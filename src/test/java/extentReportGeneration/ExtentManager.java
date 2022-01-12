package extentReportGeneration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	
	public static  ExtentReports getReport()
	{
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReport\\Extentreport.html");
		reporter.config().setReportName("Automation Test Report");
		reporter.config().setDocumentTitle("Report");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Engineer", "Vimal Panchal");
		extent.setSystemInfo("OS", "Windows 10");
		return extent;
	}
	
}
