package TestRunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/resources/features",
		tags="@NewEnrollment_SingleCustomer_Meterfee_VolRecs",
		glue = {"Stepdefinitions","apphooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:rerun/failed_scenarios.txt"},
		monochrome = true
)
//Running with cucumber class

public class EndToEndTest
{
	
	   }
