package testing;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.forgotPass;
import pageObjects.home;
import pageObjects.landing;
import pageObjects.login;
import pageObjects.signUp;
import utilities.base;

public class test extends base{
	@BeforeMethod
	public void test0()
	{
		initialize();
	}
	@Test
	public void test1()
	{
		landing l=new landing(driver);
		login log=l.logIn();
		home h=log.login("Muskan@gmail.com","poiuyt");
		Assert.assertEquals(h.btn(), "Home");
		System.out.println("test");
	}
	@Test
	public void test2()
	{
		landing l=new landing(driver);
		login log=l.logIn();
		forgotPass fp=log.forgot();
		Assert.assertEquals(fp.fpPage(),"Forgot your password?");
	}
	@Test
	public void test3()
	{
		landing l=new landing(driver);
		signUp su=l.SignUpBtn();
		Assert.assertEquals(su.Title("Muskan"),"Signup | Job Portal");
	}
	
	@AfterMethod()
	public void testFinal()
	{
		quit();	
	}
	
}
