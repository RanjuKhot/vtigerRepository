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
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigerLoginPage;
import objectRepository.WindowSwitingToProductPage;

public class CreateCampaignWithProductTest extends BaseClass{
	@Test
	public void CreateCampaignWithProductTest() throws Throwable {
		File_Utility flib = new File_Utility();
		 WebDriver_Utility wlib = new WebDriver_Utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
		
        int ranNumber = jlib.getRandomNumber();
        HomePage home = new HomePage(driver);
        home.clickProductLink();
       CreateProductPage prdPage = new CreateProductPage(driver);
        prdPage.clickOnPlusSign();
        
      String productData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
	  prdPage.enterProductName(productData);
	  prdPage.clickSaveButton();
      home.clickMoreLink();
      home.clickCampaignLink();
      CreateCampaignPage campPage = new CreateCampaignPage(driver);
      campPage.clickCampPlusSign();
      String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
         campPage.enterCampName(campaignData);
         campPage.clickProductPlusSign();
         wlib.switchingWindows(driver, "Products&action");
         WindowSwitingToProductPage campPrdPage = new WindowSwitingToProductPage(driver);
         campPrdPage.enterProductName(productData);
         campPrdPage.searchPrdName();
         campPrdPage.prdNamePresent(driver, productData);
         wlib.switchingWindows(driver, "Campaigns&action");
         campPage.clickOnSaveButton();
         
         
    ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
   campProdValidation.campData(driver, campaignData);
   campProdValidation.productInCamp(driver, productData);
   home.logOutFromApp();
	
	}


}
