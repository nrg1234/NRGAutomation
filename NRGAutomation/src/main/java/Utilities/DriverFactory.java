package Utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jxavier Initializes thread local web driver based on browser property
 *         and return driver instance
 */
public class DriverFactory {

	public WebDriver driver;
	private Logger log = Logger.getLogger(DriverFactory.class);
	public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

	/**
	 * @param browser
	 *            Initializes thread local web driver based on browser property
	 * @return web driver
	 */
	public WebDriver init_Webdriver(String browser) {
		if (browser.equalsIgnoreCase(ConstantVariables.Browsers.chrome.toString())) {
			WebDriverManager.chromedriver().setup();
			localDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase(ConstantVariables.Browsers.firefox.toString())) {
			WebDriverManager.firefoxdriver().setup();
			localDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase(ConstantVariables.Browsers.edge.toString())) {
			WebDriverManager.edgedriver().setup();
			localDriver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase(ConstantVariables.Browsers.ie.toString())) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			WebDriverManager.iedriver().setup();
			localDriver.set(new InternetExplorerDriver(caps));
		} else if (browser.equalsIgnoreCase(ConstantVariables.Browsers.headless.toString())) {
			WebDriverManager.phantomjs().setup();
			localDriver.set(new PhantomJSDriver());
		} else
			log.fatal("Invalid browser: " + browser);

		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(ConstantVariables.implicitWait, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(ConstantVariables.pageLoadWait, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * @return Web driver instance
	 */
	public static WebDriver getDriver() {
		return localDriver.get();
	}

}
