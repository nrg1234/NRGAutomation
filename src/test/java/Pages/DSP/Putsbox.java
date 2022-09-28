package Pages.DSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import apphooks.Base;

public class Putsbox {

	WebDriver driver;

	public Putsbox(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	CommonFunctions functions = new CommonFunctions();

	@FindAll(value = { @FindBy(how = How.CSS, using = "tr") })
	private List<WebElement> mails;
	@FindBy(how = How.LINK_TEXT, using = "Inspect")
	private WebElement refresh;
	@FindBy(how = How.CSS, using = "a[href*='clear']")
	private WebElement clear;
	@FindBy(how = How.CSS, using = "a[title*='Customer Consent']")
	private WebElement reviewAndConfirm;
	@FindAll(value = { @FindBy(how = How.CSS, using = "td.text-pad") })
	private List<WebElement> contents;
	@FindBy(how = How.CSS, using = "//strong[contains(text(),'Enrollment ID')] ")
	private WebElement enrollmentID;
	@FindBy(how = How.CSS, using = "body")
	private WebElement body;
	@FindBy(how = How.ID, using = "Service_Details")
	private WebElement Service_Details;
	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Confirmation Number')]")
	private WebElement confirmationNumber;
	@FindBy(how = How.CSS, using = "label[for='textMessageOptIn']")
	private WebElement optInCheckBox;
	@FindBy(how = How.ID, using = "textMessageOptInPhoneNumber")
	private WebElement optInPhoneNo;
	@FindBy(how = How.ID, using = "account")
	private WebElement accountID;
	@FindBy(how = How.ID, using = "username")
	private WebElement userName;
	@FindBy(how = How.CSS, using = "input[id='password']")
	private WebElement password;
	@FindBy(how = How.ID, using = "continue_button")
	private WebElement continueBtnpwd;
	@FindBy(how = How.ID, using = "signin_button")
	private WebElement signInBtn;
	@FindBy(how = How.ID, using = "search-box-input")
	private WebElement searchBox;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'search-box-input')]//span[contains(text(),'Simple Email')]")
	private WebElement clickSimpleEmailService;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Email Addresses')]")
	private WebElement emailAdressesLink;
	@FindBy(how = How.ID, using = "gwt-debug-verifyNewEmail")
	private WebElement verifyNewEmailAddressBtn;
	@FindBy(how = How.ID, using = "gwt-debug-verifySenderEmailBox")
	private WebElement searchEmail;
	@FindBy(how = How.ID, using = "gwt-debug-verifySenderSubmitButton")
	private WebElement verifyThisEmailAddressBtn;
	@FindBy(how = How.ID, using = "gwt-debug-verifySenderConfirmationCloseButton")
	private WebElement verificationCloseBtn;
	@FindBy(how = How.XPATH, using = "//pre")
	private WebElement gettingAWSURL;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Congratulations!')]")
	private WebElement awsVerificationSuccess;
	@FindBy(how = How.CSS, using = "a[ng-click='updatePassword()']")
	private WebElement changePassword;
	@FindBy(how = How.CSS, using = "div[class='alert alert-success']")
	private WebElement passwordResetSuccessMsg;
	@FindBy(how = How.CSS, using = "button[ng-click='ok()']")
	private WebElement passwordResetSuccessMsgOk;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'GOT IT')]")
	private WebElement gotItBtn;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'THESE ARE CORRECT')]")
	private WebElement theseAreCorrectBtn;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'LOG IN')]")
	private WebElement readyToLoginBtn;
	@FindAll(value = { @FindBy(how = How.CSS, using = "td[style = 'padding:15px']") })
	private List<WebElement> contentMail;
	@FindAll(value = {
			@FindBy(how = How.CSS, using = "table[style = 'border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: inherit; width: 580px; background: #fff; margin: 0 auto; padding: 0;']") })
	private List<WebElement> contentMail1;
	@FindBy(how = How.CSS, using = "button.btn-large")
	private WebElement newBucket;
	@FindBy(how = How.ID, using = "putsbox-token-input")
	private WebElement newId;
	@FindAll(value = { @FindBy(how = How.NAME, using = "loginfmt") })
	private List<WebElement> cloudLogin;
	@FindBy(how = How.ID, using = "idSIButton9")
	private WebElement cloudNext;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),' REVIEW DOCUMENT ')]")
	private WebElement ReviewBtn;
	@FindBy(how = How.XPATH, using = "//label[@for='disclosureAccepted']")
	private WebElement DisclosureCheckbox;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	private WebElement ContinueBtn;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Required - LOAExpiration - Unlimited')]")
	private WebElement Unlimitedcheckbox;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Required - Data_Group_Selections - Summary_Billing_Data_Only')]")
	private WebElement Billingdatacheckbox;
	@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element  ']")
	private WebElement esiidfield;
	@FindBy(how = How.XPATH, using = "//div[@class='signature-tab-content tab-button-yellow v2']")
	private WebElement SignatureBtn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"adopt-dialog\"]/div/div[3]/button[1]")
	private WebElement AdoptandsignBTn;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Companyfield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Namefield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Addressfield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Titlefield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Cityfield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Statefield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Telephonefield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> Zipcodefield;
	@FindBy(how = How.XPATH, using = "//button[@id='action-bar-btn-finish']")
	private WebElement FinishBtn;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No Thanks')]")
	private WebElement NoThanksBtn;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Sign')]")
	private WebElement signBtnindocudign;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> namefield;
	@FindAll(value = {
			@FindBy(how = How.XPATH, using = "//input[@class='main-text-tab-input tab-form-element signing-required ']") })
	private List<WebElement> TitlefieldEnrollment;
	@FindBy(how = How.XPATH, using = "//input[@id='tab-form-element-e2d4761c-dc1f-46f0-ad79-c3e31d633202']")
	private WebElement Phonenumberfield;
	@FindBy(how = How.XPATH, using = "//label[@for='tab-form-element-2279c913-c67d-44f0-a100-913bc670a904']")
	private WebElement languageCheckbox;
	@FindAll(value = { @FindBy(how = How.XPATH, using = "//div[@class='initials-tab-content tab-button-yellow v2']") })
	private List<WebElement> InitialBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='signature-tab-content tab-button-yellow v2']")
	private WebElement SignBtn;
	@FindBy(how = How.XPATH, using = "//input[@id='tab-form-element-e73c4f3e-6fad-4f7e-af16-6d0cf5ef604f']")
	private WebElement FederalIDField;
	@FindBy(how = How.XPATH, using = "//input[@id='tab-form-element-b0c643fa-1ebb-4d92-b34d-2da40deba452']")
	private WebElement NameField;
	@FindBy(how = How.XPATH, using = "//input[@id='tab-form-element-97e17201-becf-4ddf-92c4-02c019591f96']")
	private WebElement TitleField;
	@FindBy(how = How.XPATH, using = "//input[@id='full-name']")
	private WebElement validatenamefield;
	//input[@id='full-name']
	///html[1]/body[1]/jhi-main[1]/div[1]/jhi-opportunity[1]/div[1]/jhi-contract[1]/div[8]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/jhi-main[1]/div[1]/jhi-opportunity[1]/div[1]/jhi-contract[1]/div[8]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]")
	private WebElement validatenamefielddsp;
	
	/*
	 * This Method is to Navigate to Putsbox Mail Box
	 * 
	 */
	public void navigateToPutsMailBox(String url) {
		driver.navigate().to(url);
	}

	/*
	 * This Method is to Navigate to DSP
	 * 
	 */
	public void navigateToDSP(String url) {
		driver.navigate().to(url);
	}

	/*
	 * This Method is for Explicit Wait
	 * 
	 */
	public boolean waitFor(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * This Method is for Explicit Wait
	 * 
	 */
	public boolean waitFor(List<WebElement> elements, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * This Method is for Switching the driver to New Window
	 * 
	 */
	public void switchToNewWindow() {

		// Switch to new window opened
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
	}

	/*
	 * This Method is for closing the driver
	 * 
	 */
	public void Closedriver() {

		driver.close();
	}

	/*
	 * This Method is to generate New Putsbox email
	 * 
	 */
	public Map<String, String> generateNewPutsBoxEmail(Context putsURL) {
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		@SuppressWarnings("deprecation")
		String email, emailId;
		Map<String, String> records = new HashMap<String, String>();
		if (Context.PutsURL == putsURL) {

			// opening the new tab
			((JavascriptExecutor) driver).executeScript("window.open('" + putsURL.toString() + "');");

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));

			if (cloudLogin.size() > 0) {
				waitFor(cloudLogin, 45);
				cloudLogin.get(0).sendKeys(prop.getProperty("customer-email"));
				waitFor(cloudNext, 45);
				cloudNext.click();
			}
			driver.navigate().refresh();
			waitFor(newBucket, 45);
			newBucket.click();
			waitFor(newId, 30);
			emailId = newId.getAttribute("data-bucket-token");
			email = newId.getAttribute("value");
			records.put("email", email);
			records.put("emailId", emailId);
			records.put("emailURL", driver.getCurrentUrl());
			driver.close();

			// switch to the parent window
			driver.switchTo().window(tabs2.get(0));
		} else {
			records.put("email", "WRONG URL");
		}
		return records;

	}

	/*
	 * This Method is to Validate Email in Putsbox
	 */
	public void validateEmailinPutsbox() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		int count = 0;
		String text;
		while (mails.size() == 0 && count < 75) {
			count++;
			refresh.click();
		}

		for (WebElement mail : mails) {
			try {
				if (mail.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

					//
					functions.shortWait();
				mail.findElement(By.xpath("//a[contains(text(),'HTML')]")).click();
				functions.shortWait();

				// switch to the New window
				switchToNewWindow();

				// Clicks on Review Button
				functions.click(driver, ReviewBtn);

				functions.intermediatewait();

				// Clicks on Disclosure Button
				functions.click(driver, DisclosureCheckbox);

				functions.shortWait();

				// Clicks on Continue Button
				functions.click(driver, ContinueBtn);

				functions.shortWait();

				// Clicks on UnlimitedCheckbox Button
				functions.click(driver, Unlimitedcheckbox);

				// Clicks on Billingdatacheckbox Button
				functions.click(driver, Billingdatacheckbox);

				// Clicks on ESIIDField
				functions.click(driver, esiidfield);

				// Passing ESIID Text in ESIID Field
				functions.setText(driver, esiidfield, prop.getProperty("site"));

				// Clicks on Signature Button
				functions.click(driver, SignatureBtn);
				
				
				//Validate correct name in the Full Name field
				String ValidateName=functions.getValue(driver,validatenamefield);
				System.out.println("value of Name field: "+ValidateName);

				
				
				
				// Clicks on AdoptandSign Button
				functions.click(driver, AdoptandsignBTn);

				// Wait for Sometime
				functions.shortWait();

				// Enter Company Name in Company Field
				Companyfield.get(1).sendKeys(prop.getProperty("Company"));

				// Enter Name in Name Field
				Namefield.get(2).sendKeys(prop.getProperty("Name"));

				// Enter Address in Address Field
				Addressfield.get(3).sendKeys(prop.getProperty("Address"));

				// Enter Title in Title Field
				Titlefield.get(4).sendKeys(prop.getProperty("Title"));

				// Enter City in Title Field
				Cityfield.get(5).sendKeys(prop.getProperty("City"));

				// Enter State in State Field
				Statefield.get(6).sendKeys(prop.getProperty("State"));

				// Enter Telephone Number in Telephone Field
				Telephonefield.get(7).sendKeys(prop.getProperty("Telephone"));

				// Enter Zipcode in Zipcode Field
				Zipcodefield.get(8).sendKeys(prop.getProperty("Zipcode"));

				// Wait for Sometime
				functions.intermediatewait();

				// Click on Finish Button
				functions.click(driver, FinishBtn);

				// Click on No Thanks Button
				functions.click(driver, NoThanksBtn);
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

		}

	}

	/*
	 * This Method is to Validate Email in Putsbox for New Single>50kwh
	 */
	public void validateSingleEnrollmentEmailinPutsbox() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		int count = 0;
		String text;
		try {
			while (mails.size() == 0 && count < 75) {

				count++;
				refresh.click();
			}
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		for (WebElement mail : mails) {
			try {
				if (mail.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

					// Wait for Sometime
					functions.shortWait();

				mail.findElement(By.xpath("//a[contains(text(),'HTML')]")).click();
				functions.shortWait();

				// Close the driver
				Closedriver();

				// switch driver to the New window
				switchToNewWindow();

				// Clicks on Review Button
				functions.click(driver, ReviewBtn);

				functions.intermediatewait();

				// Clicks on Disclosure Button
				functions.click(driver, DisclosureCheckbox);

				// Wait for Sometime
				functions.shortWait();

				// Clicks on Continue Button
				functions.click(driver, ContinueBtn);

				// Wait for Sometime
				functions.shortWait();

				// Click on Sign in Button
				functions.click(driver, signBtnindocudign);

				// Wait for Sometime
				functions.shortWait();

				// Click on Adopt Sign in Button
				functions.click(driver, AdoptandsignBTn);

				// Wait for Sometime
				functions.shortWait();

				// Enter Name in Name Field
				namefield.get(0).sendKeys(prop.getProperty("Name"));

				// Enter Title in Title Field
				TitlefieldEnrollment.get(1).sendKeys(prop.getProperty("Title"));

				// Wait for Sometime
				functions.intermediatewait();

				// Click on Finish Button
				functions.click(driver, FinishBtn);

				// Click on No Thanks Button
				functions.click(driver, NoThanksBtn);

				// Close the driver
				Closedriver();

				// switch driver to the parent window
				driver.switchTo().window(tabs2.get(0));

			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

		}
	}

	/*
	 * This Method is to Validate Email in Putsbox for New Aggregate>50kwh
	 */
	public void validateAggregateEnrollmentEmailinPutsbox() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		int count = 0;
		String text;
		try {
			while (mails.size() == 0 && count < 75) {

				count++;
				refresh.click();
			}
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		for (WebElement mail : mails) {
			try {
				if (mail.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

					// Wait for Sometime
					functions.shortWait();

				mail.findElement(By.xpath("//a[contains(text(),'HTML')]")).click();
				functions.shortWait();

				// Close the driver
				Closedriver();

				// switch driver to the New window
				switchToNewWindow();

				// Clicks on Review Button
				functions.click(driver, ReviewBtn);

				functions.intermediatewait();

				// Clicks on Disclosure Button
				functions.click(driver, DisclosureCheckbox);

				// Wait for Sometime
				functions.shortWait();

				// Clicks on Continue Button
				functions.click(driver, ContinueBtn);

				// Wait for Sometime
				functions.shortWait();

				// Click on Sign in Button
				functions.click(driver, signBtnindocudign);

				// Wait for Sometime
				functions.shortWait();

				// Click on Adopt Sign in Button
				functions.click(driver, AdoptandsignBTn);

				// Wait for Sometime
				functions.shortWait();

				// Enter Name in Name Field
				namefield.get(0).sendKeys(prop.getProperty("Name"));

				// Enter Title in Title Field
				TitlefieldEnrollment.get(1).sendKeys(prop.getProperty("Title"));

				// Wait for Sometime
				functions.intermediatewait();

				// Click on Finish Button
				functions.click(driver, FinishBtn);

				// Click on No Thanks Button
				functions.click(driver, NoThanksBtn);

				// Close the driver
				Closedriver();
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

			// switch driver to the parent window
			driver.switchTo().window(tabs2.get(1));

			try {
				while (mails.size() == 0 && count < 75) {

					count++;
					refresh.click();
				}
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

			for (WebElement email : mails) {
				try {
					if (email.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

						// Wait for Sometime
						functions.shortWait();

					List<WebElement> listOfElements = email.findElements(By.xpath("//a[contains(text(),'HTML')]"));

					listOfElements.get(2).click();

					functions.shortWait();

					// Close the driver
					Closedriver();

					// switch driver to the New window
					switchToNewWindow();

					// Clicks on Review Button
					functions.click(driver, ReviewBtn);

					functions.intermediatewait();

					// Clicks on Disclosure Button
					functions.click(driver, DisclosureCheckbox);

					// Wait for Sometime
					functions.shortWait();

					// Clicks on Continue Button
					functions.click(driver, ContinueBtn);

					// Wait for Sometime
					functions.shortWait();

					// Click on Sign in Button
					functions.click(driver, signBtnindocudign);

					// Wait for Sometime
					functions.shortWait();

					// Click on Adopt Sign in Button
					functions.click(driver, AdoptandsignBTn);

					// Wait for Sometime
					functions.shortWait();

					// Enter Name in Name Field
					namefield.get(0).sendKeys(prop.getProperty("Name"));

					// Enter Title in Title Field
					TitlefieldEnrollment.get(1).sendKeys(prop.getProperty("Title"));

					// Wait for Sometime
					functions.intermediatewait();

					// Click on Finish Button
					functions.click(driver, FinishBtn);

					// Click on No Thanks Button
					functions.click(driver, NoThanksBtn);

					// Close the driver
					Closedriver();

					// switch driver to the parent window
					driver.switchTo().window(tabs2.get(0));

				} catch (StaleElementReferenceException e) {
					e.getMessage();
				}
			}
		}

	}

	/*
	 * This Method is to Validate Email in Putsbox for New Single<50kwh
	 */
	public void validateEmailinPutsboxforlessthan50() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		int count = 0;
		String text;
		try {
			while (mails.size() == 0 && count < 75) {

				count++;
				refresh.click();
			}
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		for (WebElement mail : mails) {
			try {
				if (mail.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

					// Wait for Sometime
					functions.shortWait();

				mail.findElement(By.xpath("//a[contains(text(),'HTML')]")).click();
				functions.shortWait();

				// Close the driver
				Closedriver();

				// switch driver to the New window
				switchToNewWindow();

				// Clicks on Review Button
				functions.click(driver, ReviewBtn);

				functions.intermediatewait();

				// Clicks on Disclosure Button
				functions.click(driver, DisclosureCheckbox);

				// Wait for Sometime
				functions.shortWait();

				// Clicks on Continue Button
				functions.click(driver, ContinueBtn);

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, Phonenumberfield, prop.getProperty("Telephone"));

				// Wait for Sometime
				functions.shortWait();

				functions.click(driver, languageCheckbox);

				// Wait for Sometime
				functions.shortWait();

				InitialBtn.get(0).click();

				// Wait for Sometime
				functions.shortWait();

				// Click on Adopt Sign in Button
				functions.click(driver, AdoptandsignBTn);

				// Wait for Sometime
				functions.shortWait();

				functions.click(driver, SignBtn);

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, FederalIDField, "test");

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, NameField, "test");

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, TitleField, "tester");

				// Wait for Sometime
				functions.shortWait();

				InitialBtn.get(1).click();

				// Wait for Sometime
				functions.shortWait();

				// Click on Finish Button
				functions.click(driver, FinishBtn);

				// Click on No Thanks Button
				functions.click(driver, NoThanksBtn);

				// Close the driver
				Closedriver();

				// switch driver to the parent window
				driver.switchTo().window(tabs2.get(0));

			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

		}
	}

	/*
	 * This Method is to Validate Email in Putsbox for New Aggregate<50kwh
	 */
	public void validateEmailinPutsboxforAggregatelessthan50() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		int count = 0;
		String text;
		try {
			while (mails.size() == 0 && count < 75) {

				count++;
				refresh.click();
			}
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		for (WebElement mail : mails) {
			try {
				if (mail.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

					// Wait for Sometime
					functions.shortWait();

				mail.findElement(By.xpath("//a[contains(text(),'HTML')]")).click();
				functions.shortWait();

				// Close the driver
				Closedriver();

				// switch driver to the New window
				switchToNewWindow();

				// Clicks on Review Button
				functions.click(driver, ReviewBtn);

				functions.intermediatewait();

				// Clicks on Disclosure Button
				functions.click(driver, DisclosureCheckbox);

				// Wait for Sometime
				functions.shortWait();

				// Clicks on Continue Button
				functions.click(driver, ContinueBtn);

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, Phonenumberfield, prop.getProperty("Telephone"));

				// Wait for Sometime
				functions.shortWait();

				functions.click(driver, languageCheckbox);

				// Wait for Sometime
				functions.shortWait();

				InitialBtn.get(0).click();

				// Wait for Sometime
				functions.shortWait();

				// Click on Adopt Sign in Button
				functions.click(driver, AdoptandsignBTn);

				// Wait for Sometime
				functions.shortWait();

				functions.click(driver, SignBtn);

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, FederalIDField, "test");

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, NameField, "test");

				// Wait for Sometime
				functions.shortWait();

				functions.setText(driver, TitleField, "tester");

				// Wait for Sometime
				functions.shortWait();

				InitialBtn.get(1).click();

				// Wait for Sometime
				functions.shortWait();

				// Click on Finish Button
				functions.click(driver, FinishBtn);

				// Click on No Thanks Button
				functions.click(driver, NoThanksBtn);

				// Close the driver
				Closedriver();
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

			// switch driver to the parent window
			driver.switchTo().window(tabs2.get(1));

			try {
				while (mails.size() == 0 && count < 75) {

					count++;
					refresh.click();
				}
			} catch (StaleElementReferenceException e) {
				e.getMessage();
			}

			for (WebElement email : mails) {
				try {
					if (email.findElements(By.xpath("//*[contains(text(),'NRG Energy LOA')]")).size() > 0)

						// Wait for Sometime
						functions.shortWait();

					List<WebElement> listOfElements = email.findElements(By.xpath("//a[contains(text(),'HTML')]"));

					listOfElements.get(2).click();

					functions.shortWait();

					// Close the driver
					Closedriver();

					// switch driver to the New window
					switchToNewWindow();

					// Clicks on Review Button
					functions.click(driver, ReviewBtn);

					functions.intermediatewait();

					// Clicks on Disclosure Button
					functions.click(driver, DisclosureCheckbox);

					// Wait for Sometime
					functions.shortWait();

					// Clicks on Continue Button
					functions.click(driver, ContinueBtn);

					// Wait for Sometime
					functions.shortWait();

					functions.setText(driver, Phonenumberfield, prop.getProperty("Telephone"));

					// Wait for Sometime
					functions.shortWait();

					functions.click(driver, languageCheckbox);

					// Wait for Sometime
					functions.shortWait();

					InitialBtn.get(0).click();

					// Wait for Sometime
					functions.shortWait();

					// Click on Adopt Sign in Button
					functions.click(driver, AdoptandsignBTn);

					// Wait for Sometime
					functions.shortWait();

					functions.click(driver, SignBtn);

					// Wait for Sometime
					functions.shortWait();

					functions.setText(driver, FederalIDField, "test");

					// Wait for Sometime
					functions.shortWait();

					functions.setText(driver, NameField, "test");

					// Wait for Sometime
					functions.shortWait();

					functions.setText(driver, TitleField, "tester");

					// Wait for Sometime
					functions.shortWait();

					InitialBtn.get(1).click();

					// Wait for Sometime
					functions.shortWait();

					// Click on Finish Button
					functions.click(driver, FinishBtn);

					// Click on No Thanks Button
					functions.click(driver, NoThanksBtn);

					// Close the driver
					Closedriver();

					// switch driver to the parent window
					driver.switchTo().window(tabs2.get(0));

				} catch (StaleElementReferenceException e) {
					e.getMessage();
				}

			}
		}
	}
}
