package Stepdefinitions.VHOS;

import java.sql.SQLException;
import java.util.Properties;

import Pages.VHOS.ValidateNegativeScenarios;
import Utilities.ConfigReader;
import Utilities.ConnectToDatabase;
import Utilities.Context;
import Utilities.TestContext;
import Utilities.TestcaseResultintoExcel;
import apphooks.Base;
import io.cucumber.java.en.When;

public class NegativeScenarios extends Base {

	 private Base base;
	    TestContext testContext;
	    public NegativeScenarios (Base base, TestContext context) {
	        this.base = base;
	        testContext = context;
	    }
	    String Scenario="Validate First Negative testcase with usage > 50Kwh";
	    ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
	    String PodId= prop.getProperty("podid");
	    TestcaseResultintoExcel Result=new TestcaseResultintoExcel(base);
	    ValidateNegativeScenarios negative = new ValidateNegativeScenarios(base);
	    ConnectToDatabase DB = new ConnectToDatabase(base);
	    Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
	    @When("VHOS: Verify whether site is present is Vhos DB and Verify rate code and voltage in Vhos")
	    public void vhos_verify_whether_site_is_present_is_vhos_db_and_verify_rate_code_and_voltage_in_vhos() throws Throwable {
	 boolean validation=  DB.SitevalidationVHOS(PodId);	    
	    if(validation) {
	    	String result= negative.ValidateRatecodeandVoltage((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
	    	Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, result);
	    }
	    Result.ResultintoExcel((String) testContext.scenarioContext.getContext(Context.OPTY_ID),Scenario, "Fail");

	    }


}