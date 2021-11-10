package Pages.DSP;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.Library;
import Utilities.CommonFunctions;

public class HUFileUpload extends Library{

	
	public  HUFileUpload(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindAll(value = { @FindBy(xpath="//button[contains(text(),'HU')]")})
	public List<WebElement> HUTab;
	
	@FindBy(xpath="//button[contains(text(), 'Upload HU')]")
	WebElement uploadHUBtn;
	
	@FindBy(xpath="//div[contains(text(),'Browse')]")
	WebElement browseBtn;
	
	@FindAll(value = { @FindBy(xpath="//button[contains(text(),'Upload')]")})
	public List<WebElement> uploadBtn;
	
	@FindBy(xpath="//button[contains(text(),'Customer')]")
	WebElement customerTAB;
	
	
	
	public void fileupload() throws InterruptedException {
		
		CommonFunctions functions=new CommonFunctions();
		
		Thread.sleep(2000);

		// Click HU Tab
		HUTab.get(0).click();
		
		//Click Upload HU Button
		
		functions.click(driver,uploadHUBtn);
		
		Thread.sleep(2000);
		
		//Click Browse button and Select the Upload File from the machine
		
		Actions act=new Actions(driver);
		WebElement chooseFile= browseBtn;
		act.moveToElement(chooseFile).click().perform();
		Thread.sleep(6000);
		
		
		String filePath = "C:\\Users\\pankajab\\Pictures\\ADAMS GROCERY.xlsx";
		filePath.replaceAll("\\\\", "\\\\\\\\");
		System.out.println(filePath);
		functions.uploadFileWithRobot(filePath);
		Thread.sleep(3000);
	
		//Click Upload Button
		uploadBtn.get(1).click();
		
		Thread.sleep(2000);
		
		
}
}