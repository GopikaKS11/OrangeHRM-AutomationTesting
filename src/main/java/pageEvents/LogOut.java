package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {

	WebDriver driver;
	By Logout = By.xpath("/html/body/div/div/div/header/div/div[2]/ul/li/span/i");
	By LogOutClick = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a");

	public LogOut(WebDriver driver) {
		this.driver = driver;
	}

	public void Logout() throws InterruptedException {
		driver.findElement(Logout).click();
		Thread.sleep(8000);
		driver.findElement(LogOutClick).click();
		Thread.sleep(3000);
	}

}
