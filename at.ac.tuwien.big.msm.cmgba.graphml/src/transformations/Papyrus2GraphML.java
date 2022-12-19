package transformations;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.msm.cmgba.graphml.Data;
import at.ac.tuwien.big.msm.cmgba.graphml.Graph;
import at.ac.tuwien.big.msm.cmgba.graphml.Node;

public class Papyrus2GraphML extends Ecore2GraphML {
	public Papyrus2GraphML(EObject root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createNode(EObject e, Graph graph) {

		String cname = e.eClass().getName();
		// if (!e.eClass().getName().equals("Class"))
		// return;

		Node n = graphFactory.createNode();
		n.setId(getObjectID(e));
		n.setName(e.eClass().getName());

		Data dataClassName = graphFactory.createData();
		dataClassName.setKey("ClassName");
		dataClassName.setValue(e.eClass().getName());

		n.getDataAttributes().add(dataClassName);

		Data dataClassLabel = graphFactory.createData();
		dataClassLabel.setKey("Label");
		dataClassLabel.setValue(this.labelBeutify(e.toString()));

		List<EAttribute> attributes = e.eClass().getEAllAttributes();
		for (int i = 0; i < attributes.size(); i++) {
			EAttribute attribute = attributes.get(i);
			if (attribute.isID()) {
				// Skip the id
				continue;
			}

			if (attribute.getName().equals("anyAttribute"))
				dataClassLabel.setValue(e.eGet(attribute).toString().replaceAll("&", "and"));

			Data data = graphFactory.createData();
			data.setKey(attribute.getName());
			if (e.eGet(attribute) != null)
				data.setValue(e.eGet(attribute).toString().replaceAll("&", "and"));

			n.getDataAttributes().add(data);
		}

		n.getDataAttributes().add(dataClassLabel);

		graph.getNodes().add(n);
		// for performance improvement
		nodesMap.put(n.getId(), n);

	}
}
