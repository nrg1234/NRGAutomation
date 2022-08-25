@Enrollment 
Feature: Pricing Link permission validation for different OAM users 

@Enrollment@BrokerPermissions
Scenario: Validate Pricing Link permission validation for different OAM users 
	Given Internal Super User successfully logged into OAM 
	When User selects Third party from OAM 
	Then Pricing link should appear
	When User is selecting Third party from OAM
     Then Pricing link should not appear
     When  selecting Third party from OAM
     Then Pricing link must not appear
     When  Choose Third party from OAM
     Then Pricing link shouldn't appear
     Given New Super User successfully logged into OAM
     When selects Third party from OAM 
	Then Pricing link should be appeared
	#    Given Third Party Admin User successfully logged into OAM
	#    When User selects Third party from OAM
	#    Then Pricing link should appear
	#    Given Internal Super User without pricing access successfully logged into OAM
	#    When User selects Third party from OAM
	#    Then Pricing link should not appear
	#    Given Customer admin successfully logged into OAM
	#    When User selects Third party from OAM
	#    Then Pricing link should not appear 
	#    Given Customer full access successfully logged into OAM
	#    When User selects Third party from OAM
	#    Then Pricing link should not appear
	#    Given Customer Read only User successfully logged into OAM
	#    When User selects Third party from OAM
	#    Then Pricing link should not appear
	
