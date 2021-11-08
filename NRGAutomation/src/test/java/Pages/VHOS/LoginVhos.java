package Pages.VHOS;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;
import Utilities.ConfigReader;

public class LoginVhos extends Library{
	
	public LoginVhos(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginVhos(Map<String,Object> data, String Optyid) throws Throwable {
	 //DSPHomePage Dsp=new DSPHomePage(driver);
	 CommonFunctions functions=new CommonFunctions();
	   
	   System.out.println("passing the string value from AddsitestotheoPty method:"+Optyid);
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
