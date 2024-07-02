package Organization;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class CreateOrganizationTest1 {
	public static void main(String[] args) throws Throwable {
		
		 File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValueData("browser");
		 if(BROWSER.equalsIgnoreCase("cHRoMe"))
		 {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else 
			 
		 {
			 driver=new ChromeDriver();
		 }
String URL = flib.getKeyAndValueData("url");
String USERNAME = flib.getKeyAndValueData("username");
String PASSWORD = flib.getKeyAndValueData("password");
		
wlib.maximizeWindow(driver);
wlib.waitForElementToLoad(driver);
		
driver.get(URL);
VtigerLoginPage login = new VtigerLoginPage(driver);
login.loginToApp(USERNAME, PASSWORD);

HomePage home = new HomePage(driver);
home.clickOrganizationLink();

CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
orgPage.clickOrgPlusSign();
int ranNum = jlib.getRandomNumber();
String organizationData = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
String phoneNum = elib.readExcelDataUsingDataFormatter("Campaign", 2, 1);
String emailId = elib.readExcelDataUsingDataFormatter("Campaign", 3, 1); 
orgPage.orgData(organizationData, phoneNum, emailId);
orgPage.clickOnSaveButton();
Thread.sleep(2000);
home.logOut(driver);
	}

}
