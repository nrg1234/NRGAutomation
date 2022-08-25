Feature: DSP Matrix Adoption

@Enrollment@Matrixpricedealgreaterthan50kwSmallFixedProductPc_product
Scenario: New Matrix Enrollment >50K with Small Fixed Product(Pc product)_Curve date_ CalculatedBrokerFee

	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty
	Then DSP:  Add Sites to customers in new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	Then DSP: Select Small Fixed Product
Then DSP: Navigate to Quotes


@Enrollment@Matrixpricedealgreaterthan50kwSmallFixedGreenProductPc_productnegativebrokerfee
Scenario: New Matrix Enrollment >50K with Small Fixed Green Product(Pc Product)_Curve date_ CalculatedBrokerFee_negative broker fee- negative scenario

	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty
	Then DSP:  Add Sites to customers in new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	Then DSP: Select Small Fixed Green Product
Then DSP: Enter negative broker fee
Then DSP: Navigate to Quotes Negative

@Enrollment@Matrixpricedealgreaterthan50kwSmallFixedGreenProductPc_product
Scenario: New Matrix Enrollment >50K with Small Fixed Green Product(Pc Product)_Curve date_ CalculatedBrokerFee

	Given DSP: make sure user is in landing page 
	And DSP: Clicks on All Opportunities 
	And DSP: Click on ENTER MATRIX PRICE DEAL
	Then  DSP: Add customer to the Opty
	Then DSP:  Add Sites to customers in new Opty 
	When SIEBEL: Login to Siebel as BA 
	Then SIEBEL: Approve Credit for Single Customer 
	Then DSP: Select Small Fixed Green Product
        Then DSP: Navigate to Quotes