package Pages.DSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Pages.Siebel.LoginSiebel;
import Utilities.CommonFunctions;

public class ViewCredit extends Library{
	
	public  ViewCredit(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//button[contains(text(), 'Credit')]")
	WebElement CreditTAB;
	
	/*
     * View Credit 
     */
	
	public LoginSiebel ViewCreditChevron() throws Throwable {
		CommonFunctions functions=new CommonFunctions();
	//View Credit 
		//waitForvisibility(CreditTAB,10);
	functions.click(driver,CreditTAB);
	return new LoginSiebel(driver);
	}
}
