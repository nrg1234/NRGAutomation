package Pages.DSP;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class PipelineSeibel {
	// locators
	CommonFunctions functions = new CommonFunctions();

	@FindAll(value = { @FindBy(xpath = "//*[@id=\"renewals-table\"]") })
	public List<WebElement> Rowcount;
	@FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
	WebElement addCustomerBtn;
	@FindBy(xpath = "//input[@id='typeahead-customer']")
	WebElement customerNameInput;
	@FindBy(xpath = "//button[contains(text(), 'Create Customer')]")
	WebElement createCustomerBtn;
	@FindBy(xpath = "//*[@class='dropdown open dropdown-menu']")
	WebElement customersLst;
	@FindBy(xpath = "//div[@class='col p-3']")
	WebElement firstCustomerCard;
	@FindBy(xpath = "//button[contains(text(), 'Add To Opportunity')]")
	WebElement addCustomerToOptyBtn;
	@FindBy(xpath = "//button[contains(text(), 'Renew')]")
	WebElement renewButton;
	@FindBy(xpath = "//button[contains(text(), 'Restructure')]")
	WebElement restructureBtn;
	@FindBy(xpath = "//button[contains(text(), 'Create New Deal')]")
	WebElement createNewDealBtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Create New Deal')]") })
	public List<WebElement> createNewDealBtn1;
	@FindAll(value = { @FindBy(xpath = "//div[@class='col p-3']") })
	public List<WebElement> GMECustomerCard;
	@FindBy(xpath = "//button[contains(text(),'Renew')]")
	WebElement renewBtn;
	@FindBy(xpath = "//h3[@class='mdi mdi-menu-right']")
	WebElement contractexpandBtn;
	@FindBy(xpath = "//div[@class='control__indicator contract-checkbox']")
	WebElement contractCheckbox;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator contract-checkbox']") })
	public List<WebElement> contractCheckbox50kwh;
	@FindBy(xpath = "//button[contains(text(), 'Create Renewal Opportunity')]")
	WebElement createRenewalOptyBtn;
	@FindBy(xpath = "//a[contains(text(),'Renewals Pipeline')]")
	WebElement RenewalPipelineBTn;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator site-checkbox']") })
	public List<WebElement> SelectAllBtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi icon-renew mdi-autorenew']") })
	public List<WebElement> autorenewBtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='font-weight-light']") })
	public List<WebElement> contractidtext;
	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi mdi-menu-swap']") })
	public List<WebElement> AnnualUsageMenuswapper;
	@FindBy(xpath = "//span[@class='mdi mdi-menu-up']")
	WebElement AnnualUsageMenuUp;
	@FindBy(xpath = "//span[@class='mdi mdi-menu-down']")
	WebElement AnnualUsageMenudown;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator']") })
	public List<WebElement> EsIidCheckbox;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator contract-checkbox']") })
	public List<WebElement> Contractcbox;

	@FindBy(xpath = "//span[@class='icon icon-pencil brand-primary']")
	WebElement EditButton;

	@FindAll(value = { @FindBy(xpath = "//button[@class='mat-icon-button']") })
	public List<WebElement> calendarbtn;

	@FindAll(value = { @FindBy(xpath = "//span[@class='mat-button-wrapper']") })
	public List<WebElement> Enddate;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mat-button-wrapper']") })
	public List<WebElement> Duedate;
	@FindBy(xpath = "//div[contains(text(),'DEC')]")
	WebElement monthSelector;
	@FindBy(xpath = " //div[contains(text(),'2022')]")
	WebElement YearSelector;
	@FindBy(xpath = "//div[contains(text(),'30')]")
	WebElement DateSelector;
	@FindBy(xpath = "//span[@class='icon icon-check']")
	WebElement SaveButton;
	@FindBy(xpath = "//a[contains(text(),'Renewals Pipeline')]")
	WebElement RenewalPipelinebtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi icon-renew mdi-autorenew']") })
	public List<WebElement> customerBtn;
	@FindBy(xpath = "//span[@class='mdi icon-renew mdi-autorenew']")
	WebElement customerBtns;
	@FindBy(xpath = "//div[@class='control__indicator contract-checkbox']")
	WebElement contractcheckbox;
	@FindBy(xpath = "//button[contains(text(),' Create Renewal Opportunity')]")
	WebElement renewalopportunitybtn;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindAll(value = { @FindBy(xpath = "//a[@class='page-link']") })
	public List<WebElement> NextBTn;
	@FindBy(xpath = "//a[normalize-space()='2088']")
	WebElement Previouspage;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement Phonefield;
	@FindBy(xpath = "//select[@id='businessType']")
	WebElement Businesstypedropdown;
	@FindBy(xpath = "//input[@id='accountRep']")
	WebElement AccountRepField;
	@FindBy(xpath = "//select[@id='salesChannel']")
	WebElement Saleschanneldropdown;
	@FindBy(xpath = "//div[@class='card mb-3 pb-3']")
	WebElement Siebelrecord;
	@FindAll(value = { @FindBy(xpath = "//div[@class='card mb-3 pb-3']") })
	public List<WebElement> Siebelrecord1;
	@FindBy(xpath = "//button[normalize-space()='Replace']")
	WebElement ReplaceBtn;
	@FindAll(value = { @FindBy(xpath = "//button[normalize-space()='Replace']") })
	public List<WebElement> ReplaceBtn1;
	@FindBy(xpath = "//button[normalize-space()='Add To Opportunity']")
	WebElement AddtoOptyBtn;
	@FindBy(xpath = "//button[normalize-space()='Create and Add']")
	WebElement CreateandAddBtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='icon icon-close']") })
	public List<WebElement> Popupclose;
	@FindBy(xpath = "//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;
	@FindAll(value = { @FindBy(xpath = "//span[contains(text(), 'Select')]") })
	public List<WebElement> productSelectBtn;
	@FindBy(xpath = "//td[@class='d-none d-md-table-cell'][normalize-space()='Isha Meshaal']")
	WebElement Customername;
	WebDriver driver;

	public PipelineSeibel(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public String Addcustomer() throws Throwable {
		// click on renewals

		functions.click(driver, RenewalPipelinebtn);
		functions.shortWait();
		// click on customer
		customerBtn.get(2).click();
		// click on checkbox
		functions.click(driver, contractcheckbox);
		functions.intermediatewait();
		// click on create renewal button
		functions.click(driver, renewalopportunitybtn);
		functions.dealconversion3();
		String oprtyid = opportunityIDText.getText();
		return oprtyid;
	}

	public String AddcustomerOtherSource() throws Throwable {
		// click on renewals

		functions.click(driver, RenewalPipelinebtn);
		functions.shortWait();

		NextBTn.get(8).click();
		functions.shortWait();

		functions.click(driver, Previouspage);
		functions.shortWait();

		// Breaking the Xpath
		String beforeXpath0 = "/html/body/jhi-main/div/jhi-opportunities/div/div[6]/div/jhi-renewals/div/pagination/ul/li[";

		// Breaking the Xpath
		String afterXpath0 = "]/a";

		// Breaking the Xpath
		String beforeXpath1 = "//*[@id='renewals-table']/table/tbody/tr[";

		// Breaking the Xpath
		String afterXpath1 = "]/td[2]";

		// for looping the Xpath
		for (int i = 6; i >= 3; i--) {
			// Appending the Xpath
			String actualXpath0 = beforeXpath0 + i + afterXpath0;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath0));

			// Printing the element text to Console
			System.out.println(element.getText());

//			// click on customer
		for (int j = 1; j <= 11; j++) {
				// Appending the Xpath
				String actualXpath1 = beforeXpath1 + j + afterXpath1;
				// Passing xpath to WebElement
				WebElement element1 = driver.findElement(By.xpath(actualXpath1));

				System.out.println(element1);

				try {
					if (element1.getText().equals("Keith Texter") && element1.isDisplayed() == true) {

						customerBtn.get(j - 1).click();
						functions.intermediatewait();
					}
				}

				catch (StaleElementReferenceException e) {
					e.getMessage();
				}

			}
			if (element.isDisplayed() == true)
			element.click();

		}
		functions.intermediatewait();
		// click on checkbox
		functions.click(driver, contractcheckbox);
		functions.intermediatewait();

		// click on create renewal button
		functions.click(driver, renewalopportunitybtn);
		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 140);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customerName']")));

		functions.setText(driver, Phonefield, "7654664783");
		functions.vshortWait();

		functions.selectDropdownByVisibleText(driver, Businesstypedropdown, "Automotive Dealers");
		functions.vshortWait();

		functions.setText(driver, AccountRepField, "pankajab");
		functions.vshortWait();

		functions.selectDropdownByVisibleText(driver, Saleschanneldropdown, "SMB Broker");
		functions.vshortWait();

		functions.click(driver, CreateandAddBtn);
		functions.vshortWait();
