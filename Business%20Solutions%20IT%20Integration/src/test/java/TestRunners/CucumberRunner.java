package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
		features = "src/test/resources/features",
		tags="@SmokeTest",
		glue = {"Stepdefinitions","apphooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
)
 
public class CucumberRunner extends AbstractTestNGCucumberTests {
 
}
