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
import java.util.Properties; 
public class ReadXMLFile {
	static String customername;
	public String Readxml()throws ParserConfigurationException, SAXException, IOException{ 
		 ConfigReader config = new ConfigReader(); 
		 Properties prop = config.init_properties();
	//creating a constructor of file class and parsing an XML file  
	File file = new File("./src/test/resources/DataReader/OPPORTUNITYREQUEST_PAYLOAD.xml");
	//an instance of factory that gives a document builder  
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	//an instance of builder to parse the specified xml file  
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	doc.getDocumentElement().normalize();  
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	NodeList nodeList = doc.getElementsByTagName(prop.getProperty("opportunity-request"));  
	// nodeList is not iterable, so we are using for loop  
 
	NodeList nodeList2 = doc.getElementsByTagName(prop.getProperty("opportunity-requestcustomer")); 
	for (int i = 0; i < nodeList2.getLength(); i++)   
	{  
	Node node2 = nodeList2.item(i);  
	System.out.println("\nNode Name :" + node2.getNodeName());  
	if (node2.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node2; 
	 customername=eElement.getElementsByTagName("CUSTOMERNAME").item(0).getTextContent();
	System.out.println(customername);
	}
	}return customername;
	}}