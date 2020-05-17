package hu.bme.mit.sequencediagram.m2m.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.ModelManipulationException;

import hu.bme.mit.lpt.LPTRootNode;
import trace.Trace;
import trace.TracePackage;
import trace.TraceRoot;

public class TracingHelperUtility {

	static TracePackage tracePackage = TracePackage.eINSTANCE;
	
	private IModelManipulations manipulation;
	private TraceRoot rootTrace;
	
	public TracingHelperUtility(IModelManipulations manipulation, TraceRoot rootTrace) {
		this.manipulation = manipulation;
		this.rootTrace = rootTrace;
	}

	private void logTraceOp(Trace trace, boolean insert) {
		System.out.println(
				String.format(
					"\tTRACE %s: %s <--- %s ---> %s", 
					insert? "INS" : "DEL",
					trace.getSeqelement(),
					trace,
					trace.getLptelement()
				)
		); 
	}
	
	public void createTrace(EObject seqElement,
			LPTRootNode lptElement)
			throws ModelManipulationException {
		
		Trace trace = (Trace) manipulation.createChild(rootTrace, tracePackage.getTraceRoot_Traces(), tracePackage.getTrace());
		manipulation.set(trace, tracePackage.getTrace_Seqelement(), seqElement);
		manipulation.set(trace, tracePackage.getTrace_Lptelement(), lptElement);
		logTraceOp(trace, true);
	}

	public void deleteTraceAndTarget(Trace trace) throws ModelManipulationException {
		if (trace != null) {
			logTraceOp(trace, false);
			LPTRootNode lptElement = trace.getLptelement();
			if (lptElement != null && lptElement.eResource() != null) {
				manipulation.remove(lptElement);
			}
			manipulation.remove(rootTrace, tracePackage.getTraceRoot_Traces(), trace);
		}
	}

}

