package Sel2021Pro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepo.loginPageRepo;
import resources.basePage;

public class DBConnectionMySql extends basePage {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(DBConnectionMySql.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void mySQL() throws SQLException
	{
		loginPageRepo lp = new loginPageRepo(driver);
		lp.login().click();
		log.debug("click on login page");
		String host="localhost";
		String port="3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/automation","root","root");
		Statement s = con.createStatement();
		ResultSet res = s.executeQuery("select * from seleniumInfo where name='Tester'");
		while(res.next())
		{
			lp.email().sendKeys(res.getString("username"));
			log.debug("Enter username");
			lp.password().sendKeys(res.getString("password"));
			log.debug("Enter password");
			lp.submit().click();
			log.debug("click on submit button");
			
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
