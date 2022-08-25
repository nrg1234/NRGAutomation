package Stepdefinitions.OAM;
import java.util.Properties;
import Pages.OAM.OAMLandingPage;
import Utilities.ConfigReader;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Given;

public class LoginOAM {
	private Base base;
	TestContext testContext;
	public LoginOAM(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}

	OAMLandingPage OamLandingPage = new OAMLandingPage(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	@Given("Broker successfully logged into OAM")
	public void broker_successfully_logged_into_oam() {
		OamLandingPage.launchurlOAM();
		OamLandingPage.TitleValidationOAM();
		OamLandingPage.Login(prop.getProperty("OAM_Username1"),prop.getProperty("OAM_Password1"));
		 System.out.println("Page Title is Welcome | NRG Energy");
	}


	}


