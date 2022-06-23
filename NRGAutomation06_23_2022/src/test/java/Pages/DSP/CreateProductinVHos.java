package Pages.DSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CreateProductinVHos {

	@FindBy(xpath = "//button[contains(text(),'Quotes ')]")
	WebElement QuotesTab;
	@FindBy(xpath = "//span[@class='mdi mdi-open-in-new brand-primary quotes-complex-product']")
	WebElement DSPProductBtn;
	@FindBy(xpath = "//li[contains(text(),'Fixed Price No Settlement')]")
	WebElement FixedProductBtn;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-arrow-1-e']")
	WebElement RightarrowBtn;
	@FindBy(xpath = "//input[@name='A3004:f1:j_idt19']")
	WebElement AllSitesBtn;
	@FindBy(xpath = "//input[@value='Site']")
	WebElement SiteBtn;
	@FindBy(xpath = "//input[@id='A3004:f1:j_idt27']")
	WebElement Startdatefield;
	@FindBy(xpath = "//input[@id='A3004:f1:j_idt30']")
	WebElement Termfield;
	@FindBy(xpath = "//input[@value='Preview']")
	WebElement PreviewBtn;
	@FindBy(xpath = "//input[@id='A3004:f1:pWPPrtlet:autoCalc']")
	WebElement AutoCalcCheckbox;
	@FindBy(xpath = "//input[@value='Create']")
	WebElement CreateBtn;
	@FindBy(xpath = "//span[contains(text(),' Deal Option')]")
	WebElement DealOptionBtn;
	@FindBy(xpath = "//select[@id='A4583:j_idt6:sPortlet:_t35']")
	WebElement dropdownforsendtosiebel;
	@FindBy(xpath = "//input[@value='Go']")
	WebElement GOBtn;
	@FindBy(xpath = "//input[@id='A4583:j_idt6:sPortlet:dealName']")
	WebElement Dealoptionnamefield;
	@FindBy(xpath = "//input[@id='A4583:j_idt6:sPortlet:save']")
	WebElement SaveBtn;
	@FindBy(xpath = "//input[@id='A4583:j_idt6:prschPrtlet:prschTable:0:j_idt50']")
	WebElement checkbox;
	@FindBy(xpath = "//input[@value='Build Deal']")
	WebElement BUildDealBtn;
	@FindBy(xpath = "//span[@id='A4583:j_idt6:sPortlet:dotbl:0:_t22']")
	WebElement Dealoptionnamehyperlink;
	@FindBy(xpath = "//input[@id='A4583:j_idt6:sPortlet:dotbl:0:j_idt20']")
	WebElement checkbox1;
	@FindBy(xpath = "//button[contains(text(),'Deal Options' )]")
	WebElement DealOptions;
	@FindBy(xpath = "//button[contains(text(),'Get Executable Approval ')]")
	WebElement GetExecutableHyperlink;
	@FindBy(xpath = "//span[contains(text(),'Pending Executable Approval ')]")
	WebElement PendingExecutable;
	@FindBy(xpath = "//span[contains(text(),' Product')]")
	WebElement productBtn;
	@FindBy(xpath = "//span[@id='A3175:sPortlet:pl1:fpTable:0:j_idt20']")
	WebElement producthyperlink;
	@FindBy(xpath = "//input[@name='MARGINamt']")
	WebElement Marginfield;
	@FindBy(xpath = "//input[@name='MARGIN']")
	WebElement DOAMarginfield;
	@FindAll(value = { @FindBy(xpath = "//img[@alt='Calculate Product']") })
	public List<WebElement> calculateproduct;
	
	
	WebDriver driver;

	public CreateProductinVHos(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Create Product in VHos
	 */
	public void CreateProductinvhos() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		Actions action = new Actions(driver);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		functions.click(driver, QuotesTab);

		functions.vshortWait();

		functions.click(driver, DSPProductBtn);

		// Navigate to Vhos

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		functions.intermediatewait();

		functions.click(driver, FixedProductBtn);

		functions.vshortWait();

		functions.click(driver, RightarrowBtn);

		functions.vshortWait();

		functions.click(driver, AllSitesBtn);

		functions.vshortWait();

		functions.click(driver, SiteBtn);

		functions.vshortWait();

		functions.setText(driver, Startdatefield, "June2022");

		functions.vshortWait();

		functions.setText(driver, Termfield, "24");

		functions.vshortWait();

		functions.click(driver, PreviewBtn);

		functions.vshortWait();

		functions.click(driver, AutoCalcCheckbox);

		functions.vshortWait();

		functions.click(driver, CreateBtn);

		functions.intermediatewait();

		functions.click(driver, DealOptionBtn);

		functions.intermediatewait();

		functions.selectDropdownByVisibleText(driver, dropdownforsendtosiebel, "New");

		functions.vshortWait();

		functions.click(driver, GOBtn);

		functions.vshortWait();

		functions.setText(driver, Dealoptionnamefield, "Test PJM");

		functions.vshortWait();

		functions.click(driver, SaveBtn);

		functions.vshortWait();

		functions.click(driver, checkbox);

		functions.vshortWait();

		functions.click(driver, BUildDealBtn);

		functions.vshortWait();

		functions.click(driver, checkbox1);

		functions.vshortWait();

		functions.selectDropdownByVisibleText(driver, dropdownforsendtosiebel, "SendToSiebel");

		functions.vshortWait();

		functions.click(driver, GOBtn);

		functions.vshortWait();
		
		functions.click(driver, productBtn);
		
		functions.vshortWait();
		
		functions.click(driver, producthyperlink);
		
		
		functions.midintermediatewait();
		
		functions.setText(driver, Marginfield, "8");
		
		functions.vshortWait();
		
		functions.setText(driver, DOAMarginfield, "8");
		
		functions.vshortWait();
		
		calculateproduct.get(1).click();
		
		functions.midintermediatewait();
		
		WebDriverWait wait9 = new WebDriverWait(driver, 200);
		wait9.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Pre-Approved')]")));

		functions.Closedriver(driver);

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
		
		driver.navigate().refresh();
		
		WebDriverWait wait6 = new WebDriverWait(driver, 200);
		wait6.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Deal Options' )]")));
		
		functions.midintermediatewait();
		
		functions.click(driver, DealOptions);
		
		WebDriverWait wait7 = new WebDriverWait(driver, 800);
		wait7.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Get Executable Approval ')]")));
		functions.click(driver, GetExecutableHyperlink);
		
		WebDriverWait wait90 = new WebDriverWait(driver, 800);
		wait90.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Pending Executable Approval ')]")));
		

	}

}
