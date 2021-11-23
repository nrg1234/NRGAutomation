package Pages.DSP;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
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

public class CreateOptyPopup  {

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

	WebDriver driver;
	public CreateOptyPopup(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Create new opportunity.
	 */
public void CreateNewOpportunity(HashMap<String, String > OptyHeader) throws Throwable {
CommonFunctions functions=new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();

	
functions.click(driver,createNewOptyBtn);

// Enter opportunity name
functions.setText(driver, opportunityName, OptyHeader.get("OPPORTUNITY_NAME"));

// Wait for Duedate pop up before writing to input
functions.setText(driver, dueDate, prop.getProperty("DueDate"));
 
// Select the Market using the visible text
 functions.selectDropdownByVisibleText(driver,market,prop.getProperty("Market"));

// Select the Marketsegment using the visible text
 functions.selectDropdownByVisibleText(driver,marketsegment,OptyHeader.get("MARKET_SEGMENT"));
		
// Select the start Date for the Opportunity
functions.setText(driver,startDate,OptyHeader.get("START_DATE"));
		
// Select the End Date for the Opportunity
functions.setText(driver,endDate,OptyHeader.get("END_DATE"));
		
//Select the AccountRep for the Opportunity
functions.setText(driver,accountRep,OptyHeader.get("MARKETER_NAME"));
functions.click(driver,accountRepMenu);

// Click "create Button"
List<WebElement> Createbutton= createBtn;
		if(Createbutton.size()>0 ==true && Createbutton.get(1).isDisplayed()==true) {
			Createbutton.get(1).click();
		}	
		
// Make sure opportunity was created
assertTrue("Newly created opty name should be displayed", randomOptyName.isDisplayed());
        
System.out.println("Adding customer to opty.");

}
}
