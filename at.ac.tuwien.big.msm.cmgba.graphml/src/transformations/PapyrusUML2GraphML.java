package transformations;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

import at.ac.tuwien.big.msm.cmgba.graphml.ConnectableElement;
import at.ac.tuwien.big.msm.cmgba.graphml.Data;
import at.ac.tuwien.big.msm.cmgba.graphml.Edge;
import at.ac.tuwien.big.msm.cmgba.graphml.Element;
import at.ac.tuwien.big.msm.cmgba.graphml.Graph;
import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import at.ac.tuwien.big.msm.cmgba.graphml.GraphmlFactory;
import at.ac.tuwien.big.msm.cmgba.graphml.Node;
import at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlFactoryImpl;

public class PapyrusUML2GraphML {
	// protected List<EObject> roots;
	protected GraphML graphml;
	protected GraphmlFactory graphFactory;

	protected File file;

	public PapyrusUML2GraphML(File xmlFile) {

		file = xmlFile;

		// graph = new GraphMLImpl();
		graphFactory = new GraphmlFactoryImpl();
		graphml = graphFactory.createGraphML();
	}

	public GraphML getGraphml() {
		return graphml;
	}

	public void convert() {
		try {
			this.createGraphmlFromEcore();
			System.out.println("Finished with transformation.");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void createGraphmlFromEcore() throws SAXException, IOException, ParserConfigurationException {

		Graph graph = graphFactory.createGraph();
		graph.setId("123");

		// ---------------------------Initial load--------------------------
		// Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(file);

		// Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

		// Here comes the root node
		org.w3c.dom.Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		// ---------------------------Initial load--------------------------

		// iterate all instances
		org.w3c.dom.NodeList instances = document.getElementsByTagName("packagedElement");
		System.out.println("============================");

		for (int temp = 0; temp < instances.getLength(); temp++) {
			org.w3c.dom.Node node = instances.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element eElement = (org.w3c.dom.Element) node;
				if (eElement.getAttribute("xmi:type").equals("uml:Class")
						|| eElement.getAttribute("xmi:type").equals("uml:AssociationClass")
						|| eElement.getAttribute("xmi:type").equals("uml:Package")
						|| eElement.getAttribute("xmi:type").equals("uml:Component")
						|| eElement.getAttribute("xmi:type").equals("uml:DataType")

						|| eElement.getAttribute("xsi:type").equals("uml:Class")
						|| eElement.getAttribute("xsi:type").equals("uml:AssociationClass")
						|| eElement.getAttribute("xsi:type").equals("uml:Package")
						|| eElement.getAttribute("xsi:type").equals("uml:Component")
						|| eElement.getAttribute("xsi:type").equals("uml:DataType"))
					this.addNode(eElement, graph);
			}
		}

		// before edges so the nodes can be found
		graphml.getGraphs().add(graph);

		// iterate all connectors
		for (int temp = 0; temp < instances.getLength(); temp++) {
			org.w3c.dom.Node node = instances.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element eElement = (org.w3c.dom.Element) node;

				org.w3c.dom.NodeList interNodes = eElement.getChildNodes();
				for (int j = 0; j < interNodes.getLength(); j++) {
					org.w3c.dom.Node interNode = interNodes.item(j);
					if (interNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
						org.w3c.dom.Element intereElement = (org.w3c.dom.Element) interNode;

						this.addEdge(eElement, intereElement, graph);
					}
				}

				if (eElement.getAttribute("xmi:type").equals("uml:Abstraction")
						|| eElement.getAttribute("xmi:type").equals("uml:Dependency")
						|| eElement.getAttribute("xmi:type").equals("uml:Realization")

						|| eElement.getAttribute("xsi:type").equals("uml:Abstraction")
						|| eElement.getAttribute("xsi:type").equals("uml:Dependency")
						|| eElement.getAttribute("xsi:type").equals("uml:Realization")) {
					this.addEdge(eElement, graph);
				}

			}
		}

		/*
		 * NodeList connections = document.getElementsByTagName("packagedElement");
		 * System.out.println("============================");
		 * 
		 * for (int temp = 0; temp < connections.getLength(); temp++) { org.w3c.dom.Node
		 * node = connections.item(temp);
		 * 
		 * System.out.println(""); // Just a separator if (node.getNodeType() ==
		 * org.w3c.dom.Node.ELEMENT_NODE) { // Print each employee's detail
		 * org.w3c.dom.Element eElement = (org.w3c.dom.Element) node;
		 * 
		 * this.addEdge(eElement, graph); } }
		 */

	}

