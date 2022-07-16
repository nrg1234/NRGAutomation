package Pages.DSP;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import apphooks.Base;

public class MatrixMarginGroup {
	CommonFunctions functions = new CommonFunctions();
//Margin Locators
	@FindBy(xpath = "//span[contains(text(),'Maintenance')]")
	WebElement Maintenancebtn;
	@FindBy(xpath = "//button[contains(text(),'Create Margin Group')]")
	WebElement CreateMargingroupbtn;
	@FindBy(xpath = "//input[@formcontrolname='marginGroupName']")
	WebElement MarginGroupNameField;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Create Margin Group')]") })
	public List<WebElement> CreateMarginpopupbtn;
	@FindBy(xpath = "//span[contains(text(),'Add New Row')]")
	WebElement AddNewRowbtn;
	@FindBy(xpath = "//input[@formcontrolname='mwhLowerLevel']")
	WebElement Mwhlowerlimit;
	@FindAll(value = { @FindBy(xpath = "//input[@formcontrolname='mwhLowerLevel']") })
	public List<WebElement> Mwhlowerlimit1;
	@FindBy(xpath = "//input[@formcontrolname='mwhUpperLevel']")
	WebElement MwhUpperlimit;
	@FindAll(value = { @FindBy(xpath = "//input[@formcontrolname='mwhUpperLevel']") })
	public List<WebElement> MwhUpperlimit1;
	@FindBy(xpath = "//input[@formcontrolname='fixedTarget']")
	WebElement TargetMargin;
	@FindAll(value = { @FindBy(xpath = "//input[@formcontrolname='fixedTarget']") })
	public List<WebElement> TargetMargin1;
	@FindBy(xpath = "//select[@formcontrolname='monthlyMeterFee']")
	WebElement MeterFeedropdown;
	@FindBy(xpath = "//button[contains(text(),'Save')] ")
	WebElement Savebtn;

//Margin Locators	
	WebDriver driver;

	public MatrixMarginGroup(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMaintenance() throws Throwable {
		functions.click(driver, Maintenancebtn);
		functions.intermediatewait();
	}

	public String createMargingroup() throws Throwable {

		// Clicking on margin group btn
		functions.click(driver, CreateMargingroupbtn);
		functions.intermediatewait();
		// Entering value
		String alphabet = "Test";
		Random random=new Random();
		String number = String.valueOf (random.nextInt(100));
		String Margingroupname =alphabet.concat(number);
	
		functions.setText(driver, MarginGroupNameField, Margingroupname);
		functions.intermediatewait();
		//
		CreateMarginpopupbtn.get(1).click();
		functions.intermediatewait();
		//
		functions.click(driver, AddNewRowbtn);

		// Entering values in field
		// MWH LOWER LIMIT
		functions.setText(driver, Mwhlowerlimit, "0");
		functions.minwait();
		Mwhlowerlimit1.get(1).sendKeys("300");
		functions.minwait();
		// MWH UPPER LIMIT
		functions.setText(driver, MwhUpperlimit, "300");
		functions.minwait();
		MwhUpperlimit1.get(1).sendKeys("1000");
		functions.minwait();
		// TARGET MARGIN
		functions.setText(driver, TargetMargin, "7.01");
		functions.minwait();
		TargetMargin1.get(1).sendKeys("7.01");
		functions.minwait();
		// select from drop down
		functions.click(driver, MeterFeedropdown);
		functions.minwait();
		functions.selectDropdownByIndex(driver, MeterFeedropdown, 0);
		functions.shortWait();
		
		return Margingroupname;

	}

	public String submit() throws Throwable {
		functions.click(driver, Savebtn);
		functions.maxWait();
		
		String Status="Pass";
		return Status;
	}

}
