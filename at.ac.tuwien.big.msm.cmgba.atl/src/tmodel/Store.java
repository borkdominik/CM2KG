/**
 */
package tmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.Store#getBooks <em>Books</em>}</li>
 *   <li>{@link tmodel.Store#getName <em>Name</em>}</li>
 *   <li>{@link tmodel.Store#getWorkers <em>Workers</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getStore()
 * @model
 * @generated
 */
public interface Store extends EObject {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.Book}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getStore_Books()
	 * @model containment="true"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tmodel.TmodelPackage#getStore_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tmodel.Store#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Workers</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.Worker}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workers</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getStore_Workers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Worker> getWorkers();

} // Store
