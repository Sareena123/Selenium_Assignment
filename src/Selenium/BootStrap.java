package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootStrap {

	WebDriver driver = null;
	String url="";
		
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//			driver.findElement(By.xpath("//*[@id=\"cbb\"]/svg/path[1]")).click();
//            driver.switchTo().defaultContent();
          
		}
		
		@Test
		public void bootstrapdrpdown()
		{		    
      		//driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul/li[4]/a/label")).click();
			driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
            //List<WebElement> list= driver.findElements(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/ul"));
			List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li/a/label"));
			System.out.println(list.size());
			for(int i=1;i<list.size();)
			{
				if(list.get(i).getText().contains("Python"))
				list.get(i).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				System.out.println(list.get(i).getText());
				break;
		
			}
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
}
