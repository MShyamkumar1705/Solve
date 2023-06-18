package com.hrm.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebDriverUtility;

public class dummy {

	public static void main(String[] args) throws Throwable {
       WebDriver driver=new ChromeDriver();
       WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility rLib=new ExcelUtility();
		
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		
		LoginPage lp=new LoginPage(driver);
        lp.HRHeadLogin(wLib, driver);
        
        HomePage hp=new HomePage(driver);
        hp.clickHeadEmployee();
        
        AddHrHeadEmployeePage ahp=new AddHrHeadEmployeePage(driver);
        ahp.AddHrHeadEmployee();
        //rLib.list(driver, "Sheet2");
        
	}

}
