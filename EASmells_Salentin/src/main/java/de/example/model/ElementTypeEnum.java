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
 * <p>Java-Klasse für ElementTypeEnum.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ElementTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="BusinessActor"/>
 *     &lt;enumeration value="BusinessRole"/>
 *     &lt;enumeration value="BusinessCollaboration"/>
 *     &lt;enumeration value="BusinessInterface"/>
 *     &lt;enumeration value="BusinessProcess"/>
 *     &lt;enumeration value="BusinessFunction"/>
 *     &lt;enumeration value="BusinessInteraction"/>
 *     &lt;enumeration value="BusinessEvent"/>
 *     &lt;enumeration value="BusinessService"/>
 *     &lt;enumeration value="BusinessObject"/>
 *     &lt;enumeration value="Contract"/>
 *     &lt;enumeration value="Representation"/>
 *     &lt;enumeration value="Product"/>
 *     &lt;enumeration value="ApplicationComponent"/>
 *     &lt;enumeration value="ApplicationCollaboration"/>
 *     &lt;enumeration value="ApplicationInterface"/>
 *     &lt;enumeration value="ApplicationFunction"/>
 *     &lt;enumeration value="ApplicationInteraction"/>
 *     &lt;enumeration value="ApplicationProcess"/>
 *     &lt;enumeration value="ApplicationEvent"/>
 *     &lt;enumeration value="ApplicationService"/>
 *     &lt;enumeration value="DataObject"/>
 *     &lt;enumeration value="Node"/>
 *     &lt;enumeration value="Device"/>
 *     &lt;enumeration value="SystemSoftware"/>
 *     &lt;enumeration value="TechnologyCollaboration"/>
 *     &lt;enumeration value="TechnologyInterface"/>
 *     &lt;enumeration value="Path"/>
 *     &lt;enumeration value="CommunicationNetwork"/>
 *     &lt;enumeration value="TechnologyFunction"/>
 *     &lt;enumeration value="TechnologyProcess"/>
 *     &lt;enumeration value="TechnologyInteraction"/>
 *     &lt;enumeration value="TechnologyEvent"/>
 *     &lt;enumeration value="TechnologyService"/>
 *     &lt;enumeration value="Artifact"/>
 *     &lt;enumeration value="Equipment"/>
 *     &lt;enumeration value="Facility"/>
 *     &lt;enumeration value="DistributionNetwork"/>
 *     &lt;enumeration value="Material"/>
 *     &lt;enumeration value="Stakeholder"/>
 *     &lt;enumeration value="Driver"/>
 *     &lt;enumeration value="Assessment"/>
 *     &lt;enumeration value="Goal"/>
 *     &lt;enumeration value="Outcome"/>
 *     &lt;enumeration value="Principle"/>
 *     &lt;enumeration value="Requirement"/>
 *     &lt;enumeration value="Constraint"/>
 *     &lt;enumeration value="Meaning"/>
 *     &lt;enumeration value="Value"/>
 *     &lt;enumeration value="Resource"/>
 *     &lt;enumeration value="Capability"/>
 *     &lt;enumeration value="CourseOfAction"/>
 *     &lt;enumeration value="WorkPackage"/>
 *     &lt;enumeration value="Deliverable"/>
 *     &lt;enumeration value="ImplementationEvent"/>
 *     &lt;enumeration value="Plateau"/>
 *     &lt;enumeration value="Gap"/>
 *     &lt;enumeration value="Grouping"/>
 *     &lt;enumeration value="Location"/>
 *     &lt;enumeration value="AndJunction"/>
 *     &lt;enumeration value="OrJunction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ElementTypeEnum")
@XmlEnum
public enum ElementTypeEnum {

