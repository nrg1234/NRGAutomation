package Pages.Siebel;

import Pages.VHOS.LoginVhos;
import Pages.commonObjects.Opportunity;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BAApprovescreditinSiebel {

	By opportunitiesTabsiebe = By.xpath("//a[contains(text(), 'Opportunities')]");

	@FindAll(value = { @FindBy(xpath = "//input[@name='s_3_1_3_0']") })
	public List<WebElement> Protectedclasscheckbox;
	@FindBy(xpath = "//a[contains(text(), 'Opportunities')]")
	WebElement opportunitiesTabsiebel;
	// a[contains(text(), 'Third Parties')]
	// a[contains(text(), 'Elixir Financial LLC')]
	// a[contains(text(), 'Contacts')]
	//span[@id='s_4_1_17_0_icon']
	//input[@name='s_4_1_17_0']
	@FindBy(xpath = "//input[@name='s_4_1_17_0']")
	WebElement Assesmentname;
	@FindBy(xpath = "//span[@id='s_4_1_17_0_icon']")
	WebElement Assesmentoveride;
	@FindBy(xpath = "//a[contains(text(), 'Third Parties')]")
	WebElement ThirdParty;
	
	@FindAll(value = { @FindBy(xpath = "//div[contains(text(), 'Assessment Override')]") })
	public List<WebElement> Assesmentoverride;
	@FindBy(xpath = "//a[contains(text(), 'Elixir Financial LLC')]")
	WebElement ThirdPartyName;
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement Contacts;
	@FindBy(xpath = "//select[@name='s_vis_div']")
	WebElement allOpportunityDropdown;
	@FindBy(xpath = "//button[@id='s_4_1_17_0_Ctrl']|//button[@title='Opportunity List:Query']")
	WebElement queryBtn;
	@FindBy(xpath = "//button[contains(text(),'Query')]")
	WebElement queryBtnincontracts;
	@FindBy(xpath = "//td[@id='1_s_4_l_Opportunity__']")
	WebElement opportunityId;
	@FindBy(xpath = "//td[@id='1_s_4_l_Name']")
	WebElement opportunityName;
	@FindBy(xpath = "//button[@id='s_4_1_14_0_Ctrl']|//button[@id='s_4_1_20_0_Ctrl']")
	WebElement goBtn;
	@FindBy(xpath = "//button[contains(text(),'Go')]")
	WebElement goBtnincontracts;
	// span[contains(text(), 'Go')]
	@FindBy(xpath = "//button[@name='s_1_1_0_0']")
	WebElement gobtn;
	@FindBy(xpath = "//*[@id='a_3']/div/table/tbody/tr/td/div[1]/span/table/tbody/tr/td[1]")
	WebElement otherRandomDiv;
	@FindBy(xpath = "//a[contains(text(), 'Credit Review Result')]")
	WebElement creditReviewResultTab;
	@FindBy(xpath = "//tr[@class='ui-widget-content jqgrow ui-row-ltr ui-state-highlight']/td[@id='1_s_1_l_Alert_Number']/a[@name='Alert Number']")
	WebElement creditAlertDrilldown;
	@FindBy(xpath = "//input[@name='s_1_1_6_0']")
	WebElement evaluator;
	@FindBy(xpath = "//input[@name='s_2_1_2_0']")
	WebElement creditReviewResultDropdown;
	@FindBy(xpath = "//li[@class='ui-menu-item']/a[@id='ui-id-1591']")
	WebElement creditReviewResultValue;
	@FindBy(xpath = "//input[@name='s_1_1_4_0']")
	WebElement rergScore;
	@FindBy(xpath = "//img[@id='s_1_1_7_0_icon']")
	WebElement lastcreditevaluationdate;
	@FindBy(xpath = "//input[@name='s_1_1_2_0']")
	WebElement legalEntity;
	@FindBy(xpath = "//input[@id='1_Name']")
	WebElement OpportunityNamefield;
	@FindBy(id = "1_Opportunity__")
	WebElement Opportunityidfield;
	@FindBy(xpath = "//a[@name='Name']")
	WebElement opportunitiesLst;
	@FindBy(xpath = "//a[contains(text(),'Pricing Instructions PJM Deals')]")
	WebElement Pricinglink;
	@FindBy(xpath = "//input[@name='s_1_1_56_0']")
	WebElement StatusDpdown;
	@FindBy(xpath = "//img[@id='s_1_1_56_0_icon']")
	WebElement ArrowBtn;
	@FindBy(xpath = "//img[@id='s_1_1_7_0_icon']|//span[@class='siebui-icon-date applet-form-date applet-list-date']")
	WebElement calendarIcon;
	@FindBy(xpath = "//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	WebElement calendarDoneBtn;
	@FindBy(xpath = "//a[contains(text(), '17')]")
	WebElement calendarDate;
	@FindBy(xpath = "//td[@id='2_s_3_l_Street_Address']")
	WebElement ChooseCustomer;
	@FindBy(xpath = "//button[@id='s_at_m_2']")
	WebElement MenuBtn;
	@FindBy(xpath = "//button[contains(text(),'Menu ')]")
	WebElement MenuBtn1;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(),'New Query                   [Alt+Q]')]") })
	public List<WebElement> NewQueryBtn;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(),'Run Query               [Alt+ENTER]')]") })
	public List<WebElement> RunQueryBtn;
	@FindBy(id = "1_ROE_Amendment__")
	WebElement Amendmentfield;
	@FindBy(xpath = "//input[@name='SWEUserName']")
	WebElement siebelUserName;
	@FindBy(xpath = "//input[@name='SWEPassword']")
	WebElement siebelPassword;
	@FindBy(xpath = "//a[@id='s_swepi_22']")
	WebElement submitBtn;
	@FindBy(xpath = "//select[@class='searchField']")
	WebElement createdbydropdown;
	@FindBy(xpath = " //td[@id='1_s_4_l_Type']")
	WebElement OpportunityType;
	@FindBy(xpath = "//img[@id='1_Type_icon']")
	WebElement Opportunitytypedropdownbtn;
	@FindBy(xpath = " //a[contains(text(),'Renewal')]")
	WebElement Renewalbtn;
	By RenewalCustomeraccount = By.xpath("//a[@name='Account']");
	@FindBy(xpath = "//a[contains(text(),'Contracts')]")
	WebElement contractstab;
	@FindBy(id = "1_Agreement_Number")
	WebElement contractfieldvalue;
	@FindBy(id = "1_s_1_l_Agreement_Number")
	WebElement contractfield;
	@FindBy(xpath = "//input[@name='s_1_1_2_0']")
	WebElement contractvaluefield;

	@FindBy(xpath = "//input[@name='s_1_1_1_0']")
	WebElement contractsearchfield;
	@FindBy(xpath = "//a[@name='Agreement Number']")
	WebElement contracthyperlink;
