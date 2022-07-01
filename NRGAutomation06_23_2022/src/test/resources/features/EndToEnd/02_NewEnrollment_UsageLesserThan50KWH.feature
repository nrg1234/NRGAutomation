#@Enrollment 
Feature: New Enrollment with usage < 50Kwh 

@Enrollment@NewEnrollmentforasinglecustomerwithusage<50KwhwithFixedproduct
Scenario: 
Validate new Enrollment for a single customer with usage < 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	Then DSP:Add Sites to the dsp Opty 
	Then DSP:Converting deal to less than 50kw 
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS:Authenticate Opportunity in VHOS
	Then DSP:Select a deal with Fixed product 
	Then DSP: Create Contract in Dsp 
	Then DSP: Ensure the contract is generated
#    Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
	
	
	
@Enrollment@NewEnrollmentforaAggregatecustomerwithusage<50KwhwithFixedproduct 
Scenario: 
Validate new Enrollment for a Aggregate customer with usage < 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then  DSP: Add Aggregate customers to the new Opty 
	Then DSP:Add Sites to both Aggregate customers in new Opty 
	Then DSP:Convertingg deal to less than 50kw 
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS:Authenticate Opportunity in VHOS
#	Then DSP:Select a deal with Fixed product
#	Then DSP:Contract is Generated in DSP
#	Then DSP: Ensure the contract is generated
#	Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
