package Utilities;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.DSP.LandingPage;
import Pages.DSP.SearchOpportunity;
import apphooks.Base;

public class WriteExcel {
	private Base base;

	public WriteExcel(Base base) {
		this.base = base;
	}

//   public static void main(String[] args){
////public void write(String OpportunityID) {
//
//	XSSFWorkbook workbook = new XSSFWorkbook();
//
//	XSSFSheet sheet = workbook.createSheet("VHOSOL_Opportunity");
//
//     Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[] { "OpportunityID"});
//        data.put("2", new Object[] {"123456"});
//       Set<String> keyset = data.keySet();int rownum = 0;
//       for (String key : keyset){Row row = sheet.createRow(rownum++);Object [] objArr = data.get(key);
//       int cellnum = 0;
//       for (Object obj : objArr){Cell cell = row.createCell(cellnum++);
//       if(obj instanceof String)
//                    cell.setCellValue((String)obj);
//                    else if(obj instanceof Integer)
//                    cell.setCellValue((Integer)obj);}}
//try{
//	FileOutputStream out = new FileOutputStream(new File(".\\src\\test\\resources\\DataReader\\VHOSOL_Inflight_opportunity.xlsx"));
//            workbook.write(out);
//            out.close();
//            System.out.println("Newopty  written successfully on disk.");
//            }
//catch (Exception e){
//            e.printStackTrace();
//            }}}
//public static void main(String[] args){
	public void UpdateExcel(String OpportunityID, int Rowvalue) {
		int a = Rowvalue;
		ConfigReader config = new ConfigReader();
		Properties prop = config.init_properties();
		// String siteissue="Site error Exception";
		try {

			// Create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream(new File(prop.getProperty("Excelpath")));

			// Create object of XSSFWorkbook class
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Read excel sheet by sheet name
			XSSFSheet sheet = workbook.getSheet("Data");

			// Get the Cell at index from the above row
			XSSFCell cell = sheet.getRow(a + 1).getCell(54);

			cell.setCellType(CellType.STRING);
			cell.setCellValue(OpportunityID);

			// Write the output to the file
			FileOutputStream fileOut = new FileOutputStream(new File(prop.getProperty("Excelpath")));
			workbook.write(fileOut);

			System.out.println("Id column in Excel is updated successfully");
			fileOut.close();

			// Closing the workbook
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
