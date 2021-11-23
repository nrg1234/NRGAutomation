package Stepdefinitions.DSP;

import Pages.DSP.*;

import Utilities.Context;
import Utilities.ExcelUtil;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class Enrollment  {

    private Base base;
    TestContext testContext;
    public Enrollment(Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }

	String customername;

    CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
    AddCustomerPopup customer=new AddCustomerPopup(base) ;
    AddSitesPopup sites=new AddSitesPopup(base) ;
    ViewCredit credit=new ViewCredit(base) ;
    PriceaDeal deal=new PriceaDeal(base) ;
    GenerateContract contract =new GenerateContract(base) ;
    ViewContract status =new ViewContract(base) ;
    SendContracttoCustomer sendContract =new SendContracttoCustomer(base) ;
    ExcelandXML opty=new ExcelandXML(base, testContext);

    @Then("DSP: Add New Opportunity")
    public void create_new_opportunity() throws Throwable {
    	opty.OptyXML();
    }
    
    @And("DSP: Add customer and sites from the input XML")
    public void Take_the_testdata_from_DBQuery() throws Throwable {
    	opty.ReadXML();
    }

    @When("DSP: Add Sites to the new Opty")
    public void add_sites_to_the_opty() throws Throwable {
        testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("site-esids"));
        System.out.println("Sites successfully added to the Opportunity");
    }

    @Then("DSP: View Credit")
    public void view_credit_chevron() throws Throwable {
        credit.ViewCreditChevron();
        System.out.println("credit review result is displayed as In-progress");
    }

    @And("DSP: price a deal with Fixed product")
    public void price_a_deal() throws Throwable {
            deal.priceadeal();
    }

    @Then("DSP: Generate Contract in DSP")
    public void generate_contract() throws Throwable {
            contract.ContractGeneration();
    }

    @Then("DSP: Make sure the contract is generated")
    public void View_Contracts() throws Throwable {
        status.contractcreation();
        System.out.println("Contract has been Successfully created");
    }

    @And("DSP: Send generated contract to customer email")
    public void send_contract_to_customer() throws Throwable {
            sendContract.Sendcontracttocustomer();
    }

}