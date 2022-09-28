#@Enrollment 
Feature: New Enrollment with usage < 50Kwh using Sitelist

@Enrollment@NewEnrollmentforasinglecustomerwithusage<50KwhwithFixedproduct_Sitelist_Mvp_CRR_CMA@Enrollment1@CICD
Scenario: Validate new Enrollment for a single customer with usage < 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	Then DSP:Add Sites to the dsp Opty 
	Then DSP:Converting deal to less than 50kwh for Single Customer 
	Then DSP:Select a deal with Fixed product validate MVP and generate contract 
	Then DSP:  Validate CRR in Dealoption 
	Then VHOS: Validate MeterFee and Vol Recs in VHOS
#		When SIEBEL: Login to Siebel as BA 
#	When SIEBEL: Validate MVPCRR Siebel as BA 
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS:Authenticate Opportunity in VHOS
#	Then DSP:Price a deal with Fixed product for <50kwh 
#	Then DSP: Generate Contract in Dsp for <50kwh 
#	Then DSP: Ensure the contract is generated
#    Then DSP DB:Validate PCFlag in DSP DB
#	Then VHOS DB:Validate PCFlag in VHOS DB
#	And DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
	
@Enrollment@NewEnrollmentforaAggregatecustomerwithusage<50KwhwithFixedproduct_Sitelist 
Scenario: Validate new Enrollment for a Aggregate customer with usage < 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	Then  DSP: Add Aggregate customers to the new Opty 
	Then DSP:Add Sites to both Aggregate customers in new Opty 
	Then DSP:Converting deal to less than 50kw for Aggregate Customer 
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
