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
  "duration": 11233629299,
  "status": "passed"
});
formatter.match({
  "location": "LoginDSP.page_Title_Should_be_Digital_Services_Platform()"
});
