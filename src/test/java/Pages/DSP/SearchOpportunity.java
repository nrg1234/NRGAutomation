package Pages.DSP;

import java.lang.reflect.Array;
import java.util.List;
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

public class SearchOpportunity {

	@FindBy(xpath = "//th[@class='search']")
	WebElement SearchBtn;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchplaceholder;
	@FindBy(xpath = "//*[@class='d-flex align-items-baseline edit-hover'][1]/h1")
	WebElement OpportunityName;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block header-overlap'][1]/h1")
	WebElement CustomerName;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto'][1]/h1")
	WebElement opportunityStartDate;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto'][2]/h1")
	WebElement opportunityEndDate;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto'][3]/h1")
	WebElement opportunityDueDate;
	@FindBy(xpath = "//span[@class='mdi mdi-24px mdi-chevron-down']")
	WebElement SeeDetailsBtn;
	@FindBy(xpath = "//*[@class='col-auto mr-auto my-auto'][5]/h1")
	WebElement SalesGroup;
	@FindBy(xpath = "//*[@class='col-auto mr-auto my-auto'][6]/h1")
	WebElement SalesChannel;
	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindBy(xpath = "//td[@id='esidColumn']")
	WebElement sitesText;
	@FindAll(value = {@FindBy(xpath = "//button[@class='btn btn-progress-step status-success']")})
	public List<WebElement> DealOptions;
	@FindBy(xpath = "//span[@class='icon icon-expand']")
	WebElement AdderBTn;
	@FindBy(xpath = "//button[contains(text(),'Deal Options')]")
	WebElement DealOptionsTab;
	@FindBy(xpath = "//table[@class='product-table']/thead/tr/td[5]")
	WebElement ProductType;
	@FindBy(css = "body > jhi-main:nth-child(1) > div:nth-child(1) > jhi-opportunity:nth-child(4) > div:nth-child(3) > jhi-deal-option:nth-child(4) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > thead:nth-child(1) > tr:nth-child(2) > td:nth-child(6)")
	WebElement Price;
	@FindBy(xpath = "//table[@class='product-table']/thead/tr/td[7]")
	WebElement Term;
	@FindBy(xpath = "//table[@class='product-table']/thead/tr/td[8]")
	WebElement Margin;
	@FindBy(xpath = "//button[contains(text(),'Customer')]")
	WebElement CustomerTab;
	@FindAll(value = {@FindBy(xpath = "//button[@class='btn btn-link']")})
	public List<WebElement> EditBtn;
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstnametext;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastnametext;
	@FindBy(xpath = "//input[@id='streetAddress']")
	WebElement addresstext;
	@FindBy(xpath = "//input[@id='city']")
	WebElement citytext;
	@FindBy(xpath = "//input[@id='zip']")
	WebElement Ziptext;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailtext;
	@FindBy(xpath = "//select[@id='state']")
	WebElement statetext;

	WebDriver driver;
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();

	public SearchOpportunity(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Search Opportunity in DSp.
	 */

	public String SearchOpty(String OptyID, String OptyName) throws Throwable {

		// Click on Search Button
		functions.click(driver, SearchBtn);

		// Enter Opportunity Id in the Search
		functions.setText(driver, Searchplaceholder, OptyName);

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
		driver.findElement(By.xpath("//a[contains(text(),'" + OptyID + "')]")).click();

		// Wait for Sometime
		WebDriverWait wait = new WebDriverWait(driver, 360);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='mdi mdi-24px mdi-chevron-down']")));

		// Storing and Returning the text into a String
		return (functions.getText(driver, OpportunityName));

	}

	public String customername() {
		return (functions.getText(driver, CustomerName));

	}

	public String OpportunityID() {
		return (functions.getText(driver, opportunityIDText));

	}

	public String OpportunityStartDate() {
		return (functions.getText(driver, opportunityStartDate));

	}

	public String OpportunityEndDate() {
		return (functions.getText(driver, opportunityEndDate));

	}

	public String OpportunityDueDate() {
		return (functions.getText(driver, opportunityDueDate));

	}

	public String SalesGroup() throws InterruptedException {

		// Click on See Details Button
		functions.click(driver, SeeDetailsBtn);

		// Wait for Sometime
		functions.midintermediatewait();

		return (functions.getText(driver, SalesGroup));

	}

	public String SalesChannel() throws InterruptedException {

		return (functions.getText(driver, SalesChannel));

	}

	public String ESIID() throws InterruptedException {
		// Click on Site Component Cart
		functions.click(driver, sitesComponentCart);

		functions.shortWait();

		return (functions.getText(driver, sitesText));

	}

	public String DealOptions() throws InterruptedException {

		functions.click(driver, DealOptionsTab);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon icon-expand']")));

		functions.click(driver, AdderBTn);

		functions.vshortWait();

		functions.click(driver, AdderBTn);

		return (functions.getText(driver, ProductType));
	}

	public String Price() throws InterruptedException {

		return (functions.getText(driver, Price));
	}

	public String Term() throws InterruptedException {

		return (functions.getText(driver, Term));
	}

	public String Margin() throws InterruptedException {

		return (functions.getText(driver, Margin));
	}

	public String firstname() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Customer')]")));
		functions.click(driver, CustomerTab);

		functions.shortWait();

		EditBtn.get(1).click();

		functions.shortWait();

		return (functions.getValue(driver, firstnametext));
	}

	public String lastname() throws InterruptedException {

		return (functions.getValue(driver, lastnametext));
	}

	public String address() throws InterruptedException {

		return (functions.getValue(driver, addresstext));
	}

	public String city() throws InterruptedException {

		return (functions.getValue(driver, citytext));
	}

	public String Zip() throws InterruptedException {

		return (functions.getValue(driver, Ziptext));
	}

	public String State() throws InterruptedException {
		String state = functions.getValue(driver, statetext);
		String state1 = state.substring(4, 5);
		String state2 = "Texas";
		return (state2);
	}

	public String Email() throws InterruptedException {

		return (functions.getValue(driver, emailtext));
	}
	//public static void main(String[] args){
	public String stringArray(String Opty1, String Opty2, String Opty3, String Opty4) throws Throwable {
		String[] strAr1= new String[]{Opty1, Opty2, Opty3, Opty4};
		System.out.println(strAr1[0]);
		System.out.println(strAr1[1]);
		System.out.println(strAr1[2]);
		System.out.println(strAr1[3]);

		return null;
	}

}
