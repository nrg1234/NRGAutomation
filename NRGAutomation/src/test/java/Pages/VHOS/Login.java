package Pages.VHOS;

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

public class Login {
	public static WebDriver driver;
	public Login(Base base) {
		this.driver=base.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginVhos() throws Throwable {
	 //DSPHomePage Dsp=new DSPHomePage(driver);
	 CommonFunctions functions=new CommonFunctions();
	 ConfigReader config=new ConfigReader();
	   Properties prop=config.init_properties();

 	// Navigate to VHOS
		//opening the new tab
       ((JavascriptExecutor)driver).executeScript("window.open('" + prop.getProperty("vhos-url") + "');");
 	        
 	        //getting all the handles currently available
 	       
	  	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  	    driver.switchTo().window(tabs2.get(1));
	  	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 

	  	
}
}
