package com.salesforce.automation.config;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.salesforce.automation.utility.XlsOperationsUtility;

public class ExtentReportListener implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentConfigurer.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentConfigurer.getTest().log(Status.PASS, "Test passed");
	}

	//WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentConfigurer.getTest().log(Status.FAIL, "Test Failed");	
		/*try
		{
			
			XlsOperationsUtility.captureScreenshot(driver, result.getName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentConfigurer.getTest().log(Status.SKIP, "Test Skipped");		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentConfigurer.endTest();
	}

}
