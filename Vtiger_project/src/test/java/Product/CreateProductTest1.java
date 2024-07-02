package Product;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateCampaignPage;
import objectRepository.CreateProductPage;
import objectRepository.DeleteProductValidationPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;

public class CreateProductTest1 {
	public static void main(String[] args) throws Throwable {
		
		 File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		 WebDriver driver;
		 String BROWSER = flib.getKeyAndValueData("browser");
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			  driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("fireFox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
		 String URL = flib.getKeyAndValueData("url");
		 String USERNAME = flib.getKeyAndValueData("username");
		 String PASSWORD = flib.getKeyAndValueData("password");
		
		wlib.maximizeWindow(driver);
		wlib.elementsToGetLoaded(driver);
      
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
     
		int ranNum = jlib.getRandomNumber();
   
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
	        int ranNumber = jlib.getRandomNumber();
	        String productData = elib.readExcelDataUsingDataFormatter("Campaign", 1, 1)+ranNumber;

	    	prdPage.enterProductName(productData);
	    	
	      
	    	prdPage.clickSaveButton();
	    	

	    	home.clickProductLink();

	    	DeleteProductValidationPage prdValidate = new DeleteProductValidationPage(driver);
	    	
	    	 prdValidate.deleteProduct(driver, productData);
		
		

	}



}
