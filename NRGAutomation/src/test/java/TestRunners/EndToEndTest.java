package TestRunners;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {"src/test/resources/features"},
		tags={"@EndToEnd"},
		glue = {"Stepdefinitions"},
		plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
)
//Running with cucumber class

public class EndToEndTest
{
	@AfterClass
	    public static void  extentReport()
	   {
	       Reporter.loadXMLConfig("./src/test/resources/Config/ExtentReports.xml");
	       Reporter.setSystemInfo("user", System.getProperty("user.name"));
	       Reporter.setSystemInfo("os", "Windows");
	       Reporter.setTestRunnerOutput("Sample test runner output message");
	   }
}
