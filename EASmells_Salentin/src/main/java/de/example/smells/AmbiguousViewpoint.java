package de.example.smells;

import de.example.model.Diagram;

import java.util.List;

public class AmbiguousViewpoint extends Detector {

    public AmbiguousViewpoint() {
        super("Ambiguous Viewpoint");
    }

    public List<EASmell> detect() {
        for (Diagram view : model.getViews()) {
            if (view.getViewpoint() == null) {
                addToSmells(new EASmell(getSmellName(), null, " at the View \"" + view.getNameGroup().get(0).getValue()
                        + "\" (" + view.getIdentifier() + ")"));
            }
        }
        return result;
    }
}
