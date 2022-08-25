package Pages.DSP;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import Utilities.ConfigReader;
import apphooks.Base;

import com.codahale.metrics.Meter;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;

public class PriceaDeal {
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
	@FindBy(xpath = "//input[@tabindex='8']")
	WebElement marginfield;
	@FindBy(xpath = "//input[@tabindex='9']")
	WebElement doaMarginfield;
	@FindBy(xpath = "//input[@formcontrolname='brokerFee']")
	WebElement brokerfeefield;
	@FindBy(xpath = "//button[contains(text(), 'Calculate and Save')]")
	WebElement calculateAndSave;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link mt-3 pt-1 ng-star-inserted']") })
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
	@FindBy(xpath = "//input[@id='mat-input-14']")
	WebElement Margin;
	@FindBy(xpath = "//span[@class='mdi mdi-36px mdi-plus-circle mb-3']")
	WebElement createterm;
	@FindBy(xpath = "//select[@formcontrolname='monthlyMeterFee']")
	WebElement MeterFeevalue;
	@FindAll(value = { @FindBy(xpath = "//div[@ng-reflect-form='[object Object]']") })
	public List<WebElement> fullproduct;
	@FindBy(xpath = "//button[contains(text(), 'Deal Options')]")
	WebElement DealoptionTAB;
	@FindBy(xpath = "//span[@class='icon icon-expand ng-star-inserted']")
	WebElement expandicon;
	@FindBy(xpath = "//span[@class='icon icon-collapse ng-star-inserted']")
	WebElement minimizeicon;

	
	@FindBy(xpath = "//td[normalize-space()='CRR Interzonal']")
	WebElement CRRInterzonal;
//@FindBy(xpath = "//p[normalize-space()='No Products for Quote']")
	@FindBy(xpath = "//span[@ng-reflect-tooltip='Site error in VHOS']")	
	WebElement siteerror;
	@FindBy(xpath = "//select[@id='recPercent']")
	WebElement recpercent;
	@FindBy(xpath = "//h4[contains(text(), 'Add Customer')]")
	WebElement AddCustomerbanner;
	@FindBy(xpath = "//h4[contains(text(), 'Create Customer')]")
	WebElement CreateCustomerbanner;
	 @FindBy(xpath = " //p [contains(text(),'This opportunity has not been created in Siebel yet. Please ensure the opportunity has at least 1 customer with at least 1 site before creating a quote.')]")
	   	WebElement Sitesnotadded;
		@FindBy(xpath = "//span[contains(text(), 'Invalid product terms')]")
		WebElement invalidterm;
		@FindAll(value = { @FindBy(xpath = "//span[@class='mdi mdi-open-in-new brand-primary']") })
		public List<WebElement> Navigatetovhos;
		@FindBy(xpath = "//select[@id='materialChange']")
		WebElement MVPDropdown;
		@FindBy(xpath = "//span[contains(text(),' Product')]")
		WebElement Vhosproduct;
		@FindBy(xpath = "//a[contains(text(), 'Product Wizard')]")
		WebElement Vhosproductwizard;
		@FindBy(xpath = "//li[contains(text(), 'Block & Index Realtime Settlement')]")
		WebElement BIRealtime;		
		@FindBy(xpath = "//span[@class='ui-icon ui-icon-arrow-1-e']")
		WebElement Arrowbtn;
		@FindBy(xpath = "//input[@value='All Sites']")
		WebElement allsitesbtn;
		@FindBy(xpath = "//input[@value='CongestionZone']")
		WebElement congestionzonebtn;
		@FindBy(xpath = "//input[@id='A3004:f1:j_idt27']")
		WebElement Productstartsate;
		@FindBy(xpath = "//input[@id='A3004:f1:j_idt30']")
		WebElement term;
		@FindBy(xpath = "//input[@value='Preview']")
		WebElement previewbtn;
		@FindBy(xpath = "//input[@type='checkbox']")
		WebElement checkbtn;
		@FindBy(xpath = "//input[@value='Create']")
		WebElement Createbtn;
		@FindBy(xpath = "//span[@id='A3175:sPortlet:pl1:biTable:0:j_idt78']")
		WebElement productlink;
		@FindAll(value = { @FindBy(xpath = "//input[@value='Edit']") })
		public List<WebElement> editbtn;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt426']")
		WebElement istblocksize;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt429']")
		WebElement secondblocksize;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt432']")
		WebElement thirdblocksize;
		@FindAll(value = { @FindBy(xpath = "//input[@value='+']") })
		public List<WebElement> plusbtn;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt441']")
		WebElement istContractblocksize;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt443']")
		WebElement secondContractblocksize;
		@FindBy(xpath = "//input[@id='A5879:j_idt176:j_idt383:editerctblockfrm:blocke:0:j_idt445']")
		WebElement ThirdContractblocksize;
		@FindAll(value = { @FindBy(xpath = "//input[@value='Save']") })
		public List<WebElement> savebtn;
		@FindBy(xpath = "//input[@value='Save']")
		WebElement Save;
		@FindBy(xpath = "//input[@id='MARGIN']")
		WebElement DOAvalue;
		@FindBy(xpath = "//input[@id='MARGINamt']")
		WebElement Marginvalue;
		@FindAll(value = { @FindBy(xpath = "//img[@alt='Calculate Product']") })
		public List<WebElement> calculatebtn;
		@FindBy(xpath="//span[contains(text(),' Deal Option')]")
		WebElement dealoption;
		@FindBy(xpath = "//select[@id='A4583:j_idt6:sPortlet:_t35']")
		WebElement vhosdropdwn;
		@FindBy(xpath = "//input[@value='Go']")
		WebElement gobtn;
		@FindBy(xpath = "//input[@id='A4583:j_idt6:sPortlet:dealName']")
		WebElement dealname;
		@FindBy(xpath = "//input[@id='A4583:j_idt6:prschPrtlet:prschTable:0:j_idt50']")
		WebElement dealcheckbox;
		@FindBy(xpath = "//input[@id='A4583:j_idt6:sPortlet:dotbl:0:j_idt20']")
		WebElement dealcheckbox1;
		
