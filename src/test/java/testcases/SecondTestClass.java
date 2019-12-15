package testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SecondTestClass {
  @Test(priority=4)
  public void f() {
	  System.out.println("Second Class F");
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }
  
}
