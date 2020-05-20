package hu.bme.mit.sequencediagram.graphical.design;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import hu.bme.mit.sequencediagram.model.GraphicalFactory;
import hu.bme.mit.sequencediagram.model.Message;
import hu.bme.mit.sequencediagram.model.MessageContent;

public class UpdateMessageContent implements IExternalJavaAction {
	
	private final static String targetMessage = "message";
	private final static String newContents = "content";

	public UpdateMessageContent() {

	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Message toUpdate = (Message)parameters.get(targetMessage);
		//System.out.println("Message: " + toUpdate);
		String[] splitContents;
		String contents = (String)parameters.get(newContents);
		//System.out.println("Contents: " + contents);
		splitContents = contents.split("\\.");
		//System.out.println("Split: " + splitContents + ", length: " + splitContents.length);
		MessageContent messageContent = GraphicalFactory.eINSTANCE.createMessageContent();
		if(splitContents.length < 2) {	//not qualified with interface
			messageContent.setName(splitContents[0]);
		} else { //qualified with interface 
			messageContent.setInterface(splitContents[0]);
			messageContent.setName(splitContents[1]);
		}
		
		toUpdate.setContent(messageContent);
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
