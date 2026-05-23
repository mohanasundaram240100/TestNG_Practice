package Listeners;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//Need to create this before class()
//@Listeners(MyListeners.class) //Use whenever we don't have xml file to execute the test cases.

public class listenersTests {
	
	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.iconplc.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void testLogo()
	{
		boolean logo= driver.findElement(By.xpath("//div[@id=\"block-sitebranding\"]")).isDisplayed();
		Assert.assertEquals(logo, true);
		
	}
	
	@Test (priority=2, dependsOnMethods = "testLogo")
	void testURL()
	{
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.iconplc.comm/");
		
	}
	
	
	@Test (priority=3, dependsOnMethods="testURL")
	void testTitle()
	{
		String PageTitle= driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals(PageTitle, "ICON plc | Clinical Research Organisation (CRO) for Drug Development");
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	

}
