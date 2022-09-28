package Pages.DSP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import Utilities.ConfigReader;
import apphooks.Base;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;

public class GenerateContract {
	String Status="Error";
	CommonFunctions functions = new CommonFunctions();
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	WebDriver driver;
	private Base base;
	Putsbox putsbox = new Putsbox(base);

	public GenerateContract(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Accept Address As Is')]")
	WebElement AcceptAddressBtn;
	@FindBy(xpath = "//button[contains(text(), 'Generate Contract')]")
	WebElement generateContractModalBtn;
	@FindBy(xpath = "//input[@id='name']")
	WebElement dealOptionName;
	@FindBy(xpath = "//select[@id='templateName']")
	WebElement templateName;
	@FindBy(xpath = "//select[@id='languageType']")
	WebElement languagedropdown;
	@FindAll(value = { @FindBy(xpath = "//select[@id='templateName']") })
	public List<WebElement> templateName1;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Enter Info')]") })
	public List<WebElement> noticeAddress;
	@FindBy(xpath = "//button[contains(text(), 'Enter Info')]")
	WebElement noticeAddressBtn;
	@FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
	WebElement contactNameDropdown;
	@FindAll(value = { @FindBy(xpath = "//p[@class='typeahead-options-title ng-star-inserted']") })
	public List<WebElement> contactNameValue;
	@FindAll(value = { @FindBy(xpath = "//p[@class='typeahead-options-title']") })
	public List<WebElement> contactNameValue1;
	
	@FindBy(xpath = "//button[contains(text(), 'Add to Customer ')]")
	WebElement addContactToCustomerBtn;
	@FindBy(xpath = "//button[contains(text(),'Save Changes')]")
	WebElement savechangesBtn;
	// @FindBy(xpath =
	// "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")
//    WebElement approverDropdown;
	@FindBy(xpath = " //Select[@ng-reflect-name='approverSelector0']")
	WebElement approverDropdown;
	@FindBy(xpath = " //Select[@ng-reflect-name='approverSelector1']")
	WebElement approverDropdown1;
	// Select[@class='form-control ng-pristine ng-invalid ng-touched']
	// form-control ng-pristine ng-invalid ng-touched
	@FindBy(xpath = "//Select[@ng-reflect-name='approverSelector0']")
	WebElement Approverdropdownforlessthan50;
	@FindAll(value = { @FindBy(xpath = " //select[@class='form-control ng-pristine ng-invalid ng-touched']") })
	public List<WebElement> approverdropdwn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Generate Contract')]") })
	public List<WebElement> contractBtn;
	@FindBy(xpath = "//button[contains(text(),'Create Contact')]")
	WebElement CreateContact;
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement Firstname;
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement Lastname;
	@FindBy(xpath = "//input[@id='streetAddress']")
	WebElement Addressbox;
	@FindBy(xpath = "//input[@id='city']")
	WebElement City;
	@FindBy(xpath = "//select[@formcontrolname='state']")
	WebElement Statedropdown;
	@FindBy(xpath = "//input[@id='zip']")
	WebElement zipcode;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//button[contains(text(),'Create and Add ')]")
	WebElement AddCreatebtn;
	@FindBy(xpath = "//button[contains(text(),'Create Anyways')]")
	WebElement CreateanywaysBTn;
	@FindBy(xpath = "//input[@ng-reflect-name='generalPartner']")
	WebElement GeneralPartnerField;
	@FindBy(xpath = "//select[@class='form-control ng-pristine ng-invalid ng-touched']")
	WebElement Approvedropdown;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Generate Contract')]") })
	public List<WebElement> generatecontractdisabled;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link']") })
	public List<WebElement> generatecontractenabled;
	
	@FindAll(value = { @FindBy(xpath = "//div[contains(text(),'Pre-Approved')]") })
	public List<WebElement> Approvallevel;
	@FindBy(xpath = " //tbody/tr[1]/td[5]/select[1]")
	WebElement Approvedropdown1;
	// option[contains(text(),' Automated Approval ')]
	@FindBy(xpath = " //tbody/tr[2]/td[5]/select[1]")
	WebElement Approvedropdown2;
	@FindBy(xpath = " //span[@class='ng-star-inserted']//span[@class='icon icon-pencil brand-primary']")
	WebElement pencilbtn;
	@FindBy(xpath = " //div [contains(text(),'Account Executive')]")
	WebElement CI;
	@FindBy(xpath = " //div[contains(text(),'Pre-Approved')]")
	WebElement Preapproved;
	@FindBy(xpath = " //div [contains(text(),'Manager Sales Business Development')]")
	WebElement ManagerSales;
	@FindBy(xpath = "//div [contains(text(),'Senior Vice President, NRG Business')]")
	WebElement SeniorVice;
	@FindBy(xpath = "//*[text()=' Generate Contract']")
	WebElement Generatecontractbi;
	//*[text()=' Generate Contract']
	@FindBy(xpath = " //*[text()=' At least one of your sites is out of vintage, so contract cannot be generated. ']")
	WebElement Vintagebanner;
	@FindBy(xpath = " //input[@id='cellPhone']")
	WebElement cellphone;
	@FindBy(xpath = " //input[@id='workPhone']")
	WebElement workphone;
	@FindBy(xpath = "   //button[contains(text(),'Accept Address As Is')]")
	WebElement AcceptAddress;

	@FindBy(xpath = " //input[@id='fax']")
	WebElement Faxbtn;
	@FindBy(xpath = " //button[normalize-space()='Update']")
	WebElement updatebtn;
	@FindBy(xpath = "//p[normalize-space()='No Products for Quote']")
	WebElement siteerror;
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement Continuebtn;
	@FindBy(xpath = "//button[contains(text(),'Deal Options')]")
	WebElement Dealoptiontab;
//	@FindAll(value = { @FindBy(xpath = "//div[@class='mat-radio-outer-circle']") })
//	public List<WebElement> Tconly;
	@FindBy(xpath = "//mat-radio-button[@value='TC']")
	WebElement Tconly;
	
	/*
	 * Generate contract workflow for Single with Fixed Product>50wkh.
	 */

	public String ContractGeneration() throws Throwable {

		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Generate Contract')]")));
		// Open generate contract modal
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("TemplateName"));

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		// functions.intermediatewait();

		// Selects contact name from the Dropdown
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-arrow-wrapper']")));
		functions.click(driver, contactNameDropdown);

		contactNameValue.get(0).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to Customer ')]")));

		functions.click(driver, addContactToCustomerBtn);
		
		try {
		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}
		}
		catch (Exception n) {
			System.out.println("Accept Address is not displayed");
		}

