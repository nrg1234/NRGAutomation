package Stepdefinitions.OAM;

import java.util.Properties;

import Pages.DSP.MatrixPricing;
import Pages.OAM.BPP;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BPPCOAM {
    private Base base;
    TestContext testContext;
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
String Scenario="Validate Aggregate Customer addition is not allowed Broker Enrollment < 50Kwh from OAM";
    public BPPCOAM(Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }
    MatrixPricing matrix = new MatrixPricing(base);
    BPP oam =new BPP(base);
    TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
    @When("User select Aggregator oam Third Party from drop down")
    public void user_select_aggregator_oam_third_party_from_drop_down() throws Throwable {
        oam.selectAggregatorThirdParty(prop.getProperty("OAM_ThirdParty"));
    }
    @Given("Add New Opportunity in OAM matrix")
    public void add_new_opportunity_in_oam_matrix() throws Throwable {
        oam.AddnewOpportunity();
    }
    @Then("DSP:  Add Sites to customers in new Opty oam")
    public void dsp_add_sites_to_customers_in_new_opty_oam() throws Throwable {
        testContext.scenarioContext.setContext(Context.OPTY_ID,oam.Addsites());
    }
    @Then("DSP: Navigate to Pricing section oam")
    public void dsp_navigate_to_pricing_section_oam() throws Throwable {
        String Status=oam.Quotesummary();
        Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
    }
    @Then("DSP: Navigate to Contract and billing oam")
    public void dsp_navigate_to_contract_and_billing_oam() throws Throwable {
        oam.ContractandBilling();
    }
}


