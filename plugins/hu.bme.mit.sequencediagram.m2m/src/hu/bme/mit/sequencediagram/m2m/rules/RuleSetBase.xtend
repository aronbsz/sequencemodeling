package hu.bme.mit.sequencediagram.m2m.rules

import java.util.List
import java.util.function.Consumer
import org.eclipse.viatra.query.runtime.api.IPatternMatch
import org.eclipse.viatra.query.runtime.api.IQuerySpecification
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import trace.TraceRoot
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import hu.bme.mit.sequencediagram.m2m.util.TracingHelperUtility
import hu.bme.mit.sequencediagram.model.GraphicalPackage
import hu.bme.mit.sequencediagram.m2m.queries.Queries
import org.eclipse.viatra.transformation.runtime.emf.rules.BatchTransformationRuleGroup

class RuleSetBase {
	protected val ViatraQueryEngine engine
	protected val BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory	
	protected val TraceRoot traceRoot
	
	protected val List<BatchTransformationRule<?,?>> rulesInternal = newArrayList
	
	protected extension val IModelManipulations manipulation		
	protected extension val TracingHelperUtility tracingHelper
	
	protected extension val GraphicalPackage seqPackage = GraphicalPackage.eINSTANCE
	
	protected extension val Queries queries = Queries.instance

	new(ViatraQueryEngine engine, IModelManipulations manipulation, TraceRoot traceRoot) {
		this.engine = engine;
		this.manipulation = manipulation
		this.traceRoot = traceRoot
		this.tracingHelper = new TracingHelperUtility(manipulation, traceRoot)
	}
	
	def allRules() {
		new BatchTransformationRuleGroup(rulesInternal)
	}
	
	private def logExecution(IPatternMatch match, String ruleName) {
		println('''«ruleName» («match.prettyPrint»)''')
	}
	protected def <Match extends IPatternMatch, Matcher extends ViatraQueryMatcher<Match>> addRule(
		IQuerySpecification<Matcher> query, Consumer<Match> job
	) {
		val ruleName = query.simpleName + "Rule"
		val rule = ruleFactory.createRule(query)
			.name(ruleName)
			.action() [
				logExecution(ruleName)
				job.accept(it)
			].build 
		rulesInternal += rule
		rule
	}
	
		
}