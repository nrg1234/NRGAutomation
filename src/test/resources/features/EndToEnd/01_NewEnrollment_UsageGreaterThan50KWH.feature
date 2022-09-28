#@Enrollment 
Feature: New Enrollment with usage > 50Kwh using HUUpload, ProxySites, BillCopy, AddSitelist 
@Enrollment @NewEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct_HUUpload @Enrollment1@CICD
Scenario: Validate new Enrollment for a single customer with usage > 50Kwh using HUUpload 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the Single Customer using HUUpload
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	And DSP: price a deal with Fixed product 
	Then DSP: Generate Contract in DSP 
	Then DSP: Make sure the contract is generated
#	Then DSP: Make sure the contract with Meter fee and Vol Recs is generated
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS: Validate Opty in VHOS
##When VHOS: Login to VHOS as Sales Person
#	Then VHOS: Validate MeterFee and Vol Recs in VHOS
#	When SIEBEL: Login to Siebel again as BA
#	Then SIEBEL:Validate Meterfee and Recs in Siebel
#	Then DSP: Make sure the contract is generated 
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Modifying Contract Status in Siebel
	
@Enrollment @NewEnrollmentforaggregatecustomerwithusage>50KwhwithFixedproduct_Sitelist 
Scenario: Validate new Enrollment for a aggregate customer with usage > 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	When DSP: Adding Customer to the new Opty from XLSX 
	Then DSP: Add Sites to the Aggregate Customer
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve credit for Aggregate Customer
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP:Generate Contract for Aggregate Customer
	Then DSP: Ensure the Aggregate contract is generated
#	And DSP: Send generated Aggregate contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel

@Enrollment@StaggeredSiteEnrollmentforasinglecustomerwithusage>50KwhwithIndexproduct_ProxySites_MVP_CRR_CMA 
Scenario: Validate StaggeredSite Enrollment for a single customer with usage > 50Kwh with Proxy Sites
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Proxy Site to the Single Staggered Customer 
	Then DSP: Delay Start Date for the Single Customer Sites 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer  
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Index product  
Then DSP: Generate Contract with Meterfee and Vol Recs
	Then DSP: Make sure the contract is generated for Staggered Site Opportunity 
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	When SIEBEL: Login to Siebel again as BA 
#       Then SIEBEL:Modifying Contract Status in Siebel
##	
	
@Enrollment@StaggeredSiteEnrollmentforaAggregatecustomerwithusage>50KwhwithFixedproduct_Sitelist
Scenario: Validate StaggeredSite Enrollment for a Aggregate customer with usage > 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then  DSP: Add Aggregate customers to the new Opty 
	Then DSP:  Add Sites to both Aggregate customers in new Opty 
	Then DSP: Delay Start date for Aggregate Customer Sites  
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve credit for Aggregate Customer 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 	
	Then DSP:Generate Contract for Aggregate Customer 
	Then DSP: Ensure the contract is generated for Staggered Sites 
#	And DSP: Send generated Aggregate contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
    
 	
@BlankLOAdetailsenteredfromEmailisavailableintheDSPOpportunity 
Scenario: Validate Blank LOA details entered from Email is available in the DSP Opportunity 
	Given DSP: make sure user is in landing page 
	Given DSP: Select Send Blank LOA from Opportunity Drop down 
	When  DSP: User receives an email with Blank LOA 
	Then  DSP: Enter all required details and complete Docusign 
	Then  DSP: Search for the same opportunity in DSP 
	#Then  DSP: validate the customer and sites entered in LOA is available in DSP
	Then  DSP: Download the LOA in DSP 
	
	
@Enrollment@Matrixpricedealgreaterthan50kw_Sitelist_CRR @Enrollment1@Enrollment5
Scenario: Validate the Matrix price deal greater than 50kw using Sitelist with Fixed Bundled Product( Non-Pc Product)_Curve date_ CalculatedBrokerFee_Baddebt
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty
	Then DSP:  Add Sites to customers in new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	Then DSP: Navigate to Pricing section 
	When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 
#	When VHOS: Login to VHOS as Sales Person 
#	Then DSP:pricing a deal  in DSP 
#	Then DSP:Enter the contact and Billing details
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
	
	
@Enrollment@Matrixdealmargingroupcreation @Enrollment5
Scenario: Validate the Matrix deal margin group creation
	#Given DSP: make sure user is in Outlook landing page 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on Maintenance
	Then DSP:Enter all the Details
	Then  DSP: Click on submit button
	#Given DSP: Send Email to Stakeholders
	

@Enrollment @NewEnrollmentforasinglecustomerwithBrand>50KwhwithFixedproduct_Billcopy 
Scenario: Validate new Enrollment for a single customer with Reliant Brand for usage > 50Kwh using Billcopy 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity Reliant
	And DSP: Add customer and sites from the input XML 
	When DSP: Add ESID to the new Opty using Billcopy 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit and Validate Reliant Brand 
		And DSP: price a deal with Fixed product 
		Then DSP: Generate Contract in DSP for Reliant Brand 
		Then DSP: Make sure the contract is generated for Reliant Brand
		Then DSP: Validate Brand in DSP
		Then VHOS0: Validate Brand in VHOS
		
		
@Enrollment @NewEnrollmentNonErcotOpportunity>50KwhwithFixedproduct_Sitelist 
Scenario: Validate new Enrollment for a single customer for Non Ercot Opportunity for usage > 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add NonErcot Opportunity
	And DSP: Add customer and sites from the input XML 
	When DSP: Add ESIDS to the new Opty 
	Then DSP: Create Product in VHOS
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit and validate Pricing for Non Ercot Opportunity
	Then DSP: Generate NonErcot Contract in DSP
	Then DSP: Make sure the contract is generated
	Then DSP: Validate Brand in DSP
	Then VHOS1: Validate Brand in VHOS1
	
	@Enrollment @NewEnrollmentforasinglecustomerwithBrand>50KwhwithFixedproductTC @Enrollment1
	Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with TC Template
	
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the Single Customer using HUUpload
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	And DSP: price a deal with Fixed product 
	Then DSP: Generate Contract in DSP with TC
#	Then DSP: Make sure the contract is generated
