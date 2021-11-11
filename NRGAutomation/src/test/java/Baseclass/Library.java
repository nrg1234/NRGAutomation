package Baseclass;

import Utilities.ConfigReader;
import Utilities.GenericFunctions;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Library {

    public static WebDriver driver;
    public Logger log = Logger.getLogger(Library.class);

    /*
     * This Method is to kill all active Chrome Driver sessions
     */
    private static void tearDownExistingDrivers() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    /**
     * initializes config properties
     */
    @Before(order = 0)
    public void getConfigProperty() {
        //ConfigReader config = new ConfigReader();
       // Properties prop = config.init_properties();

    }

    /**
     * launches web driver based on browser property
     */
    @Before(order = 1)
    public void launchApp() throws Throwable {

        tearDownExistingDrivers();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String browser = prop.getProperty("browser");
        tearDownExistingDrivers();
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Chrome Browser is launched");
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
                driver = new ChromeDriver();
                System.out.println("Firefox Browser is launched");
                break;
            case "IE":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/IEDriver.exe");
                driver = new ChromeDriver();
                System.out.println("IE Browser is launched");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Chrome Browser is launched");
                break;
        }
        // Configure web driver
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    /**
//    * @param scenario captures screenshot and attaches to scenario instance
//     */
//    @After(order = 1)
//    public void takeScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//        byte[] screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshotPath, "image/png", screenshotName + "_Failed.png");
//    }

    /**
     * quits web driver
     */
    /*@After(order = 0)
    public void tearDown() {
        driver.quit();
        log.info("*************************** Quit browser instance *************************** ");
    }*/
    @AfterStep
    public void Scenario(Scenario scenario) throws IOException {
        scenario.attach(GenericFunctions.getByteScreenshot(), "image/png", "screenshot");
    }

    /*
     *This Method is for clicking on Advanced Options Button and hyperlink to DSP Url navigation in Dev Environment
     */
    public void AdvancedOptions()  {
        //CommonFunctions functions = new CommonFunctions();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    }

}
