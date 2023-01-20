package HrAssistant_Module;

import org.testng.annotations.Test;

import com.hrm.ObjectPage.AddHrAssistantEmployee;
import com.hrm.ObjectPage.HRMAssistantBaseClass;
import com.hrm.ObjectPage.HomePage;

public class HrAssAddEmpUsingTNG extends HRMAssistantBaseClass {

	@Test
	public void addEmployee() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.clickAssistantEmployee();
		
		AddHrAssistantEmployee aAp=new AddHrAssistantEmployee(driver);
    	aAp.AddHrAssistantEmployee(rLib, driver, wLib);
	}
}
