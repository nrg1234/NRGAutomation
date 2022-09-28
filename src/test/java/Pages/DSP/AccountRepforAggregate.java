package Pages.DSP;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import apphooks.Base;

public class AccountRepforAggregate {
	@FindBy(xpath = "//span[@class='mdi mdi-24px mdi-chevron-down']")
	WebElement SeeDetailsBtn;
	@FindBy(xpath = "//span[@class='icon icon-check']")
	WebElement SaveBtn;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link edit-button']") })
	public List<WebElement> Edit;
	@FindAll(value = {
			@FindBy(xpath = "//ngb-alert[@class='locked-banner yellow-locked-banner alert alert-warning']") })
	public List<WebElement> Accountrepbanner;
	@FindBy(xpath = "//button[contains(text(),'Edit Customer')]")
	WebElement EditCustomerBtn;
	@FindBy(xpath = "//input[@name='emm']")
	WebElement AccountrepBtn;
	@FindBy(xpath = "//button[contains(text(),'Create Anyways')]")
	WebElement createanywaysBtn;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement YesBtn;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateBtn;
	@FindBy(xpath = "//input[@name='accountRep']")
	WebElement AccountrepinSeedetails;
	@FindBy(xpath = "//select[@id='sales-channel']")
	WebElement SalesChannelDropdown;
	@FindBy(xpath = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-customer/div[1]/div[2]/table/tbody/tr/td[2]/a")
	WebElement Customerlink1;
	@FindBy(xpath = "/html/body/jhi-main/div/jhi-opportunity/div/jhi-customer/div[1]/div[2]/table/tbody/tr[2]/td[2]/a")
	WebElement Customerlink2;
	@FindAll(value = { @FindBy(xpath = "//span[@class='icon icon-close']") })
	public List<WebElement> Popupclose;
	@FindBy(xpath = "//div[@class='col-auto mr-auto my-auto']//span[@class='icon icon-pencil brand-primary']")
	WebElement EditBtn;
	@FindBy(xpath = "//input[@id='typeahead-ema']")
	WebElement EMAfield;
	WebDriver driver;

	public AccountRepforAggregate(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Account Rep for Aggregate
	 */

	public void AccountrepforAggregate() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		if (Accountrepbanner.size() >= 0 == true && Accountrepbanner.get(0).isDisplayed() == true) {

			functions.click(driver, Customerlink1);

			functions.shortWait();

			functions.click(driver, EditCustomerBtn);

			functions.shortWait();

			String AccountRep = functions.getValue(driver, AccountrepBtn);

			if (Popupclose.size() > 0 == true && Popupclose.get(5).isDisplayed() == true) {
				Popupclose.get(5).click();
				functions.vshortWait();
			}

			functions.vshortWait();
			functions.click(driver, Customerlink2);

			functions.shortWait();

			functions.click(driver, EditCustomerBtn);

			functions.shortWait();

			functions.setText(driver, AccountrepBtn, AccountRep);

			functions.click(driver, UpdateBtn);

			functions.click(driver, createanywaysBtn);

			functions.midintermediatewait();

			// Click on See Details Button
			functions.click(driver, SeeDetailsBtn);

			// Wait for Sometime
			functions.midintermediatewait();

			// Click on Edit Button
			functions.click(driver, EditBtn);

			// Wait for Sometime
			functions.shortWait();

			// Click on EMA Field
			functions.click(driver, AccountrepinSeedetails);

			// Enter Text in EMA Field
			functions.setText(driver, AccountrepinSeedetails, AccountRep);

			// Wait for Sometime
			functions.shortWait();

			// Click on Save Button
			functions.click(driver, SaveBtn);

			// Wait for Sometime
			functions.shortWait();

		}
	}
	
	/*
	 * Account Rep for Single
	 */

	public void AccountrepforSingle() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		if (Accountrepbanner.size() >= 0 == true && Accountrepbanner.get(0).isDisplayed() == true) {

			functions.click(driver, Customerlink1);

			functions.shortWait();

			functions.click(driver, EditCustomerBtn);

			functions.shortWait();

			String AccountRep = functions.getValue(driver, AccountrepBtn);

			if (Popupclose.size() > 0 == true && Popupclose.get(5).isDisplayed() == true) {
				Popupclose.get(5).click();
				functions.vshortWait();
			}

			functions.vshortWait();
	

			// Click on See Details Button
			functions.click(driver, SeeDetailsBtn);

			// Wait for Sometime
			functions.midintermediatewait();

			// Click on Edit Button
			functions.click(driver, EditBtn);

			// Wait for Sometime
			functions.shortWait();

			// Click on EMA Field
			functions.click(driver, AccountrepinSeedetails);

			// Enter Text in EMA Field
			functions.setText(driver, AccountrepinSeedetails, AccountRep);

			// Wait for Sometime
			functions.shortWait();

			// Click on Save Button
			functions.click(driver, SaveBtn);

			// Wait for Sometime
			functions.shortWait();

		}
	}
	/*
	 * Account Rep for Aggregate
	 */

	public void SalesChannel(String Saleschannel) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		// Click on See Details Button
		functions.click(driver, SeeDetailsBtn);

		// Wait for Sometime
		functions.midintermediatewait();

		// Click on Edit Button
		functions.click(driver, EditBtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on EMA Field
		functions.click(driver, AccountrepinSeedetails);

		// Enter Text in EMA Field
		functions.setText(driver, AccountrepinSeedetails, "DHUSAS");

		// Wait for Sometime
		functions.shortWait();

		// Click on EMA Field
		functions.click(driver, EMAfield);

		// Enter Text in EMA Field
		functions.setText(driver, EMAfield, "UPARTHIPAN");

		// Click on EMA Field
		functions.click(driver, SalesChannelDropdown);

		// Enter Text in EMA Field
		functions.selectDropdownByVisibleText(driver, SalesChannelDropdown, Saleschannel);

		// Wait for Sometime
		functions.shortWait();

		// Click on Save Button
		functions.click(driver, SaveBtn);

		// Wait for Sometime
		functions.shortWait();

	}
}
