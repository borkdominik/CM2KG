package experiments;

import java.io.IOException;

import utilities.ExperimentUtility;

public class Main15_ExperimentUtil_Archi_SingleModel {
	public static void main(String[] args) {
		ExperimentUtility util = new ExperimentUtility();

		try {
			long startTime = System.nanoTime();
			long stopTime = System.nanoTime();
			
			startTime = System.nanoTime();
			util.analyzeForOneEaSmells(
					"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\T_R_G\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format\\transformedSingleModel");
			stopTime = System.nanoTime();
			String sml1_time = String.valueOf(stopTime - startTime);
			System.out.println("execution time: "+sml1_time);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
