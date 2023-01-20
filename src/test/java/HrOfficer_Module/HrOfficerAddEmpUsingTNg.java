package HrOfficer_Module;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.GenericUtility.HRMOfficerBaseClass;
import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrOfficerEmployee;
import com.hrm.ObjectPage.HomePage;

public class HrOfficerAddEmpUsingTNg extends HRMOfficerBaseClass {
	@Test
	public void addEmployee() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOfficerEmployee();
		
		AddHrOfficerEmployee aOp=new AddHrOfficerEmployee(driver);
		aOp.AddHrOfficerEmployee(rLib, driver, wLib);
	}

}
