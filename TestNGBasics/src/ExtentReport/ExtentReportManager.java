package ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkreport; //UI of the report
	public ExtentReports extent; //Populate common details of the report
	public ExtentTest test; //Status of the test case (Passed, Failed, Skipped)
	
	
	
	public void onStart(ITestContext context)
	{
	
	sparkreport= new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport.html");
	
	sparkreport.config().setTheme(Theme.DARK);
	sparkreport.config().setDocumentTitle("Automation Report");
	sparkreport.config().setReportName("Functional Testing Report");
	
	extent = new ExtentReports();
	extent.attachReporter(sparkreport);
	
	extent.setSystemInfo("Browser", "Chrome");
	extent.setSystemInfo("Operating System", "Windows 10");
	extent.setSystemInfo("Tester Name", "Mohan");
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed");
	
	}
	
	public void onTestFailure(ITestResult result)
	{
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest("Test Case Skipped");
		test.log(Status.SKIP, "Test Case Skipped");
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	
}
