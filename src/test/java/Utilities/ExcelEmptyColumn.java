package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelEmptyColumn {
	
	public static void main(String[]args) {

	try {
	    FileInputStream inputStr = new FileInputStream(".\\src\\test\\resources\\DataReader\\datadumpAggregate.xlsx");
	    XSSFWorkbook xssfWork = new XSSFWorkbook(".\\src\\test\\resources\\DataReader\\datadumpAggregate.xlsx") ;
	    XSSFSheet sheet1 = xssfWork.getSheetAt(0);
	    Iterator rowItr = sheet1.rowIterator();

//	    while ( rowItr.hasNext() ) {
//	        XSSFRow row = (XSSFRow) rowItr.next();
//	        System.out.println("ROW:-->");
//	        Iterator cellItr = row.cellIterator();
//
//	        while ( cellItr.hasNext() ) {
//	            XSSFCell cell = (XSSFCell) cellItr.next();
//	            System.out.println("CELL:-->"+cell.toString());
//	        }
//	    }
	    List cellDataList = new ArrayList(); 

	    int lineNumber = 0;   

	    while (rowItr.hasNext()) {
	        XSSFRow hssfRow = (XSSFRow)  rowItr.next();
	        //System.out.println("Befor If");
	        lineNumber++;
	        if(lineNumber==1){continue;}
	        //System.out.println("Out side if ");

	        Iterator<Cell> iterator = hssfRow.cellIterator();
	        List<Cell> cellTempList = new ArrayList();
	        int current = 0, next = 1;
	        while (iterator.hasNext()) {
	          Cell hssfCell = iterator.next();
	          current = hssfCell.getColumnIndex();

	          if(current<next){
	              System.out.println("Condition Satisfied");
	          }
	          else{
	              int loop = current-next;
	              System.out.println("inside else Loop value : "+(loop));
	              for(int k=0;k<loop+1;k++){
	                 System.out.println("Adding nulls");
	                 cellTempList.add(null);
	                 next = next + 1;
	              }
	          }

	          cellTempList.add(hssfCell);

	          next = next + 1;
	          System.out.println("At End  next value is : "+next);
	      }
	      cellDataList.add(cellTempList);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

}}
