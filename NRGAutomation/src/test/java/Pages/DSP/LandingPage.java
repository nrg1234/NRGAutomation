package Pages.DSP;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LandingPage  {

    WebDriver driver;
    public LandingPage(Base base) {
        this.driver = base.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[contains(text(), 'Clear Filters')]")
    WebElement clearFilterBtn;

    @FindBy(xpath="//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']")
    WebElement wolrToggle;

    // Logger LOG = Logger.getLogger(LandingPage.class.getName());

    /*
     *Navigate to DSP
     */
    public void launchurl()  {

        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String url = prop.getProperty("dsp-url");
        driver.get(url);
        if (driver.getTitle().equals("Privacy error")) {
            AdvancedOptions();
        }
    }
    
    /*
     *This Method is for clicking on Advanced Options Button and hyperlink to DSP Url navigation in Dev Environment
     */
    public void AdvancedOptions()  {
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    }


    /*
     * validate the Title
     */
    public void TitleValidation()  {

        if (driver.getTitle().equals("Digital Services Platform")) {
            System.out.println("Verification Successful - The correct title is displayed on the web page");
        } else {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page");
        }
    }

    /*
     * Turn off the Toggle Button in DSP
     */
    public void Toggle(Boolean toggleEnabled) {
       CommonFunctions functions=new CommonFunctions();
//        functions.waitForvisibility(wolrToggle,80);
//        if (wolrToggle.isSelected() != toggleEnabled ) {
//            functions.click(driver,wolrToggle);
//        }
        functions.click(driver,clearFilterBtn);
        System.out.println("WOLR VIEW TOGGLE is disabled");
       
    }
}
				

		
	
