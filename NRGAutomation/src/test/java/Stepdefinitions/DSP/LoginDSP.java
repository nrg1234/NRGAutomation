package Stepdefinitions.DSP;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import Baseclass.Library;
import Pages.DSP.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginDSP extends Library {
		final static Logger logger = LogManager.getLogger( LoginDSP.class.getName());
		LandingPage DSP=new LandingPage(driver);
		Library baseclass=new Library(); ;
		@Given("Sales person successfully logged into DSP")
		public void user_is_on_Url_Login_screen() throws Throwable {
			baseclass.launchApp();
			System.out.println("User is on Url Login screen");
		}
		
		@Then("make sure he/she is in landing page")
		public void page_Title_Should_be_Digital_Services_Platform() throws Throwable {
			DSP.launchurl();
			DSP.AdvancedOptions();
			DSP.TitleValidation();
			System.out.println("Page Title is Digital Services Platform ");
		}

		@Then("Turn off WOLR view if enabled")
		public void toggle_should_be_Turned_off() throws Throwable {
			DSP.Toggle();
			System.out.println("Toggle is Turned off");
		}
}

