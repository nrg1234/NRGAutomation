package Pages.DSP;
import java.util.List;
import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonFunctions;

public class HUFileUpload {
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'HU')]") })
	public List<WebElement> HUTab;
	@FindBy(xpath = "//button[contains(text(), 'Upload HU')]")
	WebElement UploadHUBtn;
	@FindBy(xpath = "//div[contains(text(),'Browse')]")
	WebElement BrowseBtn;
	@FindAll(value = { @FindBy(xpath = "//button[contains(text(),'Upload')]") })
	public List<WebElement> UploadBtn;
	@FindBy(xpath = "//button[contains(text(),'Customer')]")
	WebElement customerTAB;
	WebDriver driver;

	public HUFileUpload(Base base) {
		this.driver = base.driver;
		PageFactory.initElements(driver, this);
	}


	public void fileupload() throws InterruptedException {

		CommonFunctions functions = new CommonFunctions();

		// Click HU Tab
		HUTab.get(0).click();

		// Click Upload HU Button
		functions.click(driver, UploadHUBtn);

		// Click Browse button and Select the Upload File from the machine

		Actions act = new Actions(driver);
		act.moveToElement(BrowseBtn).click().perform();
		String filePath = "./src/test/resources/DataReader/ADAMS GROCERY.xlsx";

		//Replacing the Filepath to SIngle Back Slash
		filePath.replaceAll("\\\\", "\\\\\\\\");

		//Passing File Path to Robot Method
		functions.uploadFileWithRobot(filePath);

		//Wait for Sometime
		functions.shortWait();

		// Click on Upload Button
		
		UploadBtn.get(1).click();

		functions.shortWait();

	}
}
