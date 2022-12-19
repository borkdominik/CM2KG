package com.example.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.WebappApplication;

import utilities.ADOxxUtility;
import utilities.ArchiUtility;
import utilities.PapyrusUMLUtility;

import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class Upload {
	
	
	@Autowired
	private Environment env;
	
	private String exportFolder = new File("transformation/export").getAbsolutePath();
	
	@RequestMapping(value = "cm2kg", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "cm2kg/upload", method = RequestMethod.GET)
	public String products(Model model) {
		System.out.println("upload controller");
		return "upload";
	}

	@PostMapping(value = "cm2kg/upload")
	public String saveProduct(@RequestParam("a") int a, @RequestParam("b") int b,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("sum", a + b);
		return "redirect:/upload";
	}

	// ARCHI-------------------------------------+------------------------------------------------------
	@RequestMapping(value = "cm2kg/upload/archi", method = RequestMethod.GET)
	public String uploadArchi(Model model) {
		return "uploadarchi";
	}

	@PostMapping(value = "cm2kg/upload/archi")
	public String uploadArchi(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {

			Files.createDirectories(Paths.get(exportFolder));
			
			String content = new String(file.getBytes());
			System.out.println("content: ");
			// System.out.println(content);
			redirectAttributes.addFlashAttribute("uploadcontent", content);

			//File tmpFile = new File("src/main/resources/targetFile.xml"); //OLD WAY THAT DOES NOT WORK WHEN COMPILED TO .JAR
			//File tmpFile = new File(this.getClass().getClassLoader().getResource("src/main/resources/targetFile.xml").getFile()); 
			//File tmpFile = new ClassPathResource("targetFile.xml").getFile();
			File tmpFile = File.createTempFile("cm2kb/targetFile2", ".xml");
			
			try (OutputStream os = new FileOutputStream(tmpFile)) {
				os.write(file.getBytes());
			}
			System.out.println("created file: "+tmpFile.getAbsolutePath());
			
			System.out.println("now loading ArchiUtility...");
			
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
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/cm2kg/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/cm2kg/upload/preview";
		}
	}

	// ARCHI-------------------------------------------------------------------------------------------

	// ADOxx-------------------------------------------------------------------------------------------
	@RequestMapping(value = "cm2kg/upload/adoxx", method = RequestMethod.GET)
	public String uploadADOxx(Model model) {

		// model.addAttribute("sum", "to be calculated");

		return "uploadadoxx";
	}

	@PostMapping(value = "cm2kg/upload/adoxx")
	public String uploadADOxx(@RequestParam("file") MultipartFile file, 
							  @RequestParam("dtdfile") MultipartFile dtdFile,
							  RedirectAttributes redirectAttributes) {
		try {
			Files.createDirectories(Paths.get(exportFolder));
			
			String content = new String(file.getBytes());
			System.out.println("content: ");
			redirectAttributes.addFlashAttribute("uploadcontent", content);

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
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/cm2kg/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/cm2kg/upload/preview";
		}
	}

	// ADOxx-------------------------------------------------------------------------------------------

	// papyrusUML-------------------------------------------------------------------------------------------
	@RequestMapping(value = "cm2kg/upload/papyrusuml", method = RequestMethod.GET)
	public String uploadPapyrusUML(Model model) {
		return "uploadpapyrusuml";
	}

	@PostMapping(value = "cm2kg/upload/papyrusuml")
	public String uploadPapyrusUML(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {

			Files.createDirectories(Paths.get(exportFolder));
			
			String content = new String(file.getBytes());
			System.out.println("content: ");
			redirectAttributes.addFlashAttribute("uploadcontent", content);

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
			redirectAttributes.addFlashAttribute("fileUid", uid);
			redirectAttributes.addFlashAttribute("outputcontent", outputContent);

			return "redirect:/cm2kg/upload/preview";

		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("uploadcontent", "An error occured!");
			return "redirect:/cm2kg/upload/preview";
		}
	}

	// papyrusUML-------------------------------------------------------------------------------------------

	@RequestMapping(value = "cm2kg/upload/preview", method = RequestMethod.GET)
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

	@RequestMapping(value = "cm2kg/repository/graph/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public FileSystemResource getGraph2(HttpServletResponse response, @PathVariable String uid) {
		response.setContentType("text/plain");
		return new FileSystemResource(new File(exportFolder, uid + ".graphml")); // Or path to your file
	}

	@RequestMapping(value = "cm2kg/repository/graph/{uid}/neo4j", method = RequestMethod.GET)
	public String initializeNeo4jGraph(HttpServletResponse response, Model model, @PathVariable String uid) {
		graphDb.neo4jGraphmlImport neoImport = new graphDb.neo4jGraphmlImport(uid);
		neoImport.initializeGraph();
		
		model.addAttribute("uid", uid);

		model.addAttribute("neovisServerUrl", env.getProperty("neovis.server_url"));
		model.addAttribute("neovisUser", env.getProperty("neovis.server_user"));
		model.addAttribute("neovisPassword", env.getProperty("neovis.server_password"));
		//return "neovispreview";
		return "neovispreview_v3";
	}
	
	@RequestMapping(value = "cm2kg/repository/graph/test", method = RequestMethod.GET)
	public String initializeNeo4jGraphTest(HttpServletResponse response) {
		return "neovispreview_v2";
	}
	
	@RequestMapping(value = "cm2kg/neo4j/query", method = RequestMethod.POST)
    public @ResponseBody String processAJAXRequest(@Valid @RequestBody String query) {
		graphDb.neo4jGraphmlImport neoImport = new graphDb.neo4jGraphmlImport();
		neoImport.executeQuery(query);
		
		String response = "";
        System.out.println("working");
        return response;
    }
	
}
