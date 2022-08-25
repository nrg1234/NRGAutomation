package Pages.DSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import apphooks.Base;

public class BrokerNegativeValidations {
	CommonFunctions functions = new CommonFunctions();
	String Status;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//a[@id='account-menu']//span[@class='icon icon-caret']")
	WebElement logoutdropdown;
	@FindBy(xpath = "//a[@id='logout']")
	WebElement logoutbtn;
	@FindBy(xpath = "//button[@id='bp-view-switch']")
	WebElement brokerswitchbtn;
	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindBy(xpath = "/span[@class='ml-2']")
	WebElement verifydelete;
	////span[@class='ml-2']
	//span[@class='icon icon-caret']
	////a[@id='logout']
	//locators
	WebDriver driver;

	public  BrokerNegativeValidations(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public String Addsites() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Entering values in Add sites popup
		// Entering sites
		String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
		WebElement entersite = (WebElement) js.executeScript(roo6);

		functions.setText(driver, entersite, "1008901004180002599100");
		functions.shortWait();
		// enter srt date
		String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement srtdate = (WebElement) js.executeScript(roo7);

		functions.setText(driver, srtdate, "11/01/2021");
		functions.shortWait();
//		// enter end date//Need to fix
		String roo8 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement enddate = (WebElement) js.executeScript(roo8);
		//	functions.setText(driver, enddate, "11/30/2021");
		functions.intermediatewait();
//		// enter billed kwh
//
		String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
		WebElement billedkwh = (WebElement) js.executeScript(roo9);
		functions.setText(driver, billedkwh, "6000");
		functions.shortWait();
//
//		// File upload Click on browse btn
		String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
		WebElement browsebtn = (WebElement) js.executeScript(roo10);
//		WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
		functions.click(driver, browsebtn);
		functions.mediumWait();
		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(
				pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

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

		// click submit btn
		String roo11 = " return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > div.row.pt-3 > div:nth-child(2) > button\")";
		WebElement submitbtn = (WebElement) js.executeScript(roo11);
		js.executeScript("arguments[0].scrollIntoView();", submitbtn);
		functions.click(driver, submitbtn);
		functions.midintermediatewait();

		// Click on validate sites

		String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
		WebElement  validatebtn = (WebElement) js.executeScript(roo12);
		functions.click(driver, validatebtn);
		functions.longWait();
		return null;

	}
	public void logout() throws Throwable {

		functions.click(driver, logoutdropdown);
		functions.shortWait();
		functions.click(driver, logoutbtn);

	}




	public String Addsites1() throws Throwable {

		//Adding 1000MWH sites
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String roo5 = " return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.row.mt-4.justify-content-between.ng-star-inserted > div.col-auto > div > div.d-inline-block.align-top.pt-2 > button:nth-child(3) > span\")";
		WebElement billcopybtn = (WebElement) js.executeScript(roo5);
		functions.click(driver, billcopybtn);
		functions.mediumWait();

		String roo13 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
		WebElement entersite1 = (WebElement) js.executeScript(roo13);

		functions.setText(driver, entersite1, "10443720001352539");
		functions.shortWait();
		// enter srt date
		String roo14 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement srtdate1 = (WebElement) js.executeScript(roo14);

		functions.setText(driver, srtdate1, "11/01/2021");
		functions.shortWait();
//		// enter end date//Need to fix
		String roo15 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement enddate1 = (WebElement) js.executeScript(roo15);
		//	functions.setText(driver, enddate1, "11/30/2021");
		functions.intermediatewait();
//		// enter billed kwh
//
		String roo16 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
		WebElement billedkwh1 = (WebElement) js.executeScript(roo16);
		functions.setText(driver, billedkwh1, "6000");
		functions.shortWait();
//
//		// File upload Click on browse btn
		String roo17 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
		WebElement browsebtn1 = (WebElement) js.executeScript(roo17);
//		WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
		functions.click(driver, browsebtn1);
		functions.mediumWait();
		// choosing the file to upload
		String pdffile1 = System.getProperty("user.dir");

		StringSelection ss1 = new StringSelection(
				pdffile1 + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
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

		// click submit btn
		String roo18 = " return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > div.row.pt-3 > div:nth-child(2) > button\")";
		WebElement submitbtn1 = (WebElement) js.executeScript(roo18);
		js.executeScript("arguments[0].scrollIntoView();", submitbtn1);
		functions.click(driver, submitbtn1);
		functions.midintermediatewait();

		//WebDriverWait wait23 = new WebDriverWait(driver, 60);
		//wait23.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")")));


		// Click on validate sites
//
		String roo19 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
		WebElement  validatebtn1 = (WebElement) js.executeScript(roo19);
		functions.click(driver, validatebtn1);
		//functions.longWait();
		functions.dealconversion3();


		//	String oportyid = opportunityIDText.getText();
		// Click on continue to pricing
		String roo20 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#continue-to-pricing\")";
		WebElement  continuepricingbtn1 = (WebElement) js.executeScript(roo20);
//
		functions.click(driver, continuepricingbtn1);
		functions.mediumWait();




		return null;
	}
	//Hu Error issue
	public String Addsites3() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Entering values in Add sites popup
		// Entering sites
		String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(2) > div > input\")";
		WebElement entersite = (WebElement) js.executeScript(roo6);

		functions.setText(driver, entersite, "10443720008620867");
		functions.shortWait();
		// enter srt date
		String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement srtdate = (WebElement) js.executeScript(roo7);

		functions.setText(driver, srtdate, "11/01/2021");
		functions.shortWait();
//			// enter end date//Need to fix
		String roo8 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#contract-start-date\")";
		WebElement enddate = (WebElement) js.executeScript(roo8);
		//	functions.setText(driver, enddate, "11/30/2021");
		functions.intermediatewait();
//			// enter billed kwh
		//
		String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > form > div:nth-child(4) > div:nth-child(2) > input\")";
		WebElement billedkwh = (WebElement) js.executeScript(roo9);
		functions.setText(driver, billedkwh, "6000");
		functions.shortWait();
		//
//			// File upload Click on browse btn
		String roo10 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#browse-file\")";
		WebElement browsebtn = (WebElement) js.executeScript(roo10);
//			WebElement browsebtn = shadowDom5.findElement(By.cssSelector("#browse-file"));
		functions.click(driver, browsebtn);
		functions.mediumWait();
		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(
				pdffile + "\\src\\test\\resources\\DataReader\\Broker Contract Document.pdf");

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

		// click submit btn
		String roo11 = " return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-bill-copy > div.row.pt-3 > div:nth-child(2) > button\")";
		WebElement submitbtn = (WebElement) js.executeScript(roo11);
		js.executeScript("arguments[0].scrollIntoView();", submitbtn);
		functions.click(driver, submitbtn);
		functions.midintermediatewait();

		// Click on validate sites

		String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
		WebElement  validatebtn = (WebElement) js.executeScript(roo12);
		functions.click(driver, validatebtn);
		functions.longWait();
		return null;

		//public String logout() throws Throwable {

	}     //Delete sites
	public String Addmultiplesites3() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#esids\")";
		WebElement entersite = (WebElement) js.executeScript(roo6);
		String sites="10443720000083094,10204049724438778,10204049790694685,10204049702828577";
		functions.setText(driver, entersite, sites);
		functions.shortWait();

		String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div > div.col-lg-6.col-md-12.mt-4 > button\")";
		WebElement addsites = (WebElement) js.executeScript(roo7);
		functions.click(driver,  addsites);
		functions.mediumWait();

		String roo8 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.mt-4.table-responsive.ng-star-inserted > app-sites-table > table > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(16) > button > span\")";
		WebElement deletebtn = (WebElement) js.executeScript(roo8);
		js.executeScript("arguments[0].scrollIntoView();", deletebtn);
		functions.click(driver,  deletebtn);
		functions.intermediatewait();

		String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-delete-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > button.btn.btn-danger.ng-star-inserted\")";
		WebElement yesdeletebtn = (WebElement) js.executeScript(roo9);
		functions.click(driver,  yesdeletebtn);
		functions.intermediatewait();

		js.executeScript("arguments[0].scrollIntoView();",brokerswitchbtn);
		functions.click(driver, brokerswitchbtn);
		functions.shortWait();
		functions.click(driver, brokerswitchbtn);
		functions.intermediatewait();
		functions.click(driver, brokerswitchbtn);
		functions.intermediatewait();
		functions.click(driver, sitesComponentCart);
		functions.shortWait();
		js.executeScript("arguments[0].scrollIntoView();",verifydelete);
		functions.mediumWait();
		return null;

	}
	public String Addmultiplesites8() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String roo6 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"#esids\")";
		WebElement entersite = (WebElement) js.executeScript(roo6);
		String sites="10204049724438778,10204049790694685,10204049702828577,10443720009344621,10443720006747844,10443720004351823,10443720004321735,10443720004321660,10443720000284872,10443720000245068,10443720000244293";
		functions.setText(driver, entersite, sites);
		functions.shortWait();

