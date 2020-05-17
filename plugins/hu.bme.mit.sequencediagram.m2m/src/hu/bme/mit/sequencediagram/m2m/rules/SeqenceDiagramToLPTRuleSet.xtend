package hu.bme.mit.sequencediagram.m2m.rules

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import trace.TraceRoot

class SeqenceDiagramToLPTRuleSet extends RuleSetBase{
	
	new(ViatraQueryEngine engine, IModelManipulations manipulation, TraceRoot traceRoot) {
		super(engine, manipulation, traceRoot)
	}
	
	public val isBaseInteractionRule =
		addRule(isBaseInteraction)[
			val root = 
		]
}