		@FindBy(xpath = "//input[@value='Build Deal']")
		WebElement Builddeal;
		
		
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	WebDriver driver;
	private Base base;
	Putsbox putsbox = new Putsbox(base);

	public PriceaDeal(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);

	}
public boolean CRR() throws Throwable {
		
		functions.click(driver, DealoptionTAB);
		functions.shortWait();
		functions.click(driver, expandicon);
		functions.minwait();
		functions.click(driver, expandicon);
		if(CRRInterzonal.isDisplayed()) {
			System.out.println("CRRInterzonal present");
		}
		else {
			System.out.println("CRRInterzonal not present");
		}
	// Navigatetovhos.get(2).click();
		functions.click(driver, minimizeicon);
//		functions.click(driver, minimizeicon);
		return true;
		
	}

	/*
	 * Price a deal with Fixed Product.
	 */
	public boolean priceadeal() throws Throwable {

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

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
		// Enter Brokerfee

//        brokerfeefield.click();
//        functions.setText(driver, brokerfeefield, prop.getProperty("BrokerFee"));
//        functions.vshortWait();
//        brokerfeefield.sendKeys(Keys.ENTER);
//        functions.vshortWait();
//		try {
//			if (MVPDropdown.isDisplayed()) {
//			
//				System.out.println("MVPDropdown is getting displayed");
//				MVPDropdown.click();
//				return false;
//			}
//		} catch(Exception n) {
//		}
		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);
		// Wait for Sometime
		WebDriverWait wait11 = new WebDriverWait(driver, 200);
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(1).isDisplayed() == true) {
			productSelectBtn.get(0).click();
		}

	
		return true;
	}
	
	
	public void priceadealBlockandIndex() throws Throwable {
		
		functions.click(driver, Vhosproduct);
		functions.shortWait();
		functions.click(driver, Vhosproductwizard);
		functions.minwait();
		functions.click(driver, BIRealtime);
		functions.vshortWait();
		functions.click(driver, Arrowbtn);
		functions.vshortWait();
		functions.click(driver, allsitesbtn);
		functions.vshortWait();
		functions.click(driver, congestionzonebtn);
		functions.vshortWait();
		functions.setText(driver, Productstartsate, prop.getProperty("B&Idate"));
		functions.vshortWait();
		functions.setText(driver, term, "12");
		functions.shortWait();
		functions.click(driver,previewbtn);
	functions.vshortWait();
	functions.click(driver, checkbtn);
	functions.vshortWait();
	functions.click(driver, Createbtn);
	functions.shortWait();
	functions.click(driver, productlink);
	functions.vshortWait();
	editbtn.get(1).click();
	functions.vshortWait();
	functions.setText(driver, istblocksize, "0.01");
	functions.setText(driver, secondblocksize, "0.01");
	functions.setText(driver, thirdblocksize, "0.01");
	functions.vshortWait();
	plusbtn.get(0).click();
	functions.setText(driver, istContractblocksize, "0.05");
	functions.setText(driver, secondContractblocksize, "0.05");
	functions.setText(driver, ThirdContractblocksize, "0.05");
	functions.shortWait();
	savebtn.get(0).click();
	functions.shortWait();
	functions.setText(driver,DOAvalue, "8");
	functions.vshortWait();
	functions.setText(driver, Marginvalue, "10");
	functions.vshortWait();
 calculatebtn.get(1).click();
 functions.shortWait();
 functions.click(driver, dealoption);
	//handle leave alert

 functions.vshortWait();
 functions.selectDropdownByVisibleText(driver, vhosdropdwn, "New");
 functions.minwait();
 functions.click(driver,gobtn);
 functions.setText(driver, dealname, "TestB&I");
 functions.click(driver, Save);
 functions.vshortWait();
 functions.click(driver, dealcheckbox);
 functions.minwait();
 functions.click(driver, Builddeal);
 functions.minwait();
 functions.click(driver, dealcheckbox1);
 functions.minwait();
 functions.click(driver, gobtn);
 functions.click(driver, Save);
 
 
 driver.close();
 ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	// switch to the parent window
	driver.switchTo().window(tabs2.get(0));
	}
	

	/*
	 * Price a deal with Index Product.
	 */
	public void priceadealwithindexproduct() throws Throwable {

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Wait for spinner to appear when request is made to Siebel
		functions.shortWait();

		// Clicks on Index Price Button
		functions.click(driver, IndexPriceBtn);

		// Wait for spinner to appear when request is made to Siebel
		functions.midWait();

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(3).isDisplayed() == true) {
			productSelectBtn.get(3).click();
		}
	}

	/*
	 * Price a deal with Fixed Product for Renewal<50wkh.
	 */
	public void Priceadeal() throws Throwable {

		if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			Popupclose.get(4).click();
			functions.vshortWait();
		}
		
		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		functions.longWait();
		TermField.get(1).click();
		TermField.get(1).clear();
		TermField.get(1).sendKeys("19");
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(2).click();
		TermField.get(2).clear();
		TermField.get(2).sendKeys("19");
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(3).click();
		TermField.get(3).clear();
		TermField.get(3).sendKeys("19");
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(4).click();
		TermField.get(4).clear();
		TermField.get(4).sendKeys("19");
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(5).click();
		TermField.get(5).clear();
		TermField.get(5).sendKeys("19");
		functions.shortWait();

		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);

		// Wait for Sometime
		functions.midWait();

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(1).isDisplayed() == true) {
			productSelectBtn.get(1).click();
		}

	}

	/*
	 * Price a deal with Fixed Product for other Source.
	 */
	public String priceadealforOtherSource() throws Throwable {

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Wait for spinner to appear when request is made to Siebel
		functions.shortWait();
		if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			Popupclose.get(4).click();
			functions.vshortWait();
		}

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(1).isDisplayed() == true) {
			productSelectBtn.get(0).click();
		}
		
		String Status="Pass";
		return Status;

	}

	/*
	 * Price a deal with Fixed Product for PC Using Excel File.
	 */
	public void selectProduct(String priceTerm, String Margin, String DOAMargin, String BrokerFee, String MeterFee,
			String Recvalue) throws InterruptedException {
		try {
			if (siteerror.isDisplayed() == true) {
				System.out.println("site error");
			}
		} catch (Exception n) {

			// Navigate to quotes page
			functions.click(driver, quotesTAB);
			functions.intermediatewait();

			// Wait for spinner to appear when request is made to Siebel
			functions.shortWait();
			if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
				Popupclose.get(4).click();
				functions.vshortWait();
			}

			// Wait for Sometime
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

			functions.selectDropdownByVisibleText(driver, MeterFeevalue, MeterFee);
			functions.selectDropdownByVisibleText(driver, recpercent, Recvalue);
			// Wait for Prices to be displayed
			// Breaking the Xpath
			String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

			// Breaking the Xpath
			String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";

			// for looping the Xpath
			for (int i = 1; i < fullproduct.size(); i++) {
				// Appending the Xpath
				String actualXpath = beforeXpath + i + afterXpath;

				// Passing xpath to WebElement
				WebElement element = driver.findElement(By.xpath(actualXpath));

				// Comparing the Term from UI with Existing Opportunity Term
				if (element.getAttribute("value").equals(priceTerm)) {
					System.out.println("Term:" + element.getText());

					functions.vshortWait();
				}
			}

			for (int j = 1; j <= fullproduct.size(); j++) {
				// Appending the Xpath
				String actualXpath1 = beforeXpath + j + afterXpath;

				// Passing xpath to WebElement
				WebElement element1 = driver.findElement(By.xpath(actualXpath1));

				if (element1.getAttribute("value").equals(priceTerm)) {
					System.out.println("Term:" + element1.getText());

					functions.shortWait();
					// Enter Margin value
					String xpath1 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
					String xpath2 = "]/div/div[2]/div[7]/input";

					String xpath3 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
					String xpath4 = "]/div/div[2]/div[8]/input";

					String xpath5 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
					String xpath6 = "]/div/div[2]/div[5]/input";

					String actualXpath3 = xpath5 + j + xpath6;

					String actualXpath = xpath1 + j + xpath2;

					String actualXpath2 = xpath3 + j + xpath4;
					// // Passing xpath to WebElement
					WebElement element0 = driver.findElement(By.xpath(actualXpath));
					WebElement element2 = driver.findElement(By.xpath(actualXpath2));
					WebElement element3 = driver.findElement(By.xpath(actualXpath3));
					// Passing xpath to WebElement
					element0.clear();
					element0.sendKeys(Margin);
					functions.shortWait();
					// functions.setText(driver, element0, Margin);
					element2.clear();
					element2.sendKeys(DOAMargin);
					functions.shortWait();

					element3.clear();
					element3.sendKeys(BrokerFee);
					functions.shortWait();

					// Click on Calculate and Save Button
					functions.click(driver, calculateAndSave);
					WebDriverWait wait1 = new WebDriverWait(driver, 500);
					wait1.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

				}

			}
//		// Click on Calculate and Save Button
//		functions.click(driver, calculateAndSave);
//		WebDriverWait wait1 = new WebDriverWait(driver, 300);
//		wait1.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		}

	}

	public void addterm(String Term1, int t) throws InterruptedException {
		try {
			if (siteerror.isDisplayed() == true) {
				System.out.println("siteerror");
			}
		} catch (Exception n) {
			functions.click(driver, quotesTAB);
			functions.intermediatewait();
			// Wait for spinner to appear when request is made to Siebel
			functions.shortWait();
			if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
				Popupclose.get(4).click();
				functions.vshortWait();
			}
//String Term2 = Term1 /12;
			// Wait for Prices to be displayed
			// Breaking the Xpath
			String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

			// Breaking the Xpath
			String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";
			// String actualXpath = beforeXpath + 1 + afterXpath;
			// for looping the Xpath
			Loop: for (int i = t; i <= fullproduct.size(); i++) {
				// Appending the Xpath
				String actualXpath = beforeXpath + i + afterXpath;

				// Passing xpath to WebElement
				WebElement element = driver.findElement(By.xpath(actualXpath));

//try {
				// Comparing the Term from UI with Existing Opportunity Term
				if (element.getAttribute("value").equals(Term1)) {
					System.out.println("Term:" + element.getAttribute("value"));
					break;
				} else if (i < fullproduct.size()) {
					continue Loop;
				}

				else {

					// Wait for Sometime
					WebDriverWait wait = new WebDriverWait(driver, 300);
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

					for (int j = fullproduct.size(); j < fullproduct.size() + 1; j++) {
						String xpath1 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
						String xpath2 = "]/div/div[1]/div[2]/input";

						String actualXpath1 = xpath1 + j + xpath2;
						WebElement element0 = driver.findElement(By.xpath(actualXpath1));

						element0.clear();
						element0.sendKeys(Term1);
						functions.intermediatewait();

						// Click on Calculate and Save Button
						functions.click(driver, calculateAndSave);
						WebDriverWait wait1 = new WebDriverWait(driver, 500);
						wait1.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
						// Add term button
						functions.click(driver, createterm);
						functions.intermediatewait();
						// Click on Calculate and Save Button
						functions.click(driver, calculateAndSave);
						WebDriverWait wait2 = new WebDriverWait(driver, 300);
						wait2.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
						break;
					}

				}

				// }catch(Exception n1)

			}

//   {
//    	
//    }

		}
	}

	// }
