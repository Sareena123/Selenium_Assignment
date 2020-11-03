package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadProperties {
	WebDriver driver = null;
	String url="";
		
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);         
		}
		
		@Test
		public void Read() throws IOException
		{
			Properties prop= new Properties();
		    FileInputStream fis= new FileInputStream("C:\\Users\\Sareena_Badami\\eclipse-workspace\\Selenium_Assignments\\Configurations\\config.properties"); 
			prop.load(fis);
			System.out.println(prop.getProperty("browser"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("Username"));
			System.out.println(prop.getProperty("Password"));
		    
		}	
		
		@AfterTest
		public void tearDown()
		{
			
			driver.quit();
		}

}
