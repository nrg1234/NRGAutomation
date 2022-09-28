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
import io.cucumber.java.en.Then;

public class CMATC {
	private Base base;
	TestContext testContext;
	public CMATC (Base base, TestContext context) {
	this.base = base;
	testContext = context;
}
	String Scenario="Validate new Enrollment for a single customer with usage > 50Kwh with TC Template";
	String customername;
	
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
	
	@Then("DSP: Generate Contract in DSP with TC")
	public void dsp_generate_contract_in_dsp_with_tc() throws Throwable {
		String Status=  contract.ContractGenerationTConly();
	   Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
	}
	
}