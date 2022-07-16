package Stepdefinitions.DSP;
import Pages.DSP.*;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import Utilities.XMLFile;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Utilities.ConfigWrite;
public class AggregateEnrollment {
private Base base;
TestContext testContext;
public AggregateEnrollment(Base base, TestContext context) {
this.base = base;
testContext = context;
}

String Scenario="Validate new Enrollment for a Aggregate customer with usage > 50Kwh with Fixed product";
CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
AddCustomerPopup customer=new AddCustomerPopup(base) ;
AddSitesPopup sites=new AddSitesPopup(base) ;
AddSitesHUUpload Upload=new AddSitesHUUpload(base) ;
ViewCredit credit=new ViewCredit(base) ;
PriceaDeal deal=new PriceaDeal(base) ;
GenerateContract contract =new GenerateContract(base) ;
ViewContract status =new ViewContract(base) ;
SendContracttoCustomer sendContract =new SendContracttoCustomer(base) ;
String optyID;
String password;
CommonFunctions encrypted = new CommonFunctions();
Reports utility ;
HUFileUpload upload;
XMLFile opty = new XMLFile(base, testContext);
ConfigWrite write=new ConfigWrite(base);
ConfigReader config = new ConfigReader();
Properties prop = config.init_properties();
TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
@When("DSP: Adding Customer to the new Opty from XLSX")
public void adding_customer_to_dsp_opty() throws Throwable {
	testContext.scenarioContext.setContext(Context.CUST_NAME,opty.ReadXML());
	customer.AddCustomertoOpportunity(prop.getProperty("customername"));
}

@Then("DSP: Adding Sites to the new Opty")
public void adding_sites_to_the_opty() throws Throwable{
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOptyforAggregatecustomer((String) testContext.scenarioContext.getContext(Context.CUST_NAME),"customername","NewAggregate1","NewAggregate2"));
	//testContext.scenarioContext.setContext(Context.OPTY_ID,Upload.AddSitestotheOptyHUUpload((String) testContext.scenarioContext.getContext(Context.CUST_NAME), "customername"));
}


@Then("DSP:pricing a deal with Index product in DSP")
public void pricing_a_deal_with_Index_product_in_DSP() throws Throwable {
deal.priceadealwithindexproduct();

}

@Then("DSP:Generating Contract details in DSP")
public void Generating_Contract_details_in_DSP() throws Throwable {
String Status1=contract.GenerateContractforAggregate();
Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);
}

@Then("DSP: Ensuring the contract is generated")
public void View_Contracts() throws Throwable {
String Status=status.contractcreationAggregate();
Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status);
}


@And("DSP: Send generated Aggregate contract to customer email")
public void send_contract_to_customer() throws Throwable {
sendContract.SendcontracttoAggregatecustomer();
}

}



