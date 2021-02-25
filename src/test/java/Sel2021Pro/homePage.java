package Sel2021Pro;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.basePage;

public class homePage extends basePage {
private static Logger log=LogManager.getLogger(homePage.class.getName());
public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Launched url");
		driver.manage().window().maximize();
	}
	
	@Test
	public void homePageRepo()
	{
		pageObjectRepo.homePageRepo hp = new pageObjectRepo.homePageRepo(driver);
		Assert.assertEquals(hp.homePageText().getText(), "FEATURED COURSES");
		log.error("Text title is correct");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
