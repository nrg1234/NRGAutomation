package Stepdefinitions.DSP;
import java.awt.AWTException;
import java.io.IOException;
import Pages.DSP.LandingPage;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginDSP extends Base {

	private Base base;

	public LoginDSP(Base base) {
		this.base = base;
	}

	LandingPage DspLandingPage = new LandingPage(base);

	@Given("DSP: make sure user is in landing page")
	public void page_Title_Should_be_Digital_Services_Platform() throws InterruptedException, AWTException, IOException {
		DspLandingPage.launchurl();
		DspLandingPage.TitleValidation();
		System.out.println("Page Title is Digital Services Platform ");
	}

	@And("DSP: Clicks on All Opportunities")
	public void toggle_should_be_Turned_off() throws InterruptedException {
		DspLandingPage.AllOpportunities();
		System.out.println("Toggle is Turned off");
	}
}
