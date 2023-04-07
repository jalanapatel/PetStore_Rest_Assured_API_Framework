package api.utilities;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	
	public Excel_Utility (String path)
	
	{
		this.path = path;
	}
	
	
	public int getRowCount(String sheetName) throws IOException
	
	{
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		
		return rowCount;
	}
	
	
	
	public int getCellCount (String sheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		
	    int cellCount = row.getLastCellNum();
	    
	    workbook.close();
	    
	    fi.close();
	    
	    return cellCount;
	}
	
	
	public String getCellData (String sheetName, int rownum, int column) throws IOException             
	{
		
		fi = new FileInputStream(path);
		
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		
		
		DataFormatter formatter = new DataFormatter();
		
		String data;
		
		try {
		
			data = formatter.formatCellValue(cell);              // Returns the formatted value of a cell as String regardless of DataType.
			
			}
		catch (Exception e)
		{
			data = "";
		}
		
		
		workbook.close();
		fi.close();
		
		return data;
	}
	
	
	public void setCellData (String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File xlfile = new File(path);
		if (!xlfile.exists())              // If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		if (workbook.getSheetIndex(sheetName) == -1)     // if sheet not exists then create new sheet
			workbook.createSheet(sheetName);
		    sheet = workbook.getSheet(sheetName);
		    
		
		if (sheet.getRow(rownum) == null)
		      sheet.createRow(rownum);
		row = sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path);
		
		workbook.write(fo);
		workbook.close();
		
		fi.close();
		fo.close();
	}
	
	
	
	
	
	
	
	// fillRedColor() method is not used here in this project.
	
	public void fillRedColor (String sheetName, int rownum, int colmn) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook (fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colmn);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor((org.apache.poi.ss.usermodel.Color) Color.red);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		fi.close();
		fo.close();
		
	}
	
	
	
	
	
	
	
	
	

}
