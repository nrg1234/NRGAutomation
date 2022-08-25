package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.BrokerUiNormalDeal;
import Pages.DSP.MatrixMarginGroup;
import Pages.OAM.BrokerPricingNeg01;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrokerPricingUINormalDeal {
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
String Scenario="Broker Pricing UI Normal Deal";
TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public BrokerPricingUINormalDeal(Base base, TestContext context) {
		this.base = base;
		testContext = context;
		
	}
	BrokerUiNormalDeal normal = new BrokerUiNormalDeal(base);
	BrokerPricingNeg01 neg=new BrokerPricingNeg01(base);
	ConfigWrite write=new ConfigWrite(base);
	XMLFile opty=new XMLFile(base, testContext);
	

	@When("DSP: Add New Broker Opportunity")
	public void dsp_add_new_broker_opportunity() throws Throwable {
	   opty.OptyXMLbroker();
	}
	
	@And("DSP:Change to broker view")
	public void dsp_change_to_broker_view() throws Throwable {
		String Status= normal.changetobrokerview();
	    Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	@Then("DSP:Continue to Pricing")
	public void dsp_continue_to_pricing() throws Throwable {
	normal.continuetopricing();
	

	}

}

	
	


