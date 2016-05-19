package util;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Retrieve {
	

//	public Retrieve(String message) throws IOException
//	{
//		String msg = httpGet(message);
//		System.out.println(msg);
//	}
	
	private final static String httpGet(String urlStr, String restPath, String resourcePath) throws IOException{
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  WebResource service = client.resource(UriBuilder.fromUri(urlStr).build());
		  String resultJSON = service. path(restPath).path(resourcePath).accept(MediaType.APPLICATION_JSON).get(String.class);
		  String resultXML = service. path(restPath).path(resourcePath).accept(MediaType.APPLICATION_XML).get(String.class);
		  // getting XML data
		  System.out.println(resultJSON);
		  // getting JSON data
		  System.out.println(resultXML);
		  return resultJSON;
	}
	
	public final static String httpGet(String urlStr ) throws IOException{
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  WebResource service = client.resource(UriBuilder.fromUri(urlStr).build());
		  String resultJSON = client.resource(UriBuilder.fromUri(urlStr).build()).accept(MediaType.APPLICATION_JSON).get(String.class);
		  String resultXML = client.resource(UriBuilder.fromUri(urlStr).build()).accept(MediaType.APPLICATION_XML).get(String.class);
		  // getting XML data
		  System.out.println(resultJSON);
		  // getting JSON data
		  System.out.println(resultXML);
		  return resultJSON;
	}
	
	

}
