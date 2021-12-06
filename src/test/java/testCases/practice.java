package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class practice extends BaseClass 
{
	@Test
	public void locatorTest()

	{
		driver.get(rb.getString("automationPracticeURL"));
		driver.manage().window().maximize();
		driver.findElement(By.name("search_query")).sendKeys("T-shirt");
		driver.findElement(By.name("submit_search")).click();
		
		driver.findElement(By.linkText("Printed Chiffon Dress")).click();//linkText
		//driver.findElement(By.partialLinkText("Printed Chiffon")).click();//PartialLinkText
		
	}
	
	
	
	
	

}
