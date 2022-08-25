package Pages.DSP;

import apphooks.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;

public class ViewContract {
	WebDriver driver;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-progress-step status-success']") })
	public List<WebElement> DealOptions;
	@FindBy(xpath = "//button[contains(text(), 'Contracts')]")
	WebElement contractTab;
	@FindBy(xpath = "//span[contains(text(),'Error')]")
	WebElement Errortext;
	@FindBy(xpath = "//span[contains(text(),'Failed Creation')]")
	WebElement FailedCreationError;
	@FindBy(xpath = "//span[@class='icon icon-expand ng-star-inserted']")
	WebElement AdderBTn;
	@FindAll(value = { @FindBy(xpath = "//tr[@class='rec-row ng-star-inserted']") })
	public List<WebElement> MeterFeeandVolRecs;
	@FindBy(xpath = "//td[@class='modal-link ng-star-inserted']")
	WebElement DealOptionNumber;

	public ViewContract(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * View contract for Single greater than 50kwh
	 */
	public String contractcreation() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));

		// Click on Contract Tab
		functions.click(driver, contractTab);

		functions.intermediatewait();

		// Click on Deal Options Tab
		DealOptions.get(3).click();

		// Click on Contract Tab
		functions.click(driver, contractTab);

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Created Succesfully ')]")));
		
		String Status="Pass";
		// Assert.assertFalse("contract generation is failed due to timeout")

		return Status;
	}

	/*
	 * View contract for Single greater than 50kwh with Meter fee and Vol Recs
	 */
	public String contractwithMeterfeeVolRecs() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));

		//String DealNumber = functions.getText(driver, DealOptionNumber);
	//	String Deal=DealNumber.substring(6, 18);

		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='icon icon-expand ng-star-inserted']")));

		functions.click(driver, AdderBTn);

		functions.vshortWait();

		functions.click(driver, AdderBTn);

		//Validate Meter Fee and Voluntary Recs
		List<WebElement> VolRecsRow = MeterFeeandVolRecs;
		if (VolRecsRow.size() > 0 == true && VolRecsRow.get(0).isDisplayed() == true) {
			System.out.println("Meter fee and Vol Recs are displayed");
		}

		// Click on Contract Tab
		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Contracts')]")));
		functions.click(driver, contractTab);

		functions.intermediatewait();

		// Click on Deal Options Tab
		DealOptions.get(3).click();

		// Click on Contract Tab
		functions.click(driver, contractTab);

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 500);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Created Succesfully ')]")));

	String Status="Pass";
		return Status;
	}

	/*
	 * View contract for Aggregate greater than 50kwh
	 */
	public String contractcreationAggregate() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));

		// Click on Contract Tab
		functions.click(driver, contractTab);

		functions.longWait();

		// Click on Deal Options Tab
		DealOptions.get(3).click();

		// Click on Contract Tab
		functions.click(driver, contractTab);

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Created Succesfully ')]")));
		
		String Status="Pass";
		
		return Status;

	}

	/*
	 * View contract for Renewal Aggregate greater than 50kwh
	 */
	public String contractcreationRenewalAggregate() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));

		// Click on Contract Tab
		functions.click(driver, contractTab);

		functions.longWait();

		// Click on Deal Options Tab
		DealOptions.get(3).click();

		// Click on Contract Tab
		functions.click(driver, contractTab);

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 540);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Created Succesfully ')]")));
		
		String Status="Pass";
		
		return Status;
	}

	/*
	 * View contract for less than 50
	 */
	public String contractcreationlessthan50() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Wait for Deal Option Status to be Approved
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved ')]")));

		functions.click(driver, contractTab);
		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Created Succesfully ')]")));
		
		String Status="Pass";
		
		return Status;

	}

}
