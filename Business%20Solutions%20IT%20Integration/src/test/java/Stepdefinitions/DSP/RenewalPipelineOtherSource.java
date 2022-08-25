package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.GenerateContract;
import Pages.DSP.PipelineSeibel;
import Pages.DSP.PriceaDeal;
import Pages.DSP.ViewContract;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RenewalPipelineOtherSource {
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	String Scenario="Renewal Pipeline other source";
	GenerateContract contract =new GenerateContract(base) ;
	ViewContract status = new ViewContract(base);
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public RenewalPipelineOtherSource(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	PipelineSeibel renewals = new PipelineSeibel (base);
	PriceaDeal deal=new PriceaDeal(base) ;

	@Given("DSP: Clicks on Renewal Pipeline and Selects Other Source customer")
	public void dsp_click_on_renewal_pipeline() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID, renewals.AddcustomerOtherSource());
	}
	
	@And("DSP: price a deal with Fixed product for other source")
	public void price_a_deal() throws Throwable {
	deal.priceadealforOtherSource();
	
	}

	
	@Then("DSP: Generate Contract for Renewal Othersource Opportunity in DSP")
	public void generate_contract_Othersource() throws Throwable {
	String Status1=contract.ContractGenerate();
	 Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}

	
	@Then("DSP: Assure the contract is generated for Renewal Pipeline Other source")
	public void View_Contracts_() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
}

	

