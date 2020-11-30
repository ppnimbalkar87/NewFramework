package com.testAutomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//CApturescrrenshot,handle frames,Alerts,mulwindows,syncissues,javascriptexecutor

public class Helper {
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/Newframework-"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(ScreenshotPath));
			System.out.println("Scrrenshot captured");
		} catch (Exception e) {
			System.out.println("Unable to capture Screenshot "+e.getMessage());
		}
		return ScreenshotPath;
	}

	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate=new Date();
		return customFormat.format(currentdate);
	}
}
