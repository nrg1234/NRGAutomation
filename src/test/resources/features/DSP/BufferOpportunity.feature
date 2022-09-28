Feature: Buffer the Opportunity for Protected Class Single<50kwh

@BufferOpportunity@ProtectedClassSingleCustomer<50kwh
Scenario: Validate Protected Class <50kwh Using Excel
	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities
#	Then DSP: Storing opportunities in array
	Then DSP: Closing and Recreating Opportunity in DSP
#	Then DSP: Sending to Closed
#	    When SIEBEL: Login to Siebel again as BA 
#	    Then SIEBEL:Modifying Contract Status in Siebel


#@BufferOpportunityXML@ProtectedClassSingleCustomer<50kwhXML
#Scenario: Validate Protected Class <50kwh using XML
#	Given DSP: make sure user is in landing page 
#	And DSP: Clicks on All Opportunities
#	Then DSP: Closing and Recreating Opportunity in DSP using XML File
##	Then DSP: Sending to Closed
##	    When SIEBEL: Login to Siebel again as BA 
##	    Then SIEBEL:Modifying Contract Status in Siebel
#
#
#	@BufferOpportunity@ProtectedClassSingleCustomer<50kwhwithmultipleproducts
#	Scenario: Validate Protected Class <50kwh Using Excel
#		Given DSP: make sure user is in landing page
#		And DSP: Clicks on All Opportunities
#		Then DSP: Closing and Recreating Opportunity in DSP multiple products