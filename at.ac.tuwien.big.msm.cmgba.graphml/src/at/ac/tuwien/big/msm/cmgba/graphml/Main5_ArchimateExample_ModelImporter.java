package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

//import org.eclipse.emf.ecore.EPackage;

import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.impl.ArchimatePackage;
import com.archimatetool.modelimporter.ImportException;
import com.archimatetool.modelimporter.ModelImporter;




public class Main5_ArchimateExample_ModelImporter {

	public static void main(String[] args) {

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
	 
		//EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
		File modelFile = new File("../ArchiModels-master/Archisurance/Archisurance.archimate");
		
		IArchimateModel targetModel = null;
		// Create a new Archimate Model and set its defaults
		targetModel = IArchimateFactory.eINSTANCE.createArchimateModel();
		targetModel.setDefaults();
        
		ModelImporter modelImporter = new ModelImporter();
		try {
			modelImporter.doImport(modelFile, targetModel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ecore2GraphML ecore2Graphml = new Ecore2GraphML(targetModel);
		ecore2Graphml.convert();
		GraphML graphml = ecore2Graphml.getGraphml();
		
		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
		try {
			modelExporter.exportGraph("GraphMLXMLOutput/output_test5_Archisurance.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
