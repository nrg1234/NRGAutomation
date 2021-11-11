package Baseclass;

import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
     * launches web driver based on browser property
     */
    @Before
    public static WebDriver launchApp()   {

        try {
			tearDownExistingDrivers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String browser = prop.getProperty("browser");
        
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
        
        return driver;
    
   
    }
    /**
     * @param scenario captures screenshot and attaches to scenario instance
     * //@return
      */
    @After
     public  void takeScreenshot(Scenario scenario) {
             String screenshotName = scenario.getName().replaceAll(" ", "_");
         byte[] screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshotPath, "image/png", screenshotName + "_Failed.png");
         System.out.println("Screenshot is captured");
         
     }
    
    /*@After(order = 0)
    public void tearDown() {
        driver.quit();
        log.info("*************************** Quit browser instance *************************** ");
    }*/

}
