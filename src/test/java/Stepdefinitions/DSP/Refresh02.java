package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.ViewContract;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.Login;
import Pages.VHOS.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class Refresh02 {
	String password;
	String Optyheader;
	String optyid;
	String contractid;
	private Base base;
	TestContext testContext;
	GenerateContract contract = new GenerateContract(base);
	public Refresh02(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
String Scenario="Validate Refresh Enrollment after removing Site amendment with usage > 50Kwh with Fixed product";
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	VhosPage vhosPage = new VhosPage(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	Login login = new Login(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	CommonFunctions encrypted = new CommonFunctions();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	ViewContract status = new ViewContract(base);
	@Then("DSP:Selects Renew Option for the active contract found")
	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
		Optyheader = customer.SelectRenewRefresh(prop.getProperty("Refresh"));
		String[] parts = Optyheader.split(",");
		optyid = parts[0];
		contractid = parts[1];
		System.out.println(optyid);
		System.out.println(contractid);
	}

	
	@Then("SIEBEL:Approve Credit and Upload amendment for Delete Sites in Siebel")
	public void Accepting_Credit_and_Delete_amendment_in_Siebel() throws Throwable {
		siebel.BAApprovescreditanddeleteamendmentinSiebel(optyid,contractid);

	}
	
	@Then("VHOS: Verifying Opty id in VHOS")
	public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
		vhosPage.ValidateOpportunitydetailsinVHOS(optyid);
		System.out.println("Opportunity has been validated in VHOS");
	}
	
	
	@Then("DSP: Generate Contract in DSP for Amendment delete Opportunity")
	public void generates_contract_Amendment() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}

	
	@Then("DSP: Assure the contract is generated for Amendment delete Opportunity")
	public void View_Contracts_AmendmentOpportunity() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
}
