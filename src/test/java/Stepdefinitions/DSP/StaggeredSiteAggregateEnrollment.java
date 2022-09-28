package Stepdefinitions.DSP;

import java.io.IOException;
import java.util.Properties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesHUUpload;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.DelayedStartDatefortheSites;
import Pages.DSP.GenerateContract;
import Pages.DSP.HUFileUpload;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.*;

public class StaggeredSiteAggregateEnrollment {
	private Base base;
	TestContext testContext;

	public StaggeredSiteAggregateEnrollment(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Staggered Site Enrollment for a Aggregate customer with usage > 50Kwh with Fixed product";
	String customername;
	String optyID;
	String password;
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	CommonFunctions encrypted = new CommonFunctions();
	Reports utility;
	HUFileUpload upload;
	DelayedStartDatefortheSites Staggered = new DelayedStartDatefortheSites(base);
	XMLFile opty = new XMLFile(base, testContext);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	AddSitesHUUpload Upload=new AddSitesHUUpload(base) ;
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@Then("DSP: Add Aggregate customers to the new Opty")
	public void dsp_add_aggregate_customers_to_the_new_opty() throws Throwable {
		testContext.scenarioContext.setContext(Context.CUST_NAME, opty.ReadXML());
		customer.AddCustomertoOpportunity(prop.getProperty("customername"));

	}

	@Then("DSP:  Add Sites to both Aggregate customers in new Opty")
	public void dsp_add_sites_to_both_aggregate_customers_in_new_opty()
			throws InvalidFormatException, IOException, InterruptedException {
		testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOptyforAggregatecustomer((String) testContext.scenarioContext.getContext(Context.CUST_NAME), "customername", "StaggeredAggregate1","StaggeredAggregate2"));
		//testContext.scenarioContext.setContext(Context.OPTY_ID,Upload.AddSitestotheOptyHUUpload((String) testContext.scenarioContext.getContext(Context.CUST_NAME), "customername"));
	}

	
	@Then("DSP: Delay Start date for Aggregate Customer Sites")
	public void dsp_edit_delayed_start_date_for_the_Aggregate_sites() throws Throwable {
		Staggered.Staggeredsites();

	}

	@Then("DSP: Ensure the contract is generated for Staggered Sites")
	public void View_Contracts_Staggered_Sites() throws Throwable {
	String Status=status.contractcreationAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}


}
