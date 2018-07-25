package com.actitime.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Mohini
 *
 */
public class FileUtils {
	
String excelPath="C:\\Users\\Mohini Guntewar\\eclipse-workspace\\SeleniumActitimeFramework\\TestData\\testdata.xlsx";
String propertyFilePath="C:\\Users\\Mohini Guntewar\\eclipse-workspace\\SeleniumActitimeFramework\\TestData\\Common.properties";
/**
 * 
 * @return
 * @throws Throwable
 * 
 * its return object of the properties file & load all the keys
 * 
 */
public Properties getPropertiesFileObj() throws Throwable
{
	FileInputStream fis=new FileInputStream(propertyFilePath);
	Properties pobj=new Properties();
	pobj.load(fis);
	return pobj;
}
/**
 * @param sheetName, rowNum, colNum
 * @return String
 * @throws Throwable 
 * @throws Throwable 
 * @throws Throwable
 * its used to read the data from ExcelFile based on User argument
 * 
 */
public String getExcelData(String sheetName,int rowNum, int colNum) throws Throwable 
{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowNum);
	String data=row.getCell(colNum).getStringCellValue();
	return data;
}
/**
 * 
 * @param SheetName
 * @param RowNum
 * @param ColNum
 * @param data
 * @param throws
 * 
 * its used to write data back to excel based on user argument
 */
public void setExcelData(String sheetName,int rowNum, int colNum,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row row=sh.getRow(rowNum);
	Cell cel=row.createCell(colNum);
	cel.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(excelPath);
	wb.write(fos);
	wb.close();
}
}
