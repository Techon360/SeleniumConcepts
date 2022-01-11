package screenshotTestNGListener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName= result.getMethod().getMethodName();
		System.out.println("***********"+testMethodName+" - is Passed*********");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		String testMethodName= result.getMethod().getMethodName();
		System.out.println("***********"+testMethodName+" - is Failed**********");
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception  e1)
		{
			e1.printStackTrace();
		}
		
		try {
			capture(testMethodName, driver);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
