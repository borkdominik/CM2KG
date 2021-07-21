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


import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class main12_Papyrus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ResourceSet set = new ResourceSetImpl();
		set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		   .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);

		Resource res = set.getResource(URI.createFileURI("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\PapyrusTestModel\\PapyrusTestModel.uml"), true);
		
		EObject rootElement = (EObject)
				res.getContents().get(0);
		
		
		
		//List<EObject> roots = res.getContents();

		Papyrus2GraphML papyrus2Graphml = new Papyrus2GraphML(rootElement);
		papyrus2Graphml.convert();
		GraphML graphml = papyrus2Graphml.getGraphml();
		
		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
		try {
			modelExporter.exportGraph("GraphMLXMLOutput/papyrus_test3_full_conversion.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}
