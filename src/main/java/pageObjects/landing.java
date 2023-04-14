package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landing {
	WebDriver driver;
	login log;
	signUp su;
public landing(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//button[@type='button']")
WebElement SignUpBtn;
public login logIn()
{
	driver.findElement(By.xpath("//button")).click();
	log=new login(driver);
	return log;
}
public signUp SignUpBtn()
{
	SignUpBtn.click();
	signUp su=new signUp(driver);
	return su;
}
}
