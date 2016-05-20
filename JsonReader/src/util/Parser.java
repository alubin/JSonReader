package util;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	public final static NodeList parseXml(String url) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(new URL(url).openStream());
		
		// normalize text representation
		doc.getDocumentElement ().normalize ();
		System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
		
		NodeList listOfPersons = doc.getElementsByTagName("DatabaseUser");
		
		
		return listOfPersons;
	}

}
