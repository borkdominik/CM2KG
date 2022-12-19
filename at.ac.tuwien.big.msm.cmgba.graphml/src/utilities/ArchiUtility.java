package utilities;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;

import com.archimatetool.model.IArchimateModel;

import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import transformations.Archimate2GraphML;

public class ArchiUtility {

	File modelFile;
	File outputFile;
	String graphXML;

	long startTime = System.currentTimeMillis();

	long estimatedTime = System.currentTimeMillis() - startTime;

	public void setFile(File file) {
		modelFile = file;
	}

	public void transform(String filename) {
		System.out.println("ArchiUtility transform for file name: "+modelFile.getAbsolutePath());
		try {
			XMLModelImporter importer = new XMLModelImporter();
			System.out.println("XMLModelImporter loaded...");
			IArchimateModel model = importer.createArchiMateModel(modelFile);
			System.out.println("IArchimateModel loaded...");
			
			Archimate2GraphML archi2Graphml = new Archimate2GraphML(model);
			System.out.println("now converting...");
			archi2Graphml.convert();
			System.out.println("converted...");
			GraphML graphml = archi2Graphml.getGraphml();

			GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
			try {
				modelExporter.exportGraph();
				graphXML = modelExporter.getGraphXML();
				
				System.out.println("ArchiUtility transformation done: "+filename);
				// if no filename is provided do not create file
				if (!filename.equals(""))
					outputFile = modelExporter.saveFile(filename);
				System.out.println("ArchiUtility transformation saved to file: "+outputFile.getAbsolutePath());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("ArchiUtility transform IOException failed 1st catch...");
				e1.printStackTrace();
			}

		} catch (IOException | JDOMException | XMLModelParserException e) {
			// TODO Auto-generated catch block
			System.out.println("ArchiUtility transform transformation failed 2nd catch...");
			e.printStackTrace();
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
