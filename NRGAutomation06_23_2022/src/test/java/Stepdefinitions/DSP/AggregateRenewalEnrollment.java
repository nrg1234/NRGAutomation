package Stepdefinitions.DSP;
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
import Utilities.CommonFunctions;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AggregateRenewalEnrollment {
	private Base base;
	TestContext testContext;

	public AggregateRenewalEnrollment(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Renewal Enrollment for a Aggregate customer with usage > 50Kwh with Fixed product";
	String customername;
	String optyID;
	String password;
	String Renewalcustomer;
	String customer1;
	String customer2;
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	ConfigWrite write=new ConfigWrite(base);
	CommonFunctions encrypted = new CommonFunctions();
	Reports utility;
	HUFileUpload upload;
	XMLFile opty=new XMLFile(base, testContext);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@When("DSP: Add New renewal Opportunity")
	public void create_new_opportunity() throws Throwable {
	opty.OptyXMLrenewal();
	}

	@Then("SIEBEL:Login to Siebel as BA and Picking up Aggregate Renewal Customer")
	public void Login_to_Siebel_as_BA() throws Throwable {
		password = encrypted.Encryption();
		Renewalcustomer=siebel.SelectRenewalAggregatecustomerfromSiebel(password);
		String[] parts = Renewalcustomer.split(",");
		customer1 = parts[0];
		customer2 = parts[1];

	}

	@Then("DSP:Pick Renew option for the active contracts found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID,customer.SelectRenewButtonforAggregate(customer1, customer2));
	}
	
	@Then("DSP:Generatingg Contract details in DSP")
	public void Generating_Contract_details_in_DSP() throws Throwable {
	String Status1=contract.GenerateContractforAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Assure the contract is generated")
	public void View_Contracts() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
	
	
	@Then("DSP:selecting Bundling Options as Ancillary and Losses")
	public void dsp_select_bundling_options_as_ancillary_and_losses() {

	}

}
