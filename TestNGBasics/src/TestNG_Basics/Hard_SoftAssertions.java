package TestNG_Basics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hard_SoftAssertions {
	
	SoftAssert sa;
	
	@Test
	void hardAssertion()
	{
		String actual="Mohanasundaram";
		String expected="Mohanasundaram";
		
		Assert.assertEquals(actual, expected);
		
		/*
		
		if(actual.equals(expected))
		{
			System.out.println("Test case passed");
			Assert.assertTrue(true);
			
		}else
		{
			System.out.println("Test case failed");
			Assert.assertFalse(false);
			
		}
		*/
		
	}
	
	
	@Test
	void softAssertions()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 1);
		sa.assertAll();
		
	}
	

}
