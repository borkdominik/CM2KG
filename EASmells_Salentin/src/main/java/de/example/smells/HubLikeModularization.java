package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;
import java.util.Set;

import static de.example.smells.Constants.LARGE_FAN_IN;
import static de.example.smells.Constants.LARGE_FAN_OUT;

public class HubLikeModularization extends Detector {

    public HubLikeModularization() {
        super("Hub-like Modularization");
    }

    public List<EASmell> detect() {
        for (ElementType element : model.getElements()) {
            Set<ElementType> cluster = model.getCluster(element);
            int fanOut = 0;
            int fanIn = 0;
            for (RelationshipType relationship : model.getRelationships()) {
                if (model.isNotStructural(relationship)) {
                    ElementType target = (ElementType) relationship.getTarget();
                    ElementType source = (ElementType) relationship.getSource();
                    if (cluster.contains(source) && !cluster.contains(target)) {
                        fanOut++;
                    } else if (cluster.contains(target) && !cluster.contains(source)) {
                        fanIn++;
                    }
                }
            }
            if (fanIn > LARGE_FAN_IN && fanOut > LARGE_FAN_OUT) {
                addToSmells(new EASmell("Hub-like Modularization", element, " with a total of "
                        + (fanIn + fanOut) + " relations"));
            }
        }
        return result;
    }
}
