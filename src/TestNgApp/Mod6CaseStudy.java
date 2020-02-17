/*Test the edureka portal to throw an exception while registering a user who already 
holds an account with the same email id. Log in to the edureka portal with the
registered email id, and search for all the courses available and Logout of the edureka
portal. Write testcases using TestNG for above scenario.
Steps:
1. Launch the Chrome browser
2. Log in to the account and browser for all the courses
3. Logout of the account
4. Use all the concepts learnt in TestNG (dependency, priority, etc)
5. Create another test case to register the user with same email and an exception
has to be shown on portal
6. Check for the HTML report generated*/
package TestNgApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Mod6CaseStudy {

	// private static final String String = null;
	static String e2;
	static String e1;
	static WebDriver driver;

	@Test(priority = 0) // groups="Launch")
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1) // dependsOnMethods = "LaunchBrowser")//, groups="Launch")
	public void OpenAUT() {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co/");

		String url1 = driver.getCurrentUrl();
		System.out.println("The url after opening the AUT is : " + url1);
	}

	@Test(priority = 2, groups = "LoggingIn")
	public void LogIn() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Log In']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement Email1 = driver.findElement(By.id("si_popup_email"));

		Email1.clear();

		Thread.sleep(2000);
		e1 = "vinitbassi@gmail.com";
		Email1.sendKeys("vinitbassi@gmail.com");

		System.out.println("User1 email id entered");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement Pass = driver.findElement(By.id("si_popup_passwd"));
		Pass.clear();
		Thread.sleep(1000);
		Pass.sendKeys("India15Great");
		System.out.println("password entered");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		String url2 = driver.getCurrentUrl();
		System.out.println("The url after logging in is: " + url2);
	}

	@Test(priority = 3, groups = "Explore Courses")

	public void ExploreCourses() throws InterruptedException {

		WebElement AllCourses = driver.findElement(By.xpath("//*[@class='btn-group dropdown']"));

		Actions mh = new Actions(driver);

		mh.moveToElement(AllCourses).perform();
		Thread.sleep(1000);
		// AllCourses.click();

		String url3 = driver.getCurrentUrl();
		System.out.println("The url after clicking on all courses is: " + url3);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Software Testing']")).click();

		String url4 = driver.getCurrentUrl();
		System.out.println("The url after clicking on all courses is: " + url4);

		driver.navigate().back();
		// driver.navigate().back();

		String url5 = driver.getCurrentUrl();
		System.out.println("The url after navigating back is: " + url5);
	}

	@Test(priority = 4, groups = "LogOut") // , dependsOnMethods = "ExploreCourses")//, )
	public void LogOut() {
		// driver.findElement(By.xpath("//*[text()= 'Shallu Bass']")).click();
		driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-mycourse-main/section/app-heade"
				+ "r/header/nav/div/div[3]/ul/li[8]/div/button/span")).click();
		// WebElement LogOut = driver
		// .findElement(By.xpath("//button[@class='dropdown-toggle']" +
		// "//following::button[4]"));
		// LogOut.click();

		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

		String url6 = driver.getCurrentUrl();
		System.out.println("The url after logging out is: " + url6);
	}

	// Create another test case to register the user with same email and an
	// exception has to be shown on portal

	@Parameters("email")
	@Test(priority = 5, groups = "ReRegister")
	public void ReRegister(String Uname) throws InterruptedException {
		try {
			if (Uname.equalsIgnoreCase("vinitbassi@gmail.com")) {
				System.out.println("You are trying to use the same email id with another user ");
			}

			else if (Uname != "vinitbassi@gmail.com") {
				driver.findElement(By.xpath("//a[text()='Log In']")).click();

				Thread.sleep(2000); // driver.findElement(By.className("signin top-signin giTrackElementHeader
									// hidden-xs")).click();

				System.out.println("entering the another user with different email id:");

				WebElement Email2 = driver.findElement(By.id("si_popup_email"));

				Email2.sendKeys(Uname);

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				WebElement Pass1 = driver.findElement(By.id("si_popup_passwd"));

				Pass1.clear();
				Thread.sleep(1000);
				Pass1.sendKeys("India15Great");

				System.out.println("again entered the password ");

				driver.findElement(By.xpath("//button[text()='Login']")).click();
			}

		}

		catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterSuite
	public void closeAUT() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
