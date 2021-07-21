package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;

import com.archimatetool.model.IArchimateModel;

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
		
		try {
        	XMLModelImporter importer = new XMLModelImporter();
            IArchimateModel model = importer.createArchiMateModel(modelFile);
            
            Archimate2GraphML archi2Graphml = new Archimate2GraphML(model);
            
            archi2Graphml.convert();
    		GraphML graphml = archi2Graphml.getGraphml();
    		
    		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
    		try {
    			modelExporter.exportGraph();
    			graphXML = modelExporter.getGraphXML();
    			
    			outputFile = modelExporter.saveFile(filename);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
		} catch (IOException | JDOMException | XMLModelParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public File getFile() {
		return outputFile;
	}
	
	public String getGraphXML() {
		return graphXML;
	}
}
