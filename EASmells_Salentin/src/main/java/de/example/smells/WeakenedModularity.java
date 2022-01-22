package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;
import java.util.Set;

import static de.example.smells.Constants.MIN_INTERNAL_RELATIONS;
import static de.example.smells.Constants.MODULARITY_RATIO;

public class WeakenedModularity extends Detector {

    public WeakenedModularity() {
        super("Weakened Modularity");
    }

    public List<EASmell> detect() {
        for (ElementType element : model.getElements()) {
            Set<ElementType> cluster = model.getCluster(element);
            int internal = 0;
            int external = 0;
            for (RelationshipType relationship : model.getRelationships()) {
                ElementType target = (ElementType) relationship.getTarget();
                ElementType source = (ElementType) relationship.getSource();
                if (cluster.contains(source) && cluster.contains(target)) {
                    internal++;
                } else if (model.isNotStructural(relationship)
                        && ((cluster.contains(source) && !cluster.contains(target)) || (cluster.contains(target) && !cluster.contains(source)))) {
                    external++;
                }
            }
            double mr = (double) internal / (double) external;
            if (mr < MODULARITY_RATIO && internal > MIN_INTERNAL_RELATIONS) {
                addToSmells(new EASmell("Weakened Modularity", element, " with a modularity ratio of " + mr));
            }
        }
        return result;
    }

}
