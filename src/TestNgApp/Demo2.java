package TestNgApp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {
	
 @BeforeSuite
 public void openBrowser()
 {
	 System.out.println("This executes before suite");
 }
@BeforeTest	
public void openAUT()
{
	System.out.println("This executes before test");
	
}
 @BeforeClass
 public void beforeClass()
 {
	 System.out.println("This executes before class"); 
 }
 
 @Test
 public void logIn()
 {
	 System.out.println("This executes test"); 
 }
  @AfterTest
  public void afterTest()
  {
	  System.out.println("This executes after test"); 
  }
 
 @AfterClass
 public void afterClass()
 {
	 System.out.println("This executes after class");
 }
 
 @AfterSuite
 public void closeBrowser()
 {
	 System.out.println("This closes the browser -- after Suite");
 }
 
}
