package Stepdefinitions.DSP;



import Pages.DSP.LandingPage;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;



public class LogintoOutlook extends Base {



private Base base;



public LogintoOutlook(Base base) {
this.base = base;
}



LandingPage DspLandingPage = new LandingPage(base);



@Given("DSP: make sure user is in Outlook landing page")
public void page_Title_Should_be_Digital_Services_Platform() throws InterruptedException {
DspLandingPage.launchoutlook();

}
}