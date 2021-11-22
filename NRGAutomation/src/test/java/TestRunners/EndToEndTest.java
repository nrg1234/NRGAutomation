package TestRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {"src/test/resources/features"},
		tags="@EndToEnd",
		glue = {"Stepdefinitions","apphooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
)
//Running with cucumber class

public class EndToEndTest
{
	
	   }
