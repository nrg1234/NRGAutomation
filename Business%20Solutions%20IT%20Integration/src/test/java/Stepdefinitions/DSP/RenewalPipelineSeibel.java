package Stepdefinitions.DSP;

import java.util.Properties;

import Pages.DSP.GenerateContract;
import Pages.DSP.PipelineSeibel;
import Pages.DSP.ViewContract;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RenewalPipelineSeibel {
	String Scenario="Renewal Pipeline Seibel > 50kw";
	private Base base;
	TestContext testContext;
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();

	public RenewalPipelineSeibel(Base base, TestContext context) {
		this.base = base;
		testContext = context;
	}
	ViewContract status = new ViewContract(base);
	PipelineSeibel renewals = new PipelineSeibel (base);
	GenerateContract contract =new GenerateContract(base) ;
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	@Given("DSP: Click on Renewal Pipeline")
	public void dsp_click_on_renewal_pipeline() throws Throwable {
		testContext.scenarioContext.setContext(Context.OPTY_ID, renewals.Addcustomer());
	}

	@Then("DSP: User Generates Contract in DSP")
	public void generate_contract() throws Throwable {
	String Status1=contract.ContractGenerate();
	 Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}

	
	@Then("DSP: Assure the contract is generated for Renewal Pipeline Opportunity")
	public void View_Contracts_RenewalPipelineOpprtunity() throws Throwable {
	String Status=status.contractcreationRenewalAggregate();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}


}
