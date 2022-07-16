package Stepdefinitions.OAM;
import java.util.Properties;
import Pages.OAM.BrokerPricingNeg01;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BPNeg01  {

	private Base base;
	TestContext testContext;
	String Scenario="Validate Multiple TDSP Site and Non-ERCOT site addition is not allowed for Broker Enrollment < 50Kwh from OAM";
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	public BPNeg01(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}

	BrokerPricingNeg01 Neg = new BrokerPricingNeg01(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@When("User select Aggregator Third Party from drop down")
	public void user_select_aggregator_third_party_from_drop_down() throws Throwable {
		String Status1=Neg.selectAggregatorThirdParty(prop.getProperty("OAM_ThirdParty"));
		if(Status1!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status1);
		}
	}

	@Then("make sure user navigates to Enrollment Page")
	public void make_sure_he_she_navigates_to_enrollment_page() throws Throwable {
		String Status2=Neg.navigatingToEnrollmentPage();
		if(Status2!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status2);
	}
	}
	@Given("Add New Opportunity in OAM")
	public void add_new_opportunity_in_oam() throws Throwable {
	  String Status3=  Neg.AddnewOpportunity();
	  if(Status3!=null) {
	  Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status3);
	}
	}
	@When("Add Customer to the new Opty")
	public void add_customer_to_the_new_opty() throws Throwable {
	
	   String Status4= Neg.AddcustomertoOpportunity();
		if(Status4!=null) {
	   Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status4);
	}
	}

	@Then("Add Sites to the new Opty")
	public void add_sites_to_the_new_opty() throws Throwable {
		testContext.scenarioContext.setContext(Context.Opportunityname,Neg.AddsitestoOpportunity());
		
	}

	@Given("User access the same oppurtunity from DSP")
	public void user_access_the_same_oppurtunity_from_dsp() throws Throwable {
		Neg.Navigatetodsp((String) testContext.scenarioContext.getContext(Context.Opportunityname));
		
	}


	@When("user add Non-ERCOT Site to this oppurtunity")
	public void user_add_non_ercot_site_to_this_oppurtunity() throws Throwable {
		String Status5=Neg.AddNonErcotSites();
		System.out.println(Status5);
		if(Status5!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status5);
	}
	}
	

	@Then("validate Non-ERCOT Site addition is not allowed for this oppurtunity")
	public void validate_non_ercot_site_addition_is_not_allowed_for_this_oppurtunity() throws Throwable {
		Neg.ValidateNonErcotSites();
		
	}
	
	public String result() {
		
		
		return Scenario;
	}
	
	
}
