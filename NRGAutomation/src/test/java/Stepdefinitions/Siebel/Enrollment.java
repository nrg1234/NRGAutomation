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
}

