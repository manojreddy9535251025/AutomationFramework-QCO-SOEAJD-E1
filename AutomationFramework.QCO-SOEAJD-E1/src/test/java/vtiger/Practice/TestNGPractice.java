package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(dependsOnMethods = "delete")
	public void create()
	{
		Assert.fail();
		System.out.println("create");
	}

	@Test(dependsOnMethods  = "create")
	public void modify()
	{
		Assert.fail();
		System.out.println("modify");
	}
	
	@Test
	public void delete()
	{
		System.out.println("delete");
	}
}
