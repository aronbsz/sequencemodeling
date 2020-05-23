package hu.bme.mit.sequencediagram.m2m.rules

import hu.bme.mit.sequencediagram.model.MessageEvent
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import trace.TraceRoot
import static extension hu.bme.mit.sequencediagram.m2m.util.CommonHelperMethods.*
import hu.bme.mit.sequencediagram.model.Message
import java.util.List
import java.util.ArrayList
import hu.bme.mit.sequencediagram.model.Event
import java.util.HashMap
import hu.bme.mit.sequencediagram.model.Interaction
import java.util.Map
import hu.bme.mit.sequencediagram.model.CombinedFragmentEvent
import hu.bme.mit.sequencediagram.model.OptFragment
import trace.Trace
import hu.bme.mit.sequencediagram.model.OperandEvent
import hu.bme.mit.sequencediagram.model.InteractionUseEvent

class SeqenceDiagramToLPTRuleSet extends RuleSetBase{
	
	new(ViatraQueryEngine engine, IModelManipulations manipulation, TraceRoot traceRoot) {
		super(engine, manipulation, traceRoot)
	}
	/**
	 * Stores the input sequences for each interaction. 
	 * Since one interaction (through CombinedFragments) can store multiple such sequences, a List of Lists is stored.
	 */
	Map<Interaction, List<List<String>>> inSeq = new HashMap 
	
	/**
	 * Ints representing if a combined fragment is currently being processed. 
	 * If not null, then points to the subsequence in inSeq which the current operand of the fragment represents: [key,value)
	 */
	Pair<Integer, Integer> currCombinedFragmentSequences = null
	
	public val isUnmappedInteractionRule =
		addRule(isUnmappedInteraction)[
			createTrace(interaction, traceRoot.lptRoot)
			if(!this.inSeq.containsKey(interaction)){ 
				var l = new ArrayList<List<String>> //List of Lists
				var ll = new ArrayList<String> //Actual seq. list
				l.add(ll)
				this.inSeq.put(interaction, l)
			} 
			//Event list is the universal ordering
			for (var i = 0; i < interaction.getEvents().size(); i++) { 
				var Event currEvent = interaction.getEvents.get(i);
				//failsafe: if already Traced, just continue
				if(!inAnyTrace(currEvent)){ 
					var int eventsToSkip = 0;
					
					/* Handle Plain Messages */
					if(currEvent instanceof MessageEvent) { 
						eventsToSkip += handleMessageEvent(interaction, currEvent as MessageEvent)
					}
					/* Handle Combined Fragments (and their contents) */
					else if(currEvent instanceof CombinedFragmentEvent){
						eventsToSkip += handleCombinedFragmentEvent(interaction, currEvent as CombinedFragmentEvent)						
					}
					else if(currEvent instanceof InteractionUseEvent){
						if(i == interaction.getEvents().size()-2){
							eventsToSkip = 2;
						}else{
							throw new UnsupportedOperationException("InteractionUse not ending interaction!")
						}
					}
					
					//skip processsed events
					i+=eventsToSkip-1 //-1, because the for already adds one.
				}
			}
							
		]
		public val mapInteractionUseInteractionToRootRule =
		addRule(mapInteractionUseInteractionToRoot)[
			addLoop(ancestor, leaf, traceRoot.lptRoot)
		]
		
		public val mapInteractionUseInteractionToNodeRule =
		addRule(mapInteractionUseInteractionToNode)[
			if(inSeq.get(interactionUse.interaction).size() > 1) throw new IllegalArgumentException("InteractionUse should point to an interaction with no Combined Fragments!")
			
			createTrace(interactionUse, addLoop(ancestor, leaf, getLPTNodeForInput(inSeq.get(interactionUse.interaction).get(0), traceRoot.lptRoot)))
		]
		
		
	//Does not keep event order unfortunately
	/*public val baseInteractionMessageEventsRule =
		addRule(baseInteractionMessageEvents)[
			handleMessage(interaction, event);
		]*/
		
	/**
	 * Handles messages (both ones not inside combined fragments and inside combined fragments)
	 */	
	private def handleMessageEvent(Interaction interaction, MessageEvent toHandle){
		var tuple = readMessages(interaction, toHandle)
		var toTrace = tuple.key //List of Messages to trace
		var input = tuple.value.key
		var output = tuple.value.value
		//If not in combined fragment add to all sequences
		var listsToTraverse = currCombinedFragmentSequences === null ? 
			this.inSeq.get(interaction) : //Add input to all sequences if not in combined fragment
			this.inSeq.get(interaction).subList(currCombinedFragmentSequences.key, currCombinedFragmentSequences.value) //Add input only to the combined fragments operands sequence
		for(List<String> list: listsToTraverse){
			list.add(input)
			var node = addInOutToUnloopedTree(list, output, traceRoot.lptRoot, traceRoot);
			for(Message m : toTrace){
				createTrace(m.sourceEvent, node);
				createTrace(m.targetEvent, node);
				createTrace(m, node);
			}
		}
		
		toTrace.size*2
	}
	
	private def handleCombinedFragmentEvent(Interaction interaction, CombinedFragmentEvent toHandle){
		if(toHandle.combinedFragment instanceof OptFragment){
			handleOptCombinedFragment(interaction, toHandle as CombinedFragmentEvent)
		}else{
			throw new UnsupportedOperationException("CombinedFragment type: " + toHandle.class.name + " not supported!")
		}
	}
	
	private def handleOptCombinedFragment(Interaction interaction, CombinedFragmentEvent toHandle){
		//If ends here
		if(toHandle.combinedFragment.finishEvent == toHandle){ 
			this.currCombinedFragmentSequences = null;
			return 1;
		}
		//If starts here
		var index = interaction.events.indexOf(toHandle);
		if(!(interaction.events.get(index+1) instanceof OperandEvent)) throw new IllegalStateException("invalid format!")
		createTrace(toHandle, null);
		createTrace(interaction.events.get(index+1), null);
		//If this is the first event
		if(inSeq.get(interaction).get(0).isEmpty){
			this.currCombinedFragmentSequences = 0->1
		}else{
			//For all sequences, create az opt route
			var List<List<String>> optRoutes = new ArrayList
			for(List<String> list : inSeq.get(interaction)){
				var cpy = new ArrayList(list)
				optRoutes.add(cpy)
			}
			var fromIndex =  inSeq.get(interaction).size();
			for(List<String> route : optRoutes){
				inSeq.get(interaction).add(route);
			}
			this.currCombinedFragmentSequences = fromIndex -> inSeq.get(interaction).size //Flag so messages only enter these routes
		}
		return 2 //The fragment and the operand were handled
	}
	
	
	
	
	
	
	
}