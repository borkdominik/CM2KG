package de.example.smells;

import de.example.main.ModelAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestStrictLayersViolation {

    private StrictLayersViolation detector;

    @Test
    void testCentralModel() {
        ModelAdapter model = new ModelAdapter("CentralModel.xml", null);
        Detector.setModel(model);
        detector = new StrictLayersViolation();
        assertEquals(detector.detect().size(), 0);
    }

    @Test
    void testSmellExample() {
        ModelAdapter model = new ModelAdapter("SmellExample.xml", null);
        Detector.setModel(model);
        detector = new StrictLayersViolation();
        assertEquals(detector.detect().size(), 3);
    }
}
