package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By txtUserName = By.xpath("//input[@name='uid']"); 
	By txtPassword = By.xpath("//input[@name='password']"); 
	By btn_Login = By.xpath("//input[@name='btnLogin']"); 
	By btn_Reset = By.xpath("//input[@name='btnReset']");
	By lnk_LogOut = By.linkText("Log out");
	
	public void setUserName(String uname) 
	{
		driver.findElement(txtUserName).sendKeys(uname);
	}
	
	public void setPassword(String pword) 
	{
		driver.findElement(txtPassword).sendKeys(pword);
	}
	public void btnLoginClick() 
	{
		driver.findElement(btn_Login).click();
	}
	public void btnResetClick() 
	{
		driver.findElement(btn_Reset).click();
	}
	public void lnkLogOutClick() 
	{
		driver.findElement(lnk_LogOut).click();
	}
	
	
}
