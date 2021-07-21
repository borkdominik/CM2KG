package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;

import com.archimatetool.model.IArchimateModel;

public class PapyrusUMLUtility {
	File modelFile;
	File outputFile;
	String graphXML;

	public void setFile(File file) {
		modelFile = file;
	}

	public void transform(String filename) {

		PapyrusUML2GraphML papyrusUML2Graphml = new PapyrusUML2GraphML(modelFile);

		papyrusUML2Graphml.convert();
		GraphML graphml = papyrusUML2Graphml.getGraphml();

		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);

		try {
			modelExporter.exportGraph();
			graphXML = modelExporter.getGraphXML();

			outputFile = modelExporter.saveFile(filename);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public File getFile() {
		return outputFile;
	}

	public String getGraphXML() {
		return graphXML;
	}
}
