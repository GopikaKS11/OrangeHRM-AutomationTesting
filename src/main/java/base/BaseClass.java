package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void TestFailure(ITestResult result) throws IOException {

		System.out.println("<<<<<Test Completed>>>>>");
		System.out.println("=====================================================================");
		if (result.getStatus() == ITestResult.FAILURE) {
			//String filename=System.getProperty("user.dir")+File.separator+ "screenshots" + File.separator+result.getMethod().getMethodName();
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File ("./screenshot//" +result.getName()+ ".png"));
			
		}
		
		
	}

	@AfterClass
	public void SiteClose() {
		driver.quit();
	}

}