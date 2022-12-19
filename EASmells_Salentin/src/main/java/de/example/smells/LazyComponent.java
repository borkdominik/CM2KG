package de.example.smells;

import de.example.model.ElementType;
import de.example.model.LangStringType;

import java.util.List;
import java.util.stream.Collectors;

public class LazyComponent extends Detector {

    public LazyComponent() {
        super("Lazy Component");
    }

    // detect poltergeists by name
    public List<EASmell> detect() {
        String[] lazyNames = {"controller", "manager"};
        List<ElementType> lazyElements = model.getElements().stream().filter(e -> {
            for (LangStringType name : e.getNameGroup()) {
                for (String lazyName : lazyNames) {
                    if (name.getValue().toLowerCase().contains(lazyName)) {
                        return true;
                    }
                }
            }
            return false;
        }).collect(Collectors.toList());
        for (ElementType lazyElement : lazyElements) {
            addToSmells(new EASmell(getSmellName(), lazyElement));
        }
        return result;
    }
}
