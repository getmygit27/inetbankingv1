package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_addcustomer_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);//calling the constructor from login pageobject
		lp.setusername(username);
		log.info("User name is provided");
		lp.setpswrd(password);
		log.info("Passsword is provided");
		lp.loginbtn();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);//calling the constructor from addcustomer page object
		
		addcust.clickAddNewCustomer();
		
		log.info("providing customer details....");
		
		
		addcust.custName("Shubham");//here we are doing hardcoding
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		log.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed....");
			
		}
		else
		{
			log.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}