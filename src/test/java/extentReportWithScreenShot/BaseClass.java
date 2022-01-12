package extentReportWithScreenShot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeTest
	public WebDriver startApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public String capture(String testCaseName, WebDriver driver) throws IOException
	{
	   TakesScreenshot ts= (TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
	   String destination=System.getProperty("user.dir")+"\\NormalScreenshotsTestNG\\"+testCaseName+".png";
	   File destinationFile= new File(destination);
	   FileUtils.copyFile(source, destinationFile);
	   return destination;
	}
	
}
