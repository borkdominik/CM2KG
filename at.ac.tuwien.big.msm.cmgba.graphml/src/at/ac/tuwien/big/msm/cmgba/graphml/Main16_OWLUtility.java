package at.ac.tuwien.big.msm.cmgba.graphml;

public class Main16_OWLUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwlUtility owlUtil = new OwlUtility();
		
		//owlUtil.transformToOwl("\"transformed\\1 evolving order.xml_transformed.graphml\"");
		
		owlUtil.transformToRdf("transformed\\ex-1.graphml");
	}

}
