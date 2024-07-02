package TestNg;

import org.testng.annotations.Test;

public class SampleTest {
	 
	@Test
	 public void createproduct()
	 {
		System.out.println("product is created");
	 }
	
	@Test(dependsOnMethods="createproduct")
	public void modifyproduct()
	{
		System.out.println("product is modified");
	}
	
	@Test(dependsOnMethods="createproduct")
	public void deleteproduct()
	{
		System.out.println("product is deleted");
	}
	
}

