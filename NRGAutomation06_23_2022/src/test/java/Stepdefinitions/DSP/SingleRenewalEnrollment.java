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
import apphooks.Base;
import io.cucumber.java.en.*;

public class SingleRenewalEnrollment {

	private Base base;
	TestContext testContext;

	public SingleRenewalEnrollment(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Renewal Enrollment for a single customer with usage > 50Kwh with Fixed product";
	String Optyheader;
	String optyid;
	String contractid;
	String customername;
	String optyID;
	String password;
	String Renewalcustomer;
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	CommonFunctions encrypted = new CommonFunctions();
	VhosPage vhosPage = new VhosPage(base);
	Reports utility;
	HUFileUpload upload;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@Then("SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer")
	public void Login_to_Siebel_as_BA() throws Throwable {
		password = encrypted.Encryption();
		
		testContext.scenarioContext.setContext(Context.RENEW_CUST,siebel.SelectRenewalcustomerfromSiebel(password));
		
	}

	@Then("DSP:Select Renew option for the active contract found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		Optyheader=customer.SelectRenewButton(prop.getProperty("Renewcustname"));
		String[] parts = Optyheader.split(",");
		optyid = parts[0];
		contractid = parts[1];
		System.out.println(contractid);
	}
	
	@Then("SIEBEL:Accept Credit in Siebel")
    public void Accepting_Credit_in_Siebel() throws Throwable {
         siebel.BAApprovescreditinSiebel(optyid);
           
    }
	
	 @Then("VHOS: check Opty in VHOS")
	    public void Opty_should_be_validate_in_VHOS() throws Throwable {
	        vhosPage.ValidateOpportunitydetailsinVHOS(optyid);
	        System.out.println("Opportunity has been validated in VHOS");
	    }
	
	@Then("DSP:select Bundling Options as Ancillary and Losses")
	public void dsp_select_bundling_options_as_ancillary_and_losses() {

	}
	
	@Then("SIEBEL:Closing Contract in Siebel")
    public void Modifying_Contract_Status_in_Siebel() throws Throwable {
         siebel.Modifying_Contract_Status(optyid);
           
    }
	
	@Then("DSP: Generatee Contract in DSP")
	public void generate_contract() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Assurr the contract is generated")
	public void View_Contracts() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}

}
