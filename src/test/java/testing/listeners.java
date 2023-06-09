package testing;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.base;
import utilities.extentReport;

public class listeners extends base implements ITestListener{
	ExtentReports er=extentReport.extent();
	ExtentTest logger;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		logger=er.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		logger.pass("pass");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		logger.fail("fail");
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String dest;
			dest = screenshot(driver);
			logger.addScreenCaptureFromPath(dest,result.getMethod().getMethodName());
			} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.skip("skip");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
	}

}
