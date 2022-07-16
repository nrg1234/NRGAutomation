package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.AddBroker;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class AddBrokerValidation {
	private Base base;
	TestContext testContext;
	String Scenario="Broker Validation for Matrix Pricing >50kwh";
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public AddBrokerValidation(Base base, TestContext context) {
		this.base = base;
		testContext = context;
}
	AddBroker validate = new AddBroker (base);
	ConfigWrite write=new ConfigWrite(base);
	XMLFile opty=new XMLFile(base, testContext);
	
	@Then("DSP: Add third party which is not set up for matrix pricing in Siebel")
	public void dsp_add_third_party_which_is_not_set_up_for_matrix_pricing_in_siebel() throws Throwable {
	    opty.OptyXMLAddbroker();
	}


	@Then("DSP: Add third party which is set up for matrix pricing in Siebel")
	public void dsp_add_third_party_which_is_set_up_for_matrix_pricing_in_siebel() throws Throwable {
		String Status=opty.OptyXMLMatrix();
		Result.ResultintoExcel("Working fine",Scenario, Status);
	}

}
