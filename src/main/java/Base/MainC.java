package Base;
import java.net.MalformedURLException;
import java.net.URL;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Appconfig.BasicLogin;
import ObjectRepo.LoginPage;
import io.appium.java_client.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;



public class MainC extends BasicLogin {  
	
	 LoginPage Login;

	    @BeforeClass
	    public void setupPageObject() {
	        Login = new LoginPage(driver);
	    }
	        @Test(priority=1)
	        public void testLoginWithEmptyPassword()
	        {
	        Login.AppLogin("standard_user","");
	        Login.EmptyPassword(driver);
	        }
	        
	        
	        @Test(priority=2)
	        public void unPwdInvalid()
	        {
	        	 Login.AppLogin("abc","and");
		       Login.unPwdInvalid(driver);
	        }
	        
	   
	         
	        
	         @Test(priority =3)
	         public void validLogin()
	         {
	        	 Login.AppLogin("standard_user","secret_sauce"); 
	        	 System.out.println("valid Used Added :app login success");
	         }
	         
	        
	        
	        
	    	
	    	@Test(priority=4)
	    	public void Remaining()
	    	
	    	{
	    	String ele =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")).getText();
	        System.out.println(ele);
	    	if("Sauce Labs Backpack".equals(ele))
	        	System.out.println("element is identified:"+ele);
	        else 
	        	System.out.println("element is not identified");
	        
	        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")).click();
	        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"REMOVE\"])[1]")).click();
	        System.out.println("product removed");
	        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")).click();
	        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();//cart buuton
	      //android.widget.TextView[@text="Sauce Labs Backpack"]
	      WebElement   prodPresent =driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]"));
	     
	      String proct_text=prodPresent.getText();
	      System.out.println("proct_textcart"+proct_text);
	      try{
	    	   String atr =prodPresent.getAttribute("text");
	 	      System.out.println(atr);
	      }
	      catch(Exception e )
	      {
	    	  System.out.println(e);
	      }
	      if(prodPresent.equals(ele))
	    		  {
	    	  System.out.println("prodcut present in cart");
	    		  }
	      else System.out.println("added product not presen in the cart");
	        driver.quit();
	}
}


