package ObjectRepo;

import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import dev.failsafe.internal.util.Assert.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public  class LoginPage {
	AndroidDriver driver;
	
	
	@AndroidFindBy(accessibility="test-Username") private WebElement userNameEdt;
	@AndroidFindBy(accessibility="test-Password") private WebElement passwordEdt;
	@AndroidFindBy(accessibility ="test-LOGIN")private WebElement LoginBtn;
	 public LoginPage(AndroidDriver driver) {
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	    }
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
     public void AppLogin(String Un,String Pwd)
     {
    	 getUserNameEdt().sendKeys(Un);
    	 getPasswordEdt().sendKeys(Pwd);
    	 getLoginBtn().click();
     }
     
     public Boolean getEmptyPasswordError() {
    	 String Act=  driver.findElement(
             AppiumBy.androidUIAutomator("new UiSelector().text(\"Password is required\")")
         ).getText();
         String expected ="Username and password do not match any user in this service.";
   	  return  Act.equals(expected)?true : false;
     }

     public Boolean getInvalidLoginError() {
         
    	 String Act= driver.findElement(
             AppiumBy.androidUIAutomator("new UiSelector().textContains(\"do not match\")")
         ).getText();
    	  String expected ="Username and password do not match any user in this service.";
    	  return  Act.equals(expected)?true : false;
		
    	 
     }
}
