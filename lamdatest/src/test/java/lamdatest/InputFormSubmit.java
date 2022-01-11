package lamdatest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputFormSubmit 
{
	WebDriver driver=null;
	@BeforeTest
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Lambda Test\\Drivers\\chromedriver.exe");
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.lambdatest.com/selenium-playground");
	}
	@Test
	public void testCase03() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")).click();
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Gaurav Golani");
		
		WebElement email = driver.findElement(By.id("inputEmail4"));
		email.sendKeys("gauravgolani6@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("inputPassword4"));
		pwd.sendKeys("Gaurav@123");
		
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("Mindtree");
		
		WebElement website = driver.findElement(By.id("websitename"));
		website.sendKeys("free");
		
		WebElement city = driver.findElement(By.id("inputCity"));
		city.sendKeys("Delhi");
		
		WebElement address1 = driver.findElement(By.id("inputAddress1"));
		address1.sendKeys("A-3/52 UGF");
		
		WebElement address2 = driver.findElement(By.id("inputAddress2"));
		address2.sendKeys("Alok kunj");
		
		WebElement state = driver.findElement(By.id("inputState"));
		state.sendKeys("Delhi");
		
		WebElement zip = driver.findElement(By.id("inputZip"));
		zip.sendKeys("110089");
		
		Select  dropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		dropdown.selectByVisibleText("United States");
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
		String  msg = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		String actualmsg = "Thanks for contacting us, we will get back to you shortly.";
		
		Assert.assertEquals(actualmsg, msg);
		}
	@AfterTest
	public void quitBrowser()
	{
		driver.quit();
	}
}
