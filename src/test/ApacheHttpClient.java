package test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpClientContext context = HttpClientContext.create();
		HttpPost httpPost = new HttpPost("http://www.google.com/");
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost, context);
		try {
		    System.out.println("Response status: " + httpResponse.getStatusLine());
		    System.out.println("Last request URI: " + context.getRequest().getRequestLine());
		    //URICollection redirectLocations = context.getRedirectLocations();
		    /*if (redirectLocations != null) {
		        System.out.println("All intermediate redirects: " + redirectLocations.getAll());
		    }
		    EntityUtils.consume(httpResponse.getEntity());*/
		} finally {
		  //  httpResponse.close();
		}
	}
}
