//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Container for View type.
 * 
 *                 Note that View itself is abstract so one must have a derived type. the xml example must look like
 *                 a tag name "view" with an attribute of xsi:type="Diagram", if Diagram is a derived type from ViewType.
 *             
 * 
 * <p>Java-Klasse für ViewType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ViewType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 *       &lt;/sequence>
 *       &lt;attribute name="viewpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointTypeType" />
 *       &lt;attribute name="viewpointRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewType", propOrder = {
    "properties"
})
@XmlSeeAlso({
    Diagram.class
})
public abstract class ViewType
    extends NamedReferenceableType
{

    protected PropertiesType properties;
    @XmlAttribute(name = "viewpoint")
    protected String viewpoint;
    @XmlAttribute(name = "viewpointRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object viewpointRef;

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
     * Ruft den Wert der viewpoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewpoint() {
        return viewpoint;
    }

    /**
     * Legt den Wert der viewpoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewpoint(String value) {
        this.viewpoint = value;
    }

    /**
     * Ruft den Wert der viewpointRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getViewpointRef() {
        return viewpointRef;
    }

    /**
     * Legt den Wert der viewpointRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setViewpointRef(Object value) {
        this.viewpointRef = value;
    }

}
