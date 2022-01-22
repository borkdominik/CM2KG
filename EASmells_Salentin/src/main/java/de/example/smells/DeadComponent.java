package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;
import java.util.Set;

public class DeadComponent extends Detector {

    public DeadComponent() {
        super("Dead Component");
    }

    public List<EASmell> detect() {
        for (ElementType element : model.getElements()) {
            detectDeadComponent(element);
        }
        return result;
    }

    private void detectDeadComponent(ElementType element) {
        Set<ElementType> cluster = model.getCluster(element);
        boolean used = false;
        for (RelationshipType relationship : model.getRelationships()) {
            ElementType target = (ElementType) relationship.getTarget();
            ElementType source = (ElementType) relationship.getSource();
            // relationship to element outside the cluster -> so it is used
            if ((cluster.contains(source) && !cluster.contains(target))
                    || (cluster.contains(target) && !cluster.contains(source))) {
                used = true;
                break;
            }
        }
        if (!used) {
            addToSmells(new EASmell(getSmellName(), element));
        }
    }

}
