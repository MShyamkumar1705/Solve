package HrHead_Module;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrHeadBranchPage;
import com.hrm.ObjectPage.HomePage;
@Listeners(com.hrm.GenericUtility.ListnerImplementation.class)
public class HrHeadAddBranchUsingTNG extends HRMHeadBaseClass {

	
	@Test(groups="Smoke")
	public void addBranch() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickBranch();
		fail();
		AddHrHeadBranchPage aHb=new AddHrHeadBranchPage(driver);
		aHb.AddBranch(wLib, rLib, driver);
	}
}
