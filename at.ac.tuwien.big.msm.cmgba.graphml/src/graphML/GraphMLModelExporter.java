package graphML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import at.ac.tuwien.big.msm.cmgba.graphml.Data;
import at.ac.tuwien.big.msm.cmgba.graphml.Edge;
import at.ac.tuwien.big.msm.cmgba.graphml.Graph;
import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import at.ac.tuwien.big.msm.cmgba.graphml.Node;

public class GraphMLModelExporter {
	private GraphML graph;
	private StringBuilder graphXMLBegining = null;
	private StringBuilder graphXML = null;
	private StringBuilder dataKeysXML = null;
	private HashMap<String, String> dataKeys = null;

	public GraphMLModelExporter(GraphML graph) {
		this.graph = graph;
		graphXMLBegining = new StringBuilder();

		graphXML = new StringBuilder();
		dataKeysXML = new StringBuilder();
		dataKeys = new HashMap<>();
	}

	public void exportGraph(String filename) throws IOException {
		this.buildGraphXML();

		File file = new File(filename);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(graphXML.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}

	}

	public void exportGraph() throws IOException {
		this.buildGraphXML();
	}

	public String getGraphXML() {
		return this.graphXML.toString();
	}

	public File getFile() throws IOException {

		File file = new File("output.graphml");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(graphXML.toString());

			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	public File saveFile(String filename) throws IOException {

		File file = new File(filename);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(graphXML.toString());

			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (writer != null)
				writer.close();
		}
	}

	private void buildGraphXML() {
		this.graphXMLBegining.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \r\n");

		this.graphXMLBegining.append("<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" \r\n"
				+ "xmlns:java=\"http://www.yworks.com/xml/yfiles-common/1.0/java\" \r\n"
				+ "xmlns:sys=\"http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0\" \r\n"
				+ "xmlns:x=\"http://www.yworks.com/xml/yfiles-common/markup/2.0\" \r\n"
				+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \r\n"
				+ "xmlns:y=\"http://www.yworks.com/xml/graphml\" \r\n"
				+ "xmlns:yed=\"http://www.yworks.com/xml/yed/3\" \r\n"
				+ "xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd\">  \r\n"

				+ "  <key attr.name=\"Description\" attr.type=\"string\" for=\"graph\" id=\"d0\"/>\r\n"
				+ "  <key for=\"port\" id=\"d1\" yfiles.type=\"portgraphics\"/>\r\n"
				+ "  <key for=\"port\" id=\"d2\" yfiles.type=\"portgeometry\"/>\r\n"
				+ "  <key for=\"port\" id=\"d3\" yfiles.type=\"portuserdata\"/>\r\n"
				+ "  <key attr.name=\"url\" attr.type=\"string\" for=\"node\" id=\"d4\"/>\r\n"
				+ "  <key attr.name=\"description\" attr.type=\"string\" for=\"node\" id=\"d5\"/>\r\n"
				+ "  <key for=\"node\" id=\"d6\" yfiles.type=\"nodegraphics\"/>\r\n"
				+ "  <key for=\"graphml\" id=\"d7\" yfiles.type=\"resources\"/>\r\n"
				+ "  <key attr.name=\"url\" attr.type=\"string\" for=\"edge\" id=\"d8\"/>\r\n"
				+ "  <key attr.name=\"description\" attr.type=\"string\" for=\"edge\" id=\"d9\"/>\r\n"
				+ "  <key for=\"edge\" id=\"d10\" yfiles.type=\"edgegraphics\"/> \r\n");

		for (Graph g : graph.getGraphs()) {
			this.addGraph(g);
		}
		this.graphXML.append("</graphml> \r\n");

		this.graphXMLBegining.append(dataKeysXML);
		this.graphXMLBegining.append(graphXML);

		graphXML = graphXMLBegining;
	}

	private void addGraph(Graph g) {
		// open graph
		this.graphXML.append("<graph id=\"" + g.getId() + "\" edgedefault=\"directed\"> \r\n");

		// iterate all node elements
		for (Node n : g.getNodes()) {
			this.addNode(n);
		}

		// iterate all edge elements
		for (Edge e : g.getEdges()) {
			this.addEdge(e);
		}

		// close graph
		this.graphXML.append("</graph> \r\n");
	}

