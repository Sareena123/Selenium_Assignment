package Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class BrokenLinks {

	WebDriver driver = null;
	String url="";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://www.zlti.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
		@Test
	public void Links() {
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> iter=links.iterator();
		while(iter.hasNext()) {
		url=iter.next().getAttribute("href");
		System.out.println(url);

		if(url.isEmpty()){
		System.out.println("URL is empty!");
		continue;
	
		}
	}
}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
