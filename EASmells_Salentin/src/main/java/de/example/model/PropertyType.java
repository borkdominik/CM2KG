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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 A Property instance type declaring the reference to a Property definition and containing the Property value.
 *             
 * 
 * <p>Java-Klasse für PropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.opengroup.org/xsd/archimate/3.0/}LangStringType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="propertyDefinitionRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyType", propOrder = {
    "value"
})
public class PropertyType {

    @XmlElement(required = true)
    protected List<LangStringType> value;
    @XmlAttribute(name = "propertyDefinitionRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object propertyDefinitionRef;

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     * 
     * 
     */
    public List<LangStringType> getValue() {
        if (value == null) {
            value = new ArrayList<LangStringType>();
        }
        return this.value;
    }

    /**
     * Ruft den Wert der propertyDefinitionRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPropertyDefinitionRef() {
        return propertyDefinitionRef;
    }

    /**
     * Legt den Wert der propertyDefinitionRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPropertyDefinitionRef(Object value) {
        this.propertyDefinitionRef = value;
    }

}
