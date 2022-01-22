package de.example.smells;

import de.example.model.ElementType;

import java.util.List;
import java.util.stream.Collectors;

public class SharedPersistency extends Detector {

    public SharedPersistency() {
        super("Shared Persistency");
    }

    public List<EASmell> detect() {
        List<ElementType> databaseElements = model.getElements().stream().filter(e -> e.getClass().getSimpleName().equals("SystemSoftware")
                && (e.getNameGroup().get(0).getValue().contains("database") || e.getNameGroup().get(0).getValue().contains("DBMS"))).collect(Collectors.toList());
        for (ElementType databaseElement : databaseElements) {
            String[] types = {"Association", "Realization", "Assignment"};
            List<ElementType> referencedElements = model.getReferencedElementsOf(databaseElement, types);
            referencedElements.addAll(model.getElementsWithReferenceTo(databaseElement, types));
            if (referencedElements.size() > 1) {
                addToSmells(new EASmell(getSmellName(), databaseElement));
            }
        }
        return result;
    }
}
