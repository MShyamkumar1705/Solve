package HrOfficer_Module;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMOfficerBaseClass;
import com.hrm.ObjectPage.AddHrAssistantEmployee;
import com.hrm.ObjectPage.HRMAssistantBaseClass;
import com.hrm.ObjectPage.HomePage;
import com.hrm.ObjectPage.LoginPage;
import com.hrm.ObjectPage.LogoutPage;
import com.hrm.ObjectPage.VerifyOfficerEmployee;

class HrOfficerVerifyEmployee extends HRMOfficerBaseClass{
	@Test(priority=2)
	public void verify() {
		HomePage hp=new HomePage(driver);
		hp.clickOfficerEmployee();
		
		VerifyOfficerEmployee vOp=new VerifyOfficerEmployee(driver);
		vOp.execution();
	
		
	}

}
class HrOfficerVerify extends HRMAssistantBaseClass{
	@Test(priority=1)
public void addAssistantEmployee() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickAssistantEmployee();
		
		AddHrAssistantEmployee aHp=new AddHrAssistantEmployee(driver);
		aHp.AddHrAssistantEmployee(rLib, driver, wLib);
		
		LogoutPage lo=new LogoutPage(driver);
		lo.hrLogout(driver, wLib);
		
	}
}
