package com.qa.telco.reports;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentManager {

	    private static ExtentReports extent;

	    public static ExtentReports getExtentReport() {

	        if(extent == null) {

	            
	        	ExtentSparkReporter spark =
	                    new ExtentSparkReporter("./test-output/ExtentReport.html");

	            spark.config().setReportName("Playwright Automation Report");
	            spark.config().setDocumentTitle("Automation Execution Report");

	            extent = new ExtentReports();

	            extent.attachReporter(spark);

	            extent.setSystemInfo("Tester", "Suhasini");
	            extent.setSystemInfo("Environment", "QA");
	            extent.setSystemInfo("Browser", "Chrome");

	        }

	     
	        return extent;
	    }
	}
	
	
	
	
	
	
	
	
	

