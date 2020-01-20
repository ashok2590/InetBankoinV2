package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;

	public ReadConfig()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./Configuration\\Config.properties");
			prop.load(fis);

		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

	public String getBrowserName() 
	{
		String browser =prop.getProperty("browser");
		return browser;
	}
	public String getBaseUrl() 
	{
		String baseUrl =prop.getProperty("baseUrl");
		return baseUrl;
	}
	public String getUserName() 
	{
		String userName =prop.getProperty("userName");
		return userName;
	}
	public String getPassword() 
	{
		String password =prop.getProperty("password");
		return password;
	}
	public String getChromePath() 
	{
		String chromePath =prop.getProperty("chromePath");
		return chromePath;
	}
	public String getFirefoxPath() 
	{
		String firefoxPath =prop.getProperty("firefoxPath");
		return firefoxPath;
	}



}
