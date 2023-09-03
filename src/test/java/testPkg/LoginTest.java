package testPkg;

import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.Login;
import utility.Excel;

public class LoginTest extends BaseClass {
	// Check login with valid and invalid username and password

	@Test(priority = 6)
	public void verifyLogin() throws InterruptedException {
		Login p1 = new Login(driver);

		// Reading data from xl file
		String filepath = "B:\\\\Software testing\\\\AutomationProject\\\\OrangeHRMLogin.xlsx";
		String sheetname = "Sheet1";
		int RC = Excel.rowcount(filepath, sheetname);
		for (int i = 1; i <= RC; i++) {
			String User = Excel.cellValues(filepath, sheetname, i, 0);
			System.out.println("USERNAME>>>" + User);
			String pass = Excel.cellValues(filepath, sheetname, i, 1);
			System.out.println("PASSWORD>>>" + pass);
			try {
				p1.setvalues(User, pass);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p1.clickLoginBtn();
			String currenturl = driver.getCurrentUrl();
			String expurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			if (currenturl.equalsIgnoreCase(expurl)) {
				System.out.println("Valid Credentials & Login Successful");

			} else {
				System.out.println("Invalid Credentials & Login Failed");
			}
		}

	}

}
