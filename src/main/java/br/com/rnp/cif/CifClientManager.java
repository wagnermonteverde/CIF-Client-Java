package br.com.rnp.cif;

import org.apache.http.client.HttpClient;

/**
 * @author Wagner Ap. Monteverde
 * Cif Manager queries
 */

public class CifClientManager {

	private String ipDomainCifServer;
	private String apikeyValue;
	@SuppressWarnings("unused")
	private Integer port;
	private HttpClient httpClient;
	private CifQuery cifQuery = new CifQuery();
	private CifPostData cifPostData = new CifPostData();
	
	

	/**
	 * @constructor Instantiates the object Cifmanager.
	 * @param String ipDomainCifServer
	 * @param String apikeyValue
	 */
	public CifClientManager(String ipDomainCifServer, String apikeyValue) {
		this.ipDomainCifServer = ipDomainCifServer;
		this.apikeyValue = apikeyValue;
		this.httpClient = httpsconnect(null);
    
	}

	/**
	 * @constructor Instantiates the object Cifmanager.
	 * @param String ipDomainCifServer
	 * @param String apikeyValue
	 * @param Interger port
	 */
	public CifClientManager(String ipDomainCifServer, String apikeyValue, Integer port) {
		this.ipDomainCifServer = ipDomainCifServer;
		this.apikeyValue = apikeyValue;
		this.port = port;
		this.httpClient = httpsconnect(port);

	}
	
	
	/**
	 * 
	 * @param String IP 192.168.0.1, Domain www.123.com or CIDR, ex:192.168.0.0/24
	 * @return String JSON CIF
	 * 
	 * 
	 * */
	public String queryForIpDomain(String ipDomain){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,ipDomain);
	}
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Scan Infraestructure
	 * 
	 * */
	public String queryForInfraestructureScan(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_SCAN);
	}
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Botnet Infraestructure
	 * 
	 * */
	public String queryForInfraestructureBotnet(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_BOTNET);
	}
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Malware Infraestructure
	 * 
	 * */
	public String queryForInfraestructureMalware(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_MALWARE);
	}
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Suspicious Infraestructure
	 * 
	 * */
	public String queryForInfraestructureSuspicious(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_MALWARE);
	}
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Spam Infraestructure
	 * 
	 * */
	public String queryForInfraestructureSpam(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_SPAM);
	}
	
	
	/**
	 * 
	 * @return String JSON CIF
	 * Information Phishing Infraestructure
	 * 
	 * */
	public String queryForInfraestructurePhishing(){
		return cifQuery.httpQuery(httpClient,ipDomainCifServer, apikeyValue,R.QUERY_INFRA_PHISHING);
	}
	
	/**
	 * Submit data CIF Server
	 * 
	 * @param Obj ... 
	 * 
	 * @return boolean status POST data <br>
	 *  200 = true <br>
	 * !200 = false <br>
	 * 
	 * 
	 * */
	public boolean postData(CifObject ... obj) {
		return cifPostData.postData(httpClient,ipDomainCifServer, apikeyValue, obj);
	}
		
	
	
	/**
	 * @param Interger port
	 * @return HttpClient
	 */
	private HttpClient httpsconnect(Integer httpPort) {
		HttpClientSSLFactory clientSSLFactory = new HttpClientSSLFactory(
				httpPort);
		return clientSSLFactory.getHttpClientSSL();
	}

}
