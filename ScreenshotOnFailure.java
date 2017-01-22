package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenshotOnFailure {
	WebDriver d;
	@Test
	public void testScreenshotOnFailure() throws Exception
	{
		assertEquals("Pass",getScreenshot());
		Thread.sleep(4000);
			
	}
	public String getScreenshot() throws Exception
	{
		try
		{
			//Load web page
			d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
			assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
			//Bank
			Select bank=new Select(d.findElement(By.id("selBank")));
			bank.selectByIndex(4);
			//State
			Select state=new Select(d.findElement(By.id("selState")));
			state.selectByVisibleText("Andhra Pradesh12");
			//City
			Select city=new Select(d.findElement(By.id("selCity")));
			city.selectByVisibleText("Hyderabad");
			//Branch
			Select branch=new Select(d.findElement(By.id("selBranch")));
			branch.selectByVisibleText("Sanjeeva Reddy Nagar");
			return "Pass";
		}
		catch(Exception e)
		{
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("F:\\Selenium_Scripts_Dec15\\Results\\"+dateFormat.format(dt)+".png"));
	        return "Fail";
		}
	}
	@Before
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Scripts_Dec15\\Lib\\chromedriver.exe");
		//d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Scripts_Dec15\\Lib\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
