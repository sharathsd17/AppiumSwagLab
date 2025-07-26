package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import ObjectRepo.LoginPage;
import ObjectRepo.ProductPage;
import ObjectRepo.Sidebar;
import genericUtilities.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class SidebarTestCases extends BaseClass
{
	 
  
  Sidebar menu ; 
  
  
  @BeforeClass
  public void initPages() {
      
      menu = new Sidebar(driver);
  }
 
	 
  
  
  @Test()
  public void allItemsVerification()
  {
	 
	  menu.openMenu();
	  menu.allItems();
	  
	 
  }
  @Test()
  public void drawingVerification()
  {
	 
	  menu.openMenu();
	 
	  menu.drawing();
	 
  }
  @Test()
  public void reesetApp()
  {
	  
	  menu.openMenu();
	  
	  menu.resetAppState();
	  
  }
  
  
}
