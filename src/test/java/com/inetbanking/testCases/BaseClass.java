package com.inetbanking.testCases;






import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;



public class BaseClass {
    Readconfig readconfig=new Readconfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")//catching the browser parameter from tesng.xml file
	@BeforeClass//will be executed before testcase method
	public void setup(String br)//passing the parameter br as a browser variable
	{
		if(br.equals("chrome"))
		{System.setProperty("webdriver.chrome.driver",
			readconfig.getchromepath());
		 driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					readconfig.getfirefoxpath());
				 driver = new FirefoxDriver();
		}
		else if(br.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver",
					readconfig.getEdgepath());
				 driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		
		 log = Logger.getLogger(BaseClass.class);
			PropertyConfigurator.configure("Log4j2.properties");
	    
	}
	//@AfterClass//will be executed after test cases are executed
	/*public void teardown()
	{
	 driver.quit();
	}*/
	//Now method for taking screenshots when test fails.
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
