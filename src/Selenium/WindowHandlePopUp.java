package Selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandlePopUp {
	
WebDriver driver=null;
	
	@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\Driver\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void windowpopup()
//	{
//		WebElement popup1=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]"));
//		popup1.click();
//		driver.switchTo().alert().dismiss();
//		
//		WebElement popup2=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[2]"));
//		popup2.click();
//		driver.switchTo().alert().dismiss();
//		
//		WebElement popup3=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[3]"));
//		popup3.click();
//		driver.switchTo().alert().dismiss();
//		
//		WebElement popup4=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[4]"));
//		popup4.click();
//		driver.switchTo().alert().dismiss();
//			
//	}
//	
	
//		// Fetch the number of opened windows
//				Set<String> windowHandles = driver.getWindowHandles();
//				System.out.println("Number of opened windows: " + windowHandles.size());
//				Integer temp=0;
//				String msg=null;
//				
//				//Iterate through all the available windows
//				for (String string : windowHandles) {
//					//Switch between windows using the string reference variable
//					driver.switchTo().window(string);
//					
//					//Fetch the url of the page post successful switch
//					String title = driver.getTitle();
//					
//					//check whether the url post switch is the desired page
//					if (!title.equals("PopupTest - test your popup blocker, download free popup blockers")) {
//						temp = 1;
//						msg="Window found.";
//						break;
//					} else {
//						temp = 0;
//					}
//				}
//		 
//				if (temp == 1) {
//					
//					System.out.println(msg);
//				
//					//Find some element from the switched page to verify that the switch is successful
//					WebElement w1 = driver.findElement(By.xpath("/html/body/div/span[1]"));
//					System.out.println(w1.getText()+"window");
//				}
//				else if (temp == 0) {
//					System.out.println("Desired Window not found.");
//				}
//				
				
	@Test
	public void windowscount()
	{
				//Set<String> windowHandles = driver.getWindowHandles();
				String mainwindow=driver.getWindowHandle();
			    List<WebElement> links=driver.findElements(By.partialLinkText("Good PopUp"));
			    System.out.println("Number of Links :"+links.size());
			    
			    for(int i=0;i<links.size();i++)
			    {
			    	links.get(i).click();	
			    	System.out.println("we are in child window");
			    	driver.switchTo().window(mainwindow);
			    	System.out.println("we are in parent window");
			    }
			}
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
	}
	

}

