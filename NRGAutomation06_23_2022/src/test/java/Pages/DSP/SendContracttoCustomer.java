package Pages.DSP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import Utilities.ConfigReader;
import Utilities.Context;
import apphooks.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.TestContext;

public class SendContracttoCustomer {
	private Base base;
	TestContext testContext;
	String custemail;
	Putsbox putsbox = new Putsbox(base);
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link ng-star-inserted']") })
	public List<WebElement> sendContractToCustomerBtn;
	@FindBy(xpath = "//*[@id='customerEmail']")
	WebElement customerEmailInput;
	@FindBy(xpath = "//input[@ng-reflect-name='customerEmail1']")
	WebElement customerEmailInputforSecondCustomer;
	@FindBy(xpath = "//button[contains(text(), 'Send Contract')]")
	WebElement sendContractBtn;
	@FindBy(xpath = "//button[normalize-space()='Send To Closed']")
	WebElement SendtoClosedBtn;
	@FindBy(xpath = "//span[@class='modal-link']")
	WebElement contractidtext;
	@FindAll(value = { @FindBy(xpath = "//*[@id=\"disabled-button-wrapper\"]/button/text()") })
	public List<WebElement> SendtoClosedBtn1;
	@FindBy(xpath = "//button[contains(text(),'Closed')]")
	WebElement closedTab;
	@FindBy(xpath = "/html[1]/body[1]/jhi-main[1]/div[1]/jhi-opportunity[1]/div[1]/jhi-contract[1]/div[8]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]")
	private WebElement validatenamefielddsp;
	WebDriver driver;

	public SendContracttoCustomer(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Send Contract To Customer
	 */

	// Open contract generation modal
	public void Sendcontracttocustomer() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, prop.getProperty("customer-email"));

		// Send contract
		functions.click(driver, sendContractBtn);

		functions.waitforcontractstatus();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Received')]")));

	}

	/*
	 * Send Contract To Aggregate Customer
	 */

	// Open contract generation modal
	public void SendcontracttoAggregatecustomer() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, prop.getProperty("customer-email"));

		functions.shortWait();

		functions.setText(driver, customerEmailInputforSecondCustomer, prop.getProperty("customer-email"));

		// Send contract
		functions.click(driver, sendContractBtn);

		functions.waituntilRenewalAggregatecontract();

	}

	/*
	 * Send Contract To Closed
	 */

	public void Sendcontracttoclosed() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Wait for Sometime
		functions.mediumWait();

		// Click on Send to Closed Button
		functions.click(driver, SendtoClosedBtn);

		functions.intermediatewait();

		// Click on Close Tab
		functions.click(driver, closedTab);

	}

	/*
	 * PassingEmailtoSendcontracttocustomerpopup for New Single >50kwh
	 */

	public void PassingEmailtoSendcontracttocustomerpopup() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Generating Put Box Email
		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
		custemail = mail.get("email");
		String strputsBoxURL = mail.get("emailURL");

		// Click on Send Contract to Customer Button
		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, custemail);

		// Wait for Sometime
		functions.shortWait();

		// Send contract
		functions.click(driver, sendContractBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to putsbox
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + strputsBoxURL + "');");
		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		putsbox.validateSingleEnrollmentEmailinPutsbox();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Received')]")));

		functions.click(driver, SendtoClosedBtn);

	}

	/*
	 * PassingEmailtoSendcontracttocustomerpopup for New Aggregate >50kwh
	 */

	public void PassingEmailtoSendcontracttoAggregatecustomerpopup() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Generating Put Box Email
		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
		custemail = mail.get("email");
		String strputsBoxURL = mail.get("emailURL");

		// Click on Send Contract to Customer Button
		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, custemail);

		// Wait for Sometime
		functions.shortWait();

		// Send contract
		functions.click(driver, sendContractBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to putsbox
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + strputsBoxURL + "');");
		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		putsbox.validateAggregateEnrollmentEmailinPutsbox();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Received')]")));

		functions.click(driver, SendtoClosedBtn);

	}

	/*
	 * PassingEmailtoSendcontracttocustomerpopup for New Single <50kwh
	 */

	public void PassingEmailtoSendcontracttocustomer() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Generating Put Box Email
		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
		custemail = mail.get("email");
		String strputsBoxURL = mail.get("emailURL");

		// Click on Send Contract to Customer Button
		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, custemail);

		// Wait for Sometime
		functions.shortWait();

		// Send contract
		functions.click(driver, sendContractBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to putsbox
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + strputsBoxURL + "');");
		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		putsbox.validateEmailinPutsboxforlessthan50();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Received')]")));

		functions.click(driver, SendtoClosedBtn);

	}

	/*
	 * PassingEmailtoSendcontracttocustomerpopup for New Aggregate <50kwh
	 */

	public void PassingEmailtoSendcontracttoAggregatecustomer() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Generating Put Box Email
		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
		custemail = mail.get("email");
		String strputsBoxURL = mail.get("emailURL");

		// Click on Send Contract to Customer Button
		sendContractToCustomerBtn.get(1).click();
		// Wait for spinner to Load
		functions.shortWait();

		// Enter email for contract
		functions.setText(driver, customerEmailInput, custemail);

		// Wait for Sometime
		functions.shortWait();

		// Send contract
		functions.click(driver, sendContractBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to putsbox
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + strputsBoxURL + "');");
		// getting all the handles currently available
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		putsbox.validateEmailinPutsboxforAggregatelessthan50();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Received')]")));

		functions.click(driver, SendtoClosedBtn);

	}

}
