package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class OR  {
	
	protected static WebDriver driver;
	public OR(WebDriver driver) 
	{
		this.driver = driver;
	}

	//Cyclos Bank
	@FindBy(id="cyclosUsername") protected WebElement txtUsername;
	@FindBy(id="cyclosPassword") public WebElement txtPassword;
	@FindBy(xpath="//input[@value='Submit']") public WebElement btnSubmit;
	@FindBy(xpath="//span[text()='Logout']") public WebElement btnLogout;
	@FindBy(linkText="Account(s)") public WebElement lnkaccounts;
	@FindBy(linkText="My profile") public WebElement lnkprofile;
		
	
}