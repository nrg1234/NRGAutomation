package Stepdefinitions.DSP;
import java.util.HashMap;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.WOLR;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WOLRLOST {

	private Base base;
	TestContext testContext;

	public WOLRLOST(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	
	String Scenario="Validate WOLR Lost Report Generation";
	 TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	HashMap<String, String> OptyHeader;
	WOLR Lost = new WOLR(base);
	XMLFile opty = new XMLFile(base, testContext);
	ConfigWrite write=new ConfigWrite(base);
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer=new AddCustomerPopup(base) ;
	@When("DSP: Adding New Opportunity")
	public void create_new_opportunity() throws Throwable {
		ReadXMLFile xml = new ReadXMLFile();
		OptyHeader = xml.getSubmittedOptyFromXML();
		testContext.scenarioContext.setContext(Context.Opty_Header,opportunity.CreateNewOpportunity(OptyHeader));
	}
	@Then("DSP:Add customer to opportunity")
	public void Add_customer_to_opportunity() throws Throwable {
		customer.AddCustomertoOpportunity("Adam & Joe Food Mart Inc");


	}
	@Then("Make sure user access DSP next day and Submits Lost Report")
	public void dsp_select_send_blank_loa_from_opportunity_drop_down() throws Throwable {
		String Status=Lost.LostReport((String) testContext.scenarioContext.getContext(Context.Opty_Header));
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opty_Header),Scenario, Status);
	}

}
