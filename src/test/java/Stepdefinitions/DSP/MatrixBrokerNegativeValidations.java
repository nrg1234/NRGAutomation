package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.BrokerNegativeValidations;
import Pages.DSP.LandingPage;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MatrixBrokerNegativeValidations {
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
String Scenario="Matrix broker negative validations";
TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public MatrixBrokerNegativeValidations(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	BrokerNegativeValidations validation= new BrokerNegativeValidations(base);
	LandingPage land=new LandingPage(base);


	@Then("DSP:  Add Sites to customers")
	public void dsp_add_sites_to_customers() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID, validation.Addsites());
	}
	@Then("DSP:  logout dsp")
	public void dsp_logout_dsp() throws Throwable {
		validation.logout();
	}
	@Then("DSP:  Add Sites1 to customers")
	public void dsp_add_sites1_to_customers() throws Throwable {
		validation.Addsites1();
	}

	@Given("DSP: Clicks on All Opportunities multiple")
	public void dsp_clicks_on_all_opportunities_multiple() throws InterruptedException {
		land.AllOpportunitiesmultiple();
	}
	@Then("DSP:  Add Sites2 to customers")
	public void dsp_add_sites2_to_customers() throws Throwable {
		validation.Addsites3();
	}
	@Then("DSP:  Add Sites3 to customers")
	public void dsp_add_sites3_to_customers() throws Throwable {
		validation.Addmultiplesites3();
	}
	@Then("DSP: Add four ESID to the Opportunity")
	public void dsp_add_sites8_to_customers() throws Throwable {
		String Status=validation.Addmultiplesites8();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}








}
