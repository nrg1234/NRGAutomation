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
    		   
    		   tags={"@smoke"},
        glue = {"Stepdefinitions"},
        plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport"},
       monochrome = true
     
)
//Running with cucumber class

public class Testrunner
{
	@AfterClass
	    public static void  extentReport()
	   {
	       Reporter.loadXMLConfig("C:\\Users\\pankajab\\eclipse-workspace\\NRGAutomation.zip_expanded\\NRGAutomation\\ExtentReports.xml");
	       Reporter.setSystemInfo("user", System.getProperty("user.name"));
	       Reporter.setSystemInfo("os", "Windows");
	       Reporter.setTestRunnerOutput("Sample test runner output message");
	   }
}
