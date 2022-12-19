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
 * <p>Java-Klasse für RelationshipConnectorEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationshipConnectorEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="AndJunction"/>
 *     &lt;enumeration value="OrJunction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelationshipConnectorEnum")
@XmlEnum
public enum RelationshipConnectorEnum {

    @XmlEnumValue("AndJunction")
    AND_JUNCTION("AndJunction"),
    @XmlEnumValue("OrJunction")
    OR_JUNCTION("OrJunction");
    private final String value;

    RelationshipConnectorEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationshipConnectorEnum fromValue(String v) {
        for (RelationshipConnectorEnum c: RelationshipConnectorEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
