#@Enrollment 
Feature: Renew Enrollment with usage > 50Kwh using Sitelist

@Enrollment@RenewalEnrollmentforasinglecustomerwithusage>50KwhwithFixedproduct_Sitelist_CRR_CMA
Scenario: Validate Renewal Enrollment for a single customer with usage > 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer
	Then DSP:Select Renew option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Renewal Customer 
	And DSP: price a deal with Meterfee and VolRecs 
Then DSP: Generate Contract with Meterfee and Vol Recs
	Then DSP: Assure the Renewal contract is generated 
		Then DSP:  Validate CRR in Dealoption 
		Then VHOS: Validate MeterFee and Vol Recs in VHOS
	
#	Then DSP: Make sure the contract with Meter fee and Vol Recs is generated
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS: check Opty in VHOS
#	Then VHOS: Validate MeterFee and Vol Recs in VHOS
#	When SIEBEL: Login to Siebel again as BA
#	Then SIEBEL:Validate Meterfee and Recs in Siebel
#	And DSP: price a deal with Fixed product 
#	Then DSP: Generate Contract in DSP 
	
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	When SIEBEL: Login to Siebel again as BA 
#	Then SIEBEL:Closing Contract in Siebel
	
@Enrollment@RenewalEnrollmentforaAggregatecustomerwithusage>50KwhwithFixedproduct_Sitelist
Scenario: Validate Renewal Enrollment for a Aggregate customer with usage > 50Kwh using Sitelist 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity
	#Then SIEBEL:Login to Siebel as BA and Picking up Aggregate Renewal Customer
	Then DSP:Pick Renew option for the active contracts found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve credit for Aggregate Customer 
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP:Generate Contract for Renewal Aggregate Customer in DSP 
	Then DSP: Assure the Renewal Aggregate contract is generated 
#	And DSP: Send generated Aggregate contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
	
@Enrollment@RefreshEnrollmentafterdeletingSiteamendmentwithusage>50KwhwithFixedproduct_Sitelist 
Scenario: Validate Refresh Enrollment after deleting Site amendment with usage > 50Kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer 
	Then DSP:Selects Renew Option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Approve Credit and Upload amendment for Delete Sites in Siebel 
	#Then DSP: validate sites in DSP after refresh
	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Verifying Opty id in VHOS 
	And DSP: price a deal with Fixed product   
	Then DSP: Generate Contract in DSP for Amendment delete Opportunity 
	Then DSP: Assure the contract is generated for Amendment delete Opportunity  
#	And  DSP: Send generated contract to customer email 
	#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel
	
@Enrollment@RefreshEnrollmentafteraddingSiteamendmentwithusage>50KwhwithFixedproduct_Sitelist 
Scenario: Validate Refresh Enrollment after adding Site amendment with usage > 50Kwh using Sitelist 

	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	#Then SIEBEL: Login to Siebel as BA and Picking up the Renewal Customer 
	Then DSP:Choose Renew Option for the active contract found 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL:Approve Credit and Upload amendment for Add Sites in Siebel 
	#Then DSP: validate sites in DSP after refresh
#	When VHOS: Login to VHOS as Sales Person 
#	Then VHOS: Validate Opty id in VHOS 
	And DSP: price a deal with Fixed product  
	Then DSP: Generate Contract in DSP for Amendment Add Opportunity 
	Then DSP: Assure the contract is generated for Amendment Add Opportunity  
#	And  DSP: Send generated contract to customer email 
	#Then DSP: Sending to Closed
    #	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Closing Contract in Siebel

@Enrollment@RenewalPipelineSiebel_Sitelist
Scenario: Validate Renewal Enrollment from Pipeline with Siebel Customer using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on Renewal Pipeline
	 When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
      When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product 
	Then DSP: User Generates Contract in DSP
	Then DSP: Assure the contract is generated for Renewal Pipeline Opportunity 
#	And DSP: Send generated contract to customer email 
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel
		
@Enrollment@RenewalPipelineSeibelothersource_Sitelist
Scenario: Validate Renewal Enrollment from Pipeline with IEnergy Customer using Sitelist
	Given DSP: make sure user is in landing page
	And DSP: Clicks on All Opportunities 
	And DSP: Clicks on Renewal Pipeline and Selects Other Source customer
	 When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
        When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate Opty in VHOS 
	And DSP: price a deal with Fixed product for other source 
	Then DSP: Generate Contract for Renewal Othersource Opportunity in DSP
	Then DSP: Assure the contract is generated for Renewal Pipeline Other source 
#	And DSP: Send generated contract to customer email 
	#Then DSP:Upload the Contract document in DSP  
	#    When DSP: Send to Closed
	#    When SIEBEL: Login to Siebel as BA
	#    Then SIEBEL:Modifying Contract Status in Siebel