package Stepdefinitions.DSP;
import Pages.DSP.BlankLOA;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BLankLOA {

	private Base base;
	TestContext testContext;
	public BLankLOA(Base base, TestContext context) {
	this.base = base;
	testContext = context;
	}
	BlankLOA loa=new BlankLOA(base) ;
	
	@Given("DSP: Select Send Blank LOA from Opportunity Drop down")
	public void dsp_select_send_blank_loa_from_opportunity_drop_down() throws Throwable {
		loa.SelectSendBlankLOAfromOpportunityDropdown();
	}
	@When("DSP: User receives an email with Blank LOA")
	public void dsp_user_receives_an_email_with_blank_loa() throws Throwable {
		loa.UsereceivesanemailwithBlankLOA();
	   
	}
	@Then("DSP: Enter all required details and complete Docusign")
	public void dsp_enter_all_required_details_and_complete_docusign() throws Throwable {
		loa.EnterallrequireddetailsandcompleteDocusign();
	   
	}
	@Then("DSP: Search for the same opportunity in DSP")
	public void dsp_search_for_the_same_opportunity_in_dsp() throws Throwable {
		loa.SearchforthesameopportunityinDSP();
	   
	}
//	@Then("DSP: validate the customer and sites entered in LOA is available in DSP")
//	public void dsp_validate_the_customer_and_sites_entered_in_loa_is_available_in_dsp() {
//	    
//	   
//	}
	@Then("DSP: Download the LOA in DSP")
	public void dsp_download_the_loa_in_dsp() throws Throwable {
		loa.DownloadtheLOAinDSP();
	   
	}

}
