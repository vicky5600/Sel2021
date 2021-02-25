package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageRepo {
public WebDriver driver;
	
	public loginPageRepo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement login;
	
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public WebElement login()
	{
		return login;
	}
	
	public WebElement email()
	{
		return email;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement submit()
	{
		return submit;
	}
	
	

}
