package Stepdefinitions.DSP;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.CreateProductinVHos;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Utilities.ConfigWrite;
import Utilities.ConnectToDatabase;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NonErcotEnrollment {
	
	private Base base;
	TestContext testContext;
	public NonErcotEnrollment(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}

	String customername;
	String Scenario="Validate new Enrollment for a single customer for Non Ercot Opportunity for usage > 50Kwh with Fixed product ";
	CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
	AddCustomerPopup customer=new AddCustomerPopup(base) ;
	AddSitesPopup sites=new AddSitesPopup(base) ;
	ViewCredit credit=new ViewCredit(base) ;
	PriceaDeal deal=new PriceaDeal(base) ;
	GenerateContract contract =new GenerateContract(base) ;
	ViewContract status =new ViewContract(base) ;
	SendContracttoCustomer sendContract =new SendContracttoCustomer(base) ;
	XMLFile opty=new XMLFile(base, testContext);
	ConfigWrite write=new ConfigWrite(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	CreateProductinVHos product=new CreateProductinVHos(base);
	ConnectToDatabase database=new ConnectToDatabase(base);
	@When("DSP: Add NonErcot Opportunity")
	public void create_new_opportunity() throws Throwable {
	opty.OptyXML1();
	}

	@When("DSP: Add ESIDS to the new Opty")
	public void add_sites_to_the_opty() throws Throwable {
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("NonErcot"));
	}

	@Then("DSP: Create Product in VHOS")
	public void create_product() throws Throwable {
	product.CreateProductinvhos();
	}
	
	@Then("DSP: Generate NonErcot Contract in DSP")
	public void generate_NonErcot_contract() throws Throwable {
	String Status1=contract.ContractGenerationNonercot();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("VHOS1: Validate Brand in VHOS1")
	public void Validate_Brand_VHOS1() throws Throwable {
	String Status=database.SetUpConnectionVHOS1((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
}
	
	
	
}
