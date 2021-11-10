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
  "location": "LoginDSP.user_is_on_Url_Login_screen()"
});
formatter.result({
  "duration": 7417144200,
  "status": "passed"
});
formatter.match({
  "location": "LoginDSP.page_Title_Should_be_Digital_Services_Platform()"
});
formatter.result({
  "duration": 110811262600,
  "status": "passed"
});
formatter.match({
  "location": "LoginDSP.toggle_should_be_Turned_off()"
});
formatter.result({
  "duration": 60176855800,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//button[contains(text(), \u0027Clear Filters\u0027)]\"}\n  (Session info: chrome\u003d95.0.4638.69)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.7.1\u0027, revision: \u00278a0099a\u0027, time: \u00272017-11-06T21:01:39.354Z\u0027\nSystem info: host: \u0027L11834\u0027, ip: \u002710.43.6.53\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 95.0.4638.69, chrome: {chromedriverVersion: 95.0.4638.54 (d31a821ec901f..., userDataDir: C:\\Users\\COG_SJ~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:49821}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 68e309d4ad602ea34d51a49cf5e926e6\n*** Element info: {Using\u003dxpath, value\u003d//button[contains(text(), \u0027Clear Filters\u0027)]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:600)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:370)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:472)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:362)\r\n\tat Pages.DSP.LandingPage.Toggle(LandingPage.java:69)\r\n\tat Stepdefinitions.DSP.LoginDSP.toggle_should_be_Turned_off(LoginDSP.java:32)\r\n\tat ✽.Then Turn off WOLR view if enabled(01_NewEnrollment_UsageGreaterThan50KWH.feature:8)\r\n",
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