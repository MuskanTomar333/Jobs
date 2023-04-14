package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
public void initialize() 
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://qa-task-jp.squareboat.in/");
}
public String screenshot(WebDriver driver) throws IOException 
{
	TakesScreenshot sc=(TakesScreenshot)driver;
	File src=sc.getScreenshotAs(OutputType.FILE);
	String dest="./screenshot"+".png";
	FileUtils.copyFile(src,new File(dest));
	return dest;
}
public void quit()
{
	driver.quit();
}
}
