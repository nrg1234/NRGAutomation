package Pages.DSP;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import Utilities.ConfigReader;
import apphooks.Base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class CreateOptyPopup {

    @FindBy(xpath = "//button[contains(text(), 'Create New Opportunity')]")
    WebElement createNewOptyBtn;
    @FindBy(id = "opportunityName")
    WebElement opportunityName;
    @FindAll(value = {@FindBy(xpath = "//input[@placeholder='Enter name']")})
    public List<WebElement> Opportunityname1;
    @FindBy(xpath = "//input[@id='dueDate']")
    WebElement dueDate;
    @FindBy(xpath = "//select[@id='market']")
    WebElement market;
    @FindBy(xpath = "//select[@id='marketSegment']")
    WebElement marketsegment;
    @FindBy(xpath = "//select[@id='brand']")
    WebElement contractbrand;
    @FindBy(xpath = "//input[@id='startDate']")
    WebElement startDate;
    @FindBy(xpath = "//input[@id='endDate']")
    WebElement endDate;
    @FindBy(xpath = "//input[@name='thirdparty']")
    WebElement thirdParty;
    @FindBy(xpath = "//input[@name='accountRep']")
    WebElement accountRep;
    @FindBy(xpath = "//p[@class='typeahead-options-title']")
    WebElement accountRepMenu;
    @FindAll(value = {@FindBy(xpath = "//button[contains(text(), 'Create')]")})
    public List<WebElement> createBtn;
    @FindBy(xpath = "//*[@id=\'navbar-2\']/form/div[1]/div/h1")
    WebElement randomOptyName;
    @FindBy(xpath = "//a[contains(text(),'All Opportunities')]")
    WebElement Allopportunitiesbtn;
    @FindBy(xpath = "//button[@id='table-optype-btn']")
    WebElement Dropdownformoreopty;
    @FindBy(xpath = "//a[contains(text(), ' ENTER MATRIX PRICE DEAL')]")
    WebElement entermatrixpricedealbtn;
    @FindAll(value = {@FindBy(xpath = "//button[contains(text(), 'Create')]")})
    public List<WebElement> matrixcreateBtn;
    @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
    WebElement opportunityIDText;

    WebDriver driver;

    public CreateOptyPopup(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }

    /*
     * Create new opportunity.
     */
    public String CreateNewOpportunity(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // String Opportunityname = RandomStringUtils.random(8, alphabet);
        // String Opportunityname = RandomStringUtils.randomAlphabetic(10);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));

        // Select the AccountRep for the Opportunity
        functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        // functions.click(driver,accountRepMenu);
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    /*
     * Create Matrix opportunity.
     */
    public String CreateMatrixOpportunity(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Actions action = new Actions(driver);
        Properties prop = config.init_properties();

        // Click on Dropdownformoreopty
        functions.click(driver, Dropdownformoreopty);

        functions.shortWait();
        // Select the ENTER MATRIX PRICE DEAL
        functions.selectDropdownByVisibleText(driver, entermatrixpricedealbtn, "ENTER MATRIX PRICE DEAL");
        functions.click(driver, entermatrixpricedealbtn);

        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(1000));
        String Opportunityname = alphabet.concat(number);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Wait for Duedate pop up before writing to input
        functions.setText(driver, dueDate, prop.getProperty("DueDate"));

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));

        // Select the start Date for the Opportunity
        functions.click(driver, startDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        startDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        // a.moveToElement(startDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.setText(driver, startDate, OptyHeader.get("MATRIXSTART_DATE"));

        // Select the End Date for the Opportunity

        // a.moveToElement(endDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.click(driver, endDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        endDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        functions.setText(driver, endDate, OptyHeader.get("END_DATE"));

        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("MARKETER_NAME1"));
        // functions.click(driver,accountRepMenu);
        functions.shortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.intermediatewait();
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();

            functions.midintermediatewait();
        }
        
        String Status="Pass";
        return Status;

    } /*
     * Create new opportunity.
     */

    public String CreateNewOpportunityrenewal(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(1000));
        String Opportunityname = alphabet.concat(number);
        // String Opportunityname = RandomStringUtils.random(8, alphabet);
        // String Opportunityname = RandomStringUtils.randomAlphabetic(10);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));
        // Select the start Date for the Opportunity
        functions.click(driver, startDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        startDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        // a.moveToElement(startDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.setText(driver, startDate, OptyHeader.get("MATRIXSTART_DATE"));

        // Select the End Date for the Opportunity

        // a.moveToElement(endDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.click(driver, endDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        endDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        functions.setText(driver, endDate, OptyHeader.get("END_DATE"));
        // Select the AccountRep for the Opportunity
        functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        // functions.click(driver,accountRepMenu);
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    public void CreateBrokerOpportunity(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Actions action = new Actions(driver);
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Wait for Duedate pop up before writing to input
        functions.setText(driver, dueDate, prop.getProperty("DueDate"));

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));

        // Select the start Date for the Opportunity
        functions.click(driver, startDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        startDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        // a.moveToElement(startDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.setText(driver, startDate, OptyHeader.get("MATRIXSTART_DATE"));

        // Select the End Date for the Opportunity

        // a.moveToElement(endDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.click(driver, endDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        endDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        functions.setText(driver, endDate, OptyHeader.get("END_DATE"));

        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("MARKETER_NAME2"));
        // functions.click(driver,accountRepMenu);
        // Select the AccountRep for the Opportunity
        // functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        functions.shortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.intermediatewait();
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();

            functions.midintermediatewait();
        }
    }

    public void CreateAddBrokerOpportunity(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Actions action = new Actions(driver);
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        // Click on Dropdownformoreopty
        functions.click(driver, Dropdownformoreopty);

        functions.shortWait();
        // Select the ENTER MATRIX PRICE DEAL
        functions.selectDropdownByVisibleText(driver, entermatrixpricedealbtn, "ENTER MATRIX PRICE DEAL");
        functions.click(driver, entermatrixpricedealbtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Wait for Duedate pop up before writing to input
        // functions.setText(driver, dueDate, prop.getProperty("DueDate"));

        // Select the Market using the visible text
        // functions.selectDropdownByVisibleText(driver, market,
        // prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        // functions.selectDropdownByVisibleText(driver, marketsegment,
        // OptyHeader.get("MARKET_SEGMENT"));

        // Select the start Date for the Opportunity
//			functions.click(driver, startDate);
//			action.keyDown(Keys.CONTROL);
//			action.sendKeys("a");
//			action.keyUp(Keys.CONTROL);
//			action.build().perform();
//			functions.minwait();
//			//startDate.sendKeys(Keys.BACK_SPACE);
//			functions.minwait();
        // a.moveToElement(startDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        // functions.setText(driver, startDate, OptyHeader.get("MATRIXSTART_DATE"));

        // Select the End Date for the Opportunity

        // a.moveToElement(endDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
//			functions.click(driver, endDate);
//			action.keyDown(Keys.CONTROL);
//			action.sendKeys("a");
//			action.keyUp(Keys.CONTROL);
//			action.build().perform();
//			functions.minwait();
//			endDate.sendKeys(Keys.BACK_SPACE);
//			functions.minwait();
//			functions.setText(driver, endDate, OptyHeader.get("END_DATE"));

        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("MARKETER_NAME3"));
        // functions.click(driver,accountRepMenu);
        // Select the AccountRep for the Opportunity
        // functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        functions.shortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.intermediatewait();
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();

            functions.midintermediatewait();
            System.out.println("Third party is not currently set up for matrix pricing in DSP");
            functions.click(driver, Dropdownformoreopty);
            functions.intermediatewait();
            functions.mediumWait();
        }

    }

    /*
     * Create new opportunity using Excel File.
     */
    public String CreateNewOpportunityforProtectedclass(int i,String Opportunityname, String Salesgroup, String ThirdParty,
                                                        String AccountRep,String Startdate,String Enddate ) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
      //  functions.vshortWait();
        WebDriverWait wait9 = new WebDriverWait(driver, 100);
        wait9.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create New Opportunity')]")));
        functions.click(driver, createNewOptyBtn);

        // Enter opportunity name
        functions.vshortWait();
        if (Opportunityname1.size() >= 0 == true && Opportunityname1.get(0).isDisplayed() == true) {
            functions.setText(driver, opportunityName, Opportunityname);
        }
        // Select the Market using the visible text
        WebDriverWait wait99 = new WebDriverWait(driver, 100);
        wait99.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='market']")));
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        WebDriverWait wait97 = new WebDriverWait(driver, 100);
        wait97.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='marketSegment']")));
        functions.selectDropdownByVisibleText(driver, marketsegment, Salesgroup);

       
       
        // Select the start Date for the Opportunity
        functions.click(driver, startDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        startDate.sendKeys(Keys.BACK_SPACE);
     //   functions.minwait();


//Create an object of FileInputStream class to read excel file
        FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));
