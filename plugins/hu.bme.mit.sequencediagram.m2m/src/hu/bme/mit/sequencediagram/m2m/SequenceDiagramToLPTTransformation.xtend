package hu.bme.mit.sequencediagram.m2m

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.rules.batch.BatchTransformationRule
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements
import org.eclipse.emf.ecore.resource.Resource
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.sequencediagram.model.Model
import hu.bme.mit.sequencediagram.m2m.rules.SeqenceDiagramToLPTRuleSet
import org.eclipse.emf.ecore.resource.ResourceSet
import hu.bme.mit.sequencediagram.m2m.queries.Queries
import trace.TracePackage
import hu.bme.mit.lpt.LptPackage
import trace.TraceRoot
import java.util.Collections
import org.eclipse.emf.common.util.URI
import java.util.List
import java.util.ArrayList
import java.util.Arrays
import hu.bme.mit.lpt.LPTUnloopedNode
import java.util.HashSet
import hu.bme.mit.lpt.LPTLoopedNode
import java.util.Set

class SequenceDiagramToLPTTransformation {
	
	/* Model */
	Model seqModel;
	private ResourceSet resSet
	
	/* Queries */
	Queries queries = Queries.instance;
	/* RuleSet */
	private SeqenceDiagramToLPTRuleSet ruleSet;
	
	/* TraceRoot */
	TraceRoot traceRoot;
	
	private TracePackage tracePackage = TracePackage.eINSTANCE
	private extension LptPackage lptPackage = LptPackage.eINSTANCE
	
    /* Transformation-related extensions */
    extension BatchTransformation transformation
    extension BatchTransformationStatements statements
    
    /* Transformation rule-related extensions */
    extension BatchTransformationRuleFactory = new BatchTransformationRuleFactory
    extension IModelManipulations manipulation

    protected ViatraQueryEngine engine

    new() {
    }
    
    def prepare(Model model) {
    	this.seqModel = model
		resSet = seqModel.eResource.resourceSet
		this.engine = ViatraQueryEngine.on(new EMFScope(resSet));
		queries.prepare(engine)
		this.manipulation = new SimpleModelManipulations(engine)
		
		val traceResource = getOrCreateResource("trace")
		val lptResource = getOrCreateResource("lpt")

		val lpt = if (lptResource.contents.head === null)
				create(lptResource, lptPackage.LPTRootNode) as LPTRootNode
			else
				lptResource.contents.head as LPTRootNode

		traceRoot = if (traceResource.contents.head === null) {
			traceRoot = create(traceResource, tracePackage.traceRoot) as TraceRoot
			traceRoot.set(tracePackage.traceRoot_SeqRoot, seqModel)
			traceRoot.set(tracePackage.traceRoot_LptRoot, lpt)
			traceRoot
		} else {
			traceResource.contents.head as TraceRoot
		}
		if(traceRoot.lptRoot === null){
			traceRoot.set(tracePackage.traceRoot_LptRoot, lpt)
		}
		if(traceRoot.seqRoot === null){
			traceRoot.set(tracePackage.traceRoot_SeqRoot, seqModel)
		}
		
		ruleSet = new SeqenceDiagramToLPTRuleSet(engine, manipulation, traceRoot)

		createTransformation
    }

    public def execute() {
		println("Starting transformation")
		for(BatchTransformationRule r : ruleSet.getRules){
			r.fireAllCurrent;
		}
		saveGenFiles()
		prettyPrintResult(traceRoot.lptRoot)
    }
    private Set<LPTLoopedNode> visited = new HashSet
    private def prettyPrintResult(LPTRootNode n){
    	if(n.children.isEmpty())return;
		System.out.println(n)
    	n.children.forEach[Entry | System.out.println("\t-> " + Entry.value + ": In: " + Entry.key + " Out: " + (Entry.value as LPTUnloopedNode).output + (Entry.value instanceof LPTLoopedNode ? " LoopTo: " + (Entry.value as LPTLoopedNode).loop : ""))]
        n.children.forEach[Entry | prettyPrintResult(Entry.value)]
        
        return;
    }
    
    private def saveGenFiles(){
    	var List<Resource> toSave = new ArrayList
    	for(var i = 0; i < 3; i++){
    		var r = resSet.getResources().get(i);
    		if(!r.URI.toString.contains("graphical")){
    			var arr = r.URI.toString.split("/")
    			var String uri = ""
    			for(var int j = 2; j < arr.length-1; j++){
    				uri += arr.get(j) + "/";
    			}
    			uri += "gen-"
    			uri += arr.get(arr.length-1)
    			var Resource resource = resSet.createResource(URI.createPlatformResourceURI(uri, true));
	    		resource.getContents().addAll(r.getContents());
	    		resource.save(Collections.EMPTY_MAP)
    		}
    	}    	
    }
    

    private def createTransformation() {
        //Create VIATRA model manipulations
        this.manipulation = new SimpleModelManipulations(engine)
        //Create VIATRA Batch transformation
        transformation = BatchTransformation.forEngine(engine).addRules(ruleSet.allRules)
        .build
        //Initialize batch transformation statements
        statements = transformation.transformationStatements
    }
    
	 

    def dispose() {
        if (transformation != null) {
            transformation.ruleEngine.dispose
        }
        transformation = null
        return
    }
    
    private def Resource getOrCreateResource(String fileExtension) {
		val resourceURI = seqModel.eResource.getURI().trimFileExtension().appendFileExtension(fileExtension);
		val resource = try {
				// try to load existing resource 
				resSet.getResource(resourceURI, true);
			} catch (RuntimeException e) {
				// loading failed, i.e. file does not exists... 
				// no problem, use the Resource, file will be created on save
				resSet.getResource(resourceURI, false);
			}
		return resource;
	}
}