//	@FindBy(xpath = "//select[@class='siebui-nav-links siebui-nav-viewlist']")
	@FindBy(xpath = "//*[@id='j_s_vctrl_div_tabScreen']")
	WebElement DropdownforAmendments;
	@FindBy(xpath = "//span[@id='s_1_1_1_0_icon']")
	WebElement Dropdownclick;
	@FindBy(xpath = "//select[@name='S_A4_tgs']")
	WebElement Adddeletedetaildropdown;
	@FindBy(xpath = "//select[@name='S_A5_tgs']")
	WebElement Adddeletedetaildropdown1;
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	WebElement createdByBtn;
	@FindBy(xpath = "//*[@id=\"jqgh_s_5_l_ROE_Created_Date\"]/span/span[1]")
	WebElement Sortascending;
	@FindBy(xpath = "//a[contains(text(),'Amendment Attachments')]")
	WebElement AmendmentAttachments;
	@FindBy(xpath = "//span[@id='s_2_1_5_0']")
	WebElement NewfileBtn;
	@FindBy(id = "1_s_2_l_ROE_Ready_to_Upload")
	WebElement ReadytoUploadfield;
	@FindBy(id = "1_ROE_Ready_to_Upload")
	WebElement ReadytoUploadCheckbox;
	@FindBy(xpath = "//button[@id='s_4_1_29_0_Ctrl']")
	WebElement UploadBtn;
	@FindBy(xpath = "//a[contains(text(),'Amendment Sites')]")
	WebElement AmendmentSitesBtn;
	@FindBy(xpath = "//input[@aria-label='Amendment Name']")
	WebElement Amendmentid;
	@FindBy(xpath = "//button[contains(text(),'Obtain Load')]")
	WebElement ObtainloadBtn;
	@FindBy(xpath = "//img[@id='s_4_1_20_0_icon']")
	WebElement StatusDropdown;
	@FindBy(xpath = "//a[contains(text(),'Submitted')]")
	WebElement SubmittedBtn;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement SubmitBtn;
	@FindBy(xpath = "//button[@id='s_4_1_26_0_Ctrl']")
	WebElement NewAmendmentBtn;
	@FindBy(xpath = "//button[contains(text(),'Close Contract')]")
	WebElement CloseContract;
	@FindBy(xpath = "//a[@name='Agreement Name']")
	WebElement ContractName;
	@FindBy(xpath = " //button[contains(text(),'Enroll Contract')]")
	WebElement EnrollContract;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(), 'Save Record                [Ctrl+S]')]") })
	public List<WebElement> SaveRecord;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(), 'Save Record')]") })
	public List<WebElement> SaveRecord1;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(),'Contracts')]") })
	public List<WebElement> ContractBtnforOpportunity;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Menu ')]") })
	public List<WebElement> AmendmentMenuBtn;
	@FindBy(xpath = " //td[@id='1_s_5_l_Rec_Percentage']")
	WebElement RecPercentage;
	@FindAll(value = { @FindBy(xpath = "//a[contains(text(), 'Contracts')]") })
	public List<WebElement> cBtn;
	@FindBy(xpath = " //a[contains(text(), 'Contracts')]")
	WebElement Contractsbtn;
	@FindBy(xpath = " //a[@name='Agreement Name']")
	WebElement Contractsname;
	@FindBy(xpath = " //input[@name='s_5_1_0_0']")
	WebElement attributename;
	@FindBy(xpath = " //input[@name='s_5_1_1_0']")
	WebElement attributevalue;
	@FindBy(xpath = " //button[@name='s_5_1_2_0']")
	WebElement attributego;

	@FindBy(xpath = " 	//div[contains(text(),'Product Attribute')]")
	WebElement productattribute;
	// a[@name='Agreement Name']

	// a[contains(text(), 'Contracts')]
	String Renewcustomer;
	String Renewcust;
	String Renewcustomer1;
	String Renewcustomer2;
	String Renewcust1;
	String Renewcust2;

	WebDriver driver;
	TestContext testContext;

	public BAApprovescreditinSiebel(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public void BAApprovescreditinSiebel(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 3; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.waitForvisibility(driver, creditAlertDrilldown, 5);

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);
		// creditAlertDrilldown.click();
		// Wait for credit alert drill down to appear

		functions.waitForvisibility(driver, evaluator, 10);

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);

		// Click into opportunities tab to save changes
		functions.intermediatewait();
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		functions.intermediatewait();

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public void ValidateMvpCrr(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 3; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);
		functions.vshortWait();
		// functions.click(driver, Contractsbtn);
		cBtn.get(1).click();
		functions.vshortWait();
		functions.click(driver, Contractsname);
		functions.intermediatewait();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", productattribute);
		System.out.println("Productattribute is displayed");

		functions.click(driver, attributename);
		functions.shortWait();
		functions.setText(driver, attributename, "Attribute Name");
		attributename.sendKeys(Keys.ENTER);
		functions.setText(driver, attributevalue, "Material");
		functions.shortWait();
		try {
			functions.click(driver, attributego);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		attributevalue.clear();
		functions.setText(driver, attributevalue, "Management Fee");
		functions.shortWait();
		try {
			functions.click(driver, attributego);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		attributevalue.clear();
		functions.setText(driver, attributevalue, "QSE Fee");
		functions.shortWait();
		try {
			functions.click(driver, attributego);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public void ValidateEma(String Optyid, String opportunityname) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 1; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);
		functions.vshortWait();
		functions.click(driver, ThirdParty);
		functions.vshortWait();
		functions.click(driver, ThirdPartyName);
		functions.shortWait();
		functions.click(driver, Contacts);
		String alpha = "NewAnalystSeibel";
		functions.takeSnapShot(driver, opportunityname, alpha);
		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public void BAApprovescreditinSiebelforAggregate(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();

		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh
		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);

		for (int i = 0; i < 1; i++) {
			// Press the TAB Key to Switch Focus to Permanent Address
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID
		functions.vshortWait();

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it
		functions.intermediatewait();

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.shortWait();

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);

		// Wait for credit alert drill down to appear

		functions.intermediatewait();

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		// Wait for everything to update
		functions.intermediatewait();
		// Clicks on Menu Button
		functions.click(driver, MenuBtn);

		// Wait for everything to update
		functions.shortWait();

		// Select the Save Record from the Menu Dropdown
		SaveRecord.get(1).click();

		// Click into opportunities tab to save changes
		driver.navigate().back();

		// Wait for everything to update
		functions.intermediatewait();
		// Selects the Second Customer for Approving credit
		ChooseCustomer.click();

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);

		// Wait for credit alert drill down to appear

		functions.intermediatewait();

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		// Wait for everything to update
		functions.intermediatewait();

		// Click into opportunities tab to save changes
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		functions.intermediatewait();

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public String SelectRenewalcustomerfromSiebel(String password) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Navigate to Siebel
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("siebel-url") + "');");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Enter username and password
		functions.setText(driver, siebelUserName, prop.getProperty("SiebelUsername"));
		functions.setText(driver, siebelPassword, password);

		// Log in
		functions.click(driver, submitBtn);

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		functions.click(driver, createdbydropdown);

		functions.selectDropdownByVisibleText(driver, createdbydropdown, "Opportunity Type");

		functions.shortWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		functions.click(driver, OpportunityType);

		functions.click(driver, Opportunitytypedropdownbtn);

		functions.click(driver, Renewalbtn);

		functions.shortWait();

		functions.click(driver, goBtn);

		functions.intermediatewait();

		// Storing and Returning the text into a String
		List<WebElement> myList = driver.findElements(RenewalCustomeraccount);
		List<String> all_elements_text = new ArrayList<>();
		for (int i = 0; i < myList.size(); i++) {
			Renewcustomer = myList.get(2).getText();
			Renewcust = Renewcustomer.replaceAll("'", "");
			all_elements_text.add(myList.get(i).getText());
			System.out.println(Renewcust);
		}
		functions.Closedriver(driver);
		driver.switchTo().window(tabs2.get(0));
		return Renewcust;
	}

	public String SelectRenewalAggregatecustomerfromSiebel(String password) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("siebel-url") + "');");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		functions.setText(driver, siebelUserName, prop.getProperty("SiebelUsername"));
		functions.setText(driver, siebelPassword, password);
		functions.click(driver, submitBtn);
		functions.mediumWait();
		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");
		functions.mediumWait();
		functions.click(driver, createdbydropdown);
		functions.selectDropdownByVisibleText(driver, createdbydropdown, "Opportunity Type");
		functions.shortWait();
		functions.click(driver, queryBtn);
		functions.click(driver, OpportunityType);
		functions.click(driver, Opportunitytypedropdownbtn);
		functions.click(driver, Renewalbtn);
		functions.shortWait();
		functions.click(driver, goBtn);
		functions.intermediatewait();
		List<WebElement> myList = driver.findElements(RenewalCustomeraccount);
		List<String> all_elements_text = new ArrayList<>();
		for (int i = 0; i < myList.size(); i++) {
			Renewcustomer1 = myList.get(2).getText();
			Renewcustomer2 = myList.get(3).getText();
			Renewcust1 = Renewcustomer1.replaceAll("'", "");
			Renewcust2 = Renewcustomer2.replaceAll("'", "");
			all_elements_text.add(myList.get(i).getText());
			System.out.println(Renewcust);
		}
		functions.Closedriver(driver);
		driver.switchTo().window(tabs2.get(0));
		return Renewcust1 + "," + Renewcust2;
	}

	public void BAApprovescreditandcreatesamendmentinSiebel(String Optyid, String Contractid) throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.intermediatewait();
		// functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		// functions.mediumWait();
		functions.intermediatewait();
		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		// functions.mediumWait();
		functions.intermediatewait();
		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 3; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		// functions.mediumWait();
		functions.intermediatewait();
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.waitForvisibility(driver, creditAlertDrilldown, 5);

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);
		// creditAlertDrilldown.click();
		// Wait for credit alert drill down to appear

		functions.waitForvisibility(driver, evaluator, 10);

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);

		// Click into opportunities tab to save changes
		functions.intermediatewait();
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		// functions.intermediatewait();
		// Click into opportunities tab to save changes
		functions.click(driver, contractstab);
