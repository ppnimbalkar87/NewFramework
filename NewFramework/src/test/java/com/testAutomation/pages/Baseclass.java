package com.testAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testAutomation.utility.BrowserFactory;
import com.testAutomation.utility.ConfigDataProvider;
import com.testAutomation.utility.ExcelDataProvider;
import com.testAutomation.utility.Helper;

public class Baseclass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupSuit()
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/NewFramework_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	@BeforeClass
	public void setup() 
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quiteBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
	}
}
