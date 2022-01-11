package selectbrowserFormJenkinsOption;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public WebDriver startApp() throws IOException
	{ 

		String browserName="firefox";
		String url="http://webnetram.elihealthsupport.com:6002/login";
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
		    
		driver.get(url);
		return driver;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public void capture(String testCaseName, WebDriver driver) throws IOException
	{
	   TakesScreenshot ts= (TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
	   File destination= new File(System.getProperty("user.dir")+"\\NormalScreenshotsTestNG\\"+testCaseName+".png");
	   FileUtils.copyFile(source, destination);
	}
}
