package com_ActiTime_Generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String file_path,String sheet_name,int rn, int cn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(file_path));
			String data = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	public static int getRowCount(String file_path,String sheet_name)
	{
		try
		{
			FileInputStream fis = new  FileInputStream(new File(file_path));
			int rc = WorkbookFactory.create(fis).getSheet(sheet_name).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	public static int getCellcount(String file_path,String sheet_name, int rn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(file_path));
			int cc = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getLastCellNum();
			return cc;
		}
		catch (Exception e)
		{
			return 0;
		}
	}
}
