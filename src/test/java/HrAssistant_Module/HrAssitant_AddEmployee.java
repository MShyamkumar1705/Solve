package HrAssistant_Module;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.PropertyDataUtility;
import com.hrm.GenericUtility.ReadExcelDataUtility;
import com.hrm.GenericUtility.WebDriverUtility;
import com.hrm.GenericUtility.iPathContent;

public class HrAssitant_AddEmployee {

	public static void main(String[] args) throws Throwable {
WebDriver driver;
		JavaUtility jLib=new JavaUtility();
		PropertyDataUtility pLib=new PropertyDataUtility();
		ReadExcelDataUtility eLib=new ReadExcelDataUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Step 1:Get common Data
		String URL=pLib.getPropertyKeyValue("url");
		String USER=pLib.getPropertyKeyValue("user3");
		String PASSWORD=pLib.getPropertyKeyValue("password3");
		
		
		//Step 2:Login as HrAssistant
		driver=new ChromeDriver();
		wLib.forPageLoad(driver);
		driver.get(iPathContent.URL);
		driver.findElement(By.name("hr_email")).sendKeys(USER);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement type = driver.findElement(By.id("hr_type"));
		wLib.select(type, 3);
		driver.findElement(By.name("login_hr")).click();
		wLib.acceptAlert(driver);
		
		//Step 3:Go to Add Employee Pop-up
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("//p[.='Add Employee']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/ancestor::div/descendant::h3")).click();
		ArrayList<String> al=new ArrayList<String>();
		al.add("employee_companyid");
		al.add("employee_firstname");
		al.add("employee_lastname");
		al.add("employee_middlename");
		al.add("branches_datefrom");
		al.add("branches_recentdate");
		al.add("employee_department");
	    al.add("employee_branches");
		al.add("employee_position");
		al.add("employee_contact");
		al.add("employee_sss");
		al.add("employee_tin");
		al.add("employee_hdmf_pagibig");
		al.add("employee_gsis");
		for(int i=0;i<al.size();i++)
		{
			eLib.setExcelData("EmployeeDetails", 0, i, al.get(i));
			System.out.println("execute");
			
		}
	    eLib.list(driver, "book");
		
		
	}

}