    @XmlEnumValue("BusinessActor")
    BUSINESS_ACTOR("BusinessActor"),
    @XmlEnumValue("BusinessRole")
    BUSINESS_ROLE("BusinessRole"),
    @XmlEnumValue("BusinessCollaboration")
    BUSINESS_COLLABORATION("BusinessCollaboration"),
    @XmlEnumValue("BusinessInterface")
    BUSINESS_INTERFACE("BusinessInterface"),
    @XmlEnumValue("BusinessProcess")
    BUSINESS_PROCESS("BusinessProcess"),
    @XmlEnumValue("BusinessFunction")
    BUSINESS_FUNCTION("BusinessFunction"),
    @XmlEnumValue("BusinessInteraction")
    BUSINESS_INTERACTION("BusinessInteraction"),
    @XmlEnumValue("BusinessEvent")
    BUSINESS_EVENT("BusinessEvent"),
    @XmlEnumValue("BusinessService")
    BUSINESS_SERVICE("BusinessService"),
    @XmlEnumValue("BusinessObject")
    BUSINESS_OBJECT("BusinessObject"),
    @XmlEnumValue("Contract")
    CONTRACT("Contract"),
    @XmlEnumValue("Representation")
    REPRESENTATION("Representation"),
    @XmlEnumValue("Product")
    PRODUCT("Product"),
    @XmlEnumValue("ApplicationComponent")
    APPLICATION_COMPONENT("ApplicationComponent"),
    @XmlEnumValue("ApplicationCollaboration")
    APPLICATION_COLLABORATION("ApplicationCollaboration"),
    @XmlEnumValue("ApplicationInterface")
    APPLICATION_INTERFACE("ApplicationInterface"),
    @XmlEnumValue("ApplicationFunction")
    APPLICATION_FUNCTION("ApplicationFunction"),
    @XmlEnumValue("ApplicationInteraction")
    APPLICATION_INTERACTION("ApplicationInteraction"),
    @XmlEnumValue("ApplicationProcess")
    APPLICATION_PROCESS("ApplicationProcess"),
    @XmlEnumValue("ApplicationEvent")
    APPLICATION_EVENT("ApplicationEvent"),
    @XmlEnumValue("ApplicationService")
    APPLICATION_SERVICE("ApplicationService"),
    @XmlEnumValue("DataObject")
    DATA_OBJECT("DataObject"),
    @XmlEnumValue("Node")
    NODE("Node"),
    @XmlEnumValue("Device")
    DEVICE("Device"),
    @XmlEnumValue("SystemSoftware")
    SYSTEM_SOFTWARE("SystemSoftware"),
    @XmlEnumValue("TechnologyCollaboration")
    TECHNOLOGY_COLLABORATION("TechnologyCollaboration"),
    @XmlEnumValue("TechnologyInterface")
    TECHNOLOGY_INTERFACE("TechnologyInterface"),
    @XmlEnumValue("Path")
    PATH("Path"),
    @XmlEnumValue("CommunicationNetwork")
    COMMUNICATION_NETWORK("CommunicationNetwork"),
    @XmlEnumValue("TechnologyFunction")
    TECHNOLOGY_FUNCTION("TechnologyFunction"),
    @XmlEnumValue("TechnologyProcess")
    TECHNOLOGY_PROCESS("TechnologyProcess"),
    @XmlEnumValue("TechnologyInteraction")
    TECHNOLOGY_INTERACTION("TechnologyInteraction"),
    @XmlEnumValue("TechnologyEvent")
    TECHNOLOGY_EVENT("TechnologyEvent"),
    @XmlEnumValue("TechnologyService")
    TECHNOLOGY_SERVICE("TechnologyService"),
    @XmlEnumValue("Artifact")
    ARTIFACT("Artifact"),
    @XmlEnumValue("Equipment")
    EQUIPMENT("Equipment"),
    @XmlEnumValue("Facility")
    FACILITY("Facility"),
    @XmlEnumValue("DistributionNetwork")
    DISTRIBUTION_NETWORK("DistributionNetwork"),
    @XmlEnumValue("Material")
    MATERIAL("Material"),
    @XmlEnumValue("Stakeholder")
    STAKEHOLDER("Stakeholder"),
    @XmlEnumValue("Driver")
    DRIVER("Driver"),
    @XmlEnumValue("Assessment")
    ASSESSMENT("Assessment"),
    @XmlEnumValue("Goal")
    GOAL("Goal"),
    @XmlEnumValue("Outcome")
    OUTCOME("Outcome"),
    @XmlEnumValue("Principle")
    PRINCIPLE("Principle"),
    @XmlEnumValue("Requirement")
    REQUIREMENT("Requirement"),
    @XmlEnumValue("Constraint")
    CONSTRAINT("Constraint"),
    @XmlEnumValue("Meaning")
    MEANING("Meaning"),
    @XmlEnumValue("Value")
    VALUE("Value"),
    @XmlEnumValue("Resource")
    RESOURCE("Resource"),
    @XmlEnumValue("Capability")
    CAPABILITY("Capability"),
    @XmlEnumValue("CourseOfAction")
    COURSE_OF_ACTION("CourseOfAction"),
    @XmlEnumValue("WorkPackage")
    WORK_PACKAGE("WorkPackage"),
    @XmlEnumValue("Deliverable")
    DELIVERABLE("Deliverable"),
    @XmlEnumValue("ImplementationEvent")
    IMPLEMENTATION_EVENT("ImplementationEvent"),
    @XmlEnumValue("Plateau")
    PLATEAU("Plateau"),
    @XmlEnumValue("Gap")
    GAP("Gap"),
    @XmlEnumValue("Grouping")
    GROUPING("Grouping"),
    @XmlEnumValue("Location")
    LOCATION("Location"),
    @XmlEnumValue("AndJunction")
    AND_JUNCTION("AndJunction"),
    @XmlEnumValue("OrJunction")
    OR_JUNCTION("OrJunction");
    private final String value;

    ElementTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ElementTypeEnum fromValue(String v) {
        for (ElementTypeEnum c: ElementTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
