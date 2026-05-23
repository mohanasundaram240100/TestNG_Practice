package ExtentReport;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	//Need to create this before class()
	//Use whenever we don't have xml file to execute the test cases.
	//@Listeners(MyListeners.class) 

public class ExtentTest {	
	
		WebDriver driver;
		
		
		@BeforeClass
		public void setUp()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.iconplc.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@Test(priority=1)
		public void testLogo()
		{
			boolean logo= driver.findElement(By.xpath("//div[@id=\"block-sitebranding\"]")).isDisplayed();
			Assert.assertEquals(logo, true);
			
		}
		
		@Test (priority=2, dependsOnMethods = "testLogo")
		public void testURL()
		{
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://www.iconplc.com/");
			
		}
		
		
		@Test (priority=3, dependsOnMethods="testURL")
		public void testTitle()
		{
			String PageTitle= driver.getTitle();
			System.out.println(PageTitle);
			Assert.assertEquals(PageTitle, "ICON plc | Clinical Research Organisation (CRO) for Drug Development");
			
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		

	


}
