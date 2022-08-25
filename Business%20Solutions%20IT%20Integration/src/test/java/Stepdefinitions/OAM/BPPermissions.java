package Stepdefinitions.OAM;

import java.util.Properties;

import Pages.OAM.BrokerPricingNeg01;
import Pages.OAM.OAMLandingPage;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BPPermissions {

	private Base base;
	TestContext testContext;

	public BPPermissions(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
String Scenario="Validate Pricing Link permission validation for different OAM users";
	OAMLandingPage OamLandingPage = new OAMLandingPage(base);
	BrokerPricingNeg01 Neg = new BrokerPricingNeg01(base);
	ConfigWrite write=new ConfigWrite(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	String tesdata="Sridhar.dhusa@nrg.com\"Gayathiri.KS@nrg.com";
	@Given("Internal Super User successfully logged into OAM")
	public void Internal_Super_User_successfully_logged_into_OAM() {
		OamLandingPage.launchurlOAM();
		OamLandingPage.TitleValidationOAM();
		OamLandingPage.Login(prop.getProperty("OAM_Username"), prop.getProperty("OAM_Password"));
	}

	@When("User selects Third party from OAM")
	public void user_select_aggregator_third_party_from_drop_down1() throws Throwable {
		Neg.selectAggregatorThirdParty(prop.getProperty("OAM_ThirdParty"));

	}

	@Then("Pricing link should appear")
	public void Pricing_Link_Validation1() throws Throwable {
		Neg.ValidatingPricinglink();

	}

	@When("User is selecting Third party from OAM")
	public void user_select_aggregator_third_party_from_drop_down2() throws Throwable {
		Neg.selectAggregatorThirdParty(prop.getProperty("OAM_THirparty"));

	}

	@Then("Pricing link should not appear")
	public void Pricing_Link_Validation2() throws Throwable {
		Neg.ValidatingPricinglink1();

	}

	@When("selecting Third party from OAM")
	public void user_select_aggregator_third_party_from_drop_down3() throws Throwable {
		Neg.selectAggregatorThirdParty(prop.getProperty("OAM_THIrdparty"));

	}

	@Then("Pricing link must not appear")
	public void Pricing_Link_Validation3() throws Throwable {
		Neg.ValidatingPricinglink1();

	}

	@When("Choose Third party from OAM")
	public void user_select_aggregator_third_party_from_drop_down4() throws Throwable {
		Neg.selectAggregatorThirdParty(prop.getProperty("OAM_THIRdparty"));

	}

	@Then("Pricing link shouldn't appear")
	public void Pricing_Link_Validation4() throws Throwable {
		Neg.ValidatingPricinglink1();
		Neg.logout();

	}

	@Given("New Super User successfully logged into OAM")
	public void Internal_Super_User_successfully_logged_into_OAM1() {

		Neg.Loginagain(prop.getProperty("OAM_Username1"), prop.getProperty("OAM_Password1"));

	}

	@When("selects Third party from OAM")
	public void user_select_aggregator_third_party_from_drop_down5() throws Throwable {
		Neg.selectAggregatorThirdParty(prop.getProperty("OAM_ThirdParty"));

	}

	@Then("Pricing link should be appeared")
	public void Pricing_Link_Validation5() throws Throwable {
		String Status=Neg.ValidatingPricinglink();
		Result.ResultintoExcel(tesdata,Scenario, Status);
	}
}