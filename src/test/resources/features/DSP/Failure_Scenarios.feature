Feature: First negative scenario with usage > 50Kwh using Billcopy
@Enrollment@Ratecodeandvoltage_BillCopy
Scenario: Validate First Negative testcase with usage > 50Kwh 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the new Opty Billcopy 
	When VHOS: Login to VHOS as Sales Person 
    When VHOS: Verify whether site is present is Vhos DB and Verify rate code and voltage in Vhos	
#   When VHOS: Verify rate code and voltage in Vhos


	