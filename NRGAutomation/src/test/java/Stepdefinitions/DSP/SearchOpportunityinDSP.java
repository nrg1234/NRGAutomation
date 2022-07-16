package Stepdefinitions.DSP;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.hamcrest.text.IsEmptyString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.DSP.AccountRepforAggregate;
import Pages.DSP.AddCustomerPopup;
import Pages.DSP.AddSitesPopup;
import Pages.DSP.ClosingOpportunity;
import Pages.DSP.CreateOptyPopup;
import Pages.DSP.GenerateContract;
import Pages.DSP.PriceaDeal;
import Pages.DSP.SearchOpportunity;
import Pages.DSP.SendContracttoCustomer;
import Pages.DSP.ViewContract;
import Pages.DSP.ViewCredit;
import Pages.Siebel.BAApprovescreditinSiebel;
import Pages.Siebel.Login;
import Pages.VHOS.ValidateOpportunityStatusVhos;
import Utilities.ConfigReader;
import Utilities.Context;
import Utilities.DataReaderEXCEL;
import Utilities.ExcelReader;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import Utilities.WriteExcel;
import Utilities.XMLOptyCreate;
import Utilities.XMLRead;
import apphooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.VHOS.LoginVhos;
public class SearchOpportunityinDSP {

	private Base base;

	TestContext testContext;
	WebDriver driver;
	public SearchOpportunityinDSP(Base base, TestContext context) {
		this.base = base;
		testContext = context;
		
	}

	CreateOptyPopup opportunity = new CreateOptyPopup(base);
	AddCustomerPopup customer = new AddCustomerPopup(base);
	SearchOpportunity Search = new SearchOpportunity(base);
	ClosingOpportunity Close = new ClosingOpportunity(base);
	GenerateContract contract = new GenerateContract(base);
	ValidateOpportunityStatusVhos Status = new ValidateOpportunityStatusVhos(base);
	AddSitesPopup sites = new AddSitesPopup(base);
	WriteExcel input = new WriteExcel(base);
	PriceaDeal deal = new PriceaDeal(base);
	DataReaderEXCEL data = new DataReaderEXCEL(base);
	String password;
	Utilities.CommonFunctions encrypted = new Utilities.CommonFunctions();
	Login login = new Login(base);
	LoginVhos login1 = new LoginVhos(base);
	BAApprovescreditinSiebel siebel = new BAApprovescreditinSiebel(base);
	ViewContract status = new ViewContract(base);
	SendContracttoCustomer sendContract = new SendContracttoCustomer(base);
	AccountRepforAggregate Accountrep = new AccountRepforAggregate(base);
	ViewCredit credit = new ViewCredit(base);
	ConfigReader config = new ConfigReader();
	Properties prop = config.init_properties();
	String browser = prop.getProperty("browser");
	XMLOptyCreate xml = new XMLOptyCreate(base);
	XMLRead xmll = new XMLRead(base);
	WriteExcel read = new WriteExcel(base);
	String currentrow;
	
	
	 
