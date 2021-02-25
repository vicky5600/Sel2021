package Sel2021Pro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepo.Lenses;
import resources.utilPage;


public class lensesTestCaseOne_DBSQL extends utilPage {
	public WebDriver driver;
	private static Logger logs=(Logger) LogManager.getLogger(lensesTestCaseOne_DBSQL.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initDriver();
		
	}
	
	
	@Test(dataProvider="getData")
	public void login(String users, String pass) throws SQLException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Lenses logi = new Lenses(driver);
		System.out.println(logi.textLen().getText());
		Assert.assertEquals(logi.textLen().getText(), "Close More Deals");
		Assert.assertTrue(logi.textLen().isDisplayed());
		logs.info("Test is displayed");
		logi.loginClk().click();
		
		String host = "localhost";
		String port = "3306";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/automation", user, password);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from seleniumInfo where name='Tester'");
		while(rs.next())
		{
		
		logi.enterEmail().sendKeys(rs.getString("username"));
		logs.error("username not entered");
		logi.password().sendKeys(rs.getString("password"));
		logi.submit().click();
		logs.debug("user logged in");
		
		}
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
	data[0][0]="venki";
	data[0][1]="Anvekar";
	data[1][0]="vicky";
	data[1][1]="9lense";
	return data;
	
	}
	
	
	
	

}
