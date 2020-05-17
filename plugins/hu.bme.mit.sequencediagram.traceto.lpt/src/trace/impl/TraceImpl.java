/**
 */
package trace.impl;

import hu.bme.mit.lpt.LPTRootNode;

import hu.bme.mit.sequencediagram.model.Element;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import trace.Trace;
import trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link trace.impl.TraceImpl#getSeqelement <em>Seqelement</em>}</li>
 *   <li>{@link trace.impl.TraceImpl#getLptelement <em>Lptelement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceImpl extends MinimalEObjectImpl.Container implements Trace {
	/**
	 * The cached value of the '{@link #getSeqelement() <em>Seqelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeqelement()
	 * @generated
	 * @ordered
	 */
	protected Element seqelement;

	/**
	 * The cached value of the '{@link #getLptelement() <em>Lptelement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLptelement()
	 * @generated
	 * @ordered
	 */
	protected LPTRootNode lptelement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getSeqelement() {
		if (seqelement != null && seqelement.eIsProxy()) {
			InternalEObject oldSeqelement = (InternalEObject)seqelement;
			seqelement = (Element)eResolveProxy(oldSeqelement);
			if (seqelement != oldSeqelement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TRACE__SEQELEMENT, oldSeqelement, seqelement));
			}
		}
		return seqelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetSeqelement() {
		return seqelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeqelement(Element newSeqelement) {
		Element oldSeqelement = seqelement;
		seqelement = newSeqelement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__SEQELEMENT, oldSeqelement, seqelement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPTRootNode getLptelement() {
		if (lptelement != null && lptelement.eIsProxy()) {
			InternalEObject oldLptelement = (InternalEObject)lptelement;
			lptelement = (LPTRootNode)eResolveProxy(oldLptelement);
			if (lptelement != oldLptelement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TracePackage.TRACE__LPTELEMENT, oldLptelement, lptelement));
			}
		}
		return lptelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LPTRootNode basicGetLptelement() {
		return lptelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLptelement(LPTRootNode newLptelement) {
		LPTRootNode oldLptelement = lptelement;
		lptelement = newLptelement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TracePackage.TRACE__LPTELEMENT, oldLptelement, lptelement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRACE__SEQELEMENT:
				if (resolve) return getSeqelement();
				return basicGetSeqelement();
			case TracePackage.TRACE__LPTELEMENT:
				if (resolve) return getLptelement();
				return basicGetLptelement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRACE__SEQELEMENT:
				setSeqelement((Element)newValue);
				return;
			case TracePackage.TRACE__LPTELEMENT:
				setLptelement((LPTRootNode)newValue);
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
			case TracePackage.TRACE__SEQELEMENT:
				setSeqelement((Element)null);
				return;
			case TracePackage.TRACE__LPTELEMENT:
				setLptelement((LPTRootNode)null);
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
			case TracePackage.TRACE__SEQELEMENT:
				return seqelement != null;
			case TracePackage.TRACE__LPTELEMENT:
				return lptelement != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceImpl
