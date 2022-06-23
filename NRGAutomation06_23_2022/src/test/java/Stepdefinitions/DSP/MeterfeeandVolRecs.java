package Stepdefinitions.DSP;
import Pages.DSP.GenerateContract;
import Pages.DSP.MeterFeeandVoluntaryRecs;
import Pages.DSP.PriceaDeal;
import Pages.DSP.ViewContract;
import Pages.Siebel.BAApprovescreditinSiebel;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MeterfeeandVolRecs {

	private Base base;
	TestContext testContext;
	public MeterfeeandVolRecs(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}
	GenerateContract contract =new GenerateContract(base) ;
	String Scenario="New Enrollment Single Customer Meter fee Vol Recs";
	MeterFeeandVoluntaryRecs Recs=new MeterFeeandVoluntaryRecs(base);
	ViewContract status =new ViewContract(base) ;
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	String Deal;
	BAApprovescreditinSiebel validateseibel= new BAApprovescreditinSiebel(base);
	@And("DSP: price_a_deal_Meterfee_VolRecs")
	public void price_a_deal_Meterfee_VolRecs() throws Throwable {
		Recs.MeterFeeandVoluntaryRecs();
	}
	
	@Then("DSP: Generate Meterfee Contract in DSP")
	public void generate_contract() throws Throwable {
	String Status1=contract.ContractGeneration();
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
	}
	
	@Then("DSP: Make sure the contract with Meter fee and Vol Recs is generated")
	public void Make_sure_the_contract_is_generated () throws Throwable {
		String Status=status.contractwithMeterfeeVolRecs();
		Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	 
}
