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
 * <p>Java-Klasse für ViewpointsEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewpointsEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Organization"/>
 *     &lt;enumeration value="Application Platform"/>
 *     &lt;enumeration value="Information Structure"/>
 *     &lt;enumeration value="Technology"/>
 *     &lt;enumeration value="Layered"/>
 *     &lt;enumeration value="Physical"/>
 *     &lt;enumeration value="Product"/>
 *     &lt;enumeration value="Application Usage"/>
 *     &lt;enumeration value="Technology Usage"/>
 *     &lt;enumeration value="Business Process Cooperation"/>
 *     &lt;enumeration value="Application Cooperation"/>
 *     &lt;enumeration value="Service Realization"/>
 *     &lt;enumeration value="Implementation and Deployment"/>
 *     &lt;enumeration value="Goal Realization"/>
 *     &lt;enumeration value="Goal Contribution"/>
 *     &lt;enumeration value="Principles"/>
 *     &lt;enumeration value="Requirements Realization"/>
 *     &lt;enumeration value="Motivation"/>
 *     &lt;enumeration value="Strategy"/>
 *     &lt;enumeration value="Capability Map"/>
 *     &lt;enumeration value="Outcome Realization"/>
 *     &lt;enumeration value="Resource Map"/>
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="Migration"/>
 *     &lt;enumeration value="Implementation and Migration"/>
 *     &lt;enumeration value="Stakeholder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ViewpointsEnum")
@XmlEnum
public enum ViewpointsEnum {

    @XmlEnumValue("Organization")
    ORGANIZATION("Organization"),
    @XmlEnumValue("Application Platform")
    APPLICATION_PLATFORM("Application Platform"),
    @XmlEnumValue("Information Structure")
    INFORMATION_STRUCTURE("Information Structure"),
    @XmlEnumValue("Technology")
    TECHNOLOGY("Technology"),
    @XmlEnumValue("Layered")
    LAYERED("Layered"),
    @XmlEnumValue("Physical")
    PHYSICAL("Physical"),
    @XmlEnumValue("Product")
    PRODUCT("Product"),
    @XmlEnumValue("Application Usage")
    APPLICATION_USAGE("Application Usage"),
    @XmlEnumValue("Technology Usage")
    TECHNOLOGY_USAGE("Technology Usage"),
    @XmlEnumValue("Business Process Cooperation")
    BUSINESS_PROCESS_COOPERATION("Business Process Cooperation"),
    @XmlEnumValue("Application Cooperation")
    APPLICATION_COOPERATION("Application Cooperation"),
    @XmlEnumValue("Service Realization")
    SERVICE_REALIZATION("Service Realization"),
    @XmlEnumValue("Implementation and Deployment")
    IMPLEMENTATION_AND_DEPLOYMENT("Implementation and Deployment"),
    @XmlEnumValue("Goal Realization")
    GOAL_REALIZATION("Goal Realization"),
    @XmlEnumValue("Goal Contribution")
    GOAL_CONTRIBUTION("Goal Contribution"),
    @XmlEnumValue("Principles")
    PRINCIPLES("Principles"),
    @XmlEnumValue("Requirements Realization")
    REQUIREMENTS_REALIZATION("Requirements Realization"),
    @XmlEnumValue("Motivation")
    MOTIVATION("Motivation"),
    @XmlEnumValue("Strategy")
    STRATEGY("Strategy"),
    @XmlEnumValue("Capability Map")
    CAPABILITY_MAP("Capability Map"),
    @XmlEnumValue("Outcome Realization")
    OUTCOME_REALIZATION("Outcome Realization"),
    @XmlEnumValue("Resource Map")
    RESOURCE_MAP("Resource Map"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Migration")
    MIGRATION("Migration"),
    @XmlEnumValue("Implementation and Migration")
    IMPLEMENTATION_AND_MIGRATION("Implementation and Migration"),
    @XmlEnumValue("Stakeholder")
    STAKEHOLDER("Stakeholder");
    private final String value;

    ViewpointsEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewpointsEnum fromValue(String v) {
        for (ViewpointsEnum c: ViewpointsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
