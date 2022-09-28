package Stepdefinitions.OAM;
import java.util.Properties;
import Pages.OAM.OAMLandingPage;
import Pages.OAM.AddBank;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class AddBankAcc {
	CommonFunctions functions = new CommonFunctions();
	private Base base;
	TestContext testContext;

	public AddBankAcc(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
String Scenario="OAM Manage Payment ACH";
String Scenario1="OAM Manage Payment using CC";
String Status2="Pass";
	OAMLandingPage OamLandingPage = new OAMLandingPage(base);
	AddBank AddBank = new AddBank(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	String BankAccountNo="0000000016";
	String Creditcard="4444444444444440";
//	BrokerPricingNeg01 Neg = new BrokerPricingNeg01(base);
	ConfigWrite write=new ConfigWrite(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();

	@Given("Tester logged successfully into OAM")
	public void broker_successfully_logged_into_oam() throws Throwable {
		OamLandingPage.launchurlOAMDev();
		OamLandingPage.Login(prop.getProperty("OAM_Username2"),prop.getProperty("OAM_Password1"));
		functions.mintermediatewait();
		System.out.println("Page Title is Welcome | NRG Energy");
		
	}

	@And("User select Customer from drop down")
	public void CustomerSelect() throws Throwable , InterruptedException{
		// Select the option using the visible text
		AddBank.Custselect();
		AddBank.Billselect();
		AddBank.ACHPaymentMeth();
			
	}
	
	@Then("Add ACH account Validation")
	public void AddaccountValidation() throws Throwable {
		// Select the option using the visible text
		String Status=AddBank.AddachValidation();
		Result.ResultintoExcel(BankAccountNo,Scenario, Status2);
	
	}
	

	
	@Then("User select Credit Card Customer from drop down")
	public void CustomerSelectCC() throws Throwable , InterruptedException{
		// Select the option using the visible text
		AddBank.CustselectforCreditcard();
	   AddBank.Billselect();
		String Status1=AddBank.CreditcardPaymentMethod();
		Result.ResultintoExcel(Creditcard,Scenario1, Status1);
				
	}	
	

}