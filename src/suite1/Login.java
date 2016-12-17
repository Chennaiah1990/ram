package suite1;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import util.Testutil;

public class Login extends Common
{
	@DataProvider(name="Data")
	public static Object[][] testParameterData(Method method) throws Exception
	{
		BaseTest.initialize(); 
	    Object data[][]=Testutil.getData(BaseTest.datatable_suite1,"Login");
	    return data;
	}
	
	@Test(dataProvider ="Data")
	public void testLogin(String username,String password)throws Exception
	{
		page.fillLogin(username,password);
		page.clickLogout();
		page.clickOK();
		Thread.sleep(4000);
	}
	@Test
	public void meth1()
	{
		System.out.println("Hiiiiiiii");
	}

}
