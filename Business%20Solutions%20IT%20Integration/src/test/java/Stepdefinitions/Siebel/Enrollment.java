package Stepdefinitions.Siebel;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.commonObjects.Opportunity;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Enrollment {

    private Base base;
    TestContext testContext;
    public Enrollment(Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }

	BAApprovescreditinSiebel siebel=new BAApprovescreditinSiebel(base) ;
	

    @Then("SIEBEL: Approves Credit")
    public void Ba_approves_credit_in_siebel() throws Throwable {
            siebel.BAApprovescreditinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }

    @Then("SIEBEL: Approve Credit for Single Customer")
    public void Ba_approves_credit_in_siebel_for_Singlecustomer() throws Throwable {
            siebel.BAApprovescreditinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }
    
    @Then("SIEBEL:Accepting Credit in Siebel")
    public void Accepting_Credit_in_Siebel() throws Throwable {
         siebel.BAApprovescreditinSiebelforAggregate((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
           
    }
    
    @Then("SIEBEL: Approve credit for Aggregate Customer")
    public void Accepting_Credit_in_Siebel_AggregateCustomer() throws Throwable {
         siebel.BAApprovescreditinSiebelforAggregate((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
           
    }
    
    @Then("SIEBEL:Modifying Contract Status in Siebel")
    public void Modifying_Contract_Status_in_Siebel() throws Throwable {
         siebel.Modifying_Contract_Status((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
           
    }
   
    @Then("SIEBEL:Validate Meterfee and Recs in Siebel")
    public void Validate_Meterfee_and_Recs_in_Siebel() throws Throwable {
         siebel.ValidateMeterfeeandRecsinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
           
    }
    
    
    @Then("SIEBEL: Approve Credit and Validate Reliant Brand")
    public void Ba_approves_credit_Validate_Brand_in_siebel() throws Throwable {
            siebel.BAApprovescreditandvalidateBrandinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }
    
    @Then("SIEBEL: Approve Credit and validate Pricing for Non Ercot Opportunity")
    public void Ba_approves_credit_Validate_Pricing() throws Throwable {
            siebel.BAApprovescreditandvalidatePricing((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }
    @When("SIEBEL: Validate MVPCRR Siebel as BA")
    public void siebel_validate_mvpcrr_siebel_as_ba() throws Throwable {
//        siebel.ValidateMvpCrr((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
    	 System.out.println("credit has been Successfully approved in Siebel");
    }

    @Then("SIEBEL: Validate EMA in Seibel")
    public void siebel_validate_ema_in_seibel() throws Throwable {
    	siebel.ValidateEma((String) testContext.scenarioContext.getContext(Context.OPTY_ID),(String) testContext.scenarioContext.getContext(Context.Opportunityname));
    }



}

