package transformations;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.IArchimateRelationship;
import com.archimatetool.model.IDiagramModel;
import com.archimatetool.model.IDiagramModelObject;
import com.archimatetool.model.IFolder;
import com.archimatetool.model.INameable;
import com.archimatetool.model.impl.ArchimateDiagramModel;
import com.archimatetool.model.impl.ArchimateModel;
import com.archimatetool.model.impl.Bounds;
import com.archimatetool.model.impl.DiagramModelArchimateConnection;
import com.archimatetool.model.impl.DiagramModelArchimateObject;
import com.archimatetool.model.impl.DiagramModelBendpoint;
import com.archimatetool.model.impl.DiagramModelNote;
import com.archimatetool.model.impl.DiagramModelReference;
import at.ac.tuwien.big.msm.cmgba.graphml.ConnectableElement;
import at.ac.tuwien.big.msm.cmgba.graphml.Data;
import at.ac.tuwien.big.msm.cmgba.graphml.Edge;
import at.ac.tuwien.big.msm.cmgba.graphml.Graph;
import at.ac.tuwien.big.msm.cmgba.graphml.Node;

public class Archimate2GraphML extends Ecore2GraphML {

	protected IArchimateModel model;

	private Archimate2GraphML(EObject root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public Archimate2GraphML(IArchimateModel model) {
		super(model);
		this.model = model;
		// TODO Auto-generated constructor stub
	}

	@Override
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
		graph.setId("init_graph_01");
		// graph.setId(this.getObjectID(model));
		// Create node

		Node n1 = graphFactory.createNode();
		n1.setId(getObjectID(model));
		n1.setName(model.eClass().getName());

		Data dataClassName1 = graphFactory.createData();
		dataClassName1.setKey("ClassName");
		dataClassName1.setValue(model.eClass().getName());
		n1.getDataAttributes().add(dataClassName1);

		Data dataClassLabel1 = graphFactory.createData();
		dataClassLabel1.setKey("Label");
		dataClassLabel1.setValue(this.labelBeutify(model.toString()));
		n1.getDataAttributes().add(dataClassLabel1);

		// graph.getNodes().add(n1);

		System.out.println("adding nodes started");

		// EXCPERIMENTALLLL
		/*
		 * DiagramModelArchimateObject o;
		 * 
		 * o.getArchimateConcept();
		 * 
		 * ArchimateDiagramModel dModel; dModel.get
		 */

		// NEW Implementation, now it is able to select only one view!
		List<EObject> flatTree2 = new LinkedList<>();
		for (EObject r : flatTree) {
			if (r instanceof ArchimateDiagramModel) {
				EList<IDiagramModelObject> children = ((ArchimateDiagramModel) r).getChildren();
				for (IDiagramModelObject dO : children) {
					if (dO instanceof DiagramModelArchimateObject) {
						this.addDiagramObjectContent((DiagramModelArchimateObject) dO, flatTree2);
					}
				}
			}
		}

		/*
		 * for (EObject r : flatTree2) { this.createNode(r, graph); }
		 */

		for (EObject r : flatTree2) {
			if (!(r instanceof IFolder || r instanceof IDiagramModel || r instanceof DiagramModelArchimateObject
					|| r instanceof DiagramModelBendpoint || r instanceof DiagramModelArchimateConnection
					|| r instanceof DiagramModelNote || r instanceof DiagramModelReference || r instanceof Bounds
					|| r instanceof IArchimateRelationship || r instanceof ArchimateModel))
				this.createNode(r, graph);

		}

		// END EXCPERIMENTALLLL

		// IMPORTANT------------------------------------------------------
		/*
		 * for (EObject r : flatTree) { if(!(r instanceof IFolder || r instanceof
		 * IDiagramModel || r instanceof DiagramModelArchimateObject || r instanceof
		 * DiagramModelBendpoint || r instanceof DiagramModelArchimateConnection || r
		 * instanceof DiagramModelNote || r instanceof DiagramModelReference || r
		 * instanceof Bounds || r instanceof IArchimateRelationship || r instanceof
		 * ArchimateModel)) this.createNode(r, graph); }
		 */

		// END IMPORTANT------------------------------------------------------

		// -----------------------------------------------------------------
		// iterate through all folders
		/*
		 * for(IFolder folder : model.getFolders()) { this.createSubgraph(folder,
		 * graph); }
		 */

		// iterate through all diagrams
		/*
		 * for(IDiagramModel model : model.getDiagramModels()) {
		 * this.createSubgraph(model, graph); }
		 */
		// IViewpoint

		graphml.getGraphs().add(graph);

		System.out.println("nodes added");

		DiagramModelReference a;

		// as expected this is slow!
		System.out.println("adding edges started");
		for (EObject r : flatTree) {
			this.createDotReferences(r, graph);
		}

		System.out.println("edges added");
	}

