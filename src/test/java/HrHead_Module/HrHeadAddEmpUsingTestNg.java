package HrHead_Module;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrHeadEmployeePage;
import com.hrm.ObjectPage.HomePage;
@Listeners(com.hrm.GenericUtility.ListnerImplementation.class)
public class HrHeadAddEmpUsingTestNg extends HRMHeadBaseClass{
	
	@Test(groups=  {"smoke","regression"})
	public void createEmployee() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickHeadEmployee();
		fail();
		AddHrHeadEmployeePage aHp=new AddHrHeadEmployeePage(driver);
		aHp.AddHrHeadEmployee();
		rLib.list(driver, "book");
		fLib.docsUpload(driver);
		fLib.imgUpload(driver);
		wLib.textAlert(driver);
	    wLib.acceptAlert(driver);
		
	}

}
