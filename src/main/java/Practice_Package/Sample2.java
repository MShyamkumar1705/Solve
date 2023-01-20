package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrHeadBranchPage;
import com.hrm.ObjectPage.AddHrHeadEmployeePage;
import com.hrm.ObjectPage.HomePage;

public class Sample2 extends HRMHeadBaseClass {
	

	@Test(groups="smoke")
	public void createEmployee() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickHeadEmployee();
		
		AddHrHeadEmployeePage aHp=new AddHrHeadEmployeePage(driver);
		aHp.AddHrHeadEmployee();
		rLib.list(driver, "book");
		fLib.docsUpload(driver);
		fLib.imgUpload(driver);
		wLib.textAlert(driver);
	    wLib.acceptAlert(driver);
		
	}
	@Test(groups="regression")
	public void addBranch() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickBranch();
		
		AddHrHeadBranchPage aHb=new AddHrHeadBranchPage(driver);
		aHb.AddBranch(wLib, rLib, driver);
	}

}
