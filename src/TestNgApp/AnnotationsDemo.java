package TestNgApp; // no main class but @test acts as main class in testNg

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsDemo {
	public static WebDriver driver;
  @Test
  public void f() {
	 String str = driver.findElement(By.xpath("//img[@alt = 'Find a Flight']")).getText();
	 System.out.println("trying to run the test "+ str);
	
	 // login user name
	 WebElement logIn = driver.findElement(By.name("userName"));
	 logIn.sendKeys("abc");
	
	 // password
	 WebElement password = driver.findElement(By.name("password"));
	 password.sendKeys("abcdef");
  
	 // click log in 
	 
	 WebElement click = driver.findElement(By.xpath("//*[@value = 'Login']"));
	 click.click();
	 
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  driver.get("http://www.newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  System.out.println("Starting first TestNg");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Already Run one testNg annotations class");
  }

  @BeforeSuite
  public void beforeSuite() {  // Launching the browser
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shallu\\Desktop\\Selenium Training\\Installation Stuff\\Drivers Folder\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.close(); // closing the browser
  }

}
