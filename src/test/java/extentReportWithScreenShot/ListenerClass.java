package extentReportWithScreenShot;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass extends BaseClass implements ITestListener{

	ExtentTest test;
	ExtentReports extent= ExtentManager.getReport();
    ThreadLocal<ExtentTest> threadlocal=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());
		 threadlocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadlocal.get().log(Status.PASS, "PASSED");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		threadlocal.get().log(Status.FAIL, "FAILED");
		threadlocal.get().fail(result.getThrowable());
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
			threadlocal.get().addScreenCaptureFromPath(capture(testMethodName, driver));
			
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
		
		extent.flush();
	}

}
