@Enrollment
Feature: New Enrollment with usage > 50Kwh
#This Feature is for new enrollment customers for Usage greater than 50KWH
  @EndToEnd @TC_001_NewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product
    Given Sales person successfully logged into DSP
    Then make sure he/she is in landing page
    And Turn off WOLR view if enabled
    When Add New Opportunity in DSP
    When Add Customer to the new Opty
    When Add Sites to the new Opty
    Then View Credit
    When Login to Siebel as BA
    Then Approves Credit
    When Login to VHOS as Sales Person
    Then Validate Opty in VHOS
    And price a deal with Fixed product in DSP
    Then Generate Contract in DSP
    Then Make sure the contract is generated
    And Send generated contract to customer email
    #Then close the deal

  @TC_002_NewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate new Enrollment for a aggregate customer with usage > 50Kwh with Index product
    Given Sales person successfully logged into DSP
    Then make sure he/she in landing page
    Then Turn off WOLR view
    When  Add New Opportunity in DSP with customer sales group as Mid Market
    When Add  Customer to the new Opportunity
    Then Login to Siebel as BAnalyst
    Then Validate Customer is sucessfully created in Seibel 
    Then Add Sites to the new Opportunity
    Then Login to Seibel as BAnalyst 
    Then Validate Customer and Sites are correctly mapped to oppurtunities 
    Then View Credit in Dsp
    When Login to VHOS as Sales Personal
    Then Validate Opty id in VHOS
    Then Login to Siebel as BAnalyst
    Then Approves Credit in Dsp
    Then Login to VHOS as Sales Personal
    Then Validate quote pricing VHOS matches in DSP 
    Then price a deal with Index product in DSP
    Then Generate Contract details in DSP
    Then Making sure the contract is generated
    Then Send generated contract to customer email id
   # Then close the deal
    Then Login to Siebel as BAnalyst
    Then Validate losses,prices,voluntary recs,meterfee and deal closed status in seibel 
    Then Login to VHOS as Sales Personal
    Then Validate losses,prices,voluntary recs,meterfee and deal closed status in VHOS 

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