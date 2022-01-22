package de.example.main;

import de.example.model.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.util.*;
import java.util.stream.Collectors;

/**
 * adapt the more complex generated model and extend the functionality
 */
public class ModelAdapter {

    private static ModelType model;

    public ModelAdapter(String xmlFile, String xsdSchema) {
        try {
            model = JAXBMarshalUnmarshal.unmarshal(xmlFile, ModelType.class, xsdSchema);
            System.out.println("Successfully loaded " + xmlFile);
        } catch (JAXBException | SAXException e) {
            System.err.println(e);
            
            //ignore the system exit 
            //System.exit(1);
        }
    }

    public ModelType getModel() {
        return model;
    }

    public List<ElementType> getElements() {
        return model.getElements().getElement();
    }

    public ElementType getElementByIdentifier(String id) {
        List<ElementType> elements = model.getElements().getElement().stream().filter(e -> e.getIdentifier().equals(id))
                .collect(Collectors.toList());
        if (elements.isEmpty()) {
            return null;
        } else {
            return elements.get(0);
        }
    }

    public List<ElementType> getElementsWithReferenceTo(ElementType target) {
        List<ElementType> res = new ArrayList<>();
        for (RelationshipType rel : getRelationships()) {
            ElementType tar = (ElementType) rel.getTarget();
            if (tar.equals(target)) {
                ElementType sour = (ElementType) rel.getSource();
                res.add(sour);
            }
        }
        return res;
    }

    public List<ElementType> getReferencedElementsOf(ElementType source) {
        List<ElementType> res = new ArrayList<>();
        for (RelationshipType rel : getRelationships()) {
            ElementType sour = (ElementType) rel.getSource();
            if (sour.equals(source)) {
                ElementType tar = (ElementType) rel.getTarget();
                res.add(tar);
            }
        }
        return res;
    }

    public List<ElementType> getReferencedElementsOf(ElementType source, String[] types) {
        List<ElementType> res = new ArrayList<>();
        for (RelationshipType rel : getRelationships()) {
            ElementType sour = (ElementType) rel.getSource();
            if (sour.equals(source)) {
                for (String type : types) {
                    if (rel.getClass().getName().equals("de.example.model." + type)) {
                        ElementType tar = (ElementType) rel.getTarget();
                        res.add(tar);
                    }
                }
            }
        }
        return res;
    }

    public List<ElementType> getElementsWithReferenceTo(ElementType target, String[] types) {
        List<ElementType> res = new ArrayList<>();
        for (RelationshipType rel : getRelationships()) {
            ElementType tar = (ElementType) rel.getTarget();
            if (tar.equals(target)) {
                for (String type : types) {
                    if (rel.getClass().getName().equals("de.example.model." + type)) {
                        ElementType sour = (ElementType) rel.getSource();
                        res.add(sour);
                    }
                }
            }
        }
        return res;
    }

    public List<PropertyDefinitionType> getPropertyDefinitions() {
        return model.getPropertyDefinitions().getPropertyDefinition();
    }

    public MetadataType getMetadata() {
        return model.getMetadata();
    }

    public List<PropertyType> getProperties() {
        return model.getProperties().getProperty();
    }

    public List<RelationshipType> getRelationships() {
        return model.getRelationships().getRelationship();
    }

    public String getVersion() {
        return model.getVersion();
    }

    public List<Object> getAny() {
        return model.getAny();
    }

    public List<PreservedLangStringType> getDocumentation() {
        return model.getDocumentation();
    }

    public String getIdentifier() {
        return model.getIdentifier();
    }

    public Map<QName, String> getOtherAttributes() {
        return model.getOtherAttributes();
    }

    public String getNameGroup() {
        StringBuilder res = new StringBuilder();
        for (LangStringType langString : model.getNameGroup()) {
            res.append(langString.getLang()).append(": ").append(langString.getValue()).append("\n");
        }
        return res.toString();
    }

