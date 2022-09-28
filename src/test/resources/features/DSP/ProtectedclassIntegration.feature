@Enrollment
Feature: New Enrollment BP View with Annual Usage <50kwh with Sales Group as C&I
  @Enrollment@ProtectedClassNewOpportunityC&IThirdPartySingleIDRSiteDSP
  Scenario: Validate new Enrollment Protected Class_New Opportunity_C&I_Third Party_Single IDR Site_DSP
    Given DSP: make sure user is in landing page
    And DSP: Clicks on All Opportunities
    When DSP: Add New Opportunity PC
    And DSP: Add customer and sites from the input XML
    Then DSP:Add Sites to the C&I Opty
    Then DSP:Converting deal to less than 50kw
    And DSP:Change to broker view and continue


  @Enrollment@DSPMatrixlessthan50kwhenrollmentCRR@Enrollment1@Enrollment5
  Scenario: Validate Matrix Enrollment with Annual Usage< 50kwh from DSP with Fixed Bundled Product( Non-Pc Product)_Curve date_ CalculatedBrokerFee_Baddebt
    Given DSP: make sure user is in landing page
    And DSP: Clicks on All Opportunities
    And DSP: Click on Enter MATRIX Deal
    Then  DSP: Add customer to the Opty
    Then DSP:  Add less than fifty Sites to customers in new Opty
    Then DSP: Navigate to less than Pricing section oam
    When SIEBEL: Login to Siebel as BA
    When SIEBEL: Validate MVPCRR Siebel as BA 
#    When SIEBEL: Check pc flag in seibel
#    Then DSP DB:Validate PCFlag in DSP DB
#    Then VHOS DB:Validate PCFlag in VHOS DB

@ProtectedClassNewOpportunityC&IThirdPartySingleIDRSiteOAM
  Scenario: Validate Matrix Enrollment from OAM with Annual Usage>50kwh and Sales Group as C&I
    Given Broker successfully logged into OAM
    When User select Aggregator oam Third Party from drop down
    Then make sure user navigates to Enrollment Page
    Given Add New Opportunity in OAM matrix
    When Add Customer to the new Opty
    Then DSP:  Add Sites to customers in new Opty oam
    When SIEBEL: Login to Siebel as BA
    Then SIEBEL: Approve Credit for Single Customer
    Then DSP: Navigate to Pricing section oam
    Then DSP: Navigate to Contract and billing oam
    When SIEBEL: Login to Siebel as BA
    When SIEBEL: Check pc flag in seibel
    Then DSP DB:Validate PCFlag in DSP DB
    Then VHOS DB:Validate PCFlag in VHOS DB
#    When DSP: Send to Closed
#	When SIEBEL: Login to Siebel as BA
#	Then SIEBEL:Modifying Contract Status in Siebel