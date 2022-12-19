package de.example.smells;

import de.example.main.ModelAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A Detector is responsible for the detection of one particular smell
 */
public abstract class Detector {
    static ModelAdapter model;
    // detected smells of all different detectors
    static List<EASmell> smells;
    // detected smells of this detector [can be returned by detect()]
    List<EASmell> result;
    private String smellName;

    Detector() {
        smells = new ArrayList<>();
        result = new ArrayList<>();
    }

    Detector(String name) {
        smells = new ArrayList<>();
        smellName = name;
        result = new ArrayList<>();
    }

    public static List<EASmell> getSmells() {
        return smells;
    }

    public static void setModel(ModelAdapter m) {
        model = m;
    }

    public String getSmellName() {
        return smellName;
    }

    /**
     * Adds the smell to both smell lists
     *
     * @param smell The smell to be added
     */
    void addToSmells(EASmell smell) {
        result.add(smell);
        smells.add(smell);
    }

    /**
     * Main method of the detector that is used to detect the smell
     *
     * @return result: simply use addToSmells when a smell was detected and return the list result
     */
    abstract public List<EASmell> detect();

}
