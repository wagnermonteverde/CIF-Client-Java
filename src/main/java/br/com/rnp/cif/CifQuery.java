package br.com.rnp.cif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

/**
 * @author Wagner Ap. Monteverde
 * Cif HTTP query
 */

public class CifQuery {

	/**
	 * @param HttpClient
	 * @param String ipDomainCifServer
	 * @param String apikeyValue
	 * @param String query
	 * @return String JSON
	 * 
	 * Responsible for running the HTTP query
	 * 
	 */
	public String httpQuery(HttpClient client, String ipDomainCifServer,String apikeyValue, String query) {
		
		String json = null;

		String url = "https://" + ipDomainCifServer + R.PATH_API+ R.API_KEY_PARAM + apikeyValue + R.QUERY_PARAM + query;
		
		System.out.println(url);
		
		HttpGet getRequest = new HttpGet(url);

		getRequest.addHeader("accept", "application/json");

		HttpResponse response;

		try {

			response = client.execute(getRequest);

			json = jsonFactory(response);

		} catch (Exception e) {
			System.out.println("Connection problems: " + e.getMessage());
			client.getConnectionManager().shutdown();
		}

		client.getConnectionManager().shutdown();

		return json;
	}

	/**
	 * @param response
	 * @throws IOException
	 * @throws IllegalStateException
	 * @return String JSON
	 */
	private String jsonFactory(HttpResponse response) throws IOException,IllegalStateException {

		StringBuilder json = new StringBuilder();

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Falha : código do erro HTTP : "+ response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

		String output;

		System.out.println("Result from Servidor .... \n");
		while ((output = br.readLine()) != null) {
			json.append(output+"\n");
		}

		return json.toString();
	}

}
