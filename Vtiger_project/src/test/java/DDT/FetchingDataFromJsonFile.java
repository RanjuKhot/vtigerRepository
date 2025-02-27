package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class FetchingDataFromJsonFile {

	public static void main(String[] args) throws Throwable {
		
		
		File file=new File("./src\\test\\resources\\jsonFile.json");
		ObjectMapper jsonData=new ObjectMapper();
		JsonNode data=jsonData.readTree(file);
		
		String URL=data.get("url").asText();
		String USERNAME=data.get("username").asText();
		String PASSWORD=data.get("password").asText();
	
	   
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		 driver.findElement(By.id("password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("login-button")).click();
		 

	}

}
