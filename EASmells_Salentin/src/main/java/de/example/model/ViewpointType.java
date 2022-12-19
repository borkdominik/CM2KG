//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ViewpointType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ViewpointType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 *         &lt;element name="concern" type="{http://www.opengroup.org/xsd/archimate/3.0/}ConcernType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="viewpointPurpose" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointPurposeType" minOccurs="0"/>
 *         &lt;element name="viewpointContent" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointContentType" minOccurs="0"/>
 *         &lt;element name="allowedElementType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AllowedElementTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedRelationshipType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AllowedRelationshipTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modelingNote" type="{http://www.opengroup.org/xsd/archimate/3.0/}ModelingNoteType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewpointType", propOrder = {
    "properties",
    "concern",
    "viewpointPurpose",
    "viewpointContent",
    "allowedElementType",
    "allowedRelationshipType",
    "modelingNote"
})
public class ViewpointType
    extends NamedReferenceableType
{

    protected PropertiesType properties;
    protected List<ConcernType> concern;
    @XmlList
    protected List<ViewpointPurposeEnum> viewpointPurpose;
    @XmlList
    protected List<ViewpointContentEnum> viewpointContent;
    protected List<AllowedElementTypeType> allowedElementType;
    protected List<AllowedRelationshipTypeType> allowedRelationshipType;
    protected List<ModelingNoteType> modelingNote;

    /**
     * Ruft den Wert der properties-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Legt den Wert der properties-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Gets the value of the concern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcernType }
     * 
     * 
     */
    public List<ConcernType> getConcern() {
        if (concern == null) {
            concern = new ArrayList<ConcernType>();
        }
        return this.concern;
    }

    /**
     * Gets the value of the viewpointPurpose property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewpointPurpose property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewpointPurpose().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViewpointPurposeEnum }
     * 
     * 
     */
    public List<ViewpointPurposeEnum> getViewpointPurpose() {
        if (viewpointPurpose == null) {
            viewpointPurpose = new ArrayList<ViewpointPurposeEnum>();
        }
        return this.viewpointPurpose;
    }

    /**
     * Gets the value of the viewpointContent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewpointContent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewpointContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViewpointContentEnum }
     * 
     * 
     */
    public List<ViewpointContentEnum> getViewpointContent() {
        if (viewpointContent == null) {
            viewpointContent = new ArrayList<ViewpointContentEnum>();
        }
        return this.viewpointContent;
    }

    /**
     * Gets the value of the allowedElementType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedElementType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedElementType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedElementTypeType }
     * 
     * 
     */
    public List<AllowedElementTypeType> getAllowedElementType() {
        if (allowedElementType == null) {
            allowedElementType = new ArrayList<AllowedElementTypeType>();
        }
        return this.allowedElementType;
    }

    /**
     * Gets the value of the allowedRelationshipType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedRelationshipType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedRelationshipType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowedRelationshipTypeType }
     * 
     * 
     */
    public List<AllowedRelationshipTypeType> getAllowedRelationshipType() {
        if (allowedRelationshipType == null) {
            allowedRelationshipType = new ArrayList<AllowedRelationshipTypeType>();
        }
        return this.allowedRelationshipType;
    }

    /**
     * Gets the value of the modelingNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelingNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModelingNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModelingNoteType }
     * 
     * 
     */
    public List<ModelingNoteType> getModelingNote() {
        if (modelingNote == null) {
            modelingNote = new ArrayList<ModelingNoteType>();
        }
        return this.modelingNote;
    }

}
