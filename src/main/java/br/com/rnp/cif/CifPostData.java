package br.com.rnp.cif;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;


import com.google.gson.Gson;

/**
 * @author Wagner Ap. Monteverde
 * Cif HTTP POST data
 */

public class CifPostData {

	public boolean postData(HttpClient client, String ipDomainCifServer,
			String apikeyValue, CifObject... obj){

		boolean status = false;

		String url = "https://" + ipDomainCifServer + R.PATH_API
				+ R.API_KEY_PARAM + apikeyValue;


		try {

			StringEntity params  = new StringEntity(objToJson(obj));
			

			HttpPost post = new HttpPost(url);

			post.addHeader("Accept", "application/json");
			post.setEntity(params);
			HttpResponse response = client.execute(post);
			System.out.println(response.getStatusLine().getStatusCode());

			if (response.getStatusLine().getStatusCode() == 200) {
				status = true;
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static String objToJson(CifObject... obj) {
		return new Gson().toJson(obj);
	}

	
}
