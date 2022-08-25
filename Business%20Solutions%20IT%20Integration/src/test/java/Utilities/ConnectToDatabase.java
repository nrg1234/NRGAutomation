package Utilities;

import apphooks.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.*;
import java.util.Properties;
import java.util.Random;

public class ConnectToDatabase {

    
    private Base base;

	public ConnectToDatabase(Base base) {
		this.base = base;
	}

    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet resultSet = null;
    public static WebDriver driver;

    //public static void main(String[] args)  throws SQLException, ClassNotFoundException{
    public void SetUpConnectionDSP(String OpportunityID) throws SQLException, ClassNotFoundException {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String DSPDBQuery = prop.getProperty("DSPPCQuery");
        String OptyID;
        String PCFlag;
        String Brand;
 
        // Register JDBC driver (JDBC driver name and Database URL)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Open a connection
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//txaixebndbd02:1536/ECDBD02", "DSP_MAIN", "DSP#Ma1n#D3v02!");
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("Select External_id,Protectedclass from OPPORTUNITY WHERE EXTERNAL_ID='" + OpportunityID + "'");
        while (resultSet.next()) {
            OptyID = resultSet.getString("EXTERNAL_ID");
            PCFlag = resultSet.getString("PROTECTEDCLASS");
            Brand=resultSet.getString("BRAND");
            System.out.println(OptyID + ", " + PCFlag+","+Brand);

        }
    }
   //  public static void main(String args[]) throws ClassNotFoundException, SQLException {
   public void SetUpConnectionVHOSCreditEvaluation(String ExternalOpportunityID) throws SQLException, ClassNotFoundException {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();

 
     //   String ExternalOpportunityID= "ded85fc9-5df2-4ff4-8189-1baf0b1f0685";
        // Register JDBC driver (JDBC driver name and Database URL)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Open a connection
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.140.125.165:1521/vhost", "VHOS0", "StarbucksIT11##");
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("select INDICATIVE_CREDIT_STATUS,INDICATIVE_CREDIT_SCORE,CREATEDON,"
        		+ "UPDATEDON from opportunity_credit_alert WHERE EXTERNAL_OPPORTUNITY_ID = '" + ExternalOpportunityID + "'");
        while (resultSet.next()) {
            String IndicativecreditStatus = resultSet.getString("INDICATIVE_CREDIT_STATUS");
            String Indicativecreditscore = resultSet.getString("INDICATIVE_CREDIT_SCORE"); 
            String Createdon = resultSet.getString("CREATEDON"); 
            String Updateon = resultSet.getString("UPDATEDON"); 
            if(IndicativecreditStatus!=null && Indicativecreditscore!=null && Createdon!=null && Updateon!=null) {
            System.out.println(IndicativecreditStatus+ ", " + Indicativecreditscore+" ," + Createdon + " ," + Updateon );
            }
            else {
            	System.out.println("Values are not present");
            }
       
        }
    }
    
    
    
    