//
		// Wait for everything to update
		functions.intermediatewait();

		driver.navigate().refresh();

		functions.intermediatewait();

		functions.click(driver, contractstab);

		functions.midWait();

		// Query for the contract
		functions.click(driver, queryBtnincontracts);

		// Wait for query view to appear
		functions.midWait();

		// functions.click(driver, contractfield);
		functions.click(driver, contractsearchfield);
		functions.minwait();
		functions.setText(driver, contractsearchfield, "Contract #");
		contractsearchfield.sendKeys(Keys.ENTER);
		functions.setText(driver, contractvaluefield, Contractid);

		// Query for the opportunity by ID
		functions.click(driver, gobtn);

		// Wait for query to finish
		functions.mediumWait();

		Actions act = new Actions(driver);
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			act.sendKeys(Keys.TAB);
			act.build().perform();
		}

		functions.click(driver, contracthyperlink);

		functions.click(driver, DropdownforAmendments);

		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");

		functions.intermediatewait();

		functions.click(driver, NewAmendmentBtn);

		functions.intermediatewait();

		functions.click(driver, AmendmentAttachments);

		functions.click(driver, NewfileBtn);

		// String filePath = prop.getProperty("AddSitesPath");

		// filePath.replaceAll("\\\\", "\\\\\\\\");

		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(
				pdffile + "\\src\\test\\resources\\DataReader\\Amendment_Attachment_add.xlsx");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);


			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} catch (AWTException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("exception on send attchement");
		}

		functions.intermediatewait();

		functions.click(driver, ReadytoUploadfield);

		functions.shortWait();

		functions.click(driver, ReadytoUploadCheckbox);

		functions.intermediatewait();

		functions.click(driver, UploadBtn);

		functions.midWait();

		functions.click(driver, ObtainloadBtn);


		driver.navigate().refresh();
		functions.click(driver, ObtainloadBtn);
		driver.navigate().refresh();
		
		
		functions.click(driver, Assesmentoveride);
		
		Assesmentoverride.get(0).click();
		
