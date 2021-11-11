@Enrollment
Feature: Renew Enrollment with usage < 50Kwh

  @TC_007_RenewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate Renewal Enrollment for a single customer with usage < 50Kwh with Fixed product
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    Then Turn off WOLR view if enabled
    Given Add New Opportunity in DSP
    When Add Renewal Eligible Customer to the new Opty
    Then Select Renew option for the active contract found
    Then Add Sites to the new Opty
    Then View Credit is automatically approved
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Fixed Product in DSP   
    Then select Bundling Options as Ancillary and Losses
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal

  @TC_008_RenewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate Renewal Enrollment for a Aggregate customer with usage < 50Kwh with Index product
    Given Sales person successfully logged into DSP
    Then make sure he/she in landing page
    Then Turn off WOLR view
    Given Add New Opportunity in DSP
    When Add Renewal Eligible Customer to the new Opty
    Then Select Renew option for the active contract found
    Then Add Sites to both customers in new Opty
    Then View Credit is automatically approved
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Index product in DSP
    Then select Bundling Options as  Ancillary and Losses
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal
