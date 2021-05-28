package com_ActiTime_Test;

import org.testng.annotations.Test;

import com_ActiTime_Generic.BaseTest;
import com_ActiTime_Generic.ExcelData;
import com_ActiTime_Page.ActiTIMEEnterTimeTrackPage;
import com_ActiTime_Page.ActiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void validLoginLogout()
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String hpTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
		ActiTIMEEnterTimeTrackPage hp = new ActiTIMEEnterTimeTrackPage(driver);
		//Verify Login page should be displayed
		lp.verifyTitle(lgTitle);
		//Enter valid username
		lp.enterUserName(un);
		//Enter valid password
		lp.enterPassword(pw);
		//click on Login
		lp.clickOnLoginButton();
		//verify Enter Time Track page should be displayed
		lp.verifyTitle(hpTitle);
		//click on Logout
		hp.clickOnLogout();
		//Verify Login page should be displayed
		lp.verifyTitle(lgTitle);
	}

}
