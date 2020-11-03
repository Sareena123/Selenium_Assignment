package Selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoSendKeys {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
    public void textEntered() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement ele = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		js.executeScript("arguments[0].value = 'Selenium'" , ele);	
		ele.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

