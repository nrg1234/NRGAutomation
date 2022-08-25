Feature: New Enrollment with usage < 50Kwh Credit Evaluation validation

@Enrollment@CreditEvaluation
Scenario: Validate New Enrollment with usage < 50Kwh Credit Evaluation validation
	
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	Then DSP:Add Sites to the dsp Opty 
	Then DSP:Converting deal to less than 50kwh for Single Customer 
        Then DSP:Validate Credit Evaluation with DB