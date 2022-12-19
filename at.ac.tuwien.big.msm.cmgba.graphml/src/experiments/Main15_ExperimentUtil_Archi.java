package experiments;

import java.io.IOException;

import utilities.ExperimentUtility;

public class Main15_ExperimentUtil_Archi {
	public static void main(String[] args) {
		ExperimentUtility util = new ExperimentUtility();

		try {

			util.analyzeForEaSmells(
					"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\T_R_G\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format\\transformed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
