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
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 RGB Color type.
 *                 The r, g, b attributes range from 0 - 255.
 *                 The a (alpha) transparency attribute is optional. 0 = full transparency, 100 = opaque.
 *             
 * 
 * <p>Java-Klasse für RGBColorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RGBColorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="r" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 *       &lt;attribute name="g" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 *       &lt;attribute name="b" use="required" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBValueType" />
 *       &lt;attribute name="a">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RGBColorType")
public class RGBColorType {

    @XmlAttribute(name = "r", required = true)
    protected short r;
    @XmlAttribute(name = "g", required = true)
    protected short g;
    @XmlAttribute(name = "b", required = true)
    protected short b;
    @XmlAttribute(name = "a")
    protected Short a;

    /**
     * Ruft den Wert der r-Eigenschaft ab.
     * 
     */
    public short getR() {
        return r;
    }

    /**
     * Legt den Wert der r-Eigenschaft fest.
     * 
     */
    public void setR(short value) {
        this.r = value;
    }

    /**
     * Ruft den Wert der g-Eigenschaft ab.
     * 
     */
    public short getG() {
        return g;
    }

    /**
     * Legt den Wert der g-Eigenschaft fest.
     * 
     */
    public void setG(short value) {
        this.g = value;
    }

    /**
     * Ruft den Wert der b-Eigenschaft ab.
     * 
     */
    public short getB() {
        return b;
    }

    /**
     * Legt den Wert der b-Eigenschaft fest.
     * 
     */
    public void setB(short value) {
        this.b = value;
    }

    /**
     * Ruft den Wert der a-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getA() {
        return a;
    }

    /**
     * Legt den Wert der a-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setA(Short value) {
        this.a = value;
    }

}