//		functions.midWait();
//
//		functions.click(driver, contractstab);
//
//		functions.midWait();
//
//		// Query for the contract
//		functions.click(driver, queryBtnincontracts);
//
//		// Wait for query view to appear
//		functions.midWait();
//
//		// functions.click(driver, contractfield);
//		functions.click(driver, contractsearchfield);
//		functions.minwait();
//		functions.setText(driver, contractsearchfield, "Contract #");
//		contractsearchfield.sendKeys(Keys.SPACE);
//		functions.setText(driver, contractvaluefield, Contractid);
//
//		// Query for the opportunity by ID
//		functions.click(driver, gobtn);
//
//		// Wait for query to finish
//		functions.mediumWait();
//
//		Actions act1 = new Actions(driver);
//		// Click somewhere else to be able to click into opportunity
//		for (int i = 0; i < 2; i++) {
//			act1.sendKeys(Keys.TAB);
//			act1.build().perform();
//		}
//
//		functions.click(driver, contracthyperlink);
//
//		functions.click(driver, DropdownforAmendments);
//
//		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");
//
//		functions.intermediatewait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown, "Add/Delete Amendment List");
//
//		functions.intermediatewait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.dealconversion3();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown1, "Add/Delete Amendment Detail");
//
//		functions.shortWait();

		functions.click(driver, SubmitBtn);
		functions.click(driver, SubmitBtn);
		functions.click(driver, SubmitBtn);

		functions.maxWait();
		functions.click(driver, DropdownforAmendments);
		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Sites");
		functions.intermediatewait();
		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public void BAApprovescreditanddeleteamendmentinSiebel(String Optyid, String Contractid) throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.intermediatewait();
		// functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		// functions.mediumWait();
		functions.intermediatewait();
		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		// functions.mediumWait();
		functions.intermediatewait();
		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 3; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		// functions.mediumWait();
		functions.intermediatewait();
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.waitForvisibility(driver, creditAlertDrilldown, 5);

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);
		// creditAlertDrilldown.click();
		// Wait for credit alert drill down to appear

		functions.waitForvisibility(driver, evaluator, 10);

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);

		// Click into opportunities tab to save changes
		functions.intermediatewait();
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		// functions.intermediatewait();
		// Click into opportunities tab to save changes
		functions.click(driver, contractstab);
