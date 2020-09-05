package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentReports extent;
	
	   public static ExtentReports getInstance() {
        if (extent == null)
            createInstance(System.getProperty("user.dir")+"/Reports/Extent.html");
        return extent;
    }
	   
	   public static ExtentReports createInstance(String fileName) {

  	   ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
  	    String css = ".r-img {width: 300%;}";
 	    htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        htmlReporter.config().setCSS(css);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Upendra");
	        extent.setSystemInfo("Organization", "No Broker");
	        extent.setSystemInfo("Build no", "NoBroker-1234");
	        
	        
	        return extent;
	    }

}
