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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import objectRepository.CreateOrganizationPage;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.VtigerLoginPage;
@Listeners(Generic_Utilities.list.class)
public class CreateOrganizationTest extends BaseClass{

	//@Test//(groups = {"smokeTest","regressionTest"})
	@Test(retryAnalyzer = Generic_Utilities.RetryImplementation.class)
	public void createOrganizationTest() throws Throwable {
  HomePage home = new HomePage(driver);
  home.clickOrganizationLink();
 
 CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
  orgPage.clickOrgPlusSign();
  int ranNum = jlib.getRandomNumber();
  String organizationData = elib.readExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
  Assert.assertEquals(false, true);
  String phoneNum = elib.readExcelDataUsingDataFormatter("Organization", 2, 1);
  String emailId = elib.readExcelDataUsingDataFormatter("Organization", 3, 1); 
  orgPage.orgData(organizationData, phoneNum, emailId);
     Assert.fail();
 
  orgPage.clickOnSaveButton();
  Thread.sleep(2000);
}
}
 


