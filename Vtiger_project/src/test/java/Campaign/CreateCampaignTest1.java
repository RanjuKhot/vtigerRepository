package Campaign;
import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateCampaignPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;

public class CreateCampaignTest1 {
	public class CreateCampaignTest  {
		
		
			
		public void main(String[] args) throws Throwable {
			File_Utility flib = new File_Utility();
				 WebDriver_Utility wlib = new WebDriver_Utility();
				 Java_Utility jlib = new Java_Utility();
				 Excel_Utility elib = new Excel_Utility(); 
				
				 WebDriver driver;
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
				 
				 String URL = flib.getKeyAndValueData("url");
				 String USERNAME = flib.getKeyAndValueData("username");
				 String PASSWORD = flib.getKeyAndValueData("password");
				
				 wlib.maximizeWindow(driver);
				 wlib.elementsToGetLoaded(driver);
		       
				driver.get(URL);
				VtigerLoginPage login = new VtigerLoginPage(driver);
				login.loginToApp(USERNAME, PASSWORD);   
			
		        HomePage home = new HomePage(driver);
		        home.clickMoreLink();
		        home.clickCampaignLink();
		     
		        CreateCampaignPage campPage = new CreateCampaignPage(driver);
		        campPage.clickCampPlusSign();
		        int ranNum = jlib.getRandomNumber();
		        
		        String campaginName = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
		        campPage.enterCampName(campaginName);
		        
		        campPage.clickOnSaveButton();

		        ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
		        campvalidate.campData(driver, campaginName);
		    
			  home.logOut(driver);
			}
	}
}
