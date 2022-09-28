package Pages.VHOS;

import Pages.DSP.GenerateContract;
import Pages.DSP.LandingPage;
import Pages.DSP.PriceaDeal;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class VhosPage {

	@FindBy(xpath = "//a[contains(text(), 'here')]")
	WebElement clickhereButton;
	@FindBy(xpath = "//span[@id='A0486:f2:msg']")
	WebElement searchResult;
	@FindBy(xpath = "//input[@name='A3574:sff2:searchString2']")
	WebElement searchfieldinVHOS;
	@FindBy(xpath = "//span[contains(text(), 'Product')]")
	WebElement Producttab;
	@FindBy(xpath = "//span[contains(text(), 'Fixed Price-12')]")
	WebElement product;
	@FindBy(xpath="//div[contains(text(), 'Voluntary RECs')]")
	WebElement VoluntaryRecsValueinVhos;
	@FindAll(value = {@FindBy(xpath="	//input[@id='BROKER_FEEamt']")})
	public List<WebElement>Brokerfee;
	@FindBy(xpath = "//div[contains(text(), 'Base Charge')]")
	WebElement MeterfeeValueinVhos;
	@FindBy(xpath = "//div[contains(text(), 'Material Change Percent')]")
	WebElement MaterialchangeinVhos;
	@FindBy(xpath = "//div[contains(text(), 'CRR Intrazonal Hub to Load Zone')]")
	WebElement CRRinVhos;

	WebDriver driver;

	public VhosPage(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public void ValidateOpportunitydetailsinVHOS(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		System.out.println("passing the string value from Add sites to the OPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Enters Opportunity id in the Search Field
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='A3574:sff2:searchString2']")));
		functions.setText(driver, searchfieldinVHOS, Optyid);
		searchfieldinVHOS.sendKeys(Keys.ENTER);

		// Wait for Opportunity details to get displayed

		functions.shortWait();
		// Close the tab
		driver.close();

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));

	}
	public void ValidateMVPVHOS(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		System.out.println("passing the string value from Add sites to the OPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Enters Opportunity id in the Search Field
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='A3574:sff2:searchString2']")));
		functions.setText(driver, searchfieldinVHOS, Optyid);
		searchfieldinVHOS.sendKeys(Keys.ENTER);
		functions.intermediatewait();
		 functions.click(driver, Producttab);
		 functions.vshortWait();
		 functions.click(driver, product);
		 functions.vshortWait();
		 if (Brokerfee.size() >= 0 == true && Brokerfee.get(0).isDisplayed() == true) {
				System.out.println("Brokerfee is displayed");
			}
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", VoluntaryRecsValueinVhos);
			System.out.println("Vol Recs is displayed");
//			if (VoluntaryRecsValueinVhos.isEnabled()) {
//			System.out.println("pricing link is displayed");
//				return true;
//			}
	//
//			if (MeterfeeValueinVhos.isEnabled()) {
//				System.out.println("pricing link is displayed");
//				return true;
//			}
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
		
}
}