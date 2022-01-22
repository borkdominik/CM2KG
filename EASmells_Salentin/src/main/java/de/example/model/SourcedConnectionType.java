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
 *                 Abstract Type requiring a source and target.
 *             
 * 
 * <p>Java-Klasse für SourcedConnectionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SourcedConnectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengroup.org/xsd/archimate/3.0/}ConnectionType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="style" type="{http://www.opengroup.org/xsd/archimate/3.0/}StyleType" minOccurs="0"/>
 *         &lt;element name="viewRef" type="{http://www.opengroup.org/xsd/archimate/3.0/}ReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sourceAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 *         &lt;element name="bendpoint" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="targetAttachment" type="{http://www.opengroup.org/xsd/archimate/3.0/}LocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opengroup.org/xsd/archimate/3.0/}IdentifierGroup"/>
 *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourcedConnectionType")
@XmlSeeAlso({
    Relationship.class
})
public abstract class SourcedConnectionType
    extends ConnectionType
{


}
