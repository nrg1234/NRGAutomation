#@Enrollment  
Feature: New Enrollment with usage > 50Kwh using Sitelist
@Enrollment@NewEnrollment_SingleCustomer_Meterfee_VolRecs_SitelistMVPandCRR_CMA@Enrollment1
Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with Meterfee and Vol Recs using Sitelist
	
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer   
	And DSP: price a deal with Meterfee and VolRecs 
	Then DSP: Generate Contract with Meterfee and Vol Recs 
	Then DSP: Make sure the contract with Meter fee and Vol Recs is generated
	Then DSP:  Validate CRR in Dealoption 
#	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate MeterFee and Vol Recs in VHOS
	When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 
#	When SIEBEL: Login to Siebel again as BA
#	Then SIEBEL:Validate Meterfee and Recs in Siebel
#	And DSP: Send generated contract to customer email 
#	Then DSP: Sending to Closed
#	  When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Modifying Contract Status in Siebel

@Enrollment@Matrixbrokernegativevalidations_Sitelist
Scenario: Validate the Matrix Negative Validations using Sitelist
#	Given DSP: make sure user is in landing page
#	And DSP: Clicks on All Opportunities
#	And DSP: Click on ENTER MATRIX PRICE DEAL
#	Then  DSP: Add customer to the Opty
#	Then DSP:  Add Sites to customers
#	Then DSP:  logout dsp
#       Given DSP: make sure user is in landing page
#	And DSP: Clicks on All Opportunities multiple
#	And DSP: Click on ENTER MATRIX PRICE DEAL
#	Then  DSP: Add customer to the Opty
#	Then DSP:  Add Sites1 to customers
#	Then DSP:  logout dsp
#       Given DSP: make sure user is in landing page
#	And DSP: Clicks on All Opportunities multiple
#	And DSP: Click on ENTER MATRIX PRICE DEAL
#	Then  DSP: Add customer to the Opty
#	Then DSP:  Add Sites2 to customers
#	Then DSP:  logout dsp
#       Given DSP: make sure user is in landing page
#	And DSP: Clicks on All Opportunities multiple
#	And DSP: Click on ENTER MATRIX PRICE DEAL
#	Then  DSP: Add customer to the Opty1
#	Then DSP:  Add Sites3 to customers
#       Then DSP:  logout dsp
	Given DSP: make sure user is in landing page
	And DSP: Clicks on All Opportunities multiple
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty1
	Then DSP: Add four ESID to the Opportunity


@Enrollment@BrokerPricingUINormalDeal_Sitelist_Mvp_CRRCMA
Scenario: Validate new Enrollment for a single customer for usage > 50Kwh with Broker Pricing UI Normal Deal using Sitelist
	Given DSP: make sure user is in landing page
	And DSP: Clicks on All Opportunities
	When DSP: Add New Broker Opportunity
	And DSP: Add customer and sites from the input XML
	When DSP: Add Sites to the new Opty
	When SIEBEL: Login to Siebel as BA
	Then SIEBEL: Approves Credit
	And DSP:Change to broker view
	Then DSP:Continue to Pricing
	Then DSP:  Validate CRR in Dealoption 
	Then VHOS: Validate MeterFee and Vol Recs in VHOS
		When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 
#	When VHOS: Login to VHOS as Sales Person
#	Then VHOS: Validate MeterFee and Vol Recs in VHOS
#	When SIEBEL: Login to Siebel again as BA
#	Then SIEBEL:Validate Meterfee and Recs in Siebel

@Enrollment @HomePageFunctionality
Scenario: Validate Home Page Functionality in DSP
   Given DSP: make sure user is in landing page 
   And DSP: Clicks on All Opportunities 
   Then DSP: Click on Dropdown Filter Button
   Then DSP: Click on Table Options Filter Button
   Then DSP: Click on Customer Name Filter
   Then DSP: Click on Sales Channel Filter     
   Then DSP: Click on Market Filter
   Then DSP: Click on Opportunity Type Filter
   Then DSP: Click on Deal Type Filter
   Then DSP: Click on WOLR Filter
   Then DSP: Click on Third Party Filter
   Then DSP: Click on End Date Filter
   Then DSP: Click on Broker Filter
   
 
@NewEnrollment_SingleCustomer_Meterfee_VolRecs_SitelistMVPandCMA>20000
Scenario: Validate new Enrollment for a single customer with usage > 20000Mwh with Meterfee and Vol Recs using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add 20000MwH Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
        And DSP: Validate MVP   
	And DSP: price a deal with Meterfee and VolRecs 
	Then DSP: Generate Contract with Meterfee and Vol Recs 
	Then DSP: Make sure the contract with Meter fee and Vol Recs is generated
	Then DSP:  Validate CRR in Dealoption             
		Then VHOS: Validate MeterFee and Vol Recs in VHOS
			When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 
		

@NewEnrollment_SingleCustomer_Meterfee_VolRecs_SitelistMVPandCRR_CMA_B&I
Scenario: Validate new Enrollment for a single customer with usage > 50Kwh with B&I using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Add New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer   
	When VHOS: Login to VHOS as Sales Person 
        Then VHOS: Create B&I deal in VHOS
        Then DSP: Generate B&I Contract
	Then DSP:  Validate CRR in Dealoption 
#	When VHOS: Login to VHOS as Sales Person 
	Then VHOS: Validate MeterFee and Vol Recs in VHOS		
		When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 