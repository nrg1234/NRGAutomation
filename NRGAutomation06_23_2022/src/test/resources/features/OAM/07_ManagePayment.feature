Feature: Manage Payment using ACH

@Manage@ACH
Scenario: 
Manage Payment using ACH
    Given Tester logged successfully into OAM
	And User select Customer from drop down
	Then Add ACH account Validation
	
	
@ManageCC@CreditCard
Scenario: 
Manage Payment using CC
    Given Tester logged successfully into OAM
    Then User select Credit Card Customer from drop down