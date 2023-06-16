package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void test()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(false, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}

	@Test
	public void test1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(true, true);
		
		System.out.println("Step 4");
		
		 sa.assertTrue(false);

		System.out.println("Step 5");
		System.out.println("Step 62");
		sa.assertAll();
	}
	
	@Test
	public void test2()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertTrue(false);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		sa.assertTrue(false);
		
		Assert.assertTrue(false);
		
		System.out.println("Step 6");
		sa.assertAll();
		
	}
	
}
