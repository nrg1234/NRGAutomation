package Pages.DSP;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import apphooks.Base;

public class HomePageFunction {
	String Status;
	//locators
	@FindBy(xpath = "//button[@id='table-optype-btn']")
	WebElement Dropdownformoreopty;
	@FindAll(value = { @FindBy(xpath = "//button[@id='table-options-btn']") })
	public List<WebElement> Tableoptiondropdown;
	@FindBy(xpath = "//span[@class='mdi mdi-filter']")
	WebElement Customernamefilter;
	@FindBy(xpath = "//span[contains(text(),'Sales Channel')]")
	WebElement Saleschannelcheckbox;
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement applybtn;
	 @FindBy(xpath = "//th[normalize-space()='SALES CHANNEL']//span[@class='mdi mdi-filter']") 
	WebElement Saleschannelfilter;
	@FindBy(xpath = "//span[contains(text(),'Market')]")
	WebElement Marketcheckbox;
    @FindBy(xpath = "//th[normalize-space()='MARKET']//span[@class='mdi mdi-filter']")
    WebElement Marketfilter;
	@FindBy(xpath = "//span[contains(text(),'Type')]")
	WebElement Typecheckbox;
	@FindBy(xpath = "//span[contains(text(),'Deal Type')]")
	WebElement Dealtypecheckbox;
	
	@FindBy(xpath = "//a[contains(text(),'WOLR View')]")
	WebElement Wolrbtn;
	@FindBy(xpath = "//a[contains(text(),'Renewals Pipeline')]")
	WebElement RenewalPipelinebtn;
	  @FindBy(xpath = "//th[normalize-space()='Deal Type']//span[@class='mdi mdi-filter']")
	    WebElement Dealtypefilter;
	  @FindBy(xpath = "//th[@class='d-none d-sm-table-cell']//span[@class='mdi mdi-filter']")
	    WebElement Wolrtypefilter;
	  @FindBy(xpath = "//th[@class='d-none d-lg-table-cell']//span[@class='mdi mdi-filter']")
	    WebElement Thirdpartyfilter;
	  @FindBy(xpath = "//th[normalize-space()='END DATE']//span[@class='mdi mdi-filter']")
	    WebElement Enddatefilter;
	  @FindBy(xpath = "//th[normalize-space()='BROKER']//span[@class='mdi mdi-filter']")
	    WebElement Brokerfilter;
	
	WebDriver driver;
	CommonFunctions functions = new CommonFunctions();
	public  HomePageFunction(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}

public void dropdownfilter() throws Throwable {

	functions.click(driver, Dropdownformoreopty);
	functions.intermediatewait();
	System.out.println("Clicked on dropdownfilter");
	functions.click(driver, Dropdownformoreopty);
}
public void Tableoptionfilter() throws Throwable {
	
	Tableoptiondropdown.get(0).click();
	functions.intermediatewait();
	System.out.println("Clicked on tableoptionfilter");
	Tableoptiondropdown.get(0).click();
}
public void Customernamefilter() throws Throwable {
	
	functions.click(driver, Customernamefilter);
	functions.midintermediatewait();
	System.out.println("Clicked on dropdownfilter");
	functions.click(driver, Customernamefilter);
}
public void Saleschannelfilter() throws Throwable {
	
	Tableoptiondropdown.get(0).click();
	functions.shortWait();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Saleschannelcheckbox);
	functions.shortWait();
	functions.click(driver, Saleschannelcheckbox);
	functions.shortWait();
	functions.click(driver,  applybtn);
	functions.shortWait();

	functions.click(driver, Saleschannelfilter);
	System.out.println("Clicked on Saleschannelfilter");
	functions.intermediatewait();
	functions.click(driver, Saleschannelfilter);

}
public void Marketfilter() throws Throwable {
	
	Tableoptiondropdown.get(0).click();
	functions.shortWait();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Marketcheckbox);
	functions.shortWait();
	functions.click(driver, Marketcheckbox);
	functions.shortWait();
	functions.click(driver,  applybtn);
	functions.shortWait();
	
    functions.click(driver, Marketfilter);
	System.out.println("Clicked on Marketfilter");
	functions.intermediatewait();
	 functions.click(driver, Marketfilter);
}
public void Opportunitytypefilter() throws Throwable {
	
	Tableoptiondropdown.get(0).click();
	functions.shortWait();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Typecheckbox);
	functions.shortWait();
	functions.click(driver, Typecheckbox);
	functions.shortWait();
	functions.click(driver,  applybtn);
	functions.shortWait();
 
	System.out.println("Clicked on Opportunitytypefilter");
	functions.intermediatewait();

}
public void Dealtypefilter() throws Throwable {
	
	Tableoptiondropdown.get(0).click();
	functions.shortWait();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", Dealtypecheckbox);
	functions.shortWait();
	functions.click(driver, Dealtypecheckbox);
	functions.shortWait();
	functions.click(driver,  applybtn);
	functions.shortWait();
     functions.click(driver,  Dealtypefilter);
	System.out.println("Clicked on Dealtypefilter");
	functions.intermediatewait();

}
public void Wolrfilter() throws Throwable {
	
	functions.click(driver,Wolrbtn);
	functions.shortWait();
functions.click(driver, Wolrtypefilter);
	System.out.println("Clicked on Wolrfilter");
	functions.intermediatewait();
}
public void Thirdpartyfilter() throws Throwable {
	
functions.click(driver, Thirdpartyfilter);
	System.out.println("Clicked on Thirdpartyfilter");
	functions.intermediatewait();
}
public void Enddatefilter() throws Throwable {
	functions.click(driver, RenewalPipelinebtn);
	functions.shortWait();
functions.click(driver, Enddatefilter);
	System.out.println("Clicked on Enddatefilter");
	functions.intermediatewait();
}
public String Brokerfilter() throws Throwable {
	
	try {
		
	if(Brokerfilter.isEnabled()) {
functions.click(driver, Brokerfilter);
	System.out.println("Clicked on Brokerfilter");
	functions.intermediatewait();
	String Status="Pass";
	return Status;
	}
}
	catch(Exception e) {
		String Status="Fail";
	}

return Status;
}
}