		String roo7 = "return document.querySelector(\"body > modal-container > div > div > app-add-sites-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div:nth-child(3) > div > app-site-list > div > div.col-lg-6.col-md-12.mt-4 > button\")";
		WebElement addsites = (WebElement) js.executeScript(roo7);
		functions.click(driver,  addsites);
		functions.mediumWait();

		String roo8 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.mt-4.table-responsive.ng-star-inserted > app-sites-table > table > tbody:nth-child(3) > tr:nth-child(4) > td:nth-child(16) > button > span\")";
		WebElement deletebtn = (WebElement) js.executeScript(roo8);
		js.executeScript("arguments[0].scrollIntoView();", deletebtn);
		functions.click(driver,  deletebtn);
		functions.intermediatewait();

		String roo9 = "return document.querySelector(\"body > modal-container > div > div > app-delete-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > button.btn.btn-danger.ng-star-inserted\")";
		WebElement yesdeletebtn = (WebElement) js.executeScript(roo9);
		functions.click(driver,  yesdeletebtn);
		functions.intermediatewait();

		String roo10 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.mt-4.table-responsive > app-sites-table > table > tbody:nth-child(3) > tr:nth-child(3) > td:nth-child(16) > button > span\")";
		WebElement deletebtn1 = (WebElement) js.executeScript(roo10);
		js.executeScript("arguments[0].scrollIntoView();", deletebtn1);
		functions.click(driver,  deletebtn1);
		functions.intermediatewait();

