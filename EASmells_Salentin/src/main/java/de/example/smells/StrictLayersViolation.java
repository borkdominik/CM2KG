package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;

public class StrictLayersViolation extends Detector {

    public StrictLayersViolation() {
        super("Strict Layers Violation");
    }

    public List<EASmell> detect() {
        List<ElementType> businessElements = model.getElementsInLayer("Business");
        List<ElementType> technologyElements = model.getElementsInLayer("Technology");
        if (!businessElements.isEmpty() && !technologyElements.isEmpty()) {
            for (RelationshipType relationship : model.getRelationships()) {
                ElementType source = (ElementType) relationship.getSource();
                ElementType target = (ElementType) relationship.getTarget();
                if ((businessElements.contains(source) && technologyElements.contains(target) ||
                        (businessElements.contains(target) && technologyElements.contains(source)))) {
                    addToSmells(new EASmell(getSmellName(), source, " with the " + target.getClass().getSimpleName() + " \""
                            + target.getNameGroup().get(0).getValue() + "\" (" + target.getIdentifier() + ")"));
                }
            }
        }
        return result;
    }
}
