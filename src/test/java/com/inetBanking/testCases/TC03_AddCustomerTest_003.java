package com.inetBanking.testCases;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;


public class TC03_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void AddCust_001() throws Exception 
	{
		LoginPage lp = new LoginPage(driver);
		logger = LogManager.getLogger(TC03_AddCustomerTest_003.class);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.btnLoginClick();

		//Thread.sleep(5000);
		AddCustomerPage addcuspage = new AddCustomerPage(driver);
		
		addcuspage.selectNewCustomerLink();
		logger.info("link has been clicked");
		addcuspage.enterCustomerName("user");
		logger.info("username has been entered");
		addcuspage.selectGenderMale();
		logger.info("Gender has been selected");
		addcuspage.selectDOB("08", "03", "1990");
		addcuspage.enterAddress("123 karnataka");
		addcuspage.enterCity("Jaipur");
		addcuspage.enterState("Karnataka");
		addcuspage.enterPIN("570022");
		addcuspage.enterMobileNo("0983452672");
		addcuspage.enterEmail("vdees34er@yahoo.com");  /// Change everytime
		addcuspage.enterPass("vdsfsfwwee3");  //Change Everytime
		addcuspage.submit();

		//Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else 
		{
			CaptureScreenshot("TC03_AddCustomerTest_003");
			Assert.assertTrue(false);
		}

	}

	

}
