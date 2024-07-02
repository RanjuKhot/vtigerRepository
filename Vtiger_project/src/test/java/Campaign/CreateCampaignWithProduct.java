package Campaign;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignWithProduct {
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
		 wlib.waitForElementToLoad(driver);

        driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
       
        int ranNumber = jlib.getRandomNumber();
      
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		

	String productData = elib.getExcelData("Product", 0, 0)+ranNumber;
	driver.findElement(By.name("productname")).sendKeys(productData);
 
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Campaigns")).click();
        driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
    
        String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
         driver.findElement(By.name("campaignname")).sendKeys(campaignData);
       
        driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
        
        wlib.switchingWindows(driver, "Products&action");
        
        driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productData);
        driver.findElement(By.xpath("//input[@name='search']")).click();
      
        //Dynamic Xpath
        driver.findElement(By.xpath("//a[text()='"+productData+"']")).click(); 
        
        wlib.switchingWindows(driver, "Campaigns&action");
        
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
     }

}
