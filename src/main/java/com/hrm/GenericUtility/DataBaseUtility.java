package com.hrm.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Sham
 *
 */
public class DataBaseUtility {
Connection con=null;
	public void connectToDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(iPathContent.URL,iPathContent.HEADUSER,iPathContent.HEADPASSWORD);;
		}
	/**
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
public String executeQuerryANdgetData(String query,int columnIndex,String expData) throws Throwable {
	ResultSet result = con.createStatement().executeQuery(query);
	boolean flag = false;
	while(result.next()) {
		String data = result.getString(columnIndex);
		System.out.println(data);
		if(data.equalsIgnoreCase(expData)) {
			flag=true;
			break;
		}
	}
	if(flag) {
		System.out.println(expData+ "Project is created");
		return expData;
		}
	else {
		System.out.println("Project is not created");
		return " ";	
		}
}
}
