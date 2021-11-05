package Pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import Utilities.ConstantVariables;
import Utilities.ExcelUtil;




public class DSPHomePage {

		Logger LOG = Logger.getLogger(DSPHomePage.class.getName());
	
		
		@FindBy(xpath="//button[@class='btn btn-link mdi wolr-toggle wolr-on mdi-toggle-switch']")
		WebElement toggleswitch;
		
		
		@FindBy(xpath="//button[contains(text(), 'Clear Filters')]")
		WebElement ClearFilters;
		
		@FindBy(xpath="//button[contains(text(), 'Create New Opportunity')]")
		WebElement createNewOptyBtn;
		
		@FindBy(id="opportunityName")
		WebElement Opportunityname;
		
		@FindBy(xpath="//input[@id='dueDate']")
		WebElement DueDate;
		

		@FindBy(xpath="//select[@id='market']")
		WebElement Market;
		
		@FindBy(xpath="//select[@id='marketSegment']")
		WebElement Marketsegment;
		
		@FindBy(xpath="//input[@id='startDate']")
		WebElement startDate;
		
		@FindBy(xpath="//input[@id='endDate']")
		WebElement endDate;
		
		@FindBy(xpath="//input[@name='thirdparty']")
		WebElement Thirdparty;
		
		@FindBy(xpath="//input[@name='accountRep']")
		WebElement accountRep;
		
		@FindBy(xpath="//p[@class='typeahead-options-title']")
		WebElement accountRepMenu;
		
		
		
		@FindAll(value = { @FindBy(xpath="//button[contains(text(), 'Create')]") })
		public List<WebElement> CreateButton;
		
		@FindBy(xpath="//*[@class='col-auto m-2 mr-auto d-none d-lg-block'][1]/h1")
		WebElement OpportunityIDText;

		
		@FindBy(xpath="//*[@id=\'navbar-2\']/form/div[1]/div/h1")
		WebElement randomOptyName;
		

		@FindBy(xpath="//button[contains(text(), 'Add Customer')]")
		WebElement Addcustomerbutton;
		
		
		@FindBy(xpath="//input[@id='typeahead-customer']")
		WebElement customerNameInput;
		
		@FindBy(xpath="//button[contains(text(), 'Create Customer')]")
		WebElement CreateCustomerButton;
		
		@FindBy(xpath="//*[@class='dropdown open dropdown-menu']")
		WebElement ListofcustomersMenu;
		
		@FindBy(xpath="//div[@class='col p-3']")
		WebElement Firstcustomercard;
		
		
		@FindBy(xpath="//button[contains(text(), 'Add To Opportunity')]")
		WebElement addCustomerToOptyBtn;

		@FindBy(xpath="//button[contains(text(), 'Renew')]")
		WebElement RenewButton;
		
		@FindBy(xpath="//button[contains(text(), 'Restructure')]")
		WebElement RestructureButton;
		
		
		@FindBy(xpath="//button[contains(text(), 'Create New Deal')]")
		WebElement createnewdealButton;
		
		@FindBy(xpath="/html/body/jhi-main/div/jhi-opportunity/div[1]/jhi-customer/div[1]/div[2]/table/tbody/tr/td[1]/span[1]")
		WebElement customerID;
		
		
		@FindBy(xpath="//input[@id='customerName']")
		WebElement inputcustomerName;
		
		
		@FindBy(xpath="//input[@id='address']")
		WebElement inputAddress;
		

		@FindBy(xpath="//input[@id='customerCity']")
		WebElement inputcustomerCity;
		

		@FindBy(xpath="//select[@class='form-control ng-pristine ng-invalid ng-touched']")
		WebElement inputState;
		
		@FindBy(xpath="//input[@id='customerZip']")
		WebElement inputcustomerZip;
		

		@FindBy(xpath="//input[@id='phone']")
		WebElement inputphone;
		
		@FindBy(xpath="//select[@id='businessType']")
		WebElement inputBusinesstype;
		

		@FindBy(xpath="//input[@id='accountRep']")
		WebElement inputAccountRep;
		
		@FindBy(xpath="//input[@id='typeahead-ema']")
		WebElement inputEMA;

