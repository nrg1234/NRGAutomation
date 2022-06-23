package Utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.CreateOptyPopup;
import Utilities.ExcelUtil;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import apphooks.Base;

public class XMLFile {

	String customername;
	private Base base;
	TestContext testContext;
	public XMLFile(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
	AddCustomerPopup customer=new AddCustomerPopup(base) ;



	public String ReadXML() throws Throwable {

		ReadXMLFile xml=new ReadXMLFile();
		customername = xml.Readxml();
		customer.AddCustomertoOpportunity(customername);
		return customername;

	}

	public void OptyXML() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunity(OptyHeader);

	}
	
	public void OptyXML1() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunityforNonErcot(OptyHeader);

	}

	public String OptyXMLMatrix() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		String Status=opportunity.CreateMatrixOpportunity(OptyHeader);
		
		return Status;
	}
	public void OptyXMLrenewal() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunityrenewal(OptyHeader);
	}
	public void OptyXMLbroker() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateBrokerOpportunity(OptyHeader);

	}
	public void OptyXMLAddbroker() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateAddBrokerOpportunity(OptyHeader);

	}
	public void OptyXMLDOA() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunityDOA(OptyHeader);
	}
	public void OptyXMLPC() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunityPC(OptyHeader);
	}
	public void OptyXMLMatrixless() throws Throwable {
		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateMatrixlessthan50Opportunity(OptyHeader);
	}
}