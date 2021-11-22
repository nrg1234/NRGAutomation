package Stepdefinitions.VHOS;

import Pages.VHOS.VhosPage;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class Enrollment extends Base {

    private Base base;
    public Enrollment(Base base) {
        this.base = base;
    }

    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
    VhosPage vhosPage = new VhosPage(base);

    @Then("VHOS: Validate Opty in VHOS")
    public void Opportunity_should_be_validated_in_VHOS() throws Throwable {
        //vhosPage.ValidateOpportunitydetailsinVHOS(optyID);
        vhosPage.ValidateOpportunitydetailsinVHOS("test");
        System.out.println("Opportunity has been validated in VHOS");
    }
}

