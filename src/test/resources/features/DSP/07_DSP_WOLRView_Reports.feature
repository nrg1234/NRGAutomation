@Enrollment 
Feature: WOLR Won and Lost Report using Sitelist 

@Enrollment@WOLRWonReportGeneration_Sitelist 
Scenario: Validate WOLR Won Report Generation for >50kwh usage using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Make New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Add Sites to the Won Opportunity 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	And DSP: price a deal with Fixed product 
	Then DSP: Generate Contract for Won Report Opportunity 
	Then DSP: Make sure the contract is generated 
	And DSP: Send generated contract to customer email 
	Then DSP: Sending to Closed
	#When DSP: Send to Closed 
	When SIEBEL: Login to Siebel again as BA 
	Then SIEBEL:Modifying Contract Status in Siebel 
	Then user access DSP next day 
	    Given Opportunity displayed WON in WOLR column
	    Then Fill out the WON report
	    Then Generate the WON Report
	
@Enrollment@WOLRLostReportGeneration_Sitelist 
Scenario: Validate WOLR Lost Report Generation for usage >50kwh using Sitelist
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Adding New Opportunity 
	Then DSP:Add customer to opportunity 
	When DSP: Add Sites to the new Opty 
	Then Make sure user access DSP next day and Submits Lost Report 
	#    Given Oppurtunity displayed Lost in WOLR column
	#    Then Fill out the Lost report
	#    Then Generate the Lost Report
