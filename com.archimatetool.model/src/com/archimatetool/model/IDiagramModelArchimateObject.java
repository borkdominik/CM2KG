/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Model Archimate Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.archimatetool.model.IDiagramModelArchimateObject#getArchimateElement <em>Archimate Element</em>}</li>
 *   <li>{@link com.archimatetool.model.IDiagramModelArchimateObject#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.archimatetool.model.IArchimatePackage#getDiagramModelArchimateObject()
 * @model extendedMetaData="name='DiagramObject'"
 * @generated
 */
public interface IDiagramModelArchimateObject extends IDiagramModelObject, IDiagramModelContainer, IDiagramModelArchimateComponent, ITextPosition {
    /**
	 * Returns the value of the '<em><b>Archimate Element</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archimate Element</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Archimate Element</em>' reference.
	 * @see #setArchimateElement(IArchimateElement)
	 * @see com.archimatetool.model.IArchimatePackage#getDiagramModelArchimateObject_ArchimateElement()
	 * @model resolveProxies="false" volatile="true"
	 * @generated
	 */
    IArchimateElement getArchimateElement();

    /**
	 * Sets the value of the '{@link com.archimatetool.model.IDiagramModelArchimateObject#getArchimateElement <em>Archimate Element</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Archimate Element</em>' reference.
	 * @see #getArchimateElement()
	 * @generated
	 */
    void setArchimateElement(IArchimateElement value);

    /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(int)
	 * @see com.archimatetool.model.IArchimatePackage#getDiagramModelArchimateObject_Type()
	 * @model default="0"
	 * @generated
	 */
    int getType();

    /**
	 * Sets the value of the '{@link com.archimatetool.model.IDiagramModelArchimateObject#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
    void setType(int value);

    /**
     * Over-ride to return correct type
     */
    @Override
    IArchimateElement getArchimateConcept();
    
} // IDiagramModelArchimateObject
