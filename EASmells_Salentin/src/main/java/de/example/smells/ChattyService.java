package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;
import java.util.stream.Collectors;

import static de.example.smells.Constants.MAX_CHATTY_SERVICE_RELATIONS;

public class ChattyService extends Detector {

    public ChattyService() {
        super("Chatty Service");
    }

    public List<EASmell> detect() {
        List<ElementType> serviceElements = model.getElements().stream().filter(e ->
                e.getClass().getSimpleName().contains("Service")).collect(Collectors.toList());
        for (ElementType serviceElement : serviceElements) {
            int relationCount = 0;
            for (RelationshipType relationship : model.getRelationships()) {
                if (model.isNotStructural(relationship)) {
                    ElementType source = (ElementType) relationship.getSource();
                    ElementType target = (ElementType) relationship.getTarget();
                    if (serviceElements.contains(source) && serviceElements.contains(target)
                            && (serviceElement.equals(source) || serviceElement.equals(target))) {
                        relationCount++;
                    }
                }
            }
            if (relationCount > MAX_CHATTY_SERVICE_RELATIONS) {
                addToSmells(new EASmell(getSmellName(), serviceElement, " with " + relationCount + " related services"));
            }
        }
        return result;
    }
}
