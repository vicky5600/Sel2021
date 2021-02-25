package Sel2021Pro;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepo.loginPageRepo;
import resources.basePage;

public class LoginPage extends basePage {
private static Logger log=LogManager.getLogger(LoginPage.class.getName());
public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void login(String username, String Password)
	{
		driver.get(prop.getProperty("url"));
		log.info("page launched successfully");
		driver.manage().window().maximize();
		loginPageRepo lp = new loginPageRepo(driver);
		lp.login().click();
		log.debug("click on login page");
		lp.email().sendKeys(username);
		log.debug("Enter username");
		lp.password().sendKeys(Password);
		log.debug("Enter password");
		lp.submit().click();
		log.debug("click on submit button");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="venki123";
		data[0][1]="anavekar123";
		data[1][0]="venki560";
		data[1][1]="anavekar560";
		return data;
		
	}

}
