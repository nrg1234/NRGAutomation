@Enrollment
Feature: New Enrollment with usage > 50Kwh
#This Feature is for new enrollment customers for Usage greater than 50KWH
  @EndToEnd @TC_001_NewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product
   
   Given DSP: make sure user is in landing page
    And DSP: Turn off WOLR view if enabled
    When DSP: Add New Opportunity
   	And DSP: Add customer and sites from the input XML   
   	#When DSP: Add Customer to the new Opty
    When DSP: Add Sites to the new Opty
    Then DSP: View Credit
    When SIEBEL: Login to Siebel as BA
    Then SIEBEL: Approves Credit
    When VHOS: Login to VHOS as Sales Person
    Then VHOS: Validate Opty in VHOS
    And DSP: price a deal with Fixed product
    Then DSP: Generate Contract in DSP
    Then DSP: Make sure the contract is generated
    And DSP: Send generated contract to customer email

  @Aggregatecustomer @TC_002_NewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate new Enrollment for a aggregate customer with usage > 50Kwh with Index product
    Given DSP: make sure user is in landing page
    And  DSP: Turn off WOLR view if enabled
    When DSP:Building an Opy
    And DSP:Taking the test data from XML
    When DSP: Adding Customer to the new Opty from XLSX
#   Then SIEBEL: Loginto  Siebel as BA
#   Then SIEBEL: Validating Customer is successfully created
    Then DSP: Adding Sites to the new Opty
#   Then SIEBEL: Loginto Siebel as BA
#   Then SIEBEL:Validate Customer and Sites are correctly mapped to oppurtunities 
    Then DSP: Viewing Credit in Dsp
    Then SIEBEL:Signin with valid credentials in Siebel
    Then SIEBEL:Accepting Credit in Siebel
    When VHOS: VHOS as Sales Person
    Then VHOS: Opty id in VHOS
   #Then VHOS:Login to VHOS as Sales Personal
   #Then VHOS:Validate quote pricing VHOS matches in DSP 
    Then DSP:pricing a deal with Index product in DSP
    Then DSP:Generating Contract details in DSP
    Then DSP:Making sure the contract is generated
    Then DSP:Sending generated contract to customer email id
   # Then close the deal
    #Then SIEBEL:Login to Siebel as BAnalyst
    #Then SIEBEL:Validate losses,prices,voluntary recs,meterfee and deal closed status in seibel 
    #Then VHOS:Login to VHOS as Sales Personal
    #Then VHOS:Validate losses,prices,voluntary recs,meterfee and deal closed status in VHOS
   

  @TC_014_StaggeredSite @Staggeredgreaterthan50
  Scenario: Validate StaggeredSite Enrollment for a single customer with usage > 50Kwh with Fixed product
 Given DSP: make sure user is in landing page
    And  DSP: Turn off WOLR view if enabled
   
   When DSP:Creating New Opportunity in DSP
 # AND DSP:take the test data from DB Query/XML/XLSX
    Then DSP:Add new Customer to the new Opty
    Then DSP:Add Sites to the new Oppty
    Then DSP: Edit Delayed Start Date for the Sites
    Then DSP: Viewing Credit
    Then SEIBEL: Login to Siebel as BA
    Then SEIBEL: Approves Credit
    Then VHOS:Login to VHOS as Sales Admin
    Then VHOS:Validate Opty in VHOS
    Then DSP:price a deal with Fixed Plan 
    #Then DSP:select Bundling Options as Ancillary and Losses
   Then DSP: Create Contract in DSP for single customer
    Then DSP: Confirm the contract is generated for single customer
   Then DSP:Send confirmed generated contract to customer emailid 
    Then DSP:close the deal

  @TC_015_StaggeredSite@AggregateStaggeredgreaterthan50
  Scenario: Validate StaggeredSite Enrollment for a Aggregate customer with usage > 50Kwh with Index product
    Given DSP: make sure user is in landing page
    And  DSP: Turn off WOLR view if enabled
    #AND  DSP: take the test data from DB Query/XML/XLS
    When DSP: Build New Opportunity in DSP
    Then  DSP: Add Aggregate customers to the new Opty
    Then DSP:  Add Sites to both Aggregate customers in new Opty
    Then DSP: Edit Delay Start Date for the Sites
    Then DSP: View Credit automatically
     Then SEIBEL:Loging to Siebel as BAnalyst
    Then SEIBEL: Sanctioning Credit
     Then VHOS: Login to VHOS as aggregate Sales Person
    Then VHOS: Opty id validation in VHOS
    Then DSP: price a deal with Index product in DSP
   # Then DSP: select Bundling Options as  Ancillary and Losses for aggregate customer
    Then DSP: select Vol Recs and Meter Fee
    Then DSP: Generate Contract in DSP for aggregate customer
     Then DSP: Confirm the contract is generated
    Then DSP:Send  confirm generated contract to customer email
   #Then DSP:close the deal

  @TC_018_Blank
  Scenario: Validate Blank LOA details entered from Email is available in the DSP Opportunity
    Given DSP: Sales person successfully logged into DSP
    #AND  DSP: take the test data from DB Query/XML/XLSX
    Then  DSP: make sure he/she is in landing page
    Then  DSP: Turn off WOLR view if enabled
    Given DSP: Select Send Blank LOA from Opportunity Drop down
    When  DSP: User receives an email with Blank LOA
    Then  DSP: Enter all required details and complete Docusign
    Then  DSP: Search for the same opportunity in DSP
    Then  DSP: validate the customer and sites entered in LOA is available in DSP
    Then  DSP: Download the LOA in DSP




