package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class OwlUtility {
	File modelFile;
	File outputFile;
	Process mProcess;

	public void setFile(File file) {
		modelFile = file;
	}

	public void transformToOwl(String filename) {
		try {

			System.out.println("current directory");
			this.runScript(new String[] {"..\\graphml2rdf-master\\currentdirectory.bat"});
			
			System.out.println("python script");
			this.runScript(new String[] {"python", "..\\graphml2rdf-master\\graphml2owl.py", filename});
			System.out.println("python executed");
			
			
			System.out.println("executed");
			//outputFile = modelExporter.saveFile(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	public void transformToRdf(String filename) {
		try {
			System.out.println("current directory");
			this.runScript(new String[] {"..\\graphml2rdf-master\\currentdirectory.bat"});
			
			System.out.println("java transformation");
			
			//this.runScript(new String[] {"C:\\Program Files\\Java\\jdk-16.0.2\\bin\\java.exe -jar saxon9he.jar"});
			
			String cmd = "\"C:\\Program Files\\Java\\jdk-16.0.2\\bin\\java\" -jar ..\\graphml2rdf-master\\saxon9he.jar -xsl:\"..\\graphml2rdf-master\\graphml2rdf.xsl\" " +"\""+  filename +"\"" + " > " +"\""+ filename+".rdf"+"\"";
			System.out.println(cmd);
			this.runScript(new String[] {cmd });
			System.out.println("java executed");
			
			System.out.println("executed");
			//outputFile = modelExporter.saveFile(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	public File getFile() {
		return outputFile;
	}
	
	public void runScript(String[] commands) throws Exception{
	       Process process;
	       try{
	             process = Runtime.getRuntime().exec(commands);
	             mProcess = process;
	       }catch(Exception e) {
	          System.out.println("Exception Raised" + e.toString());
	          throw e;
	       }
	       InputStream stdout = mProcess.getInputStream();
	       BufferedReader reader = new BufferedReader(new InputStreamReader(stdout,StandardCharsets.UTF_8));
	       String line;
	       try{
	          while((line = reader.readLine()) != null){
	               System.out.println("stdout: "+ line);
	          }
	       }catch(IOException e){
	             System.out.println("Exception in reading output"+ e.toString());
	       }
	}
}
