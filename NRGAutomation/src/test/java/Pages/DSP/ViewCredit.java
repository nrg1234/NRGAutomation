package Pages.DSP;

import static org.junit.Assert.assertTrue;

import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Pages.VHOS.Login;
import Utilities.CommonFunctions;

public class ViewCredit {
	public static WebDriver driver;
	public  ViewCredit(Base base)  {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//button[contains(text(), 'Credit')]")
	WebElement creditTAB;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement convert50kwBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;

	 @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	    WebElement opportunityIDText;
	/*
     * View Credit 
     */
	public void ViewCreditChevron() throws Throwable {
	CommonFunctions functions=new CommonFunctions();
	//View Credit
	functions.click(driver,creditTAB);
	}
	
	
	
	public String Convertingdealtolessthan50kw() throws InterruptedException {
		
		CommonFunctions functions=new CommonFunctions();
		 // Navigate to quotes page
    	functions.click(driver,quotesTAB);
    	
    	functions.mediumWait();
    	
		//Clicks on Yes Button in Convert Deal to <50kw Popup
		functions.click(driver, convert50kwBtn);
		
		//wait for deal to convert
		functions.dealconversion();
		
		//Storing and Returning the text into a String
        final String OpportunityID = functions.getText(driver, opportunityIDText);
        System.out.println(OpportunityID);
        return OpportunityID;
	}


	
}
