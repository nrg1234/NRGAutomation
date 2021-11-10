@Enrollment
Feature: New Enrollment with usage > 50Kwh

  @EndToEnd @TC_001_NewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    Then Turn off WOLR view if enabled
    Then Add New Opportunity in DSP
    When Add Customer to the new Opty
    Then Add Sites to the new Opty
    Then View Credit
    Then Login to Siebel as BA
    Then Approves Credit
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Fixed product in DSP
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    #Then close the deal

  @TC_002_NewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate new Enrollment for a aggregate customer with usage > 50Kwh with Index product
    Given Sales person successfully logged into DSP
    Then make sure he/she in landing page
    Then Turn off WOLR view
    Given Add New Opportunity in DSP
    When Add Customer to the new Opty
    Then Add Sites to the new Opty
    Then View Credit
    Then Login to Siebel as BA
    Then Approves Credit
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Index product in DSP
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal

  @TC_014_StaggeredSite
  Scenario: Validate StaggeredSite Enrollment for a single customer with usage > 50Kwh with Fixed product
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    Then Turn off WOLR view if enabled
    Given Add New Opportunity in DSP
    When Add Customer to the new Opty
    Then Add Sites to the new Opty
    Then Edit Delayed Start Date for the Sites
    Then View Credit
    Then Login to Siebel as BA
    Then Approves Credit
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Fixed Product in DSP
    Then select Bundling Options as Ancillary and Losses
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal

  @TC_015_StaggeredSite
  Scenario: Validate StaggeredSite Enrollment for a Aggregate customer with usage > 50Kwh with Index product
    Given Sales person successfully logged into DSP
    Then make sure he/she in landing page
    Then Turn off WOLR view
    Given Add New Opportunity in DSP
    When Add Customers to the new Opty
    Then Add Sites to both customers in new Opty
    Then Edit Delayed Start Date for the Sites
    Then View Credit
    Then Login to Siebel as BA
    Then Approves Credit
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Index product in DSP
    Then select Bundling Options as  Ancillary and Losses
    Then select Vol Recs and Meter Fee
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal

  @TC_018_Blank
  Scenario: Validate Blank LOA details entered from Email is available in the DSP Opportunity
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    Then Turn off WOLR view if enabled
    Given Select Send Blank LOA from Opportunity Drop down
    When User receives an email with Blank LOA
    Then Enter all required details and complete Docusign
    Then Search for the same opportunity in DSP
    Then validate the customer and sites entered in LOA is available in DSP
    Then Download the LOA in DSP