package Pages.DSP;

import Baseclass.Library;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class AddSitesPopup  {

    @FindBy(xpath = "//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
    WebElement sitesComponentCart;
    @FindBy(xpath = "//button[contains(text(), 'Add Site')]")
    WebElement openAddSitesModalBtn;
    @FindBy(xpath = "//textarea[@id='esiids']")
    WebElement sitesTextArea;
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
    
    WebDriver driver;
    public AddSitesPopup(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /*
     * Add sites to opportunity.
     */

    public String AddSitestotheOpty() throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        //waitForvisibility(SitesComponentCaret,10);
        functions.click(driver, sitesComponentCart);

        // Open modal to add sites
        functions.click(driver, openAddSitesModalBtn);

        // Add sites to opportunity text area

        functions.click(driver, sitesTextArea);
        functions.setText(driver, sitesTextArea, prop.getProperty("site-esids"));

        // Add sites to opportunity
        functions.click(driver, addSitesBtn);
        functions.click(driver, submitSitesBtn);


        // Wait for add sites modal to disappear, and site tracked modal to appear
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        //Storing and Returning the text into a String
        final String OpportunityID = functions.getText(driver, opportunityIDText);
        System.out.println(OpportunityID);
        return OpportunityID;
    }

    
    public ViewCredit driver() {
    	return new ViewCredit(driver);
    }
}
