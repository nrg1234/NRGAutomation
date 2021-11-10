@Enrollment
Feature: WOLR Won and Lost Report

 @TC_012_WOLR
  Scenario: Validate WOLR Won Report Generation
    Given Sales person created an oppurtunity in DSP
    Then make sure he/she access DSP next day
    Then make sure WOLR view is turned on
    Given Opportunity displayed WON in WOLR column
    Then Fill out the WON report
    Then Generate the WON Report

  @TC_013_WOLR 
  Scenario: Validate WOLR Lost Report Generation
    Given Sales person created an oppurtunity in DSP
    Then make sure he/she access DSP next day
    Then make sure WOLR view is turned on
    Given Oppurtunity displayed Lost in WOLR column
    Then Fill out the Lost report
    Then Generate the Lost Report
