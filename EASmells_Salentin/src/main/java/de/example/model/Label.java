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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 Node type to allow a Label in a Artifact. the "label" element holds the info for the Note.
 *             
 * 
 * <p>Java-Klasse für Label complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Label">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewNodeType">
 *       &lt;attribute name="conceptRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="xpathPart" type="{http://www.opengroup.org/xsd/archimate/3.0/}XPATH_2.0_Expression" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label")
public class Label
    extends ViewNodeType
{

    @XmlAttribute(name = "conceptRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object conceptRef;
    @XmlAttribute(name = "xpathPart")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xpathPart;

    /**
     * Ruft den Wert der conceptRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getConceptRef() {
        return conceptRef;
    }

    /**
     * Legt den Wert der conceptRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setConceptRef(Object value) {
        this.conceptRef = value;
    }

    /**
     * Ruft den Wert der xpathPart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpathPart() {
        return xpathPart;
    }

    /**
     * Legt den Wert der xpathPart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpathPart(String value) {
        this.xpathPart = value;
    }

}
