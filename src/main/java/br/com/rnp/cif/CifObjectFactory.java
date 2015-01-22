package br.com.rnp.cif;

import java.util.ArrayList;


public class CifObjectFactory {
	
	private ArrayList<CifObject> cifArrayObjects;
	
		
	public CifObjectFactory(){
		cifArrayObjects = new ArrayList<CifObject>();
	}
	
		
	public  CifObject buildCifObject(String address, String portList,Protocol protocol, Assessment assessment) {
		return addRelatedData(address,portList,protocol,assessment);
	}
	
	
	public void addCifObjectInList(String address, String portList,Protocol protocol, Assessment assessment) {
        this.cifArrayObjects.add(buildCifObject(address,portList,protocol,assessment));		
	}
	
	
	public CifObject[] buildArrayCifObjects() {
		return (CifObject[]) this.cifArrayObjects.toArray(new CifObject[this.cifArrayObjects.size()]);
	}
	
	
	private  CifObject addRelatedData(String ipAddress,String portList, Protocol protocol,Assessment assessment){
		
		CifObject cifObject = new CifObject();
		
		cifObject.setAddress(ipAddress);
		cifObject.setAssessment(assessment.getAssessment());
		cifObject.setSeverity("medium");
		cifObject.setImpact(assessment.getAssessment());
		cifObject.setDescription("Scan related by" + R.INSTITUICAO );
        cifObject.setPortlist(portList);
        cifObject.setProtocol(protocol.getProtocol()); 
        cifObject.setConfidence("95");
        cifObject.setGuid("everyone");
        cifObject.setRestriction("private");
        cifObject.setAlternativeid_restriction("private");
				
		return cifObject;
		
	}
	
	
	

}
