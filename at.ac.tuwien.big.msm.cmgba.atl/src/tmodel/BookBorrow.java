/**
 */
package tmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book Borrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.BookBorrow#getIssuedBook <em>Issued Book</em>}</li>
 *   <li>{@link tmodel.BookBorrow#getResponsibleWorker <em>Responsible Worker</em>}</li>
 *   <li>{@link tmodel.BookBorrow#getDateFrom <em>Date From</em>}</li>
 *   <li>{@link tmodel.BookBorrow#getDateTo <em>Date To</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getBookBorrow()
 * @model
 * @generated
 */
public interface BookBorrow extends EObject {
	/**
	 * Returns the value of the '<em><b>Issued Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issued Book</em>' reference.
	 * @see #setIssuedBook(Book)
	 * @see tmodel.TmodelPackage#getBookBorrow_IssuedBook()
	 * @model
	 * @generated
	 */
	Book getIssuedBook();

	/**
	 * Sets the value of the '{@link tmodel.BookBorrow#getIssuedBook <em>Issued Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issued Book</em>' reference.
	 * @see #getIssuedBook()
	 * @generated
	 */
	void setIssuedBook(Book value);

	/**
	 * Returns the value of the '<em><b>Responsible Worker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Responsible Worker</em>' reference.
	 * @see #setResponsibleWorker(Worker)
	 * @see tmodel.TmodelPackage#getBookBorrow_ResponsibleWorker()
	 * @model
	 * @generated
	 */
	Worker getResponsibleWorker();

	/**
	 * Sets the value of the '{@link tmodel.BookBorrow#getResponsibleWorker <em>Responsible Worker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Responsible Worker</em>' reference.
	 * @see #getResponsibleWorker()
	 * @generated
	 */
	void setResponsibleWorker(Worker value);

	/**
	 * Returns the value of the '<em><b>Date From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date From</em>' attribute.
	 * @see #setDateFrom(String)
	 * @see tmodel.TmodelPackage#getBookBorrow_DateFrom()
	 * @model
	 * @generated
	 */
	String getDateFrom();

	/**
	 * Sets the value of the '{@link tmodel.BookBorrow#getDateFrom <em>Date From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date From</em>' attribute.
	 * @see #getDateFrom()
	 * @generated
	 */
	void setDateFrom(String value);

	/**
	 * Returns the value of the '<em><b>Date To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date To</em>' attribute.
	 * @see #setDateTo(String)
	 * @see tmodel.TmodelPackage#getBookBorrow_DateTo()
	 * @model
	 * @generated
	 */
	String getDateTo();

	/**
	 * Sets the value of the '{@link tmodel.BookBorrow#getDateTo <em>Date To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date To</em>' attribute.
	 * @see #getDateTo()
	 * @generated
	 */
	void setDateTo(String value);

} // BookBorrow
