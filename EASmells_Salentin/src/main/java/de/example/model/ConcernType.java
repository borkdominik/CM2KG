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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 document attribute holds all the concern information.
 *             
 * 
 * <p>Java-Klasse für ConcernType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConcernType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}LabelGroup" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://www.opengroup.org/xsd/archimate/3.0/}DocumentationGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stakeholders" type="{http://www.opengroup.org/xsd/archimate/3.0/}StakeholdersType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcernType", propOrder = {
    "labelGroup",
    "documentationGroup",
    "stakeholders"
})
public class ConcernType {

    @XmlElement(name = "label", required = true)
    protected List<LangStringType> labelGroup;
    @XmlElement(name = "documentation")
    protected List<PreservedLangStringType> documentationGroup;
    protected StakeholdersType stakeholders;

    /**
     * Gets the value of the labelGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabelGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     * 
     * 
     */
    public List<LangStringType> getLabelGroup() {
        if (labelGroup == null) {
            labelGroup = new ArrayList<LangStringType>();
        }
        return this.labelGroup;
    }

    /**
     * Gets the value of the documentationGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentationGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentationGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PreservedLangStringType }
     * 
     * 
     */
    public List<PreservedLangStringType> getDocumentationGroup() {
        if (documentationGroup == null) {
            documentationGroup = new ArrayList<PreservedLangStringType>();
        }
        return this.documentationGroup;
    }

    /**
     * Ruft den Wert der stakeholders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StakeholdersType }
     *     
     */
    public StakeholdersType getStakeholders() {
        return stakeholders;
    }

    /**
     * Legt den Wert der stakeholders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StakeholdersType }
     *     
     */
    public void setStakeholders(StakeholdersType value) {
        this.stakeholders = value;
    }

}