		// Wait for spinner to appear Contact Info
		// functions.mediumWait();

		// Choose approver
//        WebDriverWait wait6 = new WebDriverWait(driver, 200);
//        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//                "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
		functions.midintermediatewait();
		functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		
			}
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
		
		return Status;
	}
	public String ContractGenerationTConly() throws Throwable {
System.out.println("print");
		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Generate Contract')]")));
		// Open generate contract modal
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, "ERCOT CMA TC");

//Selecting TC only
//		Tconly.get(0).click();
		functions.click(driver,Tconly);
		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		// functions.intermediatewait();

		// Selects contact name from the Dropdown
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-arrow-wrapper']")));
		functions.click(driver, contactNameDropdown);

		contactNameValue.get(0).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to Customer ')]")));

		functions.click(driver, addContactToCustomerBtn);
		
		try {
		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}
		}
		catch (Exception n) {
			System.out.println("Accept Address is not displayed");
		}

		// Wait for spinner to appear Contact Info
		// functions.mediumWait();

		// Choose approver
//        WebDriverWait wait6 = new WebDriverWait(driver, 200);
//        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//                "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
		functions.midintermediatewait();
		functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		
			}
		}
		catch (Exception e) {
			System.out.println("Error");
			System.out.println("error");
		}
		
		
		return Status;
	}
	public String ContractGenerationCMA() throws Throwable {

		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Generate Contract')]")));
		// Open generate contract modal
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, "ERCOT CMA TC");

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		// functions.intermediatewait();

		// Selects contact name from the Dropdown
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-arrow-wrapper']")));
		functions.click(driver, contactNameDropdown);

		contactNameValue.get(0).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to Customer ')]")));

		functions.click(driver, addContactToCustomerBtn);
		
		try {
		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}
		}
		catch (Exception n) {
			System.out.println("Accept Address is not displayed");
		}

		// Wait for spinner to appear Contact Info
		// functions.mediumWait();

		// Choose approver