		@FindBy(xpath="//select[@id='salesChannel']")
		WebElement inputsalesChannel;

		@FindBy(xpath="//input[@id='dba']")
		WebElement inputDBA;
		
		
		@FindBy(xpath="//button[contains(text(), 'Create and Add')]")
		WebElement CreateandAdd;
		
		@FindBy(xpath="//button[contains(text(), 'Create Anyways')]")
		WebElement CreateAnyways;
		
		@FindBy(xpath="//span[@class='icon icon-large icon-caret icon-caret-right brand-primary']")
		WebElement SitesComponentCaret;

		@FindBy(xpath="//button[contains(text(), 'Add Site')]")
		WebElement openAddSitesModalBtn;

		@FindBy(xpath="//textarea[@id='esiids']")
		WebElement SitestextArea;
		
		
		@FindBy(xpath="//button[contains(text(), 'Add Site(s)')]")
		WebElement addSitesBtn;
		
		@FindBy(xpath="//button[contains(text(), ' Submit Site(s) ')]")
		WebElement submitSitesBtn;
		
		
		@FindBy(xpath="//a[contains(text(), 'HU Upload')]")
		WebElement HUUpload;
		
		
		@FindBy(xpath="//button[contains(text(), 'Select File(s)')]")
		WebElement SelectHUFiles;
		
		
		@FindBy(xpath="//button[contains(text(), ' Process HU')]")
		WebElement ProcessHU;
		
		@FindBy(xpath="//button[contains(text(), 'Credit')]")
		WebElement CreditTAB;
		
		@FindBy(xpath="/html/body/jhi-main/div/jhi-opportunity/div[1]/jhi-creditalert/div/div/table/tbody/tr[2]")
		WebElement creditalertstatus;
		
		@FindBy(xpath="/html/body/jhi-main/div/jhi-opportunity/div[1]/jhi-creditalert/div/div/table/tbody/tr[2]")
		WebElement listOfCreditAlerts;
		
		@FindBy(xpath="//td[contains(text(), 'In Progress')]")
		WebElement creditreviewresult;
		
		@FindBy(xpath="/html/body/jhi-main/div/jhi-opportunity/div/jhi-creditalert/div/div/table/tbody/tr[4]/td[6]")
		WebElement creditAlertScore;
		
		
		
		@FindBy(xpath="//button[contains(text(), 'Quotes')]")
		WebElement QuotesTAB;
		
		
		@FindBy(xpath="//*[@id='quotesLoader']")
		WebElement quotesLoader;
		
		
		@FindBy(xpath="//span[contains(text(), 'See Details')]")
		WebElement seedetails;
		
		@FindBy(xpath="//button[@id='bp-visible-switch']")
		WebElement BrokerVisibletoggle;
		
		@FindBy(xpath="//a[contains(text(), 'Index')]")
		WebElement IndexTAB;
		

		@FindBy(xpath="//input[@id='mat-input-12']")
		WebElement Marginfield;

		@FindBy(xpath="//input[@id='mat-input-13']")
		WebElement DOAMarginfield;

		@FindBy(xpath="//button[contains(text(), 'Calculate and Save')]")
		WebElement CalculateandSave;

		@FindAll(value = { @FindBy(xpath="//span[contains(text(), 'Select')]") })
		public List<WebElement> productSelectBtn;
		
		@FindBy(xpath="//button[@id='bp-view-switch']")
		WebElement ViewBroker;
		
		@FindBy(xpath="//span[@class='mdi mdi-chevron-double-right mdi-24px']")
		WebElement GenerateContractinDealOption;
		
		@FindBy(xpath="//input[@id='name']")
		WebElement Dealoptionname;
		
		@FindBy(xpath="//select[@id='templateName']")
		WebElement TemplateName;
		
		@FindBy(xpath="//button[contains(text(), 'Enter Info')]")
		WebElement NoticeAddressButton;
		
		
		@FindBy(xpath="//span[@class='ng-arrow-wrapper']")
		WebElement contactNameDropdown ;
		
		@FindAll(value = { @FindBy(xpath="//p[@class='typeahead-options-title ng-star-inserted']")})
		public List<WebElement> contactNameValue;
		
		
		
