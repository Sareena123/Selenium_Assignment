package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDrop {
	WebDriver driver = null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void dragdrop()
	{
		List<WebElement> iframes= driver.findElements(By.tagName("iframe"));
		System.out.println("Size:"+ iframes.size());
		driver.switchTo().frame(0);

		WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();	
		
	}

	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
	}
	}