    //   public static void main(String[] args)  throws SQLException, ClassNotFoundException{
    public String SetUpConnectionVHOS(String OpportunityID) throws SQLException, ClassNotFoundException {
        CommonFunctions functions = new CommonFunctions();
        ConfigReader config = new ConfigReader();
        Properties prop = config.init_properties();
        String VHOSDBQuery = prop.getProperty("VHOSPCQuery");
        // Register JDBC driver (JDBC driver name and Database URL)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Open a connection
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//txaixvhoss01:1521/vhoss", "VHOS0", "ShipleyIT11##");
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("Select opportunity_id,opportunityname,protected_class  from vhos0.OPPORTUNITY WHERE OPPORTUNITY_ID = '" + OpportunityID + "'");
        while (resultSet.next()) {
            String OptyID = resultSet.getString("OPPORTUNITY_ID");
            String OptyName = resultSet.getString("OPPORTUNITYNAME");
            String PCFlag = resultSet.getString("PROTECTED_CLASS");
           String  Brand=resultSet.getString("CONTRACT_BRAND");
            System.out.println(OptyID + ", " + OptyName + ", " + PCFlag+","+Brand);
            
            
        }
        String Status="Pass";
        return Status;
    }
    
    
    
    
//  public static void main(String[] args)  throws SQLException, ClassNotFoundException{
   public String SetUpConnectionVHOS1(String OpportunityID) throws SQLException, ClassNotFoundException {
       CommonFunctions functions = new CommonFunctions();
       ConfigReader config = new ConfigReader();
       Properties prop = config.init_properties();
       String VHOSDBQuery = prop.getProperty("VHOSPCQuery");
       // Register JDBC driver (JDBC driver name and Database URL)
       Class.forName("oracle.jdbc.driver.OracleDriver");

       // Open a connection
       conn = DriverManager.getConnection("jdbc:oracle:thin:@//txaixvhoss01:1521/vhoss", "VHOS1", "ShipleyIT11##");
       stmt = conn.createStatement();
       resultSet = stmt.executeQuery("Select opportunity_id,opportunityname,protected_class  from vhos1.OPPORTUNITY WHERE OPPORTUNITY_ID = '" + OpportunityID + "'");
       while (resultSet.next()) {
           String OptyID = resultSet.getString("OPPORTUNITY_ID");
           String OptyName = resultSet.getString("OPPORTUNITYNAME");
           String PCFlag = resultSet.getString("PROTECTED_CLASS");
          String  Brand=resultSet.getString("CONTRACT_BRAND");
           System.out.println(OptyID + ", " + OptyName + ", " + PCFlag+","+Brand);
           
           
       }
       String Status="Pass";
       return Status;
   }

public boolean SitevalidationVHOS(String Pod) throws SQLException, ClassNotFoundException {
    CommonFunctions functions = new CommonFunctions();
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
    String VHOSDBQuery = prop.getProperty("VHOSPCQuery");
    // Register JDBC driver (JDBC driver name and Database URL)
    Class.forName("oracle.jdbc.driver.OracleDriver");

    // Open a connection
    conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.140.125.165:1521/vhost", "VHOS0", "StarbucksIT11##");
    stmt = conn.createStatement();
    resultSet = stmt.executeQuery("Select * from SITE WHERE POD = '" + Pod + "'");
    while (resultSet.next()) {
        String SiteId = resultSet.getString("SITE_Id");
        String PodId = resultSet.getString("POD");         
        System.out.println(SiteId + ", " + PodId );
        
        return false;
    }
   

	return true;

}

String ESID;
String number;
public String PickESIDfromDB() throws SQLException, ClassNotFoundException {
    CommonFunctions functions = new CommonFunctions();
    ConfigReader config = new ConfigReader();
    Properties prop = config.init_properties();
    String DSPDBQuery = prop.getProperty("DSPPCQuery");
    String OptyID;
    String PCFlag;
    String Brand;
    
    
    for (int i = 1; i <= 5 ; i++)
    {
     int Random = (int)(Math.random()*50);
     number=String.valueOf(Random);
     System.out.println(number);
    }
    // Register JDBC driver (JDBC driver name and Database URL)
    Class.forName("oracle.jdbc.driver.OracleDriver");

    // Open a connection
    conn = DriverManager.getConnection("jdbc:oracle:thin:@//txaixebndbd02:1536/ECDBD02", "DSP_MAIN", "DSP#Ma1n#D3v02!");
    stmt = conn.createStatement();
    resultSet = stmt.executeQuery("Select ESID ,ANNUAL_USAGE,METER_TYPE,EDC from SITE where ANNUAL_USAGE >'" + number + "' by ANNUAL_USAGE ;");
    while (resultSet.next()) {
        ESID = resultSet.getString("ESID");
        System.out.println(ESID);

    }
    return ESID;
}

}



