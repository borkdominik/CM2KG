/**
 */
package tmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.Worker#getWorkerName <em>Worker Name</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getWorker()
 * @model
 * @generated
 */
public interface Worker extends EObject {
	/**
	 * Returns the value of the '<em><b>Worker Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worker Name</em>' attribute.
	 * @see #setWorkerName(String)
	 * @see tmodel.TmodelPackage#getWorker_WorkerName()
	 * @model
	 * @generated
	 */
	String getWorkerName();

	/**
	 * Sets the value of the '{@link tmodel.Worker#getWorkerName <em>Worker Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Worker Name</em>' attribute.
	 * @see #getWorkerName()
	 * @generated
	 */
	void setWorkerName(String value);

} // Worker
