package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

public class HttpClient {

	public static void main(String[] args) {

		URL url = null;
		HttpURLConnection connection = null;
		Scanner scanner = null;
		String response = null;

		try {
			url = new URL("https://digitalconnectproxy.verizon.com/oauthv1/client_credential/accesstoken");

			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxycacheF.hewitt.com", 8082));
			
			connection = (HttpURLConnection) url.openConnection(proxy);

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "x-www-form-urlencoded");

			String body = "grant_type=client_credentials";

			// set authentication header
			String authHeader = "AlQbA0aGcqsvIPxZ8GVGga7tWGncbTr8:lqIthITMyFspm23b";

			Base64 b = new Base64();
			String authHeaderEncoded = b.encodeAsString(authHeader.getBytes(StandardCharsets.UTF_8));
			connection.setRequestProperty("Authentication", "Basic " + authHeaderEncoded);

			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(body);
			writer.flush();

			InputStream content = (InputStream) connection.getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}

			connection.disconnect();
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (ProtocolException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
