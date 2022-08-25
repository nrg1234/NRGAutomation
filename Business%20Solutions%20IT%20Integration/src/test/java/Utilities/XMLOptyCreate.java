package Utilities;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import apphooks.Base;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class XMLOptyCreate {
	
	WebDriver driver;

	public XMLOptyCreate(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	 // public static void main(final String[] args) throws IOException, ParserConfigurationException, SAXException {

	public HashMap<String, String> getSubmittedOptyFromXML(int j) throws ParserConfigurationException, SAXException, IOException
			{
//		List<Map<String, String>> myList = new ArrayList<Map<String, String>>();
//		Map<String, String> OptyHeader1 = new HashMap<String,String>();
	   HashMap<String, String> OptyHeader1 = new HashMap<String, String>();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		File file = new File("./src/test/resources/DataReader/new_xml.xml");

		// an instance of factory that gives a document builder
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// an instance of builder to parse the specified xml file
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		//for (int j = 0; j <= nodeList.getLength(); j++) {
			
		NodeList nodeList = doc.getElementsByTagName(prop.getProperty("record"));


		for (int i =0; i < nodeList.getLength(); ++i) {
			
			System.out.println("length:" + nodeList.getLength());
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				OptyHeader1.put("Opportunity_Name",
						eElement.getElementsByTagName("Opportunity_Name").item(i).getTextContent());
				OptyHeader1.put("Opportunity_ID", eElement.getElementsByTagName("Opportunity_ID").item(0).getTextContent());
				OptyHeader1.put("Customer_Name1", eElement.getElementsByTagName("Customer_Name1").item(0).getTextContent());
				OptyHeader1.put("Third_Party",
						eElement.getElementsByTagName("Third_Party").item(0).getTextContent());
				OptyHeader1.put("Account_Rep",
						eElement.getElementsByTagName("Account_Rep").item(0).getTextContent());
				OptyHeader1.put("Sites1",
						eElement.getElementsByTagName("Sites1").item(0).getTextContent());
				OptyHeader1.put("End_Date",
						eElement.getElementsByTagName("End_Date").item(0).getTextContent());
				OptyHeader1.put("Due_Date",
						eElement.getElementsByTagName("Due_Date").item(0).getTextContent());
				OptyHeader1.put("Sales_Group",
						eElement.getElementsByTagName("Sales_Group").item(0).getTextContent());
				OptyHeader1.put("Sales_Channel",
						eElement.getElementsByTagName("Sales_Channel").item(0).getTextContent());
				OptyHeader1.put("Product_type",
						eElement.getElementsByTagName("Product_type").item(0).getTextContent());
				OptyHeader1.put("Price_amount",
						eElement.getElementsByTagName("Price_amount").item(0).getTextContent());
				OptyHeader1.put("Term_months",
						eElement.getElementsByTagName("Term_months").item(0).getTextContent());
				OptyHeader1.put("Margin_value",
						eElement.getElementsByTagName("Margin_value").item(0).getTextContent());
				OptyHeader1.put("DOA_Margin",
						eElement.getElementsByTagName("DOA_Margin").item(0).getTextContent());
				OptyHeader1.put("Broker_fee",
						eElement.getElementsByTagName("Broker_fee").item(0).getTextContent());
				OptyHeader1.put("Dealoption_Name",
						eElement.getElementsByTagName("Dealoption_Name").item(0).getTextContent());
				OptyHeader1.put("Template_Name",
						eElement.getElementsByTagName("Template_Name").item(0).getTextContent());
				OptyHeader1.put("first_name",
						eElement.getElementsByTagName("first_name").item(0).getTextContent());
				OptyHeader1.put("last_name",
						eElement.getElementsByTagName("last_name").item(0).getTextContent());
				OptyHeader1.put("address_details",
						eElement.getElementsByTagName("address_details").item(0).getTextContent());
				OptyHeader1.put("City",
						eElement.getElementsByTagName("City").item(0).getTextContent());
				OptyHeader1.put("Zip",
						eElement.getElementsByTagName("Zip").item(0).getTextContent());
				OptyHeader1.put("State",
						eElement.getElementsByTagName("State").item(0).getTextContent());
				OptyHeader1.put("Email",
						eElement.getElementsByTagName("Email").item(0).getTextContent());
				OptyHeader1.put("Approver",
						eElement.getElementsByTagName("Approver").item(0).getTextContent());
			
			}
	
		}
		return OptyHeader1;

		
	}
}

