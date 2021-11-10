$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_NewEnrollment_UsageGreaterThan50KWH.feature");
formatter.feature({
  "line": 2,
  "name": "New Enrollment with usage \u003e 50Kwh",
  "description": "",
  "id": "new-enrollment-with-usage-\u003e-50kwh",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Enrollment"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#This Feature is for new enrollment customers for Usage greater than 50KWH"
    }
  ],
  "line": 5,
  "name": "Validate new Enrollment for a single customer with usage \u003e 50Kwh with Fixed product",
  "description": "",
  "id": "new-enrollment-with-usage-\u003e-50kwh;validate-new-enrollment-for-a-single-customer-with-usage-\u003e-50kwh-with-fixed-product",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@EndToEnd"
    },
    {
      "line": 4,
      "name": "@TC_001_NewEnrollment_SingleCustomer_FixedProduct"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Sales person successfully logged into DSP",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "make sure he/she is in landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Turn off WOLR view if enabled",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Add New Opportunity in DSP",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Add Customer to the new Opty",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Add Sites to the new Opty",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "View Credit",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Login to Siebel as BA",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Approves Credit",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Login to VHOS as Sales Person",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Validate Opty in VHOS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "price a deal with Fixed product in DSP",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Generate Contract in DSP",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Make sure the contract is generated",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Send generated contract to customer email",
  "keyword": "And "
});
formatter.match({
  "location": "LoginDSP.user_is_on_Url_Login_screen()"
});
formatter.result({
  "duration": 13674522599,
  "status": "passed"
});
formatter.match({
  "location": "LoginDSP.page_Title_Should_be_Digital_Services_Platform()"
});
formatter.result({
  "duration": 154087287300,
  "status": "passed"
});
formatter.match({
  "location": "LoginDSP.toggle_should_be_Turned_off()"
});
formatter.result({
  "duration": 14113301,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy20.isSelected(Unknown Source)\r\n\tat Pages.DSP.LandingPage.Toggle(LandingPage.java:60)\r\n\tat Stepdefinitions.DSP.LoginDSP.toggle_should_be_Turned_off(LoginDSP.java:33)\r\n\tat ✽.And Turn off WOLR view if enabled(01_NewEnrollment_UsageGreaterThan50KWH.feature:8)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Enrollment.create_new_opportunity()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.add_customer_to_dsp_opty()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.add_sites_to_the_opty()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.view_credit_chevron()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.Login_to_Siebel_as_BA()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.Ba_approves_credit_in_siebel()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.Login_to_VHOS_as_Sales_Person()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.Opportunity_should_be_validated_in_VHOS()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.price_a_deal()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.generate_contract()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.View_Contracts()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Enrollment.send_contract_to_customer()"
});
formatter.result({
  "status": "skipped"
});
});