#@Enrollment 
Feature: New Enrollment with usage > 50Kwh 
@Enrollment@AddBrokerValidation
	Scenario: 
	Validate Banner for Matrix price deal greater than 50kw with Broker/Third Party
	Given DSP: make sure user is in landing page
	And DSP: Clicks on All Opportunities 
	Then DSP: Add third party which is not set up for matrix pricing in Siebel
        Then DSP: Add third party which is set up for matrix pricing in Siebel 

@Enrollment@NewEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct_DOAApproval
Scenario: 
Validate new Enrollment for a single customer with usage > 50Kwh with Fixed product DOA Approval
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity DOA
        And DSP: Add customer and sites from the input XML DOA
	When DSP: Add Sites to the new Opty DOA
	When SIEBEL: Login to Siebel as BA 
		Then SIEBEL: Approves Credit  
		And DSP: price a deal with Fixed product 
	Then DSP: Generate Contract in DSP DOA