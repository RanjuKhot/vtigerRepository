package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		
		//step1:-register/load the mysql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				
				//step2:- get connect to database 
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ranjana","root","root");

				 
				 //step3:create sql statement
				 Statement state=con.createStatement();
				 
				 String query= "insert into(first_name,last_name,adderss)values('rani','khot','nipani')";
				 
				 int result=state.executeUpdate(query);
				 
				 
				 if(result==1)
				 {
					 System.out.println("data upadated");
					 
				 }
				 else
				 {
					 System.out.println("not upadated");
				 }
	}

}
