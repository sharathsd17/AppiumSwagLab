package Appconfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import ObjectRepo.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BasicLogin {
	protected  AndroidDriver driver;
	public static  AndroidDriver sDriver;
	@BeforeTest()
	public void m1() throws MalformedURLException
	{
		BasicAppconfig bs=new BasicAppconfig();
		UiAutomator2Options options=bs.Appload();
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

	        
	         driver = new AndroidDriver(url, options);
	        
	        System.out.println("app started");
	       
		        LoginPage Login = new LoginPage(driver);
	        
	}
	 @AfterClass
	    public void tearDown() {
	        driver.quit();
	        System.out.println("App closed");
	
}
}