    public List<ElementType> getElementsInLayer(String layer) {
        // fallback if organizations is not specified in xml: use the alternative
        if (model.getOrganizations().isEmpty()) {
            return getElementsInLayerAlternative(layer);
        } else {
            List<OrganizationType> l = model.getOrganizations().get(0).getItem().stream().filter(e ->
                    e.getLabelGroup().get(0).getValue().toLowerCase().contains(layer.toLowerCase())).collect(Collectors.toList());
            if (l.isEmpty()) {
                return new ArrayList<>();
            } else if (l.get(0).getItem().isEmpty()) {
                return new ArrayList<>();
            } else {
                l = l.get(0).getItem();
                List<ElementType> res = new ArrayList<>();
                for (OrganizationType element : l) {
                    ElementType tmp = (ElementType) element.getIdentifierRef();
                    res.add(tmp);
                }
                return res;
            }
        }
    }

    public List<ElementType> getElementsOfType(String[] types) {
        return getElements().stream().filter(e -> {
            for (String type : types) {
                if (e.getClass().getSimpleName().equals(type)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
    }

    // alternative for getElementsInLayer when organizations is not specified in xml
    public List<ElementType> getElementsInLayerAlternative(String layer) {
        String[] types;
        switch (layer) {
            case "Business":
                types = new String[]{"BusinessActor", "BusinessRole", "BusinessCollaboration", "BusinessInterface",
                        "BusinessProcess", "BusinessFunction", "BusinessInteraction", "BusinessEvent", "BusinessService",
                        "BusinessObject", "Contract", "Representation", "Product"};
                break;
            case "Application":
                types = new String[]{"ApplicationComponent", "ApplicationCollaboration", "ApplicationInterface",
                        "ApplicationFunction", "ApplicationInteraction", "ApplicationProcess", "ApplicationEvent",
                        "ApplicationService", "DataObject"};
                break;
            case "Technology":
                types = new String[]{"Node", "Device", "SystemSoftware", "TechnologyCollaboration", "TechnologyInterface", "Path",
                        "CommunicationNetwork", "TechnologyFunction", "TechnologyProcess", "TechnologyInteraction", "TechnologyEvent",
                        "TechnologyService", "Artifact", "Equipment", "Facility", "DistributionNetwork", "Material"};
                break;
            default:
                types = new String[]{};
        }
        return getElementsOfType(types);
    }

    public List<Diagram> getViews() {
        return model.getViews().getDiagrams().getView();
    }

    // a cluster is in one layer and is related with structural relations to each other
    public Set<ElementType> getCluster(ElementType element) {
        Set<ElementType> elementAsSet = new HashSet<>();
        elementAsSet.add(element);
        List<ElementType> businessElements = getElementsInLayer("Business");
        if (businessElements.contains(element)) {
            return getCluster(elementAsSet, businessElements);
        } else {
            List<ElementType> applicationElements = getElementsInLayer("Application");
            if (applicationElements.contains(element)) {
                return getCluster(elementAsSet, applicationElements);
            } else {
                List<ElementType> technologyElements = getElementsInLayer("Technology");
                if (technologyElements.contains(element)) {
                    return getCluster(elementAsSet, technologyElements);
                }
                return elementAsSet;
            }
        }
    }

    private Set<ElementType> getCluster(Set<ElementType> elements, List<ElementType> elementsInSameLayer) {
        Set<ElementType> res = new HashSet<>(elements);
        String[] structuralRelationsOut = {"Aggregation", "Realization", "Composition"};
        String[] structuralRelationsIn = {"Assignment"};
        for (ElementType element : elements) {
            Set<ElementType> children = new HashSet<>(getReferencedElementsOf(element, structuralRelationsOut));
            children.addAll(getElementsWithReferenceTo(element, structuralRelationsIn));
            children = children.stream().filter(elementsInSameLayer::contains).collect(Collectors.toSet());
            if (!children.isEmpty()) {
                res.addAll(getCluster(children, elementsInSameLayer));
            }
        }
        return res;
    }

    public boolean isNotStructural(RelationshipType relationship) {
        String type = relationship.getClass().getSimpleName();
        return !type.contains("Realization") && !type.contains("Assignment") && !type.contains("Aggregation") && !type.contains("Composition");
    }

}
