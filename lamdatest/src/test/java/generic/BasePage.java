package generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{
	WebDriver driver=null;
	Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver browser)
	{
		driver=browser;
	}
	
	public void verifyTitlePresent(String expTitle)
	{
		WebDriverWait w=new WebDriverWait(driver, 10);
		String actTitle=null;
		try
		{
			w.until(ExpectedConditions.titleContains(expTitle));
			actTitle=driver.getTitle();
			Assert.assertEquals(actTitle, expTitle);
			log.info(expTitle+ "and " +actTitle+ "matched");
			
		}
		catch(Exception e)
		{
			log.error(expTitle+ "and " +actTitle+ "did not matched" +e);
		}
	}
		
		public void  verifyElementPresent(WebElement ele)
		{
			WebDriverWait w = new WebDriverWait(driver, 10);
			try
			{
				w.until(ExpectedConditions.visibilityOf(ele));
				log.info(ele+"was found");
			}
			catch(Exception e)
			{
				log.error(",Unable to find the element"+ele+":" +e);
			}
		}
		
		public void mouseOver(WebElement ele)
		{
			try
			{
				Actions action = new Actions(driver);
				action.moveToElement(ele).perform();
				log.info("Mouse Over on" +ele);
			}
			catch(Exception e)
			{
				log.error("Mouse ovber failed");
			}
		}
	}

