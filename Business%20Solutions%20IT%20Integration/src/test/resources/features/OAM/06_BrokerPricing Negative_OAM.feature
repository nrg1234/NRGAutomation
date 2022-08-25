@Enrollment 
Feature: Negative validations for Broker Enrollment < 50Kwh from OAM using Sitelist

@Enrollment@MultipleTDSPSiteandNon-ERCOTsiteadditionisnotallowedforBrokerEnrollment<50KwhfromOAM_Sitelist 
Scenario: Validate Multiple TDSP Site and Non-ERCOT site addition is not allowed for Broker Enrollment < 50Kwh from OAM using Sitelist 
	Given Broker successfully logged into OAM 
	When User select Aggregator Third Party from drop down 
	Then make sure user navigates to Enrollment Page 
	Given Add New Opportunity in OAM 
	When Add Customer to the new Opty 
	Then Add Sites to the new Opty 
	Given User access the same opportunity from DSP  
	When user add Non-ERCOT Site to this opportunity 
	Then validate Non-ERCOT Site addition is not allowed for this opportunity 
	
@Enrollment@AggregateCustomeradditionisnotallowedBrokerEnrollment<50KwhfromOAM_Sitelist 
Scenario: Validate Aggregate Customer addition is not allowed Broker Enrollment < 50Kwh from OAM using Sitelist
	Given Broker successfully logged into OAM 
	When User choose Aggregator Third Party from drop down 
	Then  user navigates to Enrollment Page 
	Given Adding New Opportunity in OAM 
	When Add Aggregate Customer to the new Opty 
	Then Add Aggregate Sites to the new Opty 
	Then Send Email to Customer
	#Then Validate Aggregations quotes have a peak demand of >50kw
@Enrollment@NegativevalidationforMVP>50KwhfromOAM 
Scenario: Validate Negative validations for MVP > 50Kwh from OAM  

	Given Broker successfully logged into OAM 
	When User select Aggregator Third Party from drop down 
	Then make sure user navigates to Enrollment Page 
	Given Add New Opportunity in OAM 
	When Add Customer to the new Opty 
 Then DSP: Add greater than fifty Sites to customers in new Opty oam
 When SIEBEL: Login to Siebel as BA
    Then SIEBEL: Approves Credit
   Then DSP:Pricing section oam
    Then DSP: Navigate to Contract and billing oam
When VHOS: Login to VHOS as Sales Person 
 Then VHOS:Validate MVP oam
 	When SIEBEL: Login to Siebel as BA 
	When SIEBEL: Validate MVPCRR Siebel as BA 