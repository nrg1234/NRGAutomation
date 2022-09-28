package Pages.DSP;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;

public class BlankLOA {
	@FindBy(xpath = " //a[contains(text(),'SEND BLANK LOA')]")
	WebElement BlankLOABtn;
	@FindBy(xpath = "//input[@placeholder='Type an email address...']")
	WebElement CustomerEmail;
	@FindBy(xpath = "//button[contains(text(),'Send LOA')]")
	WebElement SendLOABtn;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OKBtn;
	@FindBy(xpath = "//button[@class='btn btn-primary opty-options-button']")
	WebElement CreateOptyDropdownBtn;
	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	@FindBy(xpath = "//button[contains(text(),'LOA')]")
	WebElement LOA;
	@FindBy(xpath = "//span[@class='icon icon-export brand-primary ng-star-inserted']")
	WebElement LOADownloadBtn;
	@FindBy(xpath = "//a[contains(text(),'All Opportunities')]")
	WebElement Allopportunitiesbtn;
	@FindBy(xpath = "//button[@class='btn btn-link edit-button']")
	WebElement EditButton;
	@FindBy(xpath = "//span[@class='mat-button-wrapper']")
	WebElement calendarbtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mat-button-wrapper']") })
	public List<WebElement> Enddate;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mat-button-wrapper']") })
	public List<WebElement> Duedate;
	@FindBy(xpath = "//div[contains(text(),'DEC')]")
	WebElement monthSelector;
	@FindBy(xpath = " //div[contains(text(),'2026')]")
	WebElement YearSelector;
	@FindBy(xpath = "//div[contains(text(),'30')]")
	WebElement DateSelector;
	@FindBy(xpath = "//span[@class='icon icon-check']")
	WebElement SaveButton;
	@FindBy(xpath = "//button[contains(text(), 'Clear Filters')]")
	WebElement clearFilterBtn;
	@FindBy(xpath = "//span[@class='icon icon-check brand-success align-middle ng-star-inserted']")
	WebElement ConfirmBtn;
	@FindBy(xpath = "//td[@id='esidColumn']")
	WebElement ESIIDcolumn;
	@FindBy(xpath = "//span[@class='label d-inline-block mr-0 pr-0 success']")
	WebElement LOAStatus;
	
	String customername;
	private Base base;
	TestContext testContext;
	String custemail;
    Putsbox putsbox = new Putsbox(base);
    CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	WebDriver driver;

	public BlankLOA(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	
	/*
	 * This Method is to Submit Blank LOA from DSP
	 */

	public void SelectSendBlankLOAfromOpportunityDropdown() throws Throwable {
		
		//Click on All Opportunities Button
		functions.click(driver, Allopportunitiesbtn);

		//Click on Dropdown Menu
		CreateOptyDropdownBtn.click();

		//Click on Blank LOA Button
		functions.click(driver, BlankLOABtn);

	}

	public void UsereceivesanemailwithBlankLOA() throws Throwable {

		// Generating Put Box Email
		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
		custemail = mail.get("email");
		String strputsBoxURL = mail.get("emailURL");

		//Passing Putsbox Email to Customer Email Field in Dsp
		functions.setText(driver, CustomerEmail, custemail);

		//Click on Send LOA Button
		functions.click(driver, SendLOABtn);

		//Click on Ok Button
		functions.click(driver, OKBtn);

		// Navigate to Putsbox
		putsbox.navigateToPutsMailBox(strputsBoxURL);

	}

	public void EnterallrequireddetailsandcompleteDocusign() throws Throwable {
		
		//Submitting the LOA 
		putsbox.validateEmailinPutsbox();

	}

	public void SearchforthesameopportunityinDSP() throws Throwable {

		//Navigate to DSP
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		//Disabling clearfilter Button
		if (clearFilterBtn.isDisplayed()) {
			functions.click(driver, clearFilterBtn);
		}

		//Click on Search Button
		functions.click(driver, SearchBtn);

		//Passing Putsbox email in the DSP Search Field
		functions.setText(driver, Searchplaceholder, custemail);

		//Wait for Sometime
		functions.shortWait();

		//Click on Opportunity Hyperlink
		driver.findElement(By.xpath("//a[contains(text(),'" + custemail + "')]")).click();

		//Wait for Sometime
		functions.shortWait();

	}

	public void DownloadtheLOAinDSP() throws Throwable {

		// Click Editsites button
		functions.click(driver, EditButton);

		// Wait for sometime
		functions.shortWait();

		// Click Calendar button
		functions.click(driver, calendarbtn);

		// Wait for sometime
		functions.shortWait();

		// Select month
		functions.click(driver, monthSelector);

		// Wait for sometime
		functions.shortWait();

		// Click Calendar button
		Enddate.get(1).click();

		// Wait for sometime
		functions.shortWait();

		// Select Year
		functions.click(driver, YearSelector);

		// Select month
		functions.click(driver, monthSelector);

		// Click Calendar button
		Duedate.get(2).click();

		// Click Calendar button
		functions.click(driver, DateSelector);

		//Click on Save Button
		functions.click(driver, SaveButton);
		//explicit wait ESID
		functions.shortWait();
		//Click on LOA Button
		functions.click(driver, LOA);
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-reflect-ng-class='success']")));

		//explicit wait
		//WebDriverWait wait1 = new WebDriverWait(driver, 400);
	//	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='label d-inline-block mr-0 pr-0 success']")));


		//Click on Download LOA 
		functions.click(driver, LOADownloadBtn);

	}
}
