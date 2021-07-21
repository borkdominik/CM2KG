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


public class Main6_ArchiEx_XMLModImp_ArchiTrans {

	public static void main(String[] args) {

        
	/* XMLExchangePlugin plug = new XMLExchangePlugin();
	 
	 if(XMLExchangePlugin.INSTANCE == null) {
		 System.out.println("error");
	 }*/
		ArchiPlugin plug = new ArchiPlugin();
		
		
		//EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
		File modelFile = new File("../ArchiModels-master/ArchiMetal/ArchiMetal_exported.xml");
		
		//exlude
		//Folder|RealizationRelationship|FlowRelationship|AggregationRelationship|AccessRelationship|SpecializationRelationship|CompositionRelationship|ServingRelationship|TriggeringRelationship|AssociationRelationship|AssignmentRelationship
		
		
        try {
        	XMLModelImporter importer = new XMLModelImporter();
            IArchimateModel model = importer.createArchiMateModel(modelFile);
            
           // Ecore2GraphML ecore2Graphml = new Ecore2GraphML(model);
            
            Archimate2GraphML archi2Graphml = new Archimate2GraphML(model);
            
            archi2Graphml.convert();
    		GraphML graphml = archi2Graphml.getGraphml();
    		
    		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
    		try {
    			modelExporter.exportGraph("GraphMLXMLOutput/output_test8_ArchisuranceXML.graphml");
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
		} catch (IOException | JDOMException | XMLModelParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Completed");
	}

}
