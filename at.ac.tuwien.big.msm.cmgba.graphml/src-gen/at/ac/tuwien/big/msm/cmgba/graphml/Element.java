/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getDataAttributes <em>Data Attributes</em>}</li>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getId <em>Id</em>}</li>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.msm.cmgba.graphml.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Attributes</em>' containment reference list.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getElement_DataAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Data> getDataAttributes();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getElement_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Element