	protected void addDiagramObjectContent(DiagramModelArchimateObject diagObj, List<EObject> list) {

		if (!(diagObj.getArchimateElement() instanceof ArchimateModel))
			list.add(diagObj.getArchimateElement());

		EList<IDiagramModelObject> additionalObjs = diagObj.getChildren();
		for (IDiagramModelObject r : additionalObjs) {
			if (r instanceof DiagramModelArchimateObject) {
				this.addDiagramObjectContent((DiagramModelArchimateObject) r, list);
			}
		}
	}

	protected void createSubgraph(IFolder folder, Graph graph) {

		// Create node
		Node n = graphFactory.createNode();
		n.setId(getObjectID(folder));
		n.setName(folder.eClass().getName());

		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(folder.eClass().getName());
		n.getDataAttributes().add(dataClassName);

		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(this.labelBeutify(folder.toString()));
		n.getDataAttributes().add(dataClassLabel);

		// create graph
		// ---------------------------------------
		Graph graphFolder = graphFactory.createGraph();
		graphFolder.setId("g_" + this.getObjectID(folder));

		for (IFolder subfolder : folder.getFolders()) {
			this.createSubgraph(subfolder, graphFolder);
		}

		// add all content that is in folder to graph
		List<EObject> flatTreeFolder = new LinkedList<>();
		TreeIterator<EObject> it = folder.eAllContents();
		while (it.hasNext()) {
			flatTreeFolder.add(it.next());
		}

		for (EObject r : flatTreeFolder) {
			if (!(r instanceof IFolder || r instanceof IDiagramModel || r instanceof DiagramModelArchimateObject
					|| r instanceof DiagramModelBendpoint || r instanceof DiagramModelArchimateConnection
					|| r instanceof DiagramModelNote || r instanceof DiagramModelReference || r instanceof Bounds))
				this.createNode(r, graphFolder);
		}
		// -------------------------------------------

		n.setGraph(graphFolder);

		graph.getNodes().add(n);

		// for performance improvement
		nodesMap.put(n.getId(), n);
	}

	protected void createSubgraph(IDiagramModel model, Graph graph) {

		// Create node
		Node n = graphFactory.createNode();
		n.setId(getObjectID(model));
		n.setName(model.eClass().getName());

		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(model.eClass().getName());
		n.getDataAttributes().add(dataClassName);

		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(this.labelBeutify(model.toString()));
		n.getDataAttributes().add(dataClassLabel);

		// create graph
		// ---------------------------------------
		Graph graphFolder = graphFactory.createGraph();
		graphFolder.setId("g_" + this.getObjectID(model));

		// add all content that is in folder to graph
		List<EObject> flatTreeFolder = new LinkedList<>();
		TreeIterator<EObject> it = model.eAllContents();
		while (it.hasNext()) {
			flatTreeFolder.add(it.next());
		}

		for (EObject r : flatTreeFolder) {
			if (!(r instanceof IFolder || r instanceof IDiagramModel || r instanceof DiagramModelArchimateObject
					|| r instanceof DiagramModelBendpoint || r instanceof DiagramModelArchimateConnection
					|| r instanceof DiagramModelNote || r instanceof DiagramModelReference || r instanceof Bounds))
				this.createNode(r, graphFolder);
		}
		// -------------------------------------------

		n.setGraph(graphFolder);

		graph.getNodes().add(n);

		// for performance improvement
		nodesMap.put(n.getId(), n);
	}

	@Override
	protected void createDotReference(EObject source, EObject target, EReference ref, Graph graph) {
		String style;
		if (ref.isContainment())
			style = "style=\"bold\"";
		else {
			style = "color=\"grey\"";
		}

		Edge edge = graphFactory.createEdge();
		edge.setId(getObjectID(ref));
		// edge.setName(ref.eClass().getName());

		String label = "";
		// set source
		if (source instanceof IArchimateRelationship) {
			label = source.eClass().getName();

			edge.setName(((INameable) source).getName());
			edge.setSource(
					(ConnectableElement) getObjectById(getObjectID(((IArchimateRelationship) source).getTarget())));
		} else {
			edge.setName(ref.eClass().getName());
			edge.setSource((ConnectableElement) getObjectById(getObjectID(source)));
		}

		// set target
		if (target instanceof IArchimateRelationship) {
			label = source.eClass().getName();

			edge.setName(((INameable) target).getName());
			edge.setTarget(
					(ConnectableElement) getObjectById(getObjectID(((IArchimateRelationship) target).getTarget())));
		} else {
			edge.setName(ref.eClass().getName());
			edge.setTarget((ConnectableElement) getObjectById(getObjectID(target)));
		}

		Data dataReferenceName = graphFactory.createData();
		dataReferenceName.setKey("ReferenceName");
		dataReferenceName.setValue(ref.getName());

		edge.getDataAttributes().add(dataReferenceName);

		Data dataReferenceLabel = graphFactory.createData();
		dataReferenceLabel.setKey("Label");
		dataReferenceLabel.setValue(this.labelBeutify(label));
		// dataReferenceLabel.setValue(this.labelBeutify(ref.getName()) );
		edge.getDataAttributes().add(dataReferenceLabel);

		if (edge.getSource() != edge.getTarget())
			graph.getEdges().add(edge);
	}
}
