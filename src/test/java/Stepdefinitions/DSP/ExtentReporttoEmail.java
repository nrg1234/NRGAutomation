package Stepdefinitions.DSP;

import java.awt.AWTException;
import java.io.IOException;

import Pages.DSP.LandingPage;
import Pages.DSP.SendOutlookEmail;
import apphooks.ApplicationHooks;
import apphooks.Base;
import io.cucumber.java.en.Given;

public class ExtentReporttoEmail extends Base {

		private Base base;

		public ExtentReporttoEmail(Base base) {
			this.base = base;
		}
		LandingPage DspLandingPage = new LandingPage(base);
		ApplicationHooks hooks = new ApplicationHooks(base);
		SendOutlookEmail Outlook=new SendOutlookEmail(base);
		@Given("DSP: Send Email to Stakeholders")
		public void Send_email_To_Stakeholders() throws InterruptedException, AWTException, IOException {
			//hooks.launchApp();
			//DspLandingPage.launchoutlook();
			Outlook.SendEmail();
		}
}
