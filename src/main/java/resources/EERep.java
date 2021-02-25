package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EERep extends utilPage {
	
	static ExtentReports extent;
	public static ExtentReports getExE()
	{
		String path = System.getProperty(("user.dir")+"\\reports\\index.html");
//		String path = System.getProperty(rootPath+"\\reports\\index.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Reports");
		reporter.config().setReportName("Venkatesh");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("venki", "QA Tester");
		return extent;
		
		
	}

}
