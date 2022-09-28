package Stepdefinitions.DSP;
import java.util.HashMap;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.ClosingOpportunity;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.WOLR;
import Pages.Siebel.BAApprovescreditinSiebel;
import Utilities.Context;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WOLRWon {

	private Base base;
	TestContext testContext;

	public WOLRWon(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate WOLR Won Report Generation";
	HashMap<String, String> OptyHeader;
	WOLR Lost = new WOLR(base);
	XMLFile opty = new XMLFile(base, testContext);
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	ClosingOpportunity Close=new ClosingOpportunity(base);
	BAApprovescreditinSiebel siebel=new BAApprovescreditinSiebel(base) ;
	AddSitesPopup sites = new AddSitesPopup(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	 TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	 GenerateContract contract =new GenerateContract(base) ;
	@When("DSP: Make New Opportunity")
	public void create_new_opportunity() throws Throwable {
		ReadXMLFile xml = new ReadXMLFile();
		OptyHeader = xml.getSubmittedOptyFromXML();
		testContext.scenarioContext.setContext(Context.Opty_Header,opportunity.CreateNewOpportunity(OptyHeader));
	}

	
	@When("DSP: Add Sites to the Won Opportunity")
	public void add_sites_to_the_opty() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID, sites.AddSitestotheOpty("siteforwon"));
		System.out.println("Sites successfully added to the Opportunity");
	}

//	@When("DSP: Send to Closed")
//	public void Send_to_Closed() throws Throwable {
//		sendContract.PassingEmailtoSendcontracttocustomerpopup();
//		siebel.Modifying_Contract_Status((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
//
//	}
	

	@Then("DSP: Generate Contract for Won Report Opportunity")
	public void generate_contract() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}

	@Then("user access DSP next day")
	public void dsp_select_send_blank_loa_from_opportunity_drop_down() throws Throwable {
		String Status=Lost.WonReport((String) testContext.scenarioContext.getContext(Context.Opty_Header));
		//Close.CloseOpportunity((String) testContext.scenarioContext.getContext(Context.Opty_Header));
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opty_Header),Scenario, Status);

	}

}