//	}
	public void selectProductcontractgeneration(String contractTerm) throws InterruptedException {
// Wait for Prices to be displayed
		// Breaking the Xpath
		try {
			if (siteerror.isDisplayed() == true) {
				System.out.println("site error");
			}
		} catch (Exception n) {
			String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

			// Breaking the Xpath
			String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";

			String approverlevelxpath1 = "/html[1]/body[1]/jhi-main[1]/div[1]/jhi-opportunity[1]/div[1]/jhi-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/div[";

			String approverlevelxpath2 = "]/div[1]/div[2]/div[11]";
// for looping the Xpath
			for (int i = 1; i <= fullproduct.size(); i++) {
				// Appending the Xpath
				String actualXpath = beforeXpath + i + afterXpath;
				String approverxpath = approverlevelxpath1 + i + approverlevelxpath2;
				// Passing xpath to WebElement
				WebElement element = driver.findElement(By.xpath(actualXpath));
				WebElement approver = driver.findElement(By.xpath(approverxpath));

				// Comparing the Term from UI with Existing Opportunity Term
				if (element.getAttribute("value").equals(contractTerm)) {
					System.out.println("Term:" + element.getAttribute("value"));
					if (approver.getText().equals("Pre-Approved")) {
						try {
							System.out.println("Approver:" + approver.getText());
						} catch (StaleElementReferenceException e) {
							System.out.println("print");
						}
						productSelectBtn.get(i - 1).click();

						functions.vshortWait();
					}
				}

			}
		}
	}

	
		
	public void clickquotespage() throws InterruptedException {
		try{
        	if(invalidterm.isDisplayed()==true) {        	
         		System.out.println("invalid term");
        	}
        }catch(Exception n8) {
		try {	
			if(AddCustomerbanner.isDisplayed()==true) {
			System.out.println("Customer issue");
			}	
			}catch(Exception n7){
			try {
				if(CreateCustomerbanner.isDisplayed()==true) {
					System.out.println("Customer issue");
			}
		}catch(Exception n1) {
		
		try {	
			if(Sitesnotadded.isDisplayed()==true) {
				System.out.println("Sites not added");
			}
			}catch(Exception n6){	
		try {
		if(siteerror.isDisplayed()==true) {
		System.out.println("siteerror");
	}
	}catch(Exception n){
		
		
		// Navigate to quotes page
		WebDriverWait wait1 = new WebDriverWait(driver, 400);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Quotes')]")));
		functions.click(driver, quotesTAB);
		// Wait for spinner to appear when request is made to Siebel
		
		// Wait for few minutes
	

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
	}
	}
		}
			}
        }
		
	}
	

	public void CreatenewProductcontractgeneration(String contractTerm) throws InterruptedException {

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
		// Create new Term
		functions.setText(driver, createterm, contractTerm);

		// Breaking the Xpath
		String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

		// Breaking the Xpath
		String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";
// for looping the Xpath
		for (int i = 1; i < 5; i++) {
			// Appending the Xpath
			String actualXpath = beforeXpath + i + afterXpath;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath));

			// Comparing the Term from UI with Existing Opportunity Term
			if (element.getAttribute("value").equals(contractTerm)) {
				System.out.println("Term:" + element.getText());
				productSelectBtn.get(i - 1).click();
				functions.vshortWait();
			}
		}

	}

	/*
	 * Price a deal with Fixed Product for PC Using XML File.
	 */
	public void selectProductXML(String Brokerfee, String Marginvalue, String DOAMargin, String Term)
			throws InterruptedException {

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Wait for spinner to appear when request is made to Siebel
		functions.shortWait();
		if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			Popupclose.get(4).click();
			functions.vshortWait();
		}

		// Enter Brokerfee

		brokerfeefield.click();
		functions.setText(driver, brokerfeefield, Brokerfee);
		functions.vshortWait();
		brokerfeefield.sendKeys(Keys.ENTER);
		functions.vshortWait();

		// Enter Margin value

		marginfield.click();
		functions.setText(driver, marginfield, Marginvalue);
		functions.vshortWait();
		marginfield.sendKeys(Keys.ENTER);
		functions.vshortWait();

		// Enter DOAMargin

		doaMarginfield.click();
		functions.setText(driver, doaMarginfield, DOAMargin);
		functions.vshortWait();
		doaMarginfield.sendKeys(Keys.ENTER);
		functions.vshortWait();

		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);

		// Wait for Sometime
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// Wait for Prices to be displayed
		// Breaking the Xpath
		String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

		// Breaking the Xpath
		String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";

		// for looping the Xpath
		for (int i = 1; i <= 6; i++) {
			// Appending the Xpath
			String actualXpath = beforeXpath + i + afterXpath;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath));

			// Comparing the Term from UI with Existing Opportunity Term
			if (element.getAttribute("value").equals(Term)) {
				System.out.println("Term:" + element.getText());
				productSelectBtn.get(i - 1).click();
			}
		}
	}

	/*
	 * Price a deal with Fixed Product for PC Using Excel File.
	 */
	public void selectmultipleProduct(String priceTerm, String priceTerm1, String BrokerFee, String Margin,
			String DOAMargin) throws InterruptedException {

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Wait for spinner to appear when request is made to Siebel
		functions.shortWait();
		if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			Popupclose.get(4).click();
			functions.vshortWait();
		}

		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);

		// Wait for Sometime
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// Wait for Prices to be displayed
		// Breaking the Xpath
		String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

		// Breaking the Xpath
		String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";

		// for looping the Xpath
		for (int i = 1; i < 7; i++) {
			// Appending the Xpath
			String actualXpath = beforeXpath + i + afterXpath;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath));

			// Comparing the Term from UI with Existing Opportunity Term
			if (element.getAttribute("value").equals(priceTerm)) {
				System.out.println("Term:" + element.getText());
				productSelectBtn.get(i - 1).click();
				functions.vshortWait();
			}
		}

		for (int j = 1; j < 7; j++) {
			// Appending the Xpath
			String actualXpath1 = beforeXpath + j + afterXpath;

			// Passing xpath to WebElement
			WebElement element1 = driver.findElement(By.xpath(actualXpath1));

			if (element1.getAttribute("value").equals(priceTerm1)) {
				System.out.println("Term:" + element1.getText());
				productSelectBtn.get(j - 2).click();
				functions.shortWait();
				// Enter Margin value
				String xpath1 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath2 = "]/div/div[2]/div[7]/input";

				String xpath3 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath4 = "]/div/div[2]/div[8]/input";

				String actualXpath = xpath1 + j + xpath2;

				String actualXpath2 = xpath3 + j + xpath4;
				// // Passing xpath to WebElement
				WebElement element0 = driver.findElement(By.xpath(actualXpath));
				WebElement element2 = driver.findElement(By.xpath(actualXpath2));
				// Passing xpath to WebElement
				element0.sendKeys(Keys.BACK_SPACE);
				element0.sendKeys(Margin);

				element2.sendKeys(Keys.BACK_SPACE);
				element2.sendKeys(DOAMargin);

				// Click on Calculate and Save Button
				functions.click(driver, calculateAndSave);
				WebDriverWait wait1 = new WebDriverWait(driver, 200);
				wait1.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

			}

		}

	}

	public void multipletermsproduct(String Term1, String Margin1, String DOAMargin1, String BrokerFee1, String Term2,
			String Margin2, String DOAMargin2, String BrokerFee2, String Term3, String Margin3, String DOAMargin3,
			String BrokerFee3, String Term4, String Margin4, String DOAMargin4, String BrokerFee4)
			throws InterruptedException {
		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		functions.longWait();
		TermField.get(1).click();
		TermField.get(1).clear();
		TermField.get(1).sendKeys(Term1);
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(2).click();
		TermField.get(2).clear();
		TermField.get(2).sendKeys(Term2);
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(3).click();
		TermField.get(3).clear();
		TermField.get(3).sendKeys(Term3);
		functions.shortWait();

		// Click on Term Field and Replacing the Text with 19 Month Term in Quotes PAge
		TermField.get(4).click();
		TermField.get(4).clear();
		TermField.get(4).sendKeys(Term4);
		functions.shortWait();

		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);

		// Wait for Sometime
		functions.midWait();

		// Select a product
		if (productSelectBtn.size() > 0 == true && productSelectBtn.get(1).isDisplayed() == true) {
			productSelectBtn.get(1).click();
		}

	}
	
	public void quotestab(int Rowvalue) throws InterruptedException {	
		int a= Rowvalue;
		try {	
			if(AddCustomerbanner.isDisplayed()==true) {
			System.out.println("Customer issue");
			}	
			}catch(Exception n7){
			try {
				if(CreateCustomerbanner.isDisplayed()==true) {
					System.out.println("Customer issue");
			}
		}catch(Exception n1) {
			try {
				if(siteerror.isDisplayed()==true) {
				System.out.println("siteerror");
			}
			}catch(Exception n){
				
		try {	
			if(Sitesnotadded.isDisplayed()==true) {
			
				//Create an object of FileInputStream class to read excel file
    	        FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

    	// Create object of XSSFWorkbook class
    	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

    	// Read excel sheet by sheet name
    	        XSSFSheet sheet = workbook.getSheet("Data");

    	// Get the Cell at index  from the above row
    	        XSSFCell cell = sheet.getRow(a+1).getCell(55);

    	        cell.setCellType(CellType.STRING);
    	        cell.setCellValue("Sites not added");        
    	        
    	        
    	// Write the output to the file
    	        FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
    	        workbook.write(fileOut);

    	        System.out.println("Id column in Excel is updated successfully");
    	        fileOut.close();

    	// Closing the workbook
    	        workbook.close();
  		
			}
			}catch(Exception n6){	
		
				 if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
			            Popupclose.get(4).click();
			            functions.vshortWait();
			        }

		// Navigate to quotes page
		WebDriverWait wait1 = new WebDriverWait(driver, 400);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Quotes')]")));
		functions.click(driver, quotesTAB);
		// Wait for spinner to appear when request is made to Siebel
		
		// Wait for few minutes
	

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
	}
	}
		}
			}
        }
		
	public void addterm(String Term1,String customterm) throws InterruptedException {
//		try {	
//			if(AddCustomerbanner.isDisplayed()==true) {
//				System.out.println("Customer issue");
//			}
//		}catch(Exception n2){
//			
//			try {
//				if(CreateCustomerbanner.isDisplayed()==true) {
//					System.out.println("Customer issue");
//				}
//			}catch(Exception n1) {
//				try {	
//					if(siteerror.isDisplayed()==true) {
//						System.out.println("siteerror");
//					}
//				}catch(Exception n){
//			try {	
//				if(Sitesnotadded.isDisplayed()==true) {
//					System.out.println("Sites not added");
//				}
//			}catch(Exception n6){				
    //    functions.click(driver, quotesTAB);
		 
        try {
        	if(fullproduct.get(0).isDisplayed()==true) {
        
      //  functions.intermediatewait();
        // Wait for spinner to appear when request is made to Siebel
        functions.vshortWait();
        if (Popupclose.size() > 0 == true && Popupclose.get(4).isDisplayed() == true) {
            Popupclose.get(4).click();
            functions.vshortWait();
        }

        if ((customterm).equals("Yes"))
        {
        // Wait for Sometime
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
//Entering the value in last term
        for (int j = fullproduct.size(); j < fullproduct.size()+1; j++) {
            String xpath1 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
            String xpath2 = "]/div/div[1]/div[2]/input";

            String actualXpath1 = xpath1 + j + xpath2;
            WebElement element0 = driver.findElement(By.xpath(actualXpath1));
            
            
            
            element0.clear();
            element0.sendKeys(Term1);
         //   functions.intermediatewait();

            
            // Click on Calculate and Save Button
            functions.click(driver, calculateAndSave);
            WebDriverWait wait1 = new WebDriverWait(driver, 800);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
            //Add term button
            functions.click(driver,createterm);
            functions.vshortWait();
            try{
            	if(invalidterm.isDisplayed())
            	{
            		System.out.println("invalid term");
            	}
            }catch(Exception n8) {
            // Click on Calculate and Save Button
//            functions.click(driver, calculateAndSave);
//            WebDriverWait wait2 = new WebDriverWait(driver, 500);
//            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
            break; 
            }
        }
        
           }
        
        else {
        	System.out.println("No new term to be added");
        }
           
        	}
        }catch(Exception n) {
        	
        }
   
	}

  //          }
