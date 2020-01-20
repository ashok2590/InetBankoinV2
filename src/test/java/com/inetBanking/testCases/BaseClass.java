package com.inetBanking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.inetBanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;

public class BaseClass
{
	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	public static Logger logger;

	public String baseUrl = readconfig.getBaseUrl();
	public String userName = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public String chromePath = readconfig.getChromePath();
	public String firefoxPath = readconfig.getFirefoxPath();


	@Parameters("browser")
	@BeforeTest
	public void SetUp(String br) throws Exception 
	{	
		logger = LogManager.getLogger(BaseClass.class);
		
		if (br.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("FireFox")) 
		{
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("Url has been keyed");
		driver.manage().window().maximize();
	}

	public void CaptureScreenshot(String testName) throws Exception 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}
	
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}



}
