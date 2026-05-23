package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener  
{
	
	public void onStart(ITestResult result )
	{
		System.out.println("Test execution is started");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test is Started");
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test is Failed");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test is Skipped");
	}
	
	public void onFinish(ITestResult result)
	{
		System.out.println("Test execution is finished");
	}

}
