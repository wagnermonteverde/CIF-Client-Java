package br.com.rnp.cif;

import java.security.cert.X509Certificate;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

/**
 * @Author Wagner Ap. Monteverde SSL HTTP Connector
 */

public class HttpClientSSLFactory {

	private HttpClient httpClient;

	/**
	 * 
	 * Make @HttpClient with SSL Suport.
	 * 
	 * @param Integer
	 *            port. If port is null default port 443
	 * 
	 */
	public HttpClientSSLFactory(Integer port) {

		if (port == null)
			port = 443;

		try {

			TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] certificate,
						String authType) {
					return true;
				}
			};

			SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy,
					SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("https", port, sf));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(
					registry);

			this.httpClient = new DefaultHttpClient(ccm);

		} catch (Exception e) {
			System.out.println("ouve erro " + e.getMessage());
		}

	}

	/**
	 * 
	 * @return HttpClient with SSL Suport.
	 * 
	 */
	public HttpClient getHttpClientSSL() {

		return this.httpClient;
	}

}
