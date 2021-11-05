package Stepdefinitions;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import Baseclass.Library;
import Pages.DSPHomePage;
import Utilities.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DSPLoginStepdefinition extends Library {
		final static Logger logger = LogManager.getLogger( DSPLoginStepdefinition .class.getName());
		DSPHomePage DSP=new DSPHomePage(DriverFactory.getDriver());
		Library baseclass;
		@Given("User is on Url Login screen")
		public void user_is_on_Url_Login_screen() throws Throwable {
			baseclass=new Library();
			baseclass.launchApp();
			System.out.println("User is on Url Login screen");
		}
		
		@Then("Page Title Should be Digital Services Platform")
		public void page_Title_Should_be_Digital_Services_Platform() throws Throwable {
			baseclass=new Library();
			baseclass.TitleValidation();
			System.out.println("Page Title is Digital Services Platform ");
		}

		@Then("Toggle should be Turned off")
		public void toggle_should_be_Turned_off() throws Throwable {
			baseclass=new Library();
			baseclass.Toggle();
			System.out.println("Toggle is Turned off");
		   
		}
}

