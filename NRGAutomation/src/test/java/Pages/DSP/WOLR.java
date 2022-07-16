package Pages.DSP;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class WOLR {

	private Base base;
String Status1="Error";
	Putsbox putsbox = new Putsbox(base);

	@FindBy(xpath = "//a[@ng-reflect-router-link='86fe891e-0d98-4784-9acd-3f28a3']")
	WebElement Opportunityhyperlink;
	@FindBy(xpath = "//span[@class='mdi mdi-24px mdi-chevron-down']")
	WebElement SeeDetailsBtn;
	@FindBy(xpath = "//span[@class='icon icon-check']")
	WebElement SaveBtn;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link edit-button']") })
	public List<WebElement> Edit;
	@FindBy(xpath = "//input[@id='typeahead-ema']")
	WebElement EMAfield;
	@FindBy(xpath = "//div[@class='col-auto mr-auto my-auto']//span[@class='icon icon-pencil brand-primary']")
	WebElement EditBtn;
	@FindBy(xpath = "//span[contains(text(),'Opportunities')]")
	WebElement OpportunityBtn;
	@FindBy(xpath = "//h1[@class='text-overlap']")
	WebElement Opportunityname;
	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	@FindBy(xpath = "//span[@class='mdi mdi-dots-horizontal']")
	WebElement ThreeDotsbtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'WOLR')]c") })
	public List<WebElement> WOLRSelectorBtn1;
	
	@FindBy(xpath = "//button[contains(text(),'WOLR')]")
	WebElement WOLRSelectorBtn;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesBtn;
	@FindBy(xpath = "//button[contains(text(),'No')]")
	WebElement NoBtn;
	@FindBy(xpath = "//select[@class='form-control ng-untouched ng-pristine ng-invalid']")
	WebElement Primaryreasonlostdropdown;
	@FindBy(xpath = "//button[@class='mat-icon-button']")
	WebElement CalendarBtn;
	@FindBy(xpath = "//div[contains(text(),'DEC')]")
	WebElement MonthSelector;
	@FindBy(xpath = "//div[@class='mat-calendar-body-cell-content mat-calendar-body-today']")
	WebElement CurrentdateSelector;
	@FindBy(xpath = "//select[@class='form-control ng-untouched ng-pristine ng-valid']")
	WebElement MarketSegmentDropdown;
	@FindAll(value = { @FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid']") })
	public List<WebElement> Commentfield;
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched']") 
	WebElement Commentfield1;
	///input[@class='form-control ng-pristine ng-invalid ng-touched']
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement ContinueBtn;
	@FindAll(value = { @FindBy(xpath = "//input[@id='selectQuote']") })
	public List<WebElement> SelectQuotecheckbox;
	@FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-valid']")
	WebElement ReliantPriceField;
	@FindBy(xpath = "//button[contains(text(),'Submit WOLR')]")
	WebElement SubmitWOLRBtn;
	@FindAll(value = { @FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-valid']") })
	public List<WebElement> SalesPricefield;
	@FindBy(xpath = " //input[@class=' form-control ng-pristine ng-valid ng-touched']")
	WebElement TargetUnitfield0;
	@FindAll(value = { @FindBy(xpath = "//input[@onkeydown='return event.keyCode !== 69 && event.keyCode !== 187']") })
	public List<WebElement> TargetUnitfield1;
	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-valid ng-touched'][1]")
	WebElement ProductTypeDropdown;
	@FindBy(xpath = "//button[@class='mat-icon-button']")
	WebElement ProductStartBtn;
	@FindBy(xpath = "//button[@class='mat-icon-button']")
	WebElement ProductEndBtn;
	@FindBy(xpath = "//button[@class='mat-calendar-next-button mat-icon-button']")
	WebElement CalendarnextBtn;
	@FindBy(xpath = " //input[@onkeydown='return event.keyCode !== 69 && event.keyCode !== 189 && event.keyCode !== 109 && event.keyCode !== 110 && event.keyCode !== 190 && event.keyCode !== 187']")
	WebElement VOLUMEONVOLUNTARYRECSfield;
	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement VoluntaryRecsGreenDropdown;
	@FindBy(xpath = "//select[@class='form-control mt-21 ng-pristine ng-valid ng-touched']")
	WebElement TDSPDropdown;
	@FindBy(xpath = "//button[contains(text(), 'Clear Filters')]")
	WebElement clearFilterBtn;
	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-invalid ng-touched']")
	WebElement PrimaryReasonWondropdown;
	@FindBy(xpath = "//input[@id='contractRadioButton']")
	WebElement contractradiobtn;
	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-invalid ng-touched']")
	WebElement dropbtn;
	@FindBy(xpath = "//a[contains(text(),'WOLR View')]")
	WebElement wolrviewbtn;

	WebDriver driver;

	public WOLR(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * WOLR Lost Report.
	 */

	public String LostReport(String Optyheader) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on See Details Button
		functions.click(driver, SeeDetailsBtn);

		// Wait for Sometime
		functions.midintermediatewait();

		// Click on Edit Button
		functions.click(driver, EditBtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on EMA Field
		functions.click(driver, EMAfield);

		// Enter Text in EMA Field
		functions.setText(driver, EMAfield, "UPARTHIPAN");

		// Wait for Sometime
		functions.shortWait();

		// Click on Save Button
		functions.click(driver, SaveBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to DSP URL
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Wait for Sometime
		functions.shortWait();

		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in the Search
		functions.setText(driver, Searchplaceholder, Optyheader);

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

		functions.vshortWait();
		// paste
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		// Wait for Sometime
		functions.intermediatewait();

		// Click on Opportunity Id Hyperlink
		driver.findElement(By.xpath("//a[contains(text(),'" + Optyheader + "')]")).click();

		// Wait for Sometime
		WebDriverWait wait = new WebDriverWait(driver, 360);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-24px mdi-chevron-down']")));

		// Click on See details Button
		functions.click(driver, SeeDetailsBtn);

		// Wait for Sometime
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				"//ngb-alert[@class='locked-banner yellow-locked-banner alert alert-warning ng-star-inserted']")));

		// Wait for Sometime
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='col-auto mr-auto my-auto']//span[@class='icon icon-pencil brand-primary']")));

		// Click on Edit Button
		functions.click(driver, EditBtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on EMA Field
		functions.click(driver, EMAfield);

		// Enter Text in EMA Field
		functions.setText(driver, EMAfield, "UPARTHIPAN");

		// Wait for Sometime
		functions.shortWait();

		// Click on Save Button
		functions.click(driver, SaveBtn);

		// Wait for Sometime
		functions.shortWait();

		// Navigate to DSP
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Wait for Sometime
		functions.shortWait();

		
		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in Search Place Holder
		functions.setText(driver, Searchplaceholder, Optyheader);

		//// code for copy paste
		Actions action = new Actions(driver);
		// Select the Current Address using CTRL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.vshortWait();

		// Copy the Current Address using CTRL + C
		action.keyDown(Keys.CONTROL);
		action.sendKeys("x");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.vshortWait();
		// paste
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.intermediatewait();

		// Click on ThreeDots Button
		functions.click(driver, ThreeDotsbtn);

		// Click on WOLRSelector Button
		
		try {
			if (WOLRSelectorBtn1.size() >= 0 == true
					&& WOLRSelectorBtn1.get(0).isEnabled() == true) {

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'WOLR')]")));

		functions.click(driver, WOLRSelectorBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Yes Button
		functions.click(driver, yesBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Select Primary lost from the Dropdown
		functions.selectDropdownByVisibleText(driver, Primaryreasonlostdropdown, prop.getProperty("Primarylost"));

		// Click on Calendar Button
		functions.click(driver, CalendarBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Month Selector Button
		functions.click(driver, MonthSelector);

		// Click on Current date Selector Button
		functions.click(driver, CurrentdateSelector);

		// Select Market Segment from the Dropdown
		functions.selectDropdownByVisibleText(driver, MarketSegmentDropdown, prop.getProperty("MarketSegment"));

		// Enter Comment in the Comment Field
		Commentfield.get(4).sendKeys(prop.getProperty("Comment"));

		// Click on Continue Button
		functions.click(driver, ContinueBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Select Quote Checkbox
		SelectQuotecheckbox.get(1).click();

		// Click on Continue Button
		functions.click(driver, ContinueBtn);

		// Enter Reliant Price in Reliant Price Field
		functions.setText(driver, ReliantPriceField, prop.getProperty("ReliantPrice"));

		// Click on Submit WOLR Button
		functions.click(driver, SubmitWOLRBtn);

		// Enter Sales Price in Sales Price Field
		SalesPricefield.get(3).sendKeys(prop.getProperty("SalesPrice"));

		// Wait for Sometime
		functions.vshortWait();

		// Enter Target Unit in Target Unit Field
		TargetUnitfield1.get(1).sendKeys(prop.getProperty("TargetUnit"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Productype = (WebElement) jse.executeScript(
				"return  document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(4) > div.col.pr-sm > select\")");

		// Select Product Type in Product Type Dropdown
		functions.selectDropdownByVisibleText(driver, Productype, prop.getProperty("Producttype"));

		// Click on ProductSatrtButton
		functions.click(driver, ProductStartBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Month Selector Button
		functions.click(driver, MonthSelector);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Product End Button
		functions.click(driver, ProductEndBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Calendar Next Button
		functions.click(driver, CalendarnextBtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Month Selector Button
		functions.click(driver, MonthSelector);

		// Wait for Sometime
		functions.vshortWait();

		// Enter VoluntaryRecs in the Voluntary Field
		WebElement VOLUNTARYRECSfield = (WebElement) jse.executeScript(
				"return  document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(16) > div.col.pr-sm > input\")");

		VOLUNTARYRECSfield.sendKeys(prop.getProperty("Voluntaryrecs"));

		// Wait for Sometime
		functions.vshortWait();

		// Select Value from VoluntaryRecsGreen Dropdown
		WebElement VoluntaryRecsGreenDropdown = (WebElement) jse.executeScript(
				"return document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(16) > div.col.pl-sm > select\")");

		functions.selectDropdownByVisibleText(driver, VoluntaryRecsGreenDropdown,
				prop.getProperty("Voluntaryrecsgreen"));

		// Select Value from TDSP Dropdown
		WebElement TDSPDropdown = (WebElement) jse.executeScript(
				"return document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(18) > div.col.pr-sm > select\")");

		functions.selectDropdownByVisibleText(driver, TDSPDropdown, prop.getProperty("TDSP"));

		// Wait for Sometime
		functions.vshortWait();

		// Click on Submit WOLR Button
		functions.click(driver, SubmitWOLRBtn);

		String Status="Pass";
		return Status;
		
			}
		}
			catch (Exception e) {
				System.out.println("Error");
			}
			
			
			return Status1;
		}
	

	/*
	 * WOLR Won Report.
	 */

	public String WonReport(String Optyheader) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Navigate to DSP
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Wait for Sometime
		functions.shortWait();

//		WebDriverWait wait5 = new WebDriverWait(driver, 50);
//		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'WOLR View')]")));
//		functions.click(driver, wolrviewbtn);

		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity Name in Search Place Holder
		functions.setText(driver, Searchplaceholder, Optyheader);

		
		// Wait for Sometime
		functions.shortWait();

		//// code for copy paste
		Actions action = new Actions(driver);
		// Select the Current Address using CTRL + A
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.vshortWait();

		// Copy the Current Address using CTRL + C
		action.keyDown(Keys.CONTROL);
		action.sendKeys("x");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.vshortWait();
		// paste
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

		// Wait for Sometime
		functions.intermediatewait();

		// Click on Three Dots Button
		functions.click(driver, ThreeDotsbtn);
		
		try {
			if (WOLRSelectorBtn1.size() >= 0 == true
					&& WOLRSelectorBtn1.get(0).isEnabled() == true) {

		// Click on WOLR Selector

		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'WOLR')]")));
		functions.click(driver, WOLRSelectorBtn);

		// Click on Yes Button

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes')]")));
		functions.click(driver, yesBtn);

		// Click on No Button

		WebDriverWait waits = new WebDriverWait(driver, 50);
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes')]")));
		functions.click(driver, yesBtn);
         //select dropdown
		//select[@class='form-control ng-pristine ng-invalid ng-touched']
		functions.selectDropdownByVisibleText(driver, dropbtn,"User DSP");
		
		
		functions.click(driver, CalendarBtn);

		// Select PrimaryWon from the PrimaryReasonWonDropdown
		functions.selectDropdownByVisibleText(driver, PrimaryReasonWondropdown, prop.getProperty("PrimaryWon"));

		// Select MarketSegment from the MarketSegmentDropdown
		functions.selectDropdownByVisibleText(driver, MarketSegmentDropdown, prop.getProperty("MarketSegment"));

		// Enter Comment in Comment Field
		functions.setText(driver,Commentfield1,prop.getProperty("Comment"));

		// Click on Continue Button
		functions.click(driver, ContinueBtn);

		// Wait for Sometime
		functions.intermediatewait();

		// Click on ContractRadioButton
		functions.click(driver, contractradiobtn);

		// Wait for Sometime
		functions.vshortWait();

		// Click on Continue Button
		functions.click(driver, ContinueBtn);

		// Enter Reliant Price in the Reliant Price Field
		functions.setText(driver, ReliantPriceField, prop.getProperty("ReliantPrice"));

		// Click on SubmitWOLR Button
		functions.click(driver, SubmitWOLRBtn);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// Enter Voluntary Recs Text in the Voluntary Recs Field
		WebElement VOLUNTARYRECSfield = (WebElement) jse.executeScript(
				"return  document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(16) > div.col.pr-sm > input\")");

		VOLUNTARYRECSfield.sendKeys(prop.getProperty("Voluntaryrecs"));

		// Wait for Sometime
		functions.vshortWait();

		// Select No from VoluntaryRecsGreenDropdown
		WebElement VoluntaryRecsGreenDropdown = (WebElement) jse.executeScript(
				"return document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(16) > div.col.pl-sm > select\")");

		functions.selectDropdownByVisibleText(driver, VoluntaryRecsGreenDropdown,
				prop.getProperty("Voluntaryrecsgreen"));

		// Select TDSP value from TDSP Dropdown
		WebElement TDSPDropdown = (WebElement) jse.executeScript(
				"return document.querySelector(\"body > jhi-main > div > jhi-wolr > div.wolr-container > div > div.wolr-cards-body.col-md-11 > mat-card > div:nth-child(6) > div:nth-child(18) > div.col.pr-sm > select\")");

		functions.selectDropdownByVisibleText(driver, TDSPDropdown, prop.getProperty("TDSP"));

		// Wait for Sometime
		functions.vshortWait();

		// Click on Submit WOLR Button
		functions.click(driver, SubmitWOLRBtn);
		
		String Status="Pass";
		
		return Status;
	}
			
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
		
		return Status1;
	}
}
