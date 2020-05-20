package hu.bme.mit.sequencediagram.graphical.design;

import org.eclipse.emf.ecore.EObject;

import hu.bme.mit.sequencediagram.model.Message;
import hu.bme.mit.sequencediagram.model.MessageContent;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    public String createMessageLabel(Message message) {
    	MessageContent mc = message.getContent();
    	String interf = "(empty)";
    	String name = "(empty)";
    	if (mc.getInterface() != null) {
    		interf = mc.getInterface();
    	}
    	if(mc.getName() != null) {
    		name = mc.getName();
    	}
    	return interf + "." + name;
    }
}
