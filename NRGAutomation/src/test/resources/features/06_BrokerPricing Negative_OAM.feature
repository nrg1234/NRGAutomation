@Enrollment
Feature: Negative validations for Broker Enrollment < 50Kwh from OAM

  @TC_010_Multiple
  Scenario: Validate Multiple TDSP Site and Non-ERCOT site addition is not allowed for Broker Enrollment < 50Kwh from OAM
    Given Broker successfully logged into OAM
    When User select Aggregator Third Party from drop down
    Then make sure he/she navigates to Enrollment Page
    Given Add New Opportunity in OAM 
    When Add Customer to the new Opty
    Then Add Sites to the new Opty
    Given User access the same oppurtunity from DSP 
    When user add Multiple TDSP Site to this oppurtunity
    Then validate Multiple TDSP Site addition is not allowed for this oppurtunity
    When user add Non-ERCOT Site to this oppurtunity
    Then validate Non-ERCOT Site addition is not allowed for this oppurtunity

  @TC_011_Aggregate
  Scenario: Validate Aggregate Customer addition is not allowed Broker Enrollment < 50Kwh from OAM
    Given Broker successfully logged into OAM
    When User select Aggregator Third Party from drop down
    Then make sure he/she navigates to Enrollment Page
    Then Add New Opportunity in OAM 
    Then Add Customer to the new Opty
    Then Add Sites to the new Opty
    Given Add another customer to this oppurtunity
    Then Validate Pricing is locked 
