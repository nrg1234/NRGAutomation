package Stepdefinitions.DSP;

import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class BlockandIndex {
	private Base base;
	TestContext testContext;
	public BlockandIndex(Base base, TestContext context) {
	this.base = base;
	testContext = context;
}
	PriceaDeal deal=new PriceaDeal(base) ;
	GenerateContract contract =new GenerateContract(base) ;
	
	@Then("VHOS: Create B&I deal in VHOS")
	public void vhos_create_b_i_deal_in_vhos() throws Throwable {
	  deal.priceadealBlockandIndex();
	}
	@Then("DSP: Generate B&I Contract")
	public void dsp_generate_b_i_contract() throws Throwable {
	    contract.ContractGenerationBI();
	}
}