package utilities;

import java.io.File;
import java.io.IOException;

import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import transformations.ADOxxInstance2GraphML_Grouping;

public class ADOxxUtility {
	File modelFile;
	File outputFile;
	String graphXML;

	public void setFile(File file) {
		modelFile = file;
	}

	public void transform(String filename) {

		ADOxxInstance2GraphML_Grouping adoxx2Graphml = new ADOxxInstance2GraphML_Grouping(modelFile);

		adoxx2Graphml.convert();
		GraphML graphml = adoxx2Graphml.getGraphml();

		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);

		try {
			modelExporter.exportGraph();
			graphXML = modelExporter.getGraphXML();

			// if no filename is provided do not create file
			if (!filename.equals(""))
				outputFile = modelExporter.saveFile(filename);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void transform() {
		this.transform("");
	}

	public File getFile() {
		return outputFile;
	}

	public String getGraphXML() {
		return graphXML;
	}
}
