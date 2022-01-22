package de.example.smells;

import de.example.model.ElementType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CyclicDependency extends Detector {

    public CyclicDependency() {
        super("Cyclic Dependency");
    }

    public List<EASmell> detect() {
        for (ElementType element : model.getElements()) {
            detectCyclicDependency(element);
        }
        return result;
    }

    private void detectCyclicDependency(ElementType element) {
        int currentSize = 0;
        Set<ElementType> reachableElements = new HashSet<>(model.getReferencedElementsOf(element));
        // while new elements were reached
        while (reachableElements.size() > currentSize) {
            if (reachableElements.contains(element)) {
                addToSmells(new EASmell(getSmellName(), element));
                break;
            }
            currentSize = reachableElements.size();
            reachableElements.addAll(getAdditionalElements(reachableElements));
        }
    }

    private Set<ElementType> getAdditionalElements(Set<ElementType> reachableElements) {
        Set<ElementType> additionalElements = new HashSet<>();
        for (ElementType e : reachableElements) {
            additionalElements.addAll(model.getReferencedElementsOf(e));
        }
        return additionalElements;
    }
}
