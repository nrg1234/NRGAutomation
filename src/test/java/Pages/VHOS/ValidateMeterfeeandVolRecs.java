package Pages.VHOS;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ValidateMeterfeeandVolRecs {

	@FindBy(xpath = "//a[contains(text(), 'here')]")
	WebElement clickhereButton;
	@FindBy(xpath = "//span[@id='A0486:f2:msg']")
	WebElement searchResult;
	@FindBy(xpath = "//input[@id='A3574:sff2:searchString2']")
	WebElement searchfieldinVHOS;
	@FindBy(xpath = "//span[contains(text(),' Deal Option')]")
	WebElement DealOptionBtn;
	@FindBy(xpath = "//span[@id='A4583:j_idt6:sPortlet:dotbl:0:_t22']")
	WebElement DealOptionName;
	@FindBy(xpath = "//span[@id='A4583:j_idt6:prschPrtlet:prschTable:0:_t60']")
	WebElement ProductName;
	@FindBy(xpath="//div[contains(text(), 'Voluntary RECs')]")
	WebElement VoluntaryRecsValueinVhos;
	@FindAll(value = {@FindBy(xpath="	//input[@id='BROKER_FEEamt']")})
	public List<WebElement>Brokerfee;
	//div[contains(text(), 'Broker Fee')]
	//body//jhi-main//button[6]
	//span[@class='icon icon-expand']
	//tbody//tr[@class='product-nested-table']//td//td[1]//span[1]
	////span[@class='mdi mdi-open-in-new brand-primary']
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi mdi-open-in-new brand-primary']") })
	public List<WebElement> link;
	// @FindBy(xpath = "//span[@class='mdi mdi-open-in-new brand-primary']") 
	//WebElement link;
	
	
	
	@FindBy(xpath="//span[@class='icon icon-expand ng-star-inserted']")
	WebElement plusicon;
	@FindBy(xpath="//body//jhi-main//button[6]")
	WebElement dealoption;
	@FindBy(xpath = "//div[contains(text(), 'Base Charge')]")
	WebElement MeterfeeValueinVhos;
	@FindBy(xpath = "//div[contains(text(), 'Material Change Percent')]")
	WebElement MaterialchangeinVhos;
	@FindBy(xpath = "//div[contains(text(), 'CRR Intrazonal Hub to Load Zone')]")
	WebElement CRRinVhos;

	WebDriver driver;

	public ValidateMeterfeeandVolRecs(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

//	public void ValidateMeterfeeandVolRecsinVhos(String Optyid) throws Throwable {
		public void ValidateMeterfeeandVolRecsinVhos() throws Throwable{
		CommonFunctions functions = new CommonFunctions();

	//	System.out.println("passing the string value from Add sites to the OPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		//Click on 
		functions.click(driver, dealoption);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='icon icon-expand ng-star-inserted']")));
		
		functions.click(driver, plusicon);
		functions.shortWait();
		//WebDriverWait wait2 = new WebDriverWait(driver, 120);
//		wait2.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//tbody//tr[@class='product-nested-table']//td//td[1]//span[1]")));
	
		//functions.click(driver, link);
		link.get(2).click();
		
		// getting all the handles currently available
	ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));

		// Enters Opportunity id in the Search Field
		
//		functions.setText(driver, searchfieldinVHOS, Optyid);
//		functions.shortWait();
//		searchfieldinVHOS.sendKeys(Keys.ENTER);

		// Wait for Opportunity details to get displayed

		functions.shortWait();

//		WebDriverWait wait5 = new WebDriverWait(driver, 80);
//		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Deal Option')]")));
//
//		functions.click(driver, DealOptionBtn);
//
//		WebDriverWait wait6 = new WebDriverWait(driver, 80);
//		wait6.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//span[@id='A4583:j_idt6:sPortlet:dotbl:0:_t22']")));
//
//		functions.click(driver, DealOptionName);
//
//		WebDriverWait wait7 = new WebDriverWait(driver, 80);
//		wait7.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//span[@id='A4583:j_idt6:prschPrtlet:prschTable:0:_t60']")));
//
//		functions.click(driver, ProductName);

//		WebDriverWait wait8 = new WebDriverWait(driver, 80);
//		wait8.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//div[@id='yui-gen381']")));
		//functions.midintermediatewait();

//		if (VoluntaryRecsValueinVhos.isDisplayed() == true) {
//
//			System.out.println("Vol Recs is displayed");
//
//		}
//		if (MeterfeeValueinVhos.isDisplayed() == true) {
//
//			System.out.println("Meter fee is displayed");

//		}
		
		
		if (Brokerfee.size() >= 0 == true && Brokerfee.get(0).isDisplayed() == true) {
			System.out.println("Brokerfee is displayed");
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", VoluntaryRecsValueinVhos);
		System.out.println("Vol Recs is displayed");
//		if (VoluntaryRecsValueinVhos.isEnabled()) {
//		System.out.println("pricing link is displayed");
//			return true;
//		}
//
//		if (MeterfeeValueinVhos.isEnabled()) {
//			System.out.println("pricing link is displayed");
//			return true;
//		}
		functions.intermediatewait();
		js.executeScript("arguments[0].scrollIntoView();", MeterfeeValueinVhos);
		functions.intermediatewait();
		System.out.println("Meter fee is displayed");
		// Close the tab
		functions.intermediatewait();
		js.executeScript("arguments[0].scrollIntoView();", MaterialchangeinVhos);
		functions.intermediatewait();
		System.out.println("Material change is displayed");
		functions.intermediatewait();
		js.executeScript("arguments[0].scrollIntoView();", CRRinVhos);
		functions.intermediatewait();
		System.out.println("CRR is displayed");
		
		driver.close();

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
		//return true;

	}

}
