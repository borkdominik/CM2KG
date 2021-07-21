package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.IOException;

public class Main15_ExperimentUtil {
	public static void main(String[] args){
		ExperimentUtility util = new ExperimentUtility();
		
		try {
			util.transformArchiModels("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format");
			
			util.analyzeForEaSmells("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format\\transformed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
