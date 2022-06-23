package Pages.DSP;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AddCustomerPopup {
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),' Customer name is required. ')]")
	WebElement CustomerNamerequired;
	@FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
	WebElement addCustomerBtn;
	@FindBy(xpath = "//input[@id='typeahead-customer']")
	WebElement customerNameInput;
	@FindBy(xpath = "//button[contains(text(), 'Create Customer')]")
	WebElement createCustomerBtn;
	@FindBy(xpath = "//*[@class='dropdown open dropdown-menu']")
	WebElement customersLst;
	@FindBy(xpath = "//div[@class='col p-3']")
	WebElement firstCustomerCard;
	@FindBy(xpath = "//button[contains(text(), 'Add To Opportunity')]")
	WebElement addCustomerToOptyBtn;
	@FindBy(xpath = "//button[contains(text(), 'Renew')]")
	WebElement renewButton;
	@FindBy(xpath = "//button[contains(text(), 'Restructure')]")
	WebElement restructureBtn;
	@FindBy(xpath = "//button[contains(text(), 'Create New Deal')]")
	WebElement createNewDealBtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(), 'Create New Deal')]") })
	public List<WebElement> createNewDealBtn1;

	@FindBy(xpath = "//button[contains(text(),'Renew')]")
	WebElement renewBtn;
	@FindBy(xpath = "//h3[@class='mdi mdi-menu-right']")
	WebElement contractexpandBtn;
	@FindBy(xpath = "//div[@class='control__indicator contract-checkbox']")
	WebElement contractCheckbox;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator contract-checkbox']") })
	public List<WebElement> contractCheckbox50kwh;
	@FindBy(xpath = "//button[contains(text(), 'Create Renewal Opportunity')]")
	WebElement createRenewalOptyBtn;
	@FindBy(xpath = "//a[contains(text(),'Renewals Pipeline')]")
	WebElement RenewalPipelineBTn;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator site-checkbox']") })
	public List<WebElement> SelectAllBtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi icon-renew mdi-autorenew']") })
	public List<WebElement> autorenewBtn;
	@FindAll(value = { @FindBy(xpath = "//span[@class='font-weight-light']") })
	public List<WebElement> contractidtext;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
	WebElement sitesComponentCart;
	@FindAll(value = { @FindBy(xpath = "//span[@class='mdi mdi-menu-swap']") })
	public List<WebElement> AnnualUsageMenuswapper;
	@FindBy(xpath = "//span[@class='mdi mdi-menu-up']")
	WebElement AnnualUsageMenuUp;
	@FindBy(xpath = "//span[@class='mdi mdi-menu-down']")
	WebElement AnnualUsageMenudown;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator']") })
	public List<WebElement> EsIidCheckbox;
	@FindAll(value = { @FindBy(xpath = "//div[@class='control__indicator contract-checkbox']") })
	public List<WebElement> Contractcbox;
	@FindAll(value = { @FindBy(xpath = "//button[@class='btn btn-link edit-button']") })
	public List<WebElement> editbtn;
	@FindBy(xpath = "	//button[normalize-space()='SAVE']")
	WebElement savebtn;	

	
	@FindBy(xpath = "//select[@id='salesGroup']")
	WebElement salesgrpbtn;	
	@FindBy(xpath = "//select[@id='sales-channel']")
	WebElement saleschannelbtn;
	@FindBy(xpath = "//select[@id='contract-brand']")
	WebElement contractbrandbtn;
	@FindBy(xpath = "//h4[contains(text(), 'Add Customer')]")
	WebElement AddCustomerbanner;
	
	@FindBy(xpath = "//h4[contains(text(), 'Create Customer')]")
	WebElement CreateCustomerbanner;
	@FindBy(xpath = "//span[@class='mdi mdi-24px mdi-chevron-down']")
	WebElement seedetailsbtn;
	@FindBy(xpath = "//input[@id='typeahead-accountRep']")
	WebElement accountrepbtn;
	@FindBy(xpath = "//input[@id='typeahead-ema']")
	WebElement emabtn;
	@FindBy(xpath = "//input[@id='typeahead-thirdparty']")
	WebElement thirdpartybtn;
	@FindAll(value = { @FindBy(xpath = "//div[@class='col p-3']") })
	public List<WebElement>customersize;
	@FindAll(value = { @FindBy(xpath = "//p[@class='typeahead-options-detail']") })
	public List<WebElement> customeraddresssource;
	@FindBy(xpath = "//p[contains(text(), 'VHOS')]")
	WebElement vhosbtn;
	@FindBy(xpath = "//input[@id='customerName']")
	WebElement customerNamefield;
	@FindBy(xpath = "//input[@id='address']")
	WebElement addressfield;
	@FindBy(xpath = "//input[@id='customerCity']")
	WebElement cityfield;
	@FindBy(xpath = "//select[@id='state']")
	WebElement statefield;
	@FindBy(xpath = "//input[@id='customerZip']")
	WebElement zipfield;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phonefield;
	@FindBy(xpath = "//select[@id='businessType']")
	WebElement businesstypefield;
	@FindBy(xpath = "//input[@id='accountRep']")
	WebElement accountrepfield;
	@FindBy(xpath = "//input[@id='typeahead-ema']")
	WebElement emafield;
	@FindBy(xpath = "//select[@id='salesChannel']")
	WebElement saleschannelfield;
	@FindBy(xpath = "//input[@id='dba']")
	WebElement dbafield;
	@FindBy(xpath = "//button[contains(text(), 'Create and Add')]")
	WebElement createnewcustomer;
	@FindBy(xpath = "//button[contains(text(), 'Update')]")
	WebElement updatebtn;
	@FindBy(xpath = "//button[contains(text(),'Create Anyways')]")
	WebElement CreateanywaysBTn;
	@FindBy(xpath = "//input[@id='name']")
	WebElement customerNamefield1;	
	@FindBy(xpath = "//input[@id='city']")
	WebElement cityfield1;	
	@FindBy(xpath = "//input[@id='zip']")
	WebElement zipfield1;	
	@FindAll(value = { @FindBy(xpath = "//div[@class='col p-3']//p[@class='typeahead-options-detail']") })
	public List<WebElement> addresssource;
