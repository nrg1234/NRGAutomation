#@Enrollment 
Feature: Renew Enrollment with usage < 50Kwh using Sitelist

@SmokeTest@RenewalEnrollmentforasinglecustomerwithusage<50KwhwithFixedproduct_Sitelist
Scenario: Validate Renewal Enrollment for a single customer with usage < 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity
	Then DSP:Selecting Renew option for the active contract found
	Then DSP:Converting deal to less than 50kwh
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS:Authenticate Opportunity in VHOS  
	And DSP:Price a deal with Fixed product for Single Customer
	Then DSP: Generate Contract in Dsp for Renewal PC Deal with Single Customer
	Then DSP: Ensure the contract is generated for Renewal PC Deal with Single Customer
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
@SmokeTest@RenewalEnrollmentforaAggregatecustomerwithusage<50KwhwithFixedproduct_Sitelist  
Scenario: Validate Renewal Enrollment for a Aggregate customer with usage < 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity
	Then DSP:Choosing Renew option for the active contract found
	Then DSP:Converting deal to less than 50kwh 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS:Authenticate Opportunity in VHOS  
	And DSP:Price a deal with Fixed product for Aggregate Customer
	Then DSP: Generate Contract in Dsp for Renewal PC Deal with Aggregate Customer
	Then DSP: Ensure the contract is generated for Renewal PC Deal with Aggregate Customer
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel

@Enrollment@RenewalEnrollmentforGME<50KwhwithFixedproduct_Sitelist
Scenario: Validate Renewal Enrollment for a GME customer with usage < 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then DSP:Select Renew option for GME with the active contract found
	Then DSP:Converting deal to less than 50kwh  
	And DSP:Price a deal with Fixed product for Renewal GME Customer 
	Then DSP: Generate Contract in Dsp for Renewal GME Customer
	Then DSP: Ensure the contract is generated for Renewal GME Opportunity
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email  


@SmokeTest@SendingOutlookMail
Scenario: Email trigger for Extent Reports 
	Given DSP: make sure user is in Outlook landing page 
	Given DSP: Send Email to Stakeholders
