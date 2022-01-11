package screenshotTestNGListener;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TakeScreenshotTestNGListener2 extends BaseClass {

	@Test
	public void validateTitle999() throws IOException
	{
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login1", title);
	}
	
	@Test
	public void validateTitle1000() throws IOException
	{
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
	}

}
