package testPkg;

import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.LogOut;
import pageEvents.Login;

public class LogOutTest extends BaseClass {

	// Check whether user able to Logout
	@Test(priority = 12)
	public void logout() throws InterruptedException {
		Login log2 = new Login(driver);
		log2.ActualLogin("Admin", "admin123");
		log2.clickLoginBtn();

		Thread.sleep(8000);
		LogOut p5 = new LogOut(driver);
		p5.Logout();
		Thread.sleep(8000);
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		String expurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		if (currenturl.equals(expurl)) {
			System.out.println("User Logged Out and Redirected to Login Page >>>>>>>>>Pass");
		} else {
			System.out.println("User Still on Home page and do not logged out>>>>>>>>>>Fail");
		}

	}

}