// Create object of XSSFWorkbook class
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

// Read excel sheet by sheet name
        XSSFSheet sheet = workbook.getSheet("Data");

        Row row = sheet.getRow(i+1);
        Cell cell = row.getCell(4);
        DataFormatter dataFormatter = new DataFormatter();
        String cellStringValue = dataFormatter.formatCellValue(cell);
        startDate.sendKeys(cellStringValue);

        // Select the End Date for the Opportunity

        functions.click(driver, endDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        endDate.sendKeys(Keys.BACK_SPACE);
     //   functions.minwait();

        Row row1 = sheet.getRow(i+1);
        Cell cell1 = row1.getCell(5);
        DataFormatter dataFormatter1 = new DataFormatter();
        String cellStringValue1 = dataFormatter1.formatCellValue(cell1);
       endDate.sendKeys(cellStringValue1);
       // Select the ThirdParty for the Opportunity
       functions.setText(driver, thirdParty, ThirdParty);
       functions.minwait();
       thirdParty.sendKeys(Keys.ENTER);
      
       //Select AccountRep
       accountRep.clear();
       functions.setText(driver, accountRep, AccountRep);
       functions.minwait();
       accountRep.sendKeys(Keys.ENTER);
    
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    /*
     * Create new opportunity using XML.
     */
    public String CreateNewOpportunityforProtectedclassxml(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.vshortWait();
        WebDriverWait wait9 = new WebDriverWait(driver, 100);
        wait9.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Create New Opportunity')]")));
        functions.click(driver, createNewOptyBtn);

        // Enter opportunity name
        functions.intermediatewait();
        if (Opportunityname1.size() >= 0 == true && Opportunityname1.get(0).isDisplayed() == true) {
            functions.setText(driver, opportunityName, OptyHeader.get("Opportunity_Name"));
        }
        // Select the Market using the visible text
        WebDriverWait wait99 = new WebDriverWait(driver, 100);
        wait99.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='market']")));
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        WebDriverWait wait97 = new WebDriverWait(driver, 100);
        wait97.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='marketSegment']")));
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("Sales_Group"));
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("Third_Party"));
        functions.vshortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.vshortWait();

        // Select the AccountRep for the Opportunity
        functions.setText(driver, accountRep, OptyHeader.get("Account_Rep"));
        // functions.click(driver,accountRepMenu);

        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return OptyHeader.get("Opportunity_Name");

    }

    public String CreateNewOpportunityDOA(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // String Opportunityname = RandomStringUtils.random(8, alphabet);
        // String Opportunityname = RandomStringUtils.randomAlphabetic(10);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, prop.getProperty("SalesGroup"));
// select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Select the AccountRep for the Opportunity
        functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        // functions.click(driver,accountRepMenu);

        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    public String CreateNewOpportunityPC(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // String Opportunityname = RandomStringUtils.random(8, alphabet);
        // String Opportunityname = RandomStringUtils.randomAlphabetic(10);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, prop.getProperty("SalesGroup"));

        functions.shortWait();
        // select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("MARKETER_NAME2"));
        // functions.click(driver,accountRepMenu);
        // Select the AccountRep for the Opportunity
        // functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        functions.shortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.intermediatewait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    public void CreateMatrixlessthan50Opportunity(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Actions action = new Actions(driver);
        Properties prop = config.init_properties();

        // Click on Dropdownformoreopty
        functions.click(driver, Dropdownformoreopty);

        functions.shortWait();
        // Select the ENTER MATRIX PRICE DEAL
        functions.selectDropdownByVisibleText(driver, entermatrixpricedealbtn, "ENTER MATRIX PRICE DEAL");
        functions.click(driver, entermatrixpricedealbtn);

        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(1000));
        String Opportunityname = alphabet.concat(number);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Wait for Duedate pop up before writing to input
        functions.setText(driver, dueDate, prop.getProperty("DueDate"));

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("Market"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));

        // Select the start Date for the Opportunity
        functions.click(driver, startDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        startDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        // a.moveToElement(startDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.setText(driver, startDate, OptyHeader.get("MATRIXSTART_DATE"));

        // Select the End Date for the Opportunity

        // a.moveToElement(endDate).doubleClick().click().sendKeys(Keys.BACK_SPACE);
        functions.click(driver, endDate);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        functions.minwait();
        endDate.sendKeys(Keys.BACK_SPACE);
        functions.minwait();
        functions.setText(driver, endDate, OptyHeader.get("END_DATE"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, prop.getProperty("SalesGroup"));
        functions.shortWait();

        // select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("ContractBrand"));
        functions.shortWait();
        // Select the ThirdParty for the Opportunity
        functions.setText(driver, thirdParty, OptyHeader.get("MARKETER_NAME2"));
        // functions.click(driver,accountRepMenu);
        functions.shortWait();
        thirdParty.sendKeys(Keys.ENTER);
        functions.intermediatewait();

        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();

            functions.midintermediatewait();
        }
    }
    
    /*
     * Create new opportunity.
     */
    public String CreateNewOpportunityforNonErcot(HashMap<String, String> OptyHeader) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        Actions action = new Actions(driver);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        // Click on Create New Opportunity Button
        functions.click(driver, createNewOptyBtn);
        // random string of length 8 composed only of lettes a, b, and c
        String alphabet = "Test for E2E";
        Random random = new Random();
        String number = String.valueOf(random.nextInt(10000));
        String Opportunityname = alphabet.concat(number);
        // String Opportunityname = RandomStringUtils.random(8, alphabet);
        // String Opportunityname = RandomStringUtils.randomAlphabetic(10);
        // Enter opportunity name
        functions.setText(driver, opportunityName, Opportunityname);

        // Select the Market using the visible text
        functions.selectDropdownByVisibleText(driver, market, prop.getProperty("NonErcotMarket"));

        // Select the Marketsegment using the visible text
        functions.selectDropdownByVisibleText(driver, marketsegment, OptyHeader.get("MARKET_SEGMENT"));

        // Select the AccountRep for the Opportunity
        functions.setText(driver, accountRep, OptyHeader.get("MARKETER_NAME"));
        // functions.click(driver,accountRepMenu);
        // select brand
        functions.selectDropdownByVisibleText(driver, contractbrand, prop.getProperty("NonErcotContractBrand"));
        functions.shortWait();
        // Click "create Button"
        List<WebElement> Createbutton = createBtn;
        if (Createbutton.size() > 0 == true && Createbutton.get(1).isDisplayed() == true) {
            Createbutton.get(1).click();
        }

        // Storing and Returning the text into a String
        return Opportunityname;

    }

    
   
}
