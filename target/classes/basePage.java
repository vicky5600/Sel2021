package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class basePage {
public static String rootPath;
public WebDriver driver;
public Properties prop;
//public WebDriverWait wait=new WebDriverWait(driver,15);


	
	public WebDriver initializeDriver() throws IOException
	{
		rootPath = System.getProperty("user.dir");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(rootPath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	//	String browserType=System.getProperty("browser");
		String browserType=prop.getProperty("browser");
		if(browserType.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rootPath+"\\src\\main\\java\\resources\\chromedriver88.exe");
			ChromeOptions option = new ChromeOptions();
			if(browserType.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			
			
		}
		else if(browserType.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rootPath+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShot(String userMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot sT=(TakesScreenshot)driver;
		File source = sT.getScreenshotAs(OutputType.FILE);
		String dest = rootPath+"\\reports\\"+userMethodName+".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
	}
	
	


