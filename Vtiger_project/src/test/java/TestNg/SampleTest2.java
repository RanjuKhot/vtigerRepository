package TestNg;

import org.testng.annotations.Test;

public class SampleTest2 {

	
	@Test(invocationCount=2 , priority=2)
	 public void createproduct()
	 {
		System.out.println("product is created");
	 }
	
	@Test(enabled=false)
	public void modifyproduct()
	{
		System.out.println("product is modified");
	}
	
	@Test(priority=1)
	public void deleteproduct()
	{
		System.out.println("product is deleted");
	}
	
}
