package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	@Test(groups= {"regression","master"})
	public void test_account_Registration() throws IOException
	{
		logger.info("Starting TC_001_AccountRegistration");
		
		try
		{
			//driver.get("https://demo.opencart.com/");
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			driver.manage().window().maximize();
			
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on Register link");
			
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			
			regPage.setFirstName("Sara");
			logger.info("Provided First Name ");
			
			regPage.setLastName("Davis");
			logger.info("Provided Last Name ");
			
			regPage.setEmail(randomeString()+"."+randomeNumber()+"@gmail.com"); //Passing dynamic data, random test data created at the time of runtime.
			logger.info("Provided Email ");
			
			regPage.setTelephone("9191231231");
			logger.info("Provided Telephone ");
			
			regPage.setPassword("Sara123");
			logger.info("Provided Password ");
			
			regPage.setConfirmPassword("Sara123");
			logger.info("Provided Confirmed Password ");
			
			regPage.setPrivacyPolicy();
			logger.info("Set Privacy Policy ");
			
			regPage.clickContinueButton();
			logger.info("Clicked on Continue button");
			
			String confMsg = regPage.getConfirmationMsg();
			if(confMsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success ");
				captureScreen(driver, "test_account_Registration");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Account Registration Failed ");
				captureScreen(driver, "test_account_Registration");
				Assert.assertTrue(false);
			}			
		}
		
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed ");
			captureScreen(driver, "test_account_Registration");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration ");
				
	}
	

	
}
