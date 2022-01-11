package lamdatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropSliders {
	
	WebDriver driver=null;
	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\lamdatest\\Drivers\\chromedriver.exe");
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lambdatest.com/selenium-playground");
	}
	@Test
	public void testCase02() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Drag & Drop Sliders')]")).click();
		WebElement src= driver.findElement(By.xpath("//input[@value='15']"));
		WebElement dest = driver.findElement(By.xpath("//output[@id='rangeSuccess']"));
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest);
		
		
	}

	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
}
