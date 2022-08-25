package Stepdefinitions.DSP;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddProxySiteList;
import Pages.DSP.AddSitesHUUpload;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.When;

public class Ema {
	private Base base;
	TestContext testContext;
	public Ema(Base base, TestContext context) {
	this.base = base;
	testContext = context;
}
	String customername;
	String Scenario="Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product";
	CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
	AddCustomerPopup customer=new AddCustomerPopup(base) ;
	AddSitesPopup sites=new AddSitesPopup(base) ;
	ViewCredit credit=new ViewCredit(base) ;
	PriceaDeal deal=new PriceaDeal(base) ;
	GenerateContract contract =new GenerateContract(base) ;
	ViewContract status =new ViewContract(base) ;
	SendContracttoCustomer sendContract =new SendContracttoCustomer(base) ;
	XMLFile opty=new XMLFile(base, testContext);
	ConfigWrite write=new ConfigWrite(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	AddProxySiteList proxy=new AddProxySiteList(base);
	AddSitesHUUpload HU=new AddSitesHUUpload(base);
	
	@When("DSP: Add New Opportunity with Third Party")
	public void dsp_add_new_opportunity_with_third_party() throws Throwable {
		testContext.scenarioContext.setContext(Context.Opportunityname ,opty.OptyXMLAnalyst()); 
	}
	@When("DSP: Validate EMA in header")
	public void dsp_validate_ema_in_header() throws Throwable {
		customer.ViewHeader((String) testContext.scenarioContext.getContext(Context.Opportunityname)); 
	}



}