package experiments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main15_ExperimentUtil_Papyrus_CopyFiles {
	public static void main(String[] args) throws IOException {

		// Open the file
		FileInputStream fstream = new FileInputStream(
				"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\PapyrusUML\\ManyModels2\\uml_models_cd.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console

			File src = new File("C:\\Users\\Muhamed Smajevic\\Downloads\\repo-genmymodel-uml\\data\\" + strLine);
			File dst = new File(
					"C:\\Users\\Muhamed Smajevic\\Documents\\GitHub\\Smajevic.Metamodel2Graph\\Experiments\\PapyrusUML\\ManyModels2\\cdmodels\\"
							+ strLine);

			Files.copy(src.toPath(), dst.toPath(), StandardCopyOption.REPLACE_EXISTING);

			System.out.println(strLine);
		}

		// Close the input stream
		fstream.close();
	}
}
