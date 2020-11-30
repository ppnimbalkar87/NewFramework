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
	
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(id="user_pass") WebElement password;
	@FindBy(xpath="//input[@name='wp-submit']") WebElement LoginButton;
	
	
	public void loginToApp(String AppUsername,String AppPassword)
	{
		username.sendKeys(AppUsername);
		password.sendKeys(AppPassword);
		LoginButton.click();
	}

}