//
		// Wait for everything to update
		functions.intermediatewait();

		driver.navigate().refresh();

		functions.intermediatewait();

		functions.click(driver, contractstab);

		functions.midWait();

		// Query for the contract
		functions.click(driver, queryBtnincontracts);

		// Wait for query view to appear
		functions.midWait();

		// functions.click(driver, contractfield);
		functions.click(driver, contractsearchfield);
		functions.minwait();
		functions.setText(driver, contractsearchfield, "Contract #");
		contractsearchfield.sendKeys(Keys.ENTER);
		functions.setText(driver, contractvaluefield, Contractid);

		// Query for the opportunity by ID
		functions.click(driver, gobtn);

		// Wait for query to finish
		functions.mediumWait();

		Actions act = new Actions(driver);
		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			act.sendKeys(Keys.TAB);
			act.build().perform();
		}

		functions.click(driver, contracthyperlink);

		functions.click(driver, DropdownforAmendments);

		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");

		functions.intermediatewait();

		functions.click(driver, NewAmendmentBtn);

		functions.intermediatewait();

		functions.click(driver, AmendmentAttachments);

		functions.click(driver, NewfileBtn);

		// String filePath = prop.getProperty("AddSitesPath");

		// filePath.replaceAll("\\\\", "\\\\\\\\");

		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(
				pdffile + "\\src\\test\\resources\\DataReader\\Amendment_Attachment_delete.xlsx");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);


			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} catch (AWTException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("exception on send attchement");
		}

		functions.intermediatewait();

		functions.click(driver, ReadytoUploadfield);

		functions.shortWait();

		functions.click(driver, ReadytoUploadCheckbox);

		functions.intermediatewait();

		functions.click(driver, UploadBtn);

		functions.midWait();

		functions.click(driver, ObtainloadBtn);

		driver.navigate().refresh();
		functions.click(driver, ObtainloadBtn);
		driver.navigate().refresh();
		functions.longWait();
		driver.navigate().refresh();
		
		functions.click(driver, Assesmentoveride);
		
		Assesmentoverride.get(0).click();
		
