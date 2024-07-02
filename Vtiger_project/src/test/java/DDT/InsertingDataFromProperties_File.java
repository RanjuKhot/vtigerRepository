package DDT;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {
		
		//Writing data to property_file
		Properties pro=new Properties();
		pro.setProperty("username","standard_user");
		pro.setProperty("password","secret_sauce");
		pro.setProperty("url","https://www.saucedemo.com/v1/");
		FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\FilecommonData.properties");
		pro.store(fos,"CommonData");
		System.out.println("data written successfully");
	//------------------------------------------------------------------------------
		
		//read data from property file
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\FilecommonData.properties");

		//step2:- Create an object to properties class to load all the keys
		Properties pro1=new Properties();
		pro.load(fis);
		
		//step3:- 
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		 driver.get(URL);
		 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		 driver.findElement(By.id("password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("login-button")).click();
		 
	}

}
