package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import com.archimatetool.model.impl.ArchimatePackage;

import tmodel.TmodelFactory;
import tmodel.TmodelPackage;
import tmodel.impl.TmodelPackageImpl;



public class Main5_ArchimateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("F:\\Thesis\\Archimate models\\ArchiMetal.xml");
		
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		//		"ecore", new EcoreResourceFactoryImpl());
		
		
		//EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		
		EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		//EPackage.Registry.INSTANCE.put(TmodelPackageImpl.eNS_URI, TmodelPackageImpl.eINSTANCE);
		
		
		EPackage.Registry.INSTANCE.put(ArchimatePackage.eNS_URI, ArchimatePackage.eINSTANCE);
		
		//ArchimatePackage
		//ArchimatePackage
		
		ResourceSet load_resourceSet = new ResourceSetImpl();
		
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		//load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap ().put("*", new XMIResourceFactoryImpl());
		
		
		Resource load_resource = load_resourceSet.getResource(URI.createURI("../com.archimatetool.model/Archisurance/Archisurance_modified.archimate"),true);

		EObject rootElement = (EObject)
			    load_resource.getContents().get(0);
		
		
		
		List<EObject> roots = load_resource.getContents();

		Ecore2GraphML ecore2Graphml = new Ecore2GraphML(rootElement);
		ecore2Graphml.convert();
		GraphML graphml = ecore2Graphml.getGraphml();
		
		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
		try {
			modelExporter.exportGraph("GraphMLXMLOutput/output_test4_Archisurance.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ResourceSet metaResourceSet = new ResourceSetImpl();
		 
		
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		* Register XML Factory implementation using DEFAULT_EXTENSION
		*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "*", new  XMLResourceFactoryImpl());
		 
		/*
		* Create empty resource with the given URI
		*/
		Resource resource = resourceSet.createResource(URI.createURI("instances/javatrans_graphml1.graphml"));
		 
		/*
		* Add bookStoreObject to contents list of the resource 
		*/
		resource.getContents().add(graphml);
		 
		try{
		    /*
		    * Save the resource
		    */
		      resource.save(null);
		   }catch (IOException e) {
		      e.printStackTrace();
		   }
		
		
	}

}