	protected void addNode(org.w3c.dom.Element eElement, Graph graph) {

		// iterate inner node elements
		org.w3c.dom.NodeList instances = eElement.getElementsByTagName("packagedElement");
		System.out.println("============================");

		for (int temp = 0; temp < instances.getLength(); temp++) {
			org.w3c.dom.Node node = instances.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element eElementInner = (org.w3c.dom.Element) node;
				if (eElementInner.getAttribute("xmi:type").equals("uml:Class")
						|| eElementInner.getAttribute("xmi:type").equals("uml:AssociationClass")
						|| eElementInner.getAttribute("xmi:type").equals("uml:Package")
						|| eElementInner.getAttribute("xmi:type").equals("uml:Component")
						|| eElementInner.getAttribute("xmi:type").equals("uml:DataType")

						|| eElementInner.getAttribute("xsi:type").equals("uml:Class")
						|| eElementInner.getAttribute("xsi:type").equals("uml:AssociationClass")
						|| eElementInner.getAttribute("xsi:type").equals("uml:Package")
						|| eElementInner.getAttribute("xsi:type").equals("uml:Component")
						|| eElementInner.getAttribute("xsi:type").equals("uml:DataType"))
					this.addNode(eElementInner, graph);
			}
		}

		Node n = graphFactory.createNode();
		n.setId(eElement.getAttribute("xmi:id"));
		n.setName(eElement.getAttribute("name"));

		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(eElement.getAttribute("name"));
		n.getDataAttributes().add(dataClassName);

		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(eElement.getAttribute("name"));
		n.getDataAttributes().add(dataClassLabel);

		// get attributes
		NamedNodeMap attrs = eElement.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			// System.out.print("
			// "+((Attr)attrs.item(i)).getName()+"=\""+((Attr)attrs.item(i)).getValue()+"\"");

