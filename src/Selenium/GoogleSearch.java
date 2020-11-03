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

public class GoogleSearch {

WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void CustomizedXpathSize()
	{
		driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("selenium");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement ul=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul"));
		List<WebElement> li=ul.findElements(By.tagName("li"));
		System.out.println("List Size:"+li.size());
		for(WebElement each:li)
		{
			WebElement ele=each.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]/div[1]"));
			System.out.println(ele.getText());
			ele.click();
			break;
		}
		
	    //driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/div/div/div/div[2]/input")).sendKeys("selenium");
	    //System.out.println(driver.manage().window().getSize());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
