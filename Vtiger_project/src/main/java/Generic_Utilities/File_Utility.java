package Generic_Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class File_Utility {


	/**
	 * its used return the value from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author desai
	 */
	public String getKeyAndValueData(String key) throws Throwable
	{
	 FileInputStream fis = new FileInputStream("./src\\\\test\\\\resources\\\\FilecommonData.properties");
	 Properties pro = new Properties();
	 pro.load(fis);
	 return pro.getProperty(key);
	}
}