package Pages.DSP;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class AddCustomerPopup extends Library{

	public  AddCustomerPopup(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//button[contains(text(), 'Add Customer')]")
	WebElement Addcustomerbutton;

	@FindBy(xpath="//input[@id='typeahead-customer']")
	WebElement customerNameInput;
	
	@FindBy(xpath="//button[contains(text(), 'Create Customer')]")
	WebElement CreateCustomerButton;
	
	@FindBy(xpath="//*[@class='dropdown open dropdown-menu']")
	WebElement ListofcustomersMenu;
	
	@FindBy(xpath="//div[@class='col p-3']")
	WebElement Firstcustomercard;

	@FindBy(xpath="//button[contains(text(), 'Add To Opportunity')]")
	WebElement addCustomerToOptyBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Renew')]")
	WebElement RenewButton;
	
	@FindBy(xpath="//button[contains(text(), 'Restructure')]")
	WebElement RestructureButton;

	@FindBy(xpath="//button[contains(text(), 'Create New Deal')]")
	WebElement createnewdealButton;
	
	/*
     * Add customer to opportunity.
     */
	
	public void AddCustomertoOpportunity(Map<String,Object> data) throws Throwable  {
		CommonFunctions functions=new CommonFunctions();

		// Click add customer button
		functions.click(driver,Addcustomerbutton);

		// Enter customer name
        functions.setText(driver, customerNameInput, data.get("customerName").toString());
        
        // Wait for spinner to pop up
     
      	// Select first customer card
       	functions.click(driver,Firstcustomercard);
        
        // Click "add to opportunity" button
		functions.click(driver,addCustomerToOptyBtn);
        
        // Wait for page to update
        try {
			Thread.sleep(22000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
        
        //select Create New Deal from the Popup
        functions.click(driver, createnewdealButton);
	}
}
