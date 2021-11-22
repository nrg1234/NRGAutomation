package Pages.DSP;

import static org.junit.Assert.assertTrue;

import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;

public class ViewContract {
	WebDriver driver;
	public  ViewContract(Base base)  {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//button[contains(text(), 'Contracts')]")
	WebElement contractTab ;
	@FindBy(xpath="//span[contains(text(),'Error')]")
	WebElement Errortext ;
	
	
	  /*
   	 * View contracts 
   	 */
       public void  contractcreation()throws Throwable {
    	   CommonFunctions functions=new CommonFunctions();
    	
    	  functions.click(driver,contractTab);
    	// Wait for contract to be created
    	  functions.waitforcontactgeneration();
    	  assertTrue("contract generation is failed due to timeout exception",Errortext.isDisplayed());

       }
}
