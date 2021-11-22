package Pages.OAM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OAM {
	
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
	@FindBy(xpath="//button[@id='details-button']")
	WebElement details;
}
