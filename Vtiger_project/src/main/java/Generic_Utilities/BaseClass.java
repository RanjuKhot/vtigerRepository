package Generic_Utilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;



public class BaseClass {
	public static TakesScreenshot sDriver;
	public WebDriver driver;
	public File_Utility flib=new File_Utility();
	public Excel_Utility elib=new Excel_Utility();
	public Java_Utility jlib=new Java_Utility();
	public WebDriver_Utility wlib=new  WebDriver_Utility();
	 public DataBaseUtility dlib=new DataBaseUtility();
	
		
		@BeforeSuite(groups = { "smokeTest", "regressionTest" })
		public void bs()
		{
			System.out.println("DataBase Connection");
		}
		@BeforeTest(groups = { "smokeTest", "regressionTest" })
		public void bt()
		{
			System.out.println("parallel execution");
		}
		@BeforeClass(groups = { "smokeTest", "regressionTest" })
		public void bc() throws Throwable
		{
		 String BROWSER = flib.getKeyAndValueData("browser");
			 if(BROWSER.equalsIgnoreCase("chrome"))
			 {
				 WebDriverManager.chromedriver().setup();
				  driver=new ChromeDriver();
			 }
			 else if(BROWSER.equalsIgnoreCase("fireFox"))
			 {
				 WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();
			 }
			 else
			 {
				 driver=new ChromeDriver();
			 }
			System.out.println("Browser launched");
			sDriver = (TakesScreenshot) driver;
		}
		@BeforeMethod(groups = { "smokeTest", "regressionTest" })
		public void bm() throws Throwable
		{
		     String URL = flib.getKeyAndValueData("url");
			  String USERNAME = flib.getKeyAndValueData("username");
			  String PASSWORD = flib.getKeyAndValueData("password");
					
			  WebDriver_Utility wlib = new WebDriver_Utility();
			  wlib.maximizeWindow(driver);
			  wlib.waitForElementToLoad(driver);
					
			  driver.get(URL);
			  VtigerLoginPage login = new VtigerLoginPage(driver);
		     login.loginToApp(USERNAME, PASSWORD);
			System.out.println("login to Application");
		}
		@AfterMethod
		public void am()
		{
		
			HomePage home = new HomePage(driver);
			 home.logOut(driver); 
			System.out.println("logout from application");
		}
		@AfterClass
		public void ac()
		{
			driver.close();
			driver.quit();
			System.out.println("close browser");

}
		@AfterTest
		public void at()
		{
			System.out.println("parallel execution done");
		}
		@AfterSuite(groups = { "smokeTest", "regressionTest" })
		public void as() throws Throwable {
			dlib.dataBaseClose();
			System.out.println("close database");
		}
	}
	 