Feature: New Enrollment with usage > 50Kwh NewAnalyst&RenewalSpecialist

@Enrollment@NewAnalyst
Scenario: Validate new Enrollment for a single customer with usage > 50Kwh New Analyst
	
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity with Third Party
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the Single Customer using HUUpload
	When DSP: Validate EMA in header
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Validate EMA in Seibel 
	
	@Enrollment@RenewalSpecialist
Scenario: Validate Renewal Enrollment for a single customer with usage > 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity with Third Party
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer
	Then DSP:Select Renew option for the active contract found
        When DSP: Validate EMA in header
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Validate EMA in Seibel 
	