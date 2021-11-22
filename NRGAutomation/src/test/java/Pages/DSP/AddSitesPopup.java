package Pages.DSP;

import Pages.commonObjects.Opportunity;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.Properties;

public class AddSitesPopup  {


    @FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
    WebElement sitesComponentCart;
    @FindBy(xpath = "//button[contains(text(), 'Add Site')]")
    WebElement openAddSitesModalBtn;
    @FindBy(xpath = "//textarea[@id='esiids']")
    WebElement sitesTextArea;
    @FindBy(xpath = "//select[@id='customer']")
    WebElement CustomerDropdown;
    @FindBy(xpath = "//button[contains(text(),'Add to Queue')]")
    WebElement AddtoQueueBtn;
    @FindBy(xpath = "//button[contains(text(),' Confirm Site(s)')]")
    WebElement ConfirmSitesBtn;
    @FindBy(xpath = "//button[contains(text(), 'Add Site(s)')]")
    WebElement addSitesBtn;
    @FindBy(xpath = "//button[contains(text(), ' Submit Site(s) ')]")
    WebElement submitSitesBtn;
    @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
    WebElement opportunityIDText;
    @FindBy(xpath = "//a[contains(text(), 'HU Upload')]")
    WebElement HUUpload;
    @FindBy(xpath = "//button[contains(text(), 'Select File(s)')]")
    WebElement selectHUFiles;
    @FindBy(xpath = "//button[contains(text(), ' Process HU')]")
    WebElement processHU;
    @FindBy(xpath = "//button[contains(text(), 'Credit')]")
    WebElement creditTAB;
    @FindBy(xpath = "//td[@id='esidColumn']")
    WebElement ESIID;
    @FindBy(xpath = "//h4[contains(text(),'Add Site Progress Tracker')]")
    WebElement Progresstracker;
  
    
    WebDriver driver;

    public AddSitesPopup(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }
    /*
     * Add sites to opportunity.
     */

    public String AddSitestotheOpty(String siteid) throws InterruptedException {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();


        functions.click(driver, sitesComponentCart);

        // Open modal to add sites
        functions.click(driver, openAddSitesModalBtn);

        // Add sites to opportunity text area
        functions.click(driver, sitesTextArea);
        functions.setText(driver, sitesTextArea, prop.getProperty(siteid));

        // Add sites to opportunity
        functions.click(driver, addSitesBtn);
        functions.click(driver, submitSitesBtn);


        // Wait for add sites modal to disappear, and site tracked modal to appear
        functions.longWait();
        
        //Storing and Returning the text into a String
        return(functions.getText(driver, opportunityIDText));
      //  opty.setOptyID(functions.getText(driver, opportunityIDText));
        //final String OpportunityID = functions.getText(driver, opportunityIDText);

        //System.out.println(OpportunityID);

    }

    /*
     * Add sites to opportunity for Aggregate Customer.
     */

    public String AddSitestotheOptyforAggregatecustomer(String customername,Map<String,Object> data,String site1,String site2) {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();


        functions.click(driver, sitesComponentCart);

        // Open modal to add sites
        functions.click(driver, openAddSitesModalBtn);
        
        // Wait for Customer dropdown to Appear
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        //Select Aggregate Customers from the Customer Dropdown
        functions.click(driver, CustomerDropdown);
        functions.selectDropdownByVisibleText(driver,CustomerDropdown,customername);
        
        // Add sites to opportunity text area

        functions.click(driver, sitesTextArea);
        functions.setText(driver, sitesTextArea, prop.getProperty(site1));
        
        //Click on AddtoQueue Button
        functions.click(driver, AddtoQueueBtn);
        
     // Wait for Confirm Sites tracker to Appear
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }
        
        //Click on COnfirm Sites Button
        functions.click(driver, ConfirmSitesBtn);
        
        
      //Select Aggregate Customers from the Customer Dropdown
        functions.click(driver, CustomerDropdown);
        functions.selectDropdownByVisibleText(driver,CustomerDropdown,data.get("customerName").toString());

     // Add sites to opportunity text area

        functions.click(driver, sitesTextArea);
        functions.setText(driver, sitesTextArea, prop.getProperty(site2));
        
        //Click on AddtoQueue Button
        functions.click(driver, AddtoQueueBtn);
        
     // Wait for Confirm Sites tracker to Appear
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }
        
        //Click on COnfirm Sites Button
        functions.click(driver, ConfirmSitesBtn);
        
        
        // Add sites to opportunity
        functions.click(driver, addSitesBtn);


        // Wait for add sites modal to disappear, and site tracked modal to appear
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        //Storing and Returning the text into a String
        final String OpportunityID = functions.getText(driver, opportunityIDText);
        System.out.println(OpportunityID);
        return OpportunityID;
    }

    
   
    
}
