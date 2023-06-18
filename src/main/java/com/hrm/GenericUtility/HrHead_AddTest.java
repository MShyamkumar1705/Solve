package com.hrm.GenericUtility;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.ObjectPage.AddHrHeadBranchPage;
import com.hrm.ObjectPage.AddHrHeadCorporatePage;
import com.hrm.ObjectPage.AddHrHeadEmployeePage;
import com.hrm.ObjectPage.HomePage;
import com.hrm.ObjectPage.LoginPage;
import com.hrm.ObjectPage.LogoutPage;

public class HrHead_AddTest {

	public static void main(String[] args) throws Throwable {
		
		
        WebDriver driver=new ChromeDriver();
        ExcelUtility rLib=new ExcelUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        JavaUtility jLib=new JavaUtility();
        HashMap<String, String> fields=new HashMap<String, String>();
        wLib.forPageLoad(driver);
        wLib.maximizeWindow(driver);
        {
        
         driver.get("http://rmgtestingserver/domain/HRM_System/");
		//HrHead Create Corporate
        LoginPage lp=new LoginPage(driver);
	    lp.HRHeadLogin(wLib, driver);
	
	    HomePage hp=new HomePage(driver);
	    hp.ClickCorporate();
	    
	    AddHrHeadCorporatePage ahc=new AddHrHeadCorporatePage(driver);
	    ahc.AddCorporate(wLib,driver,rLib);
	    
	    LogoutPage lo=new LogoutPage(driver);
	    lo.hrLogout(driver, wLib);
	    wLib.acceptAlert(driver);
	}
        Thread.sleep(3000);
        { 
        //HrHead Create Branch
	    LoginPage lp=new LoginPage(driver);
        lp.HRHeadLogin(wLib, driver);
        
        HomePage hp=new HomePage(driver);
        hp.clickBranch();
        
        AddHrHeadBranchPage ahb=new AddHrHeadBranchPage(driver);
        ahb.AddBranch(wLib, rLib, driver);
        
        LogoutPage lo=new LogoutPage(driver);
	    lo.hrLogout(driver, wLib);
	    wLib.acceptAlert(driver);
    	}	
	    Thread.sleep(3000);
	    //HrHead Add Employee
        
        	LoginPage lp=new LoginPage(driver);
            lp.HRHeadLogin(wLib, driver);
            
            HomePage hp=new HomePage(driver);
            hp.clickHeadEmployee();
            
            AddHrHeadEmployeePage ahp=new AddHrHeadEmployeePage(driver);
            ahp.AddHrHeadEmployee();
            ahp.AddHrHeadEmployee(fields, rLib, jLib, driver, wLib, "book");
            //rLib.list(driver, "Sheet2");
            
            LogoutPage lo=new LogoutPage(driver);
    	    lo.hrLogout(driver, wLib);
    	    wLib.acceptAlert(driver);
    	    
            
        
        }}