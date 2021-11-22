@Enrollment
Feature: Renew Enrollment with usage > 50Kwh

  @RenewalSingleEnrollment@TC_005_RenewEnrollment_SingleCustomer_FixedProduct
  Scenario: Validate Renewal Enrollment for a single customer with usage > 50Kwh with Fixed product
     #AND  DSP:take the test data from DB Query/XML/XLSX
    Given DSP: make sure user is in landing page
   	And DSP: Turn off WOLR view if enabled
    When DSP:Add New Opportunity in DSP
    Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer
    Then DSP:Select Renew option for the active contract found
    Then DSP:View Credit
    Then SIEBEL:Login to Siebel as BA
    Then SIEBEL:Approves Credit
    Then VHOS:Login to VHOS as Sales Person
    Then VHOS:Validate Opty in VHOS
    Then DSP:price a deal with Fixed Product in DSP   
    Then DSP:select Bundling Options as Ancillary and Losses
    Then DSP:generate contract in DSP
    Then DSP:Make sure the contract is generated
    Then DSP:Send generated contract to customer email
    #Then close the deal

      @AggregateRenewalEnrollment@TC_006_RenewEnrollment_AggregateCustomer_IndexProduct
  Scenario: Validate Renewal Enrollment for a Aggregate customer with usage > 50Kwh with Index product
    # AND  DSP: take the test data from DB Query/XML/XLSX
    Given DSP: make sure user is in landing page
    And DSP: Turn off WOLR view if enabled
    When DSP: Add New Opportunity in DSP
    Then SIEBEL:Login to Siebel as BA and Picking up Aggregate Renewal Customer
    Then DSP:Select Renew option for the active contracts found
    Then DSP:View Credit in dsp
    Then SIEBEL:Login to Siebel as Analyst
    Then SIEBEL:Sanction Credit
    Then VHOS:Login to VHOS as Sales rep
    Then VHOS:Verify Opty in VHOS
    Then DSP:price a deal with Index product in DSP
    Then DSP:selecting Bundling Options as  Ancillary and Losses
    Then DSP:select Vol Recs and Meter Fee 
    Then DSP:Initiate Contract in DSP
    Then DSP:Confirm the contract is generated
    Then DSP:dispatch generated contract to customer mail
    #Then close the deal

  @TC_016_Refresh
  Scenario: Validate Refresh Enrollment after adding Site amendment with usage > 50Kwh with Index product
    Given DSP:Sales person successfully logged into DSP
  #  AND DSP: take the test data from DB Query/XML/XLSX
    Then DSP:make sure he/she is in landing page
    Then DSP:Turn off WOLR view if enabled
    Given DSP:Add New Opportunity in DSP
    When DSP:Add Customer to the new Opty
    Then DSP:Add Sites to the new Opty
    Then SIEBEL:Login to Siebel as BA
    Given SIEBEL:upload amendment for site addition
    Then DSP:validate sites in DSP after refresh
    Then DSP:View Credit in DSP
    Then SIEBEL:Login to Siebel as BA
    Then SIEBEL:Approves Credit
    Then VHOS:Login to VHOS as Sales Person
    Then VHOS:Validate Opty in VHOS
    Then DSP:price a deal with Fixed Product in DSP
    Then DSP:select Bundling Options as Ancillary and Losses
    Then DSP:Generate Contract in DSP
    Then DSP:Make sure the contract is generated
    Then DSP:Send generated contract to customer email
    #Then close the deal

  @TC_017_Refresh
  Scenario: Validate Refresh Enrollment after removing Site amendment with usage > 50Kwh with Fixed product
    Given DSP:Sales person successfully logged into DSP
    #AND  DSP: take the test data from DB Query/XML/XLSX
    Then DSP:make sure he/she in landing page
    Then DSP:Turn off WOLR view
    Given DSP:Add New Opportunity in DSP
    When DSP:Add Customers to the new Opty
    Then DSP:Add Sites to both customers in new Opty
    Then SIEBEL:Login to Siebel as BA
    Given SIEBEL:upload amendment for site addition
    Then DSP:validate sites in DSP after refresh
    Then DSP:View Credit
    Then SIEBEL:Login to Siebel as BA
    Then SIEBEL:Approves Credit
    Then VHOS:Login to VHOS as Sales Person
    Then VHOS:Validate Opty in VHOS
    Then DSP:price a deal with Index product in DSP
    Then DSP:select Bundling Options as  Ancillary and Losses
    Then DSP:select Vol Recs and Meter Fee
    Then DSP:Generate Contract in DSP
    Then DSP:Make sure the contract is generated
    Then DSP:Send generated contract to customer email
    #Then close the deal