//		functions.midWait();
//
//		functions.click(driver, contractstab);
//
//		functions.midWait();
//
//		// Query for the contract
//		functions.click(driver, queryBtnincontracts);
//
//		// Wait for query view to appear
//		functions.midWait();
//
//		// functions.click(driver, contractfield);
//		functions.click(driver, contractsearchfield);
//		functions.minwait();
//		functions.setText(driver, contractsearchfield, "Contract #");
//		contractsearchfield.sendKeys(Keys.SPACE);
//		functions.setText(driver, contractvaluefield, Contractid);
//
//		// Query for the opportunity by ID
//		functions.click(driver, gobtn);
//
//		// Wait for query to finish
//		functions.mediumWait();
//
//		Actions act1 = new Actions(driver);
//		// Click somewhere else to be able to click into opportunity
//		for (int i = 0; i < 2; i++) {
//			act1.sendKeys(Keys.TAB);
//			act1.build().perform();
//		}
//
//		functions.click(driver, contracthyperlink);
//
//		functions.click(driver, DropdownforAmendments);
//
//		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");
//
//		functions.intermediatewait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown, "Add/Delete Amendment List");
//
//		functions.intermediatewait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.dealconversion3();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown1, "Add/Delete Amendment Detail");
//
//		functions.shortWait();

		functions.click(driver, SubmitBtn);
		functions.click(driver, SubmitBtn);
		functions.click(driver, SubmitBtn);

		functions.maxWait();
		functions.click(driver, DropdownforAmendments);

		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Sites");
		functions.intermediatewait();

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
	}
