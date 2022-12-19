package de.example.main;

import de.example.smells.*;

import java.util.ArrayList;
import java.util.List;

/**
 * main class that manages the different detectors
 */
public class EASmellDetector {
    public static void main(String[] args) {
        // parsing of input xml to this ModelAdapter
        //ModelAdapter model = new ModelAdapter(args[0], args.length == 2 ? args[1] : null);
        
        //ModelAdapter model = new ModelAdapter("SmellExample.xml", "archimate3_Diagram.xsd");
    	//directoryPath + "\\" + child.getName()
        ModelAdapter model = new ModelAdapter("C:\\\\Users\\\\Muhamed Smajevic\\\\Documents\\\\GitHub\\\\CM2KGThesis\\\\Experiments\\\\EMF\\\\Archi\\\\ManyModels\\\\repo-github-archimate\\\\models\\\\OpenGroup Format\\Money.xml", null);
        
        Detector.setModel(model);

        // register detectors
        List<Detector> detectors = new ArrayList<>();
        //detectors.add(new AmbiguousViewpoint());
        //detectors.add(new ChattyService());
        //detectors.add(new CyclicDependency());
        //detectors.add(new DataService());
        //detectors.add(new DeadComponent());
        //detectors.add(new DenseStructure());
        detectors.add(new Documentation());
        //detectors.add(new Duplication());
        //detectors.add(new HubLikeModularization());
        //detectors.add(new LazyComponent());
        //detectors.add(new MessageChain());
        //detectors.add(new SharedPersistency());
        //detectors.add(new StrictLayersViolation());
        //detectors.add(new WeakenedModularity());

        System.out.print("\n");
        long startTotalTime = System.nanoTime();
        for (Detector detector : detectors) {
            System.out.println("Start detection of " + detector.getSmellName() + " ...");
            long startTime = System.nanoTime();
            long startMemory = calculateMemoryConsumption();

            // detect each smell
            printSmells(detector.detect());

            String time = calculateTimeConsumption(startTime);
            String memory = formatMemoryConsumption(calculateMemoryConsumption() - startMemory);
            System.out.println("Finished detection of " + detector.getSmellName() + " in " + time + " (" + memory + ")\n");
        }

        // print total result
        System.out.println("The following " + Detector.getSmells().size() + " smells were detected:");
        printSmells(Detector.getSmells());

        String totalTime = calculateTimeConsumption(startTotalTime);
        System.out.println("\nFinished detection in " + totalTime);
    }

    private static void printSmells(List<EASmell> smells) {
        for (EASmell smell : smells) {
            System.out.println(smell.toString());
        }
    }

    private static String calculateTimeConsumption(long start) {
        long time = (System.nanoTime() - start) / 1000 / 1000;
        if (time < 1000) return "" + time + " ms";
        return "" + (time / 1000.) + " s";
    }

    private static long calculateMemoryConsumption() {
        System.gc();
        System.gc();
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private static String formatMemoryConsumption(long bytes) {
        if (bytes < 0) return "0 Byte";
        if (bytes < 1024) return "" + bytes + " Byte";
        double b = bytes / 1024.;
        if (b < 1024.) return "" + b + " KByte";
        return "" + (b / 1024.) + " MByte";
    }
}
