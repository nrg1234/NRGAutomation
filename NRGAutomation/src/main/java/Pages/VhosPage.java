package Pages;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.DriverFactory;

public class VhosPage {
	
	WebDriver driver;
	public VhosPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(), 'here')]")
	WebElement clickhereButton;
	
	@FindBy(xpath="//span[@id='A0486:f2:msg']")
	WebElement SearchResult;
	
	@FindBy(xpath="//input[@id='A3574:sff2:searchString2']")
	WebElement SearchfieldinVHOS;
	
	/*
	 * Waits till the Element becomes visible
	 */
		public void waitForvisibility(WebElement element,int seconds) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
			}catch(Exception e) {

			}
		}
	
 public  DSPHomePage ValidateOpportunitydetailsinVHOS(Map<String,Object> data,String Optyid) throws Throwable {
	 DSPHomePage Dsp=new DSPHomePage(driver);
	 CommonFunctions functions=new CommonFunctions();
	   
	   System.out.println("passing the string value from AddsitestotheoPty method:"+Optyid);
	 ConfigReader config=new ConfigReader();
	   Properties prop=config.init_properties();

 	// Navigate to VHOS
		//opening the new tab
       ((JavascriptExecutor)driver).executeScript("window.open('http://vhostest/web/vhos/home');");
 	        
 	        //getting all the handles currently available
 	       
	  	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  	    driver.switchTo().window(tabs2.get(1));
	  	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 	
	  	

 	
 	//Enters Opportunity id in the Search Field
 	functions.setText(driver, SearchfieldinVHOS, Optyid);
 	SearchfieldinVHOS.sendKeys(Keys.ENTER);
 	System.out.println("Opportunity id has been successfully entered in the search field");
 	
 	
 
 	
 // Wait for Opportunity ID to get displayed
   	try {
 			Thread.sleep(5* 5000);
 		} catch (InterruptedException e) {
 			System.err.println("Failed to Thread.sleep()!");
 			e.printStackTrace();
 		}
  	
 	driver.close();

 	//switch to the parent window
 	driver.switchTo().window(tabs2.get(0));
 	return new DSPHomePage(driver);
  	}
  	

 	}
 

 

