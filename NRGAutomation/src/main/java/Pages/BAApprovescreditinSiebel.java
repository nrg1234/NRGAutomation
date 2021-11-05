package Pages;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.DriverFactory;

public class BAApprovescreditinSiebel {
	WebDriver driver;
	DSPHomePage Dsp=new DSPHomePage(driver);

	
	public BAApprovescreditinSiebel (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//input[@name='SWEUserName']")
	WebElement  SiebelUsernamefield;
	
	@FindBy(xpath="//input[@name='SWEPassword']")
	WebElement  SiebelPasswordfield;
	
	@FindBy(xpath="//a[@id='s_swepi_22']")
	WebElement  submitsiebelLogin;
	
	@FindBy(xpath="//a[contains(text(), 'Opportunities')]")
	WebElement opportunitiesTabsiebel;
	
	
	@FindBy(xpath="//select[@name='s_vis_div']")
	WebElement AllopportunityDropdown;
	
	@FindBy(xpath="//button[@id='s_4_1_17_0_Ctrl']")
	WebElement QueryButton;
	
	
	@FindBy(xpath="//td[@id='1_s_4_l_Opportunity__']")
	WebElement opportunityidfield;
	
	@FindBy(xpath="//td[@id='1_s_4_l_Name']")
	WebElement opportunitynamefield;
	
	//@FindBy(xpath="//a[contains(text(), '" + Opportunityname + "')]")
	WebElement OpportunityNameinsiebel;
	
	
	@FindBy(xpath="//button[@id='s_4_1_14_0_Ctrl']")
	WebElement GoButton;
	
	@FindBy(xpath="//*[@id='a_3']/div/table/tbody/tr/td/div[1]/span/table/tbody/tr/td[1]")
	WebElement otherRandomDiv;
	
	
	@FindBy(xpath="//a[contains(text(), 'Credit Review Result')]")
	WebElement creditReviewResultTab;
	

	@FindBy(xpath="//tr[@class='ui-widget-content jqgrow ui-row-ltr ui-state-highlight']/td[@id='1_s_1_l_Alert_Number']/a[@name='Alert Number']")
	WebElement creditAlertDrilldown;
	

	@FindBy(xpath="//input[@name='s_1_1_6_0']")
	WebElement Evaluatorfield;
	
	@FindBy(xpath="//input[@name='s_2_1_2_0']")
	WebElement CreditReviewResultdropdown;
	
	@FindBy(xpath="//li[@class='ui-menu-item']/a[@id='ui-id-1591']")
	WebElement Creditreviewresultvalue;
	
	
	@FindBy(xpath="//input[@name='s_1_1_4_0']")
	WebElement RERGScore;
	
	@FindBy(xpath="//img[@id='s_1_1_7_0_icon']")
	WebElement Lastcreditevaluationdate;
	
	@FindBy(xpath="//input[@name='s_1_1_2_0']")
	WebElement LegalEntity;
	
	@FindBy(xpath="//input[@id='1_Name']")
	WebElement OpportunityNamefield;
	
	@FindBy(id="1_Opportunity__")
	WebElement Opportunityidfield;

	@FindBy(xpath="//a[@name='Name']")
	WebElement Listofopportunities;
	
	@FindBy(xpath="//img[@id='s_1_1_7_0_icon']")
	WebElement Calendaricon;
	
	@FindBy(xpath="//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	WebElement CalendarDoneButton;
	
	@FindBy(xpath="//a[contains(text(), '17')]")
	WebElement Calendardate;
	
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
	 public  VhosPage BAApprovescreditinSiebel(Map<String,Object> data,String Optyid) throws Throwable {
		 DSPHomePage Dsp=new DSPHomePage(driver);
	  	   CommonFunctions functions=new CommonFunctions();
	  	 System.out.println("passing the string value from AddsitestotheoPty method:"+Optyid);
	  	   ConfigReader config=new ConfigReader();
	  	   Properties prop=config.init_properties();

	  	    	//Navigate to Siebel
	  	   	   
	  	   	//opening the new tab
	        ((JavascriptExecutor)driver).executeScript("window.open('http://wntsiebt01/eEnergyOilGasChemicals_enu');");
	  	        
	  	
		  	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		  	    driver.switchTo().window(tabs2.get(1));
		  	    
	  	    	// Enter username and password 
	  	    	
	  	    	submitsiebelLogin.click();
	  	    	
	  	    	functions.setText(driver, SiebelUsernamefield, prop.getProperty("SiebelUsername"));	 
	  	    	functions.setText(driver, SiebelPasswordfield, prop.getProperty("SiebelPassword"));	 
	  	    	
	  	    	
	  	    	// Log in
	  	    	
	  	    	
	  	    	functions.click(driver,submitsiebelLogin);
	  	    	
	  	    	// Wait for UI to finish building
	  	    	try {
	  				Thread.sleep(10 * 1000);
	  			} catch (InterruptedException e1) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e1.printStackTrace();
	  			}
	  	    	
	  	    	// Go to opportunities tab
	  	    	
	  	    	try {
	  	    		//My own visibility function
	  	      
	  	        functions.click(driver,opportunitiesTabsiebel);
	  	      }
	  	      catch (StaleElementReferenceException e)
	  	      {
	  	          e.getMessage();
	  	      }
	  	    	functions.click(driver,opportunitiesTabsiebel);
	  	    	
	  	    	// Select "all opportunities"
	  	    	
	  	    	
	  	    	functions.selectDropdownByVisibleText(driver, AllopportunityDropdown, "All Opportunities");
	  	    
	  	    	
	  	    	// Wait few seconds for opportunities to refresh
	  	    	try {
	  				Thread.sleep(5 * 2000);
	  			} catch (InterruptedException e) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e.printStackTrace();
	  			}
	  	    	
	  	    	// Query for the opportunity
	  	    	
	  	    	
	  	    	functions.click(driver,QueryButton);
	  	    	
	  	    	// Wait for query view to appear
	  	    	try {
	  				Thread.sleep(20000);
	  			} catch (InterruptedException e) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e.printStackTrace();
	  			}
	  	    	
	  	    	
		  	    	Actions actions=new Actions(driver);
			 	
