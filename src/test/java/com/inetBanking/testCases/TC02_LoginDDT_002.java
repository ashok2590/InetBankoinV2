package com.inetBanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC02_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger = LogManager.getLogger(TC02_LoginDDT_002.class);
		
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.btnLoginClick();
		
		if(isAlertPresent()==true) 
		{
			logger.warn("login failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); //this command will get back to the login window
			Assert.assertFalse(false);	
		}
		else 
		{
			Assert.assertTrue(true);
			logger.info("Login successful");
			lp.lnkLogOutClick();
			driver.switchTo().alert().accept(); //Close the logout alert
			driver.switchTo().defaultContent(); //this command will get back to the login window
		}

	}

	public boolean isAlertPresent() 
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception 
	{
		String Excelpath="./src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
		String SheetName =	"Data1";

		ExcelUtils excelutils = new ExcelUtils(Excelpath, SheetName);
		int toltalrows = excelutils.getRowCount();
		int toltalcols = excelutils.getColCount();
		

		String data[][] = new String[toltalrows-1][toltalcols];

		for (int i = 1; i < toltalrows; i++) 
		{
			for (int j = 0; j < toltalcols; j++) 
			{
				data[i-1][j] = excelutils.getCellDataString(i, j);
			}
		}
		return data;

	}

}
