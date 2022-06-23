package Utilities;

	
	import java.io.*;
	import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import apphooks.Base;

import java.util.Locale;
	
	public class DataReaderEXCEL {
		
		private String fileName;
		private String sheetName;
		private String testName;
		Sheet sheet;
		WebDriver driver;
		public DataReaderEXCEL(Base base) {
			this.driver = base.driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public String get(String dataName) {
			InputStream inputStream;
			Workbook wb;
			DataFormatter formatter = new DataFormatter(Locale.US);
			try {
				
				if(sheet==null) {
					inputStream = new FileInputStream(new File(fileName));
					wb = WorkbookFactory.create(inputStream);
					sheet = wb.getSheet(sheetName);
				}

				boolean firstRow = true;
				Row dtColumnNames = null;
				for (Row row : sheet) {
					if (firstRow == true) {
						dtColumnNames = row;
						firstRow = false;
						continue;
					}
					
					Cell cell = row.getCell(1);
					String dtTestName = formatter.formatCellValue(cell).trim();
					//Reference is to point the row corresponding to the test which is being executed

						for(int column = 0;column<row.getLastCellNum();column++) {
							if(dtColumnNames.getCell(column).getStringCellValue().trim().equalsIgnoreCase(dataName.trim())) {
								return formatter.formatCellValue(row.getCell(column)).toString().trim();
							}
						}
					}
			
				return "NOT_FOUND";
				
			} catch (Exception e) {
				return "NOT_FOUND";
			}
		}
	}

