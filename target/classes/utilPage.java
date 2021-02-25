package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class utilPage {
	public String rootPath;
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initDriver() throws IOException
	{
		rootPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(rootPath+"\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
//		String browserType = prop.getProperty("browser");
		String browserType = System.getProperty("browser");
		if(browserType.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rootPath+"\\src\\main\\java\\resources\\chromedriver88.exe");
			ChromeOptions options = new ChromeOptions();
			if(browserType.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if(browserType.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rootPath+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShots(String testCase, WebDriver driver) throws IOException
	{
		TakesScreenshot screenS = (TakesScreenshot)driver;
		File src = screenS.getScreenshotAs(OutputType.FILE);
		String dest = rootPath+"\\reports\\"+testCase+".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
		
		
	}
	
	

}
