package Stepdefinitions.DSP;
import java.util.Properties;
import Pages.DSP.AddCustomerPopup;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Renewallessthan50Aggregate {
	private Base base;
	TestContext testContext;

	public Renewallessthan50Aggregate(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Renewal Enrollment for a Aggregate customer with usage < 50Kwh with Fixed product";
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
	DelayedStartDatefortheSites Staggered=new DelayedStartDatefortheSites(base) ;
	XMLFile opty = new XMLFile(base, testContext);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	
	@Then("DSP:Choosing Renew option for the active contract found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		testContext.scenarioContext.setContext(Context.CONTRACT_ID, customer.SelectRenewOptionAggregate());

	}
	@And("DSP:Price a deal with Fixed product for Aggregate Customer")
	public void Price_a_deal_SingleCustomer() throws Throwable {
		deal.Priceadeal();
	}
	
	@Then("DSP: Generate Contract in Dsp for Renewal PC Deal with Aggregate Customer")
	public void Create_Contract_in_DSP_AggregateCustomer() throws Throwable {
		String Status1=contract.ContractGenerationforRenewal();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Ensure the contract is generated for Renewal PC Deal with Aggregate Customer")
	public void Ensure_the_contract_is_generated_AggregateCustomer() throws Throwable {
		String Status=status.contractcreationlessthan50();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
}
