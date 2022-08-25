package Pages.VHOS;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class ValidateOpportunityStatusVhos {
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
	@FindBy(xpath = "//div[contains(text(), 'Voluntary RECs')]")
	WebElement VoluntaryRecsValueinVhos;
	@FindBy(xpath = "//span[@id='A0486:f2:j_idt25:j_idt26:j_idt27:0:j_idt28:_t30']/b")
	WebElement OpportunityinVhos;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement OpportunityStatusinVhos;
	

	// span[@id='A0486:f2:j_idt25:j_idt26:j_idt27:0:j_idt28:_t30']/b
	WebDriver driver;

	public ValidateOpportunityStatusVhos(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public void ValidateOptyStatusinVhos(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Enters Opportunity id in the Search Field
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='A3574:sff2:searchString2']")));
		functions.midintermediatewait();
		functions.setText(driver, searchfieldinVHOS, Optyid);
		functions.shortWait();
		searchfieldinVHOS.sendKeys(Keys.ENTER);

		// Wait for Opportunity details to get displayed

		functions.shortWait();

		functions.click(driver, OpportunityinVhos);

		WebDriverWait wait7 = new WebDriverWait(driver, 80);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),'Cancel')]")));

		if (OpportunityStatusinVhos.isDisplayed() == true) {

			System.out.println("Opportunity Status is displayed as Cancel");

			// Wait for Opportunity details to get displayed

			functions.shortWait();
			// Close the tab
			driver.close();

			// switch to the parent window
			driver.switchTo().window(tabs2.get(0));

		}
	}
}
