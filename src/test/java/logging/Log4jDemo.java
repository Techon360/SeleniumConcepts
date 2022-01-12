package logging;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Log4jDemo extends BaseClass{
	

	@Test
	public void validateTitle() throws IOException
	{
		log.info("Url is launching");
		driver.get("http://webnetram.elihealthsupport.com:6002/login");
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
	
	}

}
