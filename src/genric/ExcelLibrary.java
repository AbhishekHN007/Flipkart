package genric;

import java.io.FileInputStream;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public static Double getNumericCellData(String filePath,String sheetName,int row,int cell) {
		try {
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook=WorkbookFactory.create(file);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getStringCellData(String filePath,String sheetName,int row,int cell) {
		try {
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook=WorkbookFactory.create(file);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Boolean getBooleanCellData(String filePath,String sheetName,int row,int cell) {
		try {
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook=WorkbookFactory.create(file);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getBooleanCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static LocalDateTime getDateCellData(String filePath,String sheetName,int row,int cell) {
		try {
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook=WorkbookFactory.create(file);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getLocalDateTimeCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String[][] getMultipleCellData(String filePath,String sheetName) {
		try {
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook=WorkbookFactory.create(file);
			Sheet sheet=workbook.getSheet(sheetName);
			int row=sheet.getPhysicalNumberOfRows();
			int cell=sheet.getRow(0).getPhysicalNumberOfCells();
			String[][] sarr=new String[row-1][cell];
			for(int i=1,k=0;i<=row-1;i++,k++) {
				for(int j=0;j<=cell-1;j++) {
					sarr[j][k]=sheet.getRow(i).getCell(j).toString();	
				}
			}
			return sarr;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
