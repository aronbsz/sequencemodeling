package hu.bme.mit.sequencediagram.m2m.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformationStatements;
import hu.bme.mit.sequencediagram.m2m.SequenceDiagramToLPTTransformation;
import hu.bme.mit.sequencediagram.model.Model;
import trace.Trace;

public class TransformHandler extends AbstractHandler implements IHandler {

    ViatraQueryEngine engine;
    SequenceDiagramToLPTTransformation transformation;

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection =
            (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

        Model model =
            (Model) selection.getFirstElement();

        if (engine == null){
            try {
                transformation = new SequenceDiagramToLPTTransformation();
                transformation.prepare(model);
            } catch (ViatraQueryException e) {
                throw new ExecutionException(e.getMessage(), e);
            }
        }
        transformation.execute();

        return null;
    }

}
