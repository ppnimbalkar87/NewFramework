package com.testAutomation.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testAutomation.pages.Baseclass;
import com.testAutomation.pages.LoginPage;
import com.testAutomation.utility.BrowserFactory;
import com.testAutomation.utility.ExcelDataProvider;
import com.testAutomation.utility.Helper;

public class LoginTestWordpress extends Baseclass {
	
	@Test
	public void LoginToWordpress()
	{
		logger=report.createTest("Login to Wordpress");
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		login.loginToApp(excel.readExcelData("Login",0, 0), excel.readExcelData("Login",0, 1));
		logger.pass("Test Passed.Login to wordpress");
	}

}
