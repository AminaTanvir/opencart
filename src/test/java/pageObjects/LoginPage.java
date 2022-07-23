package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement msgHeading;
	
	
	public void setEmail(String email)
	{
		
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		
		btnLogin.click();
	}
	
	
	public boolean isMyAccountPageExists() {
		
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	
}