//		CommonFunctions functions = new CommonFunctions();
//		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
//		ConfigReader config = new ConfigReader();
//		Properties prop = config.init_properties();
//		config.init_properties();
//
//		// getting all the handles currently available
//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs2.get(1));
//
//		// Wait for UI to finish building
//		functions.mediumWait();
//		functions.waitForvisibility(driver, opportunitiesTabsiebel, 23);
//		// Go to opportunities tab
//
//		try {
//			functions.click(driver, opportunitiesTabsiebel);
//		} catch (StaleElementReferenceException e) {
//			e.getMessage();
//		}
//
//		// Select "all opportunities"
//		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");
//
//		// Wait few seconds for opportunities to refresh
//
//		functions.mediumWait();
//
//		// Query for the opportunity
//		functions.click(driver, queryBtn);
//
//		// Wait for query view to appear
//		functions.mediumWait();
//
//		Actions actions = new Actions(driver);
//		// Press the TAB Key to Switch Focus to Permanent Address
//		for (int i = 0; i < 3; i++) {
//			actions.sendKeys(Keys.TAB);
//			actions.build().perform();
//		}
//
//		functions.setText(driver, Opportunityidfield, Optyid);
//
//		// Query for the opportunity by ID
//
//		functions.waitForvisibility(driver, goBtn, 5);
//
//		functions.click(driver, goBtn);
//
//		// Wait for query to finish
//		functions.mediumWait();
//
//		// Click somewhere else to be able to click into opportunity
//		for (int i = 0; i < 2; i++) {
//			actions.sendKeys(Keys.TAB);
//			actions.build().perform();
//		}
//		// Wait for credit review request to appear, then click it
//
//		functions.waitForvisibility(driver, opportunitiesLst, 10);
//
//		// Click into opportunity
//		functions.click(driver, opportunitiesLst);
//
//		// Click into creditReviewResultTab
//		functions.click(driver, creditReviewResultTab);
//
//		functions.waitForvisibility(driver, creditAlertDrilldown, 5);
//
//		// Scroll down to credit alert drill down, then click it
//		functions.click(driver, creditAlertDrilldown);
//
//		// Wait for credit alert drill down to appear
//
//		functions.waitForvisibility(driver, evaluator, 10);
//
//		// Wait for last credit eval date input, and enter today's date
//		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
//		functions.click(driver, calendarIcon);
//		functions.click(driver, calendarDate);
//		functions.click(driver, calendarDoneBtn);
//
//		// Select a RERG score, and set status to accepted
//		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
//		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));
//
//		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);
//
//		// Click into opportunities tab to save changes
//		functions.click(driver, contractstab);
//
//		// Wait for everything to update
//		functions.intermediatewait();
//
//		driver.navigate().refresh();
//
//		// Wait for everything to update
//		functions.intermediatewait();
//
//		// Click on Contracts Tab
//		functions.click(driver, contractstab);
//
//		// Wait for everything to update
//		functions.midWait();
//
//		// Click on Contract Tab
//		functions.click(driver, contractstab);
//
//		// Wait for everything to update
//		functions.midWait();
//
//		// Query for the contract
//		functions.click(driver, queryBtnincontracts);
//
//		// Wait for query view to appear
//		functions.midWait();
//
//		// Click on Contracts Field
//		functions.click(driver, contractfield);
//
//		// Enter Contract Id in Contract Field
//		functions.setText(driver, contractfieldvalue, Contractid);
//
//		// Query for the opportunity by ID
//		functions.click(driver, goBtnincontracts);
//
//		// Wait for query to finish
//		functions.mediumWait();
//
//		Actions act = new Actions(driver);
//		// Click somewhere else to be able to click into opportunity
//		for (int i = 0; i < 2; i++) {
//			act.sendKeys(Keys.TAB);
//			act.build().perform();
//		}
//
//		functions.click(driver, contracthyperlink);
//
//		functions.click(driver, DropdownforAmendments);
//
//		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");
//
//		functions.intermediatewait();
//
//		functions.click(driver, NewAmendmentBtn);
//
//		functions.intermediatewait();
//
//		functions.click(driver, AmendmentAttachments);
//
//		functions.click(driver, NewfileBtn);
//
//		// choosing the file to upload
//		String pdffile = System.getProperty("user.dir");
//
//		StringSelection ss = new StringSelection(
//				pdffile + "\\src\\test\\resources\\DataReader\\Amendment_Attachment_delete.xlsx");
//
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_V);
//			r.keyRelease(KeyEvent.VK_V);
//			r.keyRelease(KeyEvent.VK_CONTROL);
//
//			r.keyPress(KeyEvent.VK_ENTER);
//			r.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//		} catch (AWTException | InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.out.println("exception on send attchement");
//		}
//		functions.intermediatewait();
//
//		functions.click(driver, ReadytoUploadfield);
//
//		functions.shortWait();
//
//		functions.click(driver, ReadytoUploadCheckbox);
//
//		functions.intermediatewait();
//
//		functions.click(driver, UploadBtn);
//
//		functions.mediumWait();
//
//		functions.click(driver, AmendmentSitesBtn);
//
//		functions.intermediatewait();
//
//		functions.click(driver, ObtainloadBtn);
//
//		functions.midWait();
//
//		functions.click(driver, contractstab);
//
//		functions.mediumWait();
//
//		// Query for the contract
//		functions.click(driver, queryBtnincontracts);
//
//		// Wait for query view to appear
//		functions.mediumWait();
//
//		functions.click(driver, contractfield);
//
//		functions.setText(driver, contractfieldvalue, Contractid);
//
//		// Query for the opportunity by ID
//
//		functions.click(driver, goBtnincontracts);
//
//		// Wait for query to finish
//		functions.mediumWait();
//
//		Actions action = new Actions(driver);
//		// Click somewhere else to be able to click into opportunity
//		for (int i = 0; i < 2; i++) {
//			action.sendKeys(Keys.TAB);
//			action.build().perform();
//		}
//
//		functions.click(driver, contracthyperlink);
//
//		functions.click(driver, DropdownforAmendments);
//
//		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "Add/Delete Amendments");
//
//		functions.intermediatewait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown, "Add/Delete Amendment List");
//
//		functions.intermediatewait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.dealconversion3();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.click(driver, createdByBtn);
//
//		functions.vshortWait();
//
//		functions.selectDropdownByVisibleText(driver, Adddeletedetaildropdown1, "Add/Delete Amendment Detail");
//
//		functions.shortWait();
//
//		functions.click(driver, SubmitBtn);
//
//		functions.maxWait();
//
//		functions.Closedriver(driver);
//
//		// switch to the parent window
//		driver.switchTo().window(tabs2.get(0));
//
//	}

	public void Modifying_Contract_Status(String Optyid) throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		functions.waitForvisibility1(driver, opportunitiesTabsiebe, 23);
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 1; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		functions.midintermediatewait();

		if (Protectedclasscheckbox.size() > 0 == true && Protectedclasscheckbox.get(0).isDisplayed() == true) {
			System.out.println("Checkbox is checked and Displayed");
		}

		ContractBtnforOpportunity.get(1).click();

		functions.midintermediatewait();

		functions.click(driver, ContractName);

		functions.midintermediatewait();

		functions.click(driver, CloseContract);

		functions.maxWait();

		functions.click(driver, CloseContract);

		functions.maxWait();

		functions.click(driver, CloseContract);

		functions.maxWait();

		functions.shortWait();
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);

		functions.click(driver, EnrollContract);

		functions.maxWait();

		// Click into opportunities tab to save changes
		functions.click(driver, opportunitiesTabsiebel);

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
	}

	public boolean ValidateMeterfeeandRecsinSiebel(String Optyid) throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		functions.waitForvisibility1(driver, opportunitiesTabsiebe, 23);
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 1; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		functions.midintermediatewait();

		ContractBtnforOpportunity.get(1).click();

		functions.midintermediatewait();

		functions.click(driver, ContractName);

		functions.midintermediatewait();

		functions.click(driver, DropdownforAmendments);

		functions.selectDropdownByVisibleText(driver, DropdownforAmendments, "BMQ & RECs");

		functions.intermediatewait();

		if (RecPercentage.isEnabled()) {
			System.out.println("pricing link is displayed");
			return true;
		}
		return true;
