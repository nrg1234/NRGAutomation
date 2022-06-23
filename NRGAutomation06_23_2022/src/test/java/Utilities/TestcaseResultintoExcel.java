package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import apphooks.Base;

public class TestcaseResultintoExcel {

	private Base base;

	public TestcaseResultintoExcel(Base base) {
		this.base = base;
	}

	 public void ResultintoExcel(String OpportunityID, String Testcase, String
	 Status) {
	//public static void main(String[] args) {

		try {

			// Create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream(
					new File(".\\src\\test\\resources\\DataReader\\Excelsheet.xlsx"));

			// Create object of XSSFWorkbook class
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Read excel sheet by sheet name
			XSSFSheet sheet = workbook.getSheet("Automation Script");

			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(1).getStringCellValue();
				if (ce.contains(Testcase)) {
					XSSFCell cell = sheet.getRow(i).getCell(6);
					XSSFCell cell1 = sheet.getRow(i).getCell(5);
					cell.setCellType(CellType.STRING);
					cell.setCellValue(OpportunityID);
					cell1.setCellValue(Status);
					// Write the output to the file
					FileOutputStream fileOut = new FileOutputStream(
							new File(".\\src\\test\\resources\\DataReader\\Excelsheet.xlsx"));
					workbook.write(fileOut);

					System.out.println("Id column in Excel is updated successfully");
					fileOut.close();
					break;

					// Closing the workbook
					//workbook.close();
//				}
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
