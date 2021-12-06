package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInformationPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_MAI_001_MyAccountInformation extends BaseClass
{
	@Test
	public void test_MyAccountInformation() throws IOException
	{
		logger.info(" Starting TC_MAI_001_MyAccountInformation ");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			driver.manage().window().maximize();
			
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			logger.info("Clicked on My Account link");
			
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password");
			
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage myAcc = new MyAccountPage(driver);
			myAcc.clickEditYourInformationlink();
			logger.info("Clicked on Edit your account information link");
			
			MyAccountInformationPage myAccInfoPage = new MyAccountInformationPage(driver);
			
			boolean targetPage = myAccInfoPage.IsMyAccInformationPageExists();
			
			if(targetPage)
			{
				logger.info("Navigating to my account information page success ");
				captureScreen(driver, "test_myAccInfoPage");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Navigating to my account information page failed");
				captureScreen(driver, "test_myAccInfoPage");
				Assert.assertTrue(false);
				
			}
		}
		catch(Exception e)
		{
			logger.fatal("Navigation to my account information page failed ");
			Assert.fail();
		}
		logger.info("Finished TC_MAI_001_MyAccountInformation");
				
	}

}
