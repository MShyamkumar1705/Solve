package HrOfficer_Module;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.GenericUtility.HRMOfficerBaseClass;
import com.hrm.ObjectPage.EditHrOfficerEmployeePage;
import com.hrm.ObjectPage.HomePage;

public class HrOfficerEditEmpUsingTNg extends HRMOfficerBaseClass{
	@Test
	public void EditEmployee() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOfficerEmployee();
		
		EditHrOfficerEmployeePage eOp=new EditHrOfficerEmployeePage(driver);
		eOp.editHrOfficer(wLib, driver, rLib);
	}

}
