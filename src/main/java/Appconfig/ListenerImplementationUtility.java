package Appconfig;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
			
			String path = s.captureScreenShot(BasicLogin.sDriver, screenshotName);
			//String path = s.captureScreenShot(BasicLogin.sDriver, screenshotName);
			
			//Attach the screenshot to extent report
			test.addScreenCaptureFromPath(path, screenshotName);
			
		} catch (IOException e) {
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