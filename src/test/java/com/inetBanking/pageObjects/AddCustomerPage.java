package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage 
{
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	By Lnk_New_Customer =By.xpath("//a[@href='addcustomerpage.php']");
	By txt_Customer_Name = By.xpath("//input[@type='text' and @name='name']");
	By Rad_Gender_Male = By.xpath("//input[@value='m']");
	By Rad_Gender_Female = By.xpath("//input[@value='f']");
	By Date_DOB = By.xpath("//input[@id='dob']");
	By txt_Address = By.xpath("//textarea[@name='addr']");
	By txt_City = By.xpath("//input[@name='city']");
	By txt_State = By.xpath("//input[@name='state']");
	By txt_PinNO = By.xpath("//input[@name='pinno']");
	By txt_MobNO = By.xpath("//input[@name='telephoneno']");
	By txt_Email = By.xpath("//input[@name='emailid']");
	By txt_Password = By.xpath("//input[@name='password']");
	By btn_Submit = By.xpath("//input[@name='sub']");
	
	
	public void selectNewCustomerLink() 
	{
		driver.findElement(Lnk_New_Customer).click();
	}

	public void enterCustomerName(String Customername) 
	{
		driver.findElement(txt_Customer_Name).sendKeys(Customername);
	}

	public void selectGenderMale() 
	{
		driver.findElement(Rad_Gender_Male).click();
	}

	public void selectGenderFemale() 
	{
		driver.findElement(Rad_Gender_Female).click();
	}
	
	public void selectDOB(String dd, String mm, String yyyy) 
	{
		driver.findElement(Date_DOB).sendKeys(dd);
		driver.findElement(Date_DOB).sendKeys(mm);
		driver.findElement(Date_DOB).sendKeys(yyyy);
		
	}

	public void enterAddress(String address) 
	{
		driver.findElement(txt_Address).sendKeys(address);
	}

	public void enterCity(String city) 
	{
		driver.findElement(txt_City).sendKeys(city);
	}

	public void enterState(String state) 
	{
		driver.findElement(txt_State).sendKeys(state);
	}

	public void enterPIN(String pin) 
	{
		driver.findElement(txt_PinNO).sendKeys(pin);
	}
	
	public void enterMobileNo(String mob) 
	{
		driver.findElement(txt_MobNO).sendKeys(mob);
	}
	
	public void enterEmail(String email) 
	{
		driver.findElement(txt_Email).sendKeys(email);
	}

	public void enterPass(String pass) 
	{
		driver.findElement(txt_Password).sendKeys(pass);
	}
	
	public void submit() 
	{
		driver.findElement(btn_Submit).click();
	}



}
