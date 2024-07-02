package Campaign;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateCampaignTest extends BaseClass {
	
@Test
	
	public  void CreateCampaignTest() throws Throwable {
	File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility(); 
		
		   
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
	    
	     //   String actData=driver.findElement(By.xpath("//span[@id='dtview_Campaign Name']")).getText();
	     //  Assert.assertEquals(actData, campaginName);
	   //    Assert.assertTrue(actData.contains(campaginName));
		  home.logOut(driver);

	}

}
