package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataInTyAPI {
	

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement state=con.createStatement();
			String query="insert into project values('TY_Project_103','Sam','21/12/2022','HRM','Created','3')";
			result=state.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(result==1) {
				System.out.println("Data is inserted successfully");
			}
			else {
				System.out.println("Data is not inserted");
			}
			con.close();
		}

	
	
}

}
