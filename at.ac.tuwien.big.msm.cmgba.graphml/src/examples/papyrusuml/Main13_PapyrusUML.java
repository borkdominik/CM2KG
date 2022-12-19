package examples.papyrusuml;

import java.io.File;
import java.io.IOException;

import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import transformations.PapyrusUML2GraphML;

public class Main13_PapyrusUML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI,
		// ArchimatePackage.eINSTANCE);

		File modelFile = new File("PapyrusInstances/PapyrusTestModel_unutilizedAbstraction.uml");

		PapyrusUML2GraphML papyrusUML2Graphml = new PapyrusUML2GraphML(modelFile);

		papyrusUML2Graphml.convert();
		GraphML graphml = papyrusUML2Graphml.getGraphml();

		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);

		try {
			modelExporter
					.exportGraph("GraphMLXMLOutput/papyrusUML_test5_full_conversion_unutilized_abstraction.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
