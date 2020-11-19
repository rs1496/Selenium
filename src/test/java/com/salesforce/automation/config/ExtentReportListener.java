package com.salesforce.automation.config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentConfigurer.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentConfigurer.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentConfigurer.getTest().log(Status.FAIL, "Test Failed");		
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
