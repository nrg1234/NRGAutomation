package apphooks;

import Baseclass.Library;
import Utilities.ConfigReader;
import Utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;


/**
 * @author jxavier Application hooks to launch browser, quit browser and capture
 * screenshots
 */
public class ApplicationHooks {
    public static Scenario scenario;
    Properties prop;
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    private WebDriver driver;
    private final Logger log = Logger.getLogger(ApplicationHooks.class);

    /**
     * initializes config properties
     */
    @Before(order = 0)
    public void getConfigProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_properties();
    }

    /**
     * launches web driver based on browser property
     */
    @Before(order = 1)
    public void launchBrowser(Scenario scenario) {
        String browserName = prop.getProperty("browser");
        String environment = prop.getProperty("environment");
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        ApplicationHooks.scenario = scenario;
        log.info("*************************** Executing " + scenarioName + " test on browser: " + browserName
                + " ***************************");
        log.info("MAS Test Environment: " + environment);
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Webdriver(browserName);
    }
	   /* @AfterStep
	    public void Scenario() {
	
	    }*/

    /**
     * quits web driver
     */
    @After(order = 0)
    public void tearDown() {
        driver.quit();
        log.info("*************************** Quit browser instance *************************** ");
    }


    /**
     * //	     * @param scenario captures screenshot and attaches to scenario instance
     * //
     */
    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotPath, "image/png", screenshotName + "_Failed.png");
        }
    }

}