			 	for(int i=0;i<1;i++) {
			 	//Press the TAB Key to Switch Focus to Permanent Address
			     actions.sendKeys(Keys.TAB);
			     actions.build().perform();
			 	}
			 	
			 	functions.setText(driver, Opportunityidfield, Optyid);
			 	
	  	    	// Query for the opportunity by ID
			 	Thread.sleep(5000);
	  	    
	  	    	functions.click(driver,GoButton);
	  	    	
	  	    	// Wait for query to finish
	  	    	try {
	  				Thread.sleep(5 * 5000);
	  			} catch (InterruptedException e) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e.printStackTrace();
	  			}
	  	    	
		  	   // Click somewhere else to be able to click into opportunity
	
	  	    	for(int i=0;i<2;i++) {
		 	      actions.sendKeys(Keys.TAB);
		 	      actions.build().perform();
	  	    	}
		 	  // Wait for credit review request to appear, then click it
		 	    	
		 	 	   
		 	    	try {
		 				Thread.sleep(5 * 2000);
		 			} catch (InterruptedException e) {
		 				System.err.println("Failed to Thread.sleep()!");
		 				e.printStackTrace();
		 			}
	  	    	
	  	    	// Click into opportunity
	  	    	
		 		    functions.click(driver,Listofopportunities);
	  	    	
		 	    
	  	    	//Click into creditReviewResultTab
		 		    
		 	    	functions.click(driver, creditReviewResultTab);
		 	    	Thread.sleep(5000);
		 	    
		 	    	// Scroll down to credit alert drill down, then click it
		 	  	   
		  	    	
		  	    	functions.click(driver,creditAlertDrilldown);
		 	    	
	  	    	
	  	    	// Wait for credit alert drill down to appear
	  	    	
		  	    	try {
		 				Thread.sleep(5 * 2000);
		 			} catch (InterruptedException e) {
		 				System.err.println("Failed to Thread.sleep()!");
		 				e.printStackTrace();
		 			}
		  	    	
	  	    	
		  	   // Wait for last credit eval date input, and enter today's date
		 	    	functions.setText(driver,Evaluatorfield,data.get("Evaluator").toString());
		 	    	functions.click(driver, Calendaricon);
		 	    	functions.click(driver, Calendardate);
		 	    	functions.click(driver, CalendarDoneButton);
		 	    	
	  	    	
	  	    	// Select a RERG score, and set status to accepted
	  	    	
	  	    	functions.setText(driver,RERGScore, data.get("RERGScore").toString());
	  	    
	  	    	functions.setText(driver,CreditReviewResultdropdown, data.get("CreditReviewResult").toString());
	  	   
	  	    	
	  	   // Wait for everything to update
	  	    	try {
	  				Thread.sleep(10000);
	  			} catch (InterruptedException e) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e.printStackTrace();
	  			}
	  	   
	  	    	
	  	    	// Click into opportunities tab to save changes
	  	    	
	  	    	functions.click(driver,opportunitiesTabsiebel);
	  	    	
	  	    	// Wait for everything to update
	  	    	try {
	  				Thread.sleep(15000);
	  			} catch (InterruptedException e) {
	  				System.err.println("Failed to Thread.sleep()!");
	  				e.printStackTrace();
	  			}
	  	    	
	  	    	driver.close();
	  	    	
	  	      //switch to the parent window
	  	     driver.switchTo().window(tabs2.get(0));
	  	   
	  	    	 return new VhosPage(driver);
	  	    }
	
	 }


