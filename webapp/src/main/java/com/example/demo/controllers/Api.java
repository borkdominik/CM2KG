package com.example.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entities.Response;
import utilities.ADOxxUtility;
import utilities.ArchiUtility;
import utilities.PapyrusUMLUtility;

import java.util.UUID;

@RestController
public class Api {
	
	private String exportFolder = new File("transformation/export").getAbsolutePath();

	@PostMapping(value = "cm2kg/api/transformation/archi")
	public Response uploadArchi(@RequestParam("file") MultipartFile file) {
		System.out.println("archi transformation api called");
		try {
			Files.createDirectories(Paths.get(exportFolder));
			File tmpFile = File.createTempFile("cm2kb/targetFile2", ".xml");
			
			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}
			
			ArchiUtility archiUtil = new ArchiUtility();
			archiUtil.setFile(tmpFile);
			
			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			//String filename = "export/" + uid + ".graphml"; //OLD APPRAOCH
			String filename = exportFolder + "/" + uid + ".graphml";

			System.out.println("now transforming file...");
			archiUtil.transform(filename);
			System.out.println("transformation done...");
			
			String outputContent = archiUtil.getGraphXML();
			System.out.println(outputContent);
			
			/*redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);
			

			File tmpFile = new File("src/main/resources/targetFile.xml");

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}

			ArchiUtility archiUtil = new ArchiUtility();
			archiUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();

			archiUtil.transform();

			String outputContent = archiUtil.getGraphXML();
			System.out.println(outputContent);
			*/
			Response response = new Response();
			response.setId(uid);
			response.setTransformedGraph(outputContent);

			return response;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ARCHI-------------------------------------------------------------------------------------------

	// ADOxx-------------------------------------------------------------------------------------------
	@PostMapping(value = "cm2kg/api/transformation/adoxx")
	public Response uploadADOxx(@RequestParam("file") MultipartFile file, @RequestParam("dtdfile") MultipartFile dtdFile) {

		try {
			
			Files.createDirectories(Paths.get(exportFolder));
			
			// xml file
			File tmpFile = File.createTempFile("cm2kb/targetFile2", ".xml"); //new File("src/main/resources/" + file.getOriginalFilename());

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}
			
			String p1 = tmpFile.getAbsolutePath();
			String p2 = tmpFile.getCanonicalPath();
			String p3 = tmpFile.getParent();
			
			
			// dtd file
			//File tmpdtdFile = File.createTempFile("cm2kb/targetFiledtd2", ".xml");// new File("src/main/resources/" + dtdFile.getOriginalFilename());
			File tmpdtdFile = new File(tmpFile.getParent(), dtdFile.getOriginalFilename());
			System.out.println("dtdFile route: "+tmpdtdFile.getAbsolutePath());
			try (OutputStream os = new FileOutputStream(tmpdtdFile)) {
				os.write(dtdFile.getBytes());
			}

			ADOxxUtility adoxxUtil = new ADOxxUtility();
			adoxxUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			String filename = exportFolder + "/" + uid + ".graphml";
			adoxxUtil.transform(filename);

			String outputContent = adoxxUtil.getGraphXML();
			System.out.println(outputContent);
			/*redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);
			
			
			// xml file
			File tmpFile = new File("src/main/resources/" + file.getOriginalFilename());

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}

			// dtd file
			File tmpdtdFile = new File("src/main/resources/" + dtdFile.getOriginalFilename());
			try (OutputStream os = new FileOutputStream(tmpdtdFile)) {
				os.write(dtdFile.getBytes());
			}

			ADOxxUtility adoxxUtil = new ADOxxUtility();
			adoxxUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			adoxxUtil.transform();

			String outputContent = adoxxUtil.getGraphXML();
			System.out.println(outputContent);
*/
			Response response = new Response();
			response.setId(uid);
			response.setTransformedGraph(outputContent);
			return response;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ADOxx-------------------------------------------------------------------------------------------

	// papyrusUML-------------------------------------------------------------------------------------------
	@PostMapping(value = "cm2kg/api/transformation/papyrusuml")
	public Response uploadPapyrusUML(@RequestParam("file") MultipartFile file) {
		try {
			
			Files.createDirectories(Paths.get(exportFolder));
			// xml file
			File tmpFile = File.createTempFile("cm2kb/targetFile2", ".xml"); // new File("src/main/resources/" + file.getOriginalFilename());

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}

			PapyrusUMLUtility papyrusUmlUtil = new PapyrusUMLUtility();
			papyrusUmlUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			String filename = exportFolder + "/" + uid + ".graphml";
			papyrusUmlUtil.transform(filename);

			String outputContent = papyrusUmlUtil.getGraphXML();
			System.out.println(outputContent);
			/*redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);
			
			
			// xml file
			File tmpFile = new File("src/main/resources/" + file.getOriginalFilename());

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}

			PapyrusUMLUtility papyrusUmlUtil = new PapyrusUMLUtility();
			papyrusUmlUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			String filename = "export/" + uid + ".graphml";
			papyrusUmlUtil.transform(filename);
			// File outputFile = archiUtil.getFile();

			String outputContent = papyrusUmlUtil.getGraphXML();
			System.out.println(outputContent);
			*/
			Response response = new Response();
			response.setId(uid);
			response.setTransformedGraph(outputContent);
			return response;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// papyrusUML-------------------------------------------------------------------------------------------

}
