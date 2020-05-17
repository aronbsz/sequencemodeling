/**
 */
package trace;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "hu.bme.mit.sequencediagram.traceto.lpt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.TraceImpl
	 * @see trace.impl.TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 0;

	/**
	 * The feature id for the '<em><b>Seqelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__SEQELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Lptelement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__LPTELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link trace.impl.TraceRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see trace.impl.TraceRootImpl
	 * @see trace.impl.TracePackageImpl#getTraceRoot()
	 * @generated
	 */
	int TRACE_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ROOT__TRACES = 0;

	/**
	 * The feature id for the '<em><b>Seq Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ROOT__SEQ_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Lpt Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ROOT__LPT_ROOT = 2;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ROOT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ROOT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference '{@link trace.Trace#getSeqelement <em>Seqelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Seqelement</em>'.
	 * @see trace.Trace#getSeqelement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Seqelement();

	/**
	 * Returns the meta object for the reference '{@link trace.Trace#getLptelement <em>Lptelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lptelement</em>'.
	 * @see trace.Trace#getLptelement()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Lptelement();

	/**
	 * Returns the meta object for class '{@link trace.TraceRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see trace.TraceRoot
	 * @generated
	 */
	EClass getTraceRoot();

	/**
	 * Returns the meta object for the reference list '{@link trace.TraceRoot#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Traces</em>'.
	 * @see trace.TraceRoot#getTraces()
	 * @see #getTraceRoot()
	 * @generated
	 */
	EReference getTraceRoot_Traces();

	/**
	 * Returns the meta object for the reference '{@link trace.TraceRoot#getSeqRoot <em>Seq Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Seq Root</em>'.
	 * @see trace.TraceRoot#getSeqRoot()
	 * @see #getTraceRoot()
	 * @generated
	 */
	EReference getTraceRoot_SeqRoot();

	/**
	 * Returns the meta object for the reference '{@link trace.TraceRoot#getLptRoot <em>Lpt Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lpt Root</em>'.
	 * @see trace.TraceRoot#getLptRoot()
	 * @see #getTraceRoot()
	 * @generated
	 */
	EReference getTraceRoot_LptRoot();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.TraceImpl
		 * @see trace.impl.TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Seqelement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__SEQELEMENT = eINSTANCE.getTrace_Seqelement();

		/**
		 * The meta object literal for the '<em><b>Lptelement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__LPTELEMENT = eINSTANCE.getTrace_Lptelement();

		/**
		 * The meta object literal for the '{@link trace.impl.TraceRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see trace.impl.TraceRootImpl
		 * @see trace.impl.TracePackageImpl#getTraceRoot()
		 * @generated
		 */
		EClass TRACE_ROOT = eINSTANCE.getTraceRoot();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ROOT__TRACES = eINSTANCE.getTraceRoot_Traces();

		/**
		 * The meta object literal for the '<em><b>Seq Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ROOT__SEQ_ROOT = eINSTANCE.getTraceRoot_SeqRoot();

		/**
		 * The meta object literal for the '<em><b>Lpt Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ROOT__LPT_ROOT = eINSTANCE.getTraceRoot_LptRoot();

	}

} //TracePackage
