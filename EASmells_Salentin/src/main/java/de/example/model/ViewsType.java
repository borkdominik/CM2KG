//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ViewsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ViewsType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ViewsType">
 *       &lt;redefine>
 *         &lt;complexType name="ViewsType">
 *           &lt;complexContent>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;sequence>
 *                 &lt;element name="viewpoints" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointsType" minOccurs="0"/>
 *               &lt;/sequence>
 *             &lt;/restriction>
 *           &lt;/complexContent>
 *         &lt;/complexType>
 *       &lt;/redefine>
 *       &lt;sequence>
 *         &lt;element name="diagrams" type="{http://www.opengroup.org/xsd/archimate/3.0/}DiagramsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewsType", propOrder = {
    "diagrams"
})
public class ViewsType
    extends OriginalViewsType
{

    protected DiagramsType diagrams;

    /**
     * Ruft den Wert der diagrams-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DiagramsType }
     *     
     */
    public DiagramsType getDiagrams() {
        return diagrams;
    }

    /**
     * Legt den Wert der diagrams-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagramsType }
     *     
     */
    public void setDiagrams(DiagramsType value) {
        this.diagrams = value;
    }

}
