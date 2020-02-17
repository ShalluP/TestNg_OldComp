package TestNgApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserOnMod5 {
	
	WebDriver driver;

	@Parameters ("Browser")
	@Test(priority =0)
	public void OpenBrowser(String B)
	{
		try {
			if (B.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

				driver = new ChromeDriver();
			}
			else if (B.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Shallu\\Desktop\\Selenium Training\\Installation Stuff\\Drivers Folder\\geckodriver.exe");
				
				driver = new FirefoxDriver();
			}
		}
	
	catch (WebDriverException e)
	{
		System.out.println(e.getMessage());
	}}
	
	// open the uRL
	@Test (priority =1)
	public void OpenAUT()
	{
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Implicitly wait
	}

	// clicking on the log in web element an then logging in with personal
	// credentials
	
	@Parameters({ "Username", "Password" })
	@Test(priority = 2)
	public void LogIn(String Uname, String pass) throws InterruptedException {
		WebElement logIn = driver.findElement(By.xpath("//a[text()='Log In']"));
		logIn.click();

		 Thread.sleep(2000);
		 WebDriverWait myWait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("si_popup_email")).sendKeys(Uname);

		Thread.sleep(1000);

		driver.findElement(By.id("si_popup_passwd")).sendKeys(pass);
		
		 myWait.until(ExpectedConditions.elementToBeClickable
				 (driver.findElement(By.xpath("//button[text()= 'Login']")))).click();

		//driver.findElement(By.xpath("//button[text()= 'Login']")).click();
	}

	
	
	

}
