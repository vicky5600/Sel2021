package Sel2021Pro;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Array;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.loginPageRepo;
import resources.basePage;
import resources.excelData;

public class loginThroughExcel extends basePage{
	private static Logger log=LogManager.getLogger(loginThroughExcel.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
	}

	@Test
	public void loginTest() throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("page launched successfully");
		driver.manage().window().maximize();
		loginPageRepo lp = new loginPageRepo(driver);
		lp.login().click();
		excelData d = new excelData();
		ArrayList<String> data = d.dataDriven("Purchase");
		System.out.println(data.get(0));
		
		log.debug("click on login page");
		lp.email().sendKeys(data.get(1));
		log.debug("Enter username");
		lp.password().sendKeys(data.get(2));
		log.debug("Enter password");
		lp.submit().click();
		log.debug("click on submit button");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
