package Pages.DSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class SendOutlookEmail {

	@FindBy(xpath = "//nav[@aria-label='Quick links']//a[@class='internal sign-in-link'][normalize-space()='Sign in']")
	WebElement SigninBtn;
	@FindBy(xpath = "//span[@id='id__6']")
	WebElement NewMessageBtn;
	@FindBy(xpath = "//input[@aria-label='To']")
	WebElement EmailField;
	@FindBy(xpath = "//i[@class='ms-Icon root-89 css-166 ms-Button-menuIcon _3Hrha_4tOTCtzxXmTXUWxz menuIcon-171'][contains(text(),'')]")
	WebElement AttachDropdown;
	@FindBy(xpath = "//span[normalize-space()='Browse this computer']")
	WebElement BrowsecomputerBtn;
	@FindAll(value = {
			@FindBy(xpath = "//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[3]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]") })
	public List<WebElement> Emaillink;
	@FindBy(xpath = "//input[@placeholder='Add a subject']")
	WebElement SubjectField;
	@FindBy(xpath = "//div[@aria-label='Message body']//div")
	WebElement MessageField;
	@FindAll(value = { @FindBy(xpath = "//span[contains(text(),'Send')]") })
	public List<WebElement> SendBtn;
	private Base base;
	WebDriver driver;

	public SendOutlookEmail(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	LandingPage MSPopup = new LandingPage(base);
	Putsbox putsbox = new Putsbox(base);
	/*
	 * Send Extent Report to Stakeholders
	 */

	public void SendEmail() throws InterruptedException, AWTException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//nav[@aria-label='Quick links']//a[@class='internal sign-in-link'][normalize-space()='Sign in']")));

		functions.click(driver, SigninBtn);

		try {

			// Wait for Username field
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='loginfmt']")));
			driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(prop.getProperty("Username1"));
			// Wait for Next Button
			WebDriverWait wait0 = new WebDriverWait(driver, 10);
			wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
			functions.shortWait();
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_D);
//			robot.keyRelease(KeyEvent.VK_D);
//			robot.keyPress(KeyEvent.VK_H);
//			robot.keyRelease(KeyEvent.VK_H);
//			robot.keyPress(KeyEvent.VK_U);
//			robot.keyRelease(KeyEvent.VK_U);
//			robot.keyPress(KeyEvent.VK_S);
//			robot.keyRelease(KeyEvent.VK_S);
//			robot.keyPress(KeyEvent.VK_A);
//			robot.keyRelease(KeyEvent.VK_A);
//			robot.keyPress(KeyEvent.VK_S);
//			robot.keyRelease(KeyEvent.VK_S);
//		
//
//			functions.vshortWait();
//
//			robot.keyPress(KeyEvent.VK_TAB);
//
//			functions.vshortWait();
//
//			robot.keyPress(KeyEvent.VK_SHIFT);
//			robot.keyPress(KeyEvent.VK_M);
//			robot.keyRelease(KeyEvent.VK_M);
//			robot.keyRelease(KeyEvent.VK_SHIFT);
//			robot.keyPress(KeyEvent.VK_O);
//			robot.keyRelease(KeyEvent.VK_O);
//			robot.keyPress(KeyEvent.VK_R);
//			robot.keyRelease(KeyEvent.VK_R);
//			robot.keyPress(KeyEvent.VK_N);
//			robot.keyRelease(KeyEvent.VK_N);
//			robot.keyPress(KeyEvent.VK_I);
//			robot.keyRelease(KeyEvent.VK_I);
//			robot.keyPress(KeyEvent.VK_N);
//			robot.keyRelease(KeyEvent.VK_N);
//			robot.keyPress(KeyEvent.VK_G);
//			robot.keyRelease(KeyEvent.VK_G);
//			robot.keyPress(KeyEvent.VK_1);
//			robot.keyRelease(KeyEvent.VK_1);
//			robot.keyPress(KeyEvent.VK_5);
//			robot.keyRelease(KeyEvent.VK_5);
//			robot.keyPress(KeyEvent.VK_0);
//			robot.keyRelease(KeyEvent.VK_0);
//		
//			Thread.sleep(2000);
//
//			robot.keyPress(KeyEvent.VK_ENTER);

			// Wait for password field

			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passwd']")));
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(prop.getProperty("Password1"));
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


		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='id__6']")));

		functions.click(driver, NewMessageBtn);

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='To']")));

		functions.setText(driver, EmailField, "umesh.parthipan@nrg.com");
		functions.shortWait();
		EmailField.sendKeys(Keys.ENTER);
		functions.intermediatewait();

		functions.click(driver, EmailField);
		functions.setText(driver, EmailField, "rajesh.vittalkumar@nrg.com");
		functions.shortWait();
		EmailField.sendKeys(Keys.ENTER);

//		WebDriverWait wait3 = new WebDriverWait(driver, 50);
//		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//i[@class='ms-Icon root-89 css-166 ms-Button-menuIcon _3Hrha_4tOTCtzxXmTXUWxz menuIcon-171'][contains(text(),'')]")));
//
//		functions.click(driver, AttachDropdown);
//
//		WebDriverWait wait4 = new WebDriverWait(driver, 50);
//		wait4.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Browse this computer']")));
//
//		functions.click(driver, BrowsecomputerBtn);

		// choosing the file to upload
//		String pdffile = System.getProperty("user.dir");
//
//		StringSelection ss = new StringSelection(
//				pdffile + "\\test-output\\TestSummaryReport.html");
//
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		try {
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_V);
//			r.keyRelease(KeyEvent.VK_V);
//			r.keyRelease(KeyEvent.VK_CONTROL);
//
//			r.keyPress(KeyEvent.VK_ENTER);
//			r.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//		} catch (AWTException | InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.out.println("exception on send attchement");
//		}

		WebDriverWait wait5 = new WebDriverWait(driver, 50);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Add a subject']")));

		functions.click(driver, SubjectField);
		functions.setText(driver, SubjectField, "Common Sharepoint for Extent Report");

		functions.vshortWait();

		String Path = "\\houfip01\\BusinessDir\\Sriram\\ExtentReports";
		Path.replaceAll("\\\\\\\\", "\\\\");

		functions.click(driver, MessageField);
		functions.setText(driver, MessageField, "\\" + Path);

		functions.vshortWait();

		SendBtn.get(1).click();

	}
}
