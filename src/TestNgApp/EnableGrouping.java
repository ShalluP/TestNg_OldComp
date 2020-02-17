package TestNgApp;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class EnableGrouping {

	
		static WebDriver driver;

	
		@Test(groups ="LogIn",priority =1, enabled = true)
	  
	  public void LogIn()
	  {
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
	  @Test(groups ="Links", priority = 2 ) //dependsOnMethods = "Register")
	  public void LoginClick() throws InterruptedException
	  {
		driver.findElement(By.xpath("//a[text()='SIGN-ON']")).click();  
		Thread.sleep(2000);
	  }
	  
	  @Test(groups ="contact",priority = 4 )//,// dependsOnMethods = "Support" )
	  public void Register() throws InterruptedException
	  {
		  driver.findElement(By.xpath("/html/body/div/table"
		  		+ "/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]")).click();
		  Thread.sleep(2000);
	  }
	  @Test (groups ="Links",priority=3)
	  public void Support() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[text()='SUPPORT']")).click();
		  Thread.sleep(2000);
	  }
	 
	  @Test (priority =5, groups ="contact")
	  public void Contact()
	  {
		driver.findElement(By.linkText("CONTACT")).click();  
	  }
	  @BeforeTest
	  public void openAUT() {
		  driver.get("http://www.newtours.demoaut.com/");
		  driver.manage().window().maximize();
		  System.out.println("Testing Priority on TestNg");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @AfterTest
	  public void LogOut() {
	  }

	  @BeforeSuite
	  public void OpenBrowser() 
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }

	  @AfterSuite public void afterSuite()
	  { 
		  driver.close();
		  }
		 

	}

	
	

