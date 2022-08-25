package Stepdefinitions.DSP;
import org.openqa.selenium.WebDriver;

import Pages.DSP.*;
import Utilities.ConfigWrite;
import Utilities.ConnectToDatabase;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Enrollment  {

private Base base;
TestContext testContext;
public Enrollment(Base base, TestContext context) {
this.base = base;
testContext = context;
}

String customername;
String Scenario="Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product";
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
AddProxySiteList proxy=new AddProxySiteList(base);
AddSitesHUUpload HU=new AddSitesHUUpload(base);
@When("DSP: Add New Opportunity")
public void create_new_opportunity() throws Throwable {
opty.OptyXML();
}
@When("DSP: Add New Opportunity Reliant")
public void dsp_add_new_opportunity_reliant() throws Throwable {
   opty.OptyXMLReliant();
}


@And("DSP: Add customer and sites from the input XML")
public void Take_the_testdata_from_DBQuery() throws Throwable {
	testContext.scenarioContext.setContext(Context.CUST_NAME,opty.ReadXML());
}


@When("DSP: Add Sites to the Single Customer using HUUpload")
public void add_sites_to_the_Single_Customer() throws Throwable {
testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("NewSingle"));
//testContext.scenarioContext.setContext(Context.OPTY_ID,HU.AddSitestotheOptyHUUpload());

}

@When("DSP: Add Sites to the new Opty Billcopy")
public void dsp_add_sites_to_the_new_opty_billcopy() throws InterruptedException {
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitesbillcopy("podid")); 
}

@Then("DSP: View Credit")
public void view_credit_chevron() throws Throwable {
credit.ViewCreditChevron();
}

@And("DSP: price a deal with Fixed product")
public void price_a_deal() throws Throwable {
deal.priceadeal();
}
@Then("DSP:  Validate CRR in Dealoption")
public void dsp_validate_crr_in_dealoption() throws Throwable {
   deal.CRR();
}
@When("DSP: Add 20000MwH Sites to the new Opty")
public void add_20000MwH_sites_to_the_opty() throws Throwable {
testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOpty("MVPSiteGreaterthan20000"));
}
@Then("DSP: Generate Contract in DSP")
public void generate_contract() throws Throwable {
String Status1=contract.ContractGeneration();
Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
}
@When("DSP: price a deal with Index product")
public void dsp_price_a_deal_with_index_product() throws Throwable {
    deal.priceadealwithindexproduct();
}

@Then("DSP: Make sure the contract is generated")
public void View_Contracts() throws Throwable {
String Status=status.contractcreation();
Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
}

@And("DSP: Send generated contract to customer email")
public void send_contract_to_customer() throws Throwable {
sendContract.Sendcontracttocustomer();
}

@Then("DSP: Sending to Closed")
public void Send_to_Closed() throws Throwable {
sendContract.Sendcontracttoclosed();

}

}
