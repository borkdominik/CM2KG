package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

import org.eclipse.emf.ecore.EPackage;
import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLExchangePlugin;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;
import com.archimatetool.editor.ArchiPlugin;
import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.impl.ArchimatePackage;
import com.archimatetool.modelimporter.ImportException;
import com.archimatetool.modelimporter.ModelImporter;


public class Main5_ArchimateExample_XMLModelImporter {

	public static void main(String[] args) {

        
	/* XMLExchangePlugin plug = new XMLExchangePlugin();
	 
	 if(XMLExchangePlugin.INSTANCE == null) {
		 System.out.println("error");
	 }*/
		ArchiPlugin plug = new ArchiPlugin();
		
		
		//EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
		File modelFile = new File("../ArchiModels-master/ArchiMetal/ArchiMetal_exported.xml");
		
		
        try {
        	XMLModelImporter importer = new XMLModelImporter();
            IArchimateModel model = importer.createArchiMateModel(modelFile);
            
            Ecore2GraphML ecore2Graphml = new Ecore2GraphML(model);
            
    		ecore2Graphml.convert();
    		GraphML graphml = ecore2Graphml.getGraphml();
    		
    		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
    		try {
    			modelExporter.exportGraph("GraphMLXMLOutput/output_test6_ArchisuranceXML.graphml");
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
		} catch (IOException | JDOMException | XMLModelParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
