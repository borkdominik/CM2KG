/**
 */
package tmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.Book#getBookName <em>Book Name</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends EObject {
	/**
	 * Returns the value of the '<em><b>Book Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Book Name</em>' attribute.
	 * @see #setBookName(String)
	 * @see tmodel.TmodelPackage#getBook_BookName()
	 * @model
	 * @generated
	 */
	String getBookName();

	/**
	 * Sets the value of the '{@link tmodel.Book#getBookName <em>Book Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book Name</em>' attribute.
	 * @see #getBookName()
	 * @generated
	 */
	void setBookName(String value);

} // Book
