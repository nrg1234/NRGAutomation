package Stepdefinitions.DSP;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
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

public class ReliantE2E {

	private Base base;
	TestContext testContext;
	public ReliantE2E(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}
	String Scenario="Validate new Enrollment for a single customer with Reliant Brand for usage > 50Kwh with Fixed product";
	String customername;
	//String Scenario="Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product";
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
	ConnectToDatabase database=new ConnectToDatabase(base);

	@When("DSP: Add ESID to the new Opty using Billcopy")
	public void add_sites_to_the_opty() throws Throwable {
	//testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitesbillcopy("NewReliant"));
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("NewReliant"));
	}

	
	@Then("DSP: Generate Contract in DSP for Reliant Brand")
	public void Generate_contract_Reliant_Brand() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Make sure the contract is generated for Reliant Brand")
	public void View_Contracts_ReliantBrand() throws Throwable {
	String Status=status.contractcreation();
	//Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
	@Then("DSP: Validate Brand in DSP")
	public void Validate_Brand_DSP() throws Throwable {
	database.SetUpConnectionDSP((String) testContext.scenarioContext.getContext(Context.OPTY_ID));

}

	@Then("VHOS0: Validate Brand in VHOS")
	public void Validate_Brand_VHOS() throws Throwable {
	String Status=database.SetUpConnectionVHOS((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
}
}
