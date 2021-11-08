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
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Add New Opportunity in DSP",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Add Customer to the new Opty",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Add Sites to the new Opty",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "View Credit",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Login to Siebel as BA",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Approves Credit",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Login to VHOS as Sales Person",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Validate Opty in VHOS",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "price a deal with Fixed product in DSP",
  "keyword": "Then "
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
  "keyword": "Then "
});
formatter.match({
  "location": "Login.user_is_on_Url_Login_screen()"
});
formatter.result({
  "duration": 7362669100,
  "status": "passed"
});
formatter.match({
  "location": "Login.page_Title_Should_be_Digital_Services_Platform()"
});
formatter.result({
  "duration": 107475378400,
  "status": "passed"
});
formatter.match({
  "location": "Login.toggle_should_be_Turned_off()"
});
formatter.result({
  "duration": 22284729800,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.create_new_opportunity()"
});
formatter.result({
  "duration": 11680254600,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.add_customer_to_dsp_opty()"
});
formatter.result({
  "duration": 32874935100,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.add_sites_to_the_opty()"
});
formatter.result({
  "duration": 62780602100,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.view_credit_chevron()"
});
formatter.result({
  "duration": 1416664600,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.Login_to_Siebel_as_BA()"
});
formatter.result({
  "duration": 13533052500,
  "status": "passed"
});
formatter.match({
  "location": "Enrollment.Ba_approves_credit_in_siebel()"
});
