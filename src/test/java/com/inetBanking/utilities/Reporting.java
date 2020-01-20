package com.inetBanking.utilities;
//Listeners class used to generate Extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener
{
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;


	public void onStart(ITestContext context)
	{
		String timestamp =new SimpleDateFormat("yyyy-mm-dd_HH.mm.ss").format(new Date());
		htmlreporter = new ExtentHtmlReporter("Report_"+timestamp+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}


	public void onTestStart(ITestResult result) 
	{
		
		htmlreporter.config().setDocumentTitle("Inet Banking Test Project");
		htmlreporter.config().setReportName("Functional Test report");
		htmlreporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";

		File f = new File(screenshotpath);
		if (f.exists())
		{
			try 
			{
				test.fail("Screenshot is below: " + test.addScreenCaptureFromPath(screenshotpath));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		test = extent.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.INFO, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));

	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		test = extent.createTest(result.getName()); //Create a new entry in the report
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}




	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