//	@FindBy(xpath = "//*[text()=' The name of the record you are trying to create already exists. Either select the existing record from the list to the right or Go Back and update your customer name. ']")
//	WebElement Seibelrecord;
	@FindBy(xpath = "//h2[contains(text(), 'YOUR RECORD')]")
	WebElement Seibelrecord;
	@FindBy(xpath = "	//div[@class='col-xs-12 col-lg-3 ml-auto']")
	WebElement Matchingrecords;
	@FindBy(xpath = "//button[contains(text(), 'Replace')]")
	WebElement Replace;	
	@FindBy(xpath = "//h4[contains(text(), 'Add Customer')]")
	WebElement Addcustomermodal;
	//@FindBy(xpath = "//button//span[@class='icon icon-close']")
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/jhi-add-customer-modal/jhi-modal/div[1]/button/span")
	WebElement closebtn;
	
	

	public AddCustomerPopup(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Add customer to opportunity using XML .
	 */

	public void AddCustomertoOpportunity(String customername) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Click add customer button
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, customername);

		// Select first customer card
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col p-3']")));
		functions.click(driver, firstCustomerCard);


		// Click "add to opportunity" button
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));
		functions.click(driver, addCustomerToOptyBtn);

functions.maxWait();
try {
		if (createNewDealBtn1.size() > 0 == true && createNewDealBtn1.get(0).isDisplayed() == true) {
		// Wait for Create New deal to Appear
	functions.intermediatewait();
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create New Deal')]")));
	
		
		// select Create New Deal from the Popup
//		
//			createNewDealBtn1.get(0).click();
		functions.click(driver,createNewDealBtn);
	}
}catch(Exception n){
	}
	}

	/*
	 * Add customer to opportunity using Excel File
	 */

	public void AddCustomertoOpportunity(Map<String, Object> data) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Click add customer button

		functions.click(driver, addCustomerBtn);

		// Enter customer name
		functions.setText(driver, customerNameInput, data.get("customerName").toString());

		// Select first customer card
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, createNewDealBtn, 25);

		functions.midWait();
		// select Create New Deal from the Popup
		functions.click(driver, createNewDealBtn);

	}

	/*
	 * Add customer to opportunity using XML .
	 */

	public boolean AddCustomertoOpportunity(String customername,String customerdetails,int Rowvalue, String caddress,String ccity ,String cstate) throws Throwable {
		int a= Rowvalue;
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
		// Click add customer button
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, customername);

