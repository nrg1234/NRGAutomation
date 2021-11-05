@Login
Feature: Login Screen Validation

@smoke @tc_01_SinglecustomerEnrollment
Scenario: Validate user is able to complete a Successful Single customer Enrollment > 50Kwh with Product Type as Fixed, Bundling Options as  Ancillary, Losses  
Given User is on Url Login screen
Then Page Title Should be Digital Services Platform
Then Toggle should be Turned off
Given Create New Opportunity 
When Add Customer to DSP Opty
Then Add Sites to the Opty 
Then View Credit Chevron
Then BA Approves Credit in Siebel 
Then Opportunity should be validated in VHOS
Then price a deal
Then Generate Contract
Then View Contracts
Then Send contract to customer