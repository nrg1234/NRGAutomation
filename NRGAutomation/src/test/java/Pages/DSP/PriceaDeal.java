package Pages.DSP;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class PriceaDeal  {
	WebDriver driver;
	public  PriceaDeal(WebDriver driver)  {
		this.driver = driver;
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
	
	 /*
     * Price a deal.
     */
    public GenerateContract priceadeal(Map<String,Object> data)throws Throwable  {
 	   CommonFunctions functions=new CommonFunctions();
 	// Navigate to quotes page
    	assertTrue("Quotes page button should be there", quotesTAB.isDisplayed());
    	//waitForvisibility(QuotesTAB,10);
    	functions.click(driver,quotesTAB);
    	
    	
  // Wait for spinner to appear when request is made to Siebel
 	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
 	

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
 	
 	return new GenerateContract(driver);
    }
}
