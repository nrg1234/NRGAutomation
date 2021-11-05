$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DSPLoginPage.feature");
formatter.feature({
  "line": 2,
  "name": "Login Screen Validation",
  "description": "",
  "id": "login-screen-validation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Validate user is able to complete a Successful Single customer Enrollment \u003e 50Kwh with Product Type as Fixed, Bundling Options as  Ancillary, Losses",
  "description": "",
  "id": "login-screen-validation;validate-user-is-able-to-complete-a-successful-single-customer-enrollment-\u003e-50kwh-with-product-type-as-fixed,-bundling-options-as--ancillary,-losses",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@smoke"
    },
    {
      "line": 4,
      "name": "@tc_01_SinglecustomerEnrollment"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is on Url Login screen",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Page Title Should be Digital Services Platform",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Toggle should be Turned off",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Create New Opportunity",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Add Customer to DSP Opty",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Add Sites to the Opty",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "View Credit Chevron",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "BA Approves Credit in Siebel",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "Opportunity should be validated in VHOS",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "price a deal",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "Generate Contract",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "View Contracts",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Send contract to customer",
  "keyword": "Then "
});
formatter.match({
  "location": "DSPLoginStepdefinition.user_is_on_Url_Login_screen()"
});
formatter.result({
  "duration": 123185055248,
  "status": "passed"
});
formatter.match({
  "location": "DSPLoginStepdefinition.page_Title_Should_be_Digital_Services_Platform()"
});
formatter.result({
  "duration": 10523267,
  "status": "passed"
});
formatter.match({
  "location": "DSPLoginStepdefinition.toggle_should_be_Turned_off()"
});
formatter.result({
  "duration": 15065627419,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.create_new_opportunity()"
});
formatter.result({
  "duration": 6640488799,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.add_customer_to_dsp_opty()"
});
formatter.result({
  "duration": 24217439565,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.add_sites_to_the_opty()"
});
formatter.result({
  "duration": 61829374103,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.view_credit_chevron()"
});
formatter.result({
  "duration": 241493935,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.ba_approves_credit_in_siebel()"
});
formatter.result({
  "duration": 140001499428,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.Opportunity_should_be_validated_in_VHOS()"
});
formatter.result({
  "duration": 70669114278,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.price_a_deal()"
});
formatter.result({
  "duration": 45974369528,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.generate_contract()"
});
formatter.result({
  "duration": 101428152874,
  "status": "passed"
});
formatter.match({
  "location": "DSPEnrollment.View_Contracts()"
});
