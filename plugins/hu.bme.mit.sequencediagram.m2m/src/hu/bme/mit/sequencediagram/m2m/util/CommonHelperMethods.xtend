package hu.bme.mit.sequencediagram.m2m.util

import hu.bme.mit.sequencediagram.model.Interaction
import hu.bme.mit.lpt.LPTRootNode
import hu.bme.mit.sequencediagram.model.Message
import java.util.List
import hu.bme.mit.lpt.LPTUnloopedNode

class CommonHelperMethods {
	def addInOutToUnloopedTree(List<String> in, String out, LPTRootNode root){
		var LPTRootNode node = root;
		for(var i = 0; i < in.length-1; i++){
			node = node.getChildren().get(in.get(i))
			if(node === null) throw new Exception("Wrong ordering!")
		}
		var LPTUnloopedNode newNode = Trace.
	}
}