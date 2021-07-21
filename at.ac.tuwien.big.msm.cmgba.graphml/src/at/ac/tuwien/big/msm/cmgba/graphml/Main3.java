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

import tmodel.TmodelFactory;
import tmodel.TmodelPackage;
import tmodel.impl.TmodelPackageImpl;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("F:\\Thesis\\Archimate models\\ArchiMetal.xml");
		
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		//		"ecore", new EcoreResourceFactoryImpl());
		
		
		//EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		
		
		
		EPackage.Registry.INSTANCE.put(GraphmlPackage.eNS_URI, GraphmlPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(TmodelPackageImpl.eNS_URI, TmodelPackageImpl.eINSTANCE);
		
		
		
		
		ResourceSet load_resourceSet = new ResourceSetImpl();
		
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		//load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap ().put("*", new XMIResourceFactoryImpl());
		
		
		Resource load_resource = load_resourceSet.getResource(URI.createURI("../at.ac.tuwien.big.msm.cmgba.atl/input/TestStore.xmi"),true);

		EObject rootElement = (EObject)
			    load_resource.getContents().get(0);
		
		
		
		List<EObject> roots = load_resource.getContents();
		HashMap<String, EObject> uniqueClasses = new HashMap<>();
		
		int counterTree=0;
		List<EObject> flatTree = new LinkedList<>();
		for (EObject r : roots) {
			flatTree.add(r);
			
			if(uniqueClasses.get(r.eClass().getName()) == null) {
				uniqueClasses.put(r.eClass().getName(), r);
			}
			
			TreeIterator<EObject> it = r.eAllContents();
			while (it.hasNext()) {
				EObject o = it.next();
				//o.eClass().setName(o.eClass().getName()+(counterTree++));
				flatTree.add(o);
				
				if(uniqueClasses.get(o.eClass().getName()) == null) {
					uniqueClasses.put(o.eClass().getName(), o);
				}
			}
		}

		
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		 
		EPackage bookStoreEPackage = theCoreFactory.createEPackage();
		bookStoreEPackage.setName("BookStorePackage");
		bookStoreEPackage.setNsPrefix("bookStore");
		bookStoreEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.ecore");
		
		
		int counter=0;
		
		for (EObject r : flatTree) {
			//EPackage tpac= TmodelPackage.eINSTANCE.getESuperPackage();
			//EPackage tpac2 = TmodelPackageImpl.tpa;
			
			if(r instanceof EPackage)
				continue;
			
			
			if(r instanceof EReference)
				continue;
			
			EClass bookStoreEClass = theCoreFactory.createEClass();
			bookStoreEClass.setName(r.eClass().getName());//+EcoreUtil.getID(r));//+(counter++));
			
			String className = r.eClass().getName();
			EObject classDesc = uniqueClasses.get(className);
			
			List<EAttribute> attributes = classDesc.eClass().getEAllAttributes();
			boolean commaNecessary = false;
			for (int i = 0; i < attributes.size(); i++) {

			
				EAttribute attribute = attributes.get(i);
				
				EAttribute bookStoreOwner = theCoreFactory.createEAttribute();
				bookStoreOwner.setName(attribute.getName());
				bookStoreOwner.setEType(attribute.getEType());
				bookStoreOwner.setDefaultValue(r.eGet(attribute));
				
				bookStoreEClass.getEStructuralFeatures().add(bookStoreOwner);
			}
			
			
			for (EReference ref : r.eClass().getEAllReferences()) {
				int counterRef=0;
				List<EObject> targets = (List<EObject>) r.eGet(ref);
				for (EObject target : targets) {
					//res += createDotReference(e, target, ref);
					
					EReference bookStore_Books = theCoreFactory.createEReference();
					bookStore_Books.setName(ref.getName()+(counterRef++));
					bookStore_Books.setEType(ref.getEReferenceType());
					bookStore_Books.setUpperBound(1);
					bookStore_Books.setContainment(true);
					
					bookStoreEClass.getEStructuralFeatures().add(bookStore_Books);
				}
				
				
				
				
				/*String res = "";
				if (ref.isMany()) {
					@SuppressWarnings("unchecked")
					List<EObject> targets = (List<EObject>) r.eGet(ref);
					for (EObject target : targets) {
						res += createDotReference(r, target, ref);
						
						String style;
						if (ref.isContainment())
							style = "style=\"bold\"";
						else {
							style = "color=\"grey\"";
						}
						return String.format("\t%s -> %s[label = \"%s\", %s];", getDotNodeID(source), getDotNodeID(target),
								ref.getName(), style) + NL;
						
					}
				} else {
					EObject target = (EObject) r.eGet(ref);
					if (target != null)
						res += createDotReference(r, target, ref);
				}*/
			}
			
			bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
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
		Resource resource = resourceSet.createResource(URI.createURI("instances/teststore_with_ref1.ecore"));
		 
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
		
		
	}

}
