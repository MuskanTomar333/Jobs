package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
public static ExtentReports er;
public static ExtentReports extent()
{
	ExtentSparkReporter sr=new ExtentSparkReporter("./report"+System.currentTimeMillis()+".html");
	sr.config().setDocumentTitle("Testing");
	er=new ExtentReports();
	er.attachReporter(sr);
	er.setSystemInfo("user", "Muskan Tomar");
	return er;
}
}
