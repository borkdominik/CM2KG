/**
 */
package tmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tmodel.Book;
import tmodel.Store;
import tmodel.TmodelPackage;
import tmodel.Worker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tmodel.impl.StoreImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link tmodel.impl.StoreImpl#getName <em>Name</em>}</li>
 *   <li>{@link tmodel.impl.StoreImpl#getWorkers <em>Workers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StoreImpl extends MinimalEObjectImpl.Container implements Store {
	/**
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> books;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorkers() <em>Workers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkers()
	 * @generated
	 * @ordered
	 */
	protected EList<Worker> workers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmodelPackage.Literals.STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getBooks() {
		if (books == null) {
			books = new EObjectContainmentEList<Book>(Book.class, this, TmodelPackage.STORE__BOOKS);
		}
		return books;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TmodelPackage.STORE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Worker> getWorkers() {
		if (workers == null) {
			workers = new EObjectContainmentEList<Worker>(Worker.class, this, TmodelPackage.STORE__WORKERS);
		}
		return workers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TmodelPackage.STORE__BOOKS:
				return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
			case TmodelPackage.STORE__WORKERS:
				return ((InternalEList<?>)getWorkers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TmodelPackage.STORE__BOOKS:
				return getBooks();
			case TmodelPackage.STORE__NAME:
				return getName();
			case TmodelPackage.STORE__WORKERS:
				return getWorkers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TmodelPackage.STORE__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case TmodelPackage.STORE__NAME:
				setName((String)newValue);
				return;
			case TmodelPackage.STORE__WORKERS:
				getWorkers().clear();
				getWorkers().addAll((Collection<? extends Worker>)newValue);
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
			case TmodelPackage.STORE__BOOKS:
				getBooks().clear();
				return;
			case TmodelPackage.STORE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TmodelPackage.STORE__WORKERS:
				getWorkers().clear();
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
			case TmodelPackage.STORE__BOOKS:
				return books != null && !books.isEmpty();
			case TmodelPackage.STORE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TmodelPackage.STORE__WORKERS:
				return workers != null && !workers.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //StoreImpl
