//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.07 um 01:18:33 PM CEST 
//


package de.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ModelType complex type.
 *
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ModelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}ModelType">
 *       &lt;redefine>
 *         &lt;complexType name="ModelType">
 *           &lt;complexContent>
 *             &lt;extension base="{http://www.opengroup.org/xsd/archimate/3.0/}NamedReferenceableType">
 *               &lt;sequence>
 *                 &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}PropertiesGroup"/>
 *                 &lt;element name="metadata" type="{http://www.opengroup.org/xsd/archimate/3.0/}MetadataType" minOccurs="0"/>
 *                 &lt;element name="elements" type="{http://www.opengroup.org/xsd/archimate/3.0/}ElementsType" minOccurs="0"/>
 *                 &lt;element name="relationships" type="{http://www.opengroup.org/xsd/archimate/3.0/}RelationshipsType" minOccurs="0"/>
 *                 &lt;element name="organizations" type="{http://www.opengroup.org/xsd/archimate/3.0/}OrganizationsType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;element name="propertyDefinitions" type="{http://www.opengroup.org/xsd/archimate/3.0/}PropertyDefinitionsType" minOccurs="0"/>
 *               &lt;/sequence>
 *               &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;anyAttribute namespace='##other'/>
 *             &lt;/extension>
 *           &lt;/complexContent>
 *         &lt;/complexType>
 *       &lt;/redefine>
 *       &lt;sequence>
 *         &lt;element name="views" type="{http://www.opengroup.org/xsd/archimate/3.0/}ViewsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModelType", propOrder = {
        "views"
})
@XmlRootElement(name = "model")
public class ModelType
        extends OriginalModelType {

    protected ViewsType views;

    /**
     * Ruft den Wert der views-Eigenschaft ab.
     *
     * @return possible object is
     * {@link ViewsType }
     */
    public ViewsType getViews() {
        return views;
    }

    /**
     * Legt den Wert der views-Eigenschaft fest.
     *
     * @param value allowed object is
     *              {@link ViewsType }
     */
    public void setViews(ViewsType value) {
        this.views = value;
    }

}
