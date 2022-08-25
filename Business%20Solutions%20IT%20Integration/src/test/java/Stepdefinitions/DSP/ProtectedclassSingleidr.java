package Stepdefinitions.DSP;

import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.DSP.protectedclassidr;
import Utilities.ConfigWrite;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProtectedclassSingleidr {


    private Base base;
    TestContext testContext;
    public ProtectedclassSingleidr (Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }
    String customername;
String Scenario="DSP BP <50kwh C&I";
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
    protectedclassidr pc= new protectedclassidr(base);
    TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
    @When("DSP: Add New Opportunity PC")
    public void dsp_add_new_opportunity_pc() throws Throwable {
        opty.OptyXMLPC();
    }
    
    
    @Then("DSP:Add Sites to the C&I Opty")
	public void Add_sites_to_the_dsp_opty() throws Throwable {
		sites.AddSitestotheOptylessthan50("IDRSite");
	}

    @Then("DSP:Change to broker view and continue")
    public void dsp_change_to_broker_view_and_continue() throws Throwable {
        pc.changetobrokerviewandcontinue();
        pc.continuetopricing();
       String  Status=pc.quotespage();
       Result.ResultintoExcel("Working fine",Scenario, Status);
    }
}

