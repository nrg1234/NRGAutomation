package Stepdefinitions.DSP;


import Pages.DSP.LandingPage;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginDSP extends Base {

    private Base base;
    public LoginDSP(Base base) {
        this.base = base;
    }

    LandingPage dspLandingPage = new LandingPage(base);

    @Given("DSP: make sure user is in landing page")
    public void page_Title_Should_be_Digital_Services_Platform() {
        dspLandingPage.launchurl();
        dspLandingPage.TitleValidation();
        System.out.println("Page Title is Digital Services Platform ");
    }

    @And("DSP: Turn off WOLR view if enabled")
    public void toggle_should_be_Turned_off()  {
    	dspLandingPage.Toggle(false);
        System.out.println("Toggle is Turned off");
    }
}

