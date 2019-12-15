package testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.Dashboard;
import pages.LoginPage;
import testbase.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class HRMTestCases {
	private static WebDriver dr;
	private LoginPage lp;
	private Dashboard db;
  @Test(priority=6, timeOut=2,enabled=true,dependsOnMethods="validateFirstLevelMenu")
  public void fisrt() throws InterruptedException {
	  System.out.println("First");
	  Thread.sleep(4000);
  }
  @Test(priority=5,description="Second")
  public void second() {
	  System.out.println("Second");
  }
  @Test(priority=3,enabled=false)
  public void third() {
	  System.out.println("Third");
  }
  @Test(priority=1, description="Login Verification")
  public void verifyLogin() {
	  lp.loginToApp(BaseClass.prop.getProperty("username"), BaseClass.prop.getProperty("password"));
	  assertTrue(db.successMsg());
  }
  @Test(priority=2, enabled=true,description="Verifying Menu Items")
  public void validateFirstLevelMenu() {
	  verifyLogin();
	  List<String> actual = db.getFirstLevelMenu();
	  assertEquals(actual.size(), 9);
	  assertEquals(actual.get(0), "Admin");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("Before Method");
	  dr=BaseClass.init();
	  lp=new LoginPage(dr);
	  db=new Dashboard(dr);
  }

  @AfterMethod
  public void afterMethod() {
  dr.close();
  System.out.println("After Method");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }



}
