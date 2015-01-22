package br.com.rnp.cif;

/**
 * @author Wagner Ap. Monteverde
 * Cif Assessment
 */

public enum Assessment {
	
		
	BOTNET("botnet"),MALWARE("malware"),PHISHING("phishing"),
	FASTFLUX("fastflux"),SCANNER("scanner"),SPAM("spam"),
	SPAMVIRTIZING("spamvirtizing"),	SUSPICIOUS("suspicious"),
	WHITELIST("whitelist");
	
	
    private final String assessment;

	
	private  Assessment(String assessment){
		this.assessment =assessment;
	}


	public String getAssessment() {
		return assessment;
	}
	
}
