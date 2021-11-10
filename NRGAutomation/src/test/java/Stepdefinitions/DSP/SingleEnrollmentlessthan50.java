//package Stepdefinitions.DSP;
//
//import java.util.List;
//import java.util.Map;
//
//import Baseclass.Library;
//import Pages.DSP.AddCustomerPopup;
//import Pages.DSP.AddSitesPopup;
//import Pages.DSP.CreateOptyPopup;
//import Pages.DSP.GenerateContract;
//import Pages.DSP.HUFileUpload;
//import Pages.DSP.PriceaDeal;
//import Pages.DSP.SendContracttoCustomer;
//import Pages.DSP.ViewContract;
//import Pages.DSP.ViewCredit;
//import Pages.Siebel.BAApprovescreditinSiebel;
//import Pages.Siebel.LoginSiebel;
//import Pages.VHOS.LoginVhos;
//import Pages.VHOS.VhosPage;
//import Utilities.ExcelUtil;
//import Utilities.PasswordEncryption;
//import Utilities.SeleniumUtil;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class SingleEnrollmentlessthan50 extends Library{
//	String optyID;
//    String password;
//    CreateOptyPopup opportunity=new CreateOptyPopup(driver);
//    AddCustomerPopup customer=new AddCustomerPopup(driver);
//    AddSitesPopup sites=new AddSitesPopup(driver);
//    ViewCredit credit=new ViewCredit(driver);
//    LoginSiebel login=new LoginSiebel(driver);
//    BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(driver);
//    LoginVhos loginvhos=new LoginVhos(driver);
//    VhosPage vhos = new VhosPage(driver);
//    PriceaDeal deal=new PriceaDeal(driver);
//    GenerateContract contract=new GenerateContract(driver);
//    ViewContract status=new ViewContract(driver);
//    SendContracttoCustomer sendContract=new SendContracttoCustomer(driver);
//    PasswordEncryption encrypted=new PasswordEncryption();
//    SeleniumUtil utility=new SeleniumUtil(driver);
//    HUFileUpload upload=new HUFileUpload(driver);
// 
//    @Then("Add New Opportunity in DSP with customer sales group as Mid Market")
//    public void Create_New_Opportunity() throws Throwable {
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        System.out.println(data);
//        for (Map<String, Object> currentrow : data) {
//        	opportunity.CreateNewOpportunity(currentrow);
//            System.out.println("Created New Opportunity");
//            break;
//        }
// 
//    }
//
//    @When("Add Customer to the new Opty")
//    public void add_customer_to_dsp_opty() throws Throwable {
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        for (Map<String, Object> currentrow : data) {
//        	customer.AddCustomertoOpportunity(currentrow);
//            System.out.println("customer successfully added to the Opportunity in DSP");
//            break;
//        }
//
//    }
//
//    @Then("Add Sites to the new Opty")
//    public void add_sites_to_the_opty() throws Throwable {
//        optyID = sites.AddSitestotheOpty();
//        System.out.println("Sites successfully added to the Opportunity");
//    }
//
//    @Then("View Credit")
//    public void view_credit_chevron() throws Throwable {
//    	credit.ViewCreditChevron();
//        System.out.println("creditreviewresult is displayed as Inprogress");
//    }
//
//    @Then("Login to Siebel as BA")
//    public void Login_to_Siebel_as_BA() throws Throwable {
//    	password = encrypted.Encryption();
//        	login.LoginSiebel(password);
//            System.out.println("Login to Sibel is Successful");
//        }
//
//    @Then("Approves Credit")
//    public void Ba_approves_credit_in_siebel() throws Throwable {
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        for (Map<String, Object> currentrow : data) {
//            siebel.BAApprovescreditinSiebel(currentrow, optyID);
//            System.out.println("credit has been Successfully approved in Siebel");
//            break;
//        }
//    }
//
//    @Then("Login to VHOS as Sales Person")
//    public void Login_to_VHOS_as_Sales_Person() throws Throwable {
//        	loginvhos.loginVhos();
//            System.out.println("Login to Vhos is Successful");
//    }
//
//    
//    @Then("Validate Opty in VHOS")
//    public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
//            vhos.ValidateOpportunitydetailsinVHOS(optyID);
//            System.out.println("Opportunity has been validated in VHOS");
//    }
//
//    @Then("price a deal with Fixed product in DSP")
//    public void price_a_deal() throws Throwable {
//
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        for (Map<String, Object> currentrow : data) {
//        	deal.priceadeal(currentrow);
//            System.out.println("Product has been successfully selected");
//            break;
//        }
//    }
//
//    @Then("Generate Contract in DSP")
//    public void generate_contract() throws Throwable {
//
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        for (Map<String, Object> currentrow : data) {
//        	contract.GenerateContract(currentrow);
//            System.out.println("Contract has been successfully generated");
//            break;
//        }
//    }
//
//    @Then("Make sure the contract is generated")
//    public void View_Contracts() throws Throwable {
//    	status.contractcreation();
//        System.out.println("Contract has been Successfully created");
//    }
//
//    @Then("Send generated contract to customer email")
//    public void send_contract_to_customer() throws Throwable {
//
//        ExcelUtil util = new ExcelUtil();
//        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
//        for (Map<String, Object> currentrow : data) {
//        	sendContract.Sendcontracttocustomer(currentrow);
//            System.out.println("Contract has been Successfully sent to Customer");
//            break;
//        }
//    }
//    
//    
//    
//    
//}