try {
	if(firstCustomerCard.isDisplayed()) {

		Boolean found =false;
		int k = customersize.size()*2;
		System.out.println(k);
		System.out.println(customersize.size());
		 for (int i = 0; i <= k; i=i+1) {
	try {	
		System.out.println(customeraddresssource.get(i).getText());
		System.out.println(i);

		//
		if(customeraddresssource.get(i).getText().equals("Siebel"))
		{
				System.out.println(i);
			int	m=i+1;
			String Test = customeraddresssource.get(m).getText().toUpperCase();
			System.out.println (Test);	
			System.out.println(m);
			
			if(Test.trim().contains(caddress.toUpperCase()) && Test.trim().contains(ccity.toUpperCase()) && Test.trim().contains(cstate.toUpperCase()))
		{
			found=true;
			customeraddresssource.get(i).click();
			
			break;
		}else {
			System.out.println("print");

			}
	}else if 		
		(customeraddresssource.get(i).getText().equals("VHOS"))
	{
		int	m=i+1;
		String Test = customeraddresssource.get(m).getText();
		System.out.println (Test);	
		System.out.println(m);
	
		
		if(Test.trim().contains(caddress.toUpperCase()) && Test.trim().contains(ccity.toUpperCase()) && Test.trim().contains(cstate.toUpperCase()))
	{
		found=true;
		customeraddresssource.get(i).click();
		
		break;
	}else {
		System.out.println("print");
//
		}	
	
	}
		}catch(Exception n2) {	
			////////////////////////       cell.setCellValue("Siebel & Vhos customer record missing");   
			//Create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

	// Create object of XSSFWorkbook class
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

	// Read excel sheet by sheet name
	        XSSFSheet sheet = workbook.getSheet("Data");

	// Get the Cell at index  from the above row
	        XSSFCell cell = sheet.getRow(a+1).getCell(55);

	        cell.setCellType(CellType.STRING);
	        cell.setCellValue("Siebel & Vhos customer record missing");        
	        
	        
	// Write the output to the file
	        FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
	        workbook.write(fileOut);

	        System.out.println("Id column in Excel is updated successfully");
	        fileOut.close();

	// Closing the workbook
	        workbook.close();
	if (Addcustomermodal.isDisplayed())  {
		functions.click(driver, closebtn);	
		
	}
	    
			return false;
		}
		 }

try {
if(addCustomerToOptyBtn.isEnabled()) {
		// Click "add to opportunity" button
		WebDriverWait wait3 = new WebDriverWait(driver, 300);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));
		functions.click(driver, addCustomerToOptyBtn);
		

		//wait for invisibility of spinner
				functions.vshortWait();
				WebDriverWait wait10 = new WebDriverWait(driver, 150);
				wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-container']")));
			
				try {
				if(CustomerNamerequired.isDisplayed()) {
					

					//Create an object of FileInputStream class to read excel file
					FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

			// Create object of XSSFWorkbook class
			        XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Read excel sheet by sheet name
			        XSSFSheet sheet = workbook.getSheet("Data");

			// Get the Cell at index  from the above row
			        XSSFCell cell = sheet.getRow(a+1).getCell(55);

			        cell.setCellType(CellType.STRING);
			        cell.setCellValue("Unable to add VHOS Customer");        
			        
			        
			// Write the output to the file
			        FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
			        workbook.write(fileOut);

			        System.out.println("Id column in Excel is updated successfully");
			        fileOut.close();

			// Closing the workbook
			        workbook.close();
			        
			        return false;
				}
				}
				catch(Exception n){
					System.out.println("Customer issue");
				}
				
				
try {
		if (createNewDealBtn1.size() > 0 == true && createNewDealBtn1.get(0).isDisplayed() == true) {
		// Wait for Create New deal to Appear
functions.shortWait();
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create New Deal')]")));
	
	
		functions.click(driver,createNewDealBtn);
	}
}catch(Exception n){
	}
}
	}catch(Exception n){

		//Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

// Create object of XSSFWorkbook class
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

// Read excel sheet by sheet name
        XSSFSheet sheet = workbook.getSheet("Data");

// Get the Cell at index  from the above row
        XSSFCell cell = sheet.getRow(a+1).getCell(55);

        cell.setCellType(CellType.STRING);
        cell.setCellValue("Customer mandatory details are missing");        
        
        
// Write the output to the file
        FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
        workbook.write(fileOut);

        System.out.println("Id column in Excel is updated successfully");
        fileOut.close();

// Closing the workbook
        workbook.close();
        return false;
	}
	}
	
}catch(Exception n3) {
	return false;
	}
