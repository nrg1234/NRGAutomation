package Utilities;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ReadXMLFile {
	static String customername;
	HashMap<String, String> OptyHeader = new HashMap<String, String>();

	public String Readxml() throws ParserConfigurationException, SAXException, IOException {
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		// creating a constructor of file class and parsing an XML file
		File file = new File("./src/test/resources/DataReader/OPPORTUNITYREQUEST_PAYLOAD.xml");
		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName(prop.getProperty("opportunity-request"));
		// nodeList is not iterable, so we are using for loop

		NodeList nodeList2 = doc.getElementsByTagName(prop.getProperty("opportunity-requestcustomer"));
		for (int i = 0; i < nodeList2.getLength(); i++) {
			Node node2 = nodeList2.item(i);
			System.out.println("\nNode Name :" + node2.getNodeName());
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node2;
				customername = eElement.getElementsByTagName("CUSTOMERNAME").item(0).getTextContent();
				System.out.println(customername);
			}
		}
		return customername;
	}

	public HashMap<String, String> getSubmittedOptyFromXML()
			throws ParserConfigurationException, SAXException, IOException {
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		File file = new File("./src/test/resources/DataReader/OPPORTUNITYREQUEST_PAYLOAD.xml");

		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		NodeList nodeList = doc.getElementsByTagName(prop.getProperty("opportunity-request"));

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				OptyHeader.put("OPPORTUNITY_NAME",
						eElement.getElementsByTagName("OPPORTUNITY_NAME").item(0).getTextContent());
				OptyHeader.put("START_DATE", eElement.getElementsByTagName("START_DATE").item(0).getTextContent());
				OptyHeader.put("MATRIXSTART_DATE",
						eElement.getElementsByTagName("MATRIXSTART_DATE").item(0).getTextContent());
				OptyHeader.put("END_DATE", eElement.getElementsByTagName("END_DATE").item(0).getTextContent());
				OptyHeader.put("MARKET_SEGMENT",
						eElement.getElementsByTagName("MARKET_SEGMENT").item(0).getTextContent());
				OptyHeader.put("MARKETER_NAME",
						eElement.getElementsByTagName("MARKETER_NAME").item(0).getTextContent());
				OptyHeader.put("MARKETER_NAME1",
						eElement.getElementsByTagName("MARKETER_NAME1").item(0).getTextContent());
				OptyHeader.put("MARKETER_NAME2",
						eElement.getElementsByTagName("MARKETER_NAME2").item(0).getTextContent());
				OptyHeader.put("MARKETER_NAME3",
						eElement.getElementsByTagName("MARKETER_NAME3").item(0).getTextContent());

				System.out.println(OptyHeader);
			}
		}
		return OptyHeader;
	}
}