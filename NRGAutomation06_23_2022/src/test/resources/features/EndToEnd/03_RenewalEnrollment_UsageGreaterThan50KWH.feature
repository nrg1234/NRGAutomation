#@Enrollment 
Feature: Renew Enrollment with usage > 50Kwh 

@Enrollment@RenewalEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct
Scenario: Validate Renewal Enrollment for a single customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer
	Then DSP:Select Renew option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Accept Credit in Siebel 
	And DSP: price_a_deal_Meterfee_VolRecs 
		Then DSP: Generatee Contract in DSP 
#	Then DSP: Make sure the contract with Meter fee and Vol Recs is generated
#
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS: check Opty in VHOS
#	Then VHOS: Validate MeterFee and Vol Recs in VHOS
#	When SIEBEL: Login to Siebel again as BA
#	Then SIEBEL:Validate Meterfee and Recs in Siebel
#	And DSP: price a deal with Fixed product 
#	Then DSP: Generate Contract in DSP 
	Then DSP: Assurr the contract is generated 
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
@Enrollment@RenewalEnrollmentforaAggregatecustomerwithusage>50KwhwithFixedproduct 
Scenario: 
Validate Renewal Enrollment for a Aggregate customer with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New renewal Opportunity
	#Then SIEBEL:Login to Siebel as BA and Picking up Aggregate Renewal Customer
	Then DSP:Pick Renew option for the active contracts found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Accepting Credit in Siebel 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP:Generatingg Contract details in DSP 
	Then DSP: Assure the contract is generated  
#	And DSP: Send generated Aggregate contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
	
@Enrollment@RefreshEnrollmentafterdeletingSiteamendmentwithusage>50KwhwithFixedproduct 
Scenario: 
Validate Refresh Enrollment after deleting Site amendment with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer 
	Then DSP:Selects Renew Option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Approving Credit and delete amendment in Siebel 
	#Then DSP: validate sites in DSP after refresh
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Verifying Opty id in VHOS 
	And DSP: price a deal with Fixed product   
	Then DSP: Generatesss Contract in DSP 
	Then DSP: Assuringgg the contract is generated  
#	And  DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
@Enrollment@RefreshEnrollmentafteraddingSiteamendmentwithusage>50KwhwithFixedproduct 
Scenario: 
Validate Refresh Enrollment after adding Site amendment with usage > 50Kwh with Fixed product 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer 
	Then DSP:Choose Renew Option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Accepting Credit and create amendment in Siebel 
	#Then DSP: validate sites in DSP after refresh
#	When VHOS: Login to VHOS as Sales Person 
#	Then VHOS: Validate Opty id in VHOS 
	And DSP: price a deal with Fixed product  
	Then DSP: Generatess Contract in DSP 
	Then DSP: Assuringg the contract is generated  
#	And  DSP: Send generated contract to customer email 
	#Then DSP: Sending to Closed
    #	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel


	@Enrollment	@RenewalPipelineSiebel
Scenario: 
Validate Renewal Enrollment from Pipeline with Siebel Customer
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on Renewal Pipeline
	 When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit 

      When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP: User Generates Contract in DSP
	Then DSP: Assuringggg the contract is generated 
#	And DSP: Send generated contract to customer email 
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
		
@Enrollment	@RenewalPipelineSeibelothersource
	Scenario: 
	Validate Renewal Enrollment from Pipeline with IEnergy Customer
	Given DSP: make sure user is in landing page
	And DSP: Clicks on All Opportunities 
	And DSP: Clicks on Renewal Pipeline and Selects Other Source customer
	 When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit 
      When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product for other source 
	Then DSP: Generatesss Contract in DSP
	Then DSP: Assuringggggg the contract is generated 
#	And DSP: Send generated contract to customer email 
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel