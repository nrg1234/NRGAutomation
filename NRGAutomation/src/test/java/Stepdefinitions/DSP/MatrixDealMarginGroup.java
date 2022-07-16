package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.MatrixMarginGroup;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MatrixDealMarginGroup {
	String Scenario="DSP Matrix Deal Margin Group creation";
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	String Marginname;
	public MatrixDealMarginGroup(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	MatrixMarginGroup margin = new MatrixMarginGroup (base);
	ConfigWrite write=new ConfigWrite(base);

	@Given("DSP: Click on Maintenance")
	public void dsp_click_on_maintenance() throws Throwable {
	    margin.clickMaintenance();
	}
	@Then("DSP:Enter all the Details")
	public void dsp_enter_all_the_details() throws Throwable {
	  Marginname=margin.createMargingroup();
	}
	@Then("DSP: Click on submit button")
	public void dsp_click_on_submit_button() throws Throwable {
	   String Status= margin.submit();
	    Result.ResultintoExcel(Marginname,Scenario, Status);
	}



}
