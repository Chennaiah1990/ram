package suite1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import util.SendMail;
import util.Zip;
import base.BaseTest;

public class Common {
	public BaseTest page;
	@Parameters({"browser","url"})
	@BeforeTest
	public void openBrowser(String browser,String url)
	{
		if(browser.equals("FF"))
		{
			page = PageFactory.initElements(new FirefoxDriver(), BaseTest.class);
			
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Driver Server\\IEDriverServer.exe");
			page = PageFactory.initElements(new InternetExplorerDriver(), BaseTest.class);
			
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Driver Server\\chromedriver.exe");
			page = PageFactory.initElements(new ChromeDriver(), BaseTest.class);
			
		}
		page.openURL(url);
	} 
  @AfterTest
  public void stop()
  {
      page.stopDriver();
  }
  /*@AfterSuite
  public void sendMail() throws Exception
	  {
	    //Zip.zipFolder("F:\\Selenium_Scripts_Feb15\\Hybrid\\test-output","F:\\Selenium_Scripts_Feb15\\Hybrid\\Results\\"+"Reports.zip");    
	    Zip.zipFolder(System.getProperty("user.dir")+"\\Reports",System.getProperty("user.dir")+"\\Results\\"+"Reports.zip");
	    String[] to={"qtt.selenium.sep@gmail.com"};
	    String[] cc={"qtt.selenium@gmail.com"};
	    String[] bcc={};

	    //This is for google
        SendMail.sendMailTo("qtt.selenium.sep@gmail.com",
	                         "selenium4567",
	                          "smtp.gmail.com",
	                          "465",
	                          "true",
	                          "true",
	                           true,
	                          "javax.net.ssl.SSLSocketFactory",
	                          "false",
	                          to,
	                          cc,
	                          bcc,
	                          "Automation Reports",
	                          "Please find the reports attached in the mail.\n\n Regards\nWebMaster",
	                          System.getProperty("user.dir")+ "\\Results"+"\\Reports.zip",
	                          "Reports.zip"); 
	 }*/


}
