package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	//sample comment this
	
	
	@Test(groups={"regression","master"})
	public void test_account_Registration() throws IOException {
		
		logger.info("starting TC_001_AccountRegistration");
		
		
		logger.debug("debugging.....");
		logger.info("opening app url.....");
		driver.get(rb.getString("appURL")); //get URL from config.properties file
		driver.manage().window().maximize();
		
		
		HomePage hp=new HomePage(driver);
		//logger.info("Clicking on MyAccount link.....");
		//hp.clickMyAccount();
		logger.info("Clicking on Registration link");
		hp.clickRegister();
		
		
		logger.info("Providing user details.....");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		
		
		regpage.setFirstName("Linda");
		logger.info("Provided first Name");
		
		regpage.setLastName("haque");
		logger.info("Provided last name");
		
		regpage.setEmail(randomString()+"@gmail.com");
		logger.info(" provide email");
		
		
		regpage.setPassword("abcxyz");
		logger.info("providing password");
		
		regpage.setConfirmPassword("abcxyz");
		logger.info("providing confirm password");
		
		
		regpage.clickContinue();
		//captureScreen(driver, "test_account_registration");
		logger.info("Registration going on");
		
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your registration completed"))
		{
		
		    logger.info("Account Registration Success");
			Assert.assertTrue(true);
		}
		else
		{
		
		    captureScreen(driver, "test_account_registration");
		    logger.error("Account Registration Failed");
			Assert.assertTrue(false);
		}
		
		logger.info("logging out from user details.....");
		MyAccountPage mypage=new MyAccountPage(driver);
		
		mypage.logout();
		logger.info("logging out from my account");
		
		logger.info("Finished testcase of TC_001_AccountRegistration");
	}
	
	
	
}
