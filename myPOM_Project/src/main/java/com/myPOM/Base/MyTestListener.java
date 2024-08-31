package com.myPOM.Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyTestListener implements ITestListener{
	ExtentReports extentReporter;
	ExtentTest Test;
	@Override
	public void onStart(ITestContext result) {
		
		extentReporter = ExtentReporter.generateExtendReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName =result.getName();
		Test = extentReporter.createTest(testName);
		Test.log(Status.INFO, testName+" Test started ");
		
		//System.out.println(result.getName()+" Test started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName =result.getName();
		Test.log(Status.PASS,testName+"Test Successful");
		//System.out.println(result.getName()+" Test Succesfull ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName =result.getName();
		Test.log(Status.FAIL,testName+"Test Failed");
		//System.out.println(result.getName()+" Test Failed ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName =result.getName();
		Test.log(Status.SKIP,testName+"Test Skipped");
		
		//System.out.println(result.getName()+" Test Skipped ");
	}


	@Override
	public void onFinish(ITestContext result) {
		String testName =result.getName();
		Test.log(Status.INFO,testName+"Test Finished");
		extentReporter.flush();
		//System.out.println(result.getName()+" Test Finished ");
	}

}
