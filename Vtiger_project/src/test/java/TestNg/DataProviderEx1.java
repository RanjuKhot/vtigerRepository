package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	 
		@Test(dataProvider = "dataProvider_bookTickets")
		public void bookTicketTest(String src,String dest,int numOfpp)
		{
			System.out.println("book Tickets from "+src+" to " +dest+" ,"+numOfpp+"");
		}
		
	@DataProvider
	public Object[][] dataProvider_bookTickets()
	{
		
		
			Object[][]objArr = new Object[3][3];
			
			objArr[0][0]="Banglore";
			objArr[0][1]="Goa";
			objArr[0][2]=1;
			
			objArr[1][0]="Banglore";
			objArr[1][1]="mysore";
			objArr[1][2]=2;
			
			objArr[2][0]="Banglore";
			objArr[2][1]="pune";
			objArr[2][2]=3;
			return objArr;
	}
}
