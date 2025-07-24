package Appconfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.options.UiAutomator2Options;

public class BasicAppconfig 
{ 
	public UiAutomator2Options  Appload( ) throws MalformedURLException
	{
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("Android");
	//options.setPlatformVersion("15");
	//options.setDeviceName("ZD222L5B8N");
	  options.setDeviceName("Android Device");//added for jenkins 
	options.setAutomationName("UiAutomator2");
	String apkPath = System.getProperty("user.dir") + "/Apps/SauceLabs.apk";
	options.setApp(apkPath);
	options .setAppPackage("com.swaglabsmobileapp");
	options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
	options.setAppWaitActivity("*");
	return options;



	

}
}