//
//		// Wait for Deal Option Status to be Approved
//		WebDriverWait wait1 = new WebDriverWait(driver, 140);
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card mb-3 pb-3']")));
//
//		functions.click(driver, Siebelrecord);
//		functions.vshortWait();
//
//		functions.click(driver, ReplaceBtn);
//		functions.vshortWait();
//
//		functions.click(driver, AddtoOptyBtn);
//		functions.vshortWait();
//
//		functions.Renewalprogresstracker();
//
//		// Click Editsites button
//		functions.click(driver, EditButton);
//
//		// Wait for sometime
//		functions.shortWait();
//
//		// Click Calendar button
//		calendarbtn.get(0).click();
//
//		// Wait for sometime
//		functions.shortWait();
//
//		// Select month
//		calendarbtn.get(1).click();
//
//		// Wait for sometime
//		functions.shortWait();
//
//		// Click Calendar button
//		Enddate.get(1).click();
//
//		// Wait for sometime
//		functions.shortWait();
//
//		// Select Year
//		functions.click(driver, YearSelector);
//
//		// Select month
//		functions.click(driver, monthSelector);
//
//		// Click Calendar button
//		Duedate.get(2).click();
//
//		// Click Calendar button
//		functions.click(driver, DateSelector);
//
//		// Click on Save Button
//		functions.click(driver, SaveButton);

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));
	}

	/*
	 * Select Renew Option for GME<50kwh
	 */

	public String SelectRenewButtonforGME(String renewCust) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, renewCust);

		// Select first customer card
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col p-3']")));
		GMECustomerCard.get(4).click();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait12 = new WebDriverWait(driver, 140);
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customerName']")));

		functions.setText(driver, Phonefield, "7654664783");
		functions.vshortWait();

		functions.selectDropdownByVisibleText(driver, Businesstypedropdown, "Automotive Dealers");
		functions.vshortWait();

		functions.setText(driver, AccountRepField, "pankajab");
		functions.vshortWait();

		functions.selectDropdownByVisibleText(driver, Saleschanneldropdown, "SMB Broker");
		functions.vshortWait();

		functions.click(driver, CreateandAddBtn);
		functions.vshortWait();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait11 = new WebDriverWait(driver, 140);
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card mb-3 pb-3']")));

		if (Siebelrecord1.size() >= 0 == true && Siebelrecord1.get(0).isDisplayed() == true) {
			functions.click(driver, Siebelrecord);
			functions.vshortWait();
		}

		if (ReplaceBtn1.size() >= 0 == true && ReplaceBtn1.get(0).isDisplayed() == true) {
			functions.click(driver, ReplaceBtn);
			functions.vshortWait();
		}

		// Click "add to opportunity" button
		WebDriverWait wait31 = new WebDriverWait(driver, 200);
		wait31.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		WebDriverWait wait8 = new WebDriverWait(driver, 200);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Renew')]")));

		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from Dsp
		String contracttext = contractidtext.get(0).getText();
		// String contract= contracttext.replaceAll("Contract:","");

		// Click on contract checkbox
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='control__indicator contract-checkbox']")));
		functions.click(driver, contractCheckbox);

		// Click on Create Renewal Opty Button
		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create Renewal Opportunity')]")));
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 190);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		// Storing and Returning the text into a String
		String optyid = functions.getText(driver, opportunityIDText);

		// Storing and Returning the text into a String

		return optyid + "," + contracttext;

	}

}
