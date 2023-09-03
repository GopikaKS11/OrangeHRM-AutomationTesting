package testPkg;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.Login;

public class UserNameTest extends BaseClass {

	@Test(priority = 13)
	public void UserNameCheck() throws InterruptedException {
		Login log1 = new Login(driver);
		log1.ActualLogin("ADMIN", "admin123");// Actual usernme is Admin ,username should case sensitive
		log1.clickLoginBtn();
		Thread.sleep(4000);
		String Exp = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String Act = driver.getCurrentUrl();
		System.out.println("URL expected " + Exp);
		System.out.println("URL got " + Act);
		Assert.assertEquals(Act, Exp, "Username is not case sensitive");
	}

}
