package Generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;

import com.github.dockerjava.api.model.Driver;

public class DataBaseUtility {
	 Driver driverRef;
	 Connection con;
     ResultSet result;
      public void dataBaseConnection(WebDriver driver) {
    	  Driver driverRef=new Driver();
    	 // DriverManager.getConnection(null)
      }
	public void dataBaseClose() {
		
	}
}
