package Campaign;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;


public class CreateCampaign2 {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		 WebDriver_Utility	  wlib = new  WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		WebDriver driver=new ChromeDriver();
		 String url= flib.getKeyAndValueData("url");
		 String username = flib.getKeyAndValueData("username");
		 String password= flib.getKeyAndValueData("password");  
		
		 wlib.maximizeWindow(driver);
		 wlib.elementsToGetLoaded(driver);
       
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
       
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Campaigns")).click();
        driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
        
        int ranNum = jlib.getRandomNumber();
        
        String campaginName = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
        driver.findElement(By.name("campaignname")).sendKeys(campaginName);
       
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}



	}


