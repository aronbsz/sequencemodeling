package hu.bme.mit.sequencediagram.graphical.design;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import hu.bme.mit.sequencediagram.model.GraphicalFactory;
import hu.bme.mit.sequencediagram.model.Message;
import hu.bme.mit.sequencediagram.model.MessageContent;

public class UpdateMessageContent implements IExternalJavaAction {
	
	private final static String PARAM1 = "targetMessage";
	private final static String PARAM2 = "newContent";

	public UpdateMessageContent() {

	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		Message toUpdate = (Message)parameters.get(PARAM1);
		String newContent = (String)parameters.get(PARAM2);
		
		MessageContent messageContent = GraphicalFactory.eINSTANCE.createMessageContent();
		messageContent.setName(newContent);
		toUpdate.setContent(messageContent);
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
