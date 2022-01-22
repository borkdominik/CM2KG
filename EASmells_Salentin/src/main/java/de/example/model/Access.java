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
 * <p>Java-Klasse für Access complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Access">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipType">
 *       &lt;attribute name="accessType" type="{http://www.opengroup.org/xsd/archimate/3.0/}AccessTypeEnum" default="Access" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Access")
public class Access
    extends RelationshipType
{

    @XmlAttribute(name = "accessType")
    protected AccessTypeEnum accessType;

    /**
     * Ruft den Wert der accessType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AccessTypeEnum }
     *     
     */
    public AccessTypeEnum getAccessType() {
        if (accessType == null) {
            return AccessTypeEnum.ACCESS;
        } else {
            return accessType;
        }
    }

    /**
     * Legt den Wert der accessType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessTypeEnum }
     *     
     */
    public void setAccessType(AccessTypeEnum value) {
        this.accessType = value;
    }

}
