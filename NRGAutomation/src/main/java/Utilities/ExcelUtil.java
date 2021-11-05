package Utilities;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private Logger log = Logger.getLogger(ExcelUtil.class);

    public List<Map<String, Object>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    public List<Map<String, Object>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    public void writeSheet(String excelFilePath, String sheetName, List<Map<String, Object>> data)
            throws IOException, InvalidFormatException {
        File filePath = new File(excelFilePath);
        if (filePath.exists())
            log.info("File exists");
        else {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
            workbook.write(fileOutputStream);
            log.info("New file created");
        }
        FileInputStream excelFileInputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(excelFileInputStream);
        if (sheetName.equalsIgnoreCase("Customer_Service_Info")) {
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int index = numberOfSheets - 1; index >= 0; index--) {
                workbook.removeSheetAt(index);
            }
        }
        Sheet sheet = workbook.createSheet(sheetName);
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = setHeaderCellStyle(workbook);
        CellStyle dataCellStyle = setDataCellStyle(workbook);

        int headerCol = 0;
        for (String key : data.get(0).keySet()) {
            Cell headerCell = headerRow.createCell(headerCol);
            headerCell.setCellStyle(headerCellStyle);
            headerCell.setCellValue(key);
            headerRow.setHeightInPoints(35);
            sheet.setColumnWidth(headerCol, 20 * 256);
            sheet.setDisplayGridlines(false);
            headerCol += 1;
        }

        int dataRow = 1;
        for (Map<String, Object> rowData : data) {
            int dataCol = 0;
            Row row = sheet.createRow(dataRow);
            for (String key : rowData.keySet()) {
                Cell dataCell = row.createCell(dataCol);
                dataCell.setCellStyle(dataCellStyle);
                dataCell.setCellValue(key);
                dataCell.setCellValue(rowData.get(key).toString());
                row.setHeightInPoints(30);
                dataCol += 1;
            }
            dataRow += 1;
        }
        FileOutputStream excelFileoutputStream = new FileOutputStream(excelFilePath);
        workbook.write(excelFileoutputStream);
        workbook.close();
    }

    private List<Map<String, Object>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = 0;
        int totalPhysicalRows = sheet.getPhysicalNumberOfRows();
        for (int r = 0; r < totalPhysicalRows; r++) {
            if (sheet.getRow(r).getCell(0).getStringCellValue() == "")
                break;
            else
                totalRow = r + 1;
        }

        List<Map<String, Object>> excelRows = new ArrayList<Map<String, Object>>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, Object> columnMapdata = new LinkedHashMap<String, Object>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        excelRows.remove(excelRows.size() - 1);
        return excelRows;
    }

    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == CellType.STRING) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.STRING) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    if (columnHeaderName.toLowerCase().contains("date"))
                        columnMapdata.put(columnHeaderName,
                                String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue())));
                    else
                        columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == CellType.ERROR) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }

    private CellStyle setHeaderCellStyle(Workbook workbook) {
        HSSFWorkbook paletteWorkbook = new HSSFWorkbook();
        HSSFPalette palette = paletteWorkbook.getCustomPalette();
        HSSFColor myColor = palette.findSimilarColor(255, 192, 0);
        short palIndex = myColor.getIndex();

        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerCellStyle.setFillForegroundColor(palIndex);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setWrapText(true);
        return headerCellStyle;
    }

    private CellStyle setDataCellStyle(Workbook workbook) {
        HSSFWorkbook paletteWorkbook = new HSSFWorkbook();
        HSSFPalette palette = paletteWorkbook.getCustomPalette();
        HSSFColor myColor = palette.findSimilarColor(206, 228, 188);
        short palIndex = myColor.getIndex();

        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        dataCellStyle.setAlignment(HorizontalAlignment.LEFT);
        dataCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataCellStyle.setFillForegroundColor(palIndex);
        dataCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        dataCellStyle.setWrapText(true);
        return dataCellStyle;
    }
}
