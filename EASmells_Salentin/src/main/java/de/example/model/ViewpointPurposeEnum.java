//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ViewpointPurposeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewpointPurposeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Designing"/>
 *     &lt;enumeration value="Deciding"/>
 *     &lt;enumeration value="Informing"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ViewpointPurposeEnum")
@XmlEnum
public enum ViewpointPurposeEnum {

    @XmlEnumValue("Designing")
    DESIGNING("Designing"),
    @XmlEnumValue("Deciding")
    DECIDING("Deciding"),
    @XmlEnumValue("Informing")
    INFORMING("Informing");
    private final String value;

    ViewpointPurposeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewpointPurposeEnum fromValue(String v) {
        for (ViewpointPurposeEnum c: ViewpointPurposeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
