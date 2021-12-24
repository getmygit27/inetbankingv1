package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Ldriver;//our local driver
	
	public LoginPage(WebDriver rdriver)//this is our remote driver
	{
		Ldriver=rdriver;
		PageFactory.initElements(rdriver,this);//specifying page factory class
	}
	
	@FindBy(name="uid")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	WebElement lnkLogout;
	
	//Action methods
	public void setusername(String usernm)
	{
		Username.sendKeys(usernm);
	}
	
	public void setpswrd(String password)
	{
		Password.sendKeys(password);
	}
	
	public void loginbtn()
	{
		loginbtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
