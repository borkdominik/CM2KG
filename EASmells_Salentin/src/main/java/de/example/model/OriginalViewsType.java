//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 This is a container for all of the Views in the model.
 *             
 * 
 * <p>Java-Klasse für ViewsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ViewsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewpoints" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewpointsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "viewpoints"
})
@XmlSeeAlso({
    ViewsType.class
})
public class OriginalViewsType {

    protected ViewpointsType viewpoints;

    /**
     * Ruft den Wert der viewpoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ViewpointsType }
     *     
     */
    public ViewpointsType getViewpoints() {
        return viewpoints;
    }

    /**
     * Legt den Wert der viewpoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ViewpointsType }
     *     
     */
    public void setViewpoints(ViewpointsType value) {
        this.viewpoints = value;
    }

}
