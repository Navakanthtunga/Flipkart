package com.library;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;


public class TestngListners implements ITestListener{
	public static String reportDestination =GenericLib.sDirPath+"\\reports\\Extentreports.html";
    public ExtentReports reporter =  new ExtentReports(reportDestination, true, DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE, Locale.ENGLISH);
    public ExtentTest testReporter;

	public void onTestStart(ITestResult result) {
		testReporter = reporter.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());	
	}

	public void onTestSuccess(ITestResult result) {
		testReporter.log(LogStatus.PASS, "Test PASSED");
        reporter.endTest(testReporter);
        reporter.flush();	
	}

	public void onTestFailure(ITestResult result) {
	
		try{
		GenericLib.capture(BaseLib.driver,result.getName());
		String screenShotPath = GenericLib.capture(BaseLib.driver, result.getName());
		
		//To get the error in the report un comment below line
		
		testReporter.log(LogStatus.FAIL, result.getThrowable());
		
		testReporter.log(LogStatus.FAIL, "Find the Snapshot For the error : " + testReporter.addScreenCapture(screenShotPath));
		}catch (Exception e) {
			
		}
		reporter.endTest(testReporter);
		reporter.flush();

	}

	public void onTestSkipped(ITestResult result) {
		testReporter.log(LogStatus.SKIP, "Test Skipped");
		testReporter.log(LogStatus.SKIP, result.getThrowable());
        reporter.endTest(testReporter);
        reporter.flush();	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		reporter.loadConfig(new File(GenericLib.sDirPath+"\\extent-config.xml"));
		reporter.addSystemInfo("Created By: ", "Navakanth");
	}

	public void onFinish(ITestContext context) {
		
		// if the bellow line is un commented then Fail count is not displaying in reports, It is displaying everything as pass.
		reporter.endTest(testReporter);
		//reporter.close();	
	}


}
