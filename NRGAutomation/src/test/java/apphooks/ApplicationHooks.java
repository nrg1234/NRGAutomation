package apphooks;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.paulhammant.ngwebdriver.NgWebDriver;

import Stepdefinitions.OAM.BPNeg01;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationHooks extends Base {

	
	private Scenario scenario;
	private Base base;
	TestContext testContext;
	TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	public ApplicationHooks(Base base) {
		this.base = base;
		
	}

	
	@Before
	public Scenario before(Scenario scenario) {
	    this.scenario = scenario;
	    return scenario;
	}
	/**
	 * launches web driver based on browser property
	 * @return 
	 *
	 * @return
	 */

	@Before
	public WebDriver launchApp() {
		try {
			tearDownExistingDrivers();
		} catch (IOException e) {
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
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser is launched");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "src/test/resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE Browser is launched");
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "src/test/resources/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			System.out.println("Edge Browser is launched");
			break;
		case "NgDriver":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is launched");
			NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver).withRootSelector(".ng-tns-c0-0");
			ngWebDriver.waitForAngularRequestsToFinish();

		default:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is launched");
			break;

		}
		// Configure web driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	/*
	 * This Method is to kill all active Chrome Driver sessions
	 */
	private static void tearDownExistingDrivers() throws IOException {
		//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
	}

	/**
	 * @param //scenario captures screenshot and attaches to scenario instance
	 * @return
	 */
	@After(order=1)
	public void takescreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				// scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "error.png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
	}
		
		
	@After(order=0)
	public  void tearDown() throws IOException {
		
		driver.quit();
	}

	
	public static void addScreenShotsOnFailure() {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM HH:mm:ss z yyyy");
		String strDate = formatter.format(d);
		String screenshotName = strDate.replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "/target/extent-report/" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	


}