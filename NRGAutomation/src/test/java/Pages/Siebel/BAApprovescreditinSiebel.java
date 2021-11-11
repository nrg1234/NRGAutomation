package Pages.Siebel;


import Baseclass.Library;
import Pages.DSP.LandingPage;
import Pages.VHOS.LoginVhos;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class BAApprovescreditinSiebel  {
   // LandingPage Dsp = new LandingPage(driver);

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
WebDriver driver;
    public BAApprovescreditinSiebel(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginVhos BAApprovescreditinSiebel(Map<String, Object> data, String Optyid) throws Throwable {
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

return new LoginVhos(driver);
    }

}