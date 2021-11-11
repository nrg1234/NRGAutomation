$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EndToEnd/01_NewEnrollment_UsageGreaterThan50KWH.feature");
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
formatter.match({
  "location": "LoginDSP.user_is_on_Url_Login_screen()"
});
formatter.result({
  "duration": 2482465300,
  "status": "passed"
});
});