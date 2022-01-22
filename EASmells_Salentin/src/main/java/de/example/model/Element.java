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
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Node type to allow an Element in a Artifact.
 * 
 *                 The node's label, documentation and properties may be determined
 *                 (i.e inherited) from those in the referenced ArchiMate element. Otherwise the node's label, documentation and properties
 *                 can be provided and will be additional to (or over-ride) those contained in the referenced ArchiMate element.
 *             
 * 
 * <p>Java-Klasse für Element complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Element">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}Container">
 *       &lt;attribute name="elementRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Element")
public class Element
    extends Container
{

    @XmlAttribute(name = "elementRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object elementRef;

    /**
     * Ruft den Wert der elementRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getElementRef() {
        return elementRef;
    }

    /**
     * Legt den Wert der elementRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setElementRef(Object value) {
        this.elementRef = value;
    }

}
