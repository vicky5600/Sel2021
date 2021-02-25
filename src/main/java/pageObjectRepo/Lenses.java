package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lenses {
	public WebDriver driver;
	
	public Lenses(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://apps.9lenses.com/Account/Login']")
	private WebElement loginClk;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement enterEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//span[contains(text(),'Close More Deals')]")
	private WebElement textLen;
	
	
	public WebElement loginClk()
	{
		return loginClk;
	}
	
	public WebElement enterEmail()
	{
		return enterEmail;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement submit()
	{
		return submit;
	}
	
	public WebElement textLen()
	{
		return textLen;
	}
	

}
