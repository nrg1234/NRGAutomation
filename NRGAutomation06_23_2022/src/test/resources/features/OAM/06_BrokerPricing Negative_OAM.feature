#@Enrollment 
Feature: Negative validations for Broker Enrollment < 50Kwh from OAM 

@Enrollment@MultipleTDSPSiteandNon-ERCOTsiteadditionisnotallowedforBrokerEnrollment<50KwhfromOAM 
Scenario: 
Validate Multiple TDSP Site and Non-ERCOT site addition is not allowed for Broker Enrollment < 50Kwh from OAM 
	Given Broker successfully logged into OAM 
	When User select Aggregator Third Party from drop down 
	Then make sure user navigates to Enrollment Page 
	Given Add New Opportunity in OAM 
	When Add Customer to the new Opty 
	Then Add Sites to the new Opty 
	Given User access the same oppurtunity from DSP  
	When user add Non-ERCOT Site to this oppurtunity 
	Then validate Non-ERCOT Site addition is not allowed for this oppurtunity 
	
@Enrollment@AggregateCustomeradditionisnotallowedBrokerEnrollment<50KwhfromOAM 
Scenario: 
Validate Aggregate Customer addition is not allowed Broker Enrollment < 50Kwh from OAM 
	Given Broker successfully logged into OAM 
	When User choose Aggregator Third Party from drop down 
	Then  user navigates to Enrollment Page 
	Given Adding New Opportunity in OAM 
	When Add Aggregate Customer to the new Opty 
	Then Add Aggregate Sites to the new Opty 
	Then Send Email to Customer
	#Then Validate Aggregations quotes have a peak demand of >50kw

