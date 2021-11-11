package TestRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {"src/test/resources/features"},
		tags="@EndToEnd",
		glue = {"Stepdefinitions"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
)
//Running with cucumber class

public class EndToEndTest
{
	//@AfterClass
//	    public static void  extentReport()
//	   {
//	       Reporter.loadXMLConfig("./src/test/resources/Config/ExtentReports.xml");
//	       Reporter.setSystemInfo("user", System.getProperty("user.name"));
//	       Reporter.setSystemInfo("os", "Windows");
//	       Reporter.setTestRunnerOutput("Sample test runner output message");
	   }
