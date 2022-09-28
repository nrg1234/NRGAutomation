package Pages.OAM;

import java.util.List;
import java.util.Properties;
import org.testng.Assert;
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

public class BrokerPricingNeg01 {
	private Base base;
	LandingPage DspLandingPage = new LandingPage(base);
	Putsbox putsbox = new Putsbox(base);
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	NgWebDriver ngWebDriver;
	JavascriptExecutor jsDriver;
	WebDriver driver;

	public BrokerPricingNeg01(Base base) {
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
	String Status;
	/*
	 * Selecting third party partner
	 */

	public String selectAggregatorThirdParty(String Thirdparty) throws Throwable {

		// Wait for Sometime
		functions.intermediatewait();

		// Click on Customer Button
		CustomerBtn.get(1).click();

		
		
		try {
			if(ele.isEnabled()) {
				// Enter Third Party in the Place holder
				functions.setText(driver, ele, Thirdparty);
				ele.sendKeys(Keys.RETURN);

				// Wait for Sometime
				functions.intermediatewait();
			 Status="Pass";
			}
			}
			catch(Exception e) {
//			if(!ele.isEnabled()) {

				 Status="Fail";
		//		}
			}
			
			return Status;
	}

	/*
	 * Navigates the User to Enrollment Page
	 */

	public String navigatingToEnrollmentPage() throws Throwable {
		
		try {
			if(pricinglinkOAM.isEnabled()) {
			functions.click(driver, pricinglinkOAM);
			functions.intermediatewait();
			 Status="Pass";
			}
			}
			catch(Exception e) {
			if(!pricinglinkOAM.isEnabled()) {

				 Status="Fail";
				}
			}
			
			return Status;

		

	}

	public String ValidatingPricinglink() {
		try {
		if (pricinglinkOAM.isEnabled()) {
			System.out.println("pricing link is displayed");
			 Status="Pass";
		}
		}
		catch(Exception e) {
		if (!pricinglinkOAM.isEnabled()) {
			System.out.println("pricing link is displayed");
			Status="Fail";
		}
		}

return Status;
	}

	public boolean ValidatingPricinglink1() throws Throwable {

		if (contactuslinkOAM.isEnabled()) {
			System.out.println("pricing link is not displayed");
			return true;
		}
		return true;
	}

	/*
	 * Navigates the User to log out Page
	 */
	public void logout() throws Throwable {

		// span[@class='icon icon-caret']
		functions.click(driver, logdropdown);

		// Wait for Sometime
		functions.shortWait();

		functions.click(driver, logout);

		// Wait for Sometime
		functions.shortWait();
	}

	/*
	 * Navigates the User to login Page
	 */

	public void Loginagain(String Username, String Password) {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on OAM Login Button
		functions.click(driver, OAMLoginButton1);

		// Enter Email in Email Field
		functions.setText(driver, OAMEmail, Username);

		// Enter Password in Email Field
		functions.setText(driver, OAMPassword, Password);

		// Click on OAM Login Button
		functions.click(driver, OAMLoginButton);
	}

	/*
	 * Terminates the Driver
	 */
	public void Close() throws Throwable {

		driver.close();
	}

	/*
	 * Create New Quote
	 */
	public String AddnewOpportunity() throws Throwable {

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
	 * Add Customer to the Opportunity
	 */
	public String AddcustomertoOpportunity() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

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

		// Click on Continue Button
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

		// Click on Continue to Add Sites Button
		String roo25 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button.btn.btn-primary.mb-3.ng-star-inserted\")";
		WebElement continuetoaddsitesbtn = (WebElement) js.executeScript(roo25);
		functions.click(driver, continuetoaddsitesbtn);
		functions.midintermediatewait();

//		WebElement root3 = driver.findElement(By.tagName("app-modal"));
//		WebElement shadowDom3 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root3);

		// Click on Selected Address Button
		String roo26 = "return document.querySelector(\"body > modal-container > div > div > app-address-validation-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.button-row.ng-star-inserted > div > div > button\")";
		WebElement SelectedAddressBtn = (WebElement) js.executeScript(roo26);
		
		try {
			if(SelectedAddressBtn.isEnabled()) {
				functions.click(driver, SelectedAddressBtn);
				functions.mediumWait();
			 Status="Pass";
			}
			}
			catch(Exception e) {
			if(!SelectedAddressBtn.isEnabled()) {

				 Status="Fail";
				}
			}
			
			return Status;
		

	}

	/*
	 * Add Sites to the Opportunity
	 */

	public String AddsitestoOpportunity() throws Throwable {
functions.longWait();
functions.longWait();
functions.longWait();
//		WebElement root = driver.findElement(By.tagName("app-broker-pricing"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);

		// click on AddSitelistBTn
		String roo27 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(4) > span\")";
		WebElement AddSitelistBTn = (WebElement) js.executeScript(roo27);
		functions.click(driver, AddSitelistBTn);
		functions.shortWait();

		// entering sites values

		// converting integer to string by calling valueOf() method on String class
		String roo28 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#esids\")";
		WebElement sitesfield = (WebElement) js.executeScript(roo28);
		String str = String.valueOf("10443720008503983");
		functions.setText(driver, sitesfield, str);
		functions.shortWait();

		// click on add sites
		String roo29 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div > div.col-lg-6.col-md-12.mt-4 > button\")";
		WebElement addsitesBtn = (WebElement) js.executeScript(roo29);
		functions.click(driver, addsitesBtn);
		functions.mediumWait();

		// Generating Put Box Email
//		Map<String, String> mail = putsbox.generateNewPutsBoxEmail(Context.PutsURL);
//		String custemail = mail.get("email");
//		String strputsBoxURL = mail.get("emailURL");
		try {
			String roo30 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"#customer-email\")";
			WebElement customerEmail1 = (WebElement) js.executeScript(roo30);
			functions.setText(driver, customerEmail1, "sridhar.dhusa@nrg.com");
			functions.intermediatewait();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
//		// Navigate to putsbox
//		// opening the new tab
//		((JavascriptExecutor) driver).executeScript("window.open('" + strputsBoxURL + "');");
//		// getting all the handles currently available
//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs2.get(1));
//		putsbox.validateEmailinPutsbox();
		String roo31 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > div:nth-child(2) > button\")";
		WebElement SendLOABtn = (WebElement) js.executeScript(roo31);
		functions.click(driver, SendLOABtn);
		functions.intermediatewait();

		String roo32 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.header > div.float-left > div > form > b > div > span:nth-child(3)\")";
		WebElement Optyname = (WebElement) js.executeScript(roo32);
		String Opty = functions.getText(driver, Optyname);
		functions.intermediatewait();

		return Opty;
	}

	/*
	 * Navigates the User to DSP HomePage
	 */

	public String Navigatetodsp(String Opty) throws Throwable {

		// Navigate to DSP
		DspLandingPage.launchurl();

		// Validate Title
		DspLandingPage.TitleValidation();

		// Click on All Opportunities Button
		DspLandingPage.AllOpportunities();

		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity ID in Search Place Holder
		functions.setText(driver, Searchplaceholder, Opty);

		// Wait for Sometime
		functions.shortWait();

		//// code for copy paste
		Actions actions = new Actions(driver);
		// Select the Current Address using CTRL + A
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		// Wait for Sometime
		functions.vshortWait();

		// Copy the Current Address using CTRL + C
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("x");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		// Wait for Sometime
		functions.vshortWait();
		// paste
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		// Wait for Sometime
		functions.intermediatewait();

		// Click on Opportunity Hyperlink
		driver.findElement(By.xpath("//a[contains(text(),'" + Opty + "')]")).click();

		// Wait for Sometime
		functions.intermediatewait();
		
		String Status="Pass";
		return Status;

	}

	/*
	 * Add Non-Ercot Sites to the Sitelist
	 */
	public String AddNonErcotSites() throws Throwable {

		// Click on Sites Component Cart
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		functions.click(driver, openAddSitesModalBtn);

		// Add sites to opportunity text area
		functions.click(driver, sitesTextArea);
		functions.setText(driver, sitesTextArea, "1383875485758585858585757");

		
		try {
		if(addSitesBtn.isEnabled()) {
			// Add sites to opportunity
			functions.click(driver, addSitesBtn);
		 Status="Pass";
		}
		}
		catch(Exception e) {
		if(!addSitesBtn.isEnabled()) {

			 Status="Fail";
			}
		}
		
		return Status;
	}

	/*
	 * Validate Error Message for Non-Ercot Sites
	 */
	public void ValidateNonErcotSites() throws Throwable {

		try {
			Assert.assertTrue(InvalidSitesMessage.isDisplayed());
		} catch (Exception e) {
			Assert.assertFalse(!InvalidSitesMessage.isDisplayed());
		}

	}

}