	@Then("DSP: Closing and Recreating Opportunity in DSP")
	public void Closing_Opportunity_DSP() throws Throwable {

		int i = 0;

		int j = 0;


		ExcelReader util = new ExcelReader();
		List<Map<String, String>> data = util.getData(prop.getProperty("Excelpath"),
				"Data");
		String currentopportunityid = null;
		String nextrow = null;
		String nextdealoption = null;
		String nextcontractTerm = null;
		String CurrentContractTerm =null;
		String currentopty = data.get(i).get("OPPORTUNITY_ID");
		
		String previousoptyname= "";
		do {
			currentopportunityid = data.get(i).get("OPPORTUNITY_ID");
			String optyname = data.get(i).get("OPPORTUNITYNAME");
			String salesgroup = data.get(i).get("MKT_SEG");
			String Saleschannel = data.get(i).get("SALES_CHANNEL");
			String ThirdParty = data.get(i).get("THIRDPARTY_NAME");
			String AccountRep = data.get(i).get("ACCOUNTREP");
			String customerName = data.get(i).get("CUSTOMERNAME");
			String ESIID = data.get(i).get("PODLIST");
			

			String startdate = data.get(i).get("START_DATE");
			String enddate = data.get(i).get("END_DATE");
		
			String TemplateName = data.get(i).get("TemplateName");
			String Approver = data.get(i).get("Approver");
			
			
		    String EMA=data.get(i).get("LEADEMA");
		    String details= data.get(i).get("CUSTOMERADDRESS");
		    String caddress= data.get(i).get("C_ADDRESS");
		    String ccity= data.get(i).get("C_CITY");
		    String cstate= data.get(i).get("C_STATE");
		    String czip= data.get(i).get("C_ZIP");
		    String cphone= data.get(i).get("MAINPHONENUMBER");
		    String businesstype= data.get(i).get("BUSINESSTYPE");
		    String csaleschannel= data.get(i).get("C_SALESCHANNEL");
		    String dba= data.get(i).get("DBA");
			   System.out.println(optyname);
		    
		  if(previousoptyname!=optyname) {  
	  boolean closeopty= Close.CloseOpportunity(currentopportunityid);			
		if(closeopty) {  
	  opportunity.CreateNewOpportunityforProtectedclass(i, optyname, salesgroup, ThirdParty, AccountRep,  startdate, enddate);			
		    boolean customerresult= customer.AddCustomertoOpportunity(customerName,details,i,caddress,ccity,cstate);
//			customer.CreateCustomertoOpportunity(customerName,details,caddress,ccity,czip,cphone,businesstype,AccountRep,EMA,csaleschannel,dba );
		if(customerresult) {
				
		    customer.UpdateSalesgroup(AccountRep,EMA,ThirdParty,salesgroup,Saleschannel);
			String UpdateExcel =  sites.AddSitestotheProtectedOpty(ESIID);

			 credit.Convertingdealtolessthan50kwnew(i);
	         read.UpdateExcel(UpdateExcel, i);
			 deal.quotestab(i);
			
          int z = i;                 
          
			do {
				nextrow = data.get(z + 1).get("OPPORTUNITY_ID");

				String Term = data.get(z).get("QPRODUCTTERM");
				String CustomTerm = data.get(z).get("CUSTOM_TERM");
				
				deal.addterm(Term,CustomTerm);
				z++;
				
			}

			while (Objects.equals(currentopportunityid, nextrow) || nextrow == null);
                deal.CalculateSavebtn();
                
			String MeterFee = data.get(i).get("MONTHLY_METER_FEE");
			String Recvalue = data.get(i).get("REC_PERCENT");
			deal.BasechargeandRec(MeterFee, Recvalue);
						
			int k = i;
//Entering details in quotes page

			do {
				nextrow = data.get(k + 1).get("OPPORTUNITY_ID");
				CurrentContractTerm=data.get(k).get("PRODUCT_TERM");
				String Term = data.get(k).get("QPRODUCTTERM");
				String Margin = data.get(k).get("QMARGINVALUE");
				String DOAMargin = data.get(k).get("QDOAMARGINVALUE");
				String BrokerFee = data.get(k).get("QBROKERFEE");
				String Intradayadjustment = data.get(k).get("QINTRADAYADJUSTMENT");
				
				deal.selectProduct(Term, Margin, DOAMargin, BrokerFee,Intradayadjustment);
				
				k++;

			}

			while (Objects.equals(currentopportunityid, nextrow) || nextrow == null);
			
			deal.CalculateSavebtn();

	//Entering details in information page		
                 int s=i;
			do {
				nextrow = data.get(s + 1).get("OPPORTUNITY_ID");
				String NextContractTerm = data.get(s).get("PRODUCT_TERM");
				deal.selectProductcontractgeneration(NextContractTerm,s);
				String firstname = data.get(s).get("FIRSTNAME");
				String lastname = data.get(s).get("LASTNAME");
				String address = data.get(s).get("STREET");
				String City = data.get(s).get("CITY");
				String Zip = data.get(s).get("ZIP");
				String State = data.get(s).get("STATE");
				String Email = data.get(s).get("EMAIL");
				String Phone = data.get(s).get("PHONE");
				String Fax = data.get(s).get("FAX");
				String Dealoptionname = data.get(s).get("DEALOPT_NAME");
		
				contract.ContractGenerationmultiplecontract(s,firstname, lastname, address, Phone , City, Zip, State, Email, Dealoptionname, TemplateName, Approver,Fax);

				nextcontractTerm = data.get(s+1).get("PRODUCT_TERM");
			
								
				if(nextcontractTerm.length()!=0 ) {
			
					deal.clickquotespage();				
	
			}
				s++;

			}		
              
			while (Objects.equals(currentopportunityid, nextrow) || nextrow == null);
			int y=i;
		     contract.writevintage(y);
			  contract.Navigatetodsp();
			
			i = k;
			continue;
		}
		  }
		  }
		 contract.Navigatetodsp();
		 previousoptyname=optyname;
		 System.out.println(previousoptyname);
		 i++;
		 nextrow = data.get(i + 1).get("OPPORTUNITY_ID");
		}
		
		while (nextrow.length()!=0);
		
		
	}
}

			




