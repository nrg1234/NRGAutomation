package Pages.OAM;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddBank {
	String Status;
	@FindBy(xpath = "//*[@id=\"brand-navigation\"]/ul/li[3]/a")
	WebElement dropdown;
	@FindBy(xpath = "//input[contains(@class,'form-control ng-trigger')]")
	// input[@placeholder='Search by ID or name...']
	WebElement cust;
	@FindBy(xpath = "//*[@id=\"navbar-2\"]/ul/li[2]/a")
	WebElement Bill;
//	@FindBy(xpath = "/html/body/app-root/div/div/app-header/nav[2]/div[2]/span[2]/h2[3]")
	@FindBy(xpath = "//h2[text()='Manage Payment Methods']")
	WebElement Paymethod;
	@FindBy(xpath = "//*[@id=\"achbtn\"]")
	WebElement ACH;
	@FindBy(xpath = "//input[@id='bankRoutingNumber']")
	WebElement Routing;
	@FindBy(xpath = "//input[@id='bankAccountNumber']")
	WebElement Acc;
	@FindBy(xpath = "//input[@id='nickName']")
	WebElement nick;
	@FindBy(xpath = "//input[@id='addNewBankAccount']")
	WebElement Addacc;
	@FindBy(xpath = "//button[@id='ccbtn']")
	WebElement CCPaymentMethod;
	@FindBy(xpath = "//input[@id='nameOnCard']")
	WebElement NameonCardField;
	@FindBy(xpath = "//input[@id='ccNumber']")
	WebElement CreditcardField;
	@FindBy(xpath = "//input[@id='expMonth']")
	WebElement ExpirymonthField;
	@FindBy(xpath = "//input[@id='expYear']")
	WebElement ExpiryYearField;
	@FindBy(xpath = "// input[@id='cvvNumber']")
	WebElement CVVField;
	@FindBy(xpath = "//input[@id='addNewCreditCard']")
	WebElement AddCreditCardBtn;
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement ZipcodeField;
	@FindBy(xpath = "/html/body/app-root/div/div/div[6]/app-manage-payment-methods/app-payment-info/div[1]/div[1]/div/div/div/div/div/div/label")
	By AddACHlabel;
	@FindBy(xpath = "/html/body/app-root/div/div/div[6]/app-manage-payment-methods/app-payment-info/div[1]/div[1]/div/div/div/div/div/div/label/div[1]/div/div[2]/p[1]")
	By AddACHname;
	@FindBy(xpath = "//button[text()='Edit Name']")
	WebElement EditACH;
	@FindBy(xpath = "//button[text()='Remove']")
	WebElement RemACH;
	@FindBy(xpath = "//div[@class='control__indicator paymentControl']")
	WebElement payctrl;

	@FindBy(xpath = "//button[normalize-space()='Edit Name']")
	WebElement Editcard;

	@FindBy(xpath = "//button[normalize-space()='Remove']")
	WebElement Removecard;
	@FindBy(xpath = "//select[@name='expMonth']")
	WebElement monthdropdown;
	@FindBy(xpath = "//select[@name='expYear']")
	WebElement yeardropdown;

	@FindBy(xpath = "//h2[contains(text(),'Manage Payment Methods')]")
	WebElement ManagePaymentMethods;


	WebDriver driver;

	public AddBank(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Select Customer from Customer Dropdown
	 */

	public void Custselect() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		functions.click(driver, dropdown);
		functions.vshortWait();
		functions.setText(driver, cust, "Lamar Outdoor Advertising");
		cust.sendKeys(Keys.ENTER);
		functions.intermediatewait();

	}

	/*
	 * Select Customer from Customer Dropdown
	 */

	public void CustselectforCreditcard() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		functions.click(driver, dropdown);
		functions.vshortWait();
		functions.setText(driver, cust, "Crown Inn Inc");
		cust.sendKeys(Keys.ENTER);
		functions.intermediatewait();

	}

	public void Billselect() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Bill);
		functions.shortWait();
		functions.click(driver,ManagePaymentMethods);

	}

	public void ACHPaymentMeth() throws Throwable, InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Paymethod);
		functions.vshortWait();
		functions.click(driver, ACH);

		// Switching the Driver Inside Iframe
		driver.switchTo().frame("pciIFrame");

		// Enter Routing Number in the Routing field
		functions.click(driver, Routing);
		functions.setText(driver, Routing, "122105278");

		// Enter Account Number in the Account field
		functions.click(driver, Acc);
		functions.setText(driver, Acc, "0000000016");

		// Enter NickName in the NickName field
		functions.click(driver, nick);
		functions.setText(driver, nick, "Testing");

		// Click on Add Account Button
		functions.vshortWait();
		functions.click(driver, Addacc);

		// Switching the Main window
		driver.switchTo().parentFrame(); // switch back;

		//Edit card
		functions.vshortWait();
		functions.click(driver, Editcard);

		//Remove card
		functions.vshortWait();
		functions.click(driver, Removecard);

	}

	public String AddachValidation() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
