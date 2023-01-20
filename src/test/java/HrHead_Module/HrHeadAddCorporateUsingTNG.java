package HrHead_Module;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrHeadCorporatePage;
import com.hrm.ObjectPage.HomePage;

public class HrHeadAddCorporateUsingTNG extends HRMHeadBaseClass {
	@Test(retryAnalyzer=com.hrm.GenericUtility.RetryImplementationClass.class)
	public void addCorporate() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.ClickCorporate();
		fail();
		AddHrHeadCorporatePage aHp=new AddHrHeadCorporatePage(driver);
		aHp.AddCorporate(wLib, driver, rLib);
	}

}
