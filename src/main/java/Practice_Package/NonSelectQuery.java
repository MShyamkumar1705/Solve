package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		int result=0;
		
		try {
			Driver driver=new Driver();
			//step1:Register the database
			DriverManager.registerDriver(driver);
			
			//step2:Get connection for the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
			
			//step3:Issue create Statement
			Statement state = con.createStatement();
			
			String query = "insert into studentInfo values('Mir','btm','Appium',1);";
			
			//step4:Execute Query/Update Query
			result = state.executeUpdate(query);
		}
	
			
		 catch (Exception e) {
		}
		
		finally {
			//step5:close the database connection
			if(result==1) {
				System.out.println("Data is inserted successfully");
			}
			else {
				System.out.println("Data not inserted");
			}
	
			con.close();
		}
		}
		
		
	}


