package TestNg;

import org.testng.annotations.Test;

public class SampleTest1 {
    
	
	
	@Test(priority=-1)
	 public void createproduct()
	 {
		System.out.println("product is created");
	 }
	
	@Test(priority=2)
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
