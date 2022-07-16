#@Enrollment 
Feature: Renew Enrollment with usage < 50Kwh 

@SmokeTest@RenewalEnrollmentforasinglecustomerwithusage<50KwhwithFixedproduct
Scenario: Validate Renewal Enrollment for a single customer with usage < 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity
	Then DSP:Selecting Renew option for the active contract found
	Then DSP:Converting deal to less than 50kw 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS:Authenticate Opportunity in VHOS  
	And DSP:choose a deal with Fixed product
	Then DSP: Submitsss Contract in Dsp
	Then DSP: Ensuress the contract is generated
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
@SmokeTest@RenewalEnrollmentforaAggregatecustomerwithusage<50KwhwithFixedproduct  
Scenario: Validate Renewal Enrollment for a Aggregate customer with usage < 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity
	Then DSP:Choosing Renew option for the active contract found
	Then DSP:Converting deal to less than 50kw 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS:Authenticate Opportunity in VHOS  
	And DSP:choose a deal with Fixed product
	Then DSP: Submitting Contract in Dsp
	Then DSP: Ensureee the contract is generated
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel

@Enrollment@RenewalEnrollmentforGME<50KwhwithFixedproduct
Scenario: Validate Renewal Enrollment for a GME customer with usage < 50Kwh with Fixed product
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then DSP:Select Renew option for GME with the active contract found
	Then DSP:Converting deal to less than 50kw 
	And DSP: price a deal with Fixed product 
	Then DSP: Submitss Contract in Dsp
	Then DSP: Ensureesss the contract is generated
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email  


@SmokeTest@SendingOutlookMail
Scenario: Email trigger for Extent Reports 
	Given DSP: make sure user is in Outlook landing page 
	Given DSP: Send Email to Stakeholders
