package slcomputer.palas;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SlClient {

	// HTTP POST request
	public static SlResponse checkUser(String user) {
		try {
			String url = "https://agrius.feralhosting.com/palas/slserver/check.php";
			URL obj;
			obj = new URL(url);	
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			String urlParameters = "user=" + URLEncoder.encode(user, "UTF-8");

			//add request header
			con.setRequestMethod("POST");

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			if (responseCode != 200) {
				throw new RuntimeException("Error contacting the server!");
			} else {
				return new SlResponse(user, response.toString());
			}

		} catch (MalformedURLException e) {
			throw new RuntimeException("Error contacting the server!", e);
		} catch (IOException e) {
			throw new RuntimeException("Error contacting the server!", e);
		}
	}
}
