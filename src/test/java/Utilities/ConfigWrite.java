package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.DSP.CreateOptyPopup;
import apphooks.ApplicationHooks;
import apphooks.Base;

public class ConfigWrite {
	private Base base;
	
	ApplicationHooks hooks=new ApplicationHooks(base) ;
	WebDriver driver;
	TestContext testContext;
	public ConfigWrite(Base base) {
	this.base = base;
	}
	//public static void main(final String[] args) throws IOException {
	public void Randomname() throws IOException, InterruptedException {
		CommonFunctions functions = new CommonFunctions();
			// random string of length 8 composed only of lettes a, b, and c
			String alphabet = "TestforE2E";
			Random random=new Random();
			String number = String.valueOf (random.nextInt(1000));
			String Opportunityname=alphabet.concat(number);
			Properties Pro=new Properties();
			String Path="houfip01"+"/"+"BusinessDir"+"/"+"Sriram"+"/"+"ExtentReports"+"/";
			//Path.replaceAll("\\\\\\\\","\\\\");
			System.out.println(Path);
			FileOutputStream file=new FileOutputStream("src\\test\\resources\\extent.properties",true);
			Pro.put("extent.reporter.spark.out", "//"+Path+Opportunityname+".html");
			Pro.store(file, "test");
			functions.mediumWait();
			
		}
}
