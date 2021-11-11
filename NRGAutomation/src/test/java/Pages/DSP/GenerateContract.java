package Pages.DSP;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class GenerateContract  {
	WebDriver driver;
	public  GenerateContract(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//button[contains(text(), 'Generate Contract')]")
	WebElement generateContractModalBtn;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement dealOptionName;
	
	@FindBy(xpath="//select[@id='templateName']")
	WebElement templateName;
	
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
       
       public ViewContract ContractGeneration(Map<String,Object> data)throws Throwable  {

    	   CommonFunctions functions=new CommonFunctions();

		// Open generate contract modal
		//waitForvisibility(generateContractModalBtn,10);
		functions.click(driver,generateContractModalBtn);

    	// Fill out modal
		functions.setText(driver, dealOptionName, data.get("Dealoptionname").toString());

		// Select the option using the visible text
    	functions.selectDropdownByVisibleText(driver,templateName,data.get("TemplateName").toString());

		// Add contact notice address
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
    	contactNameValue.get(1).click();
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
    	   return new ViewContract(driver);
}
}
