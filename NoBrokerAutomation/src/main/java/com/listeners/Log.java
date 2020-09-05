package com.listeners;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.reports.CaptureScreen;
import com.reports.ExtentManager;
import com.reports.ExtentTestManager;
public class Log implements ITestListener
{
    private static Logger Log = getLogs();//Logger.getLogger(Log.class.getName());
    
	public static void info(String message) {
		
		Log.info(message);
		
	    ExtentTestManager.getTest().log(Status.INFO, message);
	    try{

			CaptureScreen.captureScreenshot();
			ExtentTestManager.getTest().info("<b>" + "<font color=" + "blue>" + message + "</font>" + "</b>"+"<br>",
					MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen.screenshotName)
							.build());
		} catch (IOException e) 
		{

		}
	 
	}
    
	public static void asserts(String expected,String actual) {
		
		
		
	    ExtentTestManager.getTest().log(Status.INFO, actual);
	    try{

			CaptureScreen.captureScreenshot();
			try{
			Assert.assertEquals(actual, expected);
			ExtentTestManager.getTest().info("<b>" + "<font color=" + "blue>" + "Expexcted Value Matches"+actual + "</font>" + "</b>"+"<br>",
					MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen.screenshotName)
							.build());
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().info("<b>" + "<font color=" + "Red>" + expected+" but found "+actual + "</font>" + "</b>"+"<br>",
						MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen.screenshotName)
								.build());
			}
			
		} catch (IOException e) 
		{
                  
		}
	  
	 
	}
	
	private static Logger getLogs()
	{
		
		ExtentTestManager.startTest("intialized extent report");
		return Logger.getLogger(Log.class.getName());
	}
	public static void warn(String message) {
		Log.warn(message);
	    ExtentTestManager.getTest().log(Status.WARNING, message);

	}
	public static void error(String message) {
		Log.error(message);
		   ExtentTestManager.getTest().log(Status.ERROR, message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
		 ExtentTestManager.getTest().log(Status.FATAL, message);

	}
	public static void debug(String message) {
		Log.debug(message);
        ExtentTestManager.getTest().log(Status.DEBUG, message);
	}
	public void onTestStart(ITestResult result) {
		   
        System.out.println(("** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	       System.out.println("** Executed " + result.getMethod().getMethodName() + " test successfully...");
	        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	       try{

			CaptureScreen.captureScreenshot();
			ExtentTestManager.getTest().pass("<b>" + "<font color=" + "green>" + "Screenshot of Success" + "</font>" + "</b>"+"<br>",
					MediaEntityBuilder.createScreenCaptureFromPath(CaptureScreen.screenshotName)
							.build());
		} catch (IOException e) 
		{

		}
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		    System.out.println("** Test execution " + result.getMethod().getMethodName() + " failed...");
	        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	       System.out.println("** Test " + result.getMethod().getMethodName() + " skipped...");
	        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	 System.out.println("*** Test Suite " + context.getName() + " started ***");
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		   System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
	        ExtentTestManager.endTest();
	        ExtentManager.getInstance().flush();
		
	}
	
	

}
