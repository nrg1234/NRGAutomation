package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.MatrixPricing;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Matrixlessthan50 {
    private Base base;
    TestContext testContext;
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
String Scenario="DSP Matrix < 50kwh";
TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);

    public Matrixlessthan50(Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }
    MatrixPricing matrix = new MatrixPricing(base);
    XMLFile opty = new XMLFile(base, testContext);
    @Given("DSP: Click on Enter MATRIX Deal")
    public void dsp_click_on_enter_matrix_deal() throws Throwable {
    	testContext.scenarioContext.setContext(Context.Opportunityname, opty.OptyXMLMatrixless());
        
    }
    @Then("DSP:  Add less than fifty Sites to customers in new Opty")
    public void dsp_add_less_than_fifty_sites_to_customers_in_new_opty() throws Throwable {
        testContext.scenarioContext.setContext(Context.OPTY_ID, matrix.Addlessthan50sites());
    }
    @Then("DSP: Navigate to less than Pricing section oam")
    public void dsp_navigate_to_less_than_pricing_section_oam() throws Throwable {
        matrix.lessthan50Quotesummary((String) testContext.scenarioContext.getContext(Context.Opportunityname));
    }
    @When("SIEBEL: Check pc flag in seibel")
    public void siebel_check_pc_flag_in_seibel() throws Throwable {
        String Status=matrix.pccheck((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
        Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
    }
}