//        WebDriverWait wait6 = new WebDriverWait(driver, 200);
//        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//                "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
		functions.midintermediatewait();
		functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		
			}
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
		
		return Status;
	}

	/*
	 * Generate contract workflow for Aggregate with Fixed Product >50wkh.
	 */

	public String GenerateContractforAggregate() throws Throwable {
		
		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {

		// Open generate contract modal
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Generate Contract')]")));
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("TemplateName"));

		// Add contact notice address for 1st Customer
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();
		// Selects contact name from the Dropdown
		functions.click(driver, contactNameDropdown);
		contactNameValue.get(0).click();
		functions.click(driver, addContactToCustomerBtn);


		// Wait for spinner to appear Contact Info
		functions.mediumWait();

		// Add contact notice address for Second Customer
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();
		// Selects contact name from the Dropdown
		functions.click(driver, contactNameDropdown);
		functions.intermediatewait();
		contactNameValue.get(0).click();
		functions.click(driver, addContactToCustomerBtn);
//
//		if (AcceptAddressBtn.isDisplayed() == true) {
//
//			functions.click(driver, AcceptAddressBtn);
//		}

		// Wait for spinner to appear Contact Info
		functions.mediumWait();
		// Choose approver
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.shortWait();

		// Wait for dealoption status to get Approved
		functions.intermediatewait();
			}
		}
		
		catch (Exception e) {
			System.out.println("Error");
		}
		
		
		return Status;
	}

	public String ContractGenerationBI() throws Throwable {
		
		driver.navigate().refresh();
		functions.intermediatewait();
		functions.click(driver, Dealoptiontab);
		functions.vshortWait();
		functions.click(driver, Generatecontractbi);
		// Fill out modal
				WebDriverWait wait1 = new WebDriverWait(driver, 200);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
				functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

				// Select the option using the visible text
				WebDriverWait wait2 = new WebDriverWait(driver, 200);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
				functions.selectDropdownByVisibleText(driver, templateName, " Short Form General Terms (100% Real Time Index)");

				// Add contact notice address
				WebDriverWait wait3 = new WebDriverWait(driver, 200);
				wait3.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
				functions.click(driver, noticeAddressBtn);

				// Wait for spinner to appear Contact Info
				// functions.intermediatewait();

				// Selects contact name from the Dropdown
				WebDriverWait wait4 = new WebDriverWait(driver, 200);
				wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-arrow-wrapper']")));
				functions.click(driver, contactNameDropdown);

				contactNameValue.get(0).click();

				WebDriverWait wait5 = new WebDriverWait(driver, 200);
				wait5.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to Customer ')]")));

				functions.click(driver, addContactToCustomerBtn);
				
				try {
				if (AcceptAddressBtn.isDisplayed() == true) {

					functions.click(driver, AcceptAddressBtn);
				}
				}
				catch (Exception n) {
					System.out.println("Accept Address is not displayed");
				}

				// Wait for spinner to appear Contact Info
				// functions.mediumWait();

				// Choose approver
//		        WebDriverWait wait6 = new WebDriverWait(driver, 200);
//		        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//		                "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
				functions.midintermediatewait();
				functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

				// Generate contract
				try {
					contractBtn.get(1).click();
				} catch (StaleElementReferenceException e) {
					e.getMessage();
				}

				// Wait for spinner to Load
				functions.intermediatewait();
				
					
				
				
				return Status;
			}
	
	

	/*
	 * Generate contract workflow for Aggregate with Index Product >50wkh.
	 */

	public void ContractGenerationforAggregate() throws Throwable {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("IndexTemplateName"));
		// Add contact notice address for 1st Customer
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();
		// Selects contact name from the Dropdown
		functions.click(driver, contactNameDropdown);
		contactNameValue.get(0).click();
		functions.click(driver, addContactToCustomerBtn);

		// Wait for spinner to appear Contact Info
		functions.mediumWait();

		// Add contact notice address for Second Customer
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();
		// Selects contact name from the Dropdown
		functions.click(driver, contactNameDropdown);
		contactNameValue.get(0).click();
		functions.click(driver, addContactToCustomerBtn);

		// Wait for spinner to appear Contact Info
		functions.mediumWait();
		// Choose approver
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));

		// Generate contract
		contractBtn.get(1).click();

		// Wait for spinner to Load
		functions.intermediatewait();

		// Wait for dealoption status to get Approved
		functions.longWait();

	}

	/*
	 * Generate contract workflow for Aggregate with Index Product >50kwh.
	 */

	public void ContractGenerationforSingle() throws Throwable {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("IndexTemplateName"));
		// Add contact notice address for 1st Customer
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();
		// Selects contact name from the Dropdown
		functions.click(driver, contactNameDropdown);
		contactNameValue.get(0).click();
		functions.click(driver, addContactToCustomerBtn);

		// Wait for spinner to appear Contact Info
		functions.mediumWait();

		// Choose approver
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));

		// Generate contract
		contractBtn.get(1).click();

		// Wait for spinner to Load
		functions.intermediatewait();

		// Wait for dealoption status to get Approved
		functions.longWait();

	}

	/*
	 * Generate contract for <50kwh workflow.
	 */

	public String ContractGenerationfor50kwh() throws Throwable {
		
		
		
		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, "ERCOT PC Agreement");

		// Fill out modal
		functions.selectDropdownByVisibleText(driver, languagedropdown, "ENGLISH");

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 500);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Contact')]")));
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, prop.getProperty("Firstname"));
		functions.setText(driver, Lastname, prop.getProperty("Lastname"));
		functions.setText(driver, Addressbox, prop.getProperty("Addressbox"));
		functions.setText(driver, City, prop.getProperty("City"));
		functions.selectDropdownByVisibleText(driver, Statedropdown, prop.getProperty("Statedropdown"));
		functions.shortWait();
		functions.setText(driver, zipcode, prop.getProperty("ZIP"));
		functions.setText(driver, email, prop.getProperty("email"));
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Click on Create Anyways Button
		WebDriverWait wait9 = new WebDriverWait(driver, 50);
		wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Anyways')]")));
		functions.click(driver, CreateanywaysBTn);


		// Wait for spinner to appear Contact Info
		functions.midintermediatewait();

		// Passing Text in the GeneralPartner Field
		functions.setText(driver, GeneralPartnerField, prop.getProperty("Dealoptionname"));

		// Choose Approver from the Approver Dropdown
		functions.selectDropdownByVisibleText(driver, Approverdropdownforlessthan50, prop.getProperty("Approver"));

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
return Status;
	}
	/*
	 * Generate contract workflow for Aggregate Customer.
	 */

	public String ContractGenerationforAggregatelessthan50() throws Throwable {
		
		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Fill out modal
		functions.setText(driver, templateName, prop.getProperty("PCTemplateName"));

		// Fill out modal
		functions.setText(driver, languagedropdown, prop.getProperty("LanguagePreference2"));
		// Add contact notice address for 1st Customer
		functions.click(driver, noticeAddressBtn);
		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, prop.getProperty("Firstname"));
		functions.setText(driver, Lastname, prop.getProperty("Lastname"));
		functions.setText(driver, Addressbox, prop.getProperty("Addressbox"));
		functions.setText(driver, City, prop.getProperty("City"));
		functions.selectDropdownByVisibleText(driver, Statedropdown, prop.getProperty("Statedropdown"));
		functions.shortWait();
		functions.setText(driver, zipcode, prop.getProperty("ZIP"));
		functions.setText(driver, email, prop.getProperty("email"));
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on Create Anyways Button
		functions.click(driver, CreateanywaysBTn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// Add contact notice address for 1st Customer
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, prop.getProperty("Firstname"));
		functions.setText(driver, Lastname, prop.getProperty("Lastname"));
		functions.setText(driver, Addressbox, prop.getProperty("Addressbox"));
		functions.setText(driver, City, prop.getProperty("City"));
		functions.selectDropdownByVisibleText(driver, Statedropdown, prop.getProperty("Statedropdown"));
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(prop.getProperty("ZIP")));
		functions.setText(driver, email, prop.getProperty("email"));
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on Create Anyways Button
		functions.click(driver, CreateanywaysBTn);

		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// Choose Approver from the Approver Dropdown
		functions.selectDropdownByVisibleText(driver, Approverdropdownforlessthan50, prop.getProperty("Approver"));

		// Generate contract
		contractBtn.get(1).click();

		// Wait for spinner to Load
		functions.intermediatewait();

		// Wait for dealoption status to get Approved
		functions.longWait();

			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
