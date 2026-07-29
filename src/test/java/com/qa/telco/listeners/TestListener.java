package com.qa.telco.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.qa.telco.reports.ExtentManager;
import com.qa.telco.reports.ExtentTestManager;
import com.qa.telco.tests.BaseTest;
import com.qa.telco.utils.ScreenshotUtil;

public class TestListener implements ITestListener{

	
	
	   @Override
	    public void onStart(ITestContext context) {
		   System.out.println("******** Extent Report Started ********");
	        ExtentManager.getExtentReport();

	    }

	    @Override
	    public void onTestStart(ITestResult result) {

	        ExtentTestManager.setTest(

	                ExtentManager
	                .getExtentReport()
	                .createTest(result.getMethod().getMethodName())

	        );

	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        ExtentTestManager
	        .getTest()
	        .log(Status.PASS, "Test Passed");

	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	String path = ScreenshotUtil.captureScreenshot(
	    	        BaseTest.getPage(),
	    	        result.getMethod().getMethodName());

	    	ExtentTestManager.getTest().addScreenCaptureFromPath(path);
	        ExtentTestManager
	        .getTest()
	        .log(Status.FAIL, result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {

	        ExtentTestManager
	        .getTest()
	        .log(Status.SKIP, "Test Skipped");

	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	System.out.println("******** Extent Report Flushed ********");
	        ExtentManager
	        .getExtentReport()
	        .flush();

	    }

	}

