package com.example.demo.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utilities.ADOxxUtility;
import utilities.ArchiUtility;
import utilities.PapyrusUMLUtility;

import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Upload {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String products(Model model) {
		System.out.println("upload controller");
		return "upload";
	}

	@PostMapping(value = "upload")
	public String saveProduct(@RequestParam("a") int a, @RequestParam("b") int b,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("sum", a + b);
		return "redirect:/upload";
	}

	// ARCHI-------------------------------------------------------------------------------------------
	@RequestMapping(value = "upload/archi", method = RequestMethod.GET)
	public String uploadArchi(Model model) {
		return "uploadarchi";
	}

	@PostMapping(value = "upload/archi")
	public String uploadArchi(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {

			String content = new String(file.getBytes());
			System.out.println("content: ");
			// System.out.println(content);
			redirectAttributes.addFlashAttribute("uploadcontent", content);

			File tmpFile = new File("src/main/resources/targetFile.xml");

			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}

			ArchiUtility archiUtil = new ArchiUtility();
			archiUtil.setFile(tmpFile);

			UUID uuid = UUID.randomUUID();
			String uid = uuid.toString();
			String filename = "export/" + uid + ".graphml";

			archiUtil.transform(filename);

			String outputContent = archiUtil.getGraphXML();
			System.out.println(outputContent);
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/upload/preview";
		}
	}

	// ARCHI-------------------------------------------------------------------------------------------

	// ADOxx-------------------------------------------------------------------------------------------
	@RequestMapping(value = "upload/adoxx", method = RequestMethod.GET)
	public String uploadADOxx(Model model) {

		// model.addAttribute("sum", "to be calculated");

		return "uploadadoxx";
	}

	@PostMapping(value = "upload/adoxx")
	public String uploadADOxx(@RequestParam("file") MultipartFile file, @RequestParam("dtdfile") MultipartFile dtdFile,
			RedirectAttributes redirectAttributes) {
		try {

			String content = new String(file.getBytes());
			System.out.println("content: ");
			redirectAttributes.addFlashAttribute("uploadcontent", content);

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
			String filename = "export/" + uid + ".graphml";
			adoxxUtil.transform(filename);

			String outputContent = adoxxUtil.getGraphXML();
			System.out.println(outputContent);
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/upload/preview";
		}
	}

	// ADOxx-------------------------------------------------------------------------------------------

	// papyrusUML-------------------------------------------------------------------------------------------
	@RequestMapping(value = "upload/papyrusuml", method = RequestMethod.GET)
	public String uploadPapyrusUML(Model model) {
		return "uploadpapyrusuml";
	}

	@PostMapping(value = "upload/papyrusuml")
	public String uploadPapyrusUML(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {

			String content = new String(file.getBytes());
			System.out.println("content: ");
			redirectAttributes.addFlashAttribute("uploadcontent", content);

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

			String outputContent = papyrusUmlUtil.getGraphXML();
			System.out.println(outputContent);
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/upload/preview";
		}
	}

	// papyrusUML-------------------------------------------------------------------------------------------

	@RequestMapping(value = "upload/preview", method = RequestMethod.GET)
	public String uploadPreview(Model model) {

		return "uploadpreview";
	}

	/*
	 * @RequestMapping(value = "repository/graph/{uid}", method = RequestMethod.GET)
	 * public void getGraph(HttpServletResponse response, @PathVariable String uid)
	 * throws IOException {
	 * 
	 * Path filePath = Paths.get("export/", uid+".graphml");
	 * 
	 * String content = Files.readString(filePath);
	 * 
	 * response.setContentType("application/xml");
	 * response.setHeader("Content-Disposition","attachment;filename="+uid+
	 * ".graphml"); ServletOutputStream out = response.getOutputStream();
	 * out.println(content); out.flush(); out.close();
	 * 
	 * }
	 */

	@RequestMapping(value = "repository/graph/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public FileSystemResource getGraph2(HttpServletResponse response, @PathVariable String uid) {
		response.setContentType("text/plain");
		return new FileSystemResource(new File("export/", uid + ".graphml")); // Or path to your file
	}

	@RequestMapping(value = "repository/graph/{uid}/neo4j", method = RequestMethod.GET)
	public String initializeNeo4jGraph(HttpServletResponse response, @PathVariable String uid) {
		graphDb.neo4jGraphmlImport neoImport = new graphDb.neo4jGraphmlImport(uid);
		neoImport.initializeGraph();
		return "neovispreview";
	}

}
