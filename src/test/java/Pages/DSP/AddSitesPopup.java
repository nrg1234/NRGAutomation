package Pages.DSP;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class AddSitesPopup {

	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindBy(xpath = "//span[contains(text(),'Refresh Site List')]")
	WebElement RefreshsitelistBtn;
	@FindBy(xpath = "//button[contains(text(), 'Add Site')]")
	WebElement openAddSitesModalBtn;
	@FindBy(xpath = "//textarea[@id='esiids']")
	WebElement sitesTextArea;
	@FindBy(xpath = "//select[@id='customer']")
	WebElement CustomerDropdown;
	@FindBy(xpath = "//button[contains(text(),'Add to Queue')]")
	WebElement AddtoQueueBtn;
	@FindBy(xpath = "//button[contains(text(),' Confirm Site(s)')]")
	WebElement ConfirmSitesBtn;
	@FindBy(xpath = "//button[contains(text(), 'Add Site(s)')]")
	WebElement addSitesBtn;
	@FindBy(xpath = "//button[contains(text(), ' Submit Site(s) ')]")
	WebElement submitSitesBtn;
	@FindBy(xpath = "//button[contains(text(), ' Submit ')]")
	WebElement submitBtn;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//a[contains(text(), 'HU Upload')]")
	WebElement HUUpload;
	@FindBy(xpath = "//button[contains(text(), 'Select File(s)')]")
	WebElement selectHUFiles;
	@FindBy(xpath = "//button[contains(text(), ' Process HU')]")
	WebElement processHU;
	@FindBy(xpath = "//button[contains(text(), 'Credit')]")
	WebElement creditTAB;
	@FindBy(xpath = "//td[@id='esidColumn']")
	WebElement ESIID;
	@FindBy(xpath = "//h4[contains(text(),'Add Site Progress Tracker')]")
	WebElement Progresstracker;
	@FindBy(xpath = "//div[contains(@class,'check-3')]/following-sibling::div[@class='progress-bar bg-brand-success']")
	WebElement Progress;
	@FindBy(xpath = "//span[@ng-reflect-tooltip='Creation of Opportunity ID is ']")
	WebElement optyid;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Dismiss')]") })
	public List<WebElement> Dismissbtn;
	@FindBy(xpath = "//h4[contains(text(), 'Add Customer')]")
	WebElement AddCustomerbanner;
	@FindBy(xpath = "//h4[contains(text(), 'Create Customer')]")
	WebElement CreateCustomerbanner;
	@FindBy(xpath = "//a[normalize-space()='Bill Copy Pricing']")
	WebElement Billcopypricing;
	@FindBy(xpath = "//input[@formcontrolname='site']")
	WebElement Billcopyentersite;
	@FindBy(xpath = "//input[@id='startDate']")
	WebElement Startdate;
	@FindBy(xpath = "//input[@id='endDate']")
	WebElement Enddate;
	@FindBy(xpath = "//input[@formcontrolname='billedKW']")
	WebElement BilledKW;
	@FindBy(xpath = "//button[@id='browse-file']")
	WebElement Browsefile;

	WebDriver driver;

	public AddSitesPopup(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Add sites to opportunity.
	 */

	public String AddSitestotheOpty(String siteid) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Add sites to opportunity text area
		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, prop.getProperty(siteid));

		// Add sites to opportunity
		functions.click(driver, addSitesBtn);
		functions.click(driver, submitSitesBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.longWait();

	
		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}

	/*
	 * Add sites to opportunity for Aggregate Customer.
	 */

	public String AddSitestotheOptyforAggregatecustomer(String customername1, String customername2, String site1,
			String site2) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart,
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Wait for Customer dropdown to Appear
		functions.shortWait();

		// Select Aggregate Customers from the Customer Dropdown
		functions.click(driver, CustomerDropdown);
		functions.selectDropdownByVisibleText(driver, CustomerDropdown, customername1);

		// Add sites to opportunity text area

		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, prop.getProperty(site1));

		// Click on AddtoQueue Button
		functions.click(driver, AddtoQueueBtn);

		// Wait for Confirm Sites tracker to Appear
		functions.shortWait();

		// Click on COnfirm Sites Button
		functions.click(driver, ConfirmSitesBtn);

		// Select Aggregate Customers from the Customer Dropdown
		functions.click(driver, CustomerDropdown);
		functions.selectDropdownByVisibleText(driver, CustomerDropdown, prop.getProperty(customername2));

		// Add sites to opportunity text area

		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, prop.getProperty(site2));

		// Click on AddtoQueue Button
		functions.click(driver, AddtoQueueBtn);

		// Wait for Confirm Sites tracker to Appear
		functions.shortWait();
		// Click on COnfirm Sites Button
		functions.click(driver, ConfirmSitesBtn);

		// Add sites to opportunity
		functions.click(driver, addSitesBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait1 = new WebDriverWait(driver, 330);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.AggregateSitesProgress();

		// Storing and Returning the text into a String
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
	}
	/*
	 * Add sites to opportunity.
	 */

	public String AddSitestotheOptylessthan50(String siteid) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Add sites to opportunity text area
		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, prop.getProperty(siteid));

		// Add sites to opportunity
		functions.click(driver, addSitesBtn);
		functions.click(driver, submitSitesBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait = new WebDriverWait(driver, 140);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.dealconversion();

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}
	/*
	 * validate sites in DSP after uploading Amendment
	 */

	public void validatesitesinDSP() throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		functions.click(driver, sitesComponentCart);

		// Refresh the DSP Page
		driver.navigate().refresh();

		// wait for Page Refresh and Sites to get Refreshed
		functions.waituntilcontactgenerationisvisible();

		// Click on Site Component Cart
		functions.click(driver, sitesComponentCart);

		// Click on Refresh Site list Button
		functions.click(driver, RefreshsitelistBtn);

		// Click on Dismiss Button
		if (Dismissbtn.size() >= 0 == true && Dismissbtn.get(0).isDisplayed() == true) {
			Dismissbtn.get(0).click();
		}

		// wait for Page Refresh and Sites to get Refreshed
		functions.AddsitesProgressTracker();

		// Click on Dismiss Button
		if (Dismissbtn.size() > 0 == true && Dismissbtn.get(1).isDisplayed() == true) {
			Dismissbtn.get(1).click();
		}

		// Refresh the DSP Page
		driver.navigate().refresh();

		// wait for Page Refresh and Sites to get Refreshed
		functions.mediumWait();

	}

	/*
	 * Add sites to Protected Class opportunity Using Excel File.
	 */

	public String AddSitestotheProtectedOpty(String siteid) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		try {
			if (AddCustomerbanner.isDisplayed() == true) {
				System.out.println("Customer issue");
			}
		} catch (Exception n) {

			try {
				if (CreateCustomerbanner.isDisplayed() == true) {
					System.out.println("Customer issue");
				}
			} catch (Exception n1) {

				// Click on Site Component Cart
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
				functions.click(driver, sitesComponentCart);

				// Open modal to add sites
				functions.click(driver, openAddSitesModalBtn);

				// Add sites to opportunity text area
				functions.click(driver, sitesTextArea);
				functions.setText(driver, sitesTextArea, siteid);

				// Add sites to opportunity
				functions.click(driver, addSitesBtn);
				functions.click(driver, submitSitesBtn);

				// Wait for add sites modal to disappear, and site tracked modal to appear
				functions.midintermediatewait();
				WebDriverWait wait10 = new WebDriverWait(driver, 600);
				wait10.until(
						ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

				// functions.dealconversion1();
			}
		}
		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}

	/*
	 * Add sites to opportunity for Aggregate Customer Protected Class.
	 */

	public String AddSitestotheOptyforAggregateProtectedclass(String customername1, String customername2, String site1,
			String site2) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart,
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Wait for Customer dropdown to Appear
		functions.shortWait();

		// Select Aggregate Customers from the Customer Dropdown
		functions.click(driver, CustomerDropdown);
		functions.selectDropdownByVisibleText(driver, CustomerDropdown, customername1);

		// Add sites to opportunity text area

		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, site1);

		// Click on AddtoQueue Button
		functions.click(driver, AddtoQueueBtn);

		// Wait for Confirm Sites tracker to Appear
		functions.shortWait();

		// Click on COnfirm Sites Button
		functions.click(driver, ConfirmSitesBtn);

		// Select Aggregate Customers from the Customer Dropdown
		functions.click(driver, CustomerDropdown);
		functions.selectDropdownByVisibleText(driver, CustomerDropdown, customername2);

		// Add sites to opportunity text area

		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, site2);

		// Click on AddtoQueue Button
		functions.click(driver, AddtoQueueBtn);

		// Wait for Confirm Sites tracker to Appear
		functions.shortWait();
		// Click on COnfirm Sites Button
		functions.click(driver, ConfirmSitesBtn);

		// Add sites to opportunity
		functions.click(driver, addSitesBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait1 = new WebDriverWait(driver, 230);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.AggregateSitesProgress();

		// Storing and Returning the text into a String
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
	}

	/*
	 * Add sites to Protected Class opportunity Using XML File.
	 */

	public String AddSitestotheProtectedOptyXML(String Sites) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Add sites to opportunity text area
		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, Sites);

		// Add sites to opportunity
		functions.click(driver, addSitesBtn);
		functions.click(driver, submitSitesBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 300);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		// functions.dealconversion1();

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}

	// Add site bill copy
	public String AddSitesbillcopy(String siteid) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		functions.click(driver, Billcopypricing);

		functions.setText(driver, Billcopyentersite, prop.getProperty(siteid));
		functions.setText(driver, Startdate, "11/01/2021");
		functions.setText(driver, Enddate, "11/30/2021");
		functions.setText(driver, BilledKW, "50");
		functions.click(driver, Browsefile);

		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

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

		// Add sites to opportunity
		// functions.click(driver, addSitesBtn);
		functions.click(driver, submitBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.longWait();

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}

}
