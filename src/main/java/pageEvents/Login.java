package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	By userName = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	By Password = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	By LoginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	By LogOut = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span");
	By LogOutButton = By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void setvalues(String UN, String PWD) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(userName).clear();
		Thread.sleep(5000);
		driver.findElement(Password).clear();
		Thread.sleep(4000);
		driver.findElement(userName).sendKeys(UN);
		Thread.sleep(4000);
		driver.findElement(Password).sendKeys(PWD);
		Thread.sleep(4000);
	}

	public void clickLoginBtn() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(LoginButton).click();

	}

	public void ActualLogin(String UN, String PSWD) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(userName).sendKeys(UN);
		driver.findElement(Password).sendKeys(PSWD);

	}

}
