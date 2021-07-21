/**
 */
package tmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tmodel.Book;
import tmodel.BookBorrow;
import tmodel.TmodelPackage;
import tmodel.Worker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book Borrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tmodel.impl.BookBorrowImpl#getIssuedBook <em>Issued Book</em>}</li>
 *   <li>{@link tmodel.impl.BookBorrowImpl#getResponsibleWorker <em>Responsible Worker</em>}</li>
 *   <li>{@link tmodel.impl.BookBorrowImpl#getDateFrom <em>Date From</em>}</li>
 *   <li>{@link tmodel.impl.BookBorrowImpl#getDateTo <em>Date To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BookBorrowImpl extends MinimalEObjectImpl.Container implements BookBorrow {
	/**
	 * The cached value of the '{@link #getIssuedBook() <em>Issued Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssuedBook()
	 * @generated
	 * @ordered
	 */
	protected Book issuedBook;

	/**
	 * The cached value of the '{@link #getResponsibleWorker() <em>Responsible Worker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibleWorker()
	 * @generated
	 * @ordered
	 */
	protected Worker responsibleWorker;

	/**
	 * The default value of the '{@link #getDateFrom() <em>Date From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateFrom()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateFrom() <em>Date From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateFrom()
	 * @generated
	 * @ordered
	 */
	protected String dateFrom = DATE_FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateTo() <em>Date To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTo()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateTo() <em>Date To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateTo()
	 * @generated
	 * @ordered
	 */
	protected String dateTo = DATE_TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookBorrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmodelPackage.Literals.BOOK_BORROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book getIssuedBook() {
		if (issuedBook != null && issuedBook.eIsProxy()) {
			InternalEObject oldIssuedBook = (InternalEObject)issuedBook;
			issuedBook = (Book)eResolveProxy(oldIssuedBook);
			if (issuedBook != oldIssuedBook) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmodelPackage.BOOK_BORROW__ISSUED_BOOK, oldIssuedBook, issuedBook));
			}
		}
		return issuedBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book basicGetIssuedBook() {
		return issuedBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssuedBook(Book newIssuedBook) {
		Book oldIssuedBook = issuedBook;
		issuedBook = newIssuedBook;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.BOOK_BORROW__ISSUED_BOOK, oldIssuedBook, issuedBook));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Worker getResponsibleWorker() {
		if (responsibleWorker != null && responsibleWorker.eIsProxy()) {
			InternalEObject oldResponsibleWorker = (InternalEObject)responsibleWorker;
			responsibleWorker = (Worker)eResolveProxy(oldResponsibleWorker);
			if (responsibleWorker != oldResponsibleWorker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER, oldResponsibleWorker, responsibleWorker));
			}
		}
		return responsibleWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Worker basicGetResponsibleWorker() {
		return responsibleWorker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibleWorker(Worker newResponsibleWorker) {
		Worker oldResponsibleWorker = responsibleWorker;
		responsibleWorker = newResponsibleWorker;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER, oldResponsibleWorker, responsibleWorker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateFrom(String newDateFrom) {
		String oldDateFrom = dateFrom;
		dateFrom = newDateFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.BOOK_BORROW__DATE_FROM, oldDateFrom, dateFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateTo(String newDateTo) {
		String oldDateTo = dateTo;
		dateTo = newDateTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.BOOK_BORROW__DATE_TO, oldDateTo, dateTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TmodelPackage.BOOK_BORROW__ISSUED_BOOK:
				if (resolve) return getIssuedBook();
				return basicGetIssuedBook();
			case TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER:
				if (resolve) return getResponsibleWorker();
				return basicGetResponsibleWorker();
			case TmodelPackage.BOOK_BORROW__DATE_FROM:
				return getDateFrom();
			case TmodelPackage.BOOK_BORROW__DATE_TO:
				return getDateTo();
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
			case TmodelPackage.BOOK_BORROW__ISSUED_BOOK:
				setIssuedBook((Book)newValue);
				return;
			case TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER:
				setResponsibleWorker((Worker)newValue);
				return;
			case TmodelPackage.BOOK_BORROW__DATE_FROM:
				setDateFrom((String)newValue);
				return;
			case TmodelPackage.BOOK_BORROW__DATE_TO:
				setDateTo((String)newValue);
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
			case TmodelPackage.BOOK_BORROW__ISSUED_BOOK:
				setIssuedBook((Book)null);
				return;
			case TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER:
				setResponsibleWorker((Worker)null);
				return;
			case TmodelPackage.BOOK_BORROW__DATE_FROM:
				setDateFrom(DATE_FROM_EDEFAULT);
				return;
			case TmodelPackage.BOOK_BORROW__DATE_TO:
				setDateTo(DATE_TO_EDEFAULT);
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
			case TmodelPackage.BOOK_BORROW__ISSUED_BOOK:
				return issuedBook != null;
			case TmodelPackage.BOOK_BORROW__RESPONSIBLE_WORKER:
				return responsibleWorker != null;
			case TmodelPackage.BOOK_BORROW__DATE_FROM:
				return DATE_FROM_EDEFAULT == null ? dateFrom != null : !DATE_FROM_EDEFAULT.equals(dateFrom);
			case TmodelPackage.BOOK_BORROW__DATE_TO:
				return DATE_TO_EDEFAULT == null ? dateTo != null : !DATE_TO_EDEFAULT.equals(dateTo);
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
		result.append(" (dateFrom: ");
		result.append(dateFrom);
		result.append(", dateTo: ");
		result.append(dateTo);
		result.append(')');
		return result.toString();
	}

} //BookBorrowImpl
