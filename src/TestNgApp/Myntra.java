package TestNgApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/*CLICK ON MEN		
CLICK ON RAIN JACKETS		
AFTER CLICK ON JACKETS OF 987 RS 		
ANY 3 		
ADD IT INTO WISHLIST		
CLICK ON WISHLIST 		
CHECK THERE THREE ITEMS ARE ADDED ARE NOT	*/
public class Myntra
{
	WebDriver driver;

	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	
	  @AfterSuite public void CloseBrowser() { driver.close(); }
	 
	@Test(priority = 0)
	public void OpenBrowser() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 1)
	public void LogIn() {

		WebElement Profile = driver.findElement(By.xpath("//div[@class='desktop-user']"));

		Actions act = new Actions(driver);
		act.moveToElement(Profile).perform();

		driver.findElement(By.xpath("//a[@data-track=\"login\" and contains(text(),'log in')] ")).click();

		WebElement SignIn = driver.findElement(By.name("email"));
		SignIn.sendKeys("shallupahwa@gmail.com");

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("alreadygot");

		WebElement ClickLogIn = driver.findElement(By.xpath("//button[text()='Log in']"));
		ClickLogIn.click();
	}
	// CLICK ON MEN CLICK ON RAIN JACKETS AFTER CLICK ON JACKETS OF 987 RS ANY 3

	@Test(priority = 2)
	public void SelectMen() throws InterruptedException {
		
		Thread.sleep(3000);
		
		WebElement Men = driver.findElement(By.xpath("//a[@data-group=\"men\" and contains(text(),'Men')]"));

		Actions act = new Actions(driver);
		act.moveToElement(Men).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Rain Jackets']")).click();
		
		String url = driver.getCurrentUrl();
		System.out.println("The url after clicking Rain jackets is:"+ url);

	}

	@Test(priority = 3)
	public void SelectJacket() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement SelJacket1 = driver
				.findElement(By.xpath("//img[@title='Sports52 wear Men Navy Blue & Purple Solid Hooded Rain Jacket']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(SelJacket1).perform();
		
		Thread.sleep(2000);
		act.moveToElement(SelJacket1).click();
		
		WebElement Wishlist1 = driver.findElement(By
				.xpath("(//div[@class='product-actions ']//span[@class='product-actionsButton product-wishlist'])[2]"));
		Wishlist1.click();

		Thread.sleep(2000);
		
		WebElement SelJacket2= driver.findElement(By.xpath("//li[@class='product-base']//img[@title=\"Sports52 wear Men Black & Blue Solid Rain Hooded Jacket S52W162664\"]"));
		act.moveToElement(SelJacket2).perform();
		
		Thread.sleep(2000);
		
		WebElement Wishlist2 = driver.findElement(By.xpath("(//div[@class='product-actions ']//span[@class='product-actionsButton product-wishlist'])[3]"));
		
		Wishlist2.click();
		
		Thread.sleep(2000);
		
		WebElement SelJacket3 = driver.findElement(By.xpath("//img[@title=\"Sports52 wear Men Black & Neon Orange Solid Hooded Jacket S52W162652\"]"));
		act.moveToElement(SelJacket3).perform();
		act.moveToElement(SelJacket3).click();
		
		Thread.sleep(2000);
		
		WebElement Wishlist3 = driver.findElement(By.xpath("(//span[@class='product-actionsButton product-wishlist'])[4]"));
		Wishlist3.click();
	
	}

	@Test(priority = 4)
	public void WishList() {
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		
		String url = driver.getCurrentUrl();
		System.out.println("The url after Checking wishlist is:"+ url);
	}
}
