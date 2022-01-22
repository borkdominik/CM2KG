package experiments;

import java.io.IOException;

import utilities.ExperimentUtility;

public class Main15_ExperimentUtil_Papyrus {
	public static void main(String[] args) {
		ExperimentUtility util = new ExperimentUtility();

		try {
			util.transformPapyrusModels(
					"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\CM2KG\\Experiments\\PapyrusUML\\ManyModels2\\cdmodels");

			util.analyzeForUMLSmells(
					"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\CM2KG\\Experiments\\PapyrusUML\\ManyModels2\\cdmodels\\transformed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
