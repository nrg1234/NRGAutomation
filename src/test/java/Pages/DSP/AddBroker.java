package Pages.DSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import apphooks.Base;

public class AddBroker {

	//locators

	@FindBy(xpath = "//li[@class='nav-item active']//span[contains(text(),'Opportunities')]")
	WebElement opportunityBtn;
	
	
	WebDriver driver;
	CommonFunctions functions = new CommonFunctions();
	public  AddBroker(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

//public void validateopportunity() throws Throwable {
//	CommonFunctions functions = new CommonFunctions();
//	functions.();
//	System.out.println("Third party is not currently set up for matrix pricing in DSP");
	
}
