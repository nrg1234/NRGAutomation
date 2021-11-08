@Enrollment
Feature: Pricing Link permission validation for different OAM users

  @TC_009_Pricing
  Scenario: Validate Pricing Link permission validation for different OAM users
    Given Internal Super User successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should appear 
    Given Third Party Admin User successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should appear
    Given Internal Super User without pricing access successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should not appear
    Given Customer admin successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should not appear 
    Given Customer full access successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should not appear
    Given Customer Read only User successfully logged into OAM
    When User selects Third party from OAM
    Then Pricing link should not appear

