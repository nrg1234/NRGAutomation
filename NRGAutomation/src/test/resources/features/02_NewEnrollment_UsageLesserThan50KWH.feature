@Enrollment
Feature: New Enrollment with usage < 50Kwh

  @TC_003_NewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate new Enrollment for a single customer with usage < 50Kwh with Fixed product
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    Then Turn off WOLR view if enabled
    Given Add New Opportunity in DSP with customer sales group as Net New
    When Add Customer to the new Opty
    Then Add Sites to the new Opty
    Then View Credit is automatically approved
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Fixed product in DSP
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal

  @TC_004_NewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate new Enrollment for a Aggregate customer with usage < 50Kwh with Index product
    Given Sales person successfully logged into DSP
    Then make sure he/she in landing page
    Then Turn off WOLR view
    Given Add New Opportunity in DSP with customer sales group as Mid Market
    When Add Customers to the new Opty
    Then Add Sites to both customers in new Opty
    Then View Credit is automatically approved
    Then Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    Then price a deal with Index product in DSP
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    Then Send generated contract to customer email
    Then close the deal
