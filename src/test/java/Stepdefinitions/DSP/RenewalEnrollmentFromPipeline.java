//package Stepdefinitions.DSP;
//
//import Pages.DSP.AddCustomerPopup;
//import Pages.DSP.AddSitesPopup;
//import Pages.DSP.CreateOptyPopup;
//import Pages.DSP.GenerateContract;
//import Pages.DSP.HUFileUpload;
//import Pages.DSP.PriceaDeal;
//import Pages.DSP.SendContracttoCustomer;
//import Pages.DSP.ViewContract;
//import Pages.DSP.ViewCredit;
//import Pages.Siebel.BAApprovescreditinSiebel;
//import Pages.VHOS.VhosPage;
//import Utilities.CommonFunctions;
//import Utilities.Context;
//import Utilities.Reports;
//import Utilities.TestContext;
//import apphooks.Base;
//import io.cucumber.java.en.Then;
//
//public class RenewalEnrollmentFromPipeline {
//
//	private Base base;
//	TestContext testContext;
//
//	public RenewalEnrollmentFromPipeline(Base base, TestContext context) {
//		this.base = base;
//		testContext = context;
//	}
//	
//	String Optyheader;
//	String optyid;
//	String contractid;
//	String customername;
//	String optyID;
//	String password;
//	String Renewalcustomer;
//	CreateOptyPopup opportunity = new CreateOptyPopup(base);
//	AddCustomerPopup customer = new AddCustomerPopup(base);
//	AddSitesPopup sites = new AddSitesPopup(base);
//	ViewCredit credit = new ViewCredit(base);
//	PriceaDeal deal = new PriceaDeal(base);
//	GenerateContract contract = new GenerateContract(base);
//	ViewContract status = new ViewContract(base);
//	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
//	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
//	CommonFunctions encrypted = new CommonFunctions();
//	VhosPage vhosPage = new VhosPage(base);
//	Reports utility;
//	HUFileUpload upload;
//	
//	
//	@Then("DSP:Select Renew option from the Renewal pipeline")
//	public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
//		testContext.scenarioContext.setContext(Context.OPTY_ID,customer.SelectRenewAutoOptionforSingle());
//		
//	}
//	
//	
//	
////	@Then("DSP:select Bundling Options as Ancillary and Losses")
////	public void dsp_select_bundling_options_as_ancillary_and_losses() {
////
////	}
//	
//}
