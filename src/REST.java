import java.io.*;
import java.net.*;

public class REST {
	
	public static String getCategory(String name, String city) {
		
		//Gets the result from google
		String key = "AIzaSyAI43yo3xh2UUkceT3vBK_8VPyFvUfUDWU";
		String json = executePost("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input="+name + "+" + city + "&inputtype=textquery&fields=types&key=" + key,"");
		System.out.println(json);
		
		//Parses to get the category
		int index = json.indexOf("types");
		if(index==-1) return null;
		json = json.substring(index, index+50);
		String [] words = json.split("\"");
		return words[2];
	}
	
	
	
	public static String executePost(String targetURL, String urlParameters) {
		  HttpURLConnection connection = null;

		  try {
			  //Create connection
			  URL url = new URL(targetURL);
			  connection = (HttpURLConnection) url.openConnection();
			  connection.setRequestMethod("POST");
			  connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			  connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			  connection.setRequestProperty("Content-Language", "en-US");  

			  connection.setUseCaches(false);
			  connection.setDoOutput(true);

			  //Send request
			  DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
			  wr.writeBytes(urlParameters);
			  wr.close();

			  //Get Response  
			  InputStream is = connection.getInputStream();
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			  StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			  String line;
			  while ((line = rd.readLine()) != null) {
				  response.append(line);
				  response.append('\r');
			  }
			  rd.close();
			  return response.toString();
		  } 
		  catch (Exception e) {
			  e.printStackTrace();
			  return null;
		  } 
		  finally {
			  if (connection != null) {
				  connection.disconnect();
			  }	
		  }
	}


}
