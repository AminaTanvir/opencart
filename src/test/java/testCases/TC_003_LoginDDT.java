package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT  extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void test_loginDDT(String email,String pwd,String exp) {
		
		logger.info("starting TC_003_LoginDDT......");
		
		try {
			driver.get(rb.getString("appURL"));
			logger.info("home page is dispalyed");
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickLogin();
			logger.info("Clicked on login");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("provided email");
			
			
			lp.setPassword(rb.getString("pwd"));
			logger.info("provided password");
			
			lp.clickLogin();
			logger.info("clicked on login");
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			
			if(exp.equals("Valid"))
			{
				
			
			   if(targetpage==true)
			    {
			    	logger.info("Login success");
			    	
			    	
					MyAccountPage mypage=new MyAccountPage(driver);
					mypage.logout();
					
					//logger.info("logging out from my account");
			    	Assert.assertTrue(true);
				
			    }
			   else
			    {
			    	logger.error("login failed");
			    	
			    	Assert.assertTrue(false);
			    }
		
			}
			if(exp.equals("Invalid"))
			{
				
			
			   if(targetpage==true)
			    {
				   MyAccountPage mypage=new MyAccountPage(driver);
					mypage.logout();
			    	Assert.assertTrue(false); //test case need to be failed as invalid data logged in
				
			    }
			   else
			    {
			    	logger.error("login failed");
			    	//captureScreen(driver,"test_Login"); //capturing screenshot
			    	Assert.assertTrue(true);
			    }
		
			}
		}
		
		catch(Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
		}
		
		logger.info("finished TC_003_LoginDDT");
		
	}	
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\nopCommerce_LoginData.xlsx";
			
			XLUtility xlutil=new XLUtility(path);
			
			
			int totalrows=xlutil.getRowCount("sheet1");
			int totalcols=xlutil.getCellCount("sheet1",1);
			
			
			String logindata[][]=new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows;i++)
			{
				
				for(int j=0;j<totalcols;j++)
				{
					
					logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
				}
			}
			return logindata;
			
		}
		
	

}
