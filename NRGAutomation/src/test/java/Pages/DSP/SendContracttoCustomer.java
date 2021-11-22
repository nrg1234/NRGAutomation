package Pages.DSP;

import java.util.Map;
import java.util.Properties;

import Utilities.ConfigReader;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;
import Utilities.Reports;

public class SendContracttoCustomer  {
	WebDriver driver;
	public  SendContracttoCustomer(Base base)  {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//span[@class='mdi mdi-file-send mdi-24px']")
	WebElement  sendContractToCustomerBtn;
	
	@FindBy(xpath="//*[@id='customerEmail']")
	WebElement  customerEmailInput;
	
	@FindBy(xpath="//button[contains(text(), 'Send Contract')]")
	WebElement  sendContractBtn;	
	
	/*
   	 * Send Contract To Customer
   	 */
   	
   	// Open contract generation modal
       public void Sendcontracttocustomer()throws Throwable  {
		   CommonFunctions functions=new CommonFunctions();
		   ConfigReader config = new ConfigReader();
		   Properties prop = config.init_properties();

   		functions.click(driver,sendContractToCustomerBtn);
		   // Wait for spinner to Load
			functions.shortWait();

			// Enter email for contract
			functions.setText(driver, customerEmailInput, prop.getProperty("customer-email"));
   	
			// Send contract
			functions.click(driver,sendContractBtn);
   	
			// Wait for modal to disappear
   	
			//return new Reports(driver);
   }
}
