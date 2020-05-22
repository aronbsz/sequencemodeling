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

class CommonHelperMethods {
	
	static extension val LptPackage = LptPackage.eINSTANCE
	
	static def addInOutToUnloopedTree(List<String> in, String out, LPTRootNode root){
		var LPTRootNode node = root;
		for(var i = 0; i < in.length-1; i++){
			node = node.getChildren().get(in.get(i))
			if(node === null) throw new Exception("Wrong ordering!")
		}
		var LPTUnloopedNode newNode = LptFactory.eINSTANCE.createLPTUnloopedNode();
		newNode.output = out;
		if(node.children.containsKey(in.get(in.length-1))){
			if((node.children.get(in.get(in.length-1)) as LPTUnloopedNode).output != newNode.output) 
				throw new IllegalStateException("Conflicting outputs!")
		}else{
			node.children.put(in.get(in.length-1), newNode);
			newNode
		}
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
		var int j = 1
		var Message prev = null
		var Message msg = (interaction.events.get(indexOfFirst) as MessageEvent).getMessage()
		var String input = getQualifiedMessageContent(msg) //Add qualified content - includig interafe
		//Find all input messages, until an output is found.
		do{
			toTrace.add(msg); //message is handled, should be put into trace
			//This message is processed, create Trace for it
			if(j!= 1) input += getNonQualifiedMessageContent(msg) //Add non-qualified content, only the message
			prev = msg
			msg = (interaction.events.get(indexOfFirst+j) as MessageEvent).getMessage()
			j++
		}while(indexOfFirst+j < interaction.events.size() && !areInOutPair(prev, msg)) //First condition is safeguard, should not occur.
		var output = getQualifiedMessageContent(msg);
		return toTrace->(input->output);
	}
	
	
}