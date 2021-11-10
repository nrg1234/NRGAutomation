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
public class ReadXMLFile {   
	public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException{   
	//creating a constructor of file class and parsing an XML file  
	File file = new File("./src/test/resources/DataReader/OPPORTUNITYREQUEST_PAYLOAD.xml");
	//an instance of factory that gives a document builder  
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	//an instance of builder to parse the specified xml file  
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	doc.getDocumentElement().normalize();  
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	NodeList nodeList = doc.getElementsByTagName("OpportunityRequest");  
	// nodeList is not iterable, so we are using for loop  
	for (int itr = 0; itr < nodeList.getLength(); itr++)   
	{  
	Node node = nodeList.item(itr);  
	System.out.println("\nNode Name :" + node.getNodeName());  
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node;  
	System.out.println("REQUEST_ID: "+ eElement.getElementsByTagName("REQUEST_ID").item(0).getTextContent());  
	System.out.println("OPPORTUNITY_NAME: "+ eElement.getElementsByTagName("OPPORTUNITY_NAME").item(0).getTextContent());  
	System.out.println("OPPORTUNITY_TYPE: "+ eElement.getElementsByTagName("OPPORTUNITY_TYPE").item(0).getTextContent());  
	System.out.println("START_DATE: "+ eElement.getElementsByTagName("START_DATE").item(0).getTextContent());  
	System.out.println("END_DATE: "+ eElement.getElementsByTagName("END_DATE").item(0).getTextContent());  
	System.out.println("MARKET_SEGMENT: "+ eElement.getElementsByTagName("MARKET_SEGMENT").item(0).getTextContent());  
	System.out.println("MARKETER_NAME: "+ eElement.getElementsByTagName("MARKETER_NAME").item(0).getTextContent());  
	System.out.println("INDUSTRY: "+ eElement.getElementsByTagName("INDUSTRY").item(0).getTextContent());  
	break;
	} 
	}
	
	NodeList nodeList1 = doc.getElementsByTagName("OpportunityRequestSite"); 
	for (int i = 0; i < nodeList1.getLength(); i++)   
	{  
	Node node1 = nodeList1.item(i);  
	System.out.println("\nNode Name :" + node1.getNodeName());  
	if (node1.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node1;  
	System.out.println("REQUEST_ID: "+ eElement.getElementsByTagName("REQUEST_ID").item(0).getTextContent());
	System.out.println("SITE_ID: "+ eElement.getElementsByTagName("SITE_ID").item(0).getTextContent()); 
	System.out.println("SITE_POD: "+ eElement.getElementsByTagName("SITE_POD").item(0).getTextContent());
	System.out.println("SITE_DC: "+ eElement.getElementsByTagName("SITE_DC").item(0).getTextContent());
	System.out.println("SITE_ADDR: "+ eElement.getElementsByTagName("SITE_ADDR").item(0).getTextContent());
	System.out.println("SITE_CITY: "+ eElement.getElementsByTagName("SITE_CITY").item(0).getTextContent());
	System.out.println("SITE_STATE: "+ eElement.getElementsByTagName("SITE_STATE").item(0).getTextContent());
	System.out.println("SITE_ZIP: "+ eElement.getElementsByTagName("SITE_ZIP").item(0).getTextContent());
	System.out.println("CUSTOMER_ID: "+ eElement.getElementsByTagName("CUSTOMER_ID").item(0).getTextContent());
	System.out.println("ACTION: "+ eElement.getElementsByTagName("ACTION").item(0).getTextContent());
	System.out.println("CUSTOMER_ID: "+ eElement.getElementsByTagName("CUSTOMER_ID").item(0).getTextContent());
	
	}
	}  
	NodeList nodeList2 = doc.getElementsByTagName("OpportunityRequestCustomer"); 
	for (int i = 0; i < nodeList2.getLength(); i++)   
	{  
	Node node2 = nodeList2.item(i);  
	System.out.println("\nNode Name :" + node2.getNodeName());  
	if (node2.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node2;  
	System.out.println("CUSTOMERNAME: "+ eElement.getElementsByTagName("CUSTOMERNAME").item(0).getTextContent());
	
	}}
	}}