//		functions.click(driver, payctrl);

		driver.switchTo().parentFrame();

		WebElement status = driver.findElement(By.xpath(
				"/html/body/app-root/div/div/div[6]/app-manage-payment-methods/app-payment-info/div[1]/div[1]/div/div/div/div/div/div/label/div[1]/div/div[2]/p[1]"));

		// p[text()[normalize-space()='Testing']]

		// p[text()[normalize-space()='Test']]
try {
		if (status.getText().equals("Testing")) {

			System.out.println("Payment Method added successfully");
			 Status="Pass";
		} else {
			System.out.println("Payment Method not added");

		}
		
}
		
		catch(Exception e) {
			 Status="Fail";
		}
		return Status;

	}

	public void EditachValidation() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		functions.vshortWait();
		functions.click(driver, EditACH);

	}

	public void RemachValidation() throws Throwable {

		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		functions.vshortWait();
		functions.click(driver, RemACH);

	}

	public String CreditcardPaymentMethod() throws Throwable, InterruptedException {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();


		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", CCPaymentMethod);
		functions.vshortWait();
		functions.click(driver, CCPaymentMethod);

		// Switching the Driver Inside Iframe
		driver.switchTo().frame("pciIFrameCC");

		// Enter Credit card Name in the Credit card Name field
		functions.click(driver, NameonCardField);
		functions.setText(driver, NameonCardField, "Tester");

		// Enter Credit card Number in the Credit card field
		functions.click(driver, CreditcardField);
		functions.setText(driver, CreditcardField, "5555555555555557");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, monthdropdown);
		functions.selectDropdownByVisibleText(driver,monthdropdown,"06");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, yeardropdown);
		functions.selectDropdownByVisibleText(driver,yeardropdown,"2024");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, CVVField);
		functions.setText(driver, CVVField, "112");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, ZipcodeField);
		functions.setText(driver, ZipcodeField, "77046");

		// Click on Add Account Button
		functions.vshortWait();
		functions.click(driver, AddCreditCardBtn);
		functions.click(driver, AddCreditCardBtn);

		driver.switchTo().parentFrame(); // switch back;

		WebDriverWait wait10 = new WebDriverWait(driver, 40);
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ccbtn']")));
		js1.executeScript("arguments[0].scrollIntoView();", CCPaymentMethod);
		functions.vshortWait();
		functions.click(driver, CCPaymentMethod);

		// Switching the Driver Inside Iframe
		driver.switchTo().frame("pciIFrameCC");

		// Enter Credit card Name in the Credit card Name field
		functions.click(driver, NameonCardField);
		functions.setText(driver, NameonCardField, "Visa");

		// Enter Credit card Number in the Credit card field
		functions.click(driver, CreditcardField);
		functions.setText(driver, CreditcardField, "4444444444444448");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, monthdropdown);
		functions.selectDropdownByVisibleText(driver,monthdropdown,"06");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver,yeardropdown);
		functions.selectDropdownByVisibleText(driver,yeardropdown,"2024");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, CVVField);
		functions.setText(driver, CVVField, "112");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, ZipcodeField);
		functions.setText(driver, ZipcodeField, "77046");

		// Click on Add Account Button
		functions.vshortWait();
		functions.click(driver, AddCreditCardBtn);
		functions.click(driver, AddCreditCardBtn);

		driver.switchTo().parentFrame(); // switch back;

		WebDriverWait wait11 = new WebDriverWait(driver, 40);
		wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='ccbtn']")));
		js1.executeScript("arguments[0].scrollIntoView();", CCPaymentMethod);
		functions.vshortWait();
		functions.click(driver, CCPaymentMethod);

		// Switching the Driver Inside Iframe
		driver.switchTo().frame("pciIFrameCC");

		// Enter Credit card Name in the Credit card Name field
		functions.click(driver, NameonCardField);
		functions.setText(driver, NameonCardField, "AmericanExpress");

		// Enter Credit card Number in the Credit card field
		functions.click(driver, CreditcardField);
		functions.setText(driver, CreditcardField, "343434343434343");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, monthdropdown);
		functions.selectDropdownByVisibleText(driver,monthdropdown,"06");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, yeardropdown);
		functions.selectDropdownByVisibleText(driver,yeardropdown,"2024");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, CVVField);
		functions.setText(driver, CVVField, "1124");

		// Enter Expiry Year in the Expiry year field
		functions.click(driver, ZipcodeField);
		functions.setText(driver, ZipcodeField, "77046");

		// Click on Add Account Button
		functions.vshortWait();
		functions.click(driver, AddCreditCardBtn);
		functions.click(driver, AddCreditCardBtn);

		driver.switchTo().parentFrame(); // switch back;

		//Edit card
		functions.vshortWait();
		functions.click(driver, Editcard);

		//Remove card
		functions.vshortWait();
		
		try {
			
		functions.click(driver, Removecard);
		
		 Status="Pass";
		}
		catch(Exception e) {
			 Status="Fail";
		}
		
		return Status;
	}

}
