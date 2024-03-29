package Stepdefinitions.VHOS;

import Pages.VHOS.VhosPage;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class Enrollment extends Base {

    private Base base;
    TestContext testContext;
    public Enrollment(Base base, TestContext context) {
        this.base = base;
        testContext = context;
    }

    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
    VhosPage vhosPage = new VhosPage(base);

    @Then("VHOS: Validate Opty in VHOS")
    public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
        //vhosPage.ValidateOpportunitydetailsinVHOS(optyID);
        vhosPage.ValidateOpportunitydetailsinVHOS((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
        System.out.println("Opportunity has been validated in VHOS");
    }
}

