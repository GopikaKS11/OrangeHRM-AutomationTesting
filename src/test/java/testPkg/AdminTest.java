package testPkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.AdminPage;
import pageEvents.Login;

public class AdminTest extends BaseClass {
	// Check by user name >>Locate AdminTab on homepage-->Click on it--> Locate
	// username field-->enter username -->search
	@Test(priority = 7)
	public void AdminUsersearch() throws InterruptedException {
		Thread.sleep(6000);
		Login log = new Login(driver);
		log.ActualLogin("Admin", "admin123");
		log.clickLoginBtn();
		Thread.sleep(4000);

		AdminPage p3 = new AdminPage(driver);
		Thread.sleep(7000);
		p3.AdminTabClick();
		p3.SearchByUserName("Admin");
		Thread.sleep(5000);
		p3.SearchBtn();
		Thread.sleep(5000);

		List<WebElement> allData = driver
				.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]"));
		Thread.sleep(6000);

		p3.Table();
		boolean DataStatus = false;

		for (WebElement element : allData) {
			String val = element.getText();
			System.out.println(val);
			if (val.contains("Admin")) {
				DataStatus = true;
				System.out.println("Record find , Hence able to search by username >>>>>>Pass");
				break;

			}

			Assert.assertTrue(DataStatus, "Record Not Find >>>Fail");
		}
		Thread.sleep(5000);

	}

}
