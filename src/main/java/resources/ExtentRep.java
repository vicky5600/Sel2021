package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRep extends basePage {
	
	static ExtentReports extent;
	public static ExtentReports getExtentReport()
	{
	
	String path=rootPath+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Automation Report 2021");
	reporter.config().setReportName("Venkatesh Anvekar");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Anvekar", "Tester");
	return extent;
	
	
	
	}

}
