package Stepdefinitions.DSP;
import java.util.Properties;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.HUFileUpload;
import Pages.DSP.PipelineSeibel;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.VHOS.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class RenewalforGME {

		private Base base;
		TestContext testContext;

		public RenewalforGME(Base base, TestContext context) {
			this.base = base;
			testContext = context;
		}
		String Scenario="Validate Renewal Enrollment for a GME customer with usage < 50Kwh with Fixed product";
		String Optyheader;
		String optyid;
		String contractid;
		String customername;
		String optyID;
		String password;
		String Renewalcustomer;
		CreateOptyPopup opportunity = new CreateOptyPopup(base);
		AddCustomerPopup customer = new AddCustomerPopup(base);
		AddSitesPopup sites = new AddSitesPopup(base);
		ViewCredit credit = new ViewCredit(base);
		PriceaDeal deal = new PriceaDeal(base);
		GenerateContract contract = new GenerateContract(base);
		ViewContract status = new ViewContract(base);
		SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
		BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
		CommonFunctions encrypted = new CommonFunctions();
		VhosPage vhosPage = new VhosPage(base);
		Reports utility;
		HUFileUpload upload;
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		PipelineSeibel renewals = new PipelineSeibel (base);
		TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
		@Then("DSP:Select Renew option for GME with the active contract found")
		public void dsp_select_renew_option_for_the_active_contract_found() throws Throwable {
			Optyheader=renewals.SelectRenewButtonforGME(prop.getProperty("RenewalGMECustomer"));
			String[] parts = Optyheader.split(",");
			optyid = parts[0];
			contractid = parts[1];
			System.out.println(contractid);
		}
		
		
		@Then("DSP: Submitss Contract in Dsp")
		public void Create_Contract_in_Dsp() throws Throwable {
			String Status1=contract.ContractGenerationforRenewal();
			Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
		}
		
		@Then("DSP: Ensureesss the contract is generated")
		public void Ensure_the_contract_is_generated() throws Throwable {
			String Status=status.contractcreationlessthan50();
			Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
		}
		
		
}