		@FindBy(xpath="//button[contains(text(), 'Add to Customer ')]")
		WebElement addContactToCustomerBtn ;
		
		@FindBy(xpath="/html/body/ngb-modal-window[2]/div/div/jhi-contact-modal/jhi-modal/div[1]")
		WebElement modalheadergradiant ;
		

		@FindBy(xpath="//button[contains(text(), 'Contracts')]")
		WebElement contracttab ;
		
		
		@FindBy(xpath="//input[@id='firstName']")
		WebElement NoticeFirstName;
		
		
		@FindBy(xpath="//input[@id='lastName']")
		WebElement NoticeLastName;
		
		@FindBy(xpath="//input[@id='streetAddress']")
		WebElement NoticeAddress;
		
		@FindBy(xpath="//input[@id='city']")
		WebElement NoticeCity;

		@FindBy(xpath="//select[@id='state']")
		WebElement NoticeState;
		
		@FindBy(xpath="//input[@id='zip']")
		WebElement NoticeZip;
		
		@FindBy(xpath="//input[@id='cellPhone']")
		WebElement Noticecellphone;
		
		@FindBy(xpath="//input[@id='workPhone']")
		WebElement Noticeworkphone;
		
		@FindBy(xpath="//input[@id='fax']")
		WebElement NoticeFax;
		
		@FindBy(xpath="//input[@id='email']")
		WebElement NoticeEmail;
		
		@FindBy(xpath="//button[contains(text(), 'Save Changes')]")
		WebElement savechanges;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[2]/jhi-contract-generation/div/div/div/div/div/form/div[8]/div/table/tbody/tr/td[5]/select")
		WebElement ApproverDropdown;
		
		@FindBy(xpath="//button[contains(text(), 'Generate Contract')]")
		WebElement generateContractModalBtn;
		
		@FindAll(value = { @FindBy(xpath="//button[contains(text(), 'Generate Contract')]")})
		public List<WebElement> ContractButtonInformationPage;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/jhi-contract-generation-modal/jhi-modal/div[1]")
		WebElement ContractModaldisappear;
		
		@FindBy(xpath="//td[@class='modal-link ng-star-inserted']")
		WebElement DealOptionNameinDeal;
		
		
		@FindBy(xpath="//span[@class='mdi mdi-signature-freehand mdi-24px']")
		WebElement Customersigned;
		
		@FindBy(xpath="//span[@class='mdi mdi-file-send mdi-24px']")
		WebElement  sendContractToCustomerBtn;
		
		@FindBy(xpath="//*[@id='customerEmail']")
		WebElement  customerEmailInput;
		
		@FindBy(xpath="//button[contains(text(), 'Send Contract')]")
		WebElement  sendContractBtn;	
		
		@FindBy(xpath="	//span[@class='ng-star-inserted']")
		WebElement  contractStatus;
	
		
		@FindBy(xpath="//select[@name='s_vis_div']")
		WebElement AllopportunityDropdown;
	
		@FindBy(xpath="//select[@id='s_2_l_searchField']")
		WebElement Createdbydropdown;
		
		@FindBy(xpath="//button[@id='s_4_1_17_0_Ctrl']")
		WebElement QueryButton;
		
		@FindBy(xpath="//input[@id='1_Opportunity__']")
		WebElement opportunityidfield;
		
		
		@FindBy(xpath="//button[@id='s_4_1_14_0_Ctrl']")
		WebElement GoButton;
		
		@FindBy(xpath="//*[@id='a_3']/div/table/tbody/tr/td/div[1]/span/table/tbody/tr/td[1]")
		WebElement otherRandomDiv;
		
		
		@FindBy(xpath="//a[contains(text(), 'Credit Review Request')]")
		WebElement creditReviewRequestTab;
		

		@FindBy(xpath="//td[@id='1_s_1_l_Alert_Number']")
		WebElement creditAlertDrilldown;
		

		@FindBy(xpath="//input[@name='s_1_1_6_0']")
		WebElement Evaluatorfield;
		
		@FindBy(xpath="//input[@name='s_2_1_2_0']")
		WebElement CreditReviewResultdropdown;
		
