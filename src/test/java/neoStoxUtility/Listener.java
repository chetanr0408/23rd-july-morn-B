package neoStoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.base;



public class Listener extends base implements ITestListener

{

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is sucessfully completed", true);
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC "+result.getName()+" is Failed", true);
		
		try {
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	
	{
		Reporter.log("TC is skipped please check ", true);
	}
	
	
	
}
