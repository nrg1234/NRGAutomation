package Pages.DSP;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import apphooks.Base;

public class BrokerUiNormalDeal {
	String Status;
	CommonFunctions functions = new CommonFunctions();
	// Locators
	@FindBy(xpath = "//button[@id='bp-view-switch']")
	WebElement Brokerswitch;

	@FindBy(xpath = "//span[@class='mdi mdi-24px mdi-chevron-down']")
	WebElement Seedetailsbtn;

	@FindBy(xpath = "//button[@id='bp-visible-switch']")
	WebElement brokervisible;
	//button[@id='bp-visible-switch']
	//button[contains(text(),' Continue ')]
	@FindBy(xpath = "//button[contains(text(),' Continue ')]")
	WebElement continuebtn;

	WebDriver driver;

	public BrokerUiNormalDeal(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	public String changetobrokerview() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-24px mdi-chevron-down']")));
		functions.click(driver, Seedetailsbtn);
		functions.intermediatewait();
		//click on broker visible
		functions.click(driver, brokervisible);
		functions.shortWait();
		//
		functions.click(driver,  continuebtn);
		functions.shortWait();
		try {
			if(Brokerswitch.isEnabled()) {
		functions.click(driver, Brokerswitch);
		functions.longWait();
		
		 Status="Pass";
			}
		}
		catch(Exception e) {
			 Status="Fail";
		}
		return Status;
	}
		

	public String continuetopricing() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		WebElement root = driver.findElement(By.tagName("app-broker-pricing"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//	WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);

		//Click on Continue to Add Sites Button
		String roo4 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-customers > div.row.mt-4 > div > button.btn.btn-primary.mb-3\")";
		WebElement continuetoaddsitesbtn = (WebElement) js.executeScript(roo4);
		functions.click(driver, continuetoaddsitesbtn);
		functions.mediumWait();
		// Click on validate sites

		String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
		WebElement  validatebtn = (WebElement) js.executeScript(roo12);
		functions.click(driver, validatebtn);
		//	functions.longWait();
		//String oportyid = opportunityIDText.getText();

		functions.maxWait();


		// Click on continue to pricing
		String roo13 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")";
		WebElement  continuepricingbtn = (WebElement) js.executeScript(roo13);

		functions.click(driver, continuepricingbtn);
		functions.mediumWait();

		//Select Contract and select from dropdown Recs and base charge
		//select rec%
		String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#dropdownMenu1\")";
		WebElement recvalue = (WebElement) js.executeScript(roo14);
		functions.selectDropdownByVisibleText(driver,recvalue,"25");
functions.shortWait();
//enter broker fee
		String roo15 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-pricing > form > div.row.quote-row.justify-content-end.flex-nowrap > div.col-auto.label-col.border-right > div.row.justify-content-end.broker-fee-input-div > input\")";
		WebElement brokerfee = (WebElement) js.executeScript(roo15);
		functions.setText(driver,brokerfee,"5");
		functions.shortWait();
		//calculatebtn
		String roo16 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-pricing > form > div.row.justify-content-end.calc-and-proceed-row > button.btn.caclulate-button.mx-3.btn-primary\")";
		WebElement calculatebtn = (WebElement) js.executeScript(roo16);
		functions.click(driver,calculatebtn);
		functions.midintermediatewait();
		//select product
		String roo17 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#QuoteCard > div.card-footer > div > button > span\")";
		WebElement selectbtn = (WebElement) js.executeScript(roo17);
		functions.click(driver,selectbtn);
		functions.intermediatewait();
		//proceed tocontract and billing
		String roo18 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-pricing > form > div.row.justify-content-end.calc-and-proceed-row > button.btn.btn-primary.proceed-button.mx-3\")";
		WebElement contractbillingbtn = (WebElement) js.executeScript(roo18);
		functions.click(driver,contractbillingbtn);
		functions.intermediatewait();
//Fill notice address
		//firstname
		String roo1 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#first-name\")";
		WebElement firstname = (WebElement) js.executeScript(roo1);
		functions.setText(driver,firstname,"Alys");
		functions.vshortWait();
		String roo2 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#last-name\")";
		WebElement lastname = (WebElement) js.executeScript(roo2);
		functions.setText(driver,lastname,"Dan");
		functions.vshortWait();
		String roo3 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#contact-email\")";
		WebElement email = (WebElement) js.executeScript(roo3);
		functions.setText(driver,email,"sridhar.dhusa@nrg.com");
		functions.vshortWait();
		String roo40 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#phone\")";
		WebElement phno = (WebElement) js.executeScript(roo40);
		functions.setText(driver,phno,"(412) 111-1111");
		functions.vshortWait();
		String roo5 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#notice-address\")";
		WebElement noticeaddress = (WebElement) js.executeScript(roo5);
		functions.setText(driver,noticeaddress,"12 greenway plaza");
		functions.vshortWait();
		String roo6 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#zip\")";
		WebElement zip = (WebElement) js.executeScript(roo6);
		functions.setText(driver,zip,"75002");
		functions.vshortWait();
		String roo7 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#city\")";
		WebElement city = (WebElement) js.executeScript(roo7);
		functions.setText(driver,city,"Houston");
		functions.vshortWait();
		String roo8 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > form > div:nth-child(5) > div:nth-child(2) > app-dropdown > div > div.row > div.col-9.pr-0 > input\")";
		WebElement state = (WebElement) js.executeScript(roo7);
		functions.setText(driver,state,"TX");
		state.sendKeys(Keys.ENTER);
		functions.vshortWait();
//click add contact to customer btn
		String roo9 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(1) > button\")";
		WebElement contacttocustbtn = (WebElement) js.executeScript(roo9);
		functions.click(driver,contacttocustbtn);
		functions.intermediatewait();
		//selectedaddress
		String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-address-validation-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div.row.button-row > div > div > button\")";
		WebElement selectedaddressbtn = (WebElement) js.executeScript(roo10);
		functions.click(driver, selectedaddressbtn);
		functions.intermediatewait();

		// Generate contact
		String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-contact > div.form-container > div:nth-child(4) > div:nth-child(2) > button\")";
		WebElement contractgenerationbtn = (WebElement) js.executeScript(roo20);
		functions.click(driver, contractgenerationbtn);
		functions.longWait();
		//send email
//		String roo33 = "return document.querySelector(\"body > modal-container > div > div > app-refresh-hu-modal > app-modal\").shadowRoot.querySelector(\"#customer-email\")";
//		WebElement  customerEmail1 = (WebElement) js.executeScript(roo33);
//		functions.setText(driver, customerEmail1, "sridhar.dhusa@nrg.com");
//		functions.intermediatewait();
//		customerEmail1.sendKeys(Keys.TAB);
//		functions.shortWait();
//
//		customerEmail1.sendKeys("sridhar.dhusa@nrg.com");


		//flip to dsp view
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-24px mdi-chevron-down']")));
		functions.click(driver, Seedetailsbtn);
		functions.intermediatewait();
		//click on broker visible
		functions.click(driver, brokervisible);
		functions.shortWait();
		//
		functions.click(driver,  continuebtn);
		functions.shortWait();
		try {
			if(Brokerswitch.isEnabled()) {
		functions.click(driver, Brokerswitch);
		functions.longWait();
		
		String Status="Pass";
			}
		}
		catch(Exception e) {
			String Status="Fail";
		}
		return Status;
	}
}

