package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage 
{
	WebDriver driver;

	//Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	//Locating Elements of Registration page
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtPhoneNumber;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Actions
	
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
	
	public void setTelephone(String TelNum)
	{
		txtPhoneNumber.sendKeys(TelNum);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String ConPwd)
	{
		txtConfirmPassword.sendKeys(ConPwd);
	}
	
	public void setPrivacyPolicy()
	{
		checkPolicy.click();
	}
	
	public void clickContinueButton()
	{
		btnContinue.click();
	}
	
	//Here we are not adding any validation.
	//Page Object page should include only locators and corresponding actions
	public String getConfirmationMsg()
	{
		try
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
		 
	}
	
	

}
