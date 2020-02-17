package TestNgApp;
//Create a test case to fetch the data from an excel sheet and feed it to the application under test.

import org.testng.annotations.Test;
import java.io.FileInputStream;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

//using TestNg and @Data Provider to make a Framework
//Executing the AUT using DataDriven Framework in combination with TestNg

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Assignments.Mod9CaseStudyPOM;

public class Mod9TestCase {

	static WebDriver driver;
	Workbook wb;
	Sheet sh;
	int numRows;
	int numCols;

	@BeforeSuite
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.edureka.co/");
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}

	@Test(priority = 0)
	public void LogIn() {
		Mod9CaseStudyPOM page1 = new Mod9CaseStudyPOM(driver);
		page1.LogIn();
	}

	@Test(dataProvider = "FetchData", priority = 1) // to form the connectivity between DataProvider and Test case
	public void LogIn(String Uname, String Pass) throws Exception {
		Mod9CaseStudyPOM page2 = new Mod9CaseStudyPOM(driver);
		page2.SendCred(Uname, Pass);
	}

	@DataProvider
	public Object[][] FetchData() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Shallu\\eclipse-workspace"
				+ "\\Selenium Training Practice Edureka\\src\\Assignments\\Mod9DDFWTestCase.xlsx");
		// Workbook = Excel file is created. Open up the Workbook

		wb = WorkbookFactory.create(fis);

		sh = wb.getSheet("Sheet1");

		// Sheet which inside the Excel file = Workbook// workbook is an interface in
		// Apache POI ss.usermodel
		// Open up the sheet
		// Read the data and run it in the loop
		// get the total number of rows and total number of columns

		numRows = sh.getLastRowNum() + 1;

		System.out.println("no of rows are :" + numRows);

		numCols = sh.getRow(1).getLastCellNum();

		System.out.println("no of columns are :" + numCols);

		Object[][] LogInCred = new Object[numRows][numCols];
		// numRows & numCols define the size of the array,
		// so both of them have to be extreme limit of matrix

		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				LogInCred[row][col] = sh.getRow(row).getCell(col).toString();
			}
		}
		// creates an array with name formData and i,j as 2 parameters with Strings as
		// attributes and return value.
		// i and j (== row and col )are to be taken from the excel sheet inside the
		// workbook
		// instead of column, cell is used
		// the value from row and col is taken as a String variable, We also created
		// String as variable to be filled in the form in pOM
		return LogInCred;

	}

	@Test(priority = 2)
	public void Click() throws InterruptedException {
		Mod9CaseStudyPOM page3 = new Mod9CaseStudyPOM(driver);
		page3.Click();

	}

	@Test(priority = 3)
	public void ExploreBlogs() throws InterruptedException 
	{
		Mod9CaseStudyPOM page4 = new Mod9CaseStudyPOM(driver); // creating an object of Page OM
		page4.ExploreBlogs(); 
		// calling the methods created in the page object Model class
	}

	

}
