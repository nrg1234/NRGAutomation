package Stepdefinitions.DSP;

import Pages.DSP.*;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.LoginSiebel;
import Pages.VHOS.LoginVhos;
import Pages.VHOS.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ExcelUtil;
import Utilities.Reports;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import Baseclass.Library;


public class Enrollment  {
    String optyID;
    String password;
    CreateOptyPopup opportunity = new CreateOptyPopup(Library.launchApp());
    AddCustomerPopup customer;
    AddSitesPopup sites;
    ViewCredit credit;
    LoginSiebel login;
    BAApprovescreditinSiebel siebel;
    LoginVhos loginvhos;
    VhosPage vhos ;
    PriceaDeal deal;
    GenerateContract contract ;
    ViewContract status ;
    SendContracttoCustomer sendContract ;
    CommonFunctions encrypted = new CommonFunctions();
    Reports utility ;
    HUFileUpload upload;

    @Then("DSP: Add New Opportunity")
    public void create_new_opportunity() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        System.out.println(data);
        for (Map<String, Object> currentrow : data) {
            customer= opportunity.CreateNewOpportunity(currentrow);
            System.out.println("Created New Opportunity");
            break;
        }
        utility.takeScreenshot();
    }

    @When("DSP: Add Customer to the new Opty")
    public void add_customer_to_dsp_opty() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            sites=customer.AddCustomertoOpportunity(currentrow);
            System.out.println("customer successfully added to the Opportunity in DSP");
            break;
        }

    }

    @When("DSP: Add Sites to the new Opty")
    public void add_sites_to_the_opty() throws Throwable {
        optyID = sites.AddSitestotheOpty();
        credit=sites.driver();
        System.out.println("Sites successfully added to the Opportunity");
    }

    @Then("DSP: View Credit")
    public void view_credit_chevron() throws Throwable {
        login=credit.ViewCreditChevron();
        System.out.println("creditreviewresult is displayed as Inprogress");
    }

    @When("SIEBEL: Login to Siebel as BA")
    public void Login_to_Siebel_as_BA() throws Throwable {
        password = encrypted.Encryption();
        siebel=login.LoginSiebel(password);
        System.out.println("Login to Sibel is Successful");
    }

    @Then("SIEBEL: Approves Credit")
    public void Ba_approves_credit_in_siebel() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            loginvhos=siebel.BAApprovescreditinSiebel(currentrow, optyID);
            System.out.println("credit has been Successfully approved in Siebel");
            break;
        }
    }

    @When("VHOS: Login to VHOS as Sales Person")
    public void Login_to_VHOS_as_Sales_Person() throws Throwable {
        vhos=loginvhos.loginVhos();
        System.out.println("Login to Vhos is Successful");
    }


    @Then("VHOS: Validate Opty in VHOS")
    public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
        deal= vhos.ValidateOpportunitydetailsinVHOS(optyID);
        System.out.println("Opportunity has been validated in VHOS");
    }

    @And("DSP: price a deal with Fixed product")
    public void price_a_deal() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            contract=deal.priceadeal(currentrow);
            System.out.println("Product has been successfully selected");
            break;
        }
    }

    @Then("DSP: Generate Contract in DSP")
    public void generate_contract() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            status=contract.ContractGeneration(currentrow);
            System.out.println("Contract has been successfully generated");
            break;
        }
    }

    @Then("DSP: Make sure the contract is generated")
    public void View_Contracts() throws Throwable {
        sendContract=status.contractcreation();
        System.out.println("Contract has been Successfully created");
    }

    @And("DSP: Send generated contract to customer email")
    public void send_contract_to_customer() throws Throwable {

        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
            sendContract.Sendcontracttocustomer(currentrow);
            System.out.println("Contract has been Successfully sent to Customer");
            break;
        }
    }

}

