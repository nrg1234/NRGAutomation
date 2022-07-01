#@Enrollment 
Feature: New Enrollment with usage > 50Kwh 
@Enrollment @NewEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct 
Scenario: 
Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit 
		And DSP: price_a_deal_Meterfee_VolRecs 
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
	
@Enrollment @NewEnrollmentforaggregatecustomerwithusage>50KwhwithFixedproduct 
Scenario: Validate new Enrollment for a aggregate customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	When DSP: Adding Customer to the new Opty from XLSX 
	Then DSP: Adding Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Accepting Credit in Siebel 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP:Generating Contract details in DSP 
	Then DSP: Ensuring the contract is generated
#	And DSP: Send generated Aggregate contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel

	
	
@Enrollment@StaggeredSiteEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct 
Scenario: Validate StaggeredSite Enrollment for a single customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Site to the new Opty 
	Then DSP: Edit Delayed Start Date for the Sites 
	When SIEBEL: Login to Siebel as BA 
		Then SIEBEL: Approves Credit  
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP: Generate Contract in DSP 
	Then DSP: Makes sure the contract is generated 
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#    Then SIEBEL:Modifying Contract Status in Siebel
##	
	
@Enrollment@StaggeredSiteEnrollmentforaAggregatecustomerwithusage>50KwhwithFixedproduct
Scenario: Validate StaggeredSite Enrollment for a Aggregate customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then  DSP: Add Aggregate customers to the new Opty 
	Then DSP:  Add Sites to both Aggregate customers in new Opty 
	Then DSP: Edit Delayed Start Date for the Sites  
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Accepting Credit in Siebel 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 	
	Then DSP:Generating Contract details in DSP 
	Then DSP: Ensuringg the contract is generated 
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
	
	
@Enrollment@Matrixpricedealgreaterthan50kw 
Scenario: Validate the Matrix price deal greater than 50kw 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty
	Then DSP:  Add Sites to customers in new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit 
	Then DSP: Navigate to Pricing section 
#	When VHOS: Login to VHOS as Sales Person 
#	Then DSP:pricing a deal  in DSP 
#	Then DSP:Enter the contact and Billing details
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
	
	
@Enrollment@Matrixdealmargingroupcreation
Scenario: Validate the Matrix deal margin group creation
	#Given DSP: make sure user is in Outlook landing page 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on Maintenance
	Then DSP:Enter all the Details
	Then  DSP: Click on submit button
	#Given DSP: Send Email to Stakeholders
	

@Enrollment @NewEnrollmentforasinglecustomerwithBrand>50KwhwithFixedproduct 
Scenario: Validate new Enrollment for a single customer with Reliant Brand for usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add ESID to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit and Validating Brand 
		And DSP: price_a_deal_Meterfee_VolRecs 
		Then DSP: Geenerate Contract in DSP 
		Then DSP: Maake sure the contract is generated
		Then DSP: Validate Brand in DSP
		Then VHOS0: Validate Brand in VHOS
		
@Enrollment @NewEnrollmentNonErcotOpportunity>50KwhwithFixedproduct 
Scenario: Validate new Enrollment for a single customer for Non Ercot Opportunity for usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add NonErcot Opportunity
	And DSP: Add customer and sites from the input XML 
	When DSP: Add ESIDS to the new Opty 
	Then DSP: Create Product in VHOS
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit and validate Pricing
	Then DSP: Generate NonErcot Contract in DSP
	Then DSP: Make sure the contract is generated
	Then DSP: Validate Brand in DSP
	Then VHOS1: Validate Brand in VHOS1
