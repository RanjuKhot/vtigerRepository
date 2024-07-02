package Sports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Game1 {

	public static void main(String[] args) {

		
		
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	 driver.manage().window().maximize();
	 
	}

}
