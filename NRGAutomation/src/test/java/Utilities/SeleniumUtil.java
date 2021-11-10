package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import Baseclass.Library;

public class SeleniumUtil extends Library {
	public SeleniumUtil(WebDriver driver) {
        Library.driver = driver;
        PageFactory.initElements(driver, this);
    }
	public String Takessnapshot(WebDriver driver) throws IOException{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		String dest="C:\\Users\\pankajab\\eclipse-workspace\\Latest119\\NRGAutomation.zip_expanded\\NRGAutomation\\Screenshots\\NewOpportunity.png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
		}
	
	
	
	public String captureScreen() {
		try {
		Random rand = new Random();
		int randomNo = rand.nextInt(100000000) + 1;
		//WebDriver augmentedDriver = new Augmenter().augment(driver);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotName = "C:\\Users\\pankajab\\eclipse-workspace\\Latest119\\NRGAutomation.zip_expanded\\NRGAutomation\\Screenshots"+"screenshot_"+randomNo+".png";
		String relativeScreenShotName = "screenshots\\screenshot_"+randomNo+".png";
		FileUtils.copyFile(source, new File(screenShotName));
		return relativeScreenShotName;
		}
		catch(Exception e) {
		return "ERROR_IN_SCREEN_CAPTURE";
		}
		}
	
	
	public MediaEntityModelProvider takeScreenshot() {
		try {
		return MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build();
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		}
}
