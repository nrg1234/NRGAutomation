@Enrollment
Feature: New Enrollment with usage < 50Kwh

  @SingleEnrollmentlessthan50 @TC_003_NewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate new Enrollment for a single customer with usage < 50Kwh with Fixed product
    Given DSP: make sure user is in landing page
   	And DSP: Turn off WOLR view if enabled
    When DSP:Add Opportunity in DSP
    # AND DSP:take the test data from DB Query/XML/XLSX
    When DSP:Add Customer to the dsp Opty
    Then DSP:Add Sites to the dsp Opty
    #Then VHOS:Check Opty details in VHOS - Customers, Sites
    #Then VHOS:Navigate to quote page and check whether the user is getting the below pop up message with YES and NO Button
    #Then SIEBEL:Opportunity status validation in Siebel 
    #Then VHOS:OLD oppty cancelled in VHOS and NEW opty got created in VHOS
    Then DSP:View Credit is automatically approved
    Then VHOS:Login to VHOS 
    Then VHOS:Authenticate Opportunity in VHOS
    Then DSP:Select a deal with Fixed product
    Then DSP:Generate Contract in DSP
    Then DSP:Ensure the contract is generated
   # Then VHOS:Validate Deal options in VHOS 
    Then DSP:Send generated contract to customer email
    #Then close the deal

   
@Aggregatelessthan50 @TC_004_NewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate new Enrollment for a Aggregate customer with usage < 50Kwh with Index product
    Given DSP: make sure user is in landing page
   	And DSP: Turn off WOLR view if enabled
    When DSP:Add New Opportunity in DSP with Aggregate customer
   # AND DSP:take the test data from DB Query/XML/XLSX
    When DSP:Add Aggregate Customers to the new Opty
    Then DSP:Add Sites to both Aggregate customers in new Opty
    Then DSP:View Credit is approved automatically
    Then VHOS:Login to VHOS as Sales Representative
    Then VHOS:Validate Opportunity in VHOS
    Then DSP:Price a deal with Fixed product in DSP
    Then DSP:Contract is Generated in DSP
    Then DSP:Confirm contract is generated
    Then DSP:Send Generated contract to customer email
    #Then close the deal