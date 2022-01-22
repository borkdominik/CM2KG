package examples.ecore;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import tmodel.impl.TmodelPackageImpl;
import transformations.Ecore2GraphML;

public class Main4_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EPackage.Registry.INSTANCE.put(TmodelPackageImpl.eNS_URI, TmodelPackageImpl.eINSTANCE);

		ResourceSet load_resourceSet = new ResourceSetImpl();

		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		Resource load_resource = load_resourceSet
				.getResource(URI.createURI("../at.ac.tuwien.big.msm.cmgba.atl/input/ViennaBooks.xmi"), true);

		EObject rootElement = (EObject) load_resource.getContents().get(0);

		List<EObject> roots = load_resource.getContents();

		Ecore2GraphML ecore2Graphml = new Ecore2GraphML(rootElement);
		ecore2Graphml.convert();
		GraphML graphml = ecore2Graphml.getGraphml();

		GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
		try {
			modelExporter.exportGraph("GraphMLXMLOutput/output_ViennaBooks.graphml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
