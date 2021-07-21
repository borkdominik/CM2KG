package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;

import org.w3c.dom.*;

import org.xml.sax.SAXException;

import com.archimatetool.model.IArchimateRelationship;
import com.archimatetool.model.INameable;

import javax.xml.parsers.*;

import at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlFactoryImpl;

public class ADOxxInstance2GraphML {
	// protected List<EObject> roots;
	protected GraphML graphml;
	protected GraphmlFactory graphFactory;

	protected File file;

	public ADOxxInstance2GraphML(File xmlFile) {

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
		
		//---------------------------Initial load--------------------------
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Build Document
		Document document = builder.parse(file);

		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();

		// Here comes the root node
		org.w3c.dom.Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());

		//---------------------------Initial load--------------------------
		
		//iterate all instances
		org.w3c.dom.NodeList instances = document.getElementsByTagName("INSTANCE");
		System.out.println("============================");

		for (int temp = 0; temp < instances.getLength(); temp++) {
			org.w3c.dom.Node node = instances.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element eElement = (org.w3c.dom.Element) node;
				
				this.addNode(eElement, graph);
			}
		}

		//before edges so the nodes can be found
		graphml.getGraphs().add(graph);
		
		//iterate all connectors
		NodeList connections = document.getElementsByTagName("CONNECTOR");
		System.out.println("============================");

		for (int temp = 0; temp < connections.getLength(); temp++) {
			org.w3c.dom.Node node = connections.item(temp);
			System.out.println(""); // Just a separator
			if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				// Print each employee's detail
				org.w3c.dom.Element eElement = (org.w3c.dom.Element) node;
				
				this.addEdge(eElement, graph);
			}
		}
	}

	protected void addNode(org.w3c.dom.Element eElement, Graph graph) {
		
		Node n = graphFactory.createNode();
		n.setId(eElement.getAttribute("id"));
		n.setName(eElement.getAttribute("name"));
		
		
		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(eElement.getAttribute("class"));
		n.getDataAttributes().add(dataClassName);
		
		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(eElement.getAttribute("name"));
		n.getDataAttributes().add(dataClassLabel);
		
		//get attributes
		NodeList attributes = eElement.getElementsByTagName("ATTRIBUTE");
		for (int i = 0; i < attributes.getLength(); i++) {
			org.w3c.dom.Node atr = attributes.item(i);
			System.out.println("attributes"); // Just a separator
			if (atr.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element atrElement = (org.w3c.dom.Element) atr;

				Data additionalAttribute = graphFactory.createData();
				additionalAttribute.setKey(atrElement.getAttribute("name"));
				additionalAttribute.setValue(atrElement.getTextContent());
				n.getDataAttributes().add(additionalAttribute);
			}
		}
		
		graph.getNodes().add(n);
	}
	

	protected void addEdge(org.w3c.dom.Element eElement, Graph graph) {
		Edge edge = graphFactory.createEdge();
		edge.setId(eElement.getAttribute("id"));
		edge.setName(eElement.getAttribute("class"));
		
		Data dataReferenceName = graphFactory.createData();
		dataReferenceName.setKey("ReferenceName");
		dataReferenceName.setValue(eElement.getAttribute("class"));
		edge.getDataAttributes().add(dataReferenceName);
		
		Data dataReferenceLabel = graphFactory.createData();
		dataReferenceLabel.setKey("Label");
		dataReferenceLabel.setValue(eElement.getAttribute("class"));
		edge.getDataAttributes().add(dataReferenceLabel);
		
		//System.out.println("id : " + eElement.getAttribute("id"));
		//System.out.println("class : " + eElement.getAttribute("class"));

		//System.out.println("from");
		org.w3c.dom.Element from = (org.w3c.dom.Element) eElement.getElementsByTagName("FROM").item(0);
		//System.out.println("instance : " + from.getAttribute("instance"));
		//System.out.println("class : " + from.getAttribute("class"));

		edge.setSource((ConnectableElement)getObjectById(from.getAttribute("instance")));
		
		//System.out.println("to");
		org.w3c.dom.Element to = (org.w3c.dom.Element) eElement.getElementsByTagName("TO").item(0);
		//System.out.println("instance : " + to.getAttribute("instance"));
		//System.out.println("class : " + to.getAttribute("class"));

		edge.setTarget((ConnectableElement)getObjectById(to.getAttribute("instance")));
		
		NodeList attributes = eElement.getElementsByTagName("ATTRIBUTE");
		for (int i = 0; i < attributes.getLength(); i++) {
			org.w3c.dom.Node atr = attributes.item(i);
			System.out.println("attributes"); // Just a separator
			if (atr.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
				org.w3c.dom.Element atrElement = (org.w3c.dom.Element) atr;

				//System.out.println("atr name : " + atrElement.getAttribute("name"));
				//System.out.println("atr value : " + atrElement.getTextContent());
				
				Data dataAttr = graphFactory.createData();
				dataAttr.setKey(atrElement.getAttribute("name"));
				dataAttr.setValue(atrElement.getTextContent());
				edge.getDataAttributes().add(dataAttr);
			}
		}
		
		graph.getEdges().add(edge);
		
	}
	
	protected Element getObjectById(String id) {
		TreeIterator<EObject> it = graphml.eAllContents();
		while (it.hasNext()) {
			//flatTree.add(it.next());
			EObject next = it.next();
			if(next instanceof Element) {
				if( (Objects.equals( ((Element)next).getName(), id) )) {
					return (Element)next;
				}
			}
		}
		return null;
	} 
}
