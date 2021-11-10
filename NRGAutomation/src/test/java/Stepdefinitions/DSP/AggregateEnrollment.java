/*package Stepdefinitions.DSP;

import Baseclass.Library;
import Pages.DSP.*;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.LoginSiebel;
import Pages.Siebel.ValidateCustomerinSeibel;
import Pages.Siebel.ValidatelossesSeibel;
import Pages.VHOS.LoginVhos;
import Pages.VHOS.ValidatelossesVhos;
import Pages.VHOS.VhosPage;
import Utilities.ExcelUtil;
import Utilities.PasswordEncryption;
import Utilities.SeleniumUtil;
import apphooks.ApplicationHooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;


public class AggregateEnrollment extends Library {
    String optyID;
    String password;
    CreateOptyPopup opportunity=new CreateOptyPopup(driver);
    AddCustomerPopup customer=new AddCustomerPopup(driver);
    AddSitesPopup sites=new AddSitesPopup(driver);
    ViewCredit credit=new ViewCredit(driver);
    LoginSiebel login=new LoginSiebel(driver);
    BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(driver);
    LoginVhos loginvhos=new LoginVhos(driver);
    VhosPage vhos = new VhosPage(driver);
    PriceaDeal deal=new PriceaDeal(driver);
    GenerateContract contract=new GenerateContract(driver);
    ViewContract status=new ViewContract(driver);
    SendContracttoCustomer sendContract=new SendContracttoCustomer(driver);
    PasswordEncryption encrypted=new PasswordEncryption(driver);
    SeleniumUtil utility=new SeleniumUtil(driver);
    ValidateCustomerinSeibel validity=new ValidateCustomerinSeibel(driver);
    Validatequotepricing  quote=new Validatequotepricing (driver);
    ValidatelossesSeibel  loss= new ValidatelossesSeibel(driver);
     ValidatelossesVhos  price = new ValidatelossesVhos(driver);

    @When(" Add New Opportunity in DSP with customer sales group as Mid Market")
    public void Create_New_Opportunity() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        System.out.println(data);
        for (Map<String, Object> currentrow : data) {
        	opportunity.CreateNewOpportunity(currentrow);
            System.out.println("Created New Opportunity");
            break;
        }
            utility.takeScreenshot();
            //upload.fileupload();

    }

    @When("Add Customer to the new Opportunity")
    public void Add_Customer_to_dsp_opty() throws Throwable {
        ExcelUtil util = new ExcelUtil();
        List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
        for (Map<String, Object> currentrow : data) {
        	customer.AddCustomertoOpportunity(currentrow);
            System.out.println("customer successfully added to the Opportunity in DSP");
            break;
        }
    }
    @Then("Login to Siebel as BAnalyst")
    public void Login_to_Siebel_as_BusinessAnalyst() throws Throwable {
    	password = encrypted.Encryption();
        	login.LoginSiebel(password);
            System.out.println("Login to Sibel is Successful");
        }

    
        @Then("Validate Customer is sucessfully created in Seibel")
         public void validate_Customer_is_sucessfully_created_in_Seibel() throws Throwable {

       
	}
        @When("Add Sites to the new Opportunity")
        public void Add_sites_to_the_opty() throws Throwable {
            optyID = sites.AddSitestotheOpty();
            System.out.println("Sites successfully added to the Opportunity");
       }
        
        @Then("Login to Siebel as BAnalyst")
        public void Login_to_Siebel_as_Businessanalyst() throws Throwable {
        	password = encrypted.Encryption();
            	login.LoginSiebel(password);
                System.out.println("Login to Sibel is Successful");
        }
    
        @Then("Validate Customer and Sites are correctly mapped to oppurtunities ")
        public void validate_Customer_and_Sites_are_correctly_mapped_to_oppurtunities() throws Throwable {
         
        }
        @Then("View Credit in Dsp")
        public void View_credit_chevron() throws Throwable {
        	credit.ViewCreditChevron();
            System.out.println("creditreviewresult is displayed as Inprogress");
        }
        @When("Login to VHOS as Sales Personal")
        public void Login_to_VHOS_as_Sales_Person() throws Throwable {
            	loginvhos.loginVhos();
                System.out.println("Login to Vhos is Successful");
        }
        @Then("Validate Opty id in VHOS")
        public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
                vhos.ValidateOpportunitydetailsinVHOS(optyID);
                System.out.println("Opportunity has been validated in VHOS");
        }
        @When("Login to Siebel as BAnalyst")
        public void Login_to_Siebel_as_businessAnalyst() throws Throwable {
        	password = encrypted.Encryption();
            	login.LoginSiebel(password);
                System.out.println("Login to Sibel is Successful");
        }
        @Then("Approves Credit in Dsp")
        public void Ba_approves_credit_in_siebel() throws Throwable {
            ExcelUtil util = new ExcelUtil();
            List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
            for (Map<String, Object> currentrow : data) {
                siebel.BAApprovescreditinSiebel(currentrow, optyID);
                System.out.println("credit has been Successfully approved in Siebel");
                break;
         }
        }
            @When("Login to VHOS as Sales Personal")
            public void Login_to_VHOS_as_Sales_Customer() throws Throwable {
                	loginvhos.loginVhos();
                    System.out.println("Login to Vhos is Successful");
            
        }
            @Then("Validate quote pricing VHOS matches in DSP")
            public void validate_quote_pricing_VHOS_matches_in_DSP_() throws Throwable {
           
            }
            
            @Then("price a deal with Index product in DSP")
            public void price_a_deal_with_Index_product_in_DSP_not() throws Throwable {
             
            }
            
            @Then("Generate Contract details in DSP")
            public void generate_contract() throws Throwable {

                ExcelUtil util = new ExcelUtil();
                List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
                for (Map<String, Object> currentrow : data) {
                	contract.GenerateContract(currentrow);
                    System.out.println("Contract has been successfully generated");
                    break;
                }
                }
                
                @Then("Making sure the contract is generated")
                public void View_Contracts() throws Throwable {
                	status.contractcreation();
                    System.out.println("Contract has been Successfully created");
                }
                @Then("Send generated contract to customer email id")
                public void send_contract_to_customer() throws Throwable {

                    ExcelUtil util = new ExcelUtil();
                    List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
                    for (Map<String, Object> currentrow : data) {
                    	sendContract.Sendcontracttocustomer(currentrow);
                        System.out.println("Contract has been Successfully sent to Customer");
                        break;
                    }
                }
                  @When("Login to Siebel as BAnalyst")
                    public void Login_to_Siebel_as_BA() throws Throwable {
                    	password = encrypted.Encryption();
                        	login.LoginSiebel(password);
                            System.out.println("Login to Sibel is Successful");
                }
                    
                  @Then("Validate losses,prices,voluntary recs,meterfee and deal closed status in seibel")
                    public void validate_losses_prices_voluntary_recs_meterfee_and_deal_closed_status_in_seibel_not() throws Throwable {
                    
                  }
                  @When("Login to VHOS as Sales Personal")
                  public void Login_to_VHOS_as_Sales_Representative() throws Throwable {
                      	loginvhos.loginVhos();
                          System.out.println("Login to Vhos is Successful");
                  }
                  @Then("Validate losses,prices,voluntary recs,meterfee and deal closed status in VHOS")
                  public void validate_losses_prices_voluntary_recs_meterfee_and_deal_closed_status_in_VHOS_not() throws Throwable {
                      
                  }
        }
*/