return Status;
	}

	/*
	 * Generate contract for Renewal <50kwh workflow.
	 */

	public String ContractGenerationforRenewal() throws Throwable {
		

		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Fill out modal
		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, "ERCOT Protected Class Agreement");

		// Fill out modal
		functions.selectDropdownByVisibleText(driver, languagedropdown, "ENGLISH");

		// Add contact notice address
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, prop.getProperty("Firstname"));
		functions.setText(driver, Lastname, prop.getProperty("Lastname"));
		functions.setText(driver, Addressbox, prop.getProperty("Addressbox"));
		functions.setText(driver, City, prop.getProperty("City"));
		functions.selectDropdownByVisibleText(driver, Statedropdown, prop.getProperty("Statedropdown"));
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(prop.getProperty("ZIP")));
		functions.setText(driver, email, prop.getProperty("email"));
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Wait for Sometime
		functions.shortWait();

		// Click on Create Anyways Button
		functions.click(driver, CreateanywaysBTn);


		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// Passing Text in the GeneralPartner Field
		functions.setText(driver, GeneralPartnerField, "Test");

		// Wait for Sometime
		functions.vshortWait();

		// Choose Approver from the Approver Dropdown
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));

		// Generate contract
		contractBtn.get(1).click();

		// Wait for spinner to Load
		functions.intermediatewait();

		System.out.println("Validating contract creation successful.");

		// Wait for dealoption status to get Approved
		functions.mediumWait();
		
			}
		}
		catch(Exception e) {
			System.out.println("Error");
		}
return Status;
	}
	/*
	 * Generate contract workflow for Single with Fixed Product>50wkh.
	 */

	public String ContractGenerate() throws Throwable {
		
		try {
			if (generatecontractdisabled.size() >= 0 == true
					&& generatecontractdisabled.get(0).isEnabled() == true) {

		// Open generate contract modal
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("TemplateName"));

//		// Add contact notice address
//		 functions.click(driver, noticeAddressBtn);
//
//		// Wait for spinner to appear Contact Info
//		functions.intermediatewait();
//
//		// Selects contact name from the Dropdown
//		 functions.click(driver, contactNameDropdown);
//
//		 contactNameValue.get(0).click();
//
//		 functions.click(driver, addContactToCustomerBtn);
//		 
//		 if (AcceptAddressBtn.isDisplayed() == true) {
//
//				functions.click(driver, AcceptAddressBtn);
//			}
//
//		// Wait for spinner to appear Contact Info
//		 functions.mediumWait();

		functions.click(driver, approverDropdown);
		// Choose approver
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));

		functions.intermediatewait();
		// Choose approver

		// Generate contract
		contractBtn.get(1).click();

		// Wait for spinner to Load
		functions.intermediatewait();

		System.out.println("Validating contract creation successful.");

		// Wait for dealoption status to get Approved
		functions.mediumWait();
		
			}
		}

		catch(Exception e) {
			System.out.println("Error");
		}
