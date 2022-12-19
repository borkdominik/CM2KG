/**
 */
package tmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.User#getName <em>Name</em>}</li>
 *   <li>{@link tmodel.User#getBorrowedBooks <em>Borrowed Books</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tmodel.TmodelPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tmodel.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Borrowed Books</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.BookBorrow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Borrowed Books</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getUser_BorrowedBooks()
	 * @model containment="true"
	 * @generated
	 */
	EList<BookBorrow> getBorrowedBooks();

} // User
