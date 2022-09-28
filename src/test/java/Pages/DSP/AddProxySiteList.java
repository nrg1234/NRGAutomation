package Pages.DSP;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
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

public class AddProxySiteList {

	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindBy(xpath = "//span[contains(text(),'Refresh Site List')]")
	WebElement RefreshsitelistBtn;
	@FindBy(xpath = "//button[contains(text(), 'Add Site')]")
	WebElement openAddSitesModalBtn;
	@FindBy(xpath = "//textarea[@id='esiids']")
	WebElement sitesTextArea;
	@FindBy(xpath = "//select[@id='customer']")
	WebElement CustomerDropdown;
	@FindBy(xpath = "//button[contains(text(),'Add to Queue')]")
	WebElement AddtoQueueBtn;
	@FindBy(xpath = "//button[contains(text(),' Confirm Site(s)')]")
	WebElement ConfirmSitesBtn;
	@FindBy(xpath = "//button[contains(text(), 'Add Site(s)')]")
	WebElement addSitesBtn;
	@FindBy(xpath = "//button[contains(text(), ' Submit Site(s) ')]")
	WebElement submitSitesBtn;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//a[contains(text(), 'HU Upload')]")
	WebElement HUUpload;
	@FindBy(xpath = "//button[contains(text(), 'Select File(s)')]")
	WebElement selectHUFiles;
	@FindBy(xpath = "//button[contains(text(), ' Process HU')]")
	WebElement processHU;
	@FindBy(xpath = "//button[contains(text(), 'Credit')]")
	WebElement creditTAB;
	@FindBy(xpath = "//td[@id='esidColumn']")
	WebElement ESIID;
	@FindBy(xpath = "//h4[contains(text(),'Add Site Progress Tracker')]")
	WebElement Progresstracker;
	@FindBy(xpath = "//div[contains(@class,'check-3')]/following-sibling::div[@class='progress-bar bg-brand-success']")
	WebElement Progress;
	@FindBy(xpath = "//span[@ng-reflect-tooltip='Creation of Opportunity ID is ']")
	WebElement optyid;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Dismiss')]") })
	public List<WebElement> Dismissbtn;
	@FindBy(xpath = "//a[contains(text(),'HU Upload')]")
	WebElement HUUploadBtn;
	@FindBy(xpath = "//button[@id='upload-file']")
	WebElement SelectfileBtn;
	@FindBy(xpath = "//button[contains(text(),'Process HU')]")
	WebElement ProcessHUBtn;
	@FindBy(xpath = "//a[contains(text(),'Proxy Site')]")
	WebElement ProxySiteBtn;
	@FindBy(xpath = "//input[@id='new-site-number']")
	WebElement EnterSiteField;
	@FindBy(xpath = "//input[@id='proxy-site-number']")
	WebElement ProxySiteField;
	@FindBy(xpath = "//button[contains(text(),' Browse ')]")
	WebElement BrowseBtn;
	@FindBy(xpath = "//button[@class='btn btn-primary w-100 action-btn']")
	WebElement AddSiteBtn;

	WebDriver driver;

	public AddProxySiteList(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Add sites to opportunity using Proxy Site List.
	 */

	public String AddProxySitestotheOpty(String Sites1, String Sites2) throws InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click on Site Component Cart
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")));
		functions.click(driver, sitesComponentCart);

		// Open modal to add sites
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Site')]")));
		functions.click(driver, openAddSitesModalBtn);

		// Click on HU Upload Header
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proxy Site')]")));
		functions.click(driver, ProxySiteBtn);
		
		// Enter Site & Proxy Site Details in the Field
		WebDriverWait wait22 = new WebDriverWait(driver, 60);
		wait22.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='new-site-number']")));
		functions.setText(driver, EnterSiteField, prop.getProperty(Sites1));
		WebDriverWait wait23 = new WebDriverWait(driver, 60);
		wait23.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='proxy-site-number']")));
		functions.setText(driver, ProxySiteField, prop.getProperty(Sites2));

		// Click on Select File Button
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' Browse ')]")));
		functions.click(driver, BrowseBtn);

		// choosing the file to upload
		String pdffile = System.getProperty("user.dir");

		StringSelection ss = new StringSelection(pdffile + "\\src\\test\\resources\\DataReader\\Worksheet in Proxy Site.xlsx");

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

		// Click on Process HU Button
		WebDriverWait wait4 = new WebDriverWait(driver, 60);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100 action-btn']")));
		functions.click(driver, AddSiteBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 120);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));
		// functions.longWait();

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}
	
	
	
	
}