return true;
	}
	
	
	public void UpdateSalesgroup(String accountrep,String ema,String thirdparty,String salesgroup,String saleschannel) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		try {	
			if(AddCustomerbanner.isDisplayed()==true) {
				System.out.println("Customer issue");
			}
		}catch(Exception n){
			
			try {
				if(CreateCustomerbanner.isDisplayed()==true) {
					System.out.println("Customer issue");
				}
			}catch(Exception n1) {
				//Click on seedetails
				functions.click(driver, seedetailsbtn);
				functions.minwait();
		//Click on edit button
		editbtn.get(1).click();
		
		 //Entering account Rep
//		 accountrepbtn.clear();
//		 functions.setText(driver, accountrepbtn, accountrep);
//		 accountrepbtn.sendKeys(Keys.ENTER);
//		 functions.minwait();
		 functions.setText(driver, emabtn, ema);
		 thirdpartybtn.clear();
		 functions.setText(driver, thirdpartybtn, thirdparty);
		 thirdpartybtn.sendKeys(Keys.ENTER);
		 functions.minwait();
		 //Entering Salesgroup,Saleschannel
		 functions.selectDropdownByVisibleText(driver, salesgrpbtn, salesgroup);
		 functions.minwait();
		 functions.selectDropdownByVisibleText(driver, saleschannelbtn, saleschannel);
		 functions.minwait();
		 functions.selectDropdownByVisibleText(driver, contractbrandbtn, "NRG");
		functions.minwait();
		functions.click(driver, savebtn);
			}
		}
	}
	
	/*
	 * Select Renew Option for Single>50kwh
	 */

	public String SelectRenewButton(String renewCust) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, renewCust);

		// Select first customer card
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col p-3']")));
		functions.click(driver, firstCustomerCard);

		// Click "add to opportunity" button
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		WebDriverWait wait8 = new WebDriverWait(driver, 200);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Renew')]")));

		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from Dsp
		String contracttext = contractidtext.get(0).getText();
		// String contract= contracttext.replaceAll("Contract:","");

		// Click on contract checkbox
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='control__indicator contract-checkbox']")));
		functions.click(driver, contractCheckbox);

		// Click on Create Renewal Opty Button
		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create Renewal Opportunity')]")));
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait10 = new WebDriverWait(driver, 150);
		wait10.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		//functions.dealconversion();

		// Storing and Returning the text into a String
		String optyid = functions.getText(driver, opportunityIDText);

		// Storing and Returning the text into a String

		return optyid + "," + contracttext;

	}

	/*
	 * Select Renew Option for Aggregate>50kwh
	 */

	public String SelectRenewButtonforAggregate(String customername1, String customername2) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, prop.getProperty("Renewcustname"));

		// Select first customer card
		WebDriverWait wait2 = new WebDriverWait(driver, 200);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col p-3']")));
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		WebDriverWait wait8 = new WebDriverWait(driver, 200);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Renew')]")));

		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from Dsp
		String contracttext = contractidtext.get(0).getText();
		System.out.println(contracttext);

		// Click on contract checkbox
		WebDriverWait wait4 = new WebDriverWait(driver, 200);
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='control__indicator contract-checkbox']")));
		functions.click(driver, contractCheckbox);

		// Click on Create Renewal Opty Button
		WebDriverWait wait5 = new WebDriverWait(driver, 200);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create Renewal Opportunity')]")));
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait44 = new WebDriverWait(driver, 190);
		wait44.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		// Wait for add sites modal to disappear, and site tracked modal to appear
		//functions.AggregateSitesProgressTracker();

		// Click add customer button
		WebDriverWait wait90 = new WebDriverWait(driver, 200);
		wait90.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add Customer')]")));
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		WebDriverWait wait91 = new WebDriverWait(driver, 200);
		wait91.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.setText(driver, customerNameInput, prop.getProperty("RenewAggcustname"));

		// Select first customer card
		WebDriverWait wait92 = new WebDriverWait(driver, 200);
		wait92.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='typeahead-customer']")));
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		WebDriverWait wait94 = new WebDriverWait(driver, 200);
		wait94.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add To Opportunity')]")));
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load

		// Click on Renew Button from the modal popup
		WebDriverWait wait95 = new WebDriverWait(driver, 200);
		wait95.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Renew')]")));
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// Click on contract checkbox
		WebDriverWait wait96 = new WebDriverWait(driver, 200);
		wait96.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='control__indicator contract-checkbox']")));
		functions.click(driver, contractCheckbox);
		

		// Click on Create Renewal Opty Button
		WebDriverWait wait97 = new WebDriverWait(driver, 200);
		wait97.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create Renewal Opportunity')]")));
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
//		WebDriverWait wait = new WebDriverWait(driver, 180);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal.fade.show")));
		functions.AddsitesProgressTracker();
		
