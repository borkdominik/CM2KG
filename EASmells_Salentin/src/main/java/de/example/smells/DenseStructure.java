package de.example.smells;

import de.example.model.ElementType;
import de.example.model.RelationshipType;

import java.util.List;
import java.util.Set;

import static de.example.smells.Constants.MAX_AVG_DEGREE;

public class DenseStructure extends Detector {

    public DenseStructure() {
        super("Dense Structure");
    }

    public List<EASmell> detect() {
        overallDenseStructure();
        for (ElementType element : model.getElements()) {
            Set<ElementType> cluster = model.getCluster(element);
            double e = 0;
            for (RelationshipType relationship : model.getRelationships()) {
                ElementType target = (ElementType) relationship.getTarget();
                ElementType source = (ElementType) relationship.getSource();
                if (cluster.contains(source) && cluster.contains(target)) {
                    e++;
                }
            }
            double avgDegree = e / cluster.size();
            if (avgDegree > MAX_AVG_DEGREE) {
                addToSmells(new EASmell("Dense Structure", element, " with average degree of " + avgDegree));
            }
        }
        return result;
    }

    private void overallDenseStructure() {
        double v = model.getElements().size();
        double e = model.getRelationships().size();
        double avgDegree = e / (v/* * (v - 1)*/);
        if (avgDegree > MAX_AVG_DEGREE) {
            addToSmells(new EASmell("Overall Dense Structure", null, " with average degree of " + avgDegree));
        }
    }
}
