/**
 */
package tmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tmodel.TmodelPackage;
import tmodel.Worker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tmodel.impl.WorkerImpl#getWorkerName <em>Worker Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkerImpl extends MinimalEObjectImpl.Container implements Worker {
	/**
	 * The default value of the '{@link #getWorkerName() <em>Worker Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkerName()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkerName() <em>Worker Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkerName()
	 * @generated
	 * @ordered
	 */
	protected String workerName = WORKER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmodelPackage.Literals.WORKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkerName() {
		return workerName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkerName(String newWorkerName) {
		String oldWorkerName = workerName;
		workerName = newWorkerName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.WORKER__WORKER_NAME, oldWorkerName, workerName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TmodelPackage.WORKER__WORKER_NAME:
				return getWorkerName();
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
			case TmodelPackage.WORKER__WORKER_NAME:
				setWorkerName((String)newValue);
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
			case TmodelPackage.WORKER__WORKER_NAME:
				setWorkerName(WORKER_NAME_EDEFAULT);
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
			case TmodelPackage.WORKER__WORKER_NAME:
				return WORKER_NAME_EDEFAULT == null ? workerName != null : !WORKER_NAME_EDEFAULT.equals(workerName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (workerName: ");
		result.append(workerName);
		result.append(')');
		return result.toString();
	}

} //WorkerImpl
