package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.opengroup.archimate.xmlexchange.XMLModelExporter;
import org.opengroup.archimate.xmlexchange.XMLValidator;
import org.xml.sax.SAXException;

import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.impl.ArchimateFactory;
import com.archimatetool.model.impl.ArchimatePackage;
import com.archimatetool.modelimporter.ImportException;
import com.archimatetool.modelimporter.ModelImporter;

import tmodel.impl.TmodelPackageImpl;

public class Main14_ArchimateToOpenGroupXML {

	// static final String PREFIX = Messages.ExportXMLProvider_0;

	static final String OPTION_EXPORT_XML = "xmlexchange.export"; //$NON-NLS-1$
	static final String OPTION_EXPORT_XML_FOLDERS = "xmlexchange.exportFolders"; //$NON-NLS-1$
	static final String OPTION_EXPORT_XML_LANGUAGE = "xmlexchange.exportLang"; //$NON-NLS-1$

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
	    
	    ResourceSet load_resourceSet = new ResourceSetImpl();
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		
		//EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
		//EPackage.Registry.INSTANCE.put(TmodelPackageImpl.eNS_URI, TmodelPackageImpl.eINSTANCE);
		
		EPackage.Registry.INSTANCE.put(IArchimatePackage.eNS_URI, IArchimatePackage.eINSTANCE);
		
		try {
			IArchimateFactory theArchimateFactory = (IArchimateFactory)EPackage.Registry.INSTANCE.getEFactory(IArchimatePackage.eNS_URI);
			if (theArchimateFactory != null) {
				 System.out.println("IArchimateFactory loaded");
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		
		//ArchimatePackage
		
		
		File modelFile = new File("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\app store.archimate");

		Scanner input;
		try {
			input = new Scanner(modelFile);
			while (input.hasNextLine())
			{
			   System.out.println(input.nextLine());
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		
		//File modelFile = new File("../ArchiModels-master/Archisurance/Archisurance.archimate");
		IArchimateModel targetModel = null;
		// Create a new Archimate Model and set its defaults
		targetModel = IArchimateFactory.eINSTANCE.createArchimateModel();
		targetModel.setDefaults();

		ModelImporter modelImporter = new ModelImporter();
		try {
			
			modelImporter.setUpdate(true);
			modelImporter.setUpdateAll(true);
			modelImporter.doImport(modelFile, targetModel);
			
			
			XMLModelExporter exporter = new XMLModelExporter();
			// Folders
			// exporter.setSaveOrganisation(commandLine.hasOption(OPTION_EXPORT_XML_FOLDERS));

			// Language
			// exporter.setLanguageCode(commandLine.getOptionValue(OPTION_EXPORT_XML_LANGUAGE));

			
			File outputFile = new File("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format/arch model_ogf.xml");
			exporter.exportModel(targetModel, outputFile);

			// logMessage(Messages.ExportXMLProvider_4);

			// Validate file
			// logMessage(Messages.ExportXMLProvider_5);

			XMLValidator validator = new XMLValidator();
			validator.validateXML(outputFile);

			//logMessage(Messages.ExportXMLProvider_6);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SAXException e) {
			e.printStackTrace();
		}

		

	}

}
