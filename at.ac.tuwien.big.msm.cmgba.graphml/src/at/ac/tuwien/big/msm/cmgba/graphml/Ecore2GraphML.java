package at.ac.tuwien.big.msm.cmgba.graphml;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphMLImpl;
import at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlFactoryImpl;
import at.ac.tuwien.big.msm.cmgba.graphml.impl.NodeImpl;

public class Ecore2GraphML {
	protected List<EObject> roots;
	protected GraphML graphml;
	protected GraphmlFactory graphFactory;
	
	
	protected HashMap<String, Element> nodesMap;
	
	public Ecore2GraphML(EObject root) {
		this.roots = new LinkedList<>();
		this.roots.add(root);
		
		//graph = new GraphMLImpl();
		graphFactory = new GraphmlFactoryImpl();
		graphml = graphFactory.createGraphML();
		
		nodesMap = new HashMap<String, Element>();
	}
	
	
	public GraphML getGraphml() {
		return graphml;
	}

	public void convert() {
		this.createGraphmlFromEcore();
	}
	
	protected void createGraphmlFromEcore() {

		List<EObject> flatTree = new LinkedList<>();
		for (EObject r : roots) {
			flatTree.add(r);
			TreeIterator<EObject> it = r.eAllContents();
			while (it.hasNext()) {
				flatTree.add(it.next());
			}
		}
		
		Graph graph = graphFactory.createGraph();
		graph.setId("123");
		
		for (EObject r : flatTree) {
			this.createNode(r, graph);
		}
		graphml.getGraphs().add(graph);
		
		for (EObject r : flatTree) {
			this.createDotReferences(r, graph);
		}
		
		
	}
	
	protected void createNode(EObject e, Graph graph) {

		Node n = graphFactory.createNode();
		n.setId(getObjectID(e));
		n.setName(e.eClass().getName());
		
		
		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(e.eClass().getName());
		
		n.getDataAttributes().add(dataClassName);
		
		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(this.labelBeutify(e.toString()) );
		n.getDataAttributes().add(dataClassLabel);
	
		
		List<EAttribute> attributes = e.eClass().getEAllAttributes();
		for (int i = 0; i < attributes.size(); i++) {
			EAttribute attribute = attributes.get(i);
			if (attribute.isID()) {
				// Skip the id
				continue;
			}
			
			Data data = graphFactory.createData();
			data.setKey(attribute.getName());
			if(e.eGet(attribute) != null)
				data.setValue(e.eGet(attribute).toString().replaceAll("&", "and"));
			
			n.getDataAttributes().add(data);
		}
		
		graph.getNodes().add(n);
		//for performance improvement
		nodesMap.put(n.getId(), n);
		
	}
	
	protected void createDotReferences(EObject e, Graph graph) {
		for (EReference ref : e.eClass().getEAllReferences()) {
			this.createDotReferences(e, ref, graph);
		}
	}
	
	protected void createDotReferences(EObject e, EReference ref, Graph graph) {
		if (ref.isMany()) {
			@SuppressWarnings("unchecked")
			List<EObject> targets = (List<EObject>) e.eGet(ref);
			for (EObject target : targets) {
				this.createDotReference(e, target, ref, graph);
			}
		} else {
			EObject target = (EObject) e.eGet(ref);
			if (target != null)
				this.createDotReference(e, target, ref, graph);
		}
	}
	
	protected void createDotReference(EObject source, EObject target, EReference ref, Graph graph) {
		String style;
		if (ref.isContainment())
			style = "style=\"bold\"";
		else {
			style = "color=\"grey\"";
		}

		Edge edge = graphFactory.createEdge();
		edge.setId(getObjectID(ref));
		edge.setName(ref.eClass().getName());
		
		
		edge.setSource((ConnectableElement)getObjectById(getObjectID(source)));
		edge.setTarget((ConnectableElement)getObjectById(getObjectID(target)));
		
		Data dataReferenceName = graphFactory.createData();
		dataReferenceName.setKey("ReferenceName");
		dataReferenceName.setValue(ref.getName());
		edge.getDataAttributes().add(dataReferenceName);
		
		Data dataReferenceLabel = graphFactory.createData();
		dataReferenceLabel.setKey("Label");
		dataReferenceLabel.setValue(this.labelBeutify(ref.getName()) );
		edge.getDataAttributes().add(dataReferenceLabel);
		
		graph.getEdges().add(edge);
		//return String.format("\t%s -> %s[label = \"%s\", %s];", getDotNodeID(source), getDotNodeID(target),
		//		ref.getName(), style) + NL;
	}
	
	protected String getObjectID(EObject e) {
		String id = EcoreUtil.getID(e);
		if (id == null)
			id = "" + e.hashCode();
		return id;
	}
	
	//deprecated!
	protected Element getObjectById_old(String id) {
		TreeIterator<EObject> it = graphml.eAllContents();
		while (it.hasNext()) {
			//flatTree.add(it.next());
			EObject next = it.next();
			if(next instanceof Element) {
				if( (Objects.equals( ((Element)next).getId(), id) )) {
					return (Element)next;
				}
			}
			
		}
		return null;
	} 
	
	
	protected Element getObjectById(String id) {
		return nodesMap.get(id);
	} 
	
	
	protected String labelBeutify(String name) {
		String shortName = "";
		
		Pattern patternClassName = Pattern.compile("impl\\.(.*?)@");
		Matcher matcher = patternClassName.matcher(name);
		if (matcher.find())
		{
			shortName = matcher.group(1);
		}
		
		Pattern patternName = Pattern.compile("name: (.*?),");
		Matcher matcher1 = patternName.matcher(name);
		if (matcher1.find())
		{
			shortName = matcher1.group(1);
			//shortName = shortName + " ("+ matcher1.group(1)+")";
		}
		
		shortName = shortName.replaceAll("&amp;", "and");
		shortName = shortName.replaceAll("&", "and");
		
		if(!shortName.equals(""))
			return shortName;
		return name;
	}
}
