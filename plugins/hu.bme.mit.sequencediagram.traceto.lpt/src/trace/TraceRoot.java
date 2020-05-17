/**
 */
package trace;

import hu.bme.mit.lpt.LPTRootNode;

import hu.bme.mit.sequencediagram.model.Model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link trace.TraceRoot#getTraces <em>Traces</em>}</li>
 *   <li>{@link trace.TraceRoot#getSeqRoot <em>Seq Root</em>}</li>
 *   <li>{@link trace.TraceRoot#getLptRoot <em>Lpt Root</em>}</li>
 * </ul>
 *
 * @see trace.TracePackage#getTraceRoot()
 * @model
 * @generated
 */
public interface TraceRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Traces</b></em>' reference list.
	 * The list contents are of type {@link trace.Trace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' reference list.
	 * @see trace.TracePackage#getTraceRoot_Traces()
	 * @model
	 * @generated
	 */
	EList<Trace> getTraces();

	/**
	 * Returns the value of the '<em><b>Seq Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seq Root</em>' reference.
	 * @see #setSeqRoot(Model)
	 * @see trace.TracePackage#getTraceRoot_SeqRoot()
	 * @model
	 * @generated
	 */
	Model getSeqRoot();

	/**
	 * Sets the value of the '{@link trace.TraceRoot#getSeqRoot <em>Seq Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seq Root</em>' reference.
	 * @see #getSeqRoot()
	 * @generated
	 */
	void setSeqRoot(Model value);

	/**
	 * Returns the value of the '<em><b>Lpt Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lpt Root</em>' reference.
	 * @see #setLptRoot(LPTRootNode)
	 * @see trace.TracePackage#getTraceRoot_LptRoot()
	 * @model
	 * @generated
	 */
	LPTRootNode getLptRoot();

	/**
	 * Sets the value of the '{@link trace.TraceRoot#getLptRoot <em>Lpt Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lpt Root</em>' reference.
	 * @see #getLptRoot()
	 * @generated
	 */
	void setLptRoot(LPTRootNode value);

} // TraceRoot
