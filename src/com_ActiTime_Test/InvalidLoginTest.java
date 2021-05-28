package com_ActiTime_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.base.Ascii;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Generic.ExcelData;
import com_ActiTime_Page.ActiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void invalidLogin() throws Exception
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
		//verify Login page should be displayed
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i =1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			//Enter invalid username
			Reporter.log("Invalid user name = "+un,true);
			lp.enterUserName(un);
			//Enter invalid password
			Reporter.log("Invalid Password = "+pw,true);
			lp.enterPassword(pw);
			//click on Login
			lp.clickOnLoginButton();
			
			String aErrorMessage = lp.verifyErrorMessage();
			String eErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
			Assert.assertEquals(aErrorMessage, eErrorMessage);
			Reporter.log("======================================",true);
			Thread.sleep(1000);
		}
	}
	

}
