package Stepdefinitions.DSP;

import java.util.HashMap;
import java.util.Properties;

import Pages.DSP.CreateOptyPopup;
import Pages.DSP.MatrixPricing;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MatrixPriceDealGreaterthan50 {
	private Base base;
	String Scenario="DSP Matrix Deal > 50kwh";
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public MatrixPriceDealGreaterthan50(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}

	CreateOptyPopup matrixopportunity = new CreateOptyPopup(base);
	MatrixPricing matrix = new MatrixPricing(base);
	XMLFile opty = new XMLFile(base, testContext);

	@Given("DSP: Click on ENTER MATRIX PRICE DEAL")
	public void dsp_click_on_enter_matrix_price_deal() throws Throwable {

		// matrixopportunity.CreateMatrixOpportunity();
		opty.OptyXMLMatrix();
	}

	//@Then("DSP:Create a oppourtinty")
//public void dsp_create_a_oppourtinty() throws Throwable {
//
//}
	@Then("DSP: Add customer to the Opty")
	public void dsp_add_customer_to_the_opty() throws Throwable {
		matrix.Addcustomer();
	}

	@Then("DSP:  Add Sites to customers in new Opty")
	public void dsp_add_sites_to_customers_in_new_opty() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID, matrix.Addsites());
	}

	@Then("DSP: Navigate to Pricing section")
	public void dsp_navigate_to_pricing_section() throws Throwable {
		matrix.Quotesummary();
	}
	@Then("DSP: Add customer to the Opty1")
	public void dsp_add_customer_to_the_opty1() throws Throwable {
		String Status=matrix.Addcustomer1();
		 Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
//@Then("DSP:pricing a deal  in DSP")
//public void dsp_pricing_a_deal_in_dsp() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//@Then("DSP:Enter the contact and Billing details")
//public void dsp_enter_the_contact_and_billing_details() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//@Then("DSP:Upload the Contract document in DSP")
//public void dsp_upload_the_contract_document_in_dsp() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
}
