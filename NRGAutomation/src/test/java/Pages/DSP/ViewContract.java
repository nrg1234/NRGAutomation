package Pages.DSP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class ViewContract extends Library{
	
	public  ViewContract(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//button[contains(text(), 'Contracts')]")
	WebElement contractTab ;
	
	  /*
   	 * View contracts 
   	 */
       public void contractcreation()throws Throwable {
    	   CommonFunctions functions=new CommonFunctions();
    	
    	  functions.click(driver,contractTab);
    	// Wait for contract to be created
       /*	try {
   			Thread.sleep(700000);
   		} catch (InterruptedException e) {
   			System.err.println("Failed to Thread.sleep()!");
   			e.printStackTrace();
   		}*/
    	   
       }
}
