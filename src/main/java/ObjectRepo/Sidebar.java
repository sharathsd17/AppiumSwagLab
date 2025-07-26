package ObjectRepo;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Sidebar 
{
	AndroidDriver driver;
	  
	  public Sidebar(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  }
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	private WebElement MenuBar;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement CancelBtn;
	
	
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.View\").instance(10)")
	private WebElement HighLigtAll;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"ALL ITEMS\"]")
	private WebElement AllItems;
	
	@AndroidFindBy(uiAutomator ="new UiSelector().text(\"LOGOUT\")")
	private WebElement Logout;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"WEBVIEW\"]")
	private WebElement WebView;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"GEO LOCATION\"]")
	private WebElement GeoLocation;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"DRAWING\"]")
	private WebElement Drawing;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"ABOUT\"]")
	private WebElement About;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"RESET APP STATE\"]")
	private WebElement ResetAppState;
	@AndroidFindBy(xpath ="//android.widget.TextView[@text=\"QR CODE SCANNER\"]")
	private WebElement QRScanner;
	
	public boolean isMenuButtonPresent() {
        try {
        	
            return MenuBar.isDisplayed();
        	}
            
         catch (NoSuchElementException e) {
            return false;
        }
    }
	
	
	public void openMenu()
	{
		MenuBar.click();
	 }
	
	public void WebView()
	{
		WebView.click();
	}
	public void qrScanner()
	{
		QRScanner.click();
	}
	public void drawing()
	{
		Drawing.click();
	}
	public void about()
	{
		About.click();
	}
	public void resetAppState()
	{
		ResetAppState.click();
	}
	public void allItems()
	{
		AllItems.click();
	}
	public void logout()
	{
		Logout.click();
	}
	

}
