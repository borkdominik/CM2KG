package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class Main {

	public static void main(String[] args) {

		File f = new File("F:\\Thesis\\Archimate models\\ArchiMetal.xml");
	
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		//		"ecore", new EcoreResourceFactoryImpl());
		
		
		//EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		
		EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		ResourceSet load_resourceSet = new ResourceSetImpl();
		
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
		//load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap ().put("*", new XMIResourceFactoryImpl());
		
		Resource graphMLtestInstance = load_resourceSet.getResource(URI.createURI("instances/GraphML_Instance.xmi"),true);
		GraphML graphMlRootElement = (GraphML)graphMLtestInstance.getContents().get(0);
		
		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphMlRootElement);
		try {
			modelExporter.exportGraph("GraphMLXMLOutput/output_test1.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Resource load_resource = load_resourceSet.getResource(URI.createURI("instances/GraphML_Instance.xmi"),true);
		Resource resoruceTestEcore = load_resourceSet.getResource(URI.createURI("../at.ac.tuwien.big.msm.cmgba.atl/metamodel/Test.ecore"),true);
		
		List<EObject> obj1s =  load_resource.getContents();
		EObject rootElement1 = (EObject)
				resoruceTestEcore.getContents().get(0);
		
		
		List<EObject> objs =  load_resource.getContents();
		
		
		EObject rootElement = (EObject)
			    load_resource.getContents().get(0);
		
		
		
		List<EObject> roots = load_resource.getContents();
		
		List<EObject> flatTree = new LinkedList<>();
		for (EObject r : roots) {
			flatTree.add(r);
			TreeIterator<EObject> it = r.eAllContents();
			while (it.hasNext()) {
				flatTree.add(it.next());
			}
		}
		
		/*for (EObject r : flatTree) {
			res += createDotNode(r);
		}

		for (EObject r : flatTree) {
			res += createDotReferences(r);
		}
		*/
		
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		 
		/*
		* Create EClass instance to model BookStore class
		*/
		
		/*
		* Instantiate EPackage and provide unique URI
		* to identify this package
		*/
		EPackage bookStoreEPackage = theCoreFactory.createEPackage();
		bookStoreEPackage.setName("BookStorePackage");
		bookStoreEPackage.setNsPrefix("bookStore");
		bookStoreEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.ecore");
		
		
		 
		for (EObject r : flatTree) {
			EClass bookStoreEClass = theCoreFactory.createEClass();
			bookStoreEClass.setName(r.eClass().getName());
			
			List<EAttribute> attributes = r.eClass().getEAllAttributes();
			boolean commaNecessary = false;
			for (int i = 0; i < attributes.size(); i++) {

				EAttribute attribute = attributes.get(i);
				bookStoreEClass.getEStructuralFeatures().add(attribute);
			}
			
			bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
		}
		 
		/*EClass bookStoreEClass = theCoreFactory.createEClass();
		bookStoreEClass.setName("BookStore");
		
		EClass bookEClass = theCoreFactory.createEClass();
		bookEClass.setName("Book");
		
		bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
		bookStoreEPackage.getEClassifiers().add(bookEClass);
	*/
		
		ResourceSet metaResourceSet = new ResourceSetImpl();
		 
		
		/*
		* Register XML Factory implementation to handle .ecore files
		*/
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "ecore", new  EcoreResourceFactoryImpl());
		
		Resource metaResource = metaResourceSet.createResource(URI.createURI("instances/bookStore.ecore"));
		metaResource.getContents().add(rootElement);
		
		Resource metaResource1 = metaResourceSet.createResource(URI.createURI("instances/bookStore2.ecore"));
		metaResource1.getContents().add(bookStoreEPackage);
		
		try {
		     /*
		     * Save the resource
		     */
		     metaResource.save(null);
		     metaResource1.save(null);
		    } catch (IOException e) {
		      e.printStackTrace();
		   }
		
		
		
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		* Register XML Factory implementation using DEFAULT_EXTENSION
		*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "*", new  XMLResourceFactoryImpl());
		 
		/*
		* Create empty resource with the given URI
		*/
		Resource resource = resourceSet.createResource(URI.createURI("instances/bookStore7.xml"));
		 
		/*
		* Add bookStoreObject to contents list of the resource 
		*/
		resource.getContents().add(bookStoreEPackage);
		 
		try{
		    /*
		    * Save the resource
		    */
		      resource.save(null);
		   }catch (IOException e) {
		      e.printStackTrace();
		   }
		
		
		/*if(load_resource.getContents().get(0) instanceof EObject)
		{
			int b = 3;
			if(b==5) {
			}
		}
		if(load_resource.getContents().get(0) instanceof EPackage)
		{
			int b = 3;
			if(b==5) {
			}
		}
		if(load_resource.getContents().get(0) instanceof EFactory)
		{
			int b = 3;
			if(b==5) {
			}
		}
		if(load_resource.getContents().get(0) instanceof EClass)
		{
			int b = 3;
			if(b==5) {
			}
		}
		if(load_resource.getContents().get(0) instanceof EReference)
		{
			int b = 3;
			if(b==5) {
			}
		}
		if(load_resource.getContents().get(0) instanceof EAttribute)
		{
			int b = 3;
			if(b==5) {
			}
		}*/
		
		int a = 3;
		
		if(a==5) {
			
		}
	}

}
