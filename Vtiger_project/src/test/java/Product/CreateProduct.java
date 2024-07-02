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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;


public class CreateProduct {
	public static void main(String[] args) throws Throwable {
		
		 File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		 WebDriver driver=new ChromeDriver();
		 String URL = flib.getKeyAndValueData("url");
		 String USERNAME = flib.getKeyAndValueData("username");
		 String PASSWORD = flib.getKeyAndValueData("password");
		
		wlib.maximizeWindow(driver);
		wlib.elementsToGetLoaded(driver);
      
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       driver.findElement(By.id("submitButton")).click();

      int ranNum = jlib.getRandomNumber();
       
      driver.findElement(By.linkText("Products")).click();
     driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	
	String productData = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
	driver.findElement(By.name("productname")).sendKeys(productData);

   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

		
	

}
