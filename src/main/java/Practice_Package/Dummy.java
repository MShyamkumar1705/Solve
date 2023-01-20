package Practice_Package;

import org.testng.annotations.Test;

public class Dummy {
	@Test
	public void create()
	{
		System.out.println("Created");
	}
	
@Test (priority=1)
public void update() {
	System.out.println("Updated");
	}

@Test(priority=0)
public void delete() {
	System.out.println("Deleted");
}
}
