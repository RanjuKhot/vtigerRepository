package Generic_Utilities;

import java.io.File;

import java.io.IOException;
import java.lang.module.ModuleDescriptor.Exports;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class list implements ITestListener {

	Exports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		
	}

	public void onTestSuccess(ITestResult result)
	{
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("<--------I am Listening----------->");
        System.out.println("<--------I am Listening----------->");
        
		TakesScreenshot takesSceenShot = (TakesScreenshot)BaseClass.sDriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dateTime = LocalDateTime.now();
		String currentDateTime = dateTime.toString().replace(":", "_").replace(" ", "_");
		File dst = new File("./ScreenShots/" +"screenShotName"+currentDateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
}
