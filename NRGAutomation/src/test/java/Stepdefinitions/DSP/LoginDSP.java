package Stepdefinitions.DSP;

import Baseclass.Library;
import Pages.DSP.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class LoginDSP extends Library {
    final static Logger logger = LogManager.getLogger(LoginDSP.class.getName());
    LandingPage dspLandingPage = new LandingPage(driver);

    @Given("DSP: make sure user is in landing page")
    public void page_Title_Should_be_Digital_Services_Platform() throws Throwable {
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

