package Stepdefinitions.DSP;

import Baseclass.Library;
import Pages.DSP.*;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.LoginSiebel;
import Pages.VHOS.LoginVhos;
import Pages.VHOS.VhosPage;
import Utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;


public class Enrollment extends Library {
    String Optyid;
    CreateOptyPopup Opportunity=new CreateOptyPopup(driver);
    AddCustomerPopup Customer=new AddCustomerPopup(driver);
    AddSitesPopup Sites=new AddSitesPopup(driver);
    ViewCredit credit=new ViewCredit(driver);
    LoginSiebel Login=new LoginSiebel(driver);
    BAApprovescreditinSiebel Siebel = new BAApprovescreditinSiebel(driver);
    LoginVhos Loginvhos=new LoginVhos(driver);
    VhosPage vhos = new VhosPage(driver);
    PriceaDeal deal=new PriceaDeal(driver);
    GenerateContract contract=new GenerateContract(driver);
    ViewContract status=new ViewContract(driver);
    SendContracttoCustomer sendcontract=new SendContracttoCustomer(driver);


    @Then("Add New Opportunity in DSP")
    public void create_new_opportunity() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        System.out.println(data);
        for (Map<String, Object> currentrow : data) {
        	Opportunity.CreateNewOpportunity(currentrow);
            System.out.println("Created New Opportunity");
            break;
        }

    }

    @When("Add Customer to the new Opty")
    public void add_customer_to_dsp_opty() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	Customer.AddCustomertoOpportunity(currentrow);
            System.out.println("customer successfully added to the Opportunity in DSP");
            break;
        }

    }

    @Then("Add Sites to the new Opty")
    public void add_sites_to_the_opty() throws Throwable {
        Optyid = Sites.AddSitestotheOpty();
        System.out.println("Sites successfully added to the Opportunity");
    }

    @Then("View Credit")
    public void view_credit_chevron() throws Throwable {
    	credit.ViewCreditChevron();
        System.out.println("creditreviewresult is displayed as Inprogress");
    }

    @Then("Login to Siebel as BA")
    public void Login_to_Siebel_as_BA() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	Login.LoginSiebel(currentrow, Optyid);
            System.out.println("Login to Sibel is Successful");
            break;
        }
    }

    @Then("Approves Credit")
    public void Ba_approves_credit_in_siebel() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            Siebel.BAApprovescreditinSiebel(currentrow, Optyid);
            System.out.println("credit has been Successfully approved in Siebel");
            break;
        }
    }

    @Then("Login to VHOS as Sales Person")
    public void Login_to_VHOS_as_Sales_Person() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	Loginvhos.loginVhos(currentrow, Optyid);
            System.out.println("Login to Vhos is Successful");
            break;
        }
    }

    
    @Then("Validate Opty in VHOS")
    public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            vhos.ValidateOpportunitydetailsinVHOS(currentrow, Optyid);
            System.out.println("Opportunity has been validated in VHOS");
            break;
        }
    }

    @Then("price a deal with Fixed product in DSP")
    public void price_a_deal() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	deal.priceadeal(currentrow);
            System.out.println("Product has been successfully selected");
            break;
        }
    }

    @Then("Generate Contract in DSP")
    public void generate_contract() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	contract.GenerateContract(currentrow);
            System.out.println("Contract has been successfully generated");
            break;
        }
    }

    @Then("Make sure the contract is generated")
    public void View_Contracts() throws Throwable {
    	status.contractcreation();
        System.out.println("Contract has been Successfully created");
    }

    @Then("Send generated contract to customer email")
    public void send_contract_to_customer() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	sendcontract.Sendcontracttocustomer(currentrow);
            System.out.println("Contract has been Successfully sent to Customer");
            break;
        }
    }

}

