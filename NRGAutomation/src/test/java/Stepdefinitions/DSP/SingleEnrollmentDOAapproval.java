package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.DOApproval;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingleEnrollmentDOAapproval {

	private Base base;
	TestContext testContext;
	public SingleEnrollmentDOAapproval(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}

	String customername;
	String Scenario="Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product DOA Approval";
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
     DOApproval doa=new DOApproval(base);
     TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
@When("DSP: Add New Opportunity DOA")
public void dsp_add_new_opportunity_doa() throws Throwable {
	opty.OptyXMLDOA();
}
@When("DSP: Add customer and sites from the input XML DOA")
public void dsp_add_customer_and_sites_from_the_input_xml_doa() throws Throwable {
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	customer.AddCustomertoOpportunity(prop.getProperty("DOAcustomername"));
}
@When("DSP: Add Sites to the new Opty DOA")
public void dsp_add_sites_to_the_new_opty_doa() throws InterruptedException {
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("NewAggregate2"));
}
@Then("DSP: Generate Contract in DSP DOA")
public void dsp_generate_contract_in_dsp_doa() throws Throwable {
   String Status=contract.ContractGenerationDOA();
   Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
   doa.DOAvalidation();
   doa.Searchopty((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
}



}