	private void addNode(Node n) {
		// open node
		this.graphXML.append("<node id=\"" + n.getId() + "\"> \r\n");

		// check if node has subgraph
		if (n.getGraph() != null) {
			this.addGraph(n.getGraph());
		}

		// iterate all attributes
		for (Data d : n.getDataAttributes()) {
			this.addDataKey(d, n);
			// this.addDataAttribute(d);
		}

		// close node
		this.graphXML.append("</node> \r\n");
	}

	private void addEdge(Edge e) {
		// open edge

		if (e.getSource() == null || e.getTarget() == null) {
			return;
		}

		this.graphXML.append(
				"<edge source=\"" + e.getSource().getId() + "\" target=\"" + e.getTarget().getId() + "\"> \r\n");

		// iterate all attributes
		for (Data d : e.getDataAttributes()) {
			this.addDataKey(d, e);
			// this.addDataAttribute(d);
		}

		// close edge
		this.graphXML.append("</edge> \r\n");
	}

	private void addDataAttribute(String key, Data d) {
		// this.graphXML.append("<data key=\""+key+"\">"+d.getValue()+"</data> \r\n");

		if (key.equals("Label")) {
			this.graphXML.append("<data key=\"" + key + "\">" + d.getValue() + "</data> \r\n");
			this.graphXML.append("<data key=\"d6\">\r\n" + "        <y:ShapeNode>\r\n"
					+ "          <y:Geometry height=\"30.0\" width=\"30.0\" x=\"746.6867968000003\" y=\"-12.487705599997412\"/>\r\n"
					+ "          <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n"
					+ "          <y:BorderStyle color=\"#000000\" raised=\"false\" type=\"line\" width=\"1.0\"/>\r\n"
					+ "          <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" horizontalTextPosition=\"center\" iconTextGap=\"4\" modelName=\"custom\" textColor=\"#000000\" verticalTextPosition=\"bottom\" visible=\"true\" width=\"40.703125\" x=\"-5.3515625\" y=\"5.6494140625\">"
					+ d.getValue() + "<y:LabelModel>\r\n"
					+ "              <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" + "            </y:LabelModel>\r\n"
					+ "            <y:ModelParameter>\r\n"
					+ "              <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n"
					+ "            </y:ModelParameter>\r\n" + "          </y:NodeLabel>\r\n"
					+ "          <y:Shape type=\"rectangle\"/>\r\n" + "        </y:ShapeNode>\r\n"
					+ "      </data> \r\n");
		} else {
			this.graphXML.append("<data key=\"" + key + "\">" + d.getValue() + "</data> \r\n");
		}

	}

	private void addDataKey(Data d, Edge e) {
		// String keyName = e.getName()+"_"+d.getKey();
		String keyName = d.getKey().replace(".", "_").replace(":", "_");
		if (d.getKey().equals("ClassName") || d.getKey().equals("Label"))
			keyName = d.getKey();

		if (dataKeys.get(keyName) == null) {
			dataKeys.put(keyName, keyName);
			this.dataKeysXML.append("<key id=\"" + keyName + "\" for=\"edge\" attr.name=\"" + keyName
					+ "\" attr.type=\"string\"/> \r\n");
		}

		this.addDataAttribute(keyName, d);
	}

	private void addDataKey(Data d, Node n) {
		// String keyName = n.getName()+"_"+d.getKey();
		String keyName = d.getKey().replace(".", "_").replace(":", "_");
		if (d.getKey().equals("ClassName") || d.getKey().equals("Label"))
			keyName = d.getKey();

		if (dataKeys.get(keyName) == null) {
			dataKeys.put(keyName, keyName);
			this.dataKeysXML.append("<key id=\"" + keyName + "\" for=\"node\" attr.name=\"" + keyName
					+ "\" attr.type=\"string\"/> \r\n");
		}

		this.addDataAttribute(keyName, d);
	}
}
