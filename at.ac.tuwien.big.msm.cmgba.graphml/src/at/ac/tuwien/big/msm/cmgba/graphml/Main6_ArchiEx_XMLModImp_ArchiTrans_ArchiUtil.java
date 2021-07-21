package at.ac.tuwien.big.msm.cmgba.graphml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

import org.eclipse.emf.ecore.EPackage;
import org.jdom2.JDOMException;
import org.opengroup.archimate.xmlexchange.XMLExchangePlugin;
import org.opengroup.archimate.xmlexchange.XMLModelImporter;
import org.opengroup.archimate.xmlexchange.XMLModelParserException;
import com.archimatetool.editor.ArchiPlugin;
import com.archimatetool.model.IArchimateFactory;
import com.archimatetool.model.IArchimateModel;
import com.archimatetool.model.impl.ArchimatePackage;
import com.archimatetool.modelimporter.ImportException;
import com.archimatetool.modelimporter.ModelImporter;


public class Main6_ArchiEx_XMLModImp_ArchiTrans_ArchiUtil {

	public static void main(String[] args) {

        ArchiUtility archiUtil = new ArchiUtility();
        
        archiUtil.setFile(new File("../ArchiModels-master/ArchiMetal/ArchiMetal_exported.xml"));
        archiUtil.transform("random.graphml");
        
        System.out.println(archiUtil.getGraphXML());
        
        File tmpFile = archiUtil.getFile();
	}

}
