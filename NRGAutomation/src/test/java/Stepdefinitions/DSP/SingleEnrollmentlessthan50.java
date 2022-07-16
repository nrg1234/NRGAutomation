package Stepdefinitions.DSP;
import Pages.DSP.*;
import Pages.VHOS.VhosPage;
import Utilities.*;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class SingleEnrollmentlessthan50 {
	private Base base;
	TestContext testContext;

	public SingleEnrollmentlessthan50(Base base, TestContext context) throws InterruptedException {
		this.base = base;
		testContext = context;
	}
	String Scenario="Validate new Enrollment for a single customer with usage < 50Kwh with Fixed product";
	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	AddProxySiteList Proxy = new AddProxySiteList(base);
	ViewCredit credit = new ViewCredit(base);
	PriceaDeal deal = new PriceaDeal(base);
	GenerateContract contract = new GenerateContract(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	ConfigWrite write = new ConfigWrite(base);
	String customername;
	String optyID;
	String password;
	VhosPage vhos = new VhosPage(base);
	ConnectToDatabase DB = new ConnectToDatabase(base);
	CommonFunctions encrypted = new CommonFunctions();
	Reports utility;
	HUFileUpload upload;
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);

	@Then("DSP:Add Sites to the dsp Opty")
	public void Add_sites_to_the_dsp_opty() throws Throwable {
		sites.AddSitestotheOptylessthan50("site-esidlessthan50");
//Proxy.AddProxySitestotheOpty("site-esidlessthan50","site-esidlessthan50agg");
	}

	@Then("DSP:Converting deal to less than 50kw")
	public void Converting_deal_to_less_than_50kw() throws Throwable {
		//testContext.scenarioContext.setContext(Context.OPTY_ID, credit.Convertingdealtolessthan50kwnew());
		testContext.scenarioContext.setContext(Context.OPTY_ID,credit.Convertingdealtolessthan50kw());
	}

	@Then("VHOS:Authenticate Opportunity in VHOS")
	public void Authenticate_Opportunity_in_VHOS() throws Throwable {
		vhos.ValidateOpportunitydetailsinVHOS((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
	}

	@Then("DSP:Select a deal with Fixed product")
	public void Select_a_deal_with_Fixed_product() throws Throwable {
		deal.priceadeal();
		
		
	}

	@Then("DSP: Create Contract in Dsp")
	public void Create_Contract_in_Dsp() throws Throwable {
		String Status1=contract.ContractGenerationfor50kwh();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}

	@Then("DSP: Ensure the contract is generated")
	public void Ensure_the_contract_is_generated() throws Throwable {
		String Status=status.contractcreationlessthan50();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}

	@Then("DSP DB:Validate PCFlag in DSP DB")
	public void DSPDBPCFlag() throws Throwable {
		DB.SetUpConnectionDSP((String) testContext.scenarioContext.getContext(Context.OPTY_ID));

	}
	@Then("VHOS DB:Validate PCFlag in VHOS DB")
	public void DSPDBVHOSFlag() throws Throwable {
		DB.SetUpConnectionVHOS((String) testContext.scenarioContext.getContext(Context.OPTY_ID));

	}
}

