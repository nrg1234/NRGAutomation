package Pages.DSP;

import java.util.List;
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
import apphooks.Base;

public class MeterFeeandVoluntaryRecs {

	@FindBy(xpath = "//button[contains(text(),'Credit ')]")
	WebElement CreditTAB;
	@FindBy(xpath = "//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;
	@FindBy(xpath = "//*[@id='quotesLoader']")
	WebElement quotesLoader;
	@FindBy(xpath = "//span[contains(text(), 'See Details')]")
	WebElement seeDetails;
	@FindBy(xpath = "//button[@id='bp-visible-switch']")
	WebElement brokerVisibletoggle;
	@FindBy(xpath = "//a[contains(text(), 'Index')]")
	WebElement indexTAB;
	@FindBy(xpath = "//input[@id='mat-input-27']")
	WebElement marginfield;
	@FindBy(xpath = "//input[@id='mat-input-28']")
	WebElement doaMarginfield;
	@FindBy(xpath = "//button[contains(text(), 'Calculate and Save')]")
	WebElement calculateAndSave;
	@FindAll(value = { @FindBy(xpath = "//span[contains(text(), 'Select')]") })
	public List<WebElement> productSelectBtn;
	@FindBy(xpath = "//li[@class='ng-star-inserted']//a[contains(text(), 'Index')]")
	WebElement IndexPriceBtn;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement convert50kwBtn;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindAll(value = { @FindBy(xpath = "//*[@id=\"QuoteCard\"]/div[1]/div[2]/input") })
	public List<WebElement> TermField;
	@FindAll(value = { @FindBy(xpath = "//span[@class='icon icon-close']") })
	public List<WebElement> Popupclose;
	@FindBy(xpath = "//select[@id='monthlyMeterFee']")
	WebElement MeterfeeDropdown;
	@FindBy(xpath = "//select[@id='recPercent']")
	WebElement RecsDropdown;
	@FindAll(value = {@FindBy(xpath = "//option[contains(text(),'0%')]")})
	public List<WebElement> DefaultRecDropdown;
	//option[contains(text(),'0%')]
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	WebDriver driver;

	public MeterFeeandVoluntaryRecs(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Price a deal with Meter Fee and Voluntary Recs.
	 */
	public void MeterFeeandVoluntaryRecs() throws Throwable {

		// Navigate to quotes page
		WebDriverWait wait1 = new WebDriverWait(driver, 400);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Quotes')]")));
		functions.click(driver, quotesTAB);
		// Wait for spinner to appear when request is made to Siebel
		functions.shortWait();
		if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			Popupclose.get(4).click();
			functions.vshortWait();
		}

		// Wait for few minutes
		functions.shortWait();
		
	     //Validating default Rec Value
		if (DefaultRecDropdown.size() >= 0 == true && DefaultRecDropdown.get(0).isDisplayed() == true) {
			//
						System.out.println("Rec value with zero is displayed");}
        
		WebDriverWait wait2 = new WebDriverWait(driver, 80);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='monthlyMeterFee']")));

		functions.selectDropdownByVisibleText(driver, MeterfeeDropdown, "$4.95");

		WebDriverWait wait3 = new WebDriverWait(driver, 80);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='recPercent']")));

		functions.selectDropdownByVisibleText(driver, RecsDropdown, "25%");

		WebDriverWait wait4 = new WebDriverWait(driver, 80);
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Calculate and Save')]")));

		functions.click(driver, calculateAndSave);

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(1).isDisplayed() == true) {
			productSelectBtn.get(0).click();
		}

	}
}
