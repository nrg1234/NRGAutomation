package Pages.DSP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.ExcelUtil;
import Utilities.ReadXMLFile;
import Utilities.TestContext;
import apphooks.Base;

public class ExcelandXML {
	
	String customername;
	 private Base base;
	    TestContext testContext;
	    public ExcelandXML(Base base, TestContext context) {
	        this.base = base;
	        testContext = context;
	    }
	CreateOptyPopup opportunity=new CreateOptyPopup(base) ;
	AddCustomerPopup customer=new AddCustomerPopup(base) ;
	
	public void Exceldataforcreatenewopty() throws Throwable {
		
	 ExcelUtil util = new ExcelUtil();
     List<Map<String, Object>> data = util.getData(".\\src\\test\\resources\\DataReader\\DSPTest.xlsx", "Source");
     System.out.println(data);
     for (Map<String, Object> currentrow : data) {
        // opportunity.CreateNewOpportunity(currentrow);
         System.out.println("Created New Opportunity");
         break;
     }
     
}
	
	public void ReadXML() throws Throwable {
		
		ReadXMLFile xml=new ReadXMLFile();
	    customername = xml.Readxml();
	    customer.AddCustomertoOpportunity(customername);
	     
	}

	public void OptyXML() throws Throwable {

		ReadXMLFile xml=new ReadXMLFile();
		HashMap<String, String > OptyHeader = xml.getSubmittedOptyFromXML();
		opportunity.CreateNewOpportunity(OptyHeader);

	}
}
