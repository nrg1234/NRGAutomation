package Pages.VHOS;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import apphooks.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;

public class LoginVhos {
	public static WebDriver driver;

	public LoginVhos(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	public void loginVhos(String Browser) throws Throwable {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// Navigate to VHOS
		// opening the new tab
		((JavascriptExecutor) driver).executeScript("window.open('" + prop.getProperty("vhos-url") + "');");
		
		switch (Browser) {
		case "Edge":
			functions.shortWait();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_U);
			robot.keyRelease(KeyEvent.VK_U);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);

			functions.vshortWait();

			robot.keyPress(KeyEvent.VK_TAB);

			functions.vshortWait();

			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyRelease(KeyEvent.VK_O);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyRelease(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_G);
			robot.keyPress(KeyEvent.VK_1);
			robot.keyRelease(KeyEvent.VK_1);
			robot.keyPress(KeyEvent.VK_5);
			robot.keyRelease(KeyEvent.VK_5);
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_0);

			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
		
		// getting all the handles currently available

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		break;
		case "Chrome":
			// getting all the handles currently available

			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs3.get(1));
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		break;
	}
	}}