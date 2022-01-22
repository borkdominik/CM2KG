package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;

public class ExperimentUtility {
	// File modelFile;
	// File outputFile;
	// String graphXML;

	neo4jUtil neo4jUtil;
	Path transformedFolder;

	public ExperimentUtility() {
		neo4jUtil = new neo4jUtil();
	}

	// transform all files in folder
	public void transformArchiModels(String directoryPath) throws IOException {

		transformedFolder = Files.createDirectories(Paths.get(directoryPath, "transformed"));
		// System.out.println("transformedFolder: "+transformedFolder);

		List<String[]> csvData = new ArrayList<>();
		String[] header = { "filename", "transformation_time_ns" };
		csvData.add(header);

		long startTime = System.nanoTime();
		long stopTime = System.nanoTime();

		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child

				if (child.getName().equals("analysis.csv"))
					continue;

				try {
					System.out.println("file: " + child.getName());

					startTime = System.nanoTime();
					ArchiUtility archiUtil = new ArchiUtility();
					archiUtil.setFile(child);
					String filename = transformedFolder + "\\" + child.getName().replaceFirst("[.][^.]+$", "")
							+ "_transformed.graphml";

					// System.out.println("export file: "+filename);
					archiUtil.transform(filename);
					stopTime = System.nanoTime();

					String transformation_time = String.valueOf(stopTime - startTime);
					String[] record1 = { child.getName(), transformation_time, };
					csvData.add(record1);
				} catch (Exception e) {
					System.out.println("transformation failed: " + child.getName());
				}
			}

			try (CSVWriter writer = new CSVWriter(
					new FileWriter(transformedFolder + "\\analysis_transformation_time.csv"))) {
				writer.writeAll(csvData);
			}
			System.out.println("\n");
			System.out
					.println("adding transformation file: " + transformedFolder + "\\analysis_transformation_time.csv");

		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

