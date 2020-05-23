package hu.bme.mit.sequencediagram.m2m.util

import hu.bme.mit.lpt.LPTRootNode
import hu.bme.mit.sequencediagram.model.Message
import java.util.List
import hu.bme.mit.sequencediagram.model.MessageEvent
import hu.bme.mit.lpt.LPTUnloopedNode
import hu.bme.mit.lpt.LptFactory
import hu.bme.mit.lpt.LptPackage
import hu.bme.mit.sequencediagram.model.Event
import hu.bme.mit.sequencediagram.model.Interaction
import java.util.ArrayList
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import hu.bme.mit.lpt.LPTLoopedNode
import trace.TraceRoot

class CommonHelperMethods {
	
	static extension val LptPackage = LptPackage.eINSTANCE
	
	static def addInOutToUnloopedTree(List<String> in, String out, LPTRootNode root, TraceRoot traceRoot){
		var LPTRootNode node = root;
		for(var i = 0; i < in.length-1; i++){
			node = node.getChildren().get(in.get(i))
			if(node === null) throw new Exception("Wrong ordering!")
		}
		var LPTUnloopedNode newNode = LptFactory.eINSTANCE.createLPTUnloopedNode();
		newNode.output = out;
		if(node.children.containsKey(in.get(in.length-1))){
			if(!(node.children.get(in.get(in.length-1)) as LPTUnloopedNode).output.equals(newNode.output)) 
				throw new IllegalStateException("Conflicting outputs: Input:" + in.join + " OldOut: " + (node.children.get(in.get(in.length-1)) as LPTUnloopedNode).output + " NewOut: " + out)
			
			node.children.get(in.get(in.length-1)) //return prev node if already exists
		}else{
			node.children.put(in.get(in.length-1), newNode);
			node.eResource.getContents().add(newNode);
			newNode
		}
	}
	
	static def getLPTNodeForInput(List<String> in, LPTRootNode root){
		var LPTRootNode node = root;
		for(var i = 0; i < in.length; i++){
			node = node.getChildren().get(in.get(i))
			if(node === null) throw new Exception("Wrong ordering!")
		}
		node
	}
	
	/**
	 * Replaces Unlooped node to Looped node
	 */
	static def addLoop(LPTRootNode ancestor, LPTUnloopedNode loopFrom, LPTRootNode loopTo){
		var LPTLoopedNode newNode = LptFactory.eINSTANCE.createLPTLoopedNode()
		newNode.output = loopFrom.output
		newNode.loop = loopTo
		var input = ancestor.children.findFirst[ E | E.value == loopFrom].key
		ancestor.children.removeKey(input)
		ancestor.children.put(input, newNode)
		ancestor.eResource.getContents().add(newNode);
		//ancestor.eResource.getContents().remove(loopFrom); Would leave dangling edge :(
		newNode
	}
	
	static def findMessageFromSource(MessageEvent src, List<Message> messages){
		for(Message m : messages){
			if(m.getSourceEvent() == src){
				return m;
			}
		}
	}
	
	static def areInOutPair(Message m1, Message m2){
		if(m1.getSourceEvent().getContext().get(0) != m1.getTargetEvent().getContext().get(0) && m2.getSourceEvent().getContext().get(0) != m2.getTargetEvent().getContext().get(0) && //not reflective
			m1.getTargetEvent().getContext().get(0) == m2.getSourceEvent().getContext().get(0) // first ends where second start
		) return true;
		return false;
	}
	/**
	 * Returns message content without interface qualifiers
	 */
	static def getNonQualifiedMessageContent(Message message){
		message.content.name
	}
	/**
	 * Returns the message content with interface qualifiers
	 */
	static def getQualifiedMessageContent(Message message){
		message.content.interface + "." + message.content.name
	}
	static def getIndexOf(List<Event> list, Event elem){
		return list.indexOf(elem);
	}
	/**
	 * Reads Messages until an output is found. (Multiple inputs are concatenated, like (in1,...,inN) -> (output) so.)
	 * Returns with: (ReadMessages->(Input->Output)) 3-tuple.
	 */
	static def readMessages(Interaction interaction, MessageEvent toHandle){
		var List<Message> toTrace = new ArrayList
		var int indexOfFirst = interaction.events.indexOf(toHandle);
		var int j = 2
		var Message prev = null
		var Message msg = (interaction.events.get(indexOfFirst) as MessageEvent).getMessage()
		toTrace.add(msg)
		var String input = getQualifiedMessageContent(msg) //Add qualified content - includig interafe
		//Find all input messages, until an output is found.
		do{
			//This message is processed, create Trace for it
			if(j!= 2) input += getNonQualifiedMessageContent(msg) //Add non-qualified content, only the message
			prev = msg
			msg = (interaction.events.get(indexOfFirst+j) as MessageEvent).getMessage()
			toTrace.add(msg); //message is handled, should be put into trace
			j+=2
		}while(indexOfFirst+j < interaction.events.size() && !areInOutPair(prev, msg)) //First condition is safeguard, should not occur.
		var output = getQualifiedMessageContent(msg);
		return toTrace->(input->output);
	}
	
	
}