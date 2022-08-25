package Stepdefinitions.DSP;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddProxySiteList;
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
import Utilities.Context;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.*;

public class StaggeredSiteSingleEnrollment {
	private Base base;
	TestContext testContext;

	public StaggeredSiteSingleEnrollment(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Staggered Site Enrollment for a single customer with usage > 50Kwh with Fixed product";
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
	DelayedStartDatefortheSites Staggered=new DelayedStartDatefortheSites(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	AddProxySiteList proxy=new AddProxySiteList(base);
	@When("DSP: Add Proxy Site to the Single Staggered Customer")
	public void add_sites_to_the_opty_Staggered_Customer() throws Throwable {
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("StaggeredSingle"));
//	testContext.scenarioContext.setContext(Context.OPTY_ID,proxy.AddProxySitestotheOpty("NewSingle1","ProxySite"));
	}
	
	
	@Then("DSP: Delay Start Date for the Single Customer Sites")
	public void dsp_edit_delayed_start_date_for_the_SingleCustomer_sites() throws Throwable {
		Staggered.Staggeredsites();
	}
	
	
	@Then("DSP: Make sure the contract is generated for Staggered Site Opportunity")
	public void View_Contracts_StaggeredSite() throws Throwable {
	String Status=status.contractcreation();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}


}
