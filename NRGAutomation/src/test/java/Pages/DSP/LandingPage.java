package Pages.DSP;

import Baseclass.Library;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class LandingPage extends Library {

    @FindBy(xpath="//button[contains(text(), 'Clear Filters')]")
    WebElement clearFilterBtn;

    Logger LOG = Logger.getLogger(LandingPage.class.getName());

    public LandingPage(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to DSP
    public void launchurl() throws Throwable {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String url = prop.getProperty("dsp-url");
        driver.get(url);
    }

    /*
     * validate the Title
     */
    public void TitleValidation() throws Throwable {

        if (driver.getTitle().equals("Digital Services Platform")) {
            System.out.println("Verification Successful - The correct title is displayed on the web page");
        } else {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page");
        }
    }

    /*
     * Turn off the Toggle Button in Dsp
     */
    public void Toggle(boolean checked) {
        CommonFunctions functions=new CommonFunctions();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']")));
				  /*  WebElement checkbox =driver.findElement(By.xpath("//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']"));
					if (checked != checkbox.isSelected())
				    {
				        checkbox.click();
				    }
					else {*/
        functions.click(driver,clearFilterBtn);
        driver.findElement(By.xpath("//button[contains(text(), 'Clear Filters')]")).click();
        System.out.println("WOLR VIEW TOGGLE is disabled");

    }
}
				

		
	
