package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
	        features = {"@rerun/failed_scenarios.txt"},
	        monochrome = true,
	        plugin = {
	        "pretty", "html:target/cucumber-report/single",
	        "json:target/cucumber-report/single/rerun_cucumber.json"},
	        glue = {"common","sample"}
	        )
	
	//Running with cucumber class

	public class FailureRerun
	{
		
		   }
