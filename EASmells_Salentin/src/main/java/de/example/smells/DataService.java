package de.example.smells;

import de.example.model.ElementType;

import java.util.List;
import java.util.stream.Collectors;

public class DataService extends Detector {

    public DataService() {
        super("Data Service");
    }

    public List<EASmell> detect() {
        List<ElementType> serviceElements = model.getElements().stream().filter(e
                -> e.getClass().getSimpleName().contains("Service")).collect(Collectors.toList());
        List<ElementType> dataElements = model.getElementsOfType(new String[]{"BusinessObject", "DataObject", "SystemSoftware"});
        for (ElementType serviceElement : serviceElements) {
            List<ElementType> referencedElements = model.getReferencedElementsOf(serviceElement);
            if (!referencedElements.isEmpty()) {
                boolean onlyDataReferences = true;
                for (ElementType referencedElement : referencedElements) {
                    if (!dataElements.contains(referencedElement)) {
                        onlyDataReferences = false;
                        break;
                    }
                }
                if (onlyDataReferences) {
                    addToSmells(new EASmell(getSmellName(), serviceElement));
                }
            }
        }
        return result;
    }
}
