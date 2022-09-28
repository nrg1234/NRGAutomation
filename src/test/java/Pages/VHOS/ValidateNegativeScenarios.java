package Pages.VHOS;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import apphooks.Base;
import junit.framework.Assert;

public class ValidateNegativeScenarios {
	@FindBy(xpath = "//a[contains(text(), 'here')]")
	WebElement clickhereButton;
	@FindBy(xpath = "//span[@id='A0486:f2:msg']")
	WebElement searchResult;
	@FindBy(xpath = "//input[@name='A3574:sff2:searchString2']")
	WebElement searchfieldinVHOS;
	@FindAll(value = { @FindBy(xpath = "//span[@class='ui-icon ui-icon-triangle-1-e']") })
	public List<WebElement> Sitesdropdwnbtn;
	@FindBy(xpath = "//span[@id='A0486:f2:j_idt30:j_idt31:j_idt32:0:j_idt33:j_idt67:j_idt68:j_idt69:0:_t70']")
	WebElement clickonsites;
	@FindBy(xpath = "//span[@id='A5007:j_idt7:j_idt11:voltageTxt']")
	WebElement voltage;
	@FindBy(xpath = "//span[@id='A5007:j_idt7:j_idt11:rateCodeTxt']")
	WebElement ratecode;
	

	
	WebDriver driver;

	public ValidateNegativeScenarios(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}



	public String ValidateRatecodeandVoltage(String Optyid) throws Throwable {
		CommonFunctions functions = new CommonFunctions();

		System.out.println("passing the string value from Add sites to the OPty method:" + Optyid);
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();

		// getting all the handles currently available

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		// Enters Opportunity id in the Search Field
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='A3574:sff2:searchString2']")));
		functions.setText(driver, searchfieldinVHOS, Optyid);
		searchfieldinVHOS.sendKeys(Keys.ENTER);

		// Wait for Opportunity details to get displayed

		functions.intermediatewait();
		// click on site list dropdown
		Sitesdropdwnbtn.get(2).click();
		functions.vshortWait();
		functions.click(driver, clickonsites);
		functions.shortWait();
	String status1 = "Pass"	 ;
	String status2 = "Fail"   ;
		//Verify voltage and rate code
	String	Actualvoltage= voltage.getText();
	String Exceptedvoltage= "";
	String ActualRatecode=ratecode.getText();
	String ExpectdRatecode= "";
	if((Actualvoltage.equals(Exceptedvoltage)) && (ActualRatecode.equals(ExpectdRatecode)))
	{
		driver.close();

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
		return status1;
		
	}else {
	
		// Close the tab
		driver.close();

		// switch to the parent window
		driver.switchTo().window(tabs2.get(0));
		return status2 ;
	
	
}
	}
}