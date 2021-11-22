@Enrollment
Feature: Renew Enrollment with usage < 50Kwh

  @TC_007_RenewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate Renewal Enrollment for a single customer with usage < 50Kwh with Fixed product
    Given DSP:Sales person successfully logged into DSP
    #AND  DSP: take the test data from DB Query/XML/XLSX
    Then  DSP:make sure he/she is in landing page
    Then  DSP:Turn off WOLR view if enabled
    Given  DSP:Add New Opportunity in DSP
    When  DSP:Add Renewal Eligible Customer to the new Opty
    Then  DSP:Select Renew option for the active contract found
    Then  DSP:Add Sites to the new Opty
    Then  DSP:View Credit is automatically approved
    Then VHOS:Login to VHOS as Sales Person
    Then VHOS:Validate Opty in VHOS
    Then  DSP:price a deal with Fixed Product in DSP   
    Then  DSP:select Bundling Options as Ancillary and Losses
    Then  DSP:Generate Contract in DSP
    Then  DSP:Make sure the contract is generated
    Then  DSP:Send generated contract to customer email
    #Then close the deal

  @TC_008_RenewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate Renewal Enrollment for a Aggregate customer with usage < 50Kwh with Index product
    Given  DSP:Sales person successfully logged into DSP
    #AND  DSP: take the test data from DB Query/XML/XLSX
    Then  DSP:make sure he/she in landing page
    Then  DSP:Turn off WOLR view
    Given  DSP:Add New Opportunity in DSP
    When  DSP:Add Renewal Eligible Customer to the new Opty
    Then  DSP:Select Renew option for the active contract found
    Then  DSP:Add Sites to both customers in new Opty
    Then  DSP:View Credit is automatically approved
    Then VHOS:Login to VHOS as Sales Person
    Then VHOS:Validate Opty in VHOS
    Then  DSP:price a deal with Index product in DSP
    Then  DSP:select Bundling Options as  Ancillary and Losses
    Then  DSP:Generate Contract in DSP
    Then  DSP:Make sure the contract is generated
    Then  DSP:Send generated contract to customer email
    #Then close the deal
