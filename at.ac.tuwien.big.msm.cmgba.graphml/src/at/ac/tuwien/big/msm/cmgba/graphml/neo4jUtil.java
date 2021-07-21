package at.ac.tuwien.big.msm.cmgba.graphml;

import static org.neo4j.driver.Values.parameters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.cypher.internal.plandescription.Arguments.Rows;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

public class neo4jUtil implements AutoCloseable {
	private Driver driver;
	private String uri = "bolt://localhost:7687";
	private String user = "neo4j";
	private String password = "admin";

	public neo4jUtil() {
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		loadSmellQueries();
	}

	@Override
	public void close() throws Exception {
		driver.close();
	}

	public void printGreeting(final String message) {
		try (Session session = driver.session()) {
			String greeting = session.writeTransaction(new TransactionWork<String>() {
				@Override
				public String execute(Transaction tx) {
					Result result = tx.run("CREATE (a:Greeting) " + "SET a.message = $message "
							+ "RETURN a.message + ', from node ' + id(a)", parameters("message", message));
					return result.single().get(0).asString();
				}
			});
			System.out.println(greeting);
		}
	}

	public String executeQuery(final String query) {
		try (Session session = driver.session()) {
			String result = session.writeTransaction(new TransactionWork<String>() {
				@Override
				public String execute(Transaction tx) {
					Result result = tx.run(query);

					String rows = "";
					while ( result.hasNext() )
				    {
				        org.neo4j.driver.Record rec = result.next();
				        Map<String,Object> row = rec.asMap();
				        for ( Entry<String,Object> column : row.entrySet() )
				        {
				            rows += column.getKey() + ": " + column.getValue() + "; ";
				        }
				        rows += "\n";
				    }

					return rows;
					
					//return result.toString();
					// return result.single().get( 0 ).asString();
				}
			});
			//System.out.println(result);
			return result;
		}

	}

	
	
	private static String deleteAllNodes = "MATCH (n)\r\n" + "DETACH DELETE n";
	private String importGraphmlFile = "";
	private static String setNodeLabels = "MATCH (n)\r\n" + "CALL apoc.create.addLabels( id(n), [ n.ClassName ] )\r\n"
			+ "YIELD node\r\n" + "RETURN node";
	private static String setRelationshipLabels = "MATCH (f)-[rel]->(b)\r\n"
			+ "CALL apoc.refactor.setType(rel, rel.Label)\r\n" + "YIELD input, output\r\n" + "RETURN input, output";
	private static String getAllNodes = "Match (n)-[r]->(m)\r\n" + "Return n,r,m";

	public void neo4jGraphmlImport(String graphPath) throws UnsupportedEncodingException {

		// String thePath = "";
		// thePath = URLEncoder.encode(graphPath, "UTF-8");
		importGraphmlFile = "CALL apoc.import.graphml(\"" + graphPath.replaceAll(" ", "%20")
				+ "\", {storeNodeIds: true})";
		this.initializeGraph();
	}

	public void initializeGraph() {
		this.executeQuery(deleteAllNodes);
		this.executeQuery(importGraphmlFile);
		this.executeQuery(setNodeLabels);
		this.executeQuery(setRelationshipLabels);
	}

	public String CHATTY_SERVICE_QUERY = "";
	public String CYCLIC_DEPENDENCY_QUERY = "";
	public String DATA_SERVICE_QUERY = "";
	public String DEAD_COMPONENT_QUERY = "";
	public String DENSE_STRUCTURE_QUERY = "";
	public String MESSAGE_CHAIN_QUERY = "";
	public String SHARED_PERSISTENCY_QUERY = "";
	public String STRICT_LAYER_VIOLATION_QUERY = "";
	
	private String uml_CyclicDependency;
	public String getUml_CyclicDependency() {
		return uml_CyclicDependency;
	}

	public String getUml_DeepHierarcy() {
		return uml_DeepHierarcy;
	}

	public String getUml_MessageChain() {
		return uml_MessageChain;
	}

	public String getUml_MultipathHierarcy() {
		return uml_MultipathHierarcy;
	}

	public String getUml_UnutilizedAbstraction() {
		return uml_UnutilizedAbstraction;
	}



	private String uml_DeepHierarcy;
	private String uml_MessageChain;
	private String uml_MultipathHierarcy;
	private String uml_UnutilizedAbstraction;

	public String getCHATTY_SERVICE_QUERY() {
		return CHATTY_SERVICE_QUERY;
	}

	public String getCYCLIC_DEPENDENCY_QUERY() {
		return CYCLIC_DEPENDENCY_QUERY;
	}

	public String getDATA_SERVICE_QUERY() {
		return DATA_SERVICE_QUERY;
	}

	public String getDEAD_COMPONENT_QUERY() {
		return DEAD_COMPONENT_QUERY;
	}

	public String getDENSE_STRUCTURE_QUERY() {
		return DENSE_STRUCTURE_QUERY;
	}

	public String getMESSAGE_CHAIN_QUERY() {
		return MESSAGE_CHAIN_QUERY;
	}

	public String getSHARED_PERSISTENCY_QUERY() {
		return SHARED_PERSISTENCY_QUERY;
	}

	public String getSTRICT_LAYER_VIOLATION_QUERY() {
		return STRICT_LAYER_VIOLATION_QUERY;
	}

	private void loadSmellQueries() {
		try {
			CHATTY_SERVICE_QUERY = Files.readString(Path.of("smellQueries/ChattyService.neo4j"));
			CYCLIC_DEPENDENCY_QUERY = Files.readString(Path.of("smellQueries/CyclicDependency.neo4j"));
			DATA_SERVICE_QUERY = Files.readString(Path.of("smellQueries/DataService.neo4j"));
			DEAD_COMPONENT_QUERY = Files.readString(Path.of("smellQueries/DeadComponent.neo4j"));
			DENSE_STRUCTURE_QUERY = Files.readString(Path.of("smellQueries/DenseStructure.neo4j"));
			MESSAGE_CHAIN_QUERY = Files.readString(Path.of("smellQueries/MessageChain.neo4j"));
			SHARED_PERSISTENCY_QUERY = Files.readString(Path.of("smellQueries/SharedPersistency.neo4j"));
			STRICT_LAYER_VIOLATION_QUERY = Files.readString(Path.of("smellQueries/StrictLayersViolation.neo4j"));
			
			
			
			uml_CyclicDependency = Files.readString(Path.of("smellQueries/uml_CyclicDependency.neo4j"));
			uml_DeepHierarcy = Files.readString(Path.of("smellQueries/uml_DeepHierarcy.neo4j"));
			uml_MessageChain = Files.readString(Path.of("smellQueries/uml_MessageChain.neo4j"));
			uml_MultipathHierarcy = Files.readString(Path.of("smellQueries/uml_MultipathHierarcy.neo4j"));
			uml_UnutilizedAbstraction = Files.readString(Path.of("smellQueries/uml_UnutilizedAbstraction.neo4j"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
