package com.testAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Find all Locators
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement LoginButton;
	@FindBy(xpath="//input[@name='btnReset']") WebElement ResetButton;
	
	
	
	public void loginToApp(String AppUsername,String AppPassword)
	{
		username.sendKeys(AppUsername);
		password.sendKeys(AppPassword);
		LoginButton.click();
	}

}