		@FindBy(xpath="//input[@name='s_1_1_4_0']")
		WebElement RERGScore;
		
		@FindBy(xpath="//img[@id='s_1_1_7_0_icon']")
		WebElement Lastcreditevaluationdate;
		
		@FindBy(xpath="//input[@name='s_1_1_2_0']")
		WebElement LegalEntity;
		
		@FindBy(xpath="//input[@id='user']")
		WebElement OAMEmail;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement OAMPassword;
		
		@FindBy(xpath="//a[@id='signin']")
		WebElement OAMLoginButton;

		
		@FindBy(xpath="//a[@class='dropdown-toggle ng-tns-c1-1']")
		WebElement DropdowntoggleOAM;
		
		@FindBy(xpath="//a[contains(text(), 'Pricing')]")
		WebElement pricinglinkOAM;
		
		@FindAll(value = { @FindBy(xpath="//div[@class='control__indicator']") })
		public List<WebElement> TermsandconditionsCheckbox;
		
		@FindBy(xpath="//div[@class='control__indicator']")
		WebElement TermsandconditionsCheckbox1;
		
		
		@FindBy(xpath="//button[contains(text(), 'Continue')]")
		WebElement ContinueButtonOAM;
		
		
		@FindBy(css="btn btn-primary create-quote")
		WebElement CreateNewQuote;
		
		@FindBy(css="btn btn-primary mb-3")
		WebElement ContinuetoAddsites;
		
		@FindBy(xpath="//button[contains(text(), ' Validate Sites')]")
		WebElement Validatesites;
		
		
		@FindBy(xpath="//button[contains(text(), ' Continue to Pricing')]")
		WebElement continuetopricing;
		
		@FindBy(xpath="//button[@id='details-button']")
		WebElement AdvancedButton;
		
		@FindBy(xpath="//a[@id='proceed-link']")
		WebElement proceedlink;
		
		@FindBy(xpath="//span[@class='icon icon-warning']")
		WebElement creditwarning;
		
		@FindBy(xpath="//input[@name='SWEUserName']")
		WebElement  SiebelUsernamefield;
		
		@FindBy(xpath="//input[@name='SWEPassword']")
		WebElement  SiebelPasswordfield;
		
		@FindBy(xpath="//a[@id='s_swepi_22']")
		WebElement  submitsiebelLogin;
		
		@FindBy(xpath="//a[contains(text(), 'Opportunities')]")
		WebElement opportunitiesTabsiebel;
		
		
		
		
		 WebDriver driver;
		public  DSPHomePage(WebDriver driver)  {
			 this.driver = driver;
			PageFactory.initElements(driver, this);
			
			}	
		
		

		/*
    	 * Method to Scroll to an element
    	 */
		
