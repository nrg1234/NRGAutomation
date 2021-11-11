package Pages.DSP;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;
import Utilities.Reports;

public class SendContracttoCustomer  {
	WebDriver driver;
	public  SendContracttoCustomer(WebDriver driver)  {
		this.driver = driver;
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
       public void Sendcontracttocustomer(Map<String,Object> data)throws Throwable  {
		   CommonFunctions functions=new CommonFunctions();
    		
   		functions.click(driver,sendContractToCustomerBtn);
		   // Wait for spinner to Load
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.err.println("Failed to Thread.sleep()!");
				e.printStackTrace();
			}

   	// Enter email for contract
   	functions.setText(driver, customerEmailInput, data.get("customerEmail").toString());
   	
   	// Send contract
   	functions.click(driver,sendContractBtn);
   	
   	// Wait for modal to disappear
   	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleeo()!");
			e.printStackTrace();
		}
   	//return new Reports(driver);
   }
}
