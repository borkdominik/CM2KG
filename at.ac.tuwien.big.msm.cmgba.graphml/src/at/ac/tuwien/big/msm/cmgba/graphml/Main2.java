package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;


public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		* Instantiate EcoreFactory
		*/
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		 
		/*
		* Create EClass instance to model BookStore class
		*/
		EClass bookStoreEClass = theCoreFactory.createEClass();
		bookStoreEClass.setName("BookStore");
		 
		/*
		* Create EClass instance to model Book class
		*/
		EClass bookEClass = theCoreFactory.createEClass();
		bookEClass.setName("Book");
		 
		/*
		* Instantiate EPackage and provide unique URI
		* to identify this package
		*/
		EPackage bookStoreEPackage = theCoreFactory.createEPackage();
		bookStoreEPackage.setName("BookStorePackage");
		bookStoreEPackage.setNsPrefix("bookStore");
		bookStoreEPackage.setNsURI("http:///com.ibm.dynamic.example.bookstore.ecore");
		
		bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
		bookStoreEPackage.getEClassifiers().add(bookEClass);
		
		
		ResourceSet resourceSet = new ResourceSetImpl();
		/*
		* Register XML Factory implementation using DEFAULT_EXTENSION
		*/
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		    "*", new  XMLResourceFactoryImpl());
		 
		/*
		* Create empty resource with the given URI
		*/
		Resource resource = resourceSet.createResource(URI.createURI("instances/bookStore6.xml"));
		 
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
		
		
		
		/*
		* Instantiate EcorePackage
		*/
		EcorePackage theCorePackage = EcorePackage.eINSTANCE;
		 
		/*
		* Create attributes for BookStore class as specified in the model
		*/
		EAttribute bookStoreOwner = theCoreFactory.createEAttribute();
		bookStoreOwner.setName("owner");
		bookStoreOwner.setEType(theCorePackage.getEString());
		EAttribute bookStoreLocation = theCoreFactory.createEAttribute();
		bookStoreLocation.setName("location");
		bookStoreLocation.setEType(theCorePackage.getEString());
		EReference bookStore_Books = theCoreFactory.createEReference();
		bookStore_Books.setName("books");
		bookStore_Books.setEType(bookEClass);
		bookStore_Books.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		bookStore_Books.setContainment(true);
		 
		/*
		* Create attributes for Book class as defined in the model
		*/
		EAttribute bookName = theCoreFactory.createEAttribute();
		bookName.setName("name");
		bookName.setEType(theCorePackage.getEString());
		EAttribute bookISBN = theCoreFactory.createEAttribute();
		bookISBN.setName("isbn");
		bookISBN.setEType(theCorePackage.getEInt());
		
		
		/*
		* Add owner, location and books attributes/references
		* to BookStore class
		*/
		bookStoreEClass.getEStructuralFeatures().add(bookStoreOwner);
		bookStoreEClass.getEStructuralFeatures().add(bookStoreLocation);
		bookStoreEClass.getEStructuralFeatures().add(bookStore_Books);
		 
		/*
		* Add name and isbn attributes to Book class
		*/
		bookEClass.getEStructuralFeatures().add(bookName);
		bookEClass.getEStructuralFeatures().add(bookISBN);
		 
		/*
		* Place BookStore and Book classes in bookStoreEPackage
		*/
		//bookStoreEPackage.getEClassifiers().add(bookStoreEClass);
		//bookStoreEPackage.getEClassifiers().add(bookEClass);
		
		
		
		
		
	}

}
