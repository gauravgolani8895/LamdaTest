package lamdatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SimpleFormDemo {

	WebDriver driver=null;
@BeforeTest
public void launchApp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Lambda Test\\Drivers\\chromedriver.exe");
	
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.lambdatest.com/selenium-playground");
}
	
@Test
public void testCase01() throws InterruptedException
{
	
	
	driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
	Thread.sleep(2000);
	WebElement simpleForm;
	simpleForm=driver.findElement(By.xpath("//a[contains(text(),'Simple Form Demo')]"));
	simpleForm.click();
	String acturl=driver.getTitle();
	String expurl="Selenium Grid Online | Run Selenium Test On Cloud";
	Assert.assertEquals(acturl, expurl);
	
	String welcomeMsg = "Welcome to LambdaTest";
	driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(welcomeMsg);
	driver.findElement(By.xpath("//button[@id='showInput']")).click();
	String  msg = driver.findElement(By.xpath("//p[@id='message']")).getText();
	Assert.assertEquals(msg, welcomeMsg);
}

@AfterTest
public void quitBrowser()
{
	driver.quit();
}
}