//		if (RecPercentage.isDisplayed() == true) {
//
//			System.out.println("Vol Recs is displayed");
//
//	}

	}

	public void BAApprovescreditandvalidateBrandinSiebel(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 1; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		try {

			Boolean found = false;

			WebElement element = driver.findElement(By.xpath("//input[@aria-label='Contract Brand']"));
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				if (allOptions.get(i).equals("Reliant"))
					;
				found = true;
				break;

			}
			if (found) {
				System.out.println("Value exists");
			}

		}

		catch (Exception e) {
			System.out.println("exception");
		}

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.waitForvisibility(driver, creditAlertDrilldown, 5);

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);
		// creditAlertDrilldown.click();
		// Wait for credit alert drill down to appear

		functions.waitForvisibility(driver, evaluator, 10);

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);

		// Click into opportunities tab to save changes
		functions.intermediatewait();
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		functions.intermediatewait();

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}

	public void BAApprovescreditandvalidatePricing(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Wait for UI to finish building
		functions.mediumWait();
		// Go to opportunities tab

		try {
			functions.click(driver, opportunitiesTabsiebel);
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Select "all opportunities"
		functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");

		// Wait few seconds for opportunities to refresh

		functions.mediumWait();

		// Query for the opportunity
		functions.click(driver, queryBtn);

		// Wait for query view to appear
		functions.mediumWait();

		Actions actions = new Actions(driver);
		// Press the TAB Key to Switch Focus to Permanent Address
		for (int i = 0; i < 1; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}

		functions.setText(driver, Opportunityidfield, Optyid);

		// Query for the opportunity by ID

		functions.waitForvisibility(driver, goBtn, 5);

		functions.click(driver, goBtn);

		// Wait for query to finish
		functions.mediumWait();

		// Click somewhere else to be able to click into opportunity
		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.TAB);
			actions.build().perform();
		}
		// Wait for credit review request to appear, then click it

		functions.waitForvisibility(driver, opportunitiesLst, 10);

		// Click into opportunity
		functions.click(driver, opportunitiesLst);

		functions.vshortWait();

		functions.click(driver, Pricinglink);

		functions.intermediatewait();

//		functions.click(driver, ArrowBtn);
//		
//		functions.shortWait();

		functions.click(driver, StatusDpdown);

		functions.vshortWait();

//		functions.setText(driver, StatusDpdown, "Ready to Work");

		StatusDpdown.sendKeys(Keys.BACK_SPACE);
		StatusDpdown.sendKeys(Keys.BACK_SPACE);
		StatusDpdown.sendKeys(Keys.BACK_SPACE);

		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("no alert");
		}

		functions.setText(driver, StatusDpdown, "Ready to Work");
//		StatusDpdown.sendKeys("Ready to Work");

		functions.vshortWait();
//		StatusDpdown.sendKeys(Keys.ENTER);

		// Clicks on Menu Button
		functions.click(driver, MenuBtn1);

		// Wait for everything to update
		functions.shortWait();

		// Select the Save Record from the Menu Dropdown
		SaveRecord1.get(1).click();

		// Click into opportunities tab to save changes
		driver.navigate().back();

		// Wait for everything to update
		functions.midintermediatewait();

		try {

			Boolean found = false;

			WebElement element = driver.findElement(By.xpath("//input[@aria-label='Contract Brand']"));
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			for (int i = 0; i < allOptions.size(); i++) {
				if (allOptions.get(i).equals("RENE"))
					;
				found = true;
				break;

			}
			if (found) {
				System.out.println("Value exists");
			}

		}

		catch (Exception e) {
			System.out.println("exception");
		}

		// Click into creditReviewResultTab
		functions.click(driver, creditReviewResultTab);

		functions.waitForvisibility(driver, creditAlertDrilldown, 5);

		// Scroll down to credit alert drill down, then click it
		functions.click(driver, creditAlertDrilldown);
		// creditAlertDrilldown.click();
		// Wait for credit alert drill down to appear

		functions.waitForvisibility(driver, evaluator, 10);

		// Wait for last credit eval date input, and enter today's date
		functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
		functions.click(driver, calendarIcon);
		functions.click(driver, calendarDate);
		functions.click(driver, calendarDoneBtn);

		// Select a RERG score, and set status to accepted
		functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
		functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));

		functions.waitForvisibility(driver, opportunitiesTabsiebel, 10);

		// Click into opportunities tab to save changes
		functions.intermediatewait();
		functions.click(driver, opportunitiesTabsiebel);

		// Wait for everything to update
		functions.intermediatewait();

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}
}