		System.out.println("\n");
		System.out.println("Transformation finished.");
	}

	// transform all files in folder
	public void transformPapyrusModels(String directoryPath) throws IOException {

		transformedFolder = Files.createDirectories(Paths.get(directoryPath, "transformed"));
		// System.out.println("transformedFolder: "+transformedFolder);

		List<String[]> csvData = new ArrayList<>();
		String[] header = { "filename", "transformation_time_ns" };
		csvData.add(header);

		long startTime = System.nanoTime();
		long stopTime = System.nanoTime();

		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child

				if (child.getName().equals("analysis.csv")
						|| child.getName().equals("analysis_transformation_time.csv"))
					continue;

				try {
					System.out.println("file: " + child.getName());

					startTime = System.nanoTime();
					PapyrusUMLUtility papyrusUtil = new PapyrusUMLUtility();
					papyrusUtil.setFile(child);
					String filename = transformedFolder + "\\" + child.getName().replaceFirst("[.][^.]+$", "")
							+ "_transformed.graphml";

					// System.out.println("export file: "+filename);
					papyrusUtil.transform(filename);
					stopTime = System.nanoTime();

					String transformation_time = String.valueOf(stopTime - startTime);
					String[] record1 = { child.getName(), transformation_time, };
					csvData.add(record1);

				} catch (Exception e) {
					System.out.println("transformation failed: " + child.getName());
				}

				try (CSVWriter writer = new CSVWriter(
						new FileWriter(transformedFolder + "\\analysis_transformation_time.csv"))) {
					writer.writeAll(csvData);
				}
				System.out.println("\n");
				System.out.println("adding transformation analysis file: " + transformedFolder
						+ "\\analysis_transformation_time.csv");

			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
	}

	public void analyzeForEaSmells(String directoryPath) throws IOException {

		transformedFolder = Paths.get(directoryPath);

		List<String[]> csvData = new ArrayList<>();
		String[] header = { "filename", "failed_anlysis", "CHATTY_SERVICE", "CYCLIC_DEPENDENCY", "DATA_SERVICE",
				"DEAD_COMPONENT", "DENSE_STRUCTURE", "MESSAGE_CHAIN", "SHARED_PERSISTENCY", "STRICT_LAYER_VIOLATION",
				"DUPLICATION", "HUB_LIKE_MODULARIZATION", "WEAKEND_MODULARITY", "DOCUMENTATION", "LAZY_COMPONENT",

				"CHATTY_SERVICE_ns", "CYCLIC_DEPENDENCY_ns", "DATA_SERVICE_ns", "DEAD_COMPONENT_ns",
				"DENSE_STRUCTURE_ns", "MESSAGE_CHAIN_ns", "SHARED_PERSISTENCY_ns", "STRICT_LAYER_VIOLATION_ns",
				"DUPLICATION_ns", "HUB_LIKE_MODULARIZATION_ns", "WEAKEND_MODULARITY_ns", "DOCUMENTATION_ns",
				"LAZY_COMPONENT_ns",

				"nodes", "edges", "file_size_bytes" };
		csvData.add(header);

		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {

				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();
				try {
					// Do something with child
					if (child.getName().equals("analysis.csv")
							|| child.getName().equals("analysis_transformation_time.csv"))
						continue;

					File tmpDest = new File(
							"C:\\Users\\Muhamed Smajevic\\AppData\\Local\\Neo4j\\Relate\\Data\\dbmss\\dbms-b0c4430f-501b-49ce-b378-58ef01f04900\\import\\"
									+ child.getName());
					Files.copy(child.toPath(), tmpDest.toPath(), StandardCopyOption.REPLACE_EXISTING);

					System.out.println("graph import name: " + child.getName());
					neo4jUtil.neo4jGraphmlImport(child.getName());

					startTime = System.nanoTime();
					System.out.println("getCHATTY_SERVICE_QUERY: ");
					String sml1 = neo4jUtil.executeQuery(neo4jUtil.getCHATTY_SERVICE_QUERY());
					stopTime = System.nanoTime();
					String sml1_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getCYCLIC_DEPENDENCY_QUERY: ");
					String sml2 = neo4jUtil.executeQuery(neo4jUtil.getCYCLIC_DEPENDENCY_QUERY());
					stopTime = System.nanoTime();
					String sml2_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getDATA_SERVICE_QUERY: ");
					String sml3 = neo4jUtil.executeQuery(neo4jUtil.getDATA_SERVICE_QUERY());
					stopTime = System.nanoTime();
					String sml3_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getDEAD_COMPONENT_QUERY: ");
					String sml4 = neo4jUtil.executeQuery(neo4jUtil.getDEAD_COMPONENT_QUERY());
					stopTime = System.nanoTime();
					String sml4_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getDENSE_STRUCTURE_QUERY: ");
					String sml5 = neo4jUtil.executeQuery(neo4jUtil.getDENSE_STRUCTURE_QUERY());
					System.out.println(sml5);
					stopTime = System.nanoTime();
					String sml5_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getMESSAGE_CHAIN_QUERY: ");
					String sml6 = neo4jUtil.executeQuery(neo4jUtil.getMESSAGE_CHAIN_QUERY());
					stopTime = System.nanoTime();
					String sml6_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getSHARED_PERSISTENCY_QUERY: ");
					String sml7 = neo4jUtil.executeQuery(neo4jUtil.getSHARED_PERSISTENCY_QUERY());
					stopTime = System.nanoTime();
					String sml7_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getSTRICT_LAYER_VIOLATION_QUERY: ");
					String sml8 = neo4jUtil.executeQuery(neo4jUtil.getSTRICT_LAYER_VIOLATION_QUERY());
					stopTime = System.nanoTime();
					String sml8_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getEa_DUPLICATION_QUERY: ");
					String sml9 = neo4jUtil.executeQuery(neo4jUtil.getEa_DUPLICATION_QUERY());
					stopTime = System.nanoTime();
					String sml9_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getEa_HUB_LIKE_MODULARIZATION_QUERY: ");
					String sml10 = neo4jUtil.executeQuery(neo4jUtil.getEa_HUB_LIKE_MODULARIZATION_QUERY());
					stopTime = System.nanoTime();
					String sml10_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getEa_WEAKEND_MODULARITY_QUERY: ");
					String sml11 = neo4jUtil.executeQuery(neo4jUtil.getEa_WEAKEND_MODULARITY_QUERY());
					stopTime = System.nanoTime();
					String sml11_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getEa_DOCUMENTATION_QUERY: ");
					String sml12 = neo4jUtil.executeQuery(neo4jUtil.getEa_DOCUMENTATION_QUERY());
					stopTime = System.nanoTime();
					String sml12_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getEa_LAZY_COMPONENT_QUERY: ");
					String sml13 = neo4jUtil.executeQuery(neo4jUtil.getEa_LAZY_COMPONENT_QUERY());
					stopTime = System.nanoTime();
					String sml13_time = String.valueOf(stopTime - startTime);

					System.out.println("getNumberOfNodes: ");
					String numberOfNodes = neo4jUtil.executeQuery(neo4jUtil.getNumberOfNodes());

					System.out.println("getNumberOfNodes: ");
					String numberOfEdges = neo4jUtil.executeQuery(neo4jUtil.getNumberOfEdges());

					String[] record1 = { child.getName(), "0", String.valueOf(!sml1.isEmpty() ? 1 : 0),
							String.valueOf(!sml2.isEmpty() ? 1 : 0), String.valueOf(!sml3.isEmpty() ? 1 : 0),
							String.valueOf(!sml4.isEmpty() ? 1 : 0), sml5.replaceAll("[^0-9]", ""),
							String.valueOf(!sml6.isEmpty() ? 1 : 0), String.valueOf(!sml7.isEmpty() ? 1 : 0),
							String.valueOf(!sml8.isEmpty() ? 1 : 0), String.valueOf(!sml9.isEmpty() ? 1 : 0),
							String.valueOf(!sml10.isEmpty() ? 1 : 0), String.valueOf(!sml11.isEmpty() ? 1 : 0),
							String.valueOf(!sml12.isEmpty() ? 1 : 0), String.valueOf(!sml13.isEmpty() ? 1 : 0),

							sml1_time, sml2_time, sml3_time, sml4_time, sml5_time, sml6_time, sml7_time, sml8_time,
							sml9_time, sml10_time, sml11_time, sml12_time, sml13_time,

							numberOfNodes.replaceAll("[^0-9]", ""), numberOfEdges.replaceAll("[^0-9]", ""),
							String.valueOf(child.length()) };
					csvData.add(record1);
				} catch (Exception e) {
					System.out.println(e);

					// TODO: handle exception
					String[] record1 = { child.getName(), "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
							"0",

							"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",

							"0", "0", "0"

					};
					csvData.add(record1);
				}

			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

		try (CSVWriter writer = new CSVWriter(new FileWriter(transformedFolder + "\\analysis.csv"))) {
			writer.writeAll(csvData);
		}

		System.out.println("\n");
		System.out.println("Analysis finished.");
	}

	public void analyzeForUMLSmells(String directoryPath) throws IOException {
		List<String[]> csvData = new ArrayList<>();
		String[] header = { "filename", "failed_anlysis", "CYCLIC_DEPENDENCY", "CYCLIC_DEPENDENCY_time_ns",
				"MESSAGE_CHAIN", "MESSAGE_CHAIN_time_ns", "UNUTILIZED_ABSTRACTION", "UNUTILIZED_ABSTRACTION_time_ns",
				"DEEP_HIERARCY", "DEEP_HIERARCY_time_ns", "MULTIPATH_HIERARCY", "MULTIPATH_HIERARCY_time_ns", "nodes",
				"edges", "file_size_bytes" };
		csvData.add(header);

		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child

				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();

				try {
					if (child.getName().equals("analysis.csv")
							|| child.getName().equals("analysis_transformation_time.csv"))
						continue;

					File tmpDest = new File(
							"C:\\Users\\Muhamed Smajevic\\AppData\\Local\\Neo4j\\Relate\\Data\\dbmss\\dbms-b0c4430f-501b-49ce-b378-58ef01f04900\\import\\"
									+ child.getName());
					Files.copy(child.toPath(), tmpDest.toPath(), StandardCopyOption.REPLACE_EXISTING);

					System.out.println("graph import name: " + child.getName());
					neo4jUtil.neo4jGraphmlImport(child.getName());

					startTime = System.nanoTime();
					System.out.println("getUml_CyclicDependency: ");
					String sml1 = neo4jUtil.executeQuery(neo4jUtil.getUml_CyclicDependency());
					stopTime = System.nanoTime();
					String sml1_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getUml_MessageChain: ");
					String sml2 = neo4jUtil.executeQuery(neo4jUtil.getUml_MessageChain());
					stopTime = System.nanoTime();
					String sml2_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getUml_UnutilizedAbstraction: ");
					String sml3 = neo4jUtil.executeQuery(neo4jUtil.getUml_UnutilizedAbstraction());
					stopTime = System.nanoTime();
					String sml3_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getUml_DeepHierarcy: ");
					String sml4 = neo4jUtil.executeQuery(neo4jUtil.getUml_DeepHierarcy());
					stopTime = System.nanoTime();
					String sml4_time = String.valueOf(stopTime - startTime);

					startTime = System.nanoTime();
					System.out.println("getUml_MultipathHierarcy: ");
					String sml5 = neo4jUtil.executeQuery(neo4jUtil.getUml_MultipathHierarcy());
					stopTime = System.nanoTime();
					String sml5_time = String.valueOf(stopTime - startTime);

					System.out.println("getNumberOfNodes: ");
					String numberOfNodes = neo4jUtil.executeQuery(neo4jUtil.getNumberOfNodes());

					System.out.println("getNumberOfNodes: ");
					String numberOfEdges = neo4jUtil.executeQuery(neo4jUtil.getNumberOfEdges());

					String[] record1 = { child.getName(), "0", String.valueOf(!sml1.isEmpty() ? 1 : 0), sml1_time,
							String.valueOf(!sml2.isEmpty() ? 1 : 0), sml2_time, String.valueOf(!sml3.isEmpty() ? 1 : 0),
							sml3_time, String.valueOf(!sml4.isEmpty() ? 1 : 0), sml4_time,
							String.valueOf(!sml5.isEmpty() ? 1 : 0), sml5_time, numberOfNodes.replaceAll("[^0-9]", ""),
							numberOfEdges.replaceAll("[^0-9]", ""), String.valueOf(child.length()) };
					csvData.add(record1);
				} catch (Exception e) {
					String[] record1 = { child.getName(), "1", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"

					};
					csvData.add(record1);
					// throw e;
					// TODO: handle exception
				}

			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

		try (CSVWriter writer = new CSVWriter(new FileWriter(transformedFolder + "\\analysis.csv"))) {
			writer.writeAll(csvData);
		}

		System.out.println("\n");
		System.out.println("Analysis finished.");
	}
}
