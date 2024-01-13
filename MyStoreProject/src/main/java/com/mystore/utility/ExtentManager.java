package com.mystore.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentManager {
	static ExtentReports extent =new ExtentReports();

		
		public static ExtentReports getReportObject()
		{
			String path =System.getProperty("user.dir")+"//reports//index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			ExtentReports extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Girish");
		    extent.setSystemInfo("HostName", "MyHost");
	   	    extent.setSystemInfo("ProjectName", "MyStoreProject");
		    extent.setSystemInfo("OS", "Win10");
		    extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}
	public static void endReport() {
		extent.flush();
	}
}
