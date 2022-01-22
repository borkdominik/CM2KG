package graphDb;

public class neo4jGraphmlImport {

	private neo4jConnector connector = new neo4jConnector();

	private static String deleteAllNodes = "MATCH (n)\r\n" + "DETACH DELETE n";
	private String importGraphmlFile = "CALL apoc.import.graphml(\"http://localhost:8080/repository/graph/b2715d3a-9158-439b-8a2b-873089dd38d9\", {})";
	private static String setNodeLabels = "MATCH (n)\r\n" + "CALL apoc.create.addLabels( id(n), [ n.ClassName ] )\r\n"
			+ "YIELD node\r\n" + "RETURN node";
	private static String setRelationshipLabels = "MATCH (f)-[rel]->(b)\r\n"
			+ "CALL apoc.refactor.setType(rel, rel.Label)\r\n" + "YIELD input, output\r\n" + "RETURN input, output";
	private static String getAllNodes = "Match (n)-[r]->(m), (a)\r\n" + "where not (a)--() Return n,r,m,a";

	public neo4jGraphmlImport(String graphUid) {
		importGraphmlFile = "CALL apoc.import.graphml(\"http://localhost:8080/repository/graph/" + graphUid
				+ "\", {storeNodeIds: true})";
	}

	public void initializeGraph() {
		connector.executeQuery(deleteAllNodes);
		connector.executeQuery(importGraphmlFile);
		connector.executeQuery(setNodeLabels);
		connector.executeQuery(setRelationshipLabels);
	}

}