		String roo11 = "return document.querySelector(\"body > modal-container > div > div > app-delete-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > button.btn.btn-danger.ng-star-inserted\")";
		WebElement yesdeletebtn1 = (WebElement) js.executeScript(roo11);
		functions.click(driver,  yesdeletebtn1);
		functions.intermediatewait();

		String roo12 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"div > app-quote > fieldset > div.content > app-sites > div.mt-4.table-responsive > app-sites-table > table > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(16) > button > span\")";
		WebElement deletebtn2 = (WebElement) js.executeScript(roo12);

		functions.click(driver,  deletebtn2);
		functions.intermediatewait();

		String roo13 = "return document.querySelector(\"body > modal-container > div > div > app-delete-modal > app-modal\").shadowRoot.querySelector(\"div > div.modal-body > div > div > div > button.btn.btn-danger.ng-star-inserted\")";
		WebElement yesdeletebtn2 = (WebElement) js.executeScript(roo13);
		functions.click(driver,  yesdeletebtn2);
		functions.intermediatewait();


		// Click on validate sites

		String roo14 = "return document.querySelector(\"#embedded-app-container > app-broker-pricing\").shadowRoot.querySelector(\"#validate-sites\")";
		WebElement  validatebtn = (WebElement) js.executeScript(roo14);
		try {
			if(validatebtn.isEnabled()) {
	
		functions.click(driver, validatebtn);
		functions.longWait();
		//	js.executeScript("arguments[0].scrollIntoView();",verifydelete);
		functions.dealconversion();
		 Status="Pass";
			}
		}
		catch(Exception e) {
		
		 Status="Fail";

	}
		return Status;
}
}
