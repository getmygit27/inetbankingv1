package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
  @Test
  public void logintest() throws IOException
  {
	  
	  log.info("opened the url");
	  
	  LoginPage lp= new LoginPage(driver);
	  lp.setusername(username);
	  log.info("enterd the username");
	  
	  lp.setpswrd(password);
	  log.info("enterd the password");
	  
	  lp.loginbtn();
	  log.info("clicked the submit btn");
	  
	  if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
	  {
		  Assert.assertTrue(true);
		  log.info("test passed");
		  
	  }
	  else
		  {
		  captureScreen( driver,"logintest");
		  Assert.assertTrue(false);
	      log.info("test failed");
		  }
	  
  }
	
	
}
