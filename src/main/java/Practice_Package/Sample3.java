package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.GenericUtility.HRMHeadBaseClass;
import com.hrm.ObjectPage.AddHrAssistantEmployee;
import com.hrm.ObjectPage.HomePage;

public class Sample3 extends HRMHeadBaseClass {
	@Test(groups= {"smoke","regression"})
	public void addEmployee() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickAssistantEmployee();
		
		AddHrAssistantEmployee aAp=new AddHrAssistantEmployee(driver);
    	aAp.AddHrAssistantEmployee(rLib, driver, wLib);
	}

}
