package Stepdefinitions.DSP;
import java.util.Properties;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.HUFileUpload;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.VHOS.VhosPage;
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

public class Renewallessthan50 {

	private Base base;
	TestContext testContext;

	public Renewallessthan50(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Renewal Enrollment for a single customer with usage < 50Kwh with Fixed product";
	String Optyheader;
	String optyid;
	String contractid;
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	String optyID;
	String password;
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	CommonFunctions encrypted = new CommonFunctions();
	VhosPage vhosPage = new VhosPage(base);
	Reports utility;
	HUFileUpload upload;
	XMLFile xml = new XMLFile(base, testContext);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();

	@Then("DSP:Selecting Renew option for the active contract found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		testContext.scenarioContext.setContext(Context.CONTRACT_ID, customer.SelectRenewOption());

	}

	@And("DSP:choose a deal with Fixed product")
	public void price_a_deal() throws Throwable {
		deal.Priceadeal();
	}

	@Then("DSP: Submitsss Contract in Dsp")
	public void Create_Contract_in_Dsp() throws Throwable {
		String Status1=contract.ContractGenerationforRenewal();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Ensuress the contract is generated")
	public void Ensure_the_contract_is_generated() throws Throwable {
		String Status=status.contractcreationlessthan50();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}

}
