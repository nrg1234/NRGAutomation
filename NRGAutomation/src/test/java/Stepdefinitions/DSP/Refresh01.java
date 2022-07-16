package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.Login;
import Pages.VHOS.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Refresh01 {
	String password;
	String Optyheader;
	String optyid;
	String contractid;
	private Base base;
	TestContext testContext;

	public Refresh01(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Refresh Enrollment after adding Site amendment with usage > 50Kwh with Index product";
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	CommonFunctions encrypted = new CommonFunctions();
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	VhosPage vhosPage = new VhosPage(base);
	Login login = new Login(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@Then("DSP:Choose Renew Option for the active contract found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		Optyheader = customer.SelectRenewRefresh(prop.getProperty("Refresh"));
		String[] parts = Optyheader.split(",");
		optyid = parts[0];
		contractid = parts[1];
		System.out.println(optyid);
		System.out.println(contractid);
	}

	@Then("SIEBEL:Accepting Credit and create amendment in Siebel")
	public void Accepting_Credit_and_creating_amendment_in_Siebel() throws Throwable {
		siebel.BAApprovescreditandcreatesamendmentinSiebel(optyid,contractid);
	}

	@Then("DSP: validate sites in DSP after refresh")
	public void validate_sites_in_DSP_after_refresh() throws Throwable {
		sites.validatesitesinDSP();

	}

	@Then("VHOS: Validate Opty id in VHOS")
	public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
		vhosPage.ValidateOpportunitydetailsinVHOS(optyid);
		System.out.println("Opportunity has been validated in VHOS");
	}
	
	
	@Then("DSP: Create Contract in DSP")
	public void generate_contract() throws Throwable {
	contract.ContractGenerationforSingle();
	}
	
	@Then("DSP: Generatess Contract in DSP")
	public void generates_contract() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Assuringg the contract is generated")
	public void View_Contracts() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
	

}
