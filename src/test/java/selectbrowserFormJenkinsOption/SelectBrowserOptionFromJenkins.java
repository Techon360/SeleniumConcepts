package selectbrowserFormJenkinsOption;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SelectBrowserOptionFromJenkins extends BaseClass {

	@Test
	public void validateTitle() throws IOException
	{
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
	}
	
	@Test
	public void validateTitle123() throws IOException
	{
		String title=driver.getTitle();
		Assert.assertEquals("Webnetram-Login", title);
	}

}