return Status;

	}
	/*
	 * Generate contract workflow for Single Protected Class with Fixed
	 * Product>50wkh.
	 */

	public void ContractGenerationforProtectedClass(int Rowvalue, String firstname, String lastname, String address,
			String phone, String city,

			String Zip, String State, String Email, String Dealoptionname, String TemplateName, String Approver,
			String Fax) throws Throwable {

		int a = Rowvalue;
		try {
			if (siteerror.isDisplayed() == true) {
				System.out.println("site error");
			}
		} catch (Exception n) {

			try {
				if (CI.isDisplayed() == true) {
					// Create an object of FileInputStream class to read excel file
					FileInputStream fis = new FileInputStream(
							new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));

					// Create object of XSSFWorkbook class
					XSSFWorkbook workbook = new XSSFWorkbook(fis);

					// Read excel sheet by sheet name
					XSSFSheet sheet = workbook.getSheet("Data");

					// Get the Cell at index from the above row
					XSSFCell cell = sheet.getRow(a + 1).getCell(55);

					cell.setCellType(CellType.STRING);
					cell.setCellValue("C&I Approver needed");

					// Write the output to the file
					FileOutputStream fileOut = new FileOutputStream(
							new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));
					workbook.write(fileOut);

					System.out.println("Id column in Excel is updated successfully");
					fileOut.close();

					// Closing the workbook
					workbook.close();
					// Navigate to DSP URL
					putsbox.navigateToDSP(prop.getProperty("dsp-url"));
				}
			} catch (Exception n1) {

				try {
					if (SeniorVice.isDisplayed() == true) {
						// Create an object of FileInputStream class to read excel file
						FileInputStream fis = new FileInputStream(
								new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));

						// Create object of XSSFWorkbook class
						XSSFWorkbook workbook = new XSSFWorkbook(fis);

						// Read excel sheet by sheet name
						XSSFSheet sheet = workbook.getSheet("Data");

						// Get the Cell at index from the above row
						XSSFCell cell = sheet.getRow(a + 1).getCell(55);

						cell.setCellType(CellType.STRING);
						cell.setCellValue("Approver needed");

						// Write the output to the file
						FileOutputStream fileOut = new FileOutputStream(
								new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));
						workbook.write(fileOut);

						System.out.println("Id column in Excel is updated successfully");
						fileOut.close();

						// Closing the workbook
						workbook.close();
						// Navigate to DSP URL
						putsbox.navigateToDSP(prop.getProperty("dsp-url"));
					}

				} catch (Exception n5) {

					try {
						if (ManagerSales.isDisplayed() == true) {
							// Create an object of FileInputStream class to read excel file
							FileInputStream fis = new FileInputStream(
									new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));

							// Create object of XSSFWorkbook class
							XSSFWorkbook workbook = new XSSFWorkbook(fis);

							// Read excel sheet by sheet name
							XSSFSheet sheet = workbook.getSheet("Data");

							// Get the Cell at index from the above row
							XSSFCell cell = sheet.getRow(a + 1).getCell(55);

							cell.setCellType(CellType.STRING);
							cell.setCellValue("Approver needed");

							// Write the output to the file
							FileOutputStream fileOut = new FileOutputStream(
									new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));
							workbook.write(fileOut);

							System.out.println("Id column in Excel is updated successfully");
							fileOut.close();

							// Closing the workbook
							workbook.close();
							// Navigate to DSP URL
							putsbox.navigateToDSP(prop.getProperty("dsp-url"));
						}

					} catch (Exception n4) {

						try {
							if (Vintagebanner.isDisplayed() == true) {
								// Create an object of FileInputStream class to read excel file
								FileInputStream fis = new FileInputStream(new File(
										".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));

								// Create object of XSSFWorkbook class
								XSSFWorkbook workbook = new XSSFWorkbook(fis);

								// Read excel sheet by sheet name
								XSSFSheet sheet = workbook.getSheet("Data");

								// Get the Cell at index from the above row
								XSSFCell cell = sheet.getRow(a + 1).getCell(55);

								cell.setCellType(CellType.STRING);
								cell.setCellValue("Vintage site issue");

								// Write the output to the file
								FileOutputStream fileOut = new FileOutputStream(new File(
										".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));
								workbook.write(fileOut);

								System.out.println("Id column in Excel is updated successfully");
								fileOut.close();

								// Closing the workbook
								workbook.close();
								// Navigate to DSP URL
								putsbox.navigateToDSP(prop.getProperty("dsp-url"));
							}

						} catch (Exception n6) {
							try {

								// Open generate contract modal
								/// Add Pre approved condition
								if (Preapproved.isDisplayed() == true) {
									if (generatecontractdisabled.size() >= 0 == true
											&& generatecontractdisabled.get(0).isEnabled() == true) {
										functions.click(driver, generateContractModalBtn);

										// Fill out modal
										functions.setText(driver, dealOptionName, Dealoptionname);

										// Select the option using the visible text
										if (templateName1.size() >= 0 == true
												&& templateName1.get(0).isDisplayed() == true) {
											WebDriverWait wait2 = new WebDriverWait(driver, 200);
											wait2.until(ExpectedConditions.visibilityOfElementLocated(
													By.xpath("//select[@id='templateName']")));
											functions.selectDropdownByVisibleText(driver, templateName,
													"ERCOT Protected Class Agreement");
										}

										// try {
										if (noticeAddress.get(0).isDisplayed() == true) {
											// Add contact notice address
											WebDriverWait wait3 = new WebDriverWait(driver, 500);
											wait3.until(ExpectedConditions.visibilityOfElementLocated(
													By.xpath("//button[contains(text(), 'Enter Info')]")));
											functions.click(driver, noticeAddressBtn);

											// Wait for spinner to appear Contact Info
											functions.intermediatewait();

											// click on create btn
											WebDriverWait wait4 = new WebDriverWait(driver, 50);
											wait4.until(ExpectedConditions.visibilityOfElementLocated(
													By.xpath("//button[contains(text(),'Create Contact')]")));
											functions.click(driver, CreateContact);

											// Enter the Customer Notice Address details
											functions.setText(driver, Firstname, firstname);
											functions.setText(driver, Lastname, lastname);
											functions.setText(driver, Addressbox, address);
											// functions.setText(driver, cellphone, phone);
											functions.setText(driver, workphone, phone);
											functions.setText(driver, City, city);
											functions.selectDropdownByVisibleText(driver, Statedropdown, "Texas");
											functions.shortWait();
											zipcode.sendKeys(String.valueOf(Zip));
											functions.setText(driver, Faxbtn, Fax);
											functions.setText(driver, email, Email);
											functions.shortWait();
											functions.click(driver, AddCreatebtn);
											functions.shortWait();
											try {
												if (updatebtn.isDisplayed()) {
													functions.click(driver, updatebtn);
												}
											} catch (Exception n3) {
												if (CreateanywaysBTn.isDisplayed()) {
													functions.click(driver, CreateanywaysBTn);
													// functions.click(driver, AcceptAddress);
												}
											}
//                        
											// Wait for spinner to appear Contact Info
											functions.longWait();
//                         WebDriverWait wait5 = new WebDriverWait(driver, 50);
//                         wait5.until(
//                                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control ng-dirty ng-touched ng-valid']")));
											// Choose approver

											functions.selectDropdownByVisibleText(driver, approverDropdown,
													"Automated Approval");
											// functions.selectDropdownByVisibleText(driver,approverDropdown1
											// ,"Automated Approval");
											functions.vshortWait();

											try {
												contractBtn.get(1).click();
											} catch (StaleElementReferenceException e) {
												e.getMessage();
											}

											// }
										}

										// else if(s == findElement(By. xpath("(//tr[@ng-reflect-form='[object
										// Object]']//span)[1]")). getText()) {
										else if (pencilbtn.isDisplayed() == true) {
											// if (!noticeAddress.get(0).isDisplayed() == true) {
											functions.selectDropdownByVisibleText(driver, approverDropdown,
													"Automated Approval");
											// functions.selectDropdownByVisibleText(driver,approverDropdown1
											// ,"Automated Approval");
											functions.vshortWait();

											try {
												contractBtn.get(1).click();
											} catch (StaleElementReferenceException e) {
												e.getMessage();
											}
										} else {
											System.out.println("Unable to create Contract");
										}

									} else {

										// Navigate to DSP URL
										// putsbox.navigateToDSP(prop.getProperty("dsp-url"));
										System.out.println("print");
									}
								}
							} catch (Exception n2) {
								System.out.println("Element is visible");
								functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

								functions.vshortWait();

								try {
									contractBtn.get(1).click();
								} catch (StaleElementReferenceException e) {
									e.getMessage();
								}
							}

							// Wait for spinner to Load
							functions.intermediatewait();
						}
					}
				}
			}
		}
	}