			Data additionalAttribute = graphFactory.createData();
			additionalAttribute.setKey(((Attr) attrs.item(i)).getName());
			additionalAttribute.setValue(((Attr) attrs.item(i)).getValue());
			n.getDataAttributes().add(additionalAttribute);

		}

		/*
		 * NodeList attributes = eElement.getElementsByTagName("ATTRIBUTE"); for (int i
		 * = 0; i < attributes.getLength(); i++) { org.w3c.dom.Node atr =
		 * attributes.item(i); System.out.println("attributes"); // Just a separator if
		 * (atr.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) { org.w3c.dom.Element
		 * atrElement = (org.w3c.dom.Element) atr;
		 * 
		 * Data additionalAttribute = graphFactory.createData();
		 * additionalAttribute.setKey(atrElement.getAttribute("name"));
		 * additionalAttribute.setValue(atrElement.getTextContent());
		 * n.getDataAttributes().add(additionalAttribute); } }
		 */

		graph.getNodes().add(n);
	}

	protected void addEdge(org.w3c.dom.Element eElement, org.w3c.dom.Element intereElement, Graph graph) {
		Edge edge = graphFactory.createEdge();
		edge.setId(intereElement.getAttribute("id"));
		// edge.setName(intereElement.getAttribute("xmi:type"));
		edge.setName(intereElement.getTagName());

		Data dataReferenceName = graphFactory.createData();
		dataReferenceName.setKey("ReferenceName");
		// dataReferenceName.setValue(intereElement.getAttribute("xmi:type"));
		dataReferenceName.setValue(intereElement.getTagName());
		edge.getDataAttributes().add(dataReferenceName);

		Data dataReferenceLabel = graphFactory.createData();
		dataReferenceLabel.setKey("Label");
		// dataReferenceLabel.setValue(intereElement.getAttribute("xmi:type"));
		dataReferenceLabel.setValue(intereElement.getTagName());
		edge.getDataAttributes().add(dataReferenceLabel);

		try {
			edge.setSource((ConnectableElement) getObjectById(eElement.getAttribute("xmi:id")));

			if (intereElement.getAttribute("xmi:type").equals("uml:Generalization")
					|| intereElement.getAttribute("xsi:type").equals("uml:Generalization")
					|| intereElement.getTagName().equals("generalization")) {
				edge.setTarget((ConnectableElement) getObjectById(intereElement.getAttribute("general")));
			} else if (intereElement.getAttribute("xmi:type").equals("uml:Class")
					|| intereElement.getAttribute("xsi:type").equals("uml:Class")
					|| intereElement.getTagName().equals("nestedClassifier"))
				edge.setTarget((ConnectableElement) getObjectByName(intereElement.getAttribute("name")));
			else if (intereElement.getAttribute("xmi:type").equals("uml:ElementImport")
					|| intereElement.getAttribute("xsi:type").equals("uml:ElementImport")
					|| intereElement.getTagName().equals("elementImport"))
				edge.setTarget((ConnectableElement) getObjectById(intereElement.getAttribute("importedElement")));
			else
				edge.setTarget((ConnectableElement) getObjectById(intereElement.getAttribute("type")));

			/*
			 * NodeList attributes = eElement.getElementsByTagName("ATTRIBUTE"); for (int i
			 * = 0; i < attributes.getLength(); i++) { org.w3c.dom.Node atr =
			 * attributes.item(i); System.out.println("attributes"); // Just a separator if
			 * (atr.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) { org.w3c.dom.Element
			 * atrElement = (org.w3c.dom.Element) atr; Data dataAttr =
			 * graphFactory.createData(); dataAttr.setKey(atrElement.getAttribute("name"));
			 * dataAttr.setValue(atrElement.getTextContent());
			 * edge.getDataAttributes().add(dataAttr); } }
			 */

			graph.getEdges().add(edge);
		} catch (Exception e) {
			String a;
		}
	}

	/// for uml:Abstraction, uml:Dependency
	protected void addEdge(org.w3c.dom.Element eElement, Graph graph) {
		Edge edge = graphFactory.createEdge();
		edge.setId(eElement.getAttribute("id"));
		// edge.setName(eElement.getAttribute("xmi:type"));
		edge.setName(eElement.getTagName());

		Data dataReferenceName = graphFactory.createData();
		dataReferenceName.setKey("ReferenceName");
		// dataReferenceName.setValue(eElement.getAttribute("xmi:type"));
		dataReferenceName.setValue(eElement.getTagName());
		edge.getDataAttributes().add(dataReferenceName);

		Data dataReferenceLabel = graphFactory.createData();
		dataReferenceLabel.setKey("Label");
		// dataReferenceLabel.setValue(eElement.getAttribute("xmi:type"));
		dataReferenceLabel.setValue(eElement.getTagName());
		edge.getDataAttributes().add(dataReferenceLabel);

		try {
			if (eElement.getAttribute("xmi:type").equals("uml:InformationFlow")
					|| eElement.getAttribute("xsi:type").equals("uml:InformationFlow")) {
				edge.setSource((ConnectableElement) getObjectById(eElement.getAttribute("informationSource")));
				edge.setTarget((ConnectableElement) getObjectById(eElement.getAttribute("informationTarget")));
			} else {
				edge.setSource((ConnectableElement) getObjectById(eElement.getAttribute("client")));
				edge.setTarget((ConnectableElement) getObjectById(eElement.getAttribute("supplier")));
			}

			graph.getEdges().add(edge);
		} catch (Exception e) {
			String a;
		}
	}

	protected Element getObjectById(String id) {
		TreeIterator<EObject> it = graphml.eAllContents();
		while (it.hasNext()) {
			// flatTree.add(it.next());
			EObject next = it.next();
			if (next instanceof Element) {
				// System.out.println(((Element)next).getId() +" == "+ id);

				if (((Element) next).getId().equals(id)) {
					return (Element) next;
				}
			}
		}
		return null;
	}

	protected Element getObjectByName(String name) {
		TreeIterator<EObject> it = graphml.eAllContents();
		while (it.hasNext()) {
			// flatTree.add(it.next());
			EObject next = it.next();
			if (next instanceof Element) {
				// System.out.println(((Element)next).getName() +" == "+ name);
				if (((Element) next).getName() == null) {
					continue;
				}

				if (((Element) next).getName().equals(name)) {
					return (Element) next;
				}
			}
		}
		return null;
	}
}
