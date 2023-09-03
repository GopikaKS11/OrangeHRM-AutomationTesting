package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	WebDriver driver;
	By AdminTab = By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
	By UserNameField = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	By SearchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	By Table = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void AdminTabClick() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(AdminTab).click();
		Thread.sleep(7000);

	}

	public void SearchByUserName(String username) {
		driver.findElement(UserNameField).sendKeys(username);
	}

	public String UserNameOnPage() {
		String UserName = driver.getPageSource();
		return UserName;
	}

	public void SearchBtn() {

		driver.findElement(SearchButton).click();

	}

	public void Table() {
		List<WebElement> allData = driver.findElements(Table);
	}

}