//    private WebElement findElement(By xpath) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void Navigatetodsp() throws Throwable {

		putsbox.navigateToDSP(prop.getProperty("dsp-url"));

	}

	public void ContractGenerationmultiplecontract(int Rowvalue, String firstname, String lastname, String address,
			String phone, String city,

			String Zip, String State, String Email, String Dealoptionname, String TemplateName, String Approver,
			String Fax) throws Throwable {
		int a = Rowvalue;
//		try{
//         	if(invalidterm.isDisplayed()==true) {        	
//         		System.out.println("invalid term");
//         	}
//         }catch(Exception n8) {
//        	 try {
//					if (Vintagebanner.isDisplayed() == true && Preapproved.isDisplayed() == true) {					
//						System.out.println("vintage issue");
//					}
//				} catch (Exception n1) {
					
					try {
						// Open generate contract modal
						if (Preapproved.isDisplayed() == true) {
							if (generatecontractdisabled.size() >= 0 == true
									&& generatecontractdisabled.get(0).isEnabled() == true) {
								functions.click(driver, generateContractModalBtn);
try {
if(Continuebtn.isDisplayed() == true) {
	functions.click(driver, Continuebtn);
}
}catch(Exception n13) {
								// Fill out modal
								functions.setText(driver, dealOptionName, Dealoptionname);

								// Select the option using the visible text
								if (templateName1.size() >= 0 == true
										&& templateName1.get(0).isDisplayed() == true) {
									WebDriverWait wait2 = new WebDriverWait(driver, 200);
									wait2.until(ExpectedConditions
											.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
									functions.selectDropdownByVisibleText(driver, templateName,
											"ERCOT Protected Class Agreement");

								}	
								}

								try {
									if (noticeAddress.get(0).isDisplayed() == true) {
										// Add contact notice address
										WebDriverWait wait3 = new WebDriverWait(driver, 500);
										wait3.until(ExpectedConditions.visibilityOfElementLocated(
												By.xpath("//button[contains(text(), 'Enter Info')]")));
										functions.click(driver, noticeAddressBtn);

										// Wait for spinner to appear Contact Info
										functions.intermediatewait();

										// click on create btn
										WebDriverWait wait4 = new WebDriverWait(driver, 50);
										wait4.until(ExpectedConditions.visibilityOfElementLocated(
												By.xpath("//button[contains(text(),'Create Contact')]")));
										functions.click(driver, CreateContact);

										// Enter the Customer Notice Address details
										functions.setText(driver, Firstname, firstname);
										functions.setText(driver, Lastname, lastname);
										functions.setText(driver, Addressbox, address);
										// functions.setText(driver, cellphone, phone);
										functions.setText(driver, workphone, phone);
										functions.setText(driver, City, city);
										functions.selectDropdownByVisibleText(driver, Statedropdown, "Texas");
										functions.minwait();
										zipcode.sendKeys(String.valueOf(Zip));
										functions.setText(driver, Faxbtn, Fax);
										functions.setText(driver, email, Email);
										functions.minwait();
										functions.click(driver, AddCreatebtn);
										functions.shortWait();
										try {
											if (updatebtn.isDisplayed()) {
												functions.click(driver, updatebtn);
											}
										} catch (Exception n3) {
											if (CreateanywaysBTn.isDisplayed()) {
												functions.click(driver, CreateanywaysBTn);
												 functions.click(driver, AcceptAddress);
											}
										}
//                    
										// Wait for spinner to appear Contact Info
										functions.maxWait();
//                     WebDriverWait wait5 = new WebDriverWait(driver, 50);
//                     wait5.until(
//                             ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control ng-dirty ng-touched ng-valid']")));
										// Choose approver

										functions.selectDropdownByVisibleText(driver, approverDropdown,
												"Automated Approval");
										

										try {
											contractBtn.get(1).click();
										} catch (StaleElementReferenceException e) {
											e.getMessage();
										}

									}

								} catch (Exception n2) {
									System.out.println("Element is visible");
									functions.selectDropdownByVisibleText(driver, approverDropdown,
											"Automated Approval");
									
									try {
										contractBtn.get(1).click();
									} catch (StaleElementReferenceException e) {
										e.getMessage();
									}
								}

								// Wait for spinner to Load
								functions.shortWait();
							}
							else {
								System.out.println("Unable to create Contract");
							}
							

						} else {
								System.out.println("print");

						}
						
					
					}catch (Exception n9) {
						
				//********Use these catch block for C&I  put xcel reading
											
					}

//		try {
//			if (AddCustomerbanner.isDisplayed() == true) {
//				System.out.println("Customer issue");
//			}
//		} catch (Exception n7) {
//			try {
//				if(CreateCustomerbanner.isDisplayed()==true) {
//					System.out.println("Customer issue");
//				}
//			}catch(Exception n11) {
//			try {
//				if (Sitesnotadded.isDisplayed() == true) {
//					System.out.println("Sites not added");
//				}
//			} catch (Exception n6) {
//				try {
//					if (siteerror.isDisplayed() == true) {
//						System.out.println("site error");
//					}
//				} catch (Exception n) {
//					
//					
//					}
							
				}
		//	}
			//}
		//	}
      //   }
	//		}

	/*
	 * Generate contract workflow for Aggregate Protected Class with Fixed
	 * Product>50wkh.
	 */

	public void ContractGenerationAggregateforProtectedClass(String firstname, String lastname, String address,
			String city, String Zip, String State, String Email) throws Throwable {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("TemplateName"));

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 500);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Contact')]")));
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, firstname);
		functions.setText(driver, Lastname, lastname);
		functions.setText(driver, Addressbox, address);
		functions.setText(driver, City, city);
		functions.selectDropdownByVisibleText(driver, Statedropdown, State);
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(Zip));
		functions.setText(driver, email, Email);
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Click on Create Anyways Button
		WebDriverWait wait9 = new WebDriverWait(driver, 50);
		wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Anyways')]")));
		functions.click(driver, CreateanywaysBTn);

		// Wait for spinner to appear Contact Info
		functions.midintermediatewait();

		// Add contact notice address
		WebDriverWait wait12 = new WebDriverWait(driver, 500);
		wait12.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		WebDriverWait wait11 = new WebDriverWait(driver, 50);
		wait11.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Contact')]")));
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, firstname);
		functions.setText(driver, Lastname, lastname);
		functions.setText(driver, Addressbox, address);
		functions.setText(driver, City, city);
		functions.selectDropdownByVisibleText(driver, Statedropdown, State);
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(Zip));
		functions.setText(driver, email, Email);
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Click on Create Anyways Button
		WebDriverWait wait10 = new WebDriverWait(driver, 50);
		wait10.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Anyways')]")));
		functions.click(driver, CreateanywaysBTn);

		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}

		// Wait for spinner to appear Contact Info
		functions.midintermediatewait();

		// Passing Text in the GeneralPartner Field
		functions.setText(driver, GeneralPartnerField, "Test");

		// Choose approver
		WebDriverWait wait6 = new WebDriverWait(driver, 40);
		wait6.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//Select[@ng-reflect-name='approverSelector0']")));
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver"));
		functions.selectDropdownByVisibleText(driver, approverDropdown1, prop.getProperty("Approver"));
		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();

	}

	/*
	 * Generate contract workflow for Single Protected Class with Fixed
	 * Product>50wkh Using XML File.
	 */

	public void ContractGenerationforProtectedClassXML(String Dealoptionname, String Templatename, String firstname,
			String lastname, String Address, String city, String State, String Zip, String Email, String Approver)
			throws Throwable {

		// Open generate contract modal

		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		functions.setText(driver, dealOptionName, Dealoptionname);

		// Select the option using the visible text
		if (templateName1.size() > 0 == true && templateName1.get(1).isDisplayed() == true) {
			WebDriverWait wait2 = new WebDriverWait(driver, 200);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
			functions.selectDropdownByVisibleText(driver, templateName, Templatename);
		}
		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 500);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		wait4.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Contact')]")));
		functions.click(driver, CreateContact);

		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, firstname);
		functions.setText(driver, Lastname, lastname);
		functions.setText(driver, Addressbox, Address);
		functions.setText(driver, City, city);
		functions.selectDropdownByVisibleText(driver, Statedropdown, State);
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(Zip));
		functions.setText(driver, email, Email);
		functions.shortWait();
		functions.click(driver, AddCreatebtn);

		// Click on Create Anyways Button
		WebDriverWait wait9 = new WebDriverWait(driver, 50);
		wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Anyways')]")));
		functions.click(driver, CreateanywaysBTn);

		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}

		// Wait for spinner to appear Contact Info
		functions.midintermediatewait();

		// Passing Text in the GeneralPartner Field
		functions.setText(driver, GeneralPartnerField, Dealoptionname);

		// Choose approver

