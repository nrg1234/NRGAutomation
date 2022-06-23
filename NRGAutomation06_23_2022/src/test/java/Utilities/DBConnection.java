//package Utilities;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Random;
//import java.util.ArrayList;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
//import com.aventstack.extentreports.Status;
//
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//
//
//
//
//public class DBConnection   {
//	//WebDriver driver1;
//	//PutsBox PutsBox =new PutsBox(driver1);
//	 
//	
//	 ConfigReader config =  new ConfigReader();
//	 Properties prop = config.init_properties();
//	private static DBConnection dbConnection;
//	
//	/**
//	 * 
//	 * @return
//	 */
//	
//	public static DBConnection getInstance(){
//		if(dbConnection==null){
//			dbConnection= new DBConnection();
//		}
//		return dbConnection;
//	}
//	
//	
//	/**
//	 * 
//	 * @param marketerAssignedID
//	 * @param accountNo
//	 * @param company
//	 * @return
//	 */
//	public synchronized String validateNewEnrollmentInDatabase(String marketerAssignedID,String offerId,String accountNo,String company) {
//		String discoveryServerName = prop.getProperty("DiscoveryServerName");
//		String discoverydatabaseName = prop.getProperty("DiscoverydatabaseName");
//		String newEnrollmentQuery = prop.getProperty("NewEnrollmentQuery");
//		String url = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
//		String resultLog="";
//		Connection conn = null;
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn = DriverManager.getConnection(url);
//			Statement stmt = conn.createStatement();
//			System.out.println(newEnrollmentQuery+"'"+marketerAssignedID+"' AND ACCOUNTNO = '"+accountNo+"';");
//			ResultSet rs = stmt.executeQuery(newEnrollmentQuery+"'"+marketerAssignedID+"' AND ACCOUNTNO = '"+accountNo+"';");
//
//			while (rs.next()) {
//
//				if(rs.getString("MarketerAssignedID").trim().equalsIgnoreCase(marketerAssignedID.trim())) {
//					resultLog = resultLog + "<pre> MarketerAssignedID : "+marketerAssignedID+" matches with DB </pre>";
//				}else {
//					resultLog = resultLog + "<pre> MarketerAssignedID : "+marketerAssignedID+" doesn't match with DB </pre>";
//				}
//
//				if(rs.getString("EscoRatePlanOfferingKey").length()>0) {
//
//					String offerIdKey = rs.getString("EscoRatePlanOfferingKey");
//					resultLog = resultLog + "<pre> EscoRatePlanOfferingKey in DB : "+offerIdKey+" </pre>";
//					ratePlanOfferingQuery = ratePlanOfferingQuery.replace("_REPLACE_OFFER_ID_", offerIdKey);
//					Statement stmt1 = conn.createStatement();
//					ResultSet rs1 = stmt1.executeQuery(ratePlanOfferingQuery);
//
//					while(rs1.next()) {
//						resultLog = resultLog + "<pre> Rate Plan Description in DB : "+rs1.getString("Description")+" </pre>";
//						break;
//					}
//
//				}else {
//					resultLog = resultLog +"<pre> EscoRatePlanOfferingKey is empty in DB </pre>";
//				}
//
//				if(rs.getString("ACCOUNTNO").trim().equalsIgnoreCase(accountNo.trim())) {
//					resultLog = resultLog + "<pre> ACCOUNTNO : "+accountNo+" matches with DB </pre>";
//				}else {
//					resultLog = resultLog +"<pre> ACCOUNTNO : "+accountNo+" doesn't match with DB </pre>";
//				}
//
//				if(rs.getString("COMPANY").trim().equalsIgnoreCase(company.trim())) {
//					resultLog = resultLog + "<pre> COMPANY : "+company+" matches with DB </pre>";
//				}else {
//					resultLog = resultLog +"<pre> COMPANY : "+company+" doesn't match with DB </pre>";
//				}
//
//				if(rs.getString("FIXEDSTART").length()>0) {
//					resultLog = resultLog + "<pre> Enrollment Start Date in DB : "+rs.getString("FIXEDSTART")+" </pre>";
//				}else {
//					resultLog = resultLog + "<pre> Enrollment Start Date is empty in DB </pre>";
//				}
//
//				if(rs.getString("FIXEDEND").length()>0) {
//					resultLog = resultLog + "<pre> Enrollment End Date in DB : "+rs.getString("FIXEDEND")+" </pre>";
//				}else {
//					resultLog = resultLog + "<pre> Enrollment End Date is empty in DB </pre>";
//				}
//				if(rs.getString("Promotionskey").length()>0) {
//					resultLog = resultLog + "<pre> Promotionskey in DB : "+rs.getString("Promotionskey")+" </pre>";
//				}else {
//					resultLog = resultLog + "<pre> Promotionskey is empty in DB </pre>";
//				}
//			}
//			if(resultLog.length()<1){
//				resultLog = "NO RECORDS CREATED!!!";
//			}
//			conn.close();
//		} catch (Exception e) {
//			try {
//				conn.close();
//			} catch (Exception e1) {
//			}
//			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
//		}
//		return resultLog;
//	}
//
////	/**
////	 * 
////	 * @param marketerAssignedID
////	 * @param accountNo
////	 * @param company
////	 * @return
////	 */
////	public synchronized String validateNewEnrollmentInDatabaseForCT(String marketerAssignedID,String offerId,String accountNo,String company, String nameKey) {
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String newEnrollmentQuery = config.getProperty("CTNewEnrollmentQuery");
////		String ratePlanOfferingQuery = config.getProperty("RatePlanOfferingQuery");
////		String url = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////		String resultLog="";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(newEnrollmentQuery+"'"+marketerAssignedID+"' AND ACCOUNTNO = '"+accountNo+"';");
////			ResultSet rs = stmt.executeQuery(newEnrollmentQuery+"'"+marketerAssignedID+"' AND ACCOUNTNO = '"+accountNo+"';");
////
////			while (rs.next()) {
////
////				if(rs.getString("MarketerAssignedID").trim().equalsIgnoreCase(marketerAssignedID.trim())) {
////					resultLog = resultLog + "<pre> MarketerAssignedID : "+marketerAssignedID+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog + "<pre> MarketerAssignedID : "+marketerAssignedID+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("EscoRatePlanOfferingKey").length()>0) {
////
////					String offerIdKey = rs.getString("EscoRatePlanOfferingKey");
////					resultLog = resultLog + "<pre> EscoRatePlanOfferingKey in DB : "+offerIdKey+" </pre>";
////					ratePlanOfferingQuery = ratePlanOfferingQuery.replace("_REPLACE_OFFER_ID_", offerIdKey);
////					Statement stmt1 = conn.createStatement();
////					ResultSet rs1 = stmt1.executeQuery(ratePlanOfferingQuery);
////
////					while(rs1.next()) {
////						resultLog = resultLog + "<pre> Rate Plan Description in DB : "+rs1.getString("Description")+" </pre>";
////						break;
////					}
////
////				}else {
////					resultLog = resultLog +"<pre> EscoRatePlanOfferingKey is empty in DB </pre>";
////				}
////
////				if(rs.getString("ACCOUNTNO").trim().equalsIgnoreCase(accountNo.trim())) {
////					resultLog = resultLog + "<pre> ACCOUNTNO : "+accountNo+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog +"<pre> ACCOUNTNO : "+accountNo+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("COMPANY").trim().equalsIgnoreCase(company.trim())) {
////					resultLog = resultLog + "<pre> COMPANY : "+company+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog +"<pre> COMPANY : "+company+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("NameKey").trim().equalsIgnoreCase(nameKey.trim())) {
////					resultLog = resultLog + "<pre> NAMEKEY : "+nameKey+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog +"<pre> NAMEKEY : "+nameKey+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("FIXEDSTART").length()>0) {
////					resultLog = resultLog + "<pre> Enrollment Start Date in DB : "+rs.getString("FIXEDSTART")+" </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Enrollment Start Date is empty in DB </pre>";
////				}
////
////				if(rs.getString("FIXEDEND").length()>0) {
////					resultLog = resultLog + "<pre> Enrollment End Date in DB : "+rs.getString("FIXEDEND")+" </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Enrollment End Date is empty in DB </pre>";
////				}
////				if(rs.getString("Promotionskey").length()>0) {
////					resultLog = resultLog + "<pre> Promotionskey in DB : "+rs.getString("Promotionskey")+" </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Promotionskey is empty in DB </pre>";
////				}
////			}
////			if(resultLog.length()<1){
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////		} catch (Exception e) {
////			try {
////				conn.close();
////			} catch (Exception e1) {
////			}
////			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////		}
////		return resultLog;
////	}
////
////	/**
////	 * 
////	 * @param confirmationId
////	 * @param accountNo
////	 * @param campaignKey
////	 * @return
////	 */
////	public synchronized String validateChooseAgainOrRenewContractInDatabase(String confirmationId,String offerId,String accountNo,String campaignKey) {
////
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String chooseAgainQuery = config.getProperty("ChooseAgainOrRenewQuery");
////		String ratePlanOfferingQuery = config.getProperty("RatePlanOfferingQuery");
////		String url = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////		String resultLog="";
////		chooseAgainQuery = chooseAgainQuery.replace("REPLACE_ACCOUNT_NUMBER", accountNo).replace("REPLACE_CONFIRMATION_NUMBER", confirmationId);
////
////		System.out.println(chooseAgainQuery);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			ResultSet rs = stmt.executeQuery(chooseAgainQuery);
////
////			while (rs.next()) {
////
////				if(rs.getString("ConfirmationID").trim().equalsIgnoreCase(confirmationId.trim())) {
////					resultLog = resultLog + "<pre> ConfirmationID : "+confirmationId+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog + "<pre> ConfirmationID : "+confirmationId+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("EscoRatePlanOfferingKey").length()>0) {
////
////					String offerIdKey = rs.getString("EscoRatePlanOfferingKey");
////					resultLog = resultLog + "<pre> EscoRatePlanOfferingKey in DB : "+offerIdKey+" </pre>";
////					ratePlanOfferingQuery = ratePlanOfferingQuery.replace("_REPLACE_OFFER_ID_", offerIdKey);
////					Statement stmt1 = conn.createStatement();
////					ResultSet rs1 = stmt1.executeQuery(ratePlanOfferingQuery);
////
////					while(rs1.next()) {
////						resultLog = resultLog + "<pre> Rate Plan Description in DB : "+rs1.getString("Description")+" </pre>";
////						break;
////					}
////
////				}else {
////					resultLog = resultLog +"<pre> EscoRatePlanOfferingKey is empty in DB </pre>";
////				}
////
////				if(rs.getString("ACCOUNTNO").trim().equalsIgnoreCase(accountNo.trim())) {
////					resultLog = resultLog + "<pre> ACCOUNTNO : "+accountNo+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog +"<pre> ACCOUNTNO : "+accountNo+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("FromDateTime").length()>0) {
////					resultLog = resultLog + "<pre> Enrollment Start Date in DB : "+rs.getString("FromDateTime")+" </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Enrollment Start Date is empty in DB </pre>";
////				}
////
////				if(rs.getString("ThruDateTime").length()>0) {
////					resultLog = resultLog + "<pre> Enrollment End Date in DB : "+rs.getString("ThruDateTime")+" </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Enrollment End Date is empty in DB </pre>";
////				}
////
////				if(rs.getString("EscoRatePlanOfferingKey").length()>0) {
////					resultLog = resultLog + "<pre> EscoRatePlanOfferingKey in DB : "+rs.getString("EscoRatePlanOfferingKey")+" </pre>";
////				}else {
////					resultLog = resultLog +"<pre> EscoRatePlanOfferingKey is empty in DB </pre>";
////				}
////			}
////			if(resultLog.length()<1){
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				conn.close();
////			} catch (Exception e1) {
////				e1.printStackTrace();
////			}
////			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////		}
////		return resultLog;
////	}
////
////
////
////	/**
////	 * 
////	 * Method Name : fetchChooseAgainAccountNoAndZip
////	 * Description : 
////	 * Author      : 
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Oct 31, 2017
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchChooseAgainAccountNoAndZip(Commodity commodity,Utility utilityName,UtilityState state) {
////
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String chooseAgainDataFetchQuery = config.getProperty("ChooseAgainDataFetchQuery");
////
////		String dbAccountNo="";
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String chooseAgainDiscoveryQuery = config.getProperty("ChooseAgainDiscoveryQuery");
////
////		chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_COMMODITY", commodity.toString());
////		chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_UTILITY", utilityName.toString());
////		chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_STATE", state.toString());
////
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		String discoveryUrl = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////
////		String renewalAndChooseAdditionalChecks1 = config.getProperty("RenewalAndChooseAdditionalChecks1");
////		String renewalAndChooseAdditionalChecks2 = config.getProperty("RenewalAndChooseAdditionalChecks2");
////
////		Connection connDigital = null;
////		Connection connDiscovery = null;
////
////		String chooseAgainDiscoveryQuery1;
////		String chooseAgainDiscoveryQuery2;
////		String chooseAgainDiscoveryQuery3;
////		int count1,count2,count3;
////
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////			connDiscovery = DriverManager.getConnection(discoveryUrl);
////
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connDiscovery.createStatement();
////			Statement stmt2 = connDiscovery.createStatement();
////			Statement stmt3 = connDiscovery.createStatement();
////
////			ResultSet rs = stmt.executeQuery(chooseAgainDataFetchQuery);
////			ResultSet rs1;
////			ResultSet rs2;
////			ResultSet rs3;
////			while (rs.next()) {
////
////				count1 = 0;
////				count2 = 0;
////				count3 = 0;
////				dbAccountNo =  rs.getString("UDCNUMBER");
////				System.out.println(dbAccountNo);
////
////				chooseAgainDiscoveryQuery1 = chooseAgainDiscoveryQuery.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs1 = stmt1.executeQuery(chooseAgainDiscoveryQuery1);
////
////				chooseAgainDiscoveryQuery2 = renewalAndChooseAdditionalChecks1.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs2 = stmt2.executeQuery(chooseAgainDiscoveryQuery2);
////
////				chooseAgainDiscoveryQuery3 = renewalAndChooseAdditionalChecks2.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs3 = stmt3.executeQuery(chooseAgainDiscoveryQuery3);
////
////				while (rs1.next()) {
////					++count1;
////				}
////
////				while (rs2.next()) {
////					++count2;
////				}
////
////				while (rs3.next()) {
////					++count3;	
////				}
////				System.out.println("count1 : "+count1+"count2 : "+count2+"count3 : "+count3);
////				if(count1>0 && count2 >0 && count3 > 0) {
////					records.put("ZIP", rs.getString("ZIP"));
////					records.put("UDCNUMBER", rs.getString("UDCNUMBER"));
////					records.put("UTILITY NAME", rs.getString("UTILITY NAME"));
////					records.put("COMPANYNAME", rs.getString("COMPANYNAME"));
////					System.out.println("ZIP: "+rs.getString("ZIP")+" Account Number :"+rs.getString("UDCNUMBER")+" Utility Name :"+rs.getString("UTILITY NAME"));
////
////					break;
////				}
////			}
////			connDigital.close();
////			connDiscovery.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connDigital.close();
////				connDiscovery.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	public synchronized Map<String, String> fetchChooseAgainAccountNoAndZip1() {
////
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String chooseAgainDataFetchQuery = config.getProperty("ChooseAgainDataFetchQuery1");
////
////		String dbAccountNo="";
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String chooseAgainDiscoveryQuery = config.getProperty("ChooseAgainDiscoveryQuery");
////
////		/*chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_COMMODITY", commodity.toString());
////		chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_UTILITY", utilityName.toString());
////		chooseAgainDataFetchQuery = chooseAgainDataFetchQuery.replace("REPLACE_STATE", state.toString());*/
////
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		String discoveryUrl = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////
////		String renewalAndChooseAdditionalChecks1 = config.getProperty("RenewalAndChooseAdditionalChecks1");
////		String renewalAndChooseAdditionalChecks2 = config.getProperty("RenewalAndChooseAdditionalChecks2");
////
////		Connection connDigital = null;
////		Connection connDiscovery = null;
////
////		String chooseAgainDiscoveryQuery1;
////		String chooseAgainDiscoveryQuery2;
////		String chooseAgainDiscoveryQuery3;
////		int count1,count2,count3;
////
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////			connDiscovery = DriverManager.getConnection(discoveryUrl);
////
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connDiscovery.createStatement();
////			Statement stmt2 = connDiscovery.createStatement();
////			Statement stmt3 = connDiscovery.createStatement();
////
////			ResultSet rs = stmt.executeQuery(chooseAgainDataFetchQuery);
////			ResultSet rs1;
////			ResultSet rs2;
////			ResultSet rs3;
////			while (rs.next()) {
////
////				count1 = 0;
////				count2 = 0;
////				count3 = 0;
////				dbAccountNo =  rs.getString("UDCNUMBER");
////				System.out.println(dbAccountNo);
////
////				chooseAgainDiscoveryQuery1 = chooseAgainDiscoveryQuery.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs1 = stmt1.executeQuery(chooseAgainDiscoveryQuery1);
////
////				chooseAgainDiscoveryQuery2 = renewalAndChooseAdditionalChecks1.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs2 = stmt2.executeQuery(chooseAgainDiscoveryQuery2);
////
////				chooseAgainDiscoveryQuery3 = renewalAndChooseAdditionalChecks2.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs3 = stmt3.executeQuery(chooseAgainDiscoveryQuery3);
////
////				while (rs1.next()) {
////					++count1;
////				}
////
////				while (rs2.next()) {
////					++count2;
////				}
////
////				while (rs3.next()) {
////					++count3;	
////				}
////				System.out.println("count1 : "+count1+"count2 : "+count2+"count3 : "+count3);
////				if(count1>0 && count2 >0 && count3 > 0) {
////					records.put("ZIP", rs.getString("ZIP"));
////					records.put("UDCNUMBER", rs.getString("UDCNUMBER"));
////					records.put("UTILITY NAME", rs.getString("UTILITY NAME"));
////					records.put("COMPANYNAME", rs.getString("COMPANYNAME"));
////					System.out.println("ZIP: "+rs.getString("ZIP")+" Account Number :"+rs.getString("UDCNUMBER")+" Utility Name :"+rs.getString("UTILITY NAME"));
////
////					break;
////				}
////			}
////			connDigital.close();
////			connDiscovery.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connDigital.close();
////				connDiscovery.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchRenewalAccountNoAndZip
////	 * Description : 
////               :
////	 * Author      : 
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Oct 31, 2017
////	 * Version     : 1.0
////	 */
////	public synchronized Map<String, String> fetchRenewalAccountNoAndZip(Commodity commodity,Utility utilityName,UtilityState state) {
////
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String renewalDataFetchQuery = config.getProperty("RenewalDataFetchQuery");
////
////		String dbAccountNo="";
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String renewalDiscoveryQuery = config.getProperty("RenewalDiscoveryQuery");
////
////		String renewalAndChooseAdditionalChecks1 = config.getProperty("RenewalAndChooseAdditionalChecks1");
////		String renewalAndChooseAdditionalChecks2 = config.getProperty("RenewalAndChooseAdditionalChecks2");
////
////		renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_COMMODITY", commodity.toString());
////		renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_UTILITY", utilityName.toString());
////		renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_STATE", state.toString());
////
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		String discoveryUrl = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////
////		Connection connDigital = null;
////		Connection connDiscovery = null;
////		String renewalDiscoveryQuery1;
////		String renewalDiscoveryQuery2;
////		String renewalDiscoveryQuery3;
////		int count1,count2,count3;
////
////		try {
////
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////			connDiscovery = DriverManager.getConnection(discoveryUrl);
////
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connDiscovery.createStatement();
////			Statement stmt2 = connDiscovery.createStatement();
////			Statement stmt3 = connDiscovery.createStatement();
////
////			ResultSet rs = stmt.executeQuery(renewalDataFetchQuery);
////			ResultSet rs1;
////			ResultSet rs2;
////			ResultSet rs3;
////			System.out.println(renewalDataFetchQuery);
////			while (rs.next()) {
////
////				count1 = 0;
////				count2 = 0;
////				count3 = 0;
////
////				dbAccountNo =  rs.getString("UDCNUMBER");
////
////				renewalDiscoveryQuery1 = renewalDiscoveryQuery.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs1 = stmt1.executeQuery(renewalDiscoveryQuery1);
////
////				renewalDiscoveryQuery2 = renewalAndChooseAdditionalChecks1.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs2 = stmt2.executeQuery(renewalDiscoveryQuery2);
////
////				renewalDiscoveryQuery3 = renewalAndChooseAdditionalChecks2.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs3 = stmt3.executeQuery(renewalDiscoveryQuery3);
////
////				while (rs1.next()) {
////					++count1;
////				}
////
////				while (rs2.next()) {
////					++count2;
////				}
////
////				while (rs3.next()) {
////					++count3;	
////				}
////				System.out.println("count1 : "+count1+"count2 : "+count2+"count3 : "+count3);
////				if(count1> 0 && count2 > 0 && count3 > 0) {
////					records.put("ZIP", rs.getString("ZIP"));
////					records.put("UDCNUMBER", rs.getString("UDCNUMBER"));
////					records.put("UTILITY NAME", rs.getString("UTILITY NAME"));
////					records.put("COMPANYNAME", rs.getString("COMPANYNAME"));
////					System.out.println("ZIP: "+rs.getString("ZIP")+" Account Number :"+rs.getString("UDCNUMBER")+" Utility Name :"+rs.getString("UTILITY NAME"));
////					break;
////				}
////			}
////			connDiscovery.close();
////			connDigital.close();
////			return records;
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connDigital.close();
////				connDiscovery.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	public synchronized Map<String, String> fetchRenewalAccountNoAndZip1() {
////
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String renewalDataFetchQuery = config.getProperty("RenewalDataFetchQuery1");
////
////		String dbAccountNo="";
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String renewalDiscoveryQuery = config.getProperty("RenewalDiscoveryQuery");
////
////		String renewalAndChooseAdditionalChecks1 = config.getProperty("RenewalAndChooseAdditionalChecks1");
////		String renewalAndChooseAdditionalChecks2 = config.getProperty("RenewalAndChooseAdditionalChecks2");
////
////		/*renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_COMMODITY", commodity.toString());
////		renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_UTILITY", utilityName.toString());
////		renewalDataFetchQuery = renewalDataFetchQuery.replace("REPLACE_STATE", state.toString());*/
////
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		String discoveryUrl = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////
////		Connection connDigital = null;
////		Connection connDiscovery = null;
////		String renewalDiscoveryQuery1;
////		String renewalDiscoveryQuery2;
////		String renewalDiscoveryQuery3;
////		int count1,count2,count3;
////
////		try {
////
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////			connDiscovery = DriverManager.getConnection(discoveryUrl);
////
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connDiscovery.createStatement();
////			Statement stmt2 = connDiscovery.createStatement();
////			Statement stmt3 = connDiscovery.createStatement();
////
////			ResultSet rs = stmt.executeQuery(renewalDataFetchQuery);
////			ResultSet rs1;
////			ResultSet rs2;
////			ResultSet rs3;
////			System.out.println(renewalDataFetchQuery);
////			while (rs.next()) {
////
////				count1 = 0;
////				count2 = 0;
////				count3 = 0;
////
////				dbAccountNo =  rs.getString("UDCNUMBER");
////
////				renewalDiscoveryQuery1 = renewalDiscoveryQuery.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs1 = stmt1.executeQuery(renewalDiscoveryQuery1);
////
////				renewalDiscoveryQuery2 = renewalAndChooseAdditionalChecks1.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs2 = stmt2.executeQuery(renewalDiscoveryQuery2);
////
////				renewalDiscoveryQuery3 = renewalAndChooseAdditionalChecks2.replace("_REPLACE_ACCOUNT_NUMBER_", dbAccountNo);
////				rs3 = stmt3.executeQuery(renewalDiscoveryQuery3);
////
////				while (rs1.next()) {
////					++count1;
////				}
////
////				while (rs2.next()) {
////					++count2;
////				}
////
////				while (rs3.next()) {
////					++count3;	
////				}
////				System.out.println("count1 : "+count1+"count2 : "+count2+"count3 : "+count3);
////				if(count1> 0 && count2 > 0 && count3 > 0) {
////					records.put("ZIP", rs.getString("ZIP"));
////					records.put("UDCNUMBER", rs.getString("UDCNUMBER"));
////					records.put("UTILITY NAME", rs.getString("UTILITY NAME"));
////					records.put("COMPANYNAME", rs.getString("COMPANYNAME"));
////					System.out.println("ZIP: "+rs.getString("ZIP")+" Account Number :"+rs.getString("UDCNUMBER")+" Utility Name :"+rs.getString("UTILITY NAME"));
////					break;
////				}
////			}
////			connDiscovery.close();
////			connDigital.close();
////			return records;
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connDigital.close();
////				connDiscovery.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////
////
////	public synchronized Map<String, String> fetchAccountNumberAndZipWithCustomerName(AccountType accountType,AccountStatus accountStatus) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String retrieveAccountNoAndZipQuery = config.getProperty("RetrieveAccountNoAndZip");
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		Connection connDigital = null;
////
////		try {
////
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////
////			Statement stmt = connDigital.createStatement();
////			retrieveAccountNoAndZipQuery = retrieveAccountNoAndZipQuery.replace("_REPLACE_BILLING_SOURCE_", accountType.toString()).replace("_REPLACE_SHIP_TO_STATUS_", accountStatus.toString());
////			if(accountType.toString().equals("APOLLO")) {
////				retrieveAccountNoAndZipQuery = retrieveAccountNoAndZipQuery.replace("order by NEWID();"," and StatementGroupID is not null order by NEWID();");
////			}
////			
////			
////			ResultSet rs = stmt.executeQuery(retrieveAccountNoAndZipQuery);
////
////			while (rs.next()) {
////				records.put("ZIP", rs.getString("ShipToBillZip"));
////				if(accountType.toString().equals("APOLLO")) {
////					records.put("AccountNumber", rs.getString("StatementGroupID"));
////				}else if(accountType.toString().equals("ERM")) {
////					records.put("AccountNumber", rs.getString("AccountNumber"));
////				}else if(accountType.toString().equals("RM")) {
////					records.put("AccountNumber", rs.getString("AccountNumber"));
////				}else if(accountType.toString().equals("Discovery")){
////					records.put("AccountNumber", rs.getString("UtilityAccountNumber"));	
////				}
////				records.put("CustomerName", rs.getString("StandardCompanyName"));
////				break;
////			}
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connDigital.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////
////	public void fetchCustomerName() {
////
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchContactInformationDetails
////	 * Description : The method to fetch Contact Information panel content
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchContactInformationDetails(String salesChannel,String contractId) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("CustomerRenewalDataFetchQuery");
////		String customerRenewalDataQuery = newQuery+" renew.SalesChannel='"+salesChannel+"'"+" and renew.ContractID='"+contractId+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(customerRenewalDataQuery);
////			ResultSet rs = stmt.executeQuery(customerRenewalDataQuery);
////
////			while (rs.next()) {
////				records.put("CompanyName", rs.getString("StandardCompanyName").trim());			
////				//records.put("CompanyContactName", rs.getString("CustomerName").trim());
////				records.put("utilityAccountNumber", rs.getString("UtilityAccountNumber").trim());
////				try {
////					records.put("EmailAddress", rs.getString("CustomerEmail").trim());
////				}catch (Exception e) {
////				}
////				records.put("PhoneNumber", rs.getString("CustomerPhone").trim());
////				records.put("zipCode1", FetchShipToBillZipfromDigitalBD(rs.getString("AccountNumber"),"SoldToBillZip"));
////				records.put("StandardCompanyName", FetchCustomerNamefromDigitalBD(rs.getString("AccountNumber")).trim());
////				records.put("accoutNumber", rs.getString("AccountNumber").trim());
////				String shiptoBillzip=FetchShipToBillZipfromDigitalBD(rs.getString("AccountNumber"),"ShipToBillZip");
////				if(shiptoBillzip.split("-")[0].trim().length()>0) {
////					records.put("zipCode", shiptoBillzip.split("-")[0].trim());
////				}
////				
////				else {
////					records.put("zipCode", shiptoBillzip);
////				}
////				try {
////					records.put("brokerName", rs.getString("BrokerName").trim());
////				}catch (Exception e) {
////				}
////				records.put("lastName", rs.getString("LastName").trim());
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchContractRenewalPriceBasePriceAndAncillaryPrice
////	 * Description : The method to fetch Your cart details panel content
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : Oct 15, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchContractRenewalPriceBasePriceAndAncillaryPrice(String contractId,String term) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String renewalPriceQuery = "select *from ContractRenewalPrice where ContractID='"+contractId+"'" +" and Term='"+term+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(renewalPriceQuery);
////			ResultSet rs = stmt.executeQuery(renewalPriceQuery);
////
////			while (rs.next()) {
////				records.put("basePrice", rs.getString("BasePrice").trim());
////				records.put("ancillaryCharge", rs.getString("AncillaryCharge").trim());
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : validateReenwalFinalPricesInDatabase
////	 * Description : The method to validate Base and Ancillary pricesPrices In Database
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : Oct 15, 2018
////	 * Version     : 1.0
////	 */
////
////	public String validateRenwalFinalPricesInDatabase(String basePrice,String AncillaryPrice, String strContractId,String term) {
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ContractRenewalFinalPrice");
////		String finalPriceQuery = newQuery+" ContractID='"+strContractId+"'" +" and Term='"+term+"'";;
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		String resultLog="";
////		Connection conn = null;
////		float expectedPrice,actualPrice;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(finalPriceQuery);
////			ResultSet rs = stmt.executeQuery(finalPriceQuery);
////			String resultLogPrice = null;
////			while (rs.next()) {				
////				resultLogPrice = rs.getString("Price").trim();
////				expectedPrice = Float.parseFloat(resultLogPrice);
////				actualPrice = Float.parseFloat(basePrice)+Float.parseFloat(AncillaryPrice);
////				
////				if(actualPrice==expectedPrice) {
////					resultLog = resultLog + "<pre> Sum of Base Price and Ancillary Price : "+actualPrice+" matches with DB </pre>";
////					break;
////				}else {
////					resultLog = resultLog + "<pre> Sum of Base Price and Ancillary Price: "+actualPrice+" doesn't match with DB </pre>";
////					System.out.println("doesn't match with DB");
////				}
////				
////			}
////			if(resultLog.length()<1){
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////		} catch (Exception e) {
////			try {
////				conn.close();
////			} catch (Exception e1) {
////			}
////
////			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////		}
////		return resultLog;
////
////	}
////
////	
////	
////	/**
////	 * 
////	 * Method Name : fetchYourCartDetails
////	 * Description : The method to fetch Your cart details panel content
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchYourCartDetails(String contractId) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ContractRenewalPrice");
////		String PriceQuery = newQuery+" ContractID='"+contractId+"'"+"), 107) AS 'FormattedDate'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(PriceQuery);
////			ResultSet rs = stmt.executeQuery(PriceQuery);
////
////			while (rs.next()) {
////				records.put("RenewalStartDate", rs.getString("FormattedDate").trim());
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchYourServiceDetails
////	 * Description : The method to fetch Your Service details panel content
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchYourServiceDetails(String companyName,String accountNumber) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ServiceDetails");
////		String serviceDetailsQuery = newQuery+" standardcompanyname='"+companyName+"'"+"and AccountNumber='"+accountNumber+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		System.out.println(serviceDetailsQuery);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(serviceDetailsQuery);
////			ResultSet rs = stmt.executeQuery(serviceDetailsQuery);
////
////			while (rs.next()) {
////
////				records.put("ServiceStreet", rs.getString("StandardServLocAddress1").trim());
////				records.put("ServiceCity", rs.getString("StandardServLocCity").trim());
////				records.put("ServiceState", rs.getString("StandardServLocState").trim());
////				//records.put("ServiceZip", rs.getString("StandardServLocZip").split("-")[0].trim());
////				if(rs.getString("StandardServLocZip").split("-")[0].trim().length()>0) {
////					records.put("ServiceZip", rs.getString("StandardServLocZip").split("-")[0].trim());
////				}else {
////					records.put("ServiceZip", rs.getString("StandardServLocZip").split("-")[0].trim());
////				}
////
////				records.put("BillStreet", rs.getString("ShipToBillStreet").trim());
////				records.put("BillCity", rs.getString("ShipToBillCity").trim());
////				records.put("BillState", rs.getString("ShipToBillState").trim());
////				//records.put("BillZip", rs.getString("ShipToBillZip").trim());
////				if(rs.getString("ShipToBillZip").split("-")[0].trim().length()>0) {
////					records.put("BillZip", rs.getString("ShipToBillZip").split("-")[0].trim());
////				}else {
////					records.put("BillZip", rs.getString("ShipToBillZip").trim());
////				}
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchYourServiceDetailsMultiple
////	 * Description : The method to fetch Your Service details panel content
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchYourServiceDetailsMultiple(String companyName,List<String> accountNumberArray) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ServiceDetails");
////
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////
////		Connection conn = null;
////		int count=1;
////		for(String accountNumber: accountNumberArray) {
////			try {
////
////				String serviceDetailsQuery = newQuery+" standardcompanyname='"+companyName+"'"+"and UtilityAccountNumber='"+accountNumber+"'";
////				System.out.println(serviceDetailsQuery);
////				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////				conn = DriverManager.getConnection(url);
////				Statement stmt = conn.createStatement();
////				System.out.println(serviceDetailsQuery);
////				ResultSet rs = stmt.executeQuery(serviceDetailsQuery);
////				String hashMapKeyPrefix = "Entry";
////				hashMapKeyPrefix = hashMapKeyPrefix+Integer.toString(count);
////
////				while (rs.next()) {
////
////					records.put(hashMapKeyPrefix+"ServiceStreet", rs.getString("StandardServLocAddress1").trim());
////					records.put(hashMapKeyPrefix+"ServiceCity", rs.getString("StandardServLocCity").trim());
////					records.put(hashMapKeyPrefix+"ServiceState", rs.getString("StandardServLocState").trim());
////					records.put(hashMapKeyPrefix+"ServiceZip", rs.getString("StandardServLocZip").split("-")[0].trim());
////
////					records.put(hashMapKeyPrefix+"BillStreet", rs.getString("ShipToBillStreet").trim());
////					records.put(hashMapKeyPrefix+"BillCity", rs.getString("ShipToBillCity").trim());
////					records.put(hashMapKeyPrefix+"BillState", rs.getString("ShipToBillState").trim());
////					records.put(hashMapKeyPrefix+"BillZip", rs.getString("ShipToBillZip").trim());
////					break;
////				}
////
////
////			} catch (Exception e) {
////				e.printStackTrace();
////				try {
////					records.put("KEY", "NOT_FOUND");
////					conn.close();
////				} catch (Exception e1) {
////
////				}
////			}
////
////			count++;
////		}
////		try {
////			conn.close();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : validateContactInfoAfterEdit
////	 * Description : The method to validate Edited contact info in DB
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized String validateContactInfoAfterEdit(String salesChannel,String contractId,String email,String phoneNumber) {
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("CustomerRenewalDataFetchQuery");
////		String customerRenewalDataQuery = newQuery+" SalesChannel='"+salesChannel+"'"+" and ContractID='"+contractId+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		String resultLog="";
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(customerRenewalDataQuery);
////			ResultSet rs = stmt.executeQuery(customerRenewalDataQuery);
////
////			while (rs.next()) {
////
////				if(rs.getString("CustomerEmail").trim().equalsIgnoreCase(email.trim())) {
////					resultLog = resultLog + "<pre> Customer email : "+email+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Customer email : "+email+" doesn't match with DB </pre>";
////				}
////
////				if(rs.getString("CustomerPhone").trim().equalsIgnoreCase(phoneNumber.trim())) {
////					resultLog = resultLog + "<pre> Customer Phone : "+phoneNumber+" matches with DB </pre>";
////				}else {
////					resultLog = resultLog + "<pre> Customer Phone : "+phoneNumber+" doesn't match with DB </pre>";
////				}
////
////			}
////
////			if(resultLog.length()<1){
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////		} catch (Exception e) {
////			try {
////				conn.close();
////			} catch (Exception e1) {
////			}
////
////			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////		}
////		return resultLog;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchContactInformationDetails
////	 * Description : The method to fetch SalesChannel and ContractId
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 25, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchSalesChannelAndContractId(String commonQuery) {
////
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String customerRenewalDataQuery = commonQuery;
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(customerRenewalDataQuery);
////			ResultSet rs = stmt.executeQuery(customerRenewalDataQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////	
////            int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				records.put("contractId", rs.getString("ContractId").trim());			
////				records.put("salesChannel", rs.getString("SalesChannel").trim());
////				break;
////				}
////				count ++;
////				
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////
////	}
////	
////	public String valueTrim(String value)
////	{		
////		double price = Double.parseDouble(value);
////		price = price * 100;
////		double roundOff = Math.round(price * 100.0) / 100.0; 
////
////		String priceRoundedOff = Double.toString(roundOff);
////		
////		return priceRoundedOff;
////	}
////
////	/**
////	 * 
////	 * Method Name : validatePricesTermInDatabase
////	 * Description : The method to validate Prices In Database
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 27, 2018
////	 * Version     : 1.0
////	 */
////
////	public String validatePricesTermInDatabase(String[] prices, String strContractId) {
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ContractRenewalFinalPrice");
////		String finalPriceQuery = newQuery+" ContractID='"+strContractId+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		String resultLog="";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(finalPriceQuery);
////			ResultSet rs = stmt.executeQuery(finalPriceQuery);
////			String resultLogPrice = null;
////			int position=1;
////			while (rs.next()) {
////
////				//resultLogPrice = rs.getString("Price").trim();
////				resultLogPrice = valueTrim(rs.getString("Price"));
////				String priceLocal = prices[position].trim();
////				for(int i = 0; i < prices.length; i++) {
////					String pr = prices[i].trim();
////				    if( resultLogPrice.equalsIgnoreCase(pr) ) {
////				    	resultLog = resultLog + "<pre> Prices : "+prices[position]+" matches with DB </pre>";
////						position++;
////						continue;
////					}else {
////						resultLog = resultLog + "<pre> Prices : "+resultLogPrice+" doesn't match with DB </pre>";
////						System.out.println("doesn't match with DB");
////					}
////				}
////				//if(rs.getString("Price").trim().equalsIgnoreCase(prices[position].trim())) {
////					
////				position++;
////			}
////
////			if(resultLog.length()<1){
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////		} catch (Exception e) {
////			try {
////				conn.close();
////			} catch (Exception e1) {
////			}
////
////			return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////		}
////		return resultLog;
////
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchPrice
////	 * Description : The method to validate Prices In Database
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : July 27, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchPrice(String strContractId,String term) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("ContractRenewalFinalPrice");
////		String finalPriceQuery = newQuery+" ContractID='"+strContractId+"'"+" and Term='"+term+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(finalPriceQuery);
////			ResultSet rs = stmt.executeQuery(finalPriceQuery);
////			while (rs.next()) {
////				records.put("price", rs.getString("Price").trim());
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////
////	}
////
////	/**
////	 * 
////	 * Method Name : getOfferIdAndDEHQSubmissionStatus
////	 * Description : The method to get Offer ID and DEHQ submission Status
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : Oct 15, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> getOfferIdAndDEHQSubmissionStatus(String strContractId) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String offerIDQuery = "declare @contractId varchar(20) set @contractId = '"+strContractId+"' declare @offerId varchar(20)  set @offerId = "
////				+ "(select top 1 PK_OfferId from enrollment.offer with(nolock)" + 
////				"join [Enrollment].[Contract] with(nolock) on pk_offerid = fk_offerid where ContractId=@contractId order by 1 desc)" + 
////				"select * from enrollment.offerstatus with(nolock) where FK_OfferId=@offerId";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(offerIDQuery);
////			ResultSet rs = stmt.executeQuery(offerIDQuery);
////			while (rs.next()) {
////				records.put("offerId", rs.getString("FK_OfferId").trim());
////				records.put("submissionStatus", rs.getString("SubmissionStatus").trim());
////				System.out.println("Submission Status:"+rs.getString("SubmissionStatus").trim());
////				records.put("errorMessage", rs.getString("ErrorMessage").trim());
////				System.out.println("Error Message from record Set:"+rs.getString("ErrorMessage").trim());
////				System.out.println("Error Message from Map set:"+records.get("errorMessage").trim());
////				
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////
////	}
////
////	/**
////	 * 
////	 * Method Name : updateOfferId
////	 * Description : The method to get Offer ID and DEHQ submission Status
////	 * Author      : Mnagaraj
////	 * Parameters  : commodity 
////	 * Date        : Oct 15, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> updateOfferId(String offerID) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String UpdateOfferIDQuery = "update enrollment.salesentity set FirstName='Frank', lastname='Sohn', SourceId ='101162' where FK_OfferId='"+offerID+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(UpdateOfferIDQuery);
////			ResultSet rs = stmt.executeQuery(UpdateOfferIDQuery);
////			while (rs.next()) {
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////
////	}
////
////	/**
////	 * 
////	 * Method Name : getMultipleElectricUtilityAccountNumberfrom DB
////	 * Description : This retrieves the electric account number from the application
////	 * Author      : Mnagaraj
////	 * Return Types: String
////	 * Paramters   : None
////	 * Date        : July 20, 2018
////	 * Version     : 1.0
////	 */
////
////	public List<String> getMultipleElectricUtilityAccountNumber(String salesChannel,String strContractId) {
////
////		String digitalServerName = config.getProperty("DigitalDBServerName");
////		String digitaldatabaseName = config.getProperty("DigitalDBdatabaseName"); 
////		String newQuery = config.getProperty("CustomerRenewalDataFetchQuery");
////		String customerRenewalDataQuery = newQuery+" SalesChannel='"+salesChannel+"'"+" and ContractID='"+strContractId+"'";
////		String url = "jdbc:sqlserver://"+digitalServerName+";databaseName="+digitaldatabaseName+";integratedSecurity=true";
////		System.out.println(url);
////		List<String> listOfAccounts = new ArrayList<String>();
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(customerRenewalDataQuery);
////			ResultSet rs = stmt.executeQuery(customerRenewalDataQuery);
////			while (rs.next()) {
////
////				String accountNo = rs.getString("UtilityAccountNumber").trim();
////				listOfAccounts.add(accountNo);	
////			}
////			conn.close();
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return listOfAccounts;
////	}
////
////	public String printAccountNoInLog(List<String> listOfAccountNo) {
////		String log="";
////		for(String element: listOfAccountNo) {
////			log=log+element+" ";
////		}
////		return log;
////
////	}
////
////
////	public synchronized Map<String, String> retrieveIntentEnrollmentID(String environment, Map<String, String>  parameters) throws JSONException,InterruptedException
////	{
////
////		//Initializing Rest API's URL
////		String APIUrl = environment+"/api/EnrollmentCart/v1/ExistingCustomer/CheckEligibility";
////		System.out.println(parameters);
////		System.out.println(APIUrl);
////		Response response = RestAssured.given()
////				.headers("WebId", "sitecore\\organicapi")
////				.formParam("LastName", parameters.get("LastName"))
////				.formParam("UtilityAccountNumber", parameters.get("UtilityAccountNumber"))
////				.formParam("ZipCode", parameters.get("Zipcode"))
////				.formParam("UtilityCode", parameters.get("UtilityCode"))
////				.when().post(APIUrl);
////
////		String responseBody = response.getBody().asString();
////		JsonPath jsonPath = new JsonPath(responseBody);
////		System.out.println(responseBody);
////		String eligibleIntent = jsonPath.getString("EligibleIntent");		
////		String enrollmentId = jsonPath.getString("EnrollmentId");
////		System.out.println(eligibleIntent);
////		System.out.println(enrollmentId);
////		Map<String, String> strApiResponse = new HashMap<String, String>();
////		strApiResponse.put("EligibleIntent", eligibleIntent);
////		strApiResponse.put("EnrollmentId", enrollmentId);
////
////		return strApiResponse;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchChooseAgainAccountNoAndZip
////	 * Description : 
////	 * Author      : cog_cisrael
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Sep 6, 2018
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String, String> fetchOptinFields(String marketerAssignedID,String accountNo) {
////
////		Map<String,String> records = new HashMap<String,String>();
////
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String optinDataFetchQuery = config.getProperty("RetrieveOptinFields");
////		optinDataFetchQuery = optinDataFetchQuery.replace("_REPLACE_ACCOUNT_NUMBER_", accountNo.toString());
////
////		String discoveryUrl = "jdbc:sqlserver://"+discoveryServerName+";databaseName="+discoverydatabaseName+";integratedSecurity=true";
////
////
////		System.out.println(discoveryUrl);
////		System.out.println(optinDataFetchQuery);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(discoveryUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(optinDataFetchQuery);
////			ResultSet rs = stmt.executeQuery(optinDataFetchQuery);
////
////			while (rs.next()) {
////
////				records.put("PrimaryPhoneNumber", rs.getString("PrimaryPhoneNumber").trim());
////				records.put("OptinMobileNumber", rs.getString("OptinMobileNumber").trim());
////				records.put("EMAIL", rs.getString("EMAIL").trim());
////				records.put("OptinFlag", rs.getString("OptinFlag").trim());
////
////				records.put("ConfirmationID", rs.getString("ConfirmationID").trim());
////				records.put("ACCOUNTNO", rs.getString("ACCOUNTNO").trim());
////				records.put("escoacctkey", rs.getString("escoacctkey").trim());
////				break;
////			}
////			conn.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	public synchronized Map<String,String> renewChooseAgainOptinEmailPhonenumberValidator(String accountNo, String phonetype) {
////		Map<String,String> records = new HashMap<String,String>();
////		String discoveryServerName = config.getProperty("DiscoveryServerName");
////		String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////		String OptinMobileNumberquery = config.getProperty("RenewChooseAgainOptinQuery");
////		String url = "jdbc:sqlserver://" + discoveryServerName + ";databaseName=" + discoverydatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			wait(30);
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			OptinMobileNumberquery = OptinMobileNumberquery.replace("_REPLACE_ACCOUNT_NUMBER_", accountNo.toString());
////			OptinMobileNumberquery = OptinMobileNumberquery.replace("_REPLACE_PHONETYPE_", phonetype.toString());
////			System.out.println(OptinMobileNumberquery );
////			ResultSet rs = stmt.executeQuery(OptinMobileNumberquery);
////
////			while (rs.next()) {
////				records.put("PhoneNumber", rs.getString("PhoneNumber").trim());
////				records.put("ElectronicAddress", rs.getString("ElectronicAddress").trim());
////				records.put("AdditionalInfojson", rs.getString("AdditionalInfojson"));
////				records.put("Telecomtypedesc", rs.getString("Telecomtypedesc").trim());
////				records.put("ConfirmationID", rs.getString("ConfirmationID").trim());
////				records.put("ACCOUNTNO", rs.getString("ACCOUNTNO").trim());
////				records.put("escoacctkey", rs.getString("escoacctkey").trim());
////				break;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchAccNoCustNameCustNoForRM
////	 * Description : This method will fetch Account Number and Customer name from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Jan 20, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized Map<String,String> fetchAccNoCustNameCustNoForRM() {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String MyAccountRMQuery = config.getProperty("MyAccountRMQuery");
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement();
////			System.out.println(MyAccountRMQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMQuery);
////
////			while (rs.next()) {
////				records.put("CustomerNumber", rs.getString("SourceCustomerID").trim());
////				records.put("AccountNumber", rs.getString("AccountNumber").trim());
////				records.put("CompanyName", rs.getString("StandardCompanyName"));
////				break;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchAccountSiteListDetailsRM
////	 * Description : This method will fetch Account Site List details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Feb 2nd, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchAccountNumerForAccountSiteListDetailsRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("GetAccoutNumberForAccountSiteList").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("GetAccoutNumberForAccountSiteList").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					if(count == randNum) {
////						String AccNoFromRMDB=rs.getString("ACCT_NO");
////						String COMPANY_LAST_NM= rs.getString("COMPANY_LAST_NM");					
////						randNum++;
////						if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {
////							records.put("BillingAccount", rs.getString("ACCT_NO"));
////							records.put("CustomerName", FetchCustomerNamefromDigitalBD(AccNoFromRMDB));
////							return records;
////				
////				}
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchAccountSiteListDetailsRM
////	 * Description : This method will fetch Account Site List details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Feb 2nd, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchAccountSiteListDetailsRM(String accountNumber, String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery= config.getProperty("AccountSiteListRMQuery").replace("AccountNumber", accountNumber).replace("ServiceType", fuelType);	
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					if(count == randNum) {
////						String AccNoFromRMDB=rs.getString("ACCT_NO");
////						String COMPANY_LAST_NM= rs.getString("COMPANY_LAST_NM");					
////						randNum++;
////						if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {	
////				records.put("CustomerNumber", rs.getString("CUST_ID").trim());
////				records.put("CustomerName",FetchCustomerNamefromDigitalBD(AccNoFromRMDB));
////				records.put("BillingAccount", rs.getString("ACCT_NO"));
////				records.put("CreateDate", rs.getString("ACCT_CREATION_DT"));
////				records.put("AccountStatus", rs.getString("ACTIVE_IN"));
////				records.put("SiteID", rs.getString("LDC_ACCT_NO").trim());
////				records.put("SiteDescription", rs.getString("SERV_LOC_NM").trim());
////				records.put("SiteAddress", rs.getString("LocAddress").trim());
////				records.put("Service", rs.getString("SERVICE_TY_CD"));
////				records.put("MeterNumber", rs.getString("METER_NO"));
////				records.put("MeterType", rs.getString("METER_TYPES_TX"));
////				records.put("RateCode", rs.getString("RATE_CLASS_CD"));
////				records.put("LDC/WSP", rs.getString("VENDOR_NM").trim());
////				records.put("RetailerID", rs.getString("VENDOR_DB_NO_TX").trim());
////				records.put("EffectiveStartDate", rs.getString("START_DT"));
////				//records.put("CloseDate", rs.getString("END_DT").trim());
////				records.put("ActiveFlag", rs.getString("ActiveFlag").trim());
////				records.put("SiteStatus", rs.getString("SiteStatus").trim());
////				records.put("EnrolledDate", rs.getString("EnrolledDate"));
////				//records.put("DeEnrolledDate", rs.getString("DeEnrolledDate").trim());
////				
////				/*records.put("CompanyName", rs.getString("LDCStatusCode"));
////				records.put("Address1", rs.getString("ADDR_1_TX").trim());
////				records.put("Address2", rs.getString("ADDR_2_TX"));*/
////				/*records.put("Address3", rs.getString("CITY_TX"));
////				records.put("Address4", rs.getString("STATE_TX"));
////				records.put("Address5", rs.getString("POSTAL_CD_TX"));*/
////				//records.put("CompanyName", rs.getString("STATE_TX"));
////				/*records.put("TRANSTY", rs.getString("TRANS_TY"));
////				records.put("CreationDate", rs.getString("CREATION_DT"));
////				records.put("CompanyName", rs.getString("TranStatusCode"));*/
////				return records;
////				}
////					}
////					}			
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchCustomMonthlyManagementDetailsRM
////	 * Description : This method will fetch Custom Monthly Management details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Feb 2nd, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchCustomMonthlyManagementDetailsRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("CustomMonthlyManagementRMQuery").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("CustomMonthlyManagementRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				records.put("TransactionDate", rs.getString("TRANS_DT").trim());
////				records.put("AccountNumber", rs.getString("ACCT_NO").trim());
////				records.put("Volume", rs.getString("TRANS_QTY").trim());
////				records.put("Energy", rs.getString("TRANS_AM"));
////				records.put("SiteNumber", rs.getString("LDC_ACCT_NO"));
////				records.put("CustomerName", rs.getString("COMPANY_LAST_NM"));
////				records.put("CommodityType", rs.getString("SERVICE_TY_CD"));
////				records.put("ServiceAddress", rs.getString("Site_Address"));
////				records.put("LDCRateCode", rs.getString("RATE_CLASS_CD"));
////				records.put("LDCName", rs.getString("VENDOR_NM").trim());
////				records.put("LSAName", rs.getString("VENDOR_NM").trim());
////				records.put("Delivery", rs.getString(""));
////				records.put("Carbon Levy", rs.getString(""));
////				records.put("GST", rs.getString("").trim());
////				records.put("Total", rs.getString("").trim());
////				records.put("ServiceName", rs.getString(""));
////				
////				/*records.put("Address5", rs.getString("POSTAL_CD_TX"));
////				records.put("Service", rs.getString("SERVICE_TY_CD"));
////				records.put("LDC/WSP", rs.getString("VENDOR_NM").trim());
////				records.put("RetailerID", rs.getString("VENDOR_DB_NO_TX").trim());
////				records.put("MeterNumber", rs.getString("METER_NO"));
////				records.put("MeterType", rs.getString("METER_TYPES_TX"));
////				//records.put("CompanyName", rs.getString("STATE_TX"));
////				records.put("TRANSTY", rs.getString("TRANS_TY"));
////				records.put("CreationDate", rs.getString("CREATION_DT"));
////				records.put("CompanyName", rs.getString("TranStatusCode"));*/
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchAESOPricesDetailsRM
////	 * Description : This method will fetch Custom Monthly Management details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : 
////	 * Date        : Feb 2nd, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchAESOPricesDetailsRM() {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		
////	    MyAccountRMSiteListQuery = config.getProperty("AESOPrices");
////	
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			while (rs.next()) {
////				
////				records.put("Date", rs.getString("ReadDate").trim());
////				records.put("HourEnding", rs.getString("Interval").trim());
////				records.put("PoolPrice", rs.getString("Price").trim());
////				break;
////				}	
////			
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchContractListDetailsRM
////	 * Description : This method will fetch Contract List details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : Feb 5th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchContractListDetailsRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMReportDatabaseName");
////		String MyAccountRMSiteListQuery= config.getProperty("ContractListRMQuery");	
////		MyAccountRMSiteListQuery=MyAccountRMSiteListQuery.replace("REPLACE_COMODITY", fuelType);
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					if(count == randNum) {
////						String AccNoFromRMDB=rs.getString("Billing_Account");
////						String COMPANY_LAST_NM= rs.getString("Customer");					
////						randNum++;
////						if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {	
////							records.put("AccountNumber", rs.getString("Billing_Account").trim());
////							records.put("Commodity", rs.getString("Commodity").trim());
////							records.put("CustomerNumber", rs.getString("Customer_Number").trim());
////							records.put("CustomerName", FetchCustomerNamefromDigitalBD(AccNoFromRMDB).trim());
////							records.put("CustomerRep", rs.getString("CustomerRep").trim());
////							records.put("AssociatedStatus", rs.getString("AssociatedStatus").trim());
////							records.put("EffectiveStartDate", rs.getString("Effective_Start_Date"));
////							records.put("EffectiveEndDate", rs.getString("Effective_End_Date").trim());
////							records.put("ContractNumber", rs.getString("Contract_#").trim());
////							records.put("RetailerContractID", rs.getString("Retailer_Contract_ID"));
////							records.put("ContractStartDate", rs.getString("Contract_Start_Date"));
////							records.put("ContractEndDate", rs.getString("Contract_End_Date"));
////							records.put("RateID", rs.getString("Rate_ID"));
////							records.put("ContractStatus", rs.getString("ContractStatus"));
////							records.put("RateType", rs.getString("Rate_Name_OR_Type"));
////							records.put("DealStartDate", rs.getString("Deal_Start_Date"));
////							records.put("DealEndDate", rs.getString("Deal_End_Date"));
////							records.put("DealEndDate", rs.getString("STATE_TX"));
////							return records;
////						}
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchEnergyUsageAccountRM
////	 * Description : This method will fetch Energy Usage Accounts from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : March 4th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchEnergyUsageAccountRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMEnergyUsageAccountQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMEnergyUsageAccountQuery = config.getProperty("FetchEnergyUsageAccountRMQuery").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMEnergyUsageAccountQuery = config.getProperty("FetchEnergyUsageAccountRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMEnergyUsageAccountQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMEnergyUsageAccountQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				records.put("AccountNumber", rs.getString("ACCT_NO").trim());
////				records.put("CustomerName", rs.getString("COMPANY_LAST_NM").trim());
////				records.put("CustomerNumber", rs.getString("Cust_id").trim());
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchEnergyUsageDetailsRM
////	 * Description : This method will fetch Energy Usage details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection
////	 * Date        : March 4th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchEnergyUsageDetailsRM(String fuelType, String accountNumber) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMReportDatabaseName");
////		
////		String MyAccountRMEnergyUsageAccountQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMEnergyUsageAccountQuery = config.getProperty("FetchEnergyUsageDetailsRMQuery").replace("ServiceType", "EL").replace("AccountNumber", accountNumber);	
////		}else {
////			MyAccountRMEnergyUsageAccountQuery = config.getProperty("FetchEnergyUsageDetailsRMQuery").replace("ServiceType", "Gas").replace("AccountNumber", accountNumber);	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMEnergyUsageAccountQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMEnergyUsageAccountQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				records.put("AccountNumber", rs.getString("Year").trim());
////				records.put("Month", rs.getString("Month").trim());
////				records.put("MonthValue", rs.getString("MonthValue").trim());
////				records.put("Volume", rs.getString("Trans_qty").trim());
////				records.put("Energy", rs.getString("trans_energy").trim());
////				records.put("Delivery", rs.getString("trans_delivery").trim());
////				records.put("GST", rs.getString("trans_gst").trim());
////				records.put("Levy", rs.getString("Carbon_Levy").trim());
////				records.put("Total", rs.getString("total").trim());
////				records.put("SiteNumber", rs.getString("SiteNo").trim());
////				records.put("ServiceName", rs.getString("ServiceName").trim());
////				records.put("CustomerName", rs.getString("Customer").trim());
////				records.put("CommodityType", rs.getString("CommodityType").trim());
////				records.put("ServiceAddress", rs.getString("ServiceAddress").trim());
////				records.put("LDCName", rs.getString("LDC").trim());
////				records.put("LSAName", rs.getString("LSA").trim());
////				records.put("LDCRateCode", rs.getString("RATE_CLASS_CD").trim());
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchPaymentHistoryDetailsRM
////	 * Description : This method will fetch Payment History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : Feb 5th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchPaymentHistoryDetailsRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQuery").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					String AccNoFromRMDB=rs.getString("Account");
////					String COMPANY_LAST_NM= rs.getString("CustomerName");					
////					randNum++;
////					if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {
////					    records.put("CustomerName", FetchCustomerNamefromDigitalBD(AccNoFromRMDB));
////						records.put("BillingAccount", rs.getString("Account").trim());
////						records.put("Commodity", rs.getString("serviceType").trim());
////						records.put("PaymentNumber", rs.getString("trans_id"));
////						records.put("PaymentDate", rs.getString("PaymentDate"));
////						records.put("PaymentAmount", rs.getString("PaymentAmount"));
////						records.put("PaymentMethod", rs.getString("PaymentMethod"));
////						records.put("PaymentReferenceNumber", rs.getString("REFERENCE_NO_TX"));
////						records.put("TransitNumber", rs.getString("acct_id").trim());
////						return records;
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS Available!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	public synchronized Map<String,String> fetchPaymentHistoryDetailsRM1(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQueryElectric").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					String AccNoFromRMDB=rs.getString("Account");
////					String COMPANY_LAST_NM= rs.getString("CustomerName");					
////					randNum++;
////					if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {
////					    records.put("CustomerName", FetchCustomerNamefromDigitalBD(AccNoFromRMDB));
////						records.put("BillingAccount", rs.getString("Account").trim());
////						records.put("Commodity", rs.getString("serviceType").trim());
////						records.put("PaymentNumber", rs.getString("trans_id"));
////						records.put("PaymentDate", rs.getString("PaymentDate"));
////						records.put("PaymentAmount", rs.getString("PaymentAmount"));
////						records.put("PaymentMethod", rs.getString("PaymentMethod"));
////						records.put("PaymentReferenceNumber", rs.getString("REFERENCE_NO_TX"));
////						records.put("TransitNumber", rs.getString("acct_id").trim());
////						return records;
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS Available!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	public synchronized Map<String,String> fetchPaymentHistoryDetailsRM2(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQuery").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("PaymentHistoryRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					String AccNoFromRMDB=rs.getString("Account");
////					String COMPANY_LAST_NM= rs.getString("CustomerName");					
////					randNum++;
////					if(ValidateAccountAvailablityInDigitalDB1(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {
////					    records.put("CustomerName", FetchCustomerNamefromDigitalBD1(AccNoFromRMDB));
////						records.put("BillingAccount", rs.getString("Account").trim());
////						records.put("Commodity", rs.getString("serviceType").trim());
////						records.put("PaymentNumber", rs.getString("trans_id"));
////						records.put("PaymentDate", rs.getString("PaymentDate"));
////						records.put("PaymentAmount", rs.getString("PaymentAmount"));
////						records.put("PaymentMethod", rs.getString("PaymentMethod"));
////						records.put("PaymentReferenceNumber", rs.getString("REFERENCE_NO_TX"));
////						records.put("TransitNumber", rs.getString("acct_id").trim());
////						return records;
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS Available!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	/**
////	 * 
////	 * Method Name : fetchPaymentHistoryReportDetailsRM
////	 * Description : This method will fetch Payment History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : Feb 5th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchPaymentHistoryReportDetailsRM(String accountNumber) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery =config.getProperty("PaymentHistoryReportRMQuery").replace("AccountNumber", accountNumber);	
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			
////			while (rs.next()) {
////				records.put("PaymentNumber", rs.getString("trans_id"));
////				records.put("PaymentDate", rs.getString("PaymentDate"));
////				records.put("PaymentAmount", rs.getString("PaymentAmount"));
////				records.put("PaymentMethod", rs.getString("PaymentMethod"));
////				records.put("PaymentReferenceNumber", rs.getString("REFERENCE_NO_TX"));
////				break;
////				
////				}
////	
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchInvoiceHistoryDetailsRM
////	 * Description : This method will fetch Invoice History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : Feb 5th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchInvoiceHistoryDetailsRM(String fuelType) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		if(fuelType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("InvoiceHistoryRMQuery").replace("ServiceType", "EL");	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("InvoiceHistoryRMQuery").replace("ServiceType", "Gas");	
////		}
////		
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					String AccNoFromRMDB=rs.getString("BillingAccount");
////					String COMPANY_LAST_NM= rs.getString("COMPANY_LAST_NM");					
////					randNum++;
////					if(ValidateAccountAvailablityInDigitalDB(AccNoFromRMDB, COMPANY_LAST_NM) ==true) {						
////					
////						records.put("CustomerName", FetchCustomerNamefromDigitalBD(AccNoFromRMDB));
////					    records.put("CustomerID", rs.getString("CustomerID"));
////						records.put("AccountNumber", rs.getString("BillingAccount").trim());
////						records.put("Commodity", rs.getString("Comodity").trim());
////						records.put("InvoiceNumber", rs.getString("InvoiceNumber"));
////						records.put("InvoiceDate", rs.getString("InvoiceDate"));
////						records.put("DueDate", rs.getString("DueDate"));
////						records.put("TotalOutstandingBalance", rs.getString("TotalOutstandingBalance"));
////						records.put("CurrentCharges", rs.getString("CurrentCharges"));
////						records.put("BalanceForward", rs.getString("BalanceForward").trim());
////						return records;					
////					}
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS available!!!";
////				Assert.assertFalse(true);
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	
////	
////	
////	
////	/*Method Name: Email Verification in MyAccount Database
////	 * Description:This Method is to verify whether Email exists in Myaccount Database or not
////	 */
////
////
////	/*public  synchronized String ValidateEmailAvailablityInDigitalDB(String custemail, String data) throws SQLException, ClassNotFoundException {
////
////
////	String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////	String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////	String DigitalDatabaseEmail = config.getProperty("DigitalDatabaseEmails");
////	//DigitalDatabaseEmail = DigitalDatabaseEmail.replace("putsbox" ,custemail.toString());
////	DigitalDatabaseEmail = DigitalDatabaseEmail.replace("putsbox" ,"brady@putsbox.com");
////	String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////	System.out.println(DigitalUrl);
////	Connection conn = null;
////		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////		conn = DriverManager.getConnection(DigitalUrl);
////		Statement stmt = conn.createStatement();
////		System.out.println(DigitalDatabaseEmail);
////		ResultSet rs = stmt.executeQuery(DigitalDatabaseEmail);
////				//String EmailFromDB=rs.getString(custemail.toString());
////				//while (rs.next()) {
////					//return rs.getString(EMAIL_ADDRESS);
////				//}
////				if(rs.next()==true) {
////					// PutsBox putsbox=new PutsBox(driver);
////					//PutsBox putsBox;
////					System.out.println(rs.getString("EMAIL_ADDRESS"));
////					Map<String, String> mail = putsBox.generateNewPutsBoxEmail(CommonString.PutsURL);
////					String custemail1 = mail.get("email");
////	String strputsBoxURL1 =  mail.get("emailURL");
////					return custemail1;
////					
////				}
////				
////				return custemail;
////}	
////	*/
////	
////	
////	/**
////	 * 
////	 * Method Name : fetchThirdPartyInvoiceRM
////	 * Description : This method will fetch Invoice History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : April 02, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchThirdPartyCustomerInvoiceAccountLevelDetailsRM() {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery=config.getProperty("ThirdPartyCustomerInvoiceAccountLevelDetails");
////	
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////			    records.put("Bill Acct #", rs.getString("ACCT_NO"));
////			    records.put("Bill Acct Name", rs.getString("ACCT_NM"));
////				records.put("Invoice No", rs.getString("INVOICE_ID").trim());
////				records.put("Invoice Date", rs.getString("INV_DT").trim());
////				records.put("Charge Type", rs.getString("ChargeType"));
////				records.put("Charge Date", rs.getString("TRANS_DT"));
////				records.put("Charge Amount", rs.getString("ChargeAmount"));
////				records.put("GST", rs.getString("GST"));
////				records.put("Total", rs.getString("TotalCharge"));
////				return records;
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchThirdPartyInvoiceRM
////	 * Description : This method will fetch Invoice History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : April 02, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchContractEnrollmentsDetailsRM(String ServiceType,String customerID) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery;
////		
////		if(ServiceType=="Electricity") {
////			MyAccountRMSiteListQuery = config.getProperty("ContractEnrollmentsRMQuery").replace("ServiceType", "EL").replace("CustomerID", customerID);	
////		}else {
////			MyAccountRMSiteListQuery = config.getProperty("ContractEnrollmentsRMQuery").replace("ServiceType", "Gas").replace("CustomerID", customerID);	
////		}
////		
////	
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			
////			System.out.println("Random Number:"+randNum);
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////			    records.put("ContractNumber", rs.getString("ContractNum"));
////			    records.put("ContractStartDate", rs.getString("StartDate"));
////				records.put("ContractEndDate", rs.getString("EndDate").trim());
////				records.put("CustomerNumber", rs.getString("CUST_ID").trim());
////				records.put("CustomerName", rs.getString("COMPANY_LAST_NM"));
////				records.put("SiteID", rs.getString("LDC_ACCT_NO"));
////				records.put("ServiceName", rs.getString("SERV_LOC_NM"));
////				records.put("ServiceAddress", rs.getString("ServiceAddress"));
////				records.put("LDCName", rs.getString("LDCName"));
////				records.put("RetailerID", rs.getString("RetailerID"));
////				records.put("LDCRateCode", rs.getString("LDCRateCode"));
////				records.put("TransactionCategory", rs.getString("TRANS_TY"));
////				records.put("TransactionType", rs.getString("TRANS_SUB_TY"));
////				records.put("TransactionStatus", rs.getString("STATUS_CD"));
////				records.put("Total", rs.getString("RESPONSE_TX"));
////				records.put("TransactionDate", rs.getString("CREATION_DT"));
////				records.put("RequestDate", rs.getString("SEND_DT"));
////				records.put("EffectiveDate", rs.getString("REQ_DT"));
////				records.put("ResponsiveEffectiveDate", rs.getString("RESPONSE_EFFECTIVE_DT"));
////				records.put("NoOfDaysLate", rs.getString("DaysLate"));
////				
////				}
////				count++;
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchInvoiceHistoryDetailsRM
////	 * Description : This method will fetch Invoice History details from DB for RM Accounts
////	 * Author      : muruger2
////	 * Return Types: Map<String,String>
////	 * Paramters   : DBConnection, String fuelType
////	 * Date        : Feb 5th, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String,String> fetchInvoiceHistoryReportDetailsRM(String accountNumber) {
////		Map<String,String> records = new HashMap<String,String>();
////		String digitalDBServerName = config.getProperty("RMServerName");
////		String digitalDBdatabaseName = config.getProperty("RMDatabasename");
////		String MyAccountRMSiteListQuery = config.getProperty("InvoiceHistoryReportRMQuery").replace("AccountNumber", accountNumber);
////		String url = "jdbc:sqlserver://" + digitalDBServerName + ";databaseName=" + digitalDBdatabaseName + ";integratedSecurity=true";
////		String resultLog = "";
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(url);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(MyAccountRMSiteListQuery );
////			ResultSet rs = stmt.executeQuery(MyAccountRMSiteListQuery);
////			
////			while (rs.next()) {
////				records.put("InvoiceNumber", rs.getString("InvoiceNumber"));
////				records.put("InvoiceDate", rs.getString("InvoiceDate"));
////				records.put("DueDate", rs.getString("DueDate"));
////				records.put("TotalOutstandingBalance", rs.getString("TotalOutstandingBalance"));
////				records.put("CurrentCharges", rs.getString("CurrentCharges"));
////				records.put("BalanceForward", rs.getString("BalanceForward").trim());
////				break;
////				
////			}
////			if (resultLog.length() < 1) {
////				resultLog = "NO RECORDS CREATED!!!";
////			}
////			conn.close();
////			return records;
////		} catch (Exception e) {e.printStackTrace();
////		try {
////			records.put("KEY", "NOT_FOUND");
////			conn.close();
////		} catch (Exception e1) {
////
////		}}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	public synchronized String validateOptinNewEnrollmentInDatabase(String marketerAssignedID, String optinMobileNumber, String email) {
////        String discoveryServerName = config.getProperty("DiscoveryServerName");
////        String discoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////        String OptinMobileNumberquery = config.getProperty("OptinMobileNumberquery");
////        String url = "jdbc:sqlserver://" + discoveryServerName + ";databaseName=" + discoverydatabaseName + ";integratedSecurity=true";
////        String resultLog = "";
////        Connection conn = null;
////        try {
////            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////            conn = DriverManager.getConnection(url);
////            Statement stmt = conn.createStatement();
////            OptinMobileNumberquery=OptinMobileNumberquery + "'" + marketerAssignedID + "';";
////            System.out.println(OptinMobileNumberquery);
////            ResultSet rs = stmt.executeQuery(OptinMobileNumberquery);
////
////            while (rs.next()) {
////
////
////                if (rs.getString("AdditionalInfo").trim() != null) {
////                    String AdditionalInfo = rs.getString("AdditionalInfo");
////                    System.out.println(AdditionalInfo);
////                    JsonPath jsonPath = new JsonPath(AdditionalInfo);
////                    String strbillingGroup = jsonPath.getString("billingGroup");
////                    System.out.println(strbillingGroup);
////                    String optInForTextvalue = strbillingGroup.replaceAll("]", "");
////                    optInForTextvalue = optInForTextvalue.substring(optInForTextvalue.lastIndexOf(":") + 1);
////                    System.out.println(optInForTextvalue);
////                    Assert.assertTrue(optInForTextvalue.equalsIgnoreCase("true"), "optInForText is not correct or Empty");
////
////                    if (optInForTextvalue.equalsIgnoreCase("true")) {
////                        resultLog = resultLog + "<pre> optInForText is True </pre>";
////                    }
////                } else {
////                    resultLog = resultLog + "<pre> optinMobileNumber : " + optinMobileNumber + " doesn't match with DB </pre>";
////                }
////              
////                Assert.assertTrue(rs.getString("info2").trim().equalsIgnoreCase(optinMobileNumber.trim()), "Phone number doest match with DB");
////                if (rs.getString("info2").trim().equalsIgnoreCase(optinMobileNumber.trim())) {
////                    resultLog = resultLog + "<pre> optinMobileNumber : " + optinMobileNumber + " matches with DB </pre>";
////                } else {
////                    resultLog = resultLog + "<pre> optinMobileNumber : " + optinMobileNumber + " doesn't match with DB </pre>";
////                }
////                Assert.assertTrue(rs.getString("Email").trim().equalsIgnoreCase(email.trim()), "Email doesn't match with DB");
////                if (rs.getString("Email").trim().equalsIgnoreCase(email.trim())) {
////                    resultLog = resultLog + "<pre> Email : " + email + " matches with DB </pre>";
////                } else {
////                    resultLog = resultLog + "<pre> Email : " + email + " doesn't match with DB </pre>";
////                }
////
////            }
////            if (resultLog.length() < 1) {
////                resultLog = "NO RECORDS CREATED!!!";
////            }
////            conn.close();
////        } catch (Exception e) {
////            try {
////                conn.close();
////            } catch (Exception e1) {}
////            return "EXCEPTION IN CONNECTING TO DATABASE!!!";
////        }
////        return resultLog;
////    }
////
////	/**
////	 * 
////	 * Method Name : fetchBalanceDueforAccount
////	 * Description : This method will fetch Balance Due for an Account
////	 * Author      : Sathish
////	 * Return Type : String
////	 * Paramters   : accountNo
////	 * Date        : Jan 2, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchBalanceDueforAccount(String accountNo, String fuelType) {
////
////		String BalanceDUE = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String BalanceDueQuery = config.getProperty("BalanceDue");
////		BalanceDueQuery = BalanceDueQuery.replace("ServiceType", fuelType).replace("AccountNumber", accountNo.toString());
////
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(BalanceDueQuery);
////			ResultSet rs = stmt.executeQuery(BalanceDueQuery);
////
////			while (rs.next()) {
////				BalanceDUE = rs.getString("TotalOutstandingBalance").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return BalanceDUE;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchCustomerIDForCustomer
////	 * Description : This method will fetch Customer ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : CustomerName
////	 * Date        : Jan 2, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchCustomerIDForAccount(String CustomerName) {
////
////		String CustomerID = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String FetchCustomerIDQuery = config.getProperty("FetchCustomerID");
////		FetchCustomerIDQuery = FetchCustomerIDQuery.replace("CustomerName", CustomerName.toString());
////
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchCustomerIDQuery);
////			ResultSet rs = stmt.executeQuery(FetchCustomerIDQuery);
////
////			while (rs.next()) {
////				CustomerID = rs.getString("CUST_ID").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return CustomerID;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchCustomerIDForCustomer
////	 * Description : This method will fetch Customer ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : CustomerName
////	 * Date        : April 04, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchDealNumberForAccount(String ServiceType,  String customerID) {
////
////		String dealNumber = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String ContractRenewalListQueryRM = config.getProperty("ContractRenewalListQueryRM");
////		//ContractRenewalListQueryRM = ContractRenewalListQueryRM.replace("CustomerName", CustomerName.toString());
////		
////		if(ServiceType=="Electricity") {
////			ContractRenewalListQueryRM = config.getProperty("ContractRenewalListQueryRM").replace("ServiceType", "EL").replace("CustomerID", customerID);	
////		}else {
////			ContractRenewalListQueryRM = config.getProperty("ContractRenewalListQueryRM").replace("ServiceType", "Gas").replace("CustomerID", customerID);	
////		}
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(ContractRenewalListQueryRM);
////			ResultSet rs = stmt.executeQuery(ContractRenewalListQueryRM);
////
////			while (rs.next()) {
////				dealNumber = rs.getString("DealNumber").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return dealNumber;
////	
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchSiteIDForAccountForContractSiteListReportRM
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : CustomerName
////	 * Date        : April  04, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchSiteIDForAccountForContractSiteListReportRM(String customerID,  String contractStatus, String siteStatus, String siteID) {
////
////		String siteID1 = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////        String ContractSiteListQueryRM = config.getProperty("ContractSiteListQueryRM").replace("CustomerID", customerID).replace("ContractStatus", contractStatus).replace("SiteStatus", siteStatus).replace("SiteID", siteID);	
////		
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(ContractSiteListQueryRM);
////			ResultSet rs = stmt.executeQuery(ContractSiteListQueryRM);
////
////			while (rs.next()) {
////				siteID1 = rs.getString("LDC_ACCT_NO").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return siteID1;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchConsumptionFromAccountSiteListInvoiceChargeInformationDB
////	 * Description : This method will fetch Consumption From Account Site List Invoice Charge Information DB
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : CustomerName
////	 * Date        : April 04, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchConsumptionFromAccountSiteListInvoiceChargeInformationDB(String AccountNumber) {
////
////		String consumption = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String AccountSiteListInvoiceChargeInformationQueryRM = config.getProperty("AccountSiteListInvoiceChargeInformationQueryRM").replace("AccountNumber", AccountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(AccountSiteListInvoiceChargeInformationQueryRM);
////			ResultSet rs = stmt.executeQuery(AccountSiteListInvoiceChargeInformationQueryRM);
////
////			while (rs.next()) {
////				consumption = rs.getString("QTY_DELIVERED_NO").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return consumption;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchCustomerIDForCustomer
////	 * Description : This method will fetch Total for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : CustomerName
////	 * Date        : April 04, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchTotalFromCustomMonthlyManagementDB(String accountNumber, String serviceType) {
////
////		String total = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String CustomMonthlyManagementQueryRM = config.getProperty("CustomMonthlyManagementReportQueryRM").replace("AccountNumber", accountNumber).replace("ServiceType", serviceType);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(CustomMonthlyManagementQueryRM);
////			ResultSet rs = stmt.executeQuery(CustomMonthlyManagementQueryRM);
////
////			while (rs.next()) {
////				total = rs.getString("total").trim().toString();
////				break;
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return total;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchCurrentYear7x24PriceFromAESOAverageHistoricalPricesDB
////	 * Description : This method will fetch Price for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchPreviousYear7x24PriceFromAESOAverageHistoricalPricesDB() {
////
////		String prices = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String AESOAverageHistoricalPricesQueryRM = config.getProperty("AESOAverageHistoricalPricesQueryRM");
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(AESOAverageHistoricalPricesQueryRM);
////			ResultSet rs = stmt.executeQuery(AESOAverageHistoricalPricesQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				prices = rs.getString("Price7X24PrevYear").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return prices;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchStandardDeviationFromAESOHourlyPricesDB
////	 * Description : This method will fetch Standard Deviation for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchStandardDeviationFromAESOHourlyPricesDB() {
////
////		String standardDeviation = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String AESOHourlyPricesQueryRM = config.getProperty("AESOHourlyPricesQueryRM");
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(AESOHourlyPricesQueryRM);
////			ResultSet rs = stmt.executeQuery(AESOHourlyPricesQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				standardDeviation = rs.getString("StandardDeviation").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return standardDeviation;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchSiteIDFromCumulativeMeteredDCMGasReportDB
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchSiteIDFromCumulativeMeteredDCMGasReportDB(String accountNumber) {
////
////		String siteID = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String CumulativeMeteredDCMGasQueryRM = config.getProperty("CumulativeMeteredDCMQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(CumulativeMeteredDCMGasQueryRM);
////			ResultSet rs = stmt.executeQuery(CumulativeMeteredDCMGasQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					siteID = rs.getString("SiteId").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return siteID;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchSiteIDFromCumulativeMeteredDCMPowerReportDB
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchSiteIDFromCumulativeMeteredDCMPowerReportDB(String accountNumber) {
////
////		String siteID = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String CumulativeMeteredDCMPowerQueryRM = config.getProperty("CumulativeMeteredDCMPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(CumulativeMeteredDCMPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(CumulativeMeteredDCMPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					siteID = rs.getString("SiteId").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return siteID;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchSiteIDFromCumulativeMeteredMicrogenGCMPowerReportDB
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchSiteIDFromCumulativeMeteredMicrogenGCMPowerReportDB(String accountNumber) {
////
////		String siteID = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String CumulativeMeteredMicrogenGCMPowerQueryRM = config.getProperty("CumulativeMeteredMicrogenGCMPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(CumulativeMeteredMicrogenGCMPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(CumulativeMeteredMicrogenGCMPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					siteID = rs.getString("SiteId").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return siteID;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchVolumeFromIntervalMeteredDIMReadsGasReportDB
////	 * Description : This method will fetch Volume for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchVolumeFromIntervalMeteredDIMReadsGasReportDB(String accountNumber) {
////
////		String volume = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String IntervalMeteredDIMReadsGasQueryRM = config.getProperty("IntervalMeteredDIMReadsGasQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(IntervalMeteredDIMReadsGasQueryRM);
////			ResultSet rs = stmt.executeQuery(IntervalMeteredDIMReadsGasQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					volume = rs.getString("QTY_DELIVERED_NO").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return volume;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchKWFromIntervalMeteredDIMReadsPowerReportDB
////	 * Description : This method will fetch KW for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchKWFromIntervalMeteredDIMReadsPowerReportDB(String accountNumber) {
////
////		String KW = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String IntervalMeteredDIMReadsPowerQueryRM = config.getProperty("IntervalMeteredDIMReadsPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(IntervalMeteredDIMReadsPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(IntervalMeteredDIMReadsPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					KW = rs.getString("KW").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return KW;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchPoolPriceFromIntervalMeteredMicrogenGIMPowerReportDB
////	 * Description : This method will fetch KW for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 08, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchPoolPriceFromIntervalMeteredMicrogenGIMPowerReportDB(String accountNumber) {
////
////		String poolPrice = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String IntervalMeteredMicrogenGIMPowerQueryRM = config.getProperty("IntervalMeteredMicrogenGIMPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(IntervalMeteredMicrogenGIMPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(IntervalMeteredMicrogenGIMPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					poolPrice = rs.getString("PoolPrice").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return poolPrice;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchUsageFromDailyUsageStripInformationGasReportReportDB
////	 * Description : This method will fetch Usage for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 09, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchUsageFromDailyUsageStripInformationGasReportDB(String accountNumber) {
////
////		String usage = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String DailyUsageStripInformationGasQueryRM = config.getProperty("DailyUsageStripInformationGasQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(DailyUsageStripInformationGasQueryRM);
////			ResultSet rs = stmt.executeQuery(DailyUsageStripInformationGasQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					usage = rs.getString("DailySiteUsage").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return usage;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchSiteIDFromDeliveryChargesReportDB
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 09, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchSiteIDFromDeliveryChargesReportDB(String accountNumber, String serviceType) {
////
////		String siteID = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String DeliveryChargesQueryRM = config.getProperty("DeliveryChargesQueryRM").replace("AccountNumber", accountNumber).replace("ServiceType", serviceType);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(DeliveryChargesQueryRM);
////			ResultSet rs = stmt.executeQuery(DeliveryChargesQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					siteID = rs.getString("LDC_ACCT_NO").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return siteID;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchConsumptionFromDeliveryChargesReportDB
////	 * Description : This method will fetch Site ID for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 09, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchConsumptionFromEnergyChargesAndConsumptionReportDB(String accountNumber, String serviceType, String siteID) {
////
////		String consumption = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String EnergyChargesAndConsumptionQueryRM = config.getProperty("EnergyChargesAndConsumptionQueryRM").replace("AccountNumber", accountNumber).replace("ServiceType", serviceType).replace("SiteID", siteID);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(EnergyChargesAndConsumptionQueryRM);
////			ResultSet rs = stmt.executeQuery(EnergyChargesAndConsumptionQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////					consumption = rs.getString("Consumption").trim().toString();
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return consumption;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchTotalFromEnergySettlementConsumptionGasReportDB
////	 * Description : This method will fetch Total for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 09, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchTotalFromEnergySettlementConsumptionGasReportDB(String accountNumber, String serviceType, String siteID) {
////
////		String total = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String EnergySettlementConsumptionQueryRM = config.getProperty("EnergySettlementConsumptionQueryRM").replace("AccountNumber", accountNumber).replace("ServiceType", serviceType).replace("SiteID", siteID);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(EnergySettlementConsumptionQueryRM);
////			ResultSet rs = stmt.executeQuery(EnergySettlementConsumptionQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {					
////					total = rs.getString("TOTAL").trim().toString();					
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return total;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchLossesFromHourlyUsageStripInformationPowerReportDB
////	 * Description : This method will fetch Total for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 10, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchLossesFromHourlyUsageStripInformationPowerReportDB(String accountNumber) {
////
////		String losses = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String HourlyUsageStripInformationPowerQueryRM = config.getProperty("HourlyUsageStripInformationPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(HourlyUsageStripInformationPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(HourlyUsageStripInformationPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				
////					losses = rs.getString("QTY_LL").trim().toString();		
////					
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return losses;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchDistributionEnergytFromPowerFactorReportDB
////	 * Description : This method will fetch Distribution Energy for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 10, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchDistributionEnergytFromWiresChargesAndConsumptionReportPowerReportDB(String accountNumber) {
////
////		String distributionEnergy = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String WiresChargesAndConsumptionReportPowerQueryRM = config.getProperty("WiresChargesAndConsumptionReportPowerQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(WiresChargesAndConsumptionReportPowerQueryRM);
////			ResultSet rs = stmt.executeQuery(WiresChargesAndConsumptionReportPowerQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				
////					distributionEnergy = rs.getString("DistributionEnergy").trim().toString();		
////					
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return distributionEnergy;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchChargeAmountFromPowerFactorReportDB
////	 * Description : This method will fetch Total for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 10, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchChargeAmountFromPowerFactorReportDB(String accountNumber) {
////
////		String chargeAmount = null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String PowerFactorQueryRM = config.getProperty("PowerFactorQueryRM").replace("AccountNumber", accountNumber);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(PowerFactorQueryRM);
////			ResultSet rs = stmt.executeQuery(PowerFactorQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				
////					chargeAmount = rs.getString("ChargeAmount").trim().toString();		
////					
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return chargeAmount;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchPeriodHourFromLoadFactorReportDB
////	 * Description : This method will fetch Total for a Account
////	 * Author      : muruger2
////	 * Return Type : String
////	 * Paramters   : prices
////	 * Date        : April 10, 2019
////	 * Version     : 1.0
////	 */
////
////	public synchronized String fetchPeriodHourFromLoadFactorReportDB(String customerID) {
////
////		String periodHour= null;
////		String ERMServerName = config.getProperty("RMServerName");
////		String ERMDBdatabaseName = config.getProperty("RMDatabasename");
////		String LoadFactorQueryRM = config.getProperty("LoadFactorQueryRM").replace("CustomerID", customerID);
////		
////		String ERMUrl = "jdbc:sqlserver://"+ERMServerName+";databaseName="+ERMDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(ERMUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(ERMUrl);
////			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
////			System.out.println(LoadFactorQueryRM);
////			ResultSet rs = stmt.executeQuery(LoadFactorQueryRM);
////			Random rand = new Random();
////			int rowCount = 0;
////			int randNum =0;
////			while (rs.next()) {
////				rowCount++;
////			}
////			System.out.println("Row Count:"+rowCount);
////			rs.beforeFirst();
////			
////			randNum = rand.nextInt(rowCount);
////			if(randNum==rowCount) {
////				randNum =randNum-1;	
////			}
////			if(randNum==0) {
////			randNum =randNum+1;
////		    }
////			int count = 1;
////			while (rs.next()) {
////				if(count == randNum) {
////				
////					periodHour = rs.getString("PeriodHour").trim().toString();		
////					
////				}
////				count++;	
////			}
////			conn.close();
////		
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				
////				conn.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		return periodHour;
////	
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchERMTXAccountNumber
////	 * Description : This method will fetch ERM TX account number with invoices available
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String, String> fetchERMTXAccountNumber(Commodity commodity, String query) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String ERMServerName = config.getProperty("ERMServerName");
////		String ERMDatabasename = config.getProperty("ERMDatabasename");
////		
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////			
////		String ERMTXQuery = query;
////		String ERMTXQuery1 = ERMTXQuery.replace("REPLACE_COMMODITY", commodity.toString());
////		
////		String ERMTXAdditionalChecks = config.getProperty("ERMTXAdditionalChecks");
////		String ERMTXAdditionalChecks1 = config.getProperty("ERMTXAdditionalChecks1");
////	
////		Connection connERM = null;
////		Connection connDigital = null;
////		
////		String ERMUrl = "jdbc:sqlserver://" + ERMServerName + ";databaseName=" + ERMDatabasename + ";integratedSecurity=true";
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		
////		
////		try {	
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			
////			connERM = DriverManager.getConnection(ERMUrl);
////			connDigital = DriverManager.getConnection(digitalUrl);
////			
////			Statement stmt = connERM.createStatement();
////			Statement stmt1 = connDigital.createStatement();
////			Statement stmt2 = connDigital.createStatement();
////			
////			System.out.println(ERMTXQuery1);
////			ResultSet rs = stmt.executeQuery(ERMTXQuery1);
////			System.out.println(rs);
////
////					
////			while (rs.next()) {
////			
////				int count1 = 0;		
////				int count2 = 0;
////								
////				String ERMTXAdditionalChecksX = ERMTXAdditionalChecks.replace("REPLACE_ACCOUNTNO", rs.getString("BillingAccount"));
////				System.out.println(ERMTXAdditionalChecksX);				
////				ResultSet rs1 = stmt1.executeQuery(ERMTXAdditionalChecksX);
////				
////				String ERMTXAdditionalChecksY = ERMTXAdditionalChecks1.replace("REPLACE_ACCOUNTNO", rs.getString("BillingAccount"));
////				System.out.println(ERMTXAdditionalChecksY);	
////				ResultSet rs2 = stmt2.executeQuery(ERMTXAdditionalChecksY);
////				
////				while (rs1.next()) {
////					++count1;				
////				}
////				
////				while (rs2.next()) {
////					++count2;	
////					records.put("CustomerName", rs2.getString("StandardCompanyName"));
////					records.put("BillingAccountNumberTX1", rs2.getString("AccountNumber"));
////					records.put("ShipToZip", rs2.getString("ShipToZip"));
////				}
////				
////				System.out.println(count1);	
////				System.out.println(count2);	
////				if(count1 == 0 && count2 > 0 && count2 < 5) {
////					//records.put("CustomerName", rs2.getString("StandardCompanyName"));
////					//System.out.println(rs2.getString("StandardCompanyName"));				
////					//System.out.println(rs2.getString("AccountNumber"));				
////					//System.out.println("CustomerName: "+rs2.getString("StandardCompanyName")+" Account Number :"+rs2.getString("AccountNumber"));
////
////					break;
////				} else {
////					records.clear();
////				}
////			}
////			connERM.close();
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {
////				records.put("KEY", "NOT_FOUND");
////				connERM.close();
////				connDigital.close();
////			} catch (Exception e1) {
////
////			}
////		}
////		records.put("KEY", "NOT_FOUND");
////		return records;
////	}
////
////	/**
////	 * 
////	 * Method Name : fetchERMMultipleTXNONTXAccounts
////	 * Description : This method will fetch ERM TX account number with invoices available
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String, String> fetchERMMultipleTXNONTXAccounts(Commodity commodity, String query) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String ERMServerName = config.getProperty("ERMServerName");
////		String ERMDatabasename = config.getProperty("ERMDatabasename");
////		
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////					
////		String ERMMultipleTXNONTXAccounts = query;
////		String ERMTXNonTXAdditionalChecks = config.getProperty("ERMTXNonTXAdditionalChecks");
////	
////		Connection connERM = null;
////		Connection connDigital = null;
////		
////		String ERMUrl = "jdbc:sqlserver://" + ERMServerName + ";databaseName=" + ERMDatabasename + ";integratedSecurity=true";
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		
////		
////		try {	
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			
////			connERM = DriverManager.getConnection(ERMUrl);
////			connDigital = DriverManager.getConnection(digitalUrl);
////			
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connERM.createStatement();
////
////			
////			System.out.println(ERMMultipleTXNONTXAccounts);
////			ResultSet rs = stmt.executeQuery(ERMMultipleTXNONTXAccounts);
////			System.out.println(rs);
////
////					
////			while (rs.next()) {
////			
////				int count2 = 0;
////				int count3 = 0;
////								
////				String ERMTXAdditionalChecksX = ERMTXNonTXAdditionalChecks.replace("REPLACE_CUST_ID", rs.getString("CustomerID"));
////				records.put("CustomerID", rs.getString("CustomerID"));
////				System.out.println(ERMTXAdditionalChecksX);				
////				ResultSet rs1 = stmt1.executeQuery(ERMTXAdditionalChecksX);
////				
////				while (rs1.next()) {
////
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count2 == 0) {
////									records.put("BillingAccountNumberTX", rs1.getString("BillingAccount"));
////									++count2;
////								}
////
////								if(!rs1.getString("State").trim().equalsIgnoreCase("TX") && count3 == 0) {
////									records.put("BillingAccountNumberNonTX", rs1.getString("BillingAccount"));
////									++count3;
////								}
////								
////								if(count2 == 1 && count3 == 1 ) {
////									break;
////								}
////				
////			}	
////				if(count2 == 1 && count3 == 1 ) {
////					break;
////				}
////		}
////			connERM.close();
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////		
////	/**
////	 * 
////	 * Method Name : retrieveMultipleTXAccountNumbers
////	 * Description : This method will fetch multiple ERM TX account number with invoices available
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String, String> retrieveMultipleTXAccountNumbers(Commodity commodity, String query) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String ERMServerName = config.getProperty("ERMServerName");
////		String ERMDatabasename = config.getProperty("ERMDatabasename");
////		
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////					
////		String ERMMultipleTXNONTXAccounts = query;
////		String ERMTXNonTXAdditionalChecks = config.getProperty("ERMTXNonTXAdditionalChecks");
////	
////		Connection connERM = null;
////		Connection connDigital = null;
////		
////		String ERMUrl = "jdbc:sqlserver://" + ERMServerName + ";databaseName=" + ERMDatabasename + ";integratedSecurity=true";
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		
////		
////		try {	
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			
////			connERM = DriverManager.getConnection(ERMUrl);
////			connDigital = DriverManager.getConnection(digitalUrl);
////			
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connERM.createStatement();
////
////			
////			System.out.println(ERMMultipleTXNONTXAccounts);
////			ResultSet rs = stmt.executeQuery(ERMMultipleTXNONTXAccounts);
////			System.out.println(rs);
////
////					
////			while (rs.next()) {
////			
////				int count2 = 0;
////				int count3 = 0;
////								
////				String ERMTXAdditionalChecksX = ERMTXNonTXAdditionalChecks.replace("REPLACE_CUST_ID", rs.getString("CustomerID"));
////				records.put("CustomerID", rs.getString("CustomerID"));
////				System.out.println(ERMTXAdditionalChecksX);				
////				ResultSet rs1 = stmt1.executeQuery(ERMTXAdditionalChecksX);
////				
////				while (rs1.next()) {
////
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count2 == 0) {
////									records.put("BillingAccountNumberTX1", rs1.getString("BillingAccount"));
////									++count2;
////							
////								}
////								
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count3 == 0 && count2 == 2) {
////									records.put("BillingAccountNumberTX2", rs1.getString("BillingAccount"));
////									++count3;
////								}
////								
////								if(count2 == 1) {
////									++count2;
////							
////								}
////								
////								if(count2 == 2 && count3 == 1 && !records.get("BillingAccountNumberTX1").isEmpty() && !records.get("BillingAccountNumberTX2").isEmpty()) {
////									break;
////								}
////				
////			}	
////				if(count2 == 2 && count3 == 1 && !records.get("BillingAccountNumberTX1").isEmpty() && !records.get("BillingAccountNumberTX2").isEmpty()) {
////					break;
////				}
////		}
////			connERM.close();
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////	public synchronized Map<String, String> retrieveMultipleTXAccountNumbers1(Commodity commodity, String query) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String ERMServerName = config.getProperty("ERMServerName");
////		String ERMDatabasename = config.getProperty("ERMDatabasename");
////		
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////					
////		String ERMMultipleTXNONTXAccounts = query;
////		String ERMTXNonTXAdditionalChecks = config.getProperty("ERMTXNonTXAdditionalChecks");
////	
////		Connection connERM = null;
////		Connection connDigital = null;
////		
////		String ERMUrl = "jdbc:sqlserver://" + ERMServerName + ";databaseName=" + ERMDatabasename + ";integratedSecurity=true";
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		
////		
////		try {	
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			
////			connERM = DriverManager.getConnection(ERMUrl);
////			connDigital = DriverManager.getConnection(digitalUrl);
////			
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connERM.createStatement();
////
////			
////			System.out.println(ERMMultipleTXNONTXAccounts);
////			ResultSet rs = stmt.executeQuery(ERMMultipleTXNONTXAccounts);
////			System.out.println(rs);
////
////					
////			while (rs.next()) {
////			
////				int count2 = 0;
////				int count3 = 0;
////								
////				String ERMTXAdditionalChecksX = ERMTXNonTXAdditionalChecks.replace("REPLACE_CUST_ID", rs.getString("CustomerID"));
////				records.put("CustomerID", rs.getString("CustomerID"));
////				System.out.println(ERMTXAdditionalChecksX);				
////				ResultSet rs1 = stmt1.executeQuery(ERMTXAdditionalChecksX);
////				
////				while (rs1.next()) {
////
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count2 == 0) {
////									records.put("BillingAccountNumberTX1", rs1.getString("BillingAccount"));
////									++count2;
////							
////								}
////								
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count3 == 0 && count2 == 2) {
////									records.put("BillingAccountNumberTX2", rs1.getString("BillingAccount"));
////									++count3;
////								}
////								
////								if(count2 == 1) {
////									++count2;
////							
////								}
////								
////								if(count2 == 2 && count3 == 1 && !records.get("BillingAccountNumberTX1").isEmpty() && !records.get("BillingAccountNumberTX2").isEmpty()) {
////									break;
////								}
////				
////			}	
////				if(count2 == 2 && count3 == 1 && !records.get("BillingAccountNumberTX1").isEmpty() && !records.get("BillingAccountNumberTX2").isEmpty()) {
////					break;
////				}
////		}
////			connERM.close();
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////	/**
////	 * 
////	 * Method Name : retrieveZip
////	 * Description : This method will retrieve Zip once the ERM account number is found with invoices
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String, String> retrieveZip(String AccountNo) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String retrieveAccountNoAndZipQuery = config.getProperty("ERMShipToZip");
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		Connection connDigital = null;
////
////		try {
////
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDigital = DriverManager.getConnection(digitalUrl);
////
////			Statement stmt = connDigital.createStatement();
////			retrieveAccountNoAndZipQuery = retrieveAccountNoAndZipQuery.replace("REPLACE_ACCOUNTNO", AccountNo);
////			System.out.println(retrieveAccountNoAndZipQuery);	
////			ResultSet rs = stmt.executeQuery(retrieveAccountNoAndZipQuery);
////
////			while (rs.next()) {
////				records.put("ShipToBillZip", rs.getString("ShipToBillZip"));
////				System.out.println(rs.getString("ShipToBillZip"));
////				connDigital.close();
////				return records;
////			}
////			connDigital.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////	
////	/**
////	 * 
////	 * Method Name : fetchERMTXAccountNumber
////	 * Description : This method will fetch ERM TX account number with invoices available
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized Map<String, String> fetchERMTXAccountNumberDig(Commodity commodity, String query) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		String ERMServerName = config.getProperty("ERMServerName");
////		String ERMDatabasename = config.getProperty("ERMDatabasename");
////		
////		String digitalDBServerName = config.getProperty("DigitalDBServerName");
////		String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////					
////		String ERMMultipleTXNONTXAccounts = query;
////		String ERMTXNonTXAdditionalChecks = config.getProperty("ERMTXNonTXAdditionalChecks");
////	
////		Connection connERM = null;
////		Connection connDigital = null;
////		
////		String ERMUrl = "jdbc:sqlserver://" + ERMServerName + ";databaseName=" + ERMDatabasename + ";integratedSecurity=true";
////		String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////		
////		
////		try {	
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			
////			connERM = DriverManager.getConnection(ERMUrl);
////			connDigital = DriverManager.getConnection(digitalUrl);
////			
////			Statement stmt = connDigital.createStatement();
////			Statement stmt1 = connERM.createStatement();
////
////			
////			System.out.println(ERMMultipleTXNONTXAccounts);
////			ResultSet rs = stmt.executeQuery(ERMMultipleTXNONTXAccounts);
////			System.out.println(rs);
////
////					
////			while (rs.next()) {
////			
////				int count2 = 0;
////								
////				String ERMTXAdditionalChecksX = ERMTXNonTXAdditionalChecks.replace("REPLACE_CUST_ID", rs.getString("SourceCustomerID"));
////				records.put("CustomerID", rs.getString("SourceCustomerID"));
////				System.out.println(ERMTXAdditionalChecksX);				
////				ResultSet rs1 = stmt1.executeQuery(ERMTXAdditionalChecksX);
////				
////				while (rs1.next()) {
////
////								if(rs1.getString("State").trim().equalsIgnoreCase("TX") && count2 == 0) {
////									records.put("BillingAccountNumberTX1", rs1.getString("BillingAccount"));
////									records.put("BalanceDue", rs1.getString("TotalOutstandingBalance"));
////									++count2;
////									rs1.next();
////								}
////								if(!rs1.getString("State").trim().equalsIgnoreCase("TX") && count2 == 0) {
////									records.put("BillingAccountNumberNonTX", rs1.getString("BillingAccount"));
////									records.put("BalanceDue", rs1.getString("TotalOutstandingBalance"));
////									++count2;
////									rs1.next();
////								}
////
////								
////								
////								if(count2 == 1 ) {
////									break;
////								}
////				
////			}	
////				if(count2 == 1) {
////					break;
////				}
////		}
////			connERM.close();
////			connDigital.close();
////			return records;
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return records;
////	}
////	
////
////	
////	/**
////	 * 
////	 * Method Name : validateDocumentLandinginDiscovery
////	 * Description : This method will fetch ERM TX account number with invoices available
////	 * Author      : cog_cisrael
////	 * Return Type : String
////	 * Parameters   : 
////	 * Date        : April 24, 2019
////	 * Version     : 1.0
////	 */
////	
////	public synchronized String validateDocumentLandinginDiscovery(String AccountNo, String fileName, String fileExtension, EnrollmentJourney docTypeCode) {
////		String resultLog="";
////		ResultSet rs=null;
////		Connection connDiscovery = null;
////		try {
////			for(int i=0;i<100;i++) {
////			String DiscoveryServerName = config.getProperty("DiscoveryServerName");
////			String DiscoverydatabaseName = config.getProperty("DiscoverydatabaseName");
////
////			String DiscoveryDocumentvalidationQuery = config.getProperty("DiscoveryDocumentvalidationQuery");
////			DiscoveryDocumentvalidationQuery=DiscoveryDocumentvalidationQuery.replace("REPLACE_ACCOUNT_NUMBER",AccountNo);
////						
////			String DiscoveryUrl = "jdbc:sqlserver://" + DiscoveryServerName + ";databaseName=" + DiscoverydatabaseName + ";integratedSecurity=true";
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			connDiscovery = DriverManager.getConnection(DiscoveryUrl);
////			Statement stmt = connDiscovery.createStatement();
////			System.out.println(DiscoveryDocumentvalidationQuery);
////			rs = stmt.executeQuery(DiscoveryDocumentvalidationQuery);
////			if(rs.next()==true) {
////				break;					
////				 }
////				 Thread.sleep(1000);
////			}
////				System.out.println(rs);					
////															
////					String Original_FilenameDB=rs.getString("Original_Filename");
////					String ExtensionDB=rs.getString("Extension");
////					String DocTypeCodeDB=rs.getString("DocTypeCode");					
////					fileName=StringUtils.substringBefore(fileName, ".");
////					 Assert.assertTrue(Original_FilenameDB.equalsIgnoreCase(StringUtils.substringBefore(fileName, ".")), "Filename is not correct or Empty");
////
////			         if (Original_FilenameDB.equalsIgnoreCase(StringUtils.substringBefore(fileName, "."))) {
////			             resultLog = resultLog + "<pre> FileName : " + fileName +" matches with DB </pre>";
////			     }
////			         else {
////			         resultLog = resultLog + "<pre> FileName : " + StringUtils.substringBefore(fileName, ".") + " doesn't match with DB </pre>";
////			     }
////			         Assert.assertTrue(ExtensionDB.equalsIgnoreCase(fileExtension), "FileExtension is not correct or Empty");
////
////			         if (ExtensionDB.equalsIgnoreCase(fileExtension)) {
////			             resultLog = resultLog + "<pre> FileExtension : " + fileExtension +" matches with DB </pre>";
////			         }
////			         else {
////			         resultLog = resultLog + "<pre> FileExtension : " + fileExtension + " doesn't match with DB </pre>";
////			     }
////			         Assert.assertTrue(DocTypeCodeDB.equalsIgnoreCase(docTypeCode.toString()), "DocTypeCode is not correct or Empty");
////			         if (DocTypeCodeDB.equalsIgnoreCase(docTypeCode.toString())) {
////			             resultLog = resultLog + "<pre> DocTypeCode : " + docTypeCode + "  matches with DB </pre>";
////			         }
////			         else {
////			         resultLog = resultLog + "<pre> DocTypeCode : " + docTypeCode + " doesn't match with DB </pre>";
////			     
////					
////				}
////				if(resultLog.length()<1){
////					Assert.assertTrue(resultLog.length()>1, "NO RECORDS CREATED IN DATABASE!!!");
////				}
////			
////				connDiscovery.close();
////
////
////			
////		} catch (ClassNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return resultLog;
////	}
////	
////	/**
////	 * 
////	 * Method Name : ValidateAccountAvailablityInDigitalDB
////	 * Description : This method will check whether customer is available in MyAccount Digital or not
////	 * Author      : Sathish
////	 * Return Type : Boolean
////	 * Paramters   : CustomerName
////	 * Date        : FEB 18, 2020
////	 * Version     : 1.0
////	 */
////
////	public synchronized boolean ValidateAccountAvailablityInDigitalDB(String BillingAccountNO, String CustomerName) {
////
////
////		String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////		String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String FetchMyAccountcustomer = config.getProperty("FetchMyAccountcustomer");
////		FetchMyAccountcustomer = FetchMyAccountcustomer.replace("REPLACE_ACCOUNT_NUMBER", BillingAccountNO.toString());
////		String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(DigitalUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(DigitalUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchMyAccountcustomer);
////			ResultSet rs = stmt.executeQuery(FetchMyAccountcustomer);
////			while (rs.next()) {
////					return true;
////				}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {				
////				conn.close();
////			} catch (Exception e1) {
////			}
////		}
////		return false;	
////	}	
////	public synchronized boolean ValidateAccountAvailablityInDigitalDB1(String BillingAccountNO, String CustomerName) {
////
////
////		String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////		String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String FetchMyAccountcustomer = config.getProperty("FetchMyAccountcustomer1");
////		FetchMyAccountcustomer = FetchMyAccountcustomer.replace("REPLACE_ACCOUNT_NUMBER", BillingAccountNO.toString());
////		String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(DigitalUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(DigitalUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchMyAccountcustomer);
////			ResultSet rs = stmt.executeQuery(FetchMyAccountcustomer);
////			while (rs.next()) {
////					return true;
////				}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {				
////				conn.close();
////			} catch (Exception e1) {
////			}
////		}
////		return false;	
////	}	
////	
////	
////	
////	
////	
////	/**
////	 * 
////	 * Method Name : FetchCustomerNamefromDigitalBD
////	 * Description : This method will fetch the customer available in MyAccount Digital DB
////	 * Author      : Sathish
////	 * Return Type : Boolean
////	 * Paramters   : CustomerName
////	 * Date        : SEP 16, 2020
////	 * Version     : 1.0
////	 */
////
////	public synchronized String FetchCustomerNamefromDigitalBD(String BillingAccountNO) {
////
////
////		String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////		String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String FetchMyAccountcustomer = config.getProperty("FetchMyAccountcustomer");
////		FetchMyAccountcustomer = FetchMyAccountcustomer.replace("REPLACE_ACCOUNT_NUMBER", BillingAccountNO.toString());
////		String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(DigitalUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(DigitalUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchMyAccountcustomer);
////			ResultSet rs = stmt.executeQuery(FetchMyAccountcustomer);
////			while (rs.next()) {
////					return rs.getString("StandardCompanyName");
////				}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {				
////				conn.close();
////			} catch (Exception e1) {
////			}
////		}
////		return "Exception in connecting DB";	
////	}
////	public synchronized String FetchCustomerNamefromDigitalBD1(String BillingAccountNO) {
////
////
////		String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////		String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String FetchMyAccountcustomer = config.getProperty("FetchMyAccountcustomer1");
////		FetchMyAccountcustomer = FetchMyAccountcustomer.replace("REPLACE_ACCOUNT_NUMBER", BillingAccountNO.toString());
////		String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(DigitalUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(DigitalUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchMyAccountcustomer);
////			ResultSet rs = stmt.executeQuery(FetchMyAccountcustomer);
////			while (rs.next()) {
////					return rs.getString("StandardCompanyName");
////				}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {				
////				conn.close();
////			} catch (Exception e1) {
////			}
////		}
////		return "Exception in connecting DB";	
////	}
////	
////	/**
////	 * 
////	 * Method Name : FetchCustomerNamefromDigitalBD
////	 * Description : This method will fetch the customer available in MyAccount Digital DB
////	 * Author      : Sathish
////	 * Return Type : Boolean
////	 * Paramters   : CustomerName
////	 * Date        : SEP 16, 2020
////	 * Version     : 1.0
////	 */
////
////	public synchronized String FetchShipToBillZipfromDigitalBD(String BillingAccountNO, String requiredData) {
////
////
////		String DigitalDBServerName = config.getProperty("DigitalDBServerName");
////		String DigitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////		String FetchMyAccountcustomer = config.getProperty("FetchMyAccountcustomer");
////		FetchMyAccountcustomer = FetchMyAccountcustomer.replace("REPLACE_ACCOUNT_NUMBER", BillingAccountNO.toString());
////		String DigitalUrl = "jdbc:sqlserver://"+DigitalDBServerName+";databaseName="+DigitalDBdatabaseName+";integratedSecurity=true";
////
////		System.out.println(DigitalUrl);
////		Connection conn = null;
////		try {
////			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////			conn = DriverManager.getConnection(DigitalUrl);
////			Statement stmt = conn.createStatement();
////			System.out.println(FetchMyAccountcustomer);
////			ResultSet rs = stmt.executeQuery(FetchMyAccountcustomer);
////			while (rs.next()) {
////					return rs.getString(requiredData);
////				}
////			conn.close();
////		} catch (Exception e) {
////			e.printStackTrace();
////			try {				
////				conn.close();
////			} catch (Exception e1) {
////			}
////		}
////		return "Exception in connecting DB";	
////	}
////	
////	public synchronized Map<String, String> fetchRMCustomerDetails(AccountType accountType,AccountStatus accountStatus) {
////		Map<String,String> records = new HashMap<String,String>();
////
////		try {
////			String digitalDBServerName = config.getProperty("DigitalDBServerName");
////			String digitalDBdatabaseName = config.getProperty("DigitalDBdatabaseName");
////			String retrieveAccountNoAndZipQuery = config.getProperty("RetrieveAccountNoAndZip");
////			String digitalUrl = "jdbc:sqlserver://"+digitalDBServerName+";databaseName="+digitalDBdatabaseName+";integratedSecurity=true";
////			Connection connDigital = null;
////
////			try {
////
////				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////				connDigital = DriverManager.getConnection(digitalUrl);
////
////				Statement stmt = connDigital.createStatement();
////				retrieveAccountNoAndZipQuery = retrieveAccountNoAndZipQuery.replace("_REPLACE_BILLING_SOURCE_", accountType.toString()).replace("_REPLACE_SHIP_TO_STATUS_", accountStatus.toString());
////				System.out.println(retrieveAccountNoAndZipQuery);
////				ResultSet rs = stmt.executeQuery(retrieveAccountNoAndZipQuery);
////				Random rand = new Random();
////				int rowCount = 0;
////				int randNum =0;
////				while (rs.next()) {
////					rowCount++;
////				}
////				System.out.println("Row Count:"+rowCount);
////				rs = stmt.executeQuery(retrieveAccountNoAndZipQuery);
////				
////				randNum = rand.nextInt(rowCount);
////				if(randNum==rowCount) {
////					randNum =randNum-1;	
////				}
////				if(randNum==0) {
////				randNum =randNum+1;
////			    }
////				
////				System.out.println("Random Number:"+randNum);
////				int count = 1;
////				while (rs.next()) {
////					if(count == randNum) {
////					
////					records.put("AccountNumber", rs.getString("AccountNumber"));
////					records.put("CustomerName", rs.getString("StandardCompanyName"));
////					records.put("SourceCustomerID",rs.getString("SourceCustomerID"));
////					records.put("BillingZipCode",rs.getString("ShipToBillZip"));
////					return records;
////					}
////					count++;
////				}
////				connDigital.close();
////				return records;
////
////			} catch (Exception e) {
////				e.printStackTrace();
////				try {
////					records.put("KEY", "NOT_FOUND");
////					connDigital.close();
////				} catch (Exception e1) {
////
////				}
////			}
////			records.put("KEY", "NOT_FOUND");
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return records;
////	}
//}
//
