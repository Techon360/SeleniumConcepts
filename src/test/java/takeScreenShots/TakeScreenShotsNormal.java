package takeScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotsNormal {
	public WebDriver driver;
	
	@BeforeTest
	public void startApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public void getScreenShot() throws IOException
	{
		 
    //	   FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File( System.getProperty("user.dir")+"\\Screenshots\\screenshot.png"));
		   TakesScreenshot ts= (TakesScreenshot)driver;
		   File source=ts.getScreenshotAs(OutputType.FILE);
		   File destination= new File(System.getProperty("user.dir")+"\\NormalScreenshots\\pic.png");
		   FileUtils.copyFile(source, destination);
		 
	}
	
	@Test
	public void validateTitle() throws IOException
	{
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
		getScreenShot();
	}

}
