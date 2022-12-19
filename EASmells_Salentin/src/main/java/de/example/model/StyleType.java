//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 A Style type for a node and a connection.
 *                 It is a container for style properties such as color, font.
 *             
 * 
 * <p>Java-Klasse für StyleType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StyleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="lineColor" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBColorType" minOccurs="0"/>
 *         &lt;element name="fillColor" type="{http://www.opengroup.org/xsd/archimate/3.0/}RGBColorType" minOccurs="0"/>
 *         &lt;element name="font" type="{http://www.opengroup.org/xsd/archimate/3.0/}FontType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="lineWidth" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {

})
public class StyleType {

    protected RGBColorType lineColor;
    protected RGBColorType fillColor;
    protected FontType font;
    @XmlAttribute(name = "lineWidth")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger lineWidth;

    /**
     * Ruft den Wert der lineColor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RGBColorType }
     *     
     */
    public RGBColorType getLineColor() {
        return lineColor;
    }

    /**
     * Legt den Wert der lineColor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColorType }
     *     
     */
    public void setLineColor(RGBColorType value) {
        this.lineColor = value;
    }

    /**
     * Ruft den Wert der fillColor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RGBColorType }
     *     
     */
    public RGBColorType getFillColor() {
        return fillColor;
    }

    /**
     * Legt den Wert der fillColor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColorType }
     *     
     */
    public void setFillColor(RGBColorType value) {
        this.fillColor = value;
    }

    /**
     * Ruft den Wert der font-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FontType }
     *     
     */
    public FontType getFont() {
        return font;
    }

    /**
     * Legt den Wert der font-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FontType }
     *     
     */
    public void setFont(FontType value) {
        this.font = value;
    }

    /**
     * Ruft den Wert der lineWidth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineWidth() {
        return lineWidth;
    }

    /**
     * Legt den Wert der lineWidth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineWidth(BigInteger value) {
        this.lineWidth = value;
    }

}
