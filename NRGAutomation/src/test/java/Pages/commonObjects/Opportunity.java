package Pages.commonObjects;

import Utilities.Context;

public class Opportunity {
    String opporunityID;
    String customername;
    String contractid;
    String renewcustomer;
    String OptyHeader;
    String customername2;

    public String getOpporunityID() {
        return opporunityID;
    }

    public void setOpporunityID(String opporunityID) {
        this.opporunityID = opporunityID;
    }
    
    
    public String Customername() {
    	return customername;
    }
    
    public void setCustomerName(String customername) {
        this.customername = customername;
    }
    
    public String getContractID() {
    	return OptyHeader;
    }
    
    public void setContractID(String OptyHeader) {
        this.OptyHeader = OptyHeader;
    }
    
    public String getRenewcustomer() {
    	return renewcustomer;
    }
    
    public void setRenewcustomer(String renewcustomer) {
        this.renewcustomer = renewcustomer;
    }
    
    
}
