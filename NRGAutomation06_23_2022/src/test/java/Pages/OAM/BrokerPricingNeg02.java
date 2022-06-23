package Pages.OAM;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.paulhammant.ngwebdriver.NgWebDriver;
import Pages.DSP.LandingPage;
import Pages.DSP.Putsbox;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class BrokerPricingNeg02 {
	private Base base;
	LandingPage DspLandingPage = new LandingPage(base);
	Putsbox putsbox = new Putsbox(base);
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	WebDriver driver;
	String Status;
	public BrokerPricingNeg02(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
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
	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	@FindBy(xpath = "//button[contains(text(), 'Clear Filters')]")
	WebElement clearFilterBtn;
	@FindBy(xpath = "//span[@class='icon icon-check brand-success align-middle ng-star-inserted']")
	WebElement ConfirmBtn;
	@FindBy(xpath = "//*[@class='dropdown']/div[@class='form-group customer-search mb-0 ng-tns-c1-1']")
	WebElement Thirdpartyplaceholder;
	@FindBy(xpath = "//p[@class='ng-tns-c1-1 blue']")
	WebElement Thirdpartycard;
	@FindAll(value = { @FindBy(xpath = "//span[@class='icon icon-caret']") })
	public List<WebElement> CustomerBtn;
	@FindBy(xpath = "//p[@class='ng-tns-c1-1 blue']")
	WebElement ThirdpartynameBTn;
	@FindBy(xpath = "//a[@class='dropdown-toggle ng-tns-c1-1']")
	WebElement DropdowntoggleOAM;
	@FindBy(xpath = "//a[contains(text(), 'Pricing')]")
	WebElement pricinglinkOAM;
	@FindBy(xpath = "//a[contains(text(), 'Contact Us')]")
	WebElement contactuslinkOAM;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator']") })
	public List<WebElement> TermsandconditionsCheckbox;
	@FindBy(xpath = "//div[@class='control__indicator']")
	WebElement TermsandconditionsCheckbox1;
	@FindBy(xpath = "//button[contains(text(), 'Continue')]")
	WebElement ContinueButtonOAM;
	@FindBy(id = "embedded-app-container")
	WebElement shadowelement;
	@FindBy(css = ".btn btn-primary create-quote")
	WebElement CreateNewQuote;
	@FindBy(xpath = "//input[@class='form-control ng-valid ng-dirty ng-touched']")
	WebElement customernamefield;
	@FindBy(xpath = "//div[contains(text(),'Add Additional Customers')]")
	WebElement AddadditionalcustomerBTn;
	@FindBy(xpath = "//p[@class='dropdown-select name-styling']")
	WebElement customerFirstcard;
	@FindBy(xpath = "//button[@class='btn btn-primary p-0 mr-5 ng-star-inserted']")
	WebElement SelectHUfileBTn;
	@FindBy(css = "btn btn-primary mb-3 ng-star-inserted")
	WebElement ContinuetoAddsites;
	@FindBy(xpath = "//button[contains(text(), ' Validate Sites')]")
	WebElement Validatesites;
	@FindBy(xpath = "//button[contains(text(), ' Continue to Pricing')]")
	WebElement continuetopricing;
	@FindBy(xpath = "//button[@id='details-button']")
	WebElement AdvancedButton;
	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement proceedlink;
	@FindBy(xpath = "//button[@class='btn btn-primary p-0 mr-5 ng-star-inserted']")
	WebElement fileupload;
	@FindBy(xpath = "//input[@placeholder='Search by ID or name...']")
	WebElement ele;
	@FindBy(xpath = "//div[@id='navbar-2']")
	WebElement adk;
	@FindBy(xpath = "//span[@class='icon icon-caret']")
	WebElement logdropdown;
	@FindBy(xpath = "//*[@id=\"brand-navigation\"]/ul/li[2]/ul/li[2]/a")
	WebElement logout;
	@FindBy(xpath = "//a[@id='logAgain']")
	WebElement login;
	@FindBy(xpath = "//input[@id='user']")
	WebElement OAMEmail;
	@FindBy(xpath = "//input[@id='password']")
	WebElement OAMPassword;
	@FindBy(xpath = "//a[@id='logAgain']")
	WebElement OAMLoginButton1;
	@FindBy(xpath = "//ngb-alert[@class='alert alert-danger confirm-sites-alert alert-warning']")
	WebElement InvalidSitesMessage;
	@FindBy(xpath = "//a[@id='signin']")
	WebElement OAMLoginButton;
	WebElement SelectedAddressBtn2;
	/*
	 * Create New Quote
	 */

	public String CreateNewOpportunity() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Clicking on create new Quote
		String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quotes > div.content > div:nth-child(1) > div > div > a\")";
		WebElement createquote = (WebElement) js.executeScript(roo14);

		
		try {
			if(createquote.isEnabled()) {
				functions.click(driver, createquote);
				functions.shortWait();
			 Status="Pass";
			}
			}
			catch(Exception e) {
			if(!createquote.isEnabled()) {

				 Status="Fail";
				}
			}
			
			return Status;
		
	}

	/*
	 * Add Aggregate Customer to the Opportunity
	 */

	public String AddAggregateCustomer() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Enter Customer Details
		// Enter Customer Name in Customer Field
		String roo15 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.mt-2.text-center > div.col-12.p-0.mb-4 > div > input\")";
		WebElement addcustomer = (WebElement) js.executeScript(roo15);
		functions.setText(driver, addcustomer, "Adams Grocery");
		functions.intermediatewait();

		// Click on Create New Button
		String roo16 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(1) > div.col-5.p-0 > a > span.cust-btn-txt\")";
		WebElement createnew = (WebElement) js.executeScript(roo16);

		functions.click(driver, createnew);
		functions.midintermediatewait();

		String roo17 = "return document.querySelector(\"body > modal-container > div > div > app-add-customer-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.btn-container.ng-star-inserted > button.btn.btn-primary\")";
		WebElement continu = (WebElement) js.executeScript(roo17);

		functions.click(driver, continu);
		functions.intermediatewait();

		// Enter Customer Name in Customer Field
		String roo18 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(1) > div:nth-child(2) > div > input\")";
		WebElement customername = (WebElement) js.executeScript(roo18);

		functions.setText(driver, customername, "SHAHIN GROUP,LLC");
		functions.minwait();

		// Enter CreditcheckAddress in Customer Field
		String roo19 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(2) > div > div > input\")";
		WebElement creditcheckaddress = (WebElement) js.executeScript(roo19);

		functions.setText(driver, creditcheckaddress, "10555 PEARLAND PKWY STE J");
		functions.minwait();
		// Enter City in the City Field
		String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(1) > div > input\")";
		WebElement city = (WebElement) js.executeScript(roo20);
		functions.setText(driver, city, "HOUSTON");
		functions.minwait();

		// Select TX from State Dropdown
		String roo21 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(2) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
		WebElement State = (WebElement) js.executeScript(roo21);
		functions.setText(driver, State, "TX");
		functions.vshortWait();
		State.sendKeys(Keys.ENTER);
		functions.vshortWait();

		// Enter Zipcode in the Zipcode Field
		String roo22 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(3) > div > input\")";
		WebElement zip = (WebElement) js.executeScript(roo22);
		functions.setText(driver, zip, "77089-2676");
		functions.minwait();

		// Enter Phone Number in the Phone Number Field
		String roo23 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(1) > div > input\")";
		WebElement phonenumber = (WebElement) js.executeScript(roo23);
		functions.setText(driver, phonenumber, "(281)685-7827");
		functions.minwait();

		// Select Apartment Buildings from the BusinessType
		String roo24 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
		WebElement Businesstype = (WebElement) js.executeScript(roo24);
		functions.setText(driver, Businesstype, "Apartment Buildings");
		functions.vshortWait();
		Businesstype.sendKeys(Keys.ENTER);
		functions.vshortWait();

		String roo25 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button.btn.btn-outline-primary.mr-3.mb-3.position-relative.ng-star-inserted > app-tooltip > span\")";
		WebElement AddAdditionalcustomer = (WebElement) js.executeScript(roo25);
		functions.click(driver, AddAdditionalcustomer);
		functions.intermediatewait();

		// Click on Selected Address Button
		String roo26 = "return document.querySelector(\"body > modal-container > div > div > app-address-validation-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.button-row.ng-star-inserted > div > div > button\")";
		WebElement SelectedAddressBtn = (WebElement) js.executeScript(roo26);
		functions.click(driver, SelectedAddressBtn);
		functions.mediumWait();

		try {

//			WebElement root4 = driver.findElement(By.tagName("app-modal"));
//			WebElement shadowDom4 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root4);
//
//			WebElement cancelBtn = shadowDom4
//					.findElement(By.cssSelector("div.app-root div[class^='modal-header'] button[aria-label='Close']"));
			String roo27 = "return document.querySelector(\"body > modal-container\")";
			WebElement cancelBtn = (WebElement) js.executeScript(roo27);
			functions.click(driver, cancelBtn);
			functions.shortWait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Enter Customer Details
		try {
			String roo28 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(1) > div:nth-child(2) > div > input\")";
			WebElement customername1 = (WebElement) js.executeScript(roo28);
			functions.setText(driver, customername1, "Test");
			functions.minwait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		try {
			String roo29 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(2) > div > div > input\")";
			WebElement creditcheckaddress1 = (WebElement) js.executeScript(roo29);

			functions.setText(driver, creditcheckaddress1, "12 Greenway plaza");
			functions.minwait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		try {
			String roo31 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(1) > div > input\")";
			WebElement city1 = (WebElement) js.executeScript(roo31);
			functions.setText(driver, city1, "HOUSTON");
			functions.minwait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		try {
			String roo32 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(2) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
			WebElement State1 = (WebElement) js.executeScript(roo32);
			functions.setText(driver, State1, "TX");
			functions.vshortWait();
			State1.sendKeys(Keys.ENTER);
			functions.vshortWait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		try {
			String roo33 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(3) > div:nth-child(3) > div > input\")";
			WebElement zip1 = (WebElement) js.executeScript(roo33);
			functions.setText(driver, zip1, "77046");
			functions.minwait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		try {
			String roo34 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(1) > div > input\")";
			WebElement phonenumber1 = (WebElement) js.executeScript(roo34);
			functions.setText(driver, phonenumber1, "(281)685-7927");
			functions.minwait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
		try {
			String roo35 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > form > div:nth-child(4) > div:nth-child(3) > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
			WebElement Businesstype2 = (WebElement) js.executeScript(roo35);
			functions.setText(driver, Businesstype2, "Apartment Buildings");
			functions.vshortWait();
			Businesstype2.sendKeys(Keys.ENTER);
			functions.vshortWait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		try {
			String roo36 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button.btn.btn-primary.mb-3.ng-star-inserted\")";
			WebElement continuetoaddsitesbtn = (WebElement) js.executeScript(roo36);
			functions.click(driver, continuetoaddsitesbtn);
			functions.intermediatewait();

		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		try {

			String roo37 = "return document.querySelector(\"body > modal-container > div > div > app-address-validation-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.button-row.ng-star-inserted > div > div > button\")";
			WebElement SelectedAddressBtn2 = (WebElement) js.executeScript(roo37);
			functions.click(driver, SelectedAddressBtn2);
			functions.mediumWait();
			
			 Status="Pass";
		} catch (StaleElementReferenceException e) {
			e.getMessage();
			if(!SelectedAddressBtn2.isEnabled()) {

				 Status="Fail";
				}
			}
		
		return Status;
		}



	/*
	 * Add Sites to the Aggregate Customer
	 */
	public void AddsitestotheOpportunity() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// click on AddSitelistBTn
		String roo27 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(4) > span\")";
		WebElement AddSitelistBTn = (WebElement) js.executeScript(roo27);
		functions.click(driver, AddSitelistBTn);
		functions.shortWait();

		// entering sites values

		// converting integer to string by calling valueOf() method on String class

		String str = String.valueOf("10443720008503983");
		String str1 = String.valueOf("10032789430651841");

		Actions action = new Actions(driver);

		String roo28 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > form > div.row.pb-3 > div > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
		WebElement customerDropdown = (WebElement) js.executeScript(roo28);
		functions.click(driver, customerDropdown);
		functions.setText(driver, customerDropdown, "SHAHIN GROUP,LLC");
		functions.shortWait();

		customerDropdown.sendKeys(Keys.ENTER);
		functions.vshortWait();

		String roo29 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#esids\")";
		WebElement sitesfield = (WebElement) js.executeScript(roo29);
		functions.setText(driver, sitesfield, str);
		functions.shortWait();

		String roo30 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div:nth-child(2) > div > button\")";
		WebElement AddtoQueue = (WebElement) js.executeScript(roo30);
		functions.click(driver, AddtoQueue);
		functions.shortWait();

//		WebElement customerDropdown1 = shadowDom6.findElement(By.cssSelector(
//				"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > form > div.row.pb-3 > div > app-dropdown > div > div.row > div.col-9.pr-0 > input"));
//		functions.click(driver, customerDropdown1);
//		WebElement customerDropdown2 = shadowDom6.findElement(By.cssSelector(
//				"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > form > div.row.pb-3 > div > app-dropdown > div > div.dropdown-menu"));
		customerDropdown.click();
		functions.setText(driver, customerDropdown, "Test");
		customerDropdown.sendKeys(Keys.DOWN);
		functions.vshortWait();
//		action.click(customerDropdown2).build().perform();
//		functions.vshortWait();
		customerDropdown.sendKeys(Keys.ENTER);

		String roo31 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#esids\")";
		WebElement sitesfield1 = (WebElement) js.executeScript(roo31);
		functions.setText(driver, sitesfield1, str1);
		functions.intermediatewait();

		String roo32 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div:nth-child(2) > div > button\")";
		WebElement AddtoQueue1 = (WebElement) js.executeScript(roo32);
		functions.click(driver, AddtoQueue1);
		functions.intermediatewait();

		// click on add sites

//		WebElement root7 = driver.findElement(By.tagName("app-modal"));
//		WebElement shadowDom7 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root7);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String roo33 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div:nth-child(4) > div.col-lg-6.col-md-12.mt-4 > button\")";
		WebElement addsitesBtn = (WebElement) js.executeScript(roo33);
		js.executeScript("arguments[0].scrollIntoView();", addsitesBtn);
		functions.click(driver, addsitesBtn);
		functions.intermediatewait();

	}

	/*
	 * Send Email to Aggregate Customers
	 */
	public String SendEmailtoCustomer() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String roo33 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"#customer-email\")";
		WebElement  customerEmail1 = (WebElement) js.executeScript(roo33);
		functions.setText(driver, customerEmail1, "sridhar.dhusa@nrg.com");
		functions.intermediatewait();
		customerEmail1.sendKeys(Keys.TAB);
		functions.shortWait();

		customerEmail1.sendKeys("sridhar.dhusa@nrg.com");
		//#customer-email1
//		String roo34 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"#customer-email\")";
//		WebElement  customerEmail2 = (WebElement) js.executeScript(roo34);
//		functions.setText(driver, customerEmail2, "sridhar.dhusa@nrg.com");
		functions.intermediatewait();
		//#customer-email2
		String roo35 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > div:nth-child(2) > button\")";
		WebElement  SendLOABtn = (WebElement) js.executeScript(roo35);
		try {
		if(SendLOABtn.isEnabled()) {
		functions.click(driver, SendLOABtn);
		functions.intermediatewait();
		 Status="Pass";
		}
		}
		catch(Exception e) {
	    Status="Fail";
		}
		return Status;
		}
	}

