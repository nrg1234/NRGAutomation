package Baseclass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.DSPHomePage;
import Pages.VhosPage;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;

public class  Library {
		public static WebDriver driver;
		FileInputStream fis;
		Properties prop;
		public DSPHomePage launchApp() throws Throwable  {

			ConfigReader config=new ConfigReader();
			 Properties prop=config.init_properties();
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("dsp-url");
		
		if(browser.equals("Chrome"))
        {
			 // Set up Chrome driver
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is launched");
            
            }
        else if(browser.equals("Firefox"))
        {
        	// Set up Chrome driver
        				System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/chromedriver.exe");
        				driver = new ChromeDriver();
        				System.out.println("Firefox Browser is launched");
        }

		 
		   
		// Navigate to DSP
		 driver.get(url);
		 
		// Configure web driver
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		  driver.manage().window().maximize();
		  
		  return new DSPHomePage(driver);
		}
		

		/*
    	 * Turn off the Toggle Button
    	 */
			public void Toggle() throws Throwable  {
			CommonFunctions functions=new CommonFunctions();
			//WebElement toggleswitch=driver.findElement(By.xpath("//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']"));
			WebElement ClearFilters=driver.findElement(By.xpath("//button[contains(text(), 'Clear Filters')]"));
			/*if(toggleswitch.isDisplayed()) {
				toggleswitch.click();
				ClearFilters.click();
			}
			else {*/
				ClearFilters.click();
			//}
			
			System.out.println("WOLR VIEW TOGGLE is disabled");
			}
			
		
		public void TitleValidation() throws Throwable  {

		if (driver.getTitle().equals("Digital Services Platform"))
		    {
		           System.out.println("Verification Successful - The correct title is displayed on the web page");
		    }
		    else
		    {
		           System.out.println("Verification Failed - An incorrect title is displayed on the web page");
		    }
		}
		
	
			
			
			
}

