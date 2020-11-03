package Selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollPage {
	
	public class DragDrop {
		
		WebDriver driver = null;
			
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
		
		@Test
		public void scrollpage()
		{
			 JavascriptExecutor js = (JavascriptExecutor) driver;	
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 //js.executeScript("window.scrollBy(0,200)");
		}

		@AfterTest
		public void tearDown()
		{
			
			driver.quit();
		}
		}


}
