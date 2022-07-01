#@Enrollment 
Feature: WOLR Won and Lost Report 

@Enrollment@WOLRWonReportGeneration 
Scenario: Validate WOLR Won Report Generation 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Make New Opportunity 
	And DSP: Add customer and sites from the input XML 
	When DSP: Update Sites to the new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approves Credit 
	    When VHOS: Login to VHOS as Sales Person
	    Then VHOS: Validate Opty in VHOS
	And DSP: price a deal with Fixed product 
	Then DSP: Generatewon Contract in DSP 
	Then DSP: Make sure the contract is generated 
	And DSP: Send generated contract to customer email 
	Then DSP: Sending to Closed
	#When DSP: Send to Closed 
	When SIEBEL: Login to Siebel again as BA 
	Then SIEBEL:Modifying Contract Status in Siebel 
	Then user access DSP next day 
	#    Given Opportunity displayed WON in WOLR column
	#    Then Fill out the WON report
	#    Then Generate the WON Report
	
@Enrollment@WOLRLostReportGeneration 
Scenario: 
Validate WOLR Lost Report Generation 
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	When DSP: Adding New Opportunity 
	Then DSP:Add customer to opportunity 
	#When DSP: Add Customer to the new Opty
	When DSP: Add Sites to the new Opty 
	Then make sure user access DSP next day 
	#    Given Oppurtunity displayed Lost in WOLR column
	#    Then Fill out the Lost report
	#    Then Generate the Lost Report
