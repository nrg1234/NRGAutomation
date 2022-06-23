package Stepdefinitions.OAM;
import java.util.Properties;
import Pages.OAM.BrokerPricingNeg01;
import Pages.OAM.BrokerPricingNeg02;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BPNeg02 {
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	public BPNeg02(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate Aggregate Customer addition is not allowed Broker Enrollment < 50Kwh from OAM";
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	BrokerPricingNeg01 Neg = new BrokerPricingNeg01(base);
	BrokerPricingNeg02 Neg02 = new BrokerPricingNeg02(base);

	@When("User choose Aggregator Third Party from drop down")
	public void user_select_aggregator_third_party_from_drop_down() throws Throwable {
		String Status1=Neg.selectAggregatorThirdParty(prop.getProperty("OAM_ThirdParty"));
		if(Status1!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status1);
	}
	}

	@Then("user navigates to Enrollment Page")
	public void make_sure_he_she_navigates_to_enrollment_page() throws Throwable {
		String Status2=Neg.navigatingToEnrollmentPage();
		if(Status2!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status2);
	}
	}

	@Given("Adding New Opportunity in OAM")
	public void add_new_opportunity_in_oam() throws Throwable {
		String Status3=Neg02.CreateNewOpportunity();
		if(Status3!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status3);
		}
	}
	@When("Add Aggregate Customer to the new Opty")
	public void add_customer_to_the_new_opty() throws Throwable {
		String Status4=Neg02.AddAggregateCustomer();
		if(Status4!=null) {
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.Opportunityname),Scenario, Status4);
	}
	}
	
	@Then("Add Aggregate Sites to the new Opty")
	public void add_sites_to_the_new_opty() throws Throwable {
		Neg02.AddsitestotheOpportunity();

	}

	@Then("Send Email to Customer")
	public void Send_Email_to_Customer() throws Throwable {
		String Status5=Neg02.SendEmailtoCustomer();
		if(Status5!=null) {
		 Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status5);
		}
	}
	
	//@Then("Validate Aggregations quotes have a peak demand of >50kw")
	//public void Validate_Aggregations_quotes_have_a_peak_demand() throws Throwable {
	//	Neg02.SendEmailtoCustomer();

	//}
	

}
