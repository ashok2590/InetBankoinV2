package com.inetBanking.testCases;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC01_LoginTest_001 extends BaseClass
{
	
	@Test
	public void Logintest() throws Exception 
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger = LogManager.getLogger(TC01_LoginTest_001.class);
		
		logger.fatal("Userid may be wrong, can cause fatal message");
		
		lp.setPassword(password);	
		logger.warn("Password may be wrong, can cause warning message");
		
		lp.btnLoginClick();
		logger.info("Login button has been clicked");
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);
			logger.info("Validation passed");	
			
		}
		else 
		{
			CaptureScreenshot("Logintest");
			Assert.assertTrue(false);
			
			logger.error("validation failed");
		}
		
		lp.lnkLogOutClick();
		logger.info("logged out from the application");
		
		driver.switchTo().alert().accept();
		logger.info("Selecting the logoff alert msg");
		
		
	}

}
