package suite1;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import util.Testutil;

public class Accounts extends Common
{
	@DataProvider(name="Data", parallel=false)
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
		page.lnkaccounts.click();
		page.clickLogout();
		page.clickOK();
		Thread.sleep(4000);
	}
	

}
