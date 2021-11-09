package Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.DSP.LandingPage;
import Utilities.ConfigReader;



public class Library {
	

	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	public void launchApp() throws Throwable {

		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		String browser = prop.getProperty("browser");

		if (browser.equals("Chrome")) {
			tearDownExistingDrivers();
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is launched");
		} else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
			driver = new ChromeDriver();
			System.out.println("Firefox Browser is launched");
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/IEDriver.exe");
			driver = new ChromeDriver();
			System.out.println("IE Browser is launched");
		}
		// Configure web driver
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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

	private static void tearDownExistingDrivers() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}

	public void AdvancedOptions()throws Throwable{
		CommonFunctions functions=new CommonFunctions();
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
	}
			
}
