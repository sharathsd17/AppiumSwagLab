package testcases;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import ObjectRepo.LoginPage;
import org.testng.Assert;
import genericUtilities.BaseClass;

public class LoginScenariosTest extends BaseClass {

    @BeforeClass
    public void initLoginPage() {
        login = new LoginPage(driver);  // already initialized in BaseClass's @BeforeMethod, but safe here too
    }

    @Test(priority = 1)
    public void testLoginWithEmptyPassword() {
        login.AppLogin("standard_user", "");
        Boolean error = login.getEmptyPasswordError();
      
    }


    @Test(priority = 2)
    public void testInvalidUsernamePassword() throws InterruptedException {
        login.AppLogin("abc", "and");
         Thread.sleep(2000);
        Boolean error = login.getInvalidLoginError();
        System.out.println(error);
       
                  
                		
            
    }

    
}
