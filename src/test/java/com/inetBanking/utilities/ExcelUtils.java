package com.inetBanking.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelUtils(String ExcelPath, String SheetName) throws Exception
	{

		FileInputStream fis = new FileInputStream(ExcelPath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(SheetName);
	}


	public int getRowCount() throws Exception 	
	{
		int rowCount = sheet.getPhysicalNumberOfRows();    //this will give the number of rows
		System.out.println("No of rows :"+rowCount);
		return rowCount;
	}


	public int getColCount() throws Exception 	
	{
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();   //this will give the number of columns
		System.out.println("No of cols :"+colCount);
		return colCount;
	}


	public String getCellDataString(int rowNum, int colNum)
	{
		String cellData = null;
		try 
		{
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue(); //this will give the String cell value
			//System.out.println(cellData);
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return cellData;
	}


	public double getCellDataNumber(int rowNum, int colNum) throws Exception 
	{
		Double cellData = null;
		try 
		{
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue(); //this will give the Numeric cell value
			System.out.println(cellData);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return cellData;
	}

}