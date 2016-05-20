package util;

import java.io.IOException;
import java.net.URL;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Retrieve {

	private enum returnType
	{
		JSON,
		XML
	}

	private final static String httpGet(String urlStr, returnType rType ) throws IOException{
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(urlStr).build());

		String result = null;
		switch(rType)
		{
		case XML:
			result = client.resource(service.getURI()).accept(MediaType.APPLICATION_XML).get(String.class);
			break;
		case JSON:
			result = client.resource(service.getURI()).accept(MediaType.APPLICATION_JSON).get(String.class);
			break;
		}
		return result;
	}

	public final static String getXML(String url) throws IOException, SAXException, ParserConfigurationException
	{
		System.out.println("URL = " + url);
		
		return httpGet(url, returnType.XML);

	}

	public final static String getJSON(String url) throws IOException
	{
		return httpGet(url, returnType.JSON);

	}



}