//	@Then("DSP: Closing and Recreating Opportunity in DSP using XML File")
//
//	public void Closing_Opportunity_DSP_XML() throws Throwable {
//		int i = 0;
//		while (i <= 2) {
//
//			HashMap<String, String> OptyHeader1 = xmll.getSubmittedOptyFromXML(i);
//			Close.CloseOpportunityXML(OptyHeader1.get("Opportunity_ID"));
//			//opportunity.CreateNewOpportunityforProtectedclassxml(OptyHeader1.get("Opportunity_Name"), OptyHeader1.get("Sales_Group"), OptyHeader1.get("Third_Party"), OptyHeader1.get("Account_Rep"));
//			customer.AddCustomertoOpportunityforPCXML(OptyHeader1.get("Customer_Name1"));
//			testContext.scenarioContext.setContext(Context.OPTY_ID, sites.AddSitestotheProtectedOptyXML(OptyHeader1.get("Sites1")));
//		//	testContext.scenarioContext.setContext(Context.OPTY_ID, credit.Convertingdealtolessthan50kwnew());
//			//read.write((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
/////			password = encrypted.Encryption();
/////		login.LoginSiebel(password);
/////			siebel.BAApprovescreditinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
////			deal.selectProductXML(OptyHeader1.get("Broker_fee"),OptyHeader1.get("Margin_value"),OptyHeader1.get("DOA_Margin"),OptyHeader1.get("Term_months"));
//			contract.ContractGenerationforProtectedClassXML(OptyHeader1.get("Dealoption_Name"),OptyHeader1.get("Template_Name"),OptyHeader1.get("first_name"),OptyHeader1.get("last_name"),OptyHeader1.get("address_details"),OptyHeader1.get("City"),OptyHeader1.get("State"),OptyHeader1.get("Zip"),OptyHeader1.get("Email"),OptyHeader1.get("Approver"));
////			status.contractcreation();
//			//sendContract.Sendcontracttocustomer();
//			i++;
//		}
//
//
//	}
//
//
//	@Then("DSP: Closing and Recreating Opportunity for Aggregate Customer in DSP")
//	public void Closing_Opty_DSP() throws Throwable {
//		int i = 0;
//		while (i <= 0) {
//			ExcelReader util = new ExcelReader();
//			List<Map<String, String>> data = util.getData(".\\src\\test\\resources\\DataReader\\datadumpAggregate.xlsx",
//					"OpportunityDetails");
//			String currentrow = data.get(i).get("OpportunityID");
//			String optyname = data.get(i).get("OpportunityName");
//			String salesgroup = data.get(i).get("SalesGroup");
//			String ThirdParty = data.get(i).get("Third Party");
//			String AccountRep = data.get(i).get("Account Rep");
//			String customerName2 = data.get(i).get("CustomerName2");
//			String customerName3 = data.get(i).get("CustomerName3");
//			String ESIID2 = data.get(i).get("Sites2");
//			String DOAMargin = data.get(i).get("DOAMargin");
//			String BrokerFee = data.get(i).get("Broker fee1");
//			String ESIID3 = data.get(i).get("Sites3");
//			String OpportunityID = data.get(i).get("OpportunityID");
//			String firstname = data.get(i).get("firstname");
//			String lastname = data.get(i).get("lastname");
//			String address = data.get(i).get("address");
//			String City = data.get(i).get("City");
//			String Zip = data.get(i).get("Zip");
//			String State = data.get(i).get("State");
//			String Email = data.get(i).get("Email");
//			String Term = data.get(i).get("Term");
//			String Margin = data.get(i).get("Margin");
//			String SubTerm = Term.substring(0, 2);
//			Close.CloseOpportunity(currentrow);
//			login1.loginVhos(browser);
//			Status.ValidateOptyStatusinVhos(OpportunityID);
//			//opportunity.CreateNewOpportunityforProtectedclass(optyname, salesgroup, ThirdParty, AccountRep);
//
//			customer.AddCustomertoOpportunity(customerName2);
//			customer.AddCustomertoOpportunity(customerName3);
//			testContext.scenarioContext.setContext(Context.OPTY_ID, sites.AddSitestotheOptyforAggregateProtectedclass(customerName2, customerName3, ESIID2, ESIID3));
//			Accountrep.AccountrepforAggregate();
//			password = encrypted.Encryption();
//			login.LoginSiebel(password);
//			siebel.BAApprovescreditinSiebelforAggregate((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
//		//deal.selectProduct(SubTerm, Margin, DOAMargin, BrokerFee,Recvalue,MeterFee);
//			contract.ContractGenerationAggregateforProtectedClass(firstname, lastname, address, City, Zip, State, Email);
//			status.contractcreation();
//			//sendContract.Sendcontracttocustomer();
//			i++;
//		}
//
//	}
//
//
//	@Then("DSP: Closing and Recreating Opportunity in DSP multiple products")
//	public void dsp_closing_and_recreating_opportunity_in_dsp_multiple_products()throws Throwable {
//		int i = 0;
//		while (i <= 0) {
//			ExcelReader util = new ExcelReader();
//			List<Map<String, String>> data = util.getData(".\\src\\test\\resources\\DataReader\\PCcutoverdatatemplatemultiple.xlsx",
//					"OpportunityDetails");
//			String currentrow = data.get(i).get("OpportunityID");
//			String optyname = data.get(i).get("OpportunityName");
//			String salesgroup = data.get(i).get("SalesGroup");
//			String Saleschannel = data.get(i).get("SalesChannel");
//			String ThirdParty = data.get(i).get("Third Party");
//			String AccountRep = data.get(i).get("Account Rep");
//			String customerName = data.get(i).get("CustomerName1");
//			String ESIID = data.get(i).get("Sites1");
//			String OpportunityID = data.get(i).get("OpportunityID");
//			String firstname = data.get(i).get("firstname");
//			String lastname = data.get(i).get("lastname");
//			String address = data.get(i).get("address");
//			String City = data.get(i).get("City");
//			String Zip = data.get(i).get("Zip");
//			String State = data.get(i).get("State");
//			String Email = data.get(i).get("Email");
//			String Term = data.get(i).get("Term");
//			String Term1 = data.get(i).get("Term1");
//			String MarginTerm = data.get(i).get("MarginTerm");
//			String Margin = data.get(i).get("Margin1");
//			String DOAMargin = data.get(i).get("DOA Margin1");
//			String BrokerFee = data.get(i).get("Broker fee1");
//			String SubTerm = Term.substring(0, 2);
//			String SubTerm1 = Term1.substring(0, 2);
//			String Mterm=MarginTerm.substring(0, 2);
//			String Dealoptionname = data.get(i).get("Dealoptionname");
//			String TemplateName = data.get(i).get("TemplateName");
//			String Approver = data.get(i).get("Approver");
//			//Close.CloseOpportunity(currentrow);
//			//opportunity.CreateNewOpportunityforProtectedclass(optyname, salesgroup, ThirdParty, AccountRep);
//			customer.AddCustomertoOpportunity(customerName);
//			testContext.scenarioContext.setContext(Context.OPTY_ID, sites.AddSitestotheProtectedOpty(ESIID));
////			testContext.scenarioContext.setContext(Context.OPTY_ID, credit.Convertingdealtolessthan50kwnew());
////			password = encrypted.Encryption();
////			login.LoginSiebel(password);
////			siebel.BAApprovescreditinSiebel((String) testContext.scenarioContext.getContext(Context.OPTY_ID));
//			deal.selectmultipleProduct(SubTerm,SubTerm1, BrokerFee,Margin, DOAMargin);
////			contract.ContractGenerationforProtectedClass(firstname, lastname, address, City, Zip, State, Email, Dealoptionname, TemplateName, Approver);
//			status.contractcreation();
//			//sendContract.Sendcontracttocustomer();
//			i++;
//		}
//
//	}}
