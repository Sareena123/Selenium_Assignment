package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterization {
	WebDriver driver = null;
	String url="";
		
		@BeforeTest
		public void setup()
		{
			System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);			
		}
		
		@Test(dataProvider="SearchProvider")
		public void testMethod(String name,String key) throws InterruptedException{
		    {
//		        WebElement searchText = driver.findElement(By.name("Serena"));
//		        searchText.sendKeys("surname");
		        System.out.println("Welcome "+name +" " +"Your search key is "+key);
//		        String value = searchText.getAttribute("value");
//		        System.out.println(value +"::"+surname);
//		        searchText.clear();
		    }
		    }
		        
	   @DataProvider(name="SearchProvider")
	    public Object[][] getData()
		    {
		    	Object[][] data=new Object[3][2];
		    		
		    	data[0][0]="Serena";
		    	data[0][1]="SK123";
		    		
		    	data[1][0]="Mahesh";
		    	data[1][1]="MK123";
		    		
		    	data[2][0]="Lionel";
		    	data[2][1]="LK123";
		    		
		    	return data;
		    	}
		    
		    
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
}
