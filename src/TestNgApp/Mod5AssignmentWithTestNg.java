package TestNgApp;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Mod5AssignmentWithTestNg {
	//private static final String String = null;
	WebDriver driver;

	@Parameters ("Browser")
	@Test
	public void OpenBrowser(String Browser)
	{
		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

				driver = new ChromeDriver();
			}
			if (Browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Shallu\\Desktop\\Selenium Training\\Installation Stuff\\Drivers Folder\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
	
	catch (WebDriverException e)
	{
		System.out.println(e.getMessage());
	}}
	// open the uRL
	@BeforeTest
	public void OpenAUT() {
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // Implicitly wait
	}

	// clicking on the log in web element an then logging in with personal
	// credentials
	@Parameters({ "Username", "Password" })
	@Test()
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

	@Test(enabled = false)
	public void MyProfile() {
		// navigating to My Profile
		// WebElement user =
		// driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-profile-main/app-header/header/nav/div/div[3]/ul/li[8]/div/button/span"));
		// user.click();

		driver.findElement(By.xpath("//*[text()= 'Shallu Bass']")).click();

		// creating selector class to select from the drop downs

		WebElement MyProfile = driver.findElement(By.xpath("(//a[text()= 'My Profile'])[1]"));
		MyProfile.click();
	}

	@Test(enabled = false)
	public void ModifyingPersonalDetails() throws InterruptedException {
		// navigating and updating personal details

		driver.findElement(By.id("personal_details")).click();

		String url1 = driver.getCurrentUrl();
		System.out.println("THe url for personal details is : " + url1);

		// editing experience in the personal profile

		WebElement exp = driver.findElement(By.id("experience"));

		// Thread.sleep(1000);
		Select oSelect = new Select(exp);
		oSelect.selectByVisibleText("2-4 years");

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//button[text()='Continue'])[1]")).click();
		// driver.findElement(By.xpath("(//*[@type = 'button'])[3]")).click();
		Thread.sleep(1000);

		String url2 = driver.getCurrentUrl();
		System.out.println("THe url for professional details is : " + url2);
	}

	@Test(enabled = false)
	public void ModifyingProfessoinalDetails() throws InterruptedException {

		Select sel = new Select(driver.findElement(By.name("currentjob")));

		sel.selectByVisibleText("Senior Management");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-profe"
				+ "ssional-details/accordion/accordion-group/div/div[2]/div/form/button[2]")).click();

		driver.findElement(By.xpath("//button[text() = 'Next']")).click();

		WebElement EmpType = driver.findElement(By.name("elementType"));

		Select sel2 = new Select(EmpType);

		sel2.selectByIndex(0);

		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[text() = 'Next']")).click();
		driver.findElement(
				By.xpath("//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/"
						+ "accordion/accordion-group/div/div[2]/div/form/button[2]"))
				.click();
		WebElement save = driver.findElement(By.xpath("(//button[text() = 'Save'])[1]"));
		save.click();
	}

	@Test(enabled = false)
	public void Blogs() {
		// exploring the blogs, clicking on community button:

		WebElement community = driver.findElement(By.xpath("(//button[@class='dropdown-toggle'])[3]"));
		community.click();

		// Selecting blogs from the drop down menu
		WebElement blog = driver.findElement(By.xpath("(//a[text()='Blog'])[1]"));
		blog.click();

		// get url
		String burl = driver.getCurrentUrl();
		System.out.println("The url after reaching blogs page is:" + burl);

		// To check the alert
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();

		// clicking on Online courses-- opens up new page, use Window Handles
		// go to new Window

		WebElement Explore = driver.findElement(By.xpath("//a[text()='Explore Online Courses']"));
		Explore.click();
	}

	@Test(enabled = false)

	public void WindowHandles() {

		// trying window handles... get window handles of all the windows
		Set<String> set = driver.getWindowHandles();

		System.out.println("the window handles are: " + set);

		// switch to previous window using for loop,

		for (String s : set)

		{
			driver.switchTo().window(s);
		} // as active page is all courses, so switch shall move to previous window of
			// main page

		// get current url for main page
		String url4 = driver.getCurrentUrl();
		System.out.println("The url after switching is, blog page :" + url4);
	}

	@Test(enabled = false)

	public void NavigateBack() {// returning to the main profile page, new

		driver.navigate().back();

		String url5 = driver.getCurrentUrl();
		System.out.println("The page after navigating back is : " + url5);

		driver.findElement(By.xpath("//span[text()= 'Shallu Bass']")).click();
	}

	@AfterSuite(enabled = false)

	public void LogOut() {
		// log out WebElement logOut =
		WebElement logOut = driver.findElement(By.xpath("//a[text() = 'Log Out']"));
		logOut.click();

		driver.close();
	}

}
