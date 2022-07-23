package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

	
	@Test(groups={"sanity","master"})
	public void test_login() {
		
		logger.info("starting TC_002_Login......");
		
		try {
			driver.get(rb.getString("appURL"));
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickLogin();
			logger.info("Clicked on login");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("provided email");
			
			
			lp.setPassword(rb.getString("password"));
			logger.info("provided password");
			
			lp.clickLogin();
			logger.info("clicked on login");
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login success");
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.error("login failed");
				captureScreen(driver,"test_Login"); //capturing screenshot
				Assert.assertTrue(false);
			}
		}
		
		catch(Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
		}
		
		logger.info("finished TC_002_Login");
		
		
	}
}
