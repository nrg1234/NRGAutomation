package Stepdefinitions.DSP;

import java.sql.SQLException;

import Pages.DSP.ViewCredit;
import Utilities.CommonFunctions;
import Utilities.ConnectToDatabase;
import Utilities.TestContext;
import apphooks.Base;
import io.cucumber.java.en.Then;

public class CreditEvaluationValidation {
	private Base base;
	TestContext testContext;

	public CreditEvaluationValidation(Base base, TestContext context) throws InterruptedException {
		this.base = base;
		testContext = context;
	}
	ConnectToDatabase DB = new ConnectToDatabase(base);
	CommonFunctions encrypted = new CommonFunctions();
	ViewCredit credit = new ViewCredit(base);
	@Then("DSP:Validate Credit Evaluation with DB")
	public void dsp_validate_credit_evaluation_with_db() throws ClassNotFoundException, SQLException, InterruptedException {
		String Externalopportunityid=credit.GetExternalopportunityid();
	   DB.SetUpConnectionVHOSCreditEvaluation(Externalopportunityid);
	}

	
}