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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Graphical connection type.
 * 
 *                 If the 'relationshipRef' attribute is present, the connection should reference an existing ArchiMate relationship.
 * 
 *                 If the connection is an ArchiMate relationship type, the connection's label, documentation and properties may be determined
 *                 (i.e inherited) from those in the referenced ArchiMate relationship. Otherwise the connection's label, documentation and properties
 *                  can be provided and will be additional to (or over-ride) those contained in the referenced ArchiMate relationship.
 *             
 * 
 * <p>Java-Klasse für ConnectionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConnectionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewConceptType">
 *       &lt;sequence>
 *         &lt;element name="sourceAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 *         &lt;element name="bendpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="targetAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="source" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectionType", propOrder = {
    "sourceAttachment",
    "bendpoint",
    "targetAttachment"
})
@XmlSeeAlso({
    Line.class,
    SourcedConnectionType.class
})
public abstract class ConnectionType
    extends ViewConceptType
{

    protected LocationType sourceAttachment;
    protected List<LocationType> bendpoint;
    protected LocationType targetAttachment;
    @XmlAttribute(name = "source")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object source;
    @XmlAttribute(name = "target")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object target;

    /**
     * Ruft den Wert der sourceAttachment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getSourceAttachment() {
        return sourceAttachment;
    }

    /**
     * Legt den Wert der sourceAttachment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setSourceAttachment(LocationType value) {
        this.sourceAttachment = value;
    }

    /**
     * Gets the value of the bendpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bendpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBendpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getBendpoint() {
        if (bendpoint == null) {
            bendpoint = new ArrayList<LocationType>();
        }
        return this.bendpoint;
    }

    /**
     * Ruft den Wert der targetAttachment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getTargetAttachment() {
        return targetAttachment;
    }

    /**
     * Legt den Wert der targetAttachment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setTargetAttachment(LocationType value) {
        this.targetAttachment = value;
    }

    /**
     * Ruft den Wert der source-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSource() {
        return source;
    }

    /**
     * Legt den Wert der source-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSource(Object value) {
        this.source = value;
    }

    /**
     * Ruft den Wert der target-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Legt den Wert der target-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTarget(Object value) {
        this.target = value;
    }

}
