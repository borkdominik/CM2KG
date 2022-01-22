package examples.archi;

import java.io.File;
import utilities.ArchiUtility;

public class Main6_ArchiEx_XMLModImp_ArchiTrans_ArchiUtil {

	public static void main(String[] args) {

		ArchiUtility archiUtil = new ArchiUtility();

		archiUtil.setFile(new File("../ArchiModels-master/ArchiMetal/ArchiMetal_exported.xml"));
		archiUtil.transform("random.graphml");

		System.out.println(archiUtil.getGraphXML());

		File tmpFile = archiUtil.getFile();
	}

}
