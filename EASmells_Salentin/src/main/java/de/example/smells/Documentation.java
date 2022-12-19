package de.example.smells;

import de.example.model.ElementType;
import de.example.model.PreservedLangStringType;

import java.util.List;

import static de.example.smells.Constants.MAX_DOCUMENTATION_LENGTH;

public class Documentation extends Detector {

    public Documentation() {
        super("Documentation");
    }

    public List<EASmell> detect() {
        for (ElementType element : model.getElements()) {
            for (PreservedLangStringType documentation : element.getDocumentation()) {
                if (documentation.getValue().length() > MAX_DOCUMENTATION_LENGTH) {
                    addToSmells(new EASmell(getSmellName(), element, " with a documentation of length "
                            + documentation.getValue().length()));
                    break;
                }
            }
        }
        return result;
    }
}
