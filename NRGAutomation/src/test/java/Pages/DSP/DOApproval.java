package Pages.DSP;

import java.util.List;

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
import apphooks.Base;

public class DOApproval {
	@FindBy(xpath = "//a[contains(text(),'All Opportunities')]")
	WebElement Allopportunitiesbtn;
	@FindBy(xpath = "//button[contains(text(), ' Send DOA Approval')]")
	WebElement SendDOABtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Send')]") })
	public List<WebElement> sendbtn;
	@FindAll(value = { @FindBy(xpath = "//span[contains(text(), 'Approvals')]") })
	public List<WebElement> Approvalbtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Accept All')]") })
	public List<WebElement> Acceptbtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Submit')]") })
	public List<WebElement> submitbtn;
	@FindBy(xpath = "	//button[@ng-reflect-router-link='dealoptions']")
	WebElement dealBtn;
	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	@FindBy(xpath = "//span[@class='mdi mdi-dots-horizontal']")
	WebElement ThreeDotsbtn;
	@FindBy(xpath = "//li[@class='nav-item']//span[contains(text(),'Opportunities')]")
	WebElement optybtn;
////li[@class='nav-item']//span[contains(text(),'Opportunities')]
	//button[@ng-reflect-router-link='dealoptions']
	//button[contains(text(), 'Submit')]
	//button[contains(text(), 'Accept All')]
	//span[contains(text(), 'Approvals')]
WebDriver driver;
CommonFunctions functions = new CommonFunctions();
public  DOApproval(Base base) {
	this.driver = base.driver;
	PageFactory.initElements(driver, this);
}
public void DOAvalidation() throws Throwable {
	functions.shortWait();
	functions.click(driver, dealBtn);
	functions.intermediatewait();
	
	WebDriverWait wait1 = new WebDriverWait(driver, 200);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), ' Send DOA Approval')]")));
	functions.click(driver,  SendDOABtn);
	functions.mediumWait();
	WebDriverWait wait2 = new WebDriverWait(driver, 200);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Send')]")));
	sendbtn.get(1).click();
	functions.intermediatewait();
	Approvalbtn.get(0).click();
	WebDriverWait wait3 = new WebDriverWait(driver, 500);
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Accept All')]")));
	Acceptbtn.get(0).click();
	functions.intermediatewait();
	submitbtn.get(1).click();
	functions.shortWait();
}
    public void Searchopty(String Optyheader) throws Throwable {
    	
    	functions.click(driver,optybtn);
    	WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Opportunities')]")));
		functions.click(driver, Allopportunitiesbtn);
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@class='search']")));
		
// Click on Search Button
functions.click(driver, SearchBtn);

// Enter Opportunity Id in the Search
functions.setText(driver, Searchplaceholder, Optyheader);

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

functions.vshortWait();
// paste
actions.keyDown(Keys.CONTROL);
actions.sendKeys("v");
actions.keyUp(Keys.CONTROL);
actions.build().perform();

// Wait for Sometime
functions.intermediatewait();

// Click on Opportunity Id Hyperlink
driver.findElement(By.xpath("//a[contains(text(),'" + Optyheader + "')]")).click();

// Wait for Sometime
WebDriverWait wait3 = new WebDriverWait(driver, 360);
wait3.until(ExpectedConditions
		.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-24px mdi-chevron-down']")));

functions.click(driver, dealBtn);
functions.intermediatewait();
// Wait for Deal Option Status to be Approved
WebDriverWait wait7 = new WebDriverWait(driver, 150);
wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));
}
}