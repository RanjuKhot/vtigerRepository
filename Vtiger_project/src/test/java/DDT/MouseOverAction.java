package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseOverAction {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	
  /*  driver.get("https://www.amazon.in");
    WebElement ele = driver.findElement(By.xpath("//a[text()=\"Today's Deals\"]"));
	Actions act = new Actions(driver);
     act.moveToElement(ele).perform();
	act.contextClick(ele).perform();  */
	//or
	//act.moveToElement(ele).contextClick(ele).perform();*/
		
 /*   driver.get("https://www.saucedemo.com/v1/");
	WebElement UserName = driver.findElement(By.name("user-name"));	
	WebElement PassWord = driver.findElement(By.name("password"));
	WebElement Login = driver.findElement(By.id("login-button"));
	
	Actions act = new Actions(driver);
	act.sendKeys(UserName, "standard_user").perform();
	act.sendKeys(PassWord, "secret_sauce").perform();
	act.click(Login).perform(); */
	
	//or
 //	act.sendKeys(UserName, "standard_user").sendKeys(PassWord, "secret_sauce").click(Login).build().perform();
	
/*	driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	
	WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
	
	Actions act = new Actions(driver);
//	act.clickAndHold(drag).perform();
//	act.release(drop).perform();
	
	//or
	act.dragAndDrop(drag, drop).perform();*/
	
	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	WebElement ele = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	Actions act = new Actions(driver);
	act.doubleClick(ele).perform();
		

}


	}


