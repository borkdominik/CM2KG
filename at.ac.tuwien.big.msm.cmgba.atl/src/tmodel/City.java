/**
 */
package tmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>City</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.City#getStores <em>Stores</em>}</li>
 *   <li>{@link tmodel.City#getUsers <em>Users</em>}</li>
 *   <li>{@link tmodel.City#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getCity()
 * @model
 * @generated
 */
public interface City extends EObject {
	/**
	 * Returns the value of the '<em><b>Stores</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.Store}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stores</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getCity_Stores()
	 * @model containment="true"
	 * @generated
	 */
	EList<Store> getStores();

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.User}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getCity_Users()
	 * @model containment="true"
	 * @generated
	 */
	EList<User> getUsers();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tmodel.TmodelPackage#getCity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tmodel.City#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // City
