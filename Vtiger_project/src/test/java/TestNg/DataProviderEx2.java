package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	@Test(dataProvider = "dataProvider_bookTickets")
	public void bookTicketTest(String src,String dest)
	{
		System.out.println("book Tickets from "+src+" to " +dest+"");
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTickets()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="pune";
		
		return objArr;
		
		
	}

}
