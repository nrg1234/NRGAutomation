package Stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import Baseclass.Library;
import Pages.BAApprovescreditinSiebel;
import Pages.DSPHomePage;
import Pages.VhosPage;
import Utilities.DriverFactory;
import Utilities.ExcelUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class DSPEnrollment extends Library {
String Optyid;
	final static Logger logger = LogManager.getLogger( DSPEnrollment .class.getName());
	DSPHomePage DSP=new DSPHomePage(driver);
	BAApprovescreditinSiebel Siebel=new BAApprovescreditinSiebel(driver);
	VhosPage vhos=new VhosPage(driver);
	
	
	@Given("Create New Opportunity")
	public void create_new_opportunity() throws Throwable {
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		System.out.println(data);
		for(Map<String,Object>currentrow:data) {	
		DSP.CreateNewOpportunity(currentrow);
		System.out.println("Created New Opportunity");
		break;
		}
	
	}
	
	@When("Add Customer to DSP Opty")
	public void add_customer_to_dsp_opty() throws Throwable{
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		DSP.AddCustomertoOpportunity(currentrow);
		System.out.println("customer successfully added to the Opportunity");
		break;
	}
		
	}
	
	@Then("Add Sites to the Opty")
	public void add_sites_to_the_opty() throws Throwable{
		 Optyid=DSP.AddSitestotheOpty();
		System.out.println("Sites successfully added to the Opportunity");
	}
	
	@Then("View Credit Chevron")
	public void view_credit_chevron() throws Throwable{
		DSP.ViewCreditChevron();
		System.out.println("creditreviewresult is displayed as Inprogress");
		
	}

	@Then("BA Approves Credit in Siebel")
	public void ba_approves_credit_in_siebel() throws Throwable{
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		Siebel.BAApprovescreditinSiebel(currentrow,Optyid);
		System.out.println("credit has been Successfully approved in Siebel");
		break;
		}
	}

	@Then("Opportunity should be validated in VHOS")
	public void Opportunity_should_be_validated_in_VHOS() throws Throwable{
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		vhos.ValidateOpportunitydetailsinVHOS(currentrow,Optyid);
		System.out.println("Opportunity has been validated in VHOS");
		break;
	}
	}
	
	@Then("price a deal")
	public void price_a_deal() throws Throwable{
		
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		DSP.priceadeal(currentrow);
		System.out.println("Product has been successfully selected");
		break;
	}
	}
	@Then("Generate Contract")
	public void generate_contract()throws Throwable{
		
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		DSP.GenerateContract(currentrow);
		System.out.println("Contract has been successfully generated");
		break;
		}
	}
	
	
	@Then("View Contracts")
	public void  View_Contracts()throws Throwable{
		DSP.contractcreation();
		System.out.println("Contract has been Successfully created");
		}
	
	
	
	@Then("Send contract to customer")
	public void send_contract_to_customer()throws Throwable{
		
		ExcelUtil util=new ExcelUtil();
		List<Map<String, Object>> data=util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx","Source");
		for(Map<String,Object>currentrow:data) {
		DSP.Sendcontracttocustomer(currentrow);
		System.out.println("Contract has been Successfully sent to Customer");
		break;
		}
	}
	
}

