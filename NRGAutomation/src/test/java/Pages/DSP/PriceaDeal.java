package Pages.DSP;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import Utilities.ConfigReader;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;

public class PriceaDeal  {
	WebDriver driver;
	public  PriceaDeal(Base base)  {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//button[contains(text(), 'Quotes')]")
	WebElement quotesTAB;

	@FindBy(xpath="//*[@id='quotesLoader']")
	WebElement quotesLoader;

	@FindBy(xpath="//span[contains(text(), 'See Details')]")
	WebElement seeDetails;
	
	@FindBy(xpath="//button[@id='bp-visible-switch']")
	WebElement brokerVisibletoggle;
	
	@FindBy(xpath="//a[contains(text(), 'Index')]")
	WebElement indexTAB;

	@FindBy(xpath="//input[@id='mat-input-12']")
	WebElement marginfield;

	@FindBy(xpath="//input[@id='mat-input-13']")
	WebElement doaMarginfield;

	@FindBy(xpath="//button[contains(text(), 'Calculate and Save')]")
	WebElement calculateAndSave;

	@FindAll(value = { @FindBy(xpath="//span[contains(text(), 'Select')]") })
	public List<WebElement> productSelectBtn;
	
	@FindBy(xpath="//li[@class='ng-star-inserted active']//a[contains(text(), 'Index')]")
	WebElement IndexPriceBtn;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement convert50kwBtn;

	 @FindBy(xpath = "//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
	    WebElement opportunityIDText;
	
	 /*
     * Price a deal with Fixed Product.
     */
    public void priceadeal()throws Throwable  {
 	   CommonFunctions functions=new CommonFunctions();
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
 	   // Navigate to quotes page
    	assertTrue("Quotes page button should be there", quotesTAB.isDisplayed());
    	functions.click(driver,quotesTAB);
    	
    	
  // Wait for spinner to appear when request is made to Siebel
    	functions.shortWait();
 	

 	//Updating Margin and DOA Margin Values
 	functions.setText(driver, marginfield, prop.getProperty("Margin"));
 	functions.setText(driver, doaMarginfield, prop.getProperty("DOAMargin"));
 	
 	//Calculate and save
 	functions.click(driver,calculateAndSave);
 	
 	
 	 // Wait for spinner to appear when request is made to Siebel
 	functions.midWait();
 	
 	// Select a product
 	productSelectBtn.get(1).click();

    }

    
    /*
     * Price a deal with Index Product.
     */
    public void priceadealwithindexproduct(Map<String,Object> data)throws Throwable  {
    	   CommonFunctions functions=new CommonFunctions();
    	// Navigate to quotes page
    	assertTrue("Quotes page button should be there", quotesTAB.isDisplayed());
    	functions.click(driver,quotesTAB);
    	
    	
    // Wait for spinner to appear when request is made to Siebel
    	try {
    		Thread.sleep(5000);
    	} catch (InterruptedException e) {
    		System.err.println("Failed to Thread.sleep()!");
    		e.printStackTrace();
    	}
    	
    	//Clicks on Index Price Button
    	functions.click(driver, IndexPriceBtn);

    	//Updating Margin and DOA Margin Values
    	functions.setText(driver, marginfield, data.get("Margin").toString());
    	functions.setText(driver, doaMarginfield, data.get("DOAMargin").toString());
    	
    	//Calculate and save
    	functions.click(driver,calculateAndSave);
    	
    	
    	 // Wait for spinner to appear when request is made to Siebel
    	try {
    		Thread.sleep(30000);
    	} catch (InterruptedException e) {
    		System.err.println("Failed to Thread.sleep()!");
    		e.printStackTrace();
    	}
    	
    	// Select a product
    	productSelectBtn.get(1).click();
    	

    }
    /*
     * Price a deal with Fixed Product for less than 50kw.
     */
    public void priceadeallessthan50(Map<String,Object> data)throws Throwable  {
 	   CommonFunctions functions=new CommonFunctions();
 	
 	   // Navigate to quotes page
    	assertTrue("Quotes page button should be there", quotesTAB.isDisplayed());
    	
    	
  // Wait for spinner to appear when request is made to Siebel
    	functions.shortWait();
 	

 	//Updating Margin and DOA Margin Values
 	functions.setText(driver, marginfield, data.get("Margin").toString());
 	functions.setText(driver, doaMarginfield, data.get("DOAMargin").toString());
 	
 	//Calculate and save
 	functions.click(driver,calculateAndSave);
 	
 	
 	 // Wait for spinner to appear when request is made to Siebel
 	functions.midWait();
 	
 	// Select a product
 	productSelectBtn.get(1).click();

    }

    
}
