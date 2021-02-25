package Sel2021Pro;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentRep;
import resources.basePage;

public class Listenerss extends basePage implements ITestListener{
	public WebDriver driver;
	ExtentTest ext;
	ExtentReports extent = ExtentRep.getExtentReport();
	ThreadLocal<ExtentTest> exttss = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ext = extent.createTest(result.getMethod().getMethodName());
		exttss.set(ext);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		exttss.get().log(Status.PASS, "Script passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		exttss.get().fail(result.getThrowable());
		String userMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
		}	
		
		try {
			exttss.get().addScreenCaptureFromPath(getScreenShot(userMethodName,driver),result.getMethod().getMethodName());
		//	getScreenShot(userMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
