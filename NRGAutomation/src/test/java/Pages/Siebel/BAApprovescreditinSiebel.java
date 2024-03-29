package Pages.Siebel;
import Pages.VHOS.Login;
import Pages.commonObjects.Opportunity;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BAApprovescreditinSiebel  {

	
	 By opportunitiesTabsiebe=By.xpath("//a[contains(text(), 'Opportunities')]");

   @FindBy(xpath = "//a[contains(text(), 'Opportunities')]")
   WebElement opportunitiesTabsiebel;
    @FindBy(xpath = "//select[@name='s_vis_div']")
    WebElement allOpportunityDropdown;
    @FindBy(xpath = "//button[@id='s_4_1_17_0_Ctrl']")
    WebElement queryBtn;
    @FindBy(xpath = "//td[@id='1_s_4_l_Opportunity__']")
    WebElement opportunityId;
    @FindBy(xpath = "//td[@id='1_s_4_l_Name']")
    WebElement opportunityName;
    @FindBy(xpath = "//button[@id='s_4_1_14_0_Ctrl']")
    WebElement goBtn;
    @FindBy(xpath = "//*[@id='a_3']/div/table/tbody/tr/td/div[1]/span/table/tbody/tr/td[1]")
    WebElement otherRandomDiv;
    @FindBy(xpath = "//a[contains(text(), 'Credit Review Result')]")
    WebElement creditReviewResultTab;
    @FindBy(xpath = "//tr[@class='ui-widget-content jqgrow ui-row-ltr ui-state-highlight']/td[@id='1_s_1_l_Alert_Number']/a[@name='Alert Number']")
    WebElement creditAlertDrilldown;
    @FindBy(xpath = "//input[@name='s_1_1_6_0']")
    WebElement evaluator;
    @FindBy(xpath = "//input[@name='s_2_1_2_0']")
    WebElement creditReviewResultDropdown;
    @FindBy(xpath = "//li[@class='ui-menu-item']/a[@id='ui-id-1591']")
    WebElement creditReviewResultValue;
    @FindBy(xpath = "//input[@name='s_1_1_4_0']")
    WebElement rergScore;
    @FindBy(xpath = "//img[@id='s_1_1_7_0_icon']")
    WebElement lastcreditevaluationdate;
    @FindBy(xpath = "//input[@name='s_1_1_2_0']")
    WebElement legalEntity;
    @FindBy(xpath = "//input[@id='1_Name']")
    WebElement OpportunityNamefield;
    @FindBy(id = "1_Opportunity__")
    WebElement Opportunityidfield;
    @FindBy(xpath = "//a[@name='Name']")
    WebElement opportunitiesLst;
    @FindBy(xpath = "//img[@id='s_1_1_7_0_icon']")
    WebElement calendarIcon;
    @FindBy(xpath = "//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
    WebElement calendarDoneBtn;
    @FindBy(xpath = "//a[contains(text(), '17')]")
    WebElement calendarDate;
    @FindBy(xpath = "//td[@id='2_s_3_l_Street_Address']")
    WebElement ChooseCustomer;
    @FindBy(xpath = "//button[@id='s_at_m_2']")
    WebElement MenuBtn;
    @FindBy(xpath = "//input[@name='SWEUserName']")
    WebElement siebelUserName;
    @FindBy(xpath = "//input[@name='SWEPassword']")
    WebElement siebelPassword;
    @FindBy(xpath = "//a[@id='s_swepi_22']")
    WebElement submitBtn;
    @FindBy(xpath = "//select[@class='searchField']")
    WebElement createdbydropdown;
    @FindBy(xpath = " //td[@id='1_s_4_l_Type']")
    WebElement OpportunityType;
    @FindBy(xpath = "//img[@id='1_Type_icon']")
    WebElement Opportunitytypedropdownbtn;
    @FindBy(xpath = " //a[contains(text(),'Renewal')]")
    WebElement Renewalbtn;
    By RenewalCustomeraccount =By.xpath("//a[@name='Account']");
    
    String Renewcustomer;
    String Renewcust;
    String Renewcustomer1;
    String Renewcustomer2;
    String Renewcust1;
    String Renewcust2;
    
    @FindAll(value = { @FindBy(xpath="//a[contains(text(), 'Save Record                [Ctrl+S]')]")})
	public List<WebElement> SaveRecord;

    WebDriver driver;
    TestContext testContext;

    public BAApprovescreditinSiebel(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }

    public void BAApprovescreditinSiebel(String Optyid) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();


        //getting all the handles currently available
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
 
     // Wait for UI to finish building
        functions.mediumWait();
        functions.waitForvisibility1(driver, opportunitiesTabsiebe, 23);
        // Go to opportunities tab

        try {
            functions.click(driver, opportunitiesTabsiebel);
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }

        // Select "all opportunities"
        functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");


        // Wait few seconds for opportunities to refresh
        
        functions.mediumWait();

        // Query for the opportunity
        functions.click(driver, queryBtn);

        // Wait for query view to appear
        functions.mediumWait();

        Actions actions = new Actions(driver);
        //Press the TAB Key to Switch Focus to Permanent Address
        for (int i = 0; i < 1; i++) {
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }

        functions.setText(driver, Opportunityidfield, Optyid);

        // Query for the opportunity by ID
        
        functions.waitForvisibility(driver,goBtn, 5);

        functions.click(driver, goBtn);

        // Wait for query to finish
        functions.mediumWait();

        // Click somewhere else to be able to click into opportunity
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }
        // Wait for credit review request to appear, then click it
        
        functions.waitForvisibility(driver,opportunitiesLst, 10);

        // Click into opportunity
        functions.click(driver, opportunitiesLst);


        //Click into creditReviewResultTab
        functions.click(driver, creditReviewResultTab);
       
        functions.waitForvisibility(driver,creditAlertDrilldown, 5);

        // Scroll down to credit alert drill down, then click it
        functions.click(driver, creditAlertDrilldown);
        
        // Wait for credit alert drill down to appear

        functions.waitForvisibility(driver,evaluator, 10);

        // Wait for last credit eval date input, and enter today's date
        functions.setText(driver, evaluator, prop.getProperty("Evaluator"));
        functions.click(driver, calendarIcon);
        functions.click(driver, calendarDate);
        functions.click(driver, calendarDoneBtn);


        // Select a RERG score, and set status to accepted
        functions.setText(driver, rergScore, prop.getProperty("RERGScore"));
        functions.setText(driver, creditReviewResultDropdown, prop.getProperty("CreditReviewResult"));
        
        functions.waitForvisibility(driver,opportunitiesTabsiebel, 10);

        // Click into opportunities tab to save changes
        functions.click(driver, opportunitiesTabsiebel);

        // Wait for everything to update
        functions.intermediatewait();

        driver.close();

        //switch to the parent window
        driver.switchTo().window(tabs2.get(0));


    }


    public void BAApprovescreditinSiebelforAggregate(Map<String, Object> data, String Optyid) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        System.out.println("passing the string value from AddsitestotheoPty method:" + Optyid);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();


        //getting all the handles currently available
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        // Wait for UI to finish building
        try {
            Thread.sleep(10 * 2300);
        } catch (InterruptedException e1) {
            System.err.println("Failed to Thread.sleep()!");
            e1.printStackTrace();
        }

        // Go to opportunities tab

        try {
            functions.click(driver, opportunitiesTabsiebel);
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }

        // Select "all opportunities"
        functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");


        // Wait few seconds for opportunities to refresh
        try {
            Thread.sleep(5 * 4000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        // Query for the opportunity
        functions.click(driver, queryBtn);

        // Wait for query view to appear
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);

        for (int i = 0; i < 1; i++) {
            //Press the TAB Key to Switch Focus to Permanent Address
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }

        functions.setText(driver, Opportunityidfield, Optyid);

        // Query for the opportunity by ID
        Thread.sleep(5000);

        functions.click(driver, goBtn);

        // Wait for query to finish
        try {
            Thread.sleep(5 * 5000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        // Click somewhere else to be able to click into opportunity
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }
        // Wait for credit review request to appear, then click it


        try {
            Thread.sleep(5 * 2000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        // Click into opportunity
        functions.click(driver, opportunitiesLst);


        //Click into creditReviewResultTab
        functions.click(driver, creditReviewResultTab);
       
        Thread.sleep(5000);

        // Scroll down to credit alert drill down, then click it
        functions.click(driver, creditAlertDrilldown);
       
        // Wait for credit alert drill down to appear

        try {
            Thread.sleep(5 * 2000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }


        // Wait for last credit eval date input, and enter today's date
        functions.setText(driver, evaluator, data.get("Evaluator").toString());
        functions.click(driver, calendarIcon);
        functions.click(driver, calendarDate);
        functions.click(driver, calendarDoneBtn);


        // Select a RERG score, and set status to accepted
        functions.setText(driver, rergScore, data.get("RERGScore").toString());
        functions.setText(driver, creditReviewResultDropdown, data.get("CreditReviewResult").toString());


        // Wait for everything to update
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }
        //Clicks on Menu Button
        functions.click(driver,MenuBtn);
        
        // Wait for everything to update
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }
        
        
        //Select the Save Record from the Menu Dropdown 
       SaveRecord.get(1).click();
        
        // Click into opportunities tab to save changes
        driver.navigate().back();

        // Wait for everything to update
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }
        //Selects the Second Customer for Approving credit
        ChooseCustomer.click();
        
     // Scroll down to credit alert drill down, then click it
        functions.click(driver, creditAlertDrilldown);
       
        // Wait for credit alert drill down to appear

        try {
            Thread.sleep(5 * 2000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }


        // Wait for last credit eval date input, and enter today's date
        functions.setText(driver, evaluator, data.get("Evaluator").toString());
        functions.click(driver, calendarIcon);
        functions.click(driver, calendarDate);
        functions.click(driver, calendarDoneBtn);


        // Select a RERG score, and set status to accepted
        functions.setText(driver, rergScore, data.get("RERGScore").toString());
        functions.setText(driver, creditReviewResultDropdown, data.get("CreditReviewResult").toString());


     // Wait for everything to update
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        // Click into opportunities tab to save changes
        functions.click(driver, opportunitiesTabsiebel);

        // Wait for everything to update
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        driver.close();

        //switch to the parent window
        driver.switchTo().window(tabs2.get(0));


    }


    public  String SelectRenewalcustomerfromSiebel(String password) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
    
        //Navigate to Siebel
        //opening the new tab
        ((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("siebel-url") + "');");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        
     // Enter username and password
        functions.setText(driver, siebelUserName, prop.getProperty("SiebelUsername"));
        functions.setText(driver, siebelPassword, password);

        // Log in
        functions.click(driver, submitBtn);
        
     // Wait for UI to finish building
        functions.mediumWait();
        //functions.waitForvisibility1(driver, opportunitiesTabsiebel, 23);
        // Go to opportunities tab

        try {
            functions.click(driver, opportunitiesTabsiebel);
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }

        // Select "all opportunities"
        functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");


        // Wait few seconds for opportunities to refresh
        
        functions.mediumWait();
        
        
        functions.click(driver, createdbydropdown);
        
        functions.selectDropdownByVisibleText(driver, createdbydropdown, "Opportunity Type");
        
        functions.shortWait();
        
     // Query for the opportunity
        functions.click(driver, queryBtn);
        
        
        functions.click(driver, OpportunityType);
        
        functions.click(driver, Opportunitytypedropdownbtn);
        
        functions.click(driver,Renewalbtn);
        
        functions.shortWait();
        
        functions.click(driver, goBtn);
        
        
        functions.intermediatewait();
        
      //Storing and Returning the text into a String
        List<WebElement> myList=driver.findElements(RenewalCustomeraccount);
        List<String> all_elements_text=new ArrayList<>();
        for(int i=0; i<myList.size(); i++){
        	Renewcustomer=myList.get(2).getText();
        	Renewcust=Renewcustomer.replaceAll("'", "");
            all_elements_text.add(myList.get(i).getText());
            System.out.println(Renewcust);
        }
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return Renewcust;
    } 
     
    public  String SelectRenewalAggregatecustomerfromSiebel(String password) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        ((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("siebel-url") + "');");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        functions.setText(driver, siebelUserName, prop.getProperty("SiebelUsername"));
        functions.setText(driver, siebelPassword, password);
        functions.click(driver, submitBtn);
        functions.mediumWait();
        try {
            functions.click(driver, opportunitiesTabsiebel);
        } catch (StaleElementReferenceException e) {
            e.getMessage();
        }
        functions.selectDropdownByVisibleText(driver, allOpportunityDropdown, "All Opportunities");
        functions.mediumWait();
        functions.click(driver, createdbydropdown);
        functions.selectDropdownByVisibleText(driver, createdbydropdown, "Opportunity Type");
        functions.shortWait();
        functions.click(driver, queryBtn);
        functions.click(driver, OpportunityType);
        functions.click(driver, Opportunitytypedropdownbtn);
        functions.click(driver,Renewalbtn);
        functions.shortWait();
        functions.click(driver, goBtn);
        functions.intermediatewait();
        List<WebElement> myList=driver.findElements(RenewalCustomeraccount);
        List<String> all_elements_text=new ArrayList<>();
        for(int i=0; i<myList.size(); i++){
        	Renewcustomer1=myList.get(2).getText();
        	Renewcustomer2=myList.get(3).getText();
        	Renewcust1=Renewcustomer1.replaceAll("'", "");
        	Renewcust2=Renewcustomer1.replaceAll("'", "");
            all_elements_text.add(myList.get(i).getText());
            System.out.println(Renewcust);
        }
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        return Renewcust1+","+Renewcust2;
    } 

}
