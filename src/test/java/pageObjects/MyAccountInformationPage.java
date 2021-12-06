package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountInformationPage 
{
	WebDriver driver;
	
	public MyAccountInformationPage(WebDriver	driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Locating elements of My Account information page
	
	@FindBy(xpath="//h1[normalize-space()='My Account Information']")
	WebElement txtHeader;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnConitue;
	
	//Actions
	
	public boolean IsMyAccInformationPageExists()
	{
		try
		{
			return(txtHeader.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
		
	}
	
	public void clickContinueButton()
	{
		btnConitue.click();
	}

}
