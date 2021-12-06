package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{
WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// locators
	////Edit your account information
	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	WebElement lnkEditYurAccInformation;
	
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public void clickEditYourInformationlink()
	{
		lnkEditYurAccInformation.click();
	}

}
