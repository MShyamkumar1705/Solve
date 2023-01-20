package Practice_Package;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrOfficerEmployee;
import com.hrm.ObjectPage.HomePage;
@Listeners(com.hrm.GenericUtility.ListnerImplementation.class)
public class Sample1 extends HRMHeadBaseClass {

	@Test(groups= {"smoke","regression"})
	public void addEmployee() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickOfficerEmployee();
		Assert.assertEquals("A", "B");
		AddHrOfficerEmployee aOp=new AddHrOfficerEmployee(driver);
		aOp.AddHrOfficerEmployee(rLib, driver, wLib);
	}


}
