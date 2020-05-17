/**
 */
package trace;

import hu.bme.mit.lpt.LPTRootNode;

import hu.bme.mit.sequencediagram.model.Element;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link trace.Trace#getSeqelement <em>Seqelement</em>}</li>
 *   <li>{@link trace.Trace#getLptelement <em>Lptelement</em>}</li>
 * </ul>
 *
 * @see trace.TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
	/**
	 * Returns the value of the '<em><b>Seqelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seqelement</em>' reference.
	 * @see #setSeqelement(Element)
	 * @see trace.TracePackage#getTrace_Seqelement()
	 * @model
	 * @generated
	 */
	Element getSeqelement();

	/**
	 * Sets the value of the '{@link trace.Trace#getSeqelement <em>Seqelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seqelement</em>' reference.
	 * @see #getSeqelement()
	 * @generated
	 */
	void setSeqelement(Element value);

	/**
	 * Returns the value of the '<em><b>Lptelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lptelement</em>' reference.
	 * @see #setLptelement(LPTRootNode)
	 * @see trace.TracePackage#getTrace_Lptelement()
	 * @model
	 * @generated
	 */
	LPTRootNode getLptelement();

	/**
	 * Sets the value of the '{@link trace.Trace#getLptelement <em>Lptelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lptelement</em>' reference.
	 * @see #getLptelement()
	 * @generated
	 */
	void setLptelement(LPTRootNode value);

} // Trace
