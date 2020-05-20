package hu.bme.mit.sequencediagram.graphical.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import hu.bme.mit.sequencediagram.model.Event;
import hu.bme.mit.sequencediagram.model.MessageEvent;

public class MaintainEventOrder implements IExternalJavaAction {
	private static final String eventsParam = "events"; 

	public MaintainEventOrder() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		if(parameters.get(eventsParam) != null) {
			EList<Event> events = (EList<Event>) parameters.get(eventsParam);
			contractMessages(events);
		}
	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}
	
	// Ensure that Events of the same Message come after one another, sourceEvent first
	private void contractMessages (EList<Event> events) {
		//TODO make 'safe'
		// print connections
		/*for(int i = 0; i < events.size(); ++i) {
			Event currentEvent = events.get(i);
			System.out.println("i: " + i + ", event class: " + events.get(i).getClass());
			if((currentEvent instanceof MessageEvent)) {
				System.out.println("->This:" + currentEvent);
				System.out.println("->Source: " + ((MessageEvent) currentEvent).getMessage().getSourceEvent());
				System.out.println("->Target: " + ((MessageEvent) currentEvent).getMessage().getTargetEvent());
			}
		}*/
		
		// move sources after targets
		for(int i = 0; i < events.size() - 2; ++i) {
			Event currentEvent = events.get(i);
			if((currentEvent instanceof MessageEvent) && (((MessageEvent) currentEvent).getMessage().getTargetEvent() == currentEvent)) {
				//System.out.println("Message: " + ((MessageEvent) currentEvent).getMessage().getContent().getName());
				if((((MessageEvent) currentEvent).getMessage().getSourceEvent() != events.get(i + 1))) {
					for(int j = i + 2; j < events.size(); ++j) {
						if((((MessageEvent) currentEvent).getMessage().getSourceEvent() == events.get(j))) {
							events.move(i + 1, events.get(j));
						}
					}
				}
			}
		}
		
		// swap sources and targets
		for(int i = 0; i < events.size() - 2; ++i) {
			Event currentEvent = events.get(i);
			if((currentEvent instanceof MessageEvent) && (((MessageEvent) currentEvent).getMessage().getTargetEvent() == currentEvent)) {
				if((((MessageEvent) currentEvent).getMessage().getSourceEvent() == events.get(i + 1))) {
					events.move(i, events.get(i + 1));
				}
			}
		}
	}

}
