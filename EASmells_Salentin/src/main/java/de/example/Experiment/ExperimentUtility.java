package de.example.Experiment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import de.example.main.ModelAdapter;
import de.example.smells.*;

public class ExperimentUtility {
	
    Detector d1 = new ChattyService();
    Detector d2 = new CyclicDependency();
    Detector d3 = new DataService();
    Detector d4 = new DeadComponent();
    Detector d5 = new DenseStructure();
    Detector d6 = new MessageChain();
    Detector d7 = new SharedPersistency();
    Detector d8 = new StrictLayersViolation();
    Detector d9 = new Duplication();
    Detector d10 = new HubLikeModularization();
    Detector d11 = new WeakenedModularity();
    Detector d12 = new Documentation();
    Detector d13 = new LazyComponent();
    Detector d14 = new AmbiguousViewpoint();
    
    String analysisFileName = "analysis_EASmells_Salentin.csv";
    
	public ExperimentUtility() {
	}
	
	public void analyzeForEaSmells(String directoryPath) throws IOException {
		List<String[]> csvData = new ArrayList<>();
		String[] header = { "filename", 
				"failed_anlysis",
				"CHATTY_SERVICE", 
				"CYCLIC_DEPENDENCY", 
				"DATA_SERVICE",
				"DEAD_COMPONENT", 
				"DENSE_STRUCTURE",
				"MESSAGE_CHAIN", 
				"SHARED_PERSISTENCY", 
				"STRICT_LAYER_VIOLATION",
				"DUPLICATION",
				"HUB_LIKE_MODULARIZATION",
				"WEAKEND_MODULARITY",
				"DOCUMENTATION",
				"LAZY_COMPONENT",
				
				"CHATTY_SERVICE_ns", 
				"CYCLIC_DEPENDENCY_ns", 
				"DATA_SERVICE_ns",
				"DEAD_COMPONENT_ns", 
				"DENSE_STRUCTURE_ns",
				"MESSAGE_CHAIN_ns", 
				"SHARED_PERSISTENCY_ns", 
				"STRICT_LAYER_VIOLATION_ns",
				"DUPLICATION_ns",
				"HUB_LIKE_MODULARIZATION_ns",
				"WEAKEND_MODULARITY_ns",
				"DOCUMENTATION_ns",
				"LAZY_COMPONENT_ns",
				
				"nodes",
				"edges",
				"file_size_bytes"};
		csvData.add(header);

		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {

				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();
				try {
					// Do something with child
					if (child.getName().equals(analysisFileName)|| child.getName().equals("analysis_transformation_time.csv"))
						continue;

					/*File tmpDest = new File(
							"C:\\Users\\Muhamed Smajevic\\AppData\\Local\\Neo4j\\Relate\\Data\\dbmss\\dbms-b0c4430f-501b-49ce-b378-58ef01f04900\\import\\"
									+ child.getName());
					Files.copy(child.toPath(), tmpDest.toPath(), StandardCopyOption.REPLACE_EXISTING);
					*/
					
					d1 = new ChattyService();
				    d2 = new CyclicDependency();
				    d3 = new DataService();
				    d4 = new DeadComponent();
				    d5 = new DenseStructure();
				    d6 = new MessageChain();
				    d7 = new SharedPersistency();
				    d8 = new StrictLayersViolation();
				    d9 = new Duplication();
				    d10 = new HubLikeModularization();
				    d11 = new WeakenedModularity();
				    d12 = new Documentation();
				    d13 = new LazyComponent();
				    d14 = new AmbiguousViewpoint();
				    
					System.out.println("model import name: " + child.getName());
					ModelAdapter model = new ModelAdapter(directoryPath + "\\" + child.getName(), null);
			        Detector.setModel(model);
					//neo4jUtil.neo4jGraphmlImport(child.getName());

					startTime = System.nanoTime();
					System.out.println("getCHATTY_SERVICE_QUERY: ");
					List<EASmell> sml1 = d1.detect();
					//String sml1 = neo4jUtil.executeQuery(neo4jUtil.getCHATTY_SERVICE_QUERY());
					stopTime = System.nanoTime();
					String sml1_time = String.valueOf(stopTime-startTime);
					
					startTime = System.nanoTime();
					System.out.println("getCYCLIC_DEPENDENCY_QUERY: ");
					List<EASmell> sml2 = d2.detect();
					//String sml2 = neo4jUtil.executeQuery(neo4jUtil.getCYCLIC_DEPENDENCY_QUERY());
					stopTime = System.nanoTime();
					String sml2_time = String.valueOf(stopTime-startTime);
					
					startTime = System.nanoTime();
					System.out.println("getDATA_SERVICE_QUERY: ");
					List<EASmell> sml3 = d3.detect();
					//String sml3 = neo4jUtil.executeQuery(neo4jUtil.getDATA_SERVICE_QUERY());
					stopTime = System.nanoTime();
					String sml3_time = String.valueOf(stopTime-startTime);

					startTime = System.nanoTime();
					System.out.println("getDEAD_COMPONENT_QUERY: ");
					List<EASmell> sml4 = d4.detect();
					//String sml4 = neo4jUtil.executeQuery(neo4jUtil.getDEAD_COMPONENT_QUERY());
					stopTime = System.nanoTime();
					String sml4_time = String.valueOf(stopTime-startTime);
					
					startTime = System.nanoTime();
					System.out.println("getDENSE_STRUCTURE_QUERY: ");
					List<EASmell> sml5 = d5.detect();
					//String sml5 = neo4jUtil.executeQuery(neo4jUtil.getDENSE_STRUCTURE_QUERY());
					//System.out.println(sml5);
					stopTime = System.nanoTime();
					String sml5_time = String.valueOf(stopTime-startTime);

					startTime = System.nanoTime();
					System.out.println("getMESSAGE_CHAIN_QUERY: ");
					List<EASmell> sml6 = d6.detect();
					//String sml6 = neo4jUtil.executeQuery(neo4jUtil.getMESSAGE_CHAIN_QUERY());
					stopTime = System.nanoTime();
					String sml6_time = String.valueOf(stopTime-startTime);

					startTime = System.nanoTime();
					System.out.println("getSHARED_PERSISTENCY_QUERY: ");
					List<EASmell> sml7 = d7.detect();
					//String sml7 = neo4jUtil.executeQuery(neo4jUtil.getSHARED_PERSISTENCY_QUERY());
					stopTime = System.nanoTime();
					String sml7_time = String.valueOf(stopTime-startTime);

					startTime = System.nanoTime();
					System.out.println("getSTRICT_LAYER_VIOLATION_QUERY: ");
					List<EASmell> sml8 = d8.detect();
					//String sml8 = neo4jUtil.executeQuery(neo4jUtil.getSTRICT_LAYER_VIOLATION_QUERY());
					stopTime = System.nanoTime();
					String sml8_time = String.valueOf(stopTime-startTime);
					
					
					startTime = System.nanoTime();
					System.out.println("getEa_DUPLICATION_QUERY: ");
					List<EASmell> sml9 = d9.detect();
					//String sml9 = neo4jUtil.executeQuery(neo4jUtil.getEa_DUPLICATION_QUERY());
					stopTime = System.nanoTime();
					String sml9_time = String.valueOf(stopTime-startTime);

					
					startTime = System.nanoTime();
					System.out.println("getEa_HUB_LIKE_MODULARIZATION_QUERY: ");
					List<EASmell> sml10 = d10.detect();
					//String sml10 = neo4jUtil.executeQuery(neo4jUtil.getEa_HUB_LIKE_MODULARIZATION_QUERY());
					stopTime = System.nanoTime();
					String sml10_time = String.valueOf(stopTime-startTime);
					
					
					startTime = System.nanoTime();
					System.out.println("getEa_WEAKEND_MODULARITY_QUERY: ");
					List<EASmell> sml11 = d11.detect();
					//String sml11 = neo4jUtil.executeQuery(neo4jUtil.getEa_WEAKEND_MODULARITY_QUERY());
					stopTime = System.nanoTime();
					String sml11_time = String.valueOf(stopTime-startTime);
					
					
					startTime = System.nanoTime();
					System.out.println("getEa_DOCUMENTATION_QUERY: ");
					List<EASmell> sml12 = d12.detect();
					//String sml12 = neo4jUtil.executeQuery(neo4jUtil.getEa_DOCUMENTATION_QUERY());
					stopTime = System.nanoTime();
					String sml12_time = String.valueOf(stopTime-startTime);
					
					
					
					startTime = System.nanoTime();
					System.out.println("getEa_LAZY_COMPONENT_QUERY: ");
					List<EASmell> sml13 = d13.detect();
					//String sml13 = neo4jUtil.executeQuery(neo4jUtil.getEa_LAZY_COMPONENT_QUERY());
					stopTime = System.nanoTime();
					String sml13_time = String.valueOf(stopTime-startTime);
					
					
					
					System.out.println("getNumberOfNodes: ");
					String numberOfNodes = String.valueOf(model.getElements().size());
					//String numberOfNodes = neo4jUtil.executeQuery(neo4jUtil.getNumberOfNodes());
					
					System.out.println("getNumberOfNodes: ");
					String numberOfEdges = String.valueOf(model.getRelationships().size());
					//String numberOfEdges = neo4jUtil.executeQuery(neo4jUtil.getNumberOfEdges());
					
					String[] record1 = { child.getName(),
							"0",
							String.valueOf(sml1.size() > 0 ? 1 : 0),
							String.valueOf(sml2.size() > 0 ? 1 : 0), 
							String.valueOf(sml3.size() > 0 ? 1 : 0),
							String.valueOf(sml4.size() > 0 ? 1 : 0), 
							String.valueOf(sml5.size() > 0 ? 1 : 0), 
							String.valueOf(sml6.size() > 0 ? 1 : 0),
							String.valueOf(sml7.size() > 0 ? 1 : 0),
							String.valueOf(sml8.size() > 0 ? 1 : 0),
							String.valueOf(sml9.size() > 0 ? 1 : 0),
							String.valueOf(sml10.size() > 0 ? 1 : 0),
							String.valueOf(sml11.size() > 0 ? 1 : 0),
							String.valueOf(sml12.size() > 0 ? 1 : 0),
							String.valueOf(sml13.size() > 0 ? 1 : 0),
							
							sml1_time,
							sml2_time,
							sml3_time,
							sml4_time,
							sml5_time,
							sml6_time,
							sml7_time,
							sml8_time,
							sml9_time,
							sml10_time,
							sml11_time,
							sml12_time,
							sml13_time,
							
							numberOfNodes.replaceAll("[^0-9]", ""),
							numberOfEdges.replaceAll("[^0-9]", ""),
							String.valueOf(child.length())
					};
					csvData.add(record1);
				} catch (Exception e) {
					System.out.println(e);
					this.addDummyAnalysisRow(child.getName(), csvData);
				}
				catch (StackOverflowError e) {
					System.out.println(e);
					this.addDummyAnalysisRow(child.getName(), csvData);
				}
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

		try (CSVWriter writer = new CSVWriter(new FileWriter(directoryPath + "\\"+analysisFileName))) {
			writer.writeAll(csvData);
		}

		System.out.println("\n");
		System.out.println("Analysis finished.");
	}
	
	private void addDummyAnalysisRow(String childName, List<String[]> csvData) {
		System.out.println("EXCEPTION thrown in processing, setting default values and skipping");
		
		// TODO: handle exception
		String[] record1 = { childName,
				"1",
				"0",
				"0", 
				"0",
				"0", 
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0", 
				"0",
				
				"0", 
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				"0",
				
				"0",
				"0",
				"0"

		};
		csvData.add(record1);
	}
}
