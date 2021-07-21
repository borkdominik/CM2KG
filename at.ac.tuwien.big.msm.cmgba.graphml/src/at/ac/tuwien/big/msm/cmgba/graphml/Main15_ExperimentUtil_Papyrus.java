package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.IOException;

public class Main15_ExperimentUtil_Papyrus {
	public static void main(String[] args){
		ExperimentUtility util = new ExperimentUtility();
		
		try {
			util.transformPapyrusModels("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\PapyrusUML\\ManyModels2\\cdmodels");
			
			util.analyzeForUMLSmells("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\PapyrusUML\\ManyModels2\\cdmodels\\transformed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
