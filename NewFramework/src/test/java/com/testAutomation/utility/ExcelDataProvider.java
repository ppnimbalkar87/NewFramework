package com.testAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{
		
		File src=new File("./Testdata/LoginData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("unable to load Excel file "+e.getMessage());
		} 
	}
	
	public String readExcelData(String SheetName,int rowNo,int colNo) 
	{
		return wb.getSheet(SheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
//		data[0][1]=wb.getSheetAt(0).getRow(0).getCell(1).getStringCellValue();
	}

}
