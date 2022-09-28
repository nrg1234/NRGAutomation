package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.BrokerUiNormalDeal;
import Pages.DSP.HomePageFunction;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class HomePageFunctionality {
	String Scenario="Home Page Functionality";
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public HomePageFunctionality(Base base, TestContext context) {
		this.base = base;
		testContext = context;
}
	HomePageFunction function = new HomePageFunction (base);
	ConfigWrite write=new ConfigWrite(base);
	XMLFile opty=new XMLFile(base, testContext);
	
	@Then("DSP: Click on Dropdown Filter Button")
	public void dsp_click_on_dropdown_filter_button() throws Throwable {
	 function.dropdownfilter();
	}
	@Then("DSP: Click on Table Options Filter Button")
	public void dsp_click_on_table_options_filter_button() throws Throwable {
	  function.Tableoptionfilter();
	}
	@Then("DSP: Click on Customer Name Filter")
	public void dsp_click_on_customer_name_filter() throws Throwable {
	 function.Customernamefilter();
	}
	@Then("DSP: Click on Sales Channel Filter")
	public void dsp_click_on_sales_channel_filter() throws Throwable {
	  function.Saleschannelfilter();
	}
	@Then("DSP: Click on Market Filter")
	public void dsp_click_on_market_filter() throws Throwable {
	   function.Marketfilter();
	}
	@Then("DSP: Click on Opportunity Type Filter")
	public void dsp_click_on_opportunity_type_filter() throws Throwable {
	  function.Opportunitytypefilter();
	}
	@Then("DSP: Click on Deal Type Filter")
	public void dsp_click_on_deal_type_filter() throws Throwable {
	   function.Dealtypefilter();
	}
	@Then("DSP: Click on WOLR Filter")
	public void dsp_click_on_wolr_filter() throws Throwable {
      function.Wolrfilter();
	}
	@Then("DSP: Click on Third Party Filter")
	public void dsp_click_on_third_party_filter() throws Throwable {
	 function.Thirdpartyfilter();
	}
	@Then("DSP: Click on End Date Filter")
	public void dsp_click_on_end_date_filter() throws Throwable {
	   function.Enddatefilter();
	}
	@Then("DSP: Click on Broker Filter")
	public void dsp_click_on_broker_filter() throws Throwable {
	   String Status=function.Brokerfilter();
	   Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}



	
}