//		functions.click(driver, EditButton);
//		
//		functions.vshortWait();
//		
//		functions.click(driver, Startdate);
//		functions.setText(driver, Startdate, "02/01/2024");
		
//		functions.click(driver, SaveButton);

		// Storing and Returning the text into a String
		return (functions.getText(driver, opportunityIDText));

	}

	/*
	 * Select Renew auto Option for Single Enrollment
	 */

	public String SelectRenewAutoOptionforSingle() throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Click on RenewalPipeline button
		functions.click(driver, RenewalPipelineBTn);

		// wait for sometime
		functions.intermediatewait();

		// Click on Auto Renewal button
		autorenewBtn.get(1).click();

		// wait for sometime
		functions.intermediatewait();

		// getting contract ID from dsp
		String contracttext = contractidtext.get(0).getText();
		System.out.println(contracttext);

		// Click on contract checkbox
		functions.click(driver, contractCheckbox);

		// wait for sometime
		functions.shortWait();

		// SelectAllBtn.get(0).click();

		// Click on Create Renewal Opty Button
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.dealconversion1();

		// Click on Site Component Cart
		functions.click(driver, sitesComponentCart);

		// wait for sometime
		functions.shortWait();

		// Click on AnnualUsage Button
		AnnualUsageMenuswapper.get(1).click();

		// Click on AnnualUsage Menu Up Button
		functions.click(driver, AnnualUsageMenuUp);

		// wait for sometime
		functions.vshortWait();

		// Click on AnnualUsage Menu down Button
		functions.click(driver, AnnualUsageMenudown);

		// wait for sometime
		functions.vshortWait();

		// Click on ESI Id Checkbox
		EsIidCheckbox.get(1).click();

		// Storing and Returning the text into a String
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
	}

	/*
	 * Select Renew Option for Single<50kwh
	 */

	public String SelectRenewOption() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		functions.setText(driver, customerNameInput, prop.getProperty("Renewalcustomername"));

		// Select first customer card
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, createNewDealBtn, 25);
		functions.midWait();

		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from dsp

		String contracttext = contractidtext.get(0).getText();
		// String contract= contracttext.replaceAll("Contract:","");

		// Click on contract checkbox
		functions.click(driver, contractexpandBtn);

		// Wait for sometime
		functions.vshortWait();

		// Click on Contract Checkbox
		if (contractCheckbox50kwh.size() > 0 == true && contractCheckbox50kwh.get(1).isDisplayed() == true) {
			contractCheckbox50kwh.get(1).click();
		}
		// Wait for sometime
		functions.shortWait();

		// Click on Select Button
		SelectAllBtn.get(0).click();

		// Breaking the Xpath
		String beforeXpath = "/html/body/ngb-modal-window/div/div/jhi-contract-renewal-modal/jhi-modal/div[2]/jhi-contract-renewal/div/div/div[3]/div[2]/div/div[";

		// Breaking the Xpath
		String afterXpath = "]/div/div[2]/p/span";

		// for looping the Xpath
		for (int i = 3; i <= 10; i++) {
			// Appending the Xpath
			String actualXpath = beforeXpath + i + afterXpath;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath));

			// Printing the element text to Console
			System.out.println(element.getText());

			// Comparing the ESI Id from UI with Property ESI Id
			if (element.getText().equals(prop.getProperty("siteforRenewalSingle"))) {
				System.out.println("ESI ID:" + element.getText());
				SelectAllBtn.get(6).click();
			}
		}

		// Click on Create Renewal Opty Button
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait = new WebDriverWait(driver, 290);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		// Storing and Returning the text into a String
		String optyid = functions.getText(driver, opportunityIDText);

		// Storing and Returning the text into a String
		return contracttext;

	}

	/*
	 * Select Renew Option for Aggregate<50kwh
	 */

	public String SelectRenewOptionAggregate() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		functions.setText(driver, customerNameInput, prop.getProperty("Renewalcustomername"));

		// Select first customer card
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, createNewDealBtn, 25);
		functions.midWait();

		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from Dsp
		String contracttext = contractidtext.get(0).getText();

		// Click on contract checkbox

		functions.click(driver, contractexpandBtn);

		// Wait for sometime
		functions.vshortWait();

		// Click on Contract Checkbox
		contractCheckbox50kwh.get(1).click();

		// Wait for sometime
		functions.shortWait();

		// Click on Select Button
		SelectAllBtn.get(0).click();

		// Breaking the Xpath
		String beforeXpath = "/html/body/ngb-modal-window/div/div/jhi-contract-renewal-modal/jhi-modal/div[2]/jhi-contract-renewal/div/div/div[3]/div[2]/div/div[";

		// Breaking the Xpath
		String afterXpath = "]/div/div[2]/p/span";

		// for looping the Xpath
		for (int i = 3; i <= 10; i++) {

			// Appending the Xpath
			String actualXpath = beforeXpath + i + afterXpath;

			// Passing xpath to WebElement
			WebElement element = driver.findElement(By.xpath(actualXpath));

			// Printing the element text to Console
			System.out.println(element.getText());

			// Comparing the ESI Id from UI with Property ESI Id
			if (element.getText().equals(prop.getProperty("siteforRenewalSingle"))) {
				System.out.println("ESI ID:" + element.getText());
				SelectAllBtn.get(6).click();
			}

			// Comparing the ESI Id from UI with Property ESI Id
			if (element.getText().equals(prop.getProperty("siteforRenewalAggregate"))) {
				System.out.println("ESI ID:" + element.getText());
				SelectAllBtn.get(2).click();
			}
		}

		// Click on Create Renewal Opty Button
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait = new WebDriverWait(driver, 190);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		// Storing and Returning the text into a String
		String optyid = functions.getText(driver, opportunityIDText);

		// Storing and Returning the text into a String

		return contracttext;

	}

	/*
	 * Select Renew Refresh01
	 */

	public String SelectRenewRefresh(String renewCust) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Click add customer button
		functions.click(driver, addCustomerBtn);

		// Enter customer name
		functions.setText(driver, customerNameInput, renewCust);

		// Select first customer card
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, createNewDealBtn, 25);
		functions.midWait();
		// Click on Renew Button from the modal popup
		functions.click(driver, renewBtn);

		// wait for Contract to get displayed
		functions.intermediatewait();

		// getting contract ID from dsp

		String contracttext = contractidtext.get(0).getText();
		// String contract= contracttext.replaceAll("Contract:","");

		// Click on contract checkbox
		if (Contractcbox.size() >= 0 == true && Contractcbox.get(0).isDisplayed() == true) {
			Contractcbox.get(0).click();
		}
		// Click on Create Renewal Opty Button
		functions.click(driver, createRenewalOptyBtn);

		// Wait for add sites modal to disappear, and site tracked modal to appear
		functions.midintermediatewait();
		WebDriverWait wait = new WebDriverWait(driver, 130);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal fade show']")));

		functions.dealconversion();

		// Storing and Returning the text into a String
		String optyid = functions.getText(driver, opportunityIDText);

		// Storing and Returning the text into a String

		return optyid + "," + contracttext;

	}
	/*
	 * Add customer to opportunity using Excel File
	 */

	public void AddCustomertoOpportunityforPCXML(String Customername ) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		// Click add customer button

		functions.click(driver, addCustomerBtn);

		// Enter customer name
		functions.setText(driver, customerNameInput, Customername);

		// Select first customer card
		functions.click(driver, firstCustomerCard);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, addCustomerToOptyBtn, 20);

		// Click "add to opportunity" button
		functions.click(driver, addCustomerToOptyBtn);

		// Wait for customer details to Load
		functions.waitForvisibility(driver, createNewDealBtn, 25);

		functions.midWait();
		// select Create New Deal from the Popup
		functions.click(driver, createNewDealBtn);

	}
	

}
