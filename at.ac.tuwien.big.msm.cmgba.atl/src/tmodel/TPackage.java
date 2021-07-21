/**
 */
package tmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tmodel.TPackage#getTclasses <em>Tclasses</em>}</li>
 *   <li>{@link tmodel.TPackage#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see tmodel.TmodelPackage#getTPackage()
 * @model
 * @generated
 */
public interface TPackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Tclasses</b></em>' containment reference list.
	 * The list contents are of type {@link tmodel.TClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tclasses</em>' containment reference list.
	 * @see tmodel.TmodelPackage#getTPackage_Tclasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<TClass> getTclasses();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tmodel.TmodelPackage#getTPackage_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tmodel.TPackage#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TPackage
