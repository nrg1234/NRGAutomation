package Pages.DSP;

import apphooks.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;

public class ViewCredit {
	public static WebDriver driver;
	@FindBy(xpath = "//button[contains(text(), 'Credit')]")
	WebElement creditTAB;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement convert50kwBtn;
	@FindBy(xpath = "//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;
	@FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	WebElement opportunityIDText;
	@FindBy(xpath = "//button[contains(text(), 'Calculate and Save')]")
	WebElement calculateAndSave;
	//@FindBy(xpath = "//p[normalize-space()='No Products for Quote']")
	@FindBy(xpath = "//span[@ng-reflect-tooltip='Site error in VHOS']")	
	WebElement siteerror;
	@FindBy(xpath = "//h4[contains(text(), 'Add Customer')]")
	WebElement AddCustomerbanner;
	@FindBy(xpath = "//h4[contains(text(), 'Create Customer')]")
	WebElement CreateCustomerbanner;
	CommonFunctions functions = new CommonFunctions();
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
	 private Base base;
	 Putsbox putsbox = new Putsbox(base);
	public ViewCredit(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * View Credit
	 */
	public void ViewCreditChevron() throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		// View Credit
		functions.click(driver, creditTAB);

		// driver.navigate().refresh();
	}

	public String Convertingdealtolessthan50kw() throws InterruptedException {

		CommonFunctions functions = new CommonFunctions();

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Click on Calculate and Save Button
		functions.click(driver, calculateAndSave);

		// Wait for Sometime
		// functions.midWait();

		// Wait for contract to be created
		WebDriverWait wait1 = new WebDriverWait(driver, 220);
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'50 KW Demand Check')]")));

		// Clicks on Yes Button in Convert Deal to <50kw Popup
		functions.click(driver, convert50kwBtn);

		// wait for deal to convert
		functions.intermediatewait();

		// View Credit
		functions.click(driver, creditTAB);

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 540);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// View Credit
		functions.click(driver, creditTAB);

		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Storing and Returning the text into a String
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
	}
	
	public String GetExternalopportunityid() throws InterruptedException {

		CommonFunctions functions = new CommonFunctions();
		String strUrl = driver.getCurrentUrl();
		System.out.println(strUrl);
		String externalopty= strUrl.substring(28, 64);
		System.out.println(externalopty);
		
		return  externalopty;
		
	}
	
	

	public String Convertingdealtolessthan50kwnew(int Rowvalue) throws InterruptedException {

		CommonFunctions functions = new CommonFunctions();
		int a= Rowvalue;
		try {	
			if(AddCustomerbanner.isDisplayed()==true) {
				System.out.println("Customer issue");
			}
		}catch(Exception n2){
			try {
				if(CreateCustomerbanner.isDisplayed()==true) {
					System.out.println("Customer issue");
				}
			}catch(Exception n1) {
		
		// Navigate to quotes page
		
		try {  
		
    		if (siteerror.isDisplayed() == true)
    		{
    			//Create an object of FileInputStream class to read excel file
    	        FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

    	// Create object of XSSFWorkbook class
    	        XSSFWorkbook workbook = new XSSFWorkbook(fis);

    	// Read excel sheet by sheet name
    	        XSSFSheet sheet = workbook.getSheet("Data");

    	// Get the Cell at index  from the above row
    	        XSSFCell cell = sheet.getRow(a+1).getCell(55);

    	        cell.setCellType(CellType.STRING);
    	        cell.setCellValue("Site error");        
    	        
    	        
    	// Write the output to the file
    	        FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
    	        workbook.write(fileOut);

    	        System.out.println("Id column in Excel is updated successfully");
    	        fileOut.close();

    	// Closing the workbook
    	        workbook.close();

    		
               
    		}
    	
		}catch(Exception n){
    		
			functions.click(driver, quotesTAB);
			functions.shortWait();

		// Wait for contract to be created
		try {
		if(convert50kwBtn.isDisplayed()) {
			functions.minwait();
			WebDriverWait wait1 = new WebDriverWait(driver, 150);
			wait1.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'50 KW Demand Check')]")));
		// Clicks on Yes Button in Convert Deal to <50kw Popup
		functions.click(driver, convert50kwBtn);

//		// wait for deal to convert
//		functions.intermediatewait();
//
//		// View Credit
//		functions.click(driver, creditTAB);
//
//		// Navigate to quotes page
//		functions.click(driver, quotesTAB);

		//driver.navigate().refresh();
		// Wait for Prices to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='QuotesScrollContainer']")));

		// View Credit
		functions.click(driver, creditTAB);
		functions.vshortWait();
		// Navigate to quotes page
		functions.click(driver, quotesTAB);

		// Storing and Returning the text into a String
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
		}
		}
		catch (Exception n3) {
			// View Credit
			functions.click(driver, creditTAB);
			functions.vshortWait();
			// Navigate to quotes page
			functions.click(driver, quotesTAB);
			// Storing and Returning the text into a String
			final String OpportunityID = functions.getText(driver, opportunityIDText);
			System.out.println(OpportunityID);
			return OpportunityID;
		}

	}
		}
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
		}
		final String OpportunityID = functions.getText(driver, opportunityIDText);
		System.out.println(OpportunityID);
		return OpportunityID;
		
	}
}



   
