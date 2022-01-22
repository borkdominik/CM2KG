package de.example.smells;

import de.example.model.ElementType;

public class EASmell {

    private String smellName;
    private ElementType element;
    private String context;

    EASmell(String smellName, ElementType element) {
        this.smellName = smellName;
        this.element = element;
    }

    EASmell(String smellName, ElementType element, String context) {
        this.smellName = smellName;
        this.element = element;
        this.context = context;
    }

    public String getSmellName() {
        return smellName;
    }

    public ElementType getElement() {
        return element;
    }

    public String getElementName() {
        return element.getNameGroup().get(0).getValue();
    }

    public String getContext() {
        return context;
    }

    public String toString() {
        return smellName + " detected" + ((element == null) ? "" : " at the " + element.getClass().getSimpleName() + " \""
                + getElementName() + "\" (" + element.getIdentifier() + ")") + (context == null ? "" : context);
    }
}
