package ParallelExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecutionTest {
	
	
	WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	void setUp(String browsers)
	{
		
		switch(browsers.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge"  : driver=new EdgeDriver(); break;
		default : System.out.println("Invalid Browser");
		return;
		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://iconplc.com");
		
	}
	
	@Test
	void testURL()
	{
		
	}
	
	
	@Test
	void testTitle()
	{
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	

}