		public void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			int yaxis = element.getLocation().getY();
			int height = element.getSize().getHeight();
			int scrollHeight = yaxis-height;
			js.executeScript("scroll(0, "+scrollHeight+");");
		}
		
		
		/*
    	 * Waits till the Element becomes visible
    	 */
			public void waitForvisibility(WebElement element,int seconds) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, seconds);
					wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
				}catch(Exception e) {

				}
		}
		/*
    	 * Waits till the Element becomes invisible
    	 */
		
			public void waitForinvisibility(WebElement element,int seconds) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, seconds);
					wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
				}catch(Exception e) {

				}
		}
			
			
				
				
				/*
		    	 * Create new opportunity.
		    	 */
		public void CreateNewOpportunity(Map<String,Object> data) throws Throwable {
			CommonFunctions functions=new CommonFunctions();
			
			functions.click(driver,createNewOptyBtn);
		
			 // Enter opportunity name
	        functions.setText(driver, Opportunityname, data.get("Opportunityname").toString());
			
			 // Wait for Duedate pop up before writing to input
	      
	        functions.setText(driver, DueDate, data.get("DueDate").toString());
			 
			// Select the Market using the visible text
			 functions.selectDropdownByVisibleText(driver,Market,data.get("Market").toString());
			 
			 
				// Select the Marketsegment using the visible text
			 functions.selectDropdownByVisibleText(driver,Marketsegment,data.get("MarketSegment").toString());
					
					// Select the start Date for the Opportunity
					
					functions.setText(driver,startDate,data.get("startDate").toString());
					
					// Select the End Date for the Opportunity
				
					functions.setText(driver,endDate,data.get("endDate").toString());
					
					//Select the AccountRep for the Opportunity
					functions.setText(driver,accountRep,data.get("accountRep").toString());
					functions.click(driver,accountRepMenu);			

			        // Click "create Button"
					
					List<WebElement> Createbutton= CreateButton;
					if(Createbutton.size()>0 ==true && Createbutton.get(1).isDisplayed()==true) {
						Createbutton.get(1).click();
					}	
					
					// Make sure opportunity was created
			     
			        assertTrue("Newly created opty name should be displayed", randomOptyName.isDisplayed());
			        

			        // Wait for modal to unload
			        try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.err.println("Failed to Thread.sleep()!");
						e.printStackTrace();
					}
			        
			    	System.out.println("Adding customer to opty.");
			    	
		}
		
		/*
         * Add customer to opportunity.
         */
    	
		public void AddCustomertoOpportunity(Map<String,Object> data) throws Throwable  {
			CommonFunctions functions=new CommonFunctions();
			// Click add customer button
			
	        
	        functions.click(driver,Addcustomerbutton);
			
	     
	        
	     // Enter customer name
	       
	        functions.setText(driver, customerNameInput, data.get("customerName").toString());
	        
	        // Wait for spinner to pop up
	      waitForvisibility(customerNameInput,10);
	     
	      // Select first customer card
	       
	       
	        functions.click(driver,Firstcustomercard); 
	        
	        // Click "add to opportunity" button
	        
	        
	        functions.click(driver,addCustomerToOptyBtn);
	        
	        // Wait for page to update
	        try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				System.err.println("Failed to Thread.sleep()!");
				e.printStackTrace();
			}
	        
	        //select Create New Deal from the Popup
	       
	        waitForvisibility(createnewdealButton,10);
	        functions.click(driver, createnewdealButton);
	       
		}
		 /*
         * Add sites to opportunity.
         */
		
		public  String AddSitestotheOpty()throws Throwable {
			CommonFunctions functions=new CommonFunctions();
			 ConfigReader config=new ConfigReader();
	    	   Properties prop=config.init_properties();
	    	   
        waitForvisibility(SitesComponentCaret,10);
      
        functions.click(driver,SitesComponentCaret);
        
        // Open modal to add sites
        
        functions.click(driver,openAddSitesModalBtn);
        
     // Add sites to opportunity text area
       
       
        functions.click(driver, SitestextArea);
        functions.setText(driver, SitestextArea, prop.getProperty("site-esids"));

     // Add sites to opportunity
		
        functions.click(driver,addSitesBtn);
       
        functions.click(driver,submitSitesBtn);
        
        
        
     // Wait for add sites modal to disappear, and site tracked modal to appear
        try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}

   
	      final String OpportunityID=functions.getText(driver, OpportunityIDText);
	        System.out.println(OpportunityID);
	        return OpportunityID;
		}
		
		
		
		/*
         * View Credit Chevron
         */
		
		public BAApprovescreditinSiebel ViewCreditChevron() throws Throwable {
			CommonFunctions functions=new CommonFunctions();
		//View Credit Chevron
			waitForvisibility(CreditTAB,10);
		functions.click(driver,CreditTAB);
		return new BAApprovescreditinSiebel(driver);
		}
		
		

       
       /*
        * Validate credit alert status.
        */
       
       public void creditalertstatusDSP()throws Throwable {
    	   CommonFunctions functions=new CommonFunctions();
    	   // Navigate to credit component
         
           assertTrue("Credit chevron button should be displayed", CreditTAB.isDisplayed());
           functions.click(driver,CreditTAB);
           
        // Wait for credit alert status to be updated in DSP
       	try {
   			Thread.sleep(10 * 1000);
   		} catch (InterruptedException e1) {
   			System.err.println("Failed to Thread.sleep()!");
   			e1.printStackTrace();
   		}
       	
        // Ensure that there exist valid credit alerts
       	
        List<WebElement> CreditAlertslist=(List<WebElement>) listOfCreditAlerts;
        assertTrue("At least one credit alert should be displayed for customer", CreditAlertslist.size() > 1);
        assertTrue("Credit alert score was updated in Siebel and reflected in DSP", creditAlertScore.getText().equals("a+")); 
       }
   	
       
       
       /*
        * Price a deal.
        */
       public void priceadeal(Map<String,Object> data)throws Throwable  {
    	   CommonFunctions functions=new CommonFunctions();
    	// Navigate to quotes page
       	assertTrue("Quotes page button should be there", QuotesTAB.isDisplayed());
       	waitForvisibility(QuotesTAB,10);
       	functions.click(driver,QuotesTAB);
       	
       	
     // Wait for spinner to appear when request is made to Siebel
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
    	
 
    	//Updating Margin and DOA Margin Values
    	functions.setText(driver, Marginfield, data.get("Margin").toString());
    	functions.setText(driver, DOAMarginfield, data.get("DOAMargin").toString());
    	
    	//Calculate and save
    	functions.click(driver,CalculateandSave);
    	
    	
    	 // Wait for spinner to appear when request is made to Siebel
    	try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
    	
    	// Select a product
    	productSelectBtn.get(1).click();
    	
    	
       }
       /*
   	 * Generate contract workflow.
   	 */
   	
       
       public void GenerateContract(Map<String,Object> data)throws Throwable  {
    	   CommonFunctions functions=new CommonFunctions();
    	// Open generate contract modal
      
       
    	   waitForvisibility(generateContractModalBtn,10);
       	functions.click(driver,generateContractModalBtn);

    	// Fill out modal
    	
    	
    	functions.setText(driver, Dealoptionname, data.get("Dealoptionname").toString());
    	
		
		// Select the option using the visible text
    	functions.selectDropdownByVisibleText(driver,TemplateName,data.get("TemplateName").toString());
    	// Add contact notice address
    	
		functions.click(driver,NoticeAddressButton);
    	
		 // Wait for spinner to appear Contact Info
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
    	
		
    	
    	functions.click(driver,contactNameDropdown);
    	
    	
    	contactNameValue.get(1).click();
    	
    
    	functions.click(driver,addContactToCustomerBtn);
    	
    	 // Wait for spinner to appear Contact Info
    	try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
    	
    	
    	// Choose approver
    	
    	functions.selectDropdownByVisibleText(driver,ApproverDropdown,data.get("Approver").toString());
    	// Generate contract
    	
    	ContractButtonInformationPage.get(1).click();
    	
    	// Wait for spinner to Load
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleep()!");
			e.printStackTrace();
		}
    	
    	
    	System.out.println("Validating contract creation successful.");
    	   
    	// Wait for dealoption status to get Approved
    	   try {
      			Thread.sleep(60000);
      		} catch (InterruptedException e) {
      			System.err.println("Failed to Thread.sleep()!");
      			e.printStackTrace();
      		}
}
       
       /*
   	 * View contracts 
   	 */
       public void contractcreation()throws Throwable {
    	   CommonFunctions functions=new CommonFunctions();
    	
    	  functions.click(driver,contracttab);
    	// Wait for contract to be created
       	try {
   			Thread.sleep(700000);
   		} catch (InterruptedException e) {
   			System.err.println("Failed to Thread.sleep()!");
   			e.printStackTrace();
   		}
    	   
       }
  
      
   	/*
   	 * Send Contract To Customer

   	 */
   	
   	// Open contract generation modal
       
       public void Sendcontracttocustomer(Map<String,Object> data)throws Throwable  {
    	   CommonFunctions functions=new CommonFunctions();
    		
   	functions.click(driver,sendContractToCustomerBtn);
 // Wait for spinner to Load
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		System.err.println("Failed to Thread.sleep()!");
		e.printStackTrace();
	}
   	
   	
   	// Enter email for contract
  
   	functions.setText(driver, customerEmailInput, data.get("customerEmail").toString());
   	
   	// Send contract
   
   	functions.click(driver,sendContractBtn);
   	
   	// Wait for modal to disappear
   	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println("Failed to Thread.sleeo()!");
			e.printStackTrace();
		}
   	
   }
  
}


