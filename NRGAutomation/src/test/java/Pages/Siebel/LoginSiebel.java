package Pages.Siebel;

import Baseclass.Library;
import Pages.DSP.LandingPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class LoginSiebel  {

    //LandingPage Dsp = new LandingPage(driver);
    @FindBy(xpath = "//input[@name='SWEUserName']")
    WebElement siebelUserName;
    @FindBy(xpath = "//input[@name='SWEPassword']")
    WebElement siebelPassword;
    @FindBy(xpath = "//a[@id='s_swepi_22']")
    WebElement submitBtn;
WebDriver driver;
    public LoginSiebel(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public BAApprovescreditinSiebel LoginSiebel(String password) throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        System.out.println("passing the string value from Addsites to the OPty method:" + password);
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

        //Navigate to Siebel
        //opening the new tab
        ((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("siebel-url") + "');");

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        submitBtn.click();

		// Enter username and password
        functions.setText(driver, siebelUserName, prop.getProperty("SiebelUsername"));
        functions.setText(driver, siebelPassword, password);

        // Log in
        functions.click(driver, submitBtn);
return new BAApprovescreditinSiebel(driver);
    }
}
