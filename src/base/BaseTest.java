 package base;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import config.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import datatable.Xls_Reader;
import static org.testng.Assert.*;
public class BaseTest extends OR 
{
		
	public static Xls_Reader datatable_suite1=null;
	public BaseTest(WebDriver driver)
	{
		super(driver);
	}
	
	public static void initialize() throws Exception
	{
		datatable_suite1=new Xls_Reader(System.getProperty("user.dir")+"//src//config//TestData.xlsx");
		
	}
	//Login
	public void fillLogin(String uname, String upwd)
	{
		txtUsername.clear();
		txtUsername.sendKeys(uname);
		txtPassword.clear();
		txtPassword.sendKeys(upwd);
		btnSubmit.click();
		
	}
	//OK
	public void clickOK()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	//Cancel
	public void clickCancel()
	{
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}
	
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	public void openURL(String url)
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);  
		driver.get(url);
	}
			

		public String getTitle()
		{
		return driver.getTitle();
		}

		
	
	public void stopDriver()
	{
		
		driver.quit();
	}
	
		
	public static void takeScreenShots(String fileName) throws IOException{
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".png"));
	}
	public String randNumGen(int i) 
	{
		return RandomStringUtils.randomNumeric(i);
	}

	public String randNameGen(int i) 
	{
		return RandomStringUtils.randomAlphabetic(i).toLowerCase();
	}

	public String randUserGen() 
	{
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmm");
		String strUser = ft.format(d);
		return strUser;
	}
		
	
	public void verifyElementPresent(WebElement e)
	{
		assertTrue(e.isDisplayed());
	}
	
}
