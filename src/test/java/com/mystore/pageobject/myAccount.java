package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	
WebDriver ldriver;
	
	public myAccount(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement registeredUsersEmail;
	
	@FindBy(id = "password")
	WebElement registeredUsersPwd;
	
	@FindBy(id = "login-button")
	WebElement submitLogin;
	
	
	public void enterUserName(String emailAdd) 
	{
		registeredUsersEmail.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) 
	{
		registeredUsersPwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		submitLogin.click();
	}

}
