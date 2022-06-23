package Utilities;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import apphooks.Base;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;
import java.util.HashMap;


public class XMLRead {
	WebDriver driver;

	public XMLRead(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public HashMap<String, String> getSubmittedOptyFromXML(int k)
			throws ParserConfigurationException, SAXException, IOException

	// public static void main(String[] args) throws ParserConfigurationException,
	// SAXException, IOException
	{

		HashMap<String, String> OptyHeader1 = new HashMap<String, String>();
		File file = new File("./src/test/resources/DataReader/new_xml.xml");

		// Create a new object of DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Create an object DocumentBuilder to parse the XML file data
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(file);

		doc.getDocumentElement().normalize();

		System.out.println("Root element name is: " + doc.getDocumentElement().getNodeName());

		// Creating a list of nodes present in the XML file
		NodeList nodeList1 = doc.getElementsByTagName("record");
		NodeList nodeList2 = doc.getElementsByTagName("OpportunityRequestSite");
		NodeList nodeList3 = doc.getElementsByTagName("OpportunityRequestCustomer");
		NodeList nodeList4 = doc.getElementsByTagName("OpportunityRequestMarket");

		int m = k;
		for (int k1 = k; k1 <= m; k1++) {
			Node node = nodeList1.item(k1);
			System.out.println("\n" + "(" + k1 + ")" + " Child Node Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				System.out.println("Opportunity_Name: "
						+ element.getElementsByTagName("Opportunity_Name").item(0).getTextContent());
				OptyHeader1.put("Opportunity_Name",
						element.getElementsByTagName("Opportunity_Name").item(0).getTextContent());
				OptyHeader1.put("Opportunity_ID",
						element.getElementsByTagName("Opportunity_ID").item(0).getTextContent());
				OptyHeader1.put("Customer_Name1",
						element.getElementsByTagName("Customer_Name1").item(0).getTextContent());
				OptyHeader1.put("Third_Party", element.getElementsByTagName("Third_Party").item(0).getTextContent());
				OptyHeader1.put("Account_Rep", element.getElementsByTagName("Account_Rep").item(0).getTextContent());
				OptyHeader1.put("Sites1", element.getElementsByTagName("Sites1").item(0).getTextContent());
				OptyHeader1.put("Sales_Group", element.getElementsByTagName("Sales_Group").item(0).getTextContent());
				OptyHeader1.put("Sales_Channel",
						element.getElementsByTagName("Sales_Channel").item(0).getTextContent());
				OptyHeader1.put("Product_type", element.getElementsByTagName("Product_type").item(0).getTextContent());
				OptyHeader1.put("Price_amount", element.getElementsByTagName("Price_amount").item(0).getTextContent());
				OptyHeader1.put("Term_months", element.getElementsByTagName("Term_months").item(0).getTextContent());
				OptyHeader1.put("Margin_value", element.getElementsByTagName("Margin_value").item(0).getTextContent());
				OptyHeader1.put("DOA_Margin", element.getElementsByTagName("DOA_Margin").item(0).getTextContent());
				OptyHeader1.put("Broker_fee", element.getElementsByTagName("Broker_fee").item(0).getTextContent());
				OptyHeader1.put("Dealoption_Name",
						element.getElementsByTagName("Dealoption_Name").item(0).getTextContent());
				OptyHeader1.put("Template_Name",
						element.getElementsByTagName("Template_Name").item(0).getTextContent());
				OptyHeader1.put("first_name", element.getElementsByTagName("first_name").item(0).getTextContent());
				OptyHeader1.put("last_name", element.getElementsByTagName("last_name").item(0).getTextContent());
				OptyHeader1.put("address_details",
						element.getElementsByTagName("address_details").item(0).getTextContent());
				OptyHeader1.put("City", element.getElementsByTagName("City").item(0).getTextContent());
				OptyHeader1.put("Zip", element.getElementsByTagName("Zip").item(0).getTextContent());
				OptyHeader1.put("State", element.getElementsByTagName("State").item(0).getTextContent());
				OptyHeader1.put("Email", element.getElementsByTagName("Email").item(0).getTextContent());
				OptyHeader1.put("Approver", element.getElementsByTagName("Approver").item(0).getTextContent());

			}

		}
		return OptyHeader1;
	}

}