//		WebDriverWait wait6 = new WebDriverWait(driver, 40);
//		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
//		functions.selectDropdownByVisibleText(driver, approverDropdown, Approver);
		// Choose Approver from the Approver Dropdown
		functions.selectDropdownByVisibleText(driver, Approverdropdownforlessthan50, Approver);
		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();

	}

	public String ContractGenerationDOA() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Generate Contract')]")));
		// Open generate contract modal
		functions.click(driver, generateContractModalBtn);

		// Fill out modal
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, prop.getProperty("TemplateName"));

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		functions.intermediatewait();

		// click on create btn
		functions.click(driver, CreateContact);
		// Enter the Customer Notice Address details
		functions.setText(driver, Firstname, prop.getProperty("Firstname"));
		functions.setText(driver, Lastname, prop.getProperty("Lastname"));
		functions.setText(driver, Addressbox, prop.getProperty("Addressbox"));
		functions.setText(driver, City, prop.getProperty("City"));
		functions.selectDropdownByVisibleText(driver, Statedropdown, prop.getProperty("Statedropdown"));
		functions.shortWait();
		zipcode.sendKeys(String.valueOf(prop.getProperty("ZIP")));
		functions.setText(driver, email, prop.getProperty("email"));
		functions.shortWait();
		functions.click(driver, AddCreatebtn);
		// Click on Create Anyways Button
		WebDriverWait wait9 = new WebDriverWait(driver, 50);
		wait9.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Anyways')]")));
		functions.click(driver, CreateanywaysBTn);

	
		// Wait for spinner to appear Contact Info
		functions.mediumWait();

		// Passing Text in the GeneralPartner Field
		functions.setText(driver, GeneralPartnerField, "Test");

		// Wait for Sometime
		functions.midintermediatewait();

		// Choose approver
		WebDriverWait wait6 = new WebDriverWait(driver, 200);
		wait6.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//Select[@ng-reflect-name='approverSelector0']")));
		functions.selectDropdownByVisibleText(driver, approverDropdown, prop.getProperty("Approver1"));

		// Generate contract
		try {
			contractBtn.get(1).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		
		String Status="Pass";
		
		return Status;

	}
	
	
	/*
	 * Generate contract workflow for Non Ercot with Fixed Product>50wkh.
	 */

	public String ContractGenerationNonercot() throws Throwable {

		try {
			driver.navigate().refresh();
			WebDriverWait wait1 = new WebDriverWait(driver, 200);
			wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-link']")));
			functions.midintermediatewait();
			
			if (generatecontractenabled.size() >= 0 == true
					&& generatecontractenabled.get(0).isEnabled() == true) {
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-link']")));
		// Open generate contract modal
		generatecontractenabled.get(1).click();

		// Fill out modal
		WebDriverWait wait12 = new WebDriverWait(driver, 200);
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		functions.setText(driver, dealOptionName, prop.getProperty("Dealoptionname"));

		// Select the option using the visible text
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='templateName']")));
		functions.selectDropdownByVisibleText(driver, templateName, "PJM Short Form FP Cover Page");

		// Add contact notice address
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Enter Info')]")));
		functions.click(driver, noticeAddressBtn);

		// Wait for spinner to appear Contact Info
		// functions.intermediatewait();

		// Selects contact name from the Dropdown
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-arrow-wrapper']")));
		functions.click(driver, contactNameDropdown);

		contactNameValue1.get(0).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add to Customer ')]")));

		functions.click(driver, addContactToCustomerBtn);
		
		try {
		if (AcceptAddressBtn.isDisplayed() == true) {

			functions.click(driver, AcceptAddressBtn);
		}
		}
		catch (Exception n) {
			System.out.println("Accept Address is not displayed");
		}

		// Wait for spinner to appear Contact Info
		// functions.mediumWait();

		// Choose approver
//        WebDriverWait wait6 = new WebDriverWait(driver, 200);
//        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//                "/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")));
		functions.midintermediatewait();
		functions.selectDropdownByVisibleText(driver, approverDropdown, "Automated Approval");

		// Generate contract
		try {
			contractBtn.get(0).click();
		} catch (StaleElementReferenceException e) {
			e.getMessage();
		}

		// Wait for spinner to Load
		functions.intermediatewait();
		
			}
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		
		
		return Status;
	}
	public void writevintage(int Rowvalue) throws Throwable {
		int a = Rowvalue;
		try {
			if (Vintagebanner.isDisplayed() == true && Preapproved.isDisplayed() == true) {

				////// ********update xcel reading condition for vintage
				// Create an object of FileInputStream class to read excel file
				FileInputStream fis = new FileInputStream(
						new File(prop.getProperty("Excelpath")));

				// Create object of XSSFWorkbook class
				XSSFWorkbook workbook = new XSSFWorkbook(fis);

				// Read excel sheet by sheet name
				XSSFSheet sheet = workbook.getSheet("Data");

				// Get the Cell at index from the above row
				XSSFCell cell = sheet.getRow(a + 1).getCell(55);
                System.out.println(a);
				cell.setCellType(CellType.STRING);
				cell.setCellValue("Vintage site issue");

				// Write the output to the file
				FileOutputStream fileOut = new FileOutputStream(
						new File(prop.getProperty("Excelpath")));
				workbook.write(fileOut);

				System.out.println("Id column in Excel is updated successfully");
				fileOut.close();

				// Closing the workbook
				workbook.close();
				
			}
		} catch (Exception n1) {
System.out.println("vintage issue");
	}
	}
}
