package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txtConfirmPass;
	
	//@FindBy(name="agree")
	//WebElement chkPolicy;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement msgConfirmation;
	
	
	//@FindBy(xpath="//a[normalize-space()='Log out']")
	//WebElement logout;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confirmpwd)
	{
		txtConfirmPass.sendKeys(confirmpwd);
	}
	
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	
}
