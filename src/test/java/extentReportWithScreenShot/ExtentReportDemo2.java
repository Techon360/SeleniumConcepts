package extentReportWithScreenShot;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ExtentReportDemo2 extends BaseClass {

	@Test
	public void validateTitle3() throws IOException
	{
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
	}
	
	@Test
	public void validateTitle4() throws IOException
	{
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login23", title);
	}

}
