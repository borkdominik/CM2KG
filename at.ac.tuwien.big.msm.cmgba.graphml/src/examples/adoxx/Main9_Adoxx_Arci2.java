package examples.adoxx;

import java.io.File;
import java.io.IOException;

import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import transformations.ADOxxInstance2GraphML;

public class Main9_Adoxx_Arci2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI,
		// ArchimatePackage.eINSTANCE);

		File modelFile = new File("AdoxxInstances/ArchiV2/adoxx4_team_smajevic.xml");

		ADOxxInstance2GraphML adoxx2Graphml = new ADOxxInstance2GraphML(modelFile);

		adoxx2Graphml.convert();
		GraphML graphml = adoxx2Graphml.getGraphml();

		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);

		try {
			modelExporter.exportGraph("GraphMLXMLOutput/output_test10_AdoxxXML_ArchiExample.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
