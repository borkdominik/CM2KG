package com.example.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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


	@PostMapping(value = "api/transformation/archi")
	public Response uploadArchi(@RequestParam("file") MultipartFile file) {
		System.out.println("archi transformation api called");
		try {

			//String content = new String(file.getBytes());
			//System.out.println("content: ");

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
	@PostMapping(value = "api/transformation/adoxx")
	public Response uploadADOxx(@RequestParam("file") MultipartFile file, @RequestParam("dtdfile") MultipartFile dtdFile) {

		// redirectAttributes.addFlashAttribute("sum", a + b);
		try {
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
	@PostMapping(value = "api/transformation/papyrusuml")
	public Response uploadPapyrusUML(@RequestParam("file") MultipartFile file) {
		try {
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
