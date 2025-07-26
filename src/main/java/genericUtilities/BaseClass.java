package genericUtilities;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.*;

import Appconfig.BasicAppconfig;
import ObjectRepo.LoginPage;
import ObjectRepo.Sidebar;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {

    public AndroidDriver driver;
    public static AndroidDriver sdriver;
    public LoginPage login;
    public Sidebar menu;
    public boolean isLoggedIn = false;
    @BeforeSuite(alwaysRun = true)
    public void dbConnect() {
        System.out.println("=== Database Connection Established ===");
    }

    @BeforeClass(alwaysRun = true)
    public void launchApp() throws MalformedURLException {
        BasicAppconfig config = new BasicAppconfig();           // ⬅ Load your Appconfig
        UiAutomator2Options options = config.Appload();         // ⬅ Get Options

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        sdriver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("=== App Launched Successfully ===");
    }

    @BeforeMethod(alwaysRun = true)
    public void loginToApp(Method method) {
    	
    	    String methodName = method.getName().toLowerCase();
    	    if (methodName.contains("empty") || methodName.contains("invalid") || methodName.contains("fail")) {
    	        System.out.println("⏩ Skipping auto-login for: " + methodName);
    	        return;
    	    }
    	  
        if (!isLoggedIn) {
            login = new LoginPage(driver);
            login.AppLogin("standard_user", "secret_sauce");
            isLoggedIn = true;
            System.out.println("Login Done");
        } else {
            System.out.println("ℹ️ Already logged in, skipping login.");
        
    }
    	    
    }

    @AfterMethod(alwaysRun = true)
    public void logoutFromApp() {
        try {
            menu = new Sidebar(driver);
            if (menu.isMenuButtonPresent()) {
                menu.openMenu();
                menu.logout();
                isLoggedIn = false;
                System.out.println("Logout Successful");
            } else {
                System.out.println("⚠️ Menu not available - can't logout.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Logout exception: " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeApp() {
        driver.quit();
        System.out.println("=== App Closed ===");
    }

    @AfterSuite(alwaysRun = true)
    public void dbDisconnect() {
        System.out.println("=== Database Connection Closed ===");
    }
}
