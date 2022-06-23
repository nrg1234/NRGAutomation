package Stepdefinitions.Siebel;
import Pages.Siebel.BAApprovescreditinSiebel;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Then;


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
    
    
    @Then("SIEBEL:Accepting Credit in Siebel")
    public void Accepting_Credit_in_Siebel() throws Throwable {
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
    
    @Then("SIEBEL: Approves Credit and Validating Brand")
    public void Ba_approves_credit_Validate_Brand_in_siebel() throws Throwable {
            siebel.BAApprovescreditandvalidateBrandinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }
    
    @Then("SIEBEL: Approves Credit and validate Pricing")
    public void Ba_approves_credit_Validate_Pricing() throws Throwable {
            siebel.BAApprovescreditandvalidatePricing((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
            System.out.println("credit has been Successfully approved in Siebel");
    }
}

