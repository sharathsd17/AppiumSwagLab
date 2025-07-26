package Appconfig;


import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtilities.BaseClass;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author Sharath 
 *
 */
public class ListenerImplementationUtility implements ITestListener{
	
	ExtentReports report;
	
	ExtentTest test;
	
	

	public void onTestStart(ITestResult result) {
		
		//Capture method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test execution Started");
		
		//create test in extent reports
		test=report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		//Capture method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test PASS");
		
		//Log the test status as PASS in extent reports
		test.log(Status.PASS,methodName+" - Test PASS" );
		//Capture the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		//Configure screenshot name
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try {
			
			//this 1 line is capture screenshot on folder which i created -this is not for extentreport
			//s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			// this is taking screenshot for extent report
	            String base64Screenshot = ((TakesScreenshot) BaseClass.sdriver).getScreenshotAs(OutputType.BASE64);
	            test.addScreenCaptureFromBase64String(base64Screenshot, methodName);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	

	public void onTestFailure(ITestResult result) {
		
		//Capture method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test FAIL");
		
		//Log the test status as PASS in extent reports
		test.log(Status.FAIL,methodName+" - Test FAIL" );
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log the exception in Extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		//Configure screenshot name
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try {
			
		//	s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			String base64Screenshot = ((TakesScreenshot) BaseClass.sdriver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(base64Screenshot, methodName);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		//Capture method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test SKIP");
		
		//Log the test status as SKIP in extent reports
		test.log(Status.SKIP, methodName+" - Test SKIP");
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		//Log the Exception in Extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Suite execution Started");
		
		//Basic settings of Extent Reports
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Swag Labs Automation Framework Execution");

		//Configure Extent reports 
		 report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "App");
		report.setSystemInfo("Base Browser", "Microsift edge");
		report.setSystemInfo("Base env", "Test Env");
		report.setSystemInfo("Reporter Name", "Sharath");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Suite execution Finished");
		
		//Generate Extent Reports
		report.flush();
		
	}
	
	

}