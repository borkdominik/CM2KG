package neo4j;

import java.nio.file.Path;

import org.neo4j.configuration.connectors.BoltConnector;
import org.neo4j.configuration.helpers.SocketAddress;
import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import static org.neo4j.driver.Values.parameters;

public class neo4jConnector implements AutoCloseable {

	private Driver driver;
	private String uri = "bolt://localhost:7687";
	private String user = "neo4j";
	private String password = "admin";
	 
	public neo4jConnector() {
		driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
	}
	
	@Override
    public void close() throws Exception
    {
        driver.close();
    }
	
	public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                                     "SET a.message = $message " +
                                                     "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }
	
	public void executeQuery( final String query )
    {
        try ( Session session = driver.session() )
        {
            String result = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run(query);
                    
                    return "";
                    //return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( result );
        }
    }
	
}
