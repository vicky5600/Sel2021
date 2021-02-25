package Sel2021Pro;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.EERep;
import resources.utilPage;

    public class listenn extends utilPage implements ITestListener{
	public WebDriver driver;
	ExtentReports extent = EERep.getExE();
	ExtentTest ext;
	ThreadLocal<ExtentTest> exttss = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ext = extent.createTest(result.getMethod().getMethodName());
		exttss.set(ext);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ext.log(Status.PASS, "TestCase Passed");
		exttss.get().log(Status.PASS, "TestCase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	//	ext.fail(result.getThrowable());
		exttss.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
			
		}
		try {
			exttss.get().addScreenCaptureFromPath(getScreenShots(testMethodName,driver), result.getMethod().getMethodName());
		//	getScreenShot(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
