package Pages.DSP;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.ApplicationHooks;
import apphooks.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

public class LandingPage  {
	CommonFunctions functions = new CommonFunctions();
	@FindBy(xpath = "//button[contains(text(), 'Clear Filters')]")
	WebElement clearFilterBtn;
	@FindBy(xpath = "//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']")
	WebElement wolrToggle;
	@FindBy(xpath = "//a[contains(text(),'All Opportunities')]")
	WebElement Allopportunitiesbtn;
	WebDriver driver;

	public LandingPage(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Navigate to DSP
	 */
	public void launchurl() throws InterruptedException, AWTException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		String url = prop.getProperty("dsp-url");
		String Browser=prop.getProperty("browser");

		switch (url) {
		case "https://test1-dsp.nrg.com/":
		driver.get(url);
			functions.cloudlogin();
			if (driver.getTitle().equals("Sign in to your account")) {
				Signin();
			}
			break;

		case "https://txlinwdkd02.nrgenergy.com/":
			driver.get(url);
			if (driver.getTitle().equals("Privacy error")) {
				AdvancedOptions();
			}
			functions.cloudlogin1();
			
			if (driver.getTitle().equals("Sign in to your account")) {
				Signin();
			}
			break;
			}
	
	}

	/*
	 * Navigate to Outlook
	 */
	public void launchoutlook() throws InterruptedException {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		String url = prop.getProperty("Outlook-url");
		
		driver.get(url);
	}
		
	
	/*
	 * This Method is for clicking on Advanced Options Button and hyperlink to DSP
	 * Url navigation in Dev Environment
	 */
	public void AdvancedOptions() {
		// Wait for Details Button
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='details-button']")));
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		// Wait for Proceed link
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='proceed-link']")));
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

	}

	/*
	 * This Method is for passing User Credentials in Dev Environment
	 */
	public void Signin() throws InterruptedException {
		try {
			ConfigReader config = new ConfigReader();
			Properties prop = config.init_properties();
			// Wait for Username field
			Robot robot =new Robot();
//			robot.keyPress(KeyEvent.VK_ESCAPE);
//			robot.keyRelease(KeyEvent.VK_ESCAPE);

			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='loginfmt']")));
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(prop.getProperty("Username"));
			// Wait for Next Button
			WebDriverWait wait0 = new WebDriverWait(driver, 40);
			wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
			// Wait for password field
			WebDriverWait wait1 = new WebDriverWait(driver, 40);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passwd']")));
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(prop.getProperty("Password"));
			functions.vshortWait();
		} catch (InterruptedException | AWTException e1) {

			e1.printStackTrace();
		}
		try {
			driver.findElement(
					By.xpath("//input[@class='win-button button_primary button ext-button primary ext-primary']"))
					.click();
			// Wait for sign in button
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
	}
	
	/*
	 * This Method is for passing User Credentials in Dev Environment
	 */
	public void SigninDSP() throws InterruptedException {
		try {
			ConfigReader config = new ConfigReader();
			Properties prop = config.init_properties();
			driver.findElement(By.tagName("body")).sendKeys("keys.ESCAPE");
			// Wait for Username field
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='loginfmt']")));
			driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(prop.getProperty("Username2"));
			// Wait for Next Button
			WebDriverWait wait0 = new WebDriverWait(driver, 40);
			wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
			driver.findElement(By.tagName("body")).sendKeys("keys.ESCAPE");
			// Wait for password field
			WebDriverWait wait1 = new WebDriverWait(driver, 40);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passwd']")));
			driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(prop.getProperty("Password2"));
			functions.vshortWait();
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		try {
			driver.findElement(
					By.xpath("//input[@class='win-button button_primary button ext-button primary ext-primary']"))
					.click();
			// Wait for sign in button
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}
	}

	/*
	 * validate the Title
	 */
	public void TitleValidation() {

		if (driver.getTitle().equals("Digital Services Platform")) {
			System.out.println("Verification Successful - The correct title is displayed on the web page");
		} else {
			System.out.println("Verification Failed - An incorrect title is displayed on the web page");
		}
	}

	/*
	 * Clicks on AllOpportunities in DSP
	 */
	public void AllOpportunities() throws InterruptedException {
		// Wait for AllOpportunities
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Opportunities')]")));
		functions.click(driver, Allopportunitiesbtn);
		// Wait for AllOpportunities
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Clear Filters')]")));
		functions.click(driver, clearFilterBtn);
		System.out.println("WOLR VIEW TOGGLE is disabled");
	}
		public void AllOpportunitiesmultiple() throws InterruptedException {
          // Wait for AllOpportunities
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Opportunities')]")));
			functions.click(driver, Allopportunitiesbtn);
	}
}
