package Pages.DSP;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class CreateOptyPopup extends Library {
	
	public  CreateOptyPopup(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//button[contains(text(), 'Create New Opportunity')]")
	WebElement createNewOptyBtn;
	
	@FindBy(id="opportunityName")
	WebElement opportunityName;
	
	@FindBy(xpath="//input[@id='dueDate']")
	WebElement dueDate;

	@FindBy(xpath="//select[@id='market']")
	WebElement market;
	
	@FindBy(xpath="//select[@id='marketSegment']")
	WebElement marketsegment;
	
	@FindBy(xpath="//input[@id='startDate']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@id='endDate']")
	WebElement endDate;
	
	@FindBy(xpath="//input[@name='thirdparty']")
	WebElement thirdParty;
	
	@FindBy(xpath="//input[@name='accountRep']")
	WebElement accountRep;
	
	@FindBy(xpath="//p[@class='typeahead-options-title']")
	WebElement accountRepMenu;
	
	@FindAll(value = { @FindBy(xpath="//button[contains(text(), 'Create')]") })
	public List<WebElement> createBtn;
	
	@FindBy(xpath="//*[@id=\'navbar-2\']/form/div[1]/div/h1")
	WebElement randomOptyName;

	/*
	 * Create new opportunity.
	 */
public void CreateNewOpportunity(Map<String,Object> data) throws Throwable {
CommonFunctions functions=new CommonFunctions();
functions.click(driver,createNewOptyBtn);

// Enter opportunity name
functions.setText(driver, opportunityName, data.get("Opportunityname").toString());

// Wait for Duedate pop up before writing to input
functions.setText(driver, dueDate, data.get("DueDate").toString());
 
// Select the Market using the visible text
 functions.selectDropdownByVisibleText(driver,market,data.get("Market").toString());

// Select the Marketsegment using the visible text
 functions.selectDropdownByVisibleText(driver,marketsegment,data.get("MarketSegment").toString());
		
// Select the start Date for the Opportunity
functions.setText(driver,startDate,data.get("startDate").toString());
		
// Select the End Date for the Opportunity
functions.setText(driver,endDate,data.get("endDate").toString());
		
//Select the AccountRep for the Opportunity
functions.setText(driver,accountRep,data.get("accountRep").toString());
functions.click(driver,accountRepMenu);

// Click "create Button"
List<WebElement> Createbutton= createBtn;
		if(Createbutton.size()>0 ==true && Createbutton.get(1).isDisplayed()==true) {
			Createbutton.get(1).click();
		}	
		
// Make sure opportunity was created
assertTrue("Newly created opty name should be displayed", randomOptyName.isDisplayed());

// Wait for modal to unload
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
        
System.out.println("Adding customer to opty.");
}

	
}
