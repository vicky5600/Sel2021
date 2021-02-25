package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageRepo {
	public WebDriver driver;
	
	public homePageRepo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	private WebElement homePageText;
	
	
	public WebElement homePageText()
	{
		return homePageText;
	}

}
