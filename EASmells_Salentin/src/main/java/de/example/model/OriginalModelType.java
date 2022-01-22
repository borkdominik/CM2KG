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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This is the root model type.
 *                 It is a container for the elements, relationships, diagrams and organizations of the model.
 *             
 * 
 * <p>Java-Klasse für ModelType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 *         &lt;element name="metadata" type="{http://www.opengroup.org/xsd/archimate/3.0/}MetadataType" minOccurs="0"/>
 *         &lt;element name="elements" type="{http://www.opengroup.org/xsd/archimate/3.0/}ElementsType" minOccurs="0"/>
 *         &lt;element name="relationships" type="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipsType" minOccurs="0"/>
 *         &lt;element name="organizations" type="{http://www.opengroup.org/xsd/archimate/3.0/}OrganizationsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="propertyDefinitions" type="{http://www.opengroup.org/xsd/archimate/3.0/}PropertyDefinitionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "properties",
    "metadata",
    "elements",
    "relationships",
    "organizations",
    "propertyDefinitions"
})
@XmlSeeAlso({
    ModelType.class
})
public class OriginalModelType
    extends NamedReferenceableType
{

    protected PropertiesType properties;
    protected MetadataType metadata;
    protected ElementsType elements;
    protected RelationshipsType relationships;
    protected List<OrganizationsType> organizations;
    protected PropertyDefinitionsType propertyDefinitions;
    @XmlAttribute(name = "version")
    protected String version;

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
     * Ruft den Wert der metadata-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MetadataType }
     *     
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Legt den Wert der metadata-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     *     
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Ruft den Wert der elements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ElementsType }
     *     
     */
    public ElementsType getElements() {
        return elements;
    }

    /**
     * Legt den Wert der elements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementsType }
     *     
     */
    public void setElements(ElementsType value) {
        this.elements = value;
    }

    /**
     * Ruft den Wert der relationships-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipsType }
     *     
     */
    public RelationshipsType getRelationships() {
        return relationships;
    }

    /**
     * Legt den Wert der relationships-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipsType }
     *     
     */
    public void setRelationships(RelationshipsType value) {
        this.relationships = value;
    }

    /**
     * Gets the value of the organizations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationsType }
     * 
     * 
     */
    public List<OrganizationsType> getOrganizations() {
        if (organizations == null) {
            organizations = new ArrayList<OrganizationsType>();
        }
        return this.organizations;
    }

    /**
     * Ruft den Wert der propertyDefinitions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PropertyDefinitionsType }
     *     
     */
    public PropertyDefinitionsType getPropertyDefinitions() {
        return propertyDefinitions;
    }

    /**
     * Legt den Wert der propertyDefinitions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyDefinitionsType }
     *     
     */
    public void setPropertyDefinitions(PropertyDefinitionsType value) {
        this.propertyDefinitions = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
