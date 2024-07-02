package Campaign;

import org.openqa.selenium.By;




import java.io.FileInputStream;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
        driver.manage().window().maximize();
		
       
		driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        Random ranNum = new Random();
        int ranNumber = ranNum.nextInt(1000);
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		//step1:- path connections
FileInputStream fis = new FileInputStream("./src\\test\\resources\\excel2.xlsx");
	   
       //step2:-open workbook in read mode
	Workbook book = WorkbookFactory.create(fis);
	
	  //step3:-get the control of the Sheet
	Sheet sheet = book.getSheet("campaign");
	
	
	//step4:- get control of the row
	Row row = sheet.getRow(0);
	
	//step5:- get control of the cell
	Cell cell = row.getCell(0);
	
	String ExcelData = cell.getStringCellValue()+ranNumber;
	System.out.println("ExcelData");
    WebElement prdName = driver.findElement(By.name("productname"));
    prdName.sendKeys("ExcelData");
 
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Campaigns")).click();
        driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
        driver.findElement(By.name("campaignname")).sendKeys("Marketing"+ranNumber);
       
        driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
        
        Set<String> wins = driver.getWindowHandles();
      Iterator<String> it = wins.iterator();
         while(it.hasNext())
       {
    	   String win =it.next();
    	   driver.switchTo().window(win);
    	   String currentTitle = driver.getTitle();
    	   if(currentTitle.contains("Products&action"))
    	   {
    		   break;
    	   }
       }
        driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ExcelData);
        driver.findElement(By.xpath("//input[@name='search']")).click();
      
        //Dynamic Xpath
        driver.findElement(By.xpath("//a[text()='"+ExcelData+"']")).click(); 
        
	}
}