//	}
  //      }
//		}
//	}
	
	public void CalculateSavebtn () throws Throwable {
//		try{
//         	if(invalidterm.isDisplayed()==true) {        	
//         		System.out.println("invalid term");
//         	}
//         }catch(Exception n8) {
//		try {	
//			if(AddCustomerbanner.isDisplayed()==true) {
//				System.out.println("Customer issue");
//			}
//		}catch(Exception n2){
//			try {
//				if(CreateCustomerbanner.isDisplayed()==true) {
//					System.out.println("Customer issue");
//				}
//			}catch(Exception n1) {
//			try {	
//				if(Sitesnotadded.isDisplayed()==true) {
//					System.out.println("Sites not added");
//				}
//			}catch(Exception n6){
//		
//		try {	
//		if(siteerror.isDisplayed()==true) {
//			System.out.println("siteerror");
//		}
//	}catch(Exception n){
		try {
			if(calculateAndSave.isDisplayed()==true) {
		
		// Click on Calculate and Save Button
	      functions.click(driver, calculateAndSave);
		  WebDriverWait wait1 = new WebDriverWait(driver, 1000);
		  wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));
	}

    }catch(Exception n5) {
		}
		}
         //}
	//}
	
	public void BasechargeandRec ( String MeterFee,String Recvalue) throws InterruptedException {

		try {
			if(MeterFeevalue.isDisplayed()==true && recpercent.isDisplayed()==true) {
		
	// Navigate to quotes page
	functions.click(driver, quotesTAB);
	
	
	// Wait for spinner to appear when request is made to Siebel
	
	
	
		

	// Wait for Sometime
	WebDriverWait wait = new WebDriverWait(driver, 1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

	functions.selectDropdownByVisibleText(driver, MeterFeevalue,MeterFee);
		
	functions.selectDropdownByVisibleText(driver, recpercent, Recvalue);
        }
		}catch(Exception n3) {
		}
	}
	/*
	 * Price a deal with Fixed Product for PC Using Excel File.
	 */
	public void selectProduct(String priceTerm, String Margin, String DOAMargin, String BrokerFee,String Intradayadjustment) throws InterruptedException {
		 try{
         	if(invalidterm.isDisplayed()==true) {        	
         		System.out.println("invalid term");
         	}
         }catch(Exception n8) {
//		try {	
//			if(AddCustomerbanner.isDisplayed()==true) {
//				System.out.println("Customer issue");
//			}
//		}catch(Exception n2){
//			try {
//				if(CreateCustomerbanner.isDisplayed()==true) {
//					System.out.println("Customer issue");
//				}
//			}catch(Exception n1) {
//			try {	
//				if(Sitesnotadded.isDisplayed()==true) {
//					System.out.println("Sites not added");
//				}
//			}catch(Exception n6){
//		try {
//    		if(siteerror.isDisplayed()==true) {
//    		System.out.println("site error");
//    		}
//            }catch(Exception n){
            try {
            	if(fullproduct.get(0).isDisplayed()==true) {
            
    		
//		// Navigate to quotes page
//		functions.click(driver, quotesTAB);
//		
//		
//		// Wait for spinner to appear when request is made to Siebel
//		functions.vshortWait();
//		
		
    		
    
		// Wait for Sometime
	//	WebDriverWait wait = new WebDriverWait(driver, 1000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// Wait for Prices to be displayed
		// Breaking the Xpath
		String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

		// Breaking the Xpath
		String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";

		// for looping the Xpath
//		for (int i = 1; i < fullproduct.size(); i++) {
//			// Appending the Xpath
//			String actualXpath = beforeXpath + i + afterXpath;
//
//			// Passing xpath to WebElement
//			WebElement element = driver.findElement(By.xpath(actualXpath));
//
//			// Comparing the Term from UI with Existing Opportunity Term
//			if (element.getAttribute("value").equals(priceTerm)) {
//				System.out.println("Term:" + element.getText());
//
//				functions.vshortWait();
//			}
//		}

		for (int j = 1; j <= fullproduct.size(); j++) {
			// Appending the Xpath
			String actualXpath1 = beforeXpath + j + afterXpath;

			// Passing xpath to WebElement
			WebElement element1 = driver.findElement(By.xpath(actualXpath1));

			if (element1.getAttribute("value").equals(priceTerm)) {
				System.out.println("Term:" + element1.getText());

			//	functions.vshortWait();
				// Enter Margin value
				String xpath1 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath2 = "]/div/div[2]/div[7]/input";

				String xpath3 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath4 = "]/div/div[2]/div[8]/input";

				String xpath5 = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath6 = "]/div/div[2]/div[5]/input";

				String xpath7="/html/body/jhi-main/div/jhi-opportunity/div/jhi-quotes/div[1]/div/div/form/div/div[5]/div[2]/div/div[";
				String xpath8="]/div/div[2]/div[6]/input";
				
				
				String actualXpath3 = xpath5 + j + xpath6;

				String actualXpath = xpath1 + j + xpath2;

				String actualXpath2 = xpath3 + j + xpath4;
				String actualXpath4 = xpath7 + j + xpath8;
				
				// // Passing xpath to WebElement
				WebElement element0 = driver.findElement(By.xpath(actualXpath));
				WebElement element2 = driver.findElement(By.xpath(actualXpath2));
				WebElement element3 = driver.findElement(By.xpath(actualXpath3));
				WebElement element4 = driver.findElement(By.xpath(actualXpath4));
				// Passing xpath to WebElement
			
				element3.clear();
				element3.sendKeys(BrokerFee);
			//	functions.shortWait();

				element4.clear();
				element4.sendKeys(Intradayadjustment);
			//	functions.shortWait();
				
				element0.clear();
				element0.sendKeys(Margin);
			//	functions.shortWait();
				// functions.setText(driver, element0, Margin);
				element2.clear();
				element2.sendKeys(DOAMargin);
			//	functions.shortWait();

				
				// Click on Calculate and Save Button
//				functions.click(driver, calculateAndSave);
//				WebDriverWait wait1 = new WebDriverWait(driver, 500);
//				wait1.until(
//						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

			}

		} 
            }	
            }catch(Exception n4)	{
	}	
	}
	//	}
      //   }
	}
	public void selectProductcontractgeneration(String contractTerm,int Rowvalue) throws InterruptedException, IOException {
		// Wait for Prices to be displayed
				// Breaking the Xpath
				int a = Rowvalue;
				try{
		         	if(invalidterm.isDisplayed()==true) {        	
		         		System.out.println("invalid term");
		         	}
		         }catch(Exception n8) {
//				try {	
//					if(AddCustomerbanner.isDisplayed()==true) {
//						System.out.println("Customer issue");
//					}
//				}catch(Exception n2){
//					try {
//						if(CreateCustomerbanner.isDisplayed()==true) {
//							System.out.println("Customer issue");
//						}
//					}catch(Exception n1) {
//					try {	
//						if(Sitesnotadded.isDisplayed()==true) {
//							System.out.println("Sites not added");
//						}
//					}catch(Exception n6){
//			try {
//				if(siteerror.isDisplayed()==true) {
//					System.out.println("site error");
//				}
//			}catch(Exception n){
		        	 try {
		        		 if(fullproduct.get(0).isDisplayed()==true) {
				String beforeXpath = "//div[@id='QuotesScrollContainer']//div[";

				// Breaking the Xpath
				String afterXpath = "]//div[1]//div[1]//div[2]//input[1]";
				
				String approverlevelxpath1 ="/html[1]/body[1]/jhi-main[1]/div[1]/jhi-opportunity[1]/div[1]/jhi-quotes[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/div[";
				
				String approverlevelxpath2="]/div[1]/div[2]/div[11]";
		// for looping the Xpath
				for (int i = 1; i <= fullproduct.size(); i++) {
					// Appending the Xpath
					String actualXpath = beforeXpath + i + afterXpath;
		            String approverxpath= approverlevelxpath1 + i + approverlevelxpath2;
					// Passing xpath to WebElement
					WebElement element = driver.findElement(By.xpath(actualXpath));
		            WebElement approver = driver.findElement(By.xpath(approverxpath));
				
					// Comparing the Term from UI with Existing Opportunity Term
					if (element.getAttribute("value").equals(contractTerm)) 
					{
						System.out.println("Term:" + element.getAttribute("value"));
						if(approver.getText().equals("Pre-Approved")) {
						try {
							System.out.println("Approver:" + approver.getText());
						}catch(StaleElementReferenceException e) {
							System.out.println("print");
						}
						productSelectBtn.get(i - 1).click();
						
						functions.vshortWait();
					}else {
						// Create an object of FileInputStream class to read excel file
						FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

						// Create object of XSSFWorkbook class
						XSSFWorkbook workbook = new XSSFWorkbook(fis);

						// Read excel sheet by sheet name
						XSSFSheet sheet = workbook.getSheet("Data");

						// Get the Cell at index from the above row
						XSSFCell cell = sheet.getRow(a + 1).getCell(53);

						cell.setCellType(CellType.STRING);
						cell.setCellValue("Approver required");

						// Write the output to the file
						FileOutputStream fileOut = new FileOutputStream(
								new File(prop.getProperty("Excelpath")));
						workbook.write(fileOut);

						System.out.println("Id column in Excel is updated successfully");
						fileOut.close();

						// Closing the workbook
						workbook.close();
					}
				}

			}
			}
			}catch(Exception n5) {
			}
				}
		         }
//			}
}
