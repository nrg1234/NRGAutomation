package TestRunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(publish=true ,
		features = "src/test/resources/features",
		tags="@CICD",
		glue = {"Stepdefinitions","apphooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:rerun/failed_scenarios.txt"},
		monochrome = true
)
//Running with cucumber class

public class EndToEndTest
{
	
	   }
