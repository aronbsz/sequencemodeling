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

class SeqenceDiagramToLPTRuleSet extends RuleSetBase{
	
	new(ViatraQueryEngine engine, IModelManipulations manipulation, TraceRoot traceRoot) {
		super(engine, manipulation, traceRoot)
	}
	/**
	 * Stores the input sequences for each interaction. 
	 * Since one interaction (through CombinedFragments) can store multiple such sequences, a List of Lists is stored.
	 */
	Map<Interaction, List<List<String>>> inSeq = new HashMap 
	
	public val isBaseInteractionRule =
		addRule(isBaseInteraction)[
			createTrace(interaction, traceRoot.lptRoot)
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
						handleCombinedFragmentEvent(interaction, currEvent as CombinedFragmentEvent)						
					}
					
					
					//skip processsed events
					i+=eventsToSkip-1 //-1, because the for already adds one.
				}
			}
							
		]
		
	//Does not keep event order unfortunately
	/*public val baseInteractionMessageEventsRule =
		addRule(baseInteractionMessageEvents)[
			handleMessage(interaction, event);
		]*/
		
	/**
	 * Handles plain messages (ones not inside combined fragments)
	 */	
	private def handleMessageEvent(Interaction interaction, MessageEvent toHandle){
		var tuple = readMessages(interaction, toHandle)
		var toTrace = tuple.key //List of Messages to trace
		var input = tuple.value.key
		var output = tuple.value.value
		//At this point, 'input' stores the concatenated input messages, 'msg' contains the output message.
		if(!this.inSeq.containsKey(interaction)){
			var l = new ArrayList<List<String>> //List of Lists
			var ll = new ArrayList<String> //Actual seq. list
			ll.add(input)
			l.add(ll)
			this.inSeq.put(interaction, l)
		}else{
			for(List<String> list: this.inSeq.get(interaction)){
				list.add(input)
				var node = addInOutToUnloopedTree(list, output, traceRoot.lptRoot);
				for(Message m : toTrace){
					createTrace(m.sourceEvent, node);
					createTrace(m.targetEvent, node);
					createTrace(m, node);
				}
			}
		}
		toTrace.size
	}
	
	private def handleCombinedFragmentEvent(Interaction interaction, CombinedFragmentEvent toHandle){
		if(toHandle instanceof OptFragment){
			handleOptCombinedFragment(interaction, toHandle as CombinedFragmentEvent)
		}else{
			throw new UnsupportedOperationException("CombinedFragment type: " + toHandle.class.name + " not supported!")
		}
	}
	
	private def handleOptCombinedFragment(Interaction interaction, CombinedFragmentEvent toHandle){
		var index = interaction.events.indexOf(toHandle);
		if(!(interaction.events.get(index+1) instanceof OperandEvent)) throw new IllegalStateException("invalid format!")
		if(interaction.events.get(index+2) instanceof CombinedFragmentEvent) return 3 //empty fragment, noprobs, fragment processed
		var message = interaction.events.get(index+2)
		if(!(message instanceof MessageEvent)) throw new IllegalStateException("invalid format!")
		
		
	}
	
	
	
	
	
	
	
}