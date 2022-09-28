Feature: Manage Payment using Both ACH and CC

@Manage@ACH @Enrollment5
Scenario: Manage Payment using ACH
    Given Tester logged successfully into OAM
	And User select Customer from drop down
	Then Add ACH account Validation
	
	
@ManageCC@CreditCard @Enrollment5
Scenario: Manage Payment using CC
    Given Tester logged successfully into OAM
    Then User select Credit Card Customer from drop down