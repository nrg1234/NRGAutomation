package Stepdefinitions.DSP;
import java.util.Properties;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.HUFileUpload;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.VHOS.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.ConfigWrite;
import Utilities.Context;
import Utilities.XMLFile;
import Utilities.Reports;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.Then;


public class AggregateEnrollmentlessthan50 {
private Base base;
TestContext testContext;
public AggregateEnrollmentlessthan50(Base base, TestContext context) {
this.base = base;
testContext = context;
}

String Scenario="Validate new Enrollment for a Aggregate customer with usage < 50Kwh with Index product";
String Status="pass";
String customername;
String optyID;
String password;
CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
AddCustomerPopup customer=new AddCustomerPopup(base) ;
AddSitesPopup sites=new AddSitesPopup(base) ;
VhosPage vhos=new VhosPage(base);
ViewCredit credit=new ViewCredit(base) ;
PriceaDeal deal=new PriceaDeal(base) ;
GenerateContract contract =new GenerateContract(base) ;
ViewContract status =new ViewContract(base) ;
SendContracttoCustomer sendContract =new SendContracttoCustomer(base) ;
CommonFunctions encrypted = new CommonFunctions();
Reports utility ;
HUFileUpload upload;
ConfigReader config = new ConfigReader();
Properties prop = config.init_properties();
XMLFile opty=new XMLFile(base, testContext);
ConfigWrite write=new ConfigWrite(base);
TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
@Then("DSP:Add Sites to both Aggregate customers in new Opty")
public void dsp_add_sites_to_both_aggregate_customers_in_new_opty() throws Throwable {
	testContext.scenarioContext.setContext(Context.OPTY_ID,sites.AddSitestotheOptyforAggregatecustomer((String) testContext.scenarioContext.getContext(Context.CUST_NAME),"customername","site-esidlessthan50","site-esidlessthan50agg"));
}

@Then("DSP:Convertingg deal to less than 50kw")
public void Converting_deal_to_less_than_50kw() throws Throwable {
	//testContext.scenarioContext.setContext(Context.OPTY_ID, credit.Convertingdealtolessthan50kwnew());
	testContext.scenarioContext.setContext(Context.OPTY_ID,credit.Convertingdealtolessthan50kw());
	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, "Pass");
	
}

@Then("DSP:Contract is Generated in DSP")
public void dsp_contract_is_generated_in_dsp() throws Throwable {
String Status1=contract.ContractGenerationforAggregatelessthan50();
Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, Status1);

}





}




