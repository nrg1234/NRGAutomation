package Pages.VHOS;

import Baseclass.Library;
import Pages.DSP.LandingPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class VhosPage extends Library {

    @FindBy(xpath = "//a[contains(text(), 'here')]")
    WebElement clickhereButton;
    @FindBy(xpath = "//span[@id='A0486:f2:msg']")
    WebElement SearchResult;
    @FindBy(xpath = "//input[@id='A3574:sff2:searchString2']")
    WebElement SearchfieldinVHOS;

    public VhosPage(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
     * Waits till the Element becomes visible
     */
    public void waitForvisibility(WebElement element, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        } catch (Exception e) {

        }
    }

    public LandingPage ValidateOpportunitydetailsinVHOS(Map<String, Object> data, String Optyid) throws Throwable {
        LandingPage Dsp = new LandingPage(driver);
        CommonFunctions functions = new CommonFunctions();

        System.out.println("passing the string value from Add sites to the OPty method:" + Optyid);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        //getting all the handles currently available

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        //Enters Opportunity id in the Search Field
        functions.setText(driver, SearchfieldinVHOS, Optyid);
        SearchfieldinVHOS.sendKeys(Keys.ENTER);
        System.out.println("Opportunity id has been successfully entered in the search field");

        // Wait for Opportunity ID to get displayed
        try {
            Thread.sleep(5 * 5000);
        } catch (InterruptedException e) {
            System.err.println("Failed to Thread.sleep()!");
            e.printStackTrace();
        }

        driver.close();

        //switch to the parent window
        driver.switchTo().window(tabs2.get(0));
        return new LandingPage(driver);
    }
}