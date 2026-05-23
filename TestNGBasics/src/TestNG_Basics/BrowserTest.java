package TestNG_Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserTest {
  
	WebDriver driver;
	
  @BeforeMethod
  void browserSetup() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://apple.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  
  }
  
  @Test (priority = 1)
  void iPhone()
  {
	  driver.findElement(By.xpath("//a[@aria-label='Shop iPhone']")).click();
  }
  
  
  @AfterMethod
  void browerClose()
  {
	  driver.quit();
  }
  
}
