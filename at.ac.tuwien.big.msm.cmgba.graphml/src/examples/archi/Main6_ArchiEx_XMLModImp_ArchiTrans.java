package examples.archi;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;
import com.archimatetool.editor.ArchiPlugin;
import com.archimatetool.model.IArchimateModel;
import at.ac.tuwien.big.msm.cmgba.graphml.GraphML;
import graphML.GraphMLModelExporter;
import transformations.Archimate2GraphML;

public class Main6_ArchiEx_XMLModImp_ArchiTrans {

	public static void main(String[] args) {

		ArchiPlugin plug = new ArchiPlugin();

		File modelFile = new File("../ArchiModels-master/ArchiMetal/ArchiMetal_exported.xml");

		try {
			XMLModelImporter importer = new XMLModelImporter();
			IArchimateModel model = importer.createArchiMateModel(modelFile);

			Archimate2GraphML archi2Graphml = new Archimate2GraphML(model);

			archi2Graphml.convert();
			GraphML graphml = archi2Graphml.getGraphml();

			GraphMLModelExporter modelExporter = new GraphMLModelExporter(graphml);
			try {
				modelExporter.exportGraph("GraphMLXMLOutput/output_test8_ArchisuranceXML.graphml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException | JDOMException | XMLModelParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed");
	}

}
