package Pages.DSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import auth.FetchToken;

public class SendOutlookEmail {

	@FindBy(xpath = "//nav[@aria-label='Quick links']//a[@class='internal sign-in-link'][normalize-space()='Sign in']")
	WebElement SigninBtn;
	@FindBy(xpath = "//span[contains(text(),'New message')]")
	WebElement NewMessageBtn;
	@FindBy(xpath = "//div[@aria-label='To']")
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
	@FindBy(xpath = "//div[contains(text(), 'Use a verification code')]")
	WebElement verifyBtn;
	@FindBy(xpath = "//input[@class='win-button button_primary button ext-button primary ext-primary']")
	WebElement NextBtn;
	@FindBy(xpath = "//span[contains(text(), 'Attach')]")
	WebElement attachbtn;
	
	@FindBy(xpath = "//span[contains(text(), 'Browse this computer')]")
	WebElement BrowsethisComputer;
	private Base base;
	WebDriver driver;
	CommonFunctions functions = new CommonFunctions();
	CommonFunctions encryption = new CommonFunctions();
	FetchToken token = new FetchToken();
	public SendOutlookEmail(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	LandingPage MSPopup = new LandingPage(base);
	Putsbox putsbox = new Putsbox(base);
	/*
	 * Send Extent Report to Stakeholders
	 */

	public void SendEmail() throws InterruptedException, AWTException, IOException {
		WebDriverWait wait12 = new WebDriverWait(driver, 150);
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//nav[@aria-label='Quick links']//a[@class='internal sign-in-link'][normalize-space()='Sign in']")));

		functions.click(driver, SigninBtn);
		try {
		
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		String DSPPassword;
		// Wait for Username field
		Robot robot = new Robot();

		WebDriverWait wait = new WebDriverWait(driver, 140);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='loginfmt']")));
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys(prop.getProperty("Username"));
		// Wait for Next Button
		WebDriverWait wait0 = new WebDriverWait(driver, 140);
		wait0.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		// Wait for password field
		WebDriverWait wait1 = new WebDriverWait(driver, 400);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='passwd']")));
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		DSPPassword = encryption.DspEncryption();
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(DSPPassword);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		functions.vshortWait();
	} catch (InterruptedException | AWTException e1) {

		e1.printStackTrace();
	}

	try {

		if (verifyBtn.isDisplayed() == true) {

			// Getting Token from Get Otp Method
			String DAccesskey = encryption.AccessKeyEncryption();
			
functions.click(driver, verifyBtn);
functions.shortWait();
			// Entering code from Authenticator App
			WebDriverWait wait5 = new WebDriverWait(driver, 100);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otc']")));
			String tkn = token.getOtp(DAccesskey);		
			driver.findElement(By.xpath("//input[@name='otc']")).sendKeys(tkn);

			// Click on Verify Button
			WebDriverWait wait4 = new WebDriverWait(driver, 100);
			wait4.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@id='idSubmit_SAOTCC_Continue']")));
			driver.findElement(By.xpath("//input[@id='idSubmit_SAOTCC_Continue']")).click();
//		driver.findElement(By.id("token")).sendKeys(tkn);

			// Wait for sign in button
			WebDriverWait wait10 = new WebDriverWait(driver, 500);
			wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		}

	} catch (Exception e) {
		e.getMessage();
	}

	try {

		if (NextBtn.isDisplayed()) {

			driver.findElement(
					By.xpath("//input[@class='win-button button_primary button ext-button primary ext-primary']"))
					.click();

			// Wait for sign in button
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idSIButton9']")));
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		}
	}

	catch (Exception e) {
		e.getMessage();
	}


		WebDriverWait wait1 = new WebDriverWait(driver, 150);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New message')]")));

		functions.click(driver, NewMessageBtn);

		WebDriverWait wait2 = new WebDriverWait(driver, 150);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='To']")));

		functions.setText(driver, EmailField, "umesh.parthipan@nrg.com");
		functions.shortWait();
		EmailField.sendKeys(Keys.ENTER);
		functions.intermediatewait();

		functions.click(driver, EmailField);
		functions.setText(driver, EmailField, "rajesh.vittalkumar@nrg.com");
		functions.shortWait();
		EmailField.sendKeys(Keys.ENTER);



		WebDriverWait wait5 = new WebDriverWait(driver, 50);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Add a subject']")));

		functions.click(driver, SubjectField);
		functions.setText(driver, SubjectField, "Regression Extent Report");

		functions.vshortWait();

		functions.click(driver, attachbtn);
functions.shortWait();
functions.click(driver, BrowsecomputerBtn);
		// choosing the file to upload
        String pdffile = System.getProperty("user.dir");

        StringSelection ss = new StringSelection(
                pdffile + "\\Extenteport&Screenshot\\TestforE2E106.html");
     //   /NRGAutomation/Extenteport&Screenshot/TestforE2E106.html
   //     /NRGAutomation/src/test/resources/DataReader/Broker Contract Document.pdf
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_CONTROL);
         
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);

            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
        } catch (AWTException | InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.println("exception on send attchement");
        }
functions.vshortWait();

		SendBtn.get(1).click();

	}
}
