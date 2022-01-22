package de.example.Experiment;

import java.io.IOException;


public class ExperimentUtil_Archi {
	public static void main(String[] args){
		ExperimentUtility util = new ExperimentUtility();
		
		try {
			util.analyzeForEaSmells("C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\CM2KGThesis\\Experiments\\EMF\\Archi\\ManyModels\\repo-github-archimate\\models\\OpenGroup Format");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("exception in main.. failed analysis");
			e.printStackTrace();
		}
	}	
}
