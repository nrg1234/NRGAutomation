package Pages.DSP;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import Utilities.ConfigReader;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;

public class GenerateContract  {
	WebDriver driver;
	public  GenerateContract(Base base)  {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//button[contains(text(), 'Generate Contract')]")
	WebElement generateContractModalBtn;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement dealOptionName;
	
	@FindBy(xpath="//select[@id='templateName']")
	WebElement templateName;
	
	@FindAll(value = { @FindBy(xpath="//button[contains(text(), 'Enter Info')]")})
	public List<WebElement> noticeAddress;
	
	@FindBy(xpath="//button[contains(text(), 'Enter Info')]")
	WebElement noticeAddressBtn;
	
	@FindBy(xpath="//span[@class='ng-arrow-wrapper']")
	WebElement contactNameDropdown ;
	
	@FindAll(value = { @FindBy(xpath="//p[@class='typeahead-options-title ng-star-inserted']")})
	public List<WebElement> contactNameValue;

	@FindBy(xpath="//button[contains(text(), 'Add to Customer ')]")
	WebElement addContactToCustomerBtn ;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")
	WebElement approverDropdown;
	
	@FindAll(value = { @FindBy(xpath="//button[contains(text(), 'Generate Contract')]")})
	public List<WebElement> contractBtn;
	
	 /*
   	 * Generate contract workflow.
   	 */
       
       public void ContractGeneration() throws Throwable  {

    	   CommonFunctions functions=new CommonFunctions();
		   ConfigReader config = new ConfigReader();
		   Properties prop = config.init_properties();

		// Open generate contract modal
	
		functions.click(driver,generateContractModalBtn);

    	// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
    	functions.selectDropdownByVisibleText(driver,templateName,prop.getProperty("TemplateName"));

		// Add contact notice address
		functions.click(driver,noticeAddressBtn);

		// Wait for spinner to appear Contact Info
    	functions.intermediatewait();
    	
    	// Selects contact name from the Dropdown
    	functions.click(driver,contactNameDropdown);
    	
    	contactNameValue.get(0).click();
    	
    	functions.click(driver,addContactToCustomerBtn);
    	
		// Wait for spinner to appear Contact Info
    	functions.mediumWait();
    	
		// Choose approver
		functions.selectDropdownByVisibleText(driver,approverDropdown,prop.getProperty("Approver"));

		// Generate contract
		contractBtn.get(1).click();
    	
    	// Wait for spinner to Load
    	functions.intermediatewait();

    	System.out.println("Validating contract creation successful.");
    	   
    	// Wait for dealoption status to get Approved
    	   functions.mediumWait();

}


/*
	 * Generate contract workflow for Aggregate Customer.
	 */
   
   public void ContractGenerationforAggregate(Map<String,Object> data)throws Throwable  {

	   CommonFunctions functions=new CommonFunctions();

	// Open generate contract modal

	functions.click(driver,generateContractModalBtn);

	// Fill out modal
	functions.setText(driver, dealOptionName, data.get("Dealoptionname").toString());

	// Select the option using the visible text
	functions.selectDropdownByVisibleText(driver,templateName,"Short Form General Terms (100% Real Time Index)");

	// Add contact notice address for 1st Customer
	functions.click(driver,noticeAddressBtn);

	// Wait for spinner to appear Contact Info
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		System.err.println("Failed to Thread.sleep()!");
		e.printStackTrace();
	}
	// Selects contact name from the Dropdown
	functions.click(driver,contactNameDropdown);
	contactNameValue.get(0).click();
	functions.click(driver,addContactToCustomerBtn);
	
	// Wait for spinner to appear Contact Info
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		System.err.println("Failed to Thread.sleep()!");
		e.printStackTrace();
	}
	
		// Add contact notice address for Second Customer
		functions.click(driver,noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
		// Selects contact name from the Dropdown
		functions.click(driver,contactNameDropdown);
		contactNameValue.get(0).click();
		functions.click(driver,addContactToCustomerBtn);
		
		// Wait for spinner to appear Contact Info
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
	// Choose approver
	functions.selectDropdownByVisibleText(driver,approverDropdown,data.get("Approver").toString());

	// Generate contract
	contractBtn.get(1).click();
	
	// Wait for spinner to Load
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		System.err.println("Failed to Thread.sleep()!");
		e.printStackTrace();
	}

	System.out.println("Validating contract creation successful.");
	   
	// Wait for dealoption status to get Approved
	   try {
  			Thread.sleep(80000);
  		} catch (InterruptedException e) {
  			System.err.println("Failed to Thread.sleep()!");
  			e.printStackTrace();
  		}

}
}
