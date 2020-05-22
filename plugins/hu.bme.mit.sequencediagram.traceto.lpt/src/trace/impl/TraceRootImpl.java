/**
 */
package trace.impl;

import hu.bme.mit.lpt.LPTRootNode;

import hu.bme.mit.sequencediagram.model.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import trace.Trace;
import trace.TracePackage;
import trace.TraceRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link trace.impl.TraceRootImpl#getTraces <em>Traces</em>}</li>
 *   <li>{@link trace.impl.TraceRootImpl#getSeqRoot <em>Seq Root</em>}</li>
 *   <li>{@link trace.impl.TraceRootImpl#getLptRoot <em>Lpt Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceRootImpl extends MinimalEObjectImpl.Container implements TraceRoot {
	/**
	 * The cached value of the '{@link #getTraces() <em>Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<Trace> traces;

	/**
	 * The cached value of the '{@link #getSeqRoot() <em>Seq Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeqRoot()
	 * @generated
	 * @ordered
	 */
	protected Model seqRoot;

	/**
	 * The cached value of the '{@link #getLptRoot() <em>Lpt Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLptRoot()
	 * @generated
	 * @ordered
	 */
	protected LPTRootNode lptRoot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Trace> getTraces() {
		if (traces == null) {
			traces = new EObjectContainmentEList<Trace>(Trace.class, this, TracePackage.TRACE_ROOT__TRACES);
		}
		return traces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getSeqRoot() {
		if (seqRoot != null && seqRoot.eIsProxy()) {
			InternalEObject oldSeqRoot = (InternalEObject)seqRoot;
			seqRoot = (Model)eResolveProxy(oldSeqRoot);
			if (seqRoot != oldSeqRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TRACE_ROOT__SEQ_ROOT, oldSeqRoot, seqRoot));
			}
		}
		return seqRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetSeqRoot() {
		return seqRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeqRoot(Model newSeqRoot) {
		Model oldSeqRoot = seqRoot;
		seqRoot = newSeqRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_ROOT__SEQ_ROOT, oldSeqRoot, seqRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPTRootNode getLptRoot() {
		if (lptRoot != null && lptRoot.eIsProxy()) {
			InternalEObject oldLptRoot = (InternalEObject)lptRoot;
			lptRoot = (LPTRootNode)eResolveProxy(oldLptRoot);
			if (lptRoot != oldLptRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TRACE_ROOT__LPT_ROOT, oldLptRoot, lptRoot));
			}
		}
		return lptRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPTRootNode basicGetLptRoot() {
		return lptRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLptRoot(LPTRootNode newLptRoot) {
		LPTRootNode oldLptRoot = lptRoot;
		lptRoot = newLptRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE_ROOT__LPT_ROOT, oldLptRoot, lptRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE_ROOT__TRACES:
				return ((InternalEList<?>)getTraces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRACE_ROOT__TRACES:
				return getTraces();
			case TracePackage.TRACE_ROOT__SEQ_ROOT:
				if (resolve) return getSeqRoot();
				return basicGetSeqRoot();
			case TracePackage.TRACE_ROOT__LPT_ROOT:
				if (resolve) return getLptRoot();
				return basicGetLptRoot();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRACE_ROOT__TRACES:
				getTraces().clear();
				getTraces().addAll((Collection<? extends Trace>)newValue);
				return;
			case TracePackage.TRACE_ROOT__SEQ_ROOT:
				setSeqRoot((Model)newValue);
				return;
			case TracePackage.TRACE_ROOT__LPT_ROOT:
				setLptRoot((LPTRootNode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE_ROOT__TRACES:
				getTraces().clear();
				return;
			case TracePackage.TRACE_ROOT__SEQ_ROOT:
				setSeqRoot((Model)null);
				return;
			case TracePackage.TRACE_ROOT__LPT_ROOT:
				setLptRoot((LPTRootNode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE_ROOT__TRACES:
				return traces != null && !traces.isEmpty();
			case TracePackage.TRACE_ROOT__SEQ_ROOT:
				return seqRoot != null;
			case TracePackage.TRACE_ROOT__LPT_ROOT:
				return lptRoot != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceRootImpl
