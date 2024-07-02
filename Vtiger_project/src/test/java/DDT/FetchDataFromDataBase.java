package DDT;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		//step1:-register/load the mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:- get connect to database 
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ranjana","root","root");
   
		 
		 //step3:create sql statement
		 Statement state=con.createStatement();
		 
		 String query="select*from student";
		 
		 //step4:-Execute statement/query
		 ResultSet result=state.executeQuery(query);
		 
		 while(result.next())
		 {
			 System.out.println(result.getInt(1) +"\t"+result.getString(2)+ "\t"+result.getString(3)+"\t"+result.getString(4)); 
			 System.out.println(result.getInt(1) +"\t"+result.getString(2)+ "\t"+result.getString(3)+"\t"+result.getString(4));
			 System.out.println(result.getInt(1) +"\t"+result.getString(2)+ "\t"+result.getString(3)+"\t"+result.getString(4));
			 //step5:-close database
			 con.close();
		 }
	}

}
