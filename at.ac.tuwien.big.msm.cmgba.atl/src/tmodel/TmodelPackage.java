/**
 */
package tmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tmodel.TmodelFactory
 * @model kind="package"
 * @generated
 */
public interface TmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TmodelPackage eINSTANCE = tmodel.impl.TmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link tmodel.impl.StoreImpl <em>Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.StoreImpl
	 * @see tmodel.impl.TmodelPackageImpl#getStore()
	 * @generated
	 */
	int STORE = 0;

	/**
	 * The feature id for the '<em><b>Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__BOOKS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Workers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__WORKERS = 2;

	/**
	 * The number of structural features of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tmodel.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.BookImpl
	 * @see tmodel.impl.TmodelPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__NAME = 0;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link tmodel.impl.WorkerImpl <em>Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.WorkerImpl
	 * @see tmodel.impl.TmodelPackageImpl#getWorker()
	 * @generated
	 */
	int WORKER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKER_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link tmodel.impl.CityImpl <em>City</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.CityImpl
	 * @see tmodel.impl.TmodelPackageImpl#getCity()
	 * @generated
	 */
	int CITY = 3;

	/**
	 * The feature id for the '<em><b>Stores</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITY__STORES = 0;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITY__USERS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITY__NAME = 2;

	/**
	 * The number of structural features of the '<em>City</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>City</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tmodel.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.UserImpl
	 * @see tmodel.impl.TmodelPackageImpl#getUser()
	 * @generated
	 */
	int USER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Borrowed Books</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__BORROWED_BOOKS = 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tmodel.impl.BookBorrowImpl <em>Book Borrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tmodel.impl.BookBorrowImpl
	 * @see tmodel.impl.TmodelPackageImpl#getBookBorrow()
	 * @generated
	 */
	int BOOK_BORROW = 5;

	/**
	 * The feature id for the '<em><b>Issued Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW__ISSUED_BOOK = 0;

	/**
	 * The feature id for the '<em><b>Responsible Worker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW__RESPONSIBLE_WORKER = 1;

	/**
	 * The feature id for the '<em><b>Date From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW__DATE_FROM = 2;

	/**
	 * The feature id for the '<em><b>Date To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW__DATE_TO = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW__NAME = 4;

	/**
	 * The number of structural features of the '<em>Book Borrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Book Borrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_BORROW_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tmodel.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Store</em>'.
	 * @see tmodel.Store
	 * @generated
	 */
	EClass getStore();

	/**
	 * Returns the meta object for the containment reference list '{@link tmodel.Store#getBooks <em>Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Books</em>'.
	 * @see tmodel.Store#getBooks()
	 * @see #getStore()
	 * @generated
	 */
	EReference getStore_Books();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.Store#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.Store#getName()
	 * @see #getStore()
	 * @generated
	 */
	EAttribute getStore_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link tmodel.Store#getWorkers <em>Workers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Workers</em>'.
	 * @see tmodel.Store#getWorkers()
	 * @see #getStore()
	 * @generated
	 */
	EReference getStore_Workers();

	/**
	 * Returns the meta object for class '{@link tmodel.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see tmodel.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.Book#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.Book#getName()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Name();

	/**
	 * Returns the meta object for class '{@link tmodel.Worker <em>Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Worker</em>'.
	 * @see tmodel.Worker
	 * @generated
	 */
	EClass getWorker();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.Worker#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.Worker#getName()
	 * @see #getWorker()
	 * @generated
	 */
	EAttribute getWorker_Name();

	/**
	 * Returns the meta object for class '{@link tmodel.City <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>City</em>'.
	 * @see tmodel.City
	 * @generated
	 */
	EClass getCity();

	/**
	 * Returns the meta object for the containment reference list '{@link tmodel.City#getStores <em>Stores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stores</em>'.
	 * @see tmodel.City#getStores()
	 * @see #getCity()
	 * @generated
	 */
	EReference getCity_Stores();

	/**
	 * Returns the meta object for the containment reference list '{@link tmodel.City#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see tmodel.City#getUsers()
	 * @see #getCity()
	 * @generated
	 */
	EReference getCity_Users();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.City#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.City#getName()
	 * @see #getCity()
	 * @generated
	 */
	EAttribute getCity_Name();

	/**
	 * Returns the meta object for class '{@link tmodel.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see tmodel.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link tmodel.User#getBorrowedBooks <em>Borrowed Books</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Borrowed Books</em>'.
	 * @see tmodel.User#getBorrowedBooks()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_BorrowedBooks();

	/**
	 * Returns the meta object for class '{@link tmodel.BookBorrow <em>Book Borrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book Borrow</em>'.
	 * @see tmodel.BookBorrow
	 * @generated
	 */
	EClass getBookBorrow();

	/**
	 * Returns the meta object for the reference '{@link tmodel.BookBorrow#getIssuedBook <em>Issued Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Issued Book</em>'.
	 * @see tmodel.BookBorrow#getIssuedBook()
	 * @see #getBookBorrow()
	 * @generated
	 */
	EReference getBookBorrow_IssuedBook();

	/**
	 * Returns the meta object for the reference '{@link tmodel.BookBorrow#getResponsibleWorker <em>Responsible Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsible Worker</em>'.
	 * @see tmodel.BookBorrow#getResponsibleWorker()
	 * @see #getBookBorrow()
	 * @generated
	 */
	EReference getBookBorrow_ResponsibleWorker();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.BookBorrow#getDateFrom <em>Date From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date From</em>'.
	 * @see tmodel.BookBorrow#getDateFrom()
	 * @see #getBookBorrow()
	 * @generated
	 */
	EAttribute getBookBorrow_DateFrom();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.BookBorrow#getDateTo <em>Date To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date To</em>'.
	 * @see tmodel.BookBorrow#getDateTo()
	 * @see #getBookBorrow()
	 * @generated
	 */
	EAttribute getBookBorrow_DateTo();

	/**
	 * Returns the meta object for the attribute '{@link tmodel.BookBorrow#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tmodel.BookBorrow#getName()
	 * @see #getBookBorrow()
	 * @generated
	 */
	EAttribute getBookBorrow_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TmodelFactory getTmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tmodel.impl.StoreImpl <em>Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.StoreImpl
		 * @see tmodel.impl.TmodelPackageImpl#getStore()
		 * @generated
		 */
		EClass STORE = eINSTANCE.getStore();

		/**
		 * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORE__BOOKS = eINSTANCE.getStore_Books();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORE__NAME = eINSTANCE.getStore_Name();

		/**
		 * The meta object literal for the '<em><b>Workers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORE__WORKERS = eINSTANCE.getStore_Workers();

		/**
		 * The meta object literal for the '{@link tmodel.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.BookImpl
		 * @see tmodel.impl.TmodelPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__NAME = eINSTANCE.getBook_Name();

		/**
		 * The meta object literal for the '{@link tmodel.impl.WorkerImpl <em>Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.WorkerImpl
		 * @see tmodel.impl.TmodelPackageImpl#getWorker()
		 * @generated
		 */
		EClass WORKER = eINSTANCE.getWorker();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKER__NAME = eINSTANCE.getWorker_Name();

		/**
		 * The meta object literal for the '{@link tmodel.impl.CityImpl <em>City</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.CityImpl
		 * @see tmodel.impl.TmodelPackageImpl#getCity()
		 * @generated
		 */
		EClass CITY = eINSTANCE.getCity();

		/**
		 * The meta object literal for the '<em><b>Stores</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CITY__STORES = eINSTANCE.getCity_Stores();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CITY__USERS = eINSTANCE.getCity_Users();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CITY__NAME = eINSTANCE.getCity_Name();

		/**
		 * The meta object literal for the '{@link tmodel.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.UserImpl
		 * @see tmodel.impl.TmodelPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Borrowed Books</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__BORROWED_BOOKS = eINSTANCE.getUser_BorrowedBooks();

		/**
		 * The meta object literal for the '{@link tmodel.impl.BookBorrowImpl <em>Book Borrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tmodel.impl.BookBorrowImpl
		 * @see tmodel.impl.TmodelPackageImpl#getBookBorrow()
		 * @generated
		 */
		EClass BOOK_BORROW = eINSTANCE.getBookBorrow();

		/**
		 * The meta object literal for the '<em><b>Issued Book</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK_BORROW__ISSUED_BOOK = eINSTANCE.getBookBorrow_IssuedBook();

		/**
		 * The meta object literal for the '<em><b>Responsible Worker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK_BORROW__RESPONSIBLE_WORKER = eINSTANCE.getBookBorrow_ResponsibleWorker();

		/**
		 * The meta object literal for the '<em><b>Date From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK_BORROW__DATE_FROM = eINSTANCE.getBookBorrow_DateFrom();

		/**
		 * The meta object literal for the '<em><b>Date To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK_BORROW__DATE_TO = eINSTANCE.getBookBorrow_DateTo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK_BORROW__NAME = eINSTANCE.getBookBorrow_Name();

	}

} //TmodelPackage
