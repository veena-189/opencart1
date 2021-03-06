package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;	
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"browser"})
	public void setup(String br)
	{		
		//loading config.properties
		rb=ResourceBundle.getBundle("config");		
		
		//Logging
		logger = LogManager.getLogger(this.getClass());
		
		//Driver
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launched Chrome Browser");
		}
		
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logger.info("Launched Edge Browser");
		}
		
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Launched Firefox Browser");
		}		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomeString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return(generateString);
	}

	public int randomeNumber()
	{
		String generateString2 = RandomStringUtils.randomNumeric(3);
		return(Integer.parseInt(generateString2));
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		
		
	}

}
