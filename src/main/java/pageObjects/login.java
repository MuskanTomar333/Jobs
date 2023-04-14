package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;
	home hm;
	forgotPass fp;
public login(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="email")
WebElement email;
@FindBy(id="password")

WebElement pass;

public home login(String emailId,String password)
{
	email.sendKeys(emailId);
	pass.sendKeys(password);
	driver.findElement(By.xpath("//button")).click();
	hm=new home(driver);
	return hm;
}
public forgotPass forgot()
{
	driver.findElement(By.linkText("Forgot your password?")).click();
	fp= new forgotPass(driver);
	return fp;
}
}
