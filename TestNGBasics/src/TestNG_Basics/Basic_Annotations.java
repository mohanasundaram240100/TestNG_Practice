package TestNG_Basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_Annotations {
	
	/*
	 1. Login to the application
	 2. Create a new user
	 3. Delete the user
	 4. Close the application 
	 */
	
	
	@BeforeMethod
	void loginApp()
	{
		
	}
	
	@Test (priority = 1)
	void createUser()
	{
		
	}
	
	@Test (priority = 2)
	void deleteUser()
	{
		
	}
	
	@AfterMethod
	void closeApp()
	{
		
	}
	
	
	
	
	
	
	
}
