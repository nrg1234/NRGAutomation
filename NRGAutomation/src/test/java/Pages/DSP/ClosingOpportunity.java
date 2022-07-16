package Pages.DSP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
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

public class ClosingOpportunity {

	@FindBy(xpath = "//select[@id='cancelReason']")
	WebElement CancellationReasonDropdown;
	@FindBy(xpath = "//button[contains(text(),'Cancel Opportunity')]")
	WebElement CancelOpportunityBtn;
	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	//@FindAll(value = { @FindBy(xpath = "//span[@class='mdi mdi-dots-horizontal']")})
			//public List<WebElement> ThreeDotsbtn;
	@FindBy(xpath = "//span[@class='mdi mdi-dots-horizontal']")
	WebElement ThreeDotsbtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Cancel')]") })
	public List<WebElement> CancelBtn;

	private Base base;

	Putsbox putsbox = new Putsbox(base);

	WebDriver driver;

	public ClosingOpportunity(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Closing Opportunity in DSP for Excel File.
	 */


	/*
	 * Closing Opportunity in DSP for Excel File.
	 */

	public boolean CloseOpportunity(String data) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Navigate to DSP URL
	//	putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Click on Search Button
		WebDriverWait wait9 = new WebDriverWait(driver, 500);
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='search']")));
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in the Search
		WebDriverWait wait99 = new WebDriverWait(driver, 500);
		wait99.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		functions.setText(driver, Searchplaceholder, data);

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

		functions.Wait();
		// paste
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
		functions.Wait();

//if (ThreeDotsbtn.size() >= 0 == true && ThreeDotsbtn.isDisplayed() == true) {
		try {
			if (ThreeDotsbtn.isDisplayed()) {

				// Click on ThreeDots Button
				WebDriverWait wait10 = new WebDriverWait(driver, 100);
				wait10.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-dots-horizontal']")));
				//functions.click(driver, ThreeDotsbtn);
				ThreeDotsbtn.click();
				// Wait for Sometime
				functions.Wait();

				CancelBtn.get(3).click();

				WebDriverWait wait7 = new WebDriverWait(driver, 80);
				wait7.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Cancel Opportunity')]")));

				functions.click(driver, CancellationReasonDropdown);

				functions.selectDropdownByVisibleText(driver, CancellationReasonDropdown, "Inadvertently created");

				WebDriverWait wait8 = new WebDriverWait(driver, 80);
				wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='cancelReason']")));

				functions.click(driver, CancelOpportunityBtn);
			} else {
				// Navigate to DSP URL
			//	putsbox.navigateToDSP(prop.getProperty("dsp-url"));

			}
		} catch (Exception n) {
			System.out.println("Opportunity missing");
			return false;
		}
		return true;
	}
	/*
	 * Closing Opportunity in DSP for XML File.
	 */

	public void CloseOpportunityXML(String OptyHeader) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Navigate to DSP URL
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Click on Search Button
		WebDriverWait wait9 = new WebDriverWait(driver, 100);
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='search']")));
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in the Search
		WebDriverWait wait99 = new WebDriverWait(driver, 100);
		wait99.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		functions.setText(driver, Searchplaceholder, OptyHeader);

		// Wait for Sometime
		functions.intermediatewait();

		// Click on ThreeDots Button
		WebDriverWait wait10 = new WebDriverWait(driver, 100);
		wait10.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-dots-horizontal']")));
		//functions.click(driver, ThreeDotsbtn);
		 ThreeDotsbtn.click();
		// Wait for Sometime
		functions.vshortWait();

		CancelBtn.get(3).click();

		WebDriverWait wait7 = new WebDriverWait(driver, 80);
		wait7.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Cancel Opportunity')]")));

		functions.click(driver, CancellationReasonDropdown);

		functions.selectDropdownByVisibleText(driver, CancellationReasonDropdown, "Inadvertently created");

		WebDriverWait wait8 = new WebDriverWait(driver, 80);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='cancelReason']")));

		functions.click(driver, CancelOpportunityBtn);

		// Navigate to DSP URL
		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

		// Wait for Sometime
		functions.shortWait();

		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in the Search
		functions.setText(driver, Searchplaceholder, OptyHeader);

		// Wait for Sometime
		functions.intermediatewait();

	}
}
