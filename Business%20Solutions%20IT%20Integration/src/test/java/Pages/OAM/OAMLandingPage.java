package Pages.OAM;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;

public class OAMLandingPage {
	@FindBy(xpath = "//input[@id='user']")
	WebElement OAMEmail;
	@FindBy(xpath = "//input[@id='password']")
	WebElement OAMPassword;
	@FindBy(xpath = "//a[@id='signin']")
	WebElement OAMLoginButton;
	WebDriver driver;

	public OAMLandingPage(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Navigate to OAM
	 */
	public void launchurlOAM() {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		String url = prop.getProperty("OAM-url");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);

	}
	
	public void launchurlOAMDev() {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		String url = prop.getProperty("OAM-url2");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);

	}

	/*
	 * validate the OAM Title
	 */
	public void TitleValidationOAM() {

		if (driver.getTitle().equals("Welcome | NRG Energy")) {
			System.out.println("Verification Successful - The correct title is displayed on the web page");
		} else {
			System.out.println("Verification Failed - An incorrect title is displayed on the web page");
		}

	}

	/*
	 * Passing Username and Password
	 */
	public void Login(String Username, String Password) {
		CommonFunctions functions = new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		functions.setText(driver, OAMEmail, Username);
		functions.setText(driver, OAMPassword, Password);
		functions.click(driver, OAMLoginButton);

	}
}
