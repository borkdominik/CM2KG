/**
 */
package tmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tmodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TmodelFactoryImpl extends EFactoryImpl implements TmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TmodelFactory init() {
		try {
			TmodelFactory theTmodelFactory = (TmodelFactory)EPackage.Registry.INSTANCE.getEFactory(TmodelPackage.eNS_URI);
			if (theTmodelFactory != null) {
				return theTmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TmodelPackage.STORE: return createStore();
			case TmodelPackage.BOOK: return createBook();
			case TmodelPackage.WORKER: return createWorker();
			case TmodelPackage.CITY: return createCity();
			case TmodelPackage.USER: return createUser();
			case TmodelPackage.BOOK_BORROW: return createBookBorrow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Store createStore() {
		StoreImpl store = new StoreImpl();
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book createBook() {
		BookImpl book = new BookImpl();
		return book;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Worker createWorker() {
		WorkerImpl worker = new WorkerImpl();
		return worker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public City createCity() {
		CityImpl city = new CityImpl();
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BookBorrow createBookBorrow() {
		BookBorrowImpl bookBorrow = new BookBorrowImpl();
		return bookBorrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmodelPackage getTmodelPackage() {
		return (TmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TmodelPackage getPackage() {
		return TmodelPackage.eINSTANCE;
	}

} //TmodelFactoryImpl
