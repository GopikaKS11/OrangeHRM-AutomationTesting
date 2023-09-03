package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
	WebDriver driver;
	By logo = By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/img");
	By LogoName = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]");
	By Links = By.tagName("a");

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean LogoCheck() {
		boolean Logo = driver.findElement(logo).isDisplayed();
		return (Logo);
	}

	public boolean LogoNameCheck() {
		boolean LogoN = driver.findElement(LogoName).isDisplayed();
		return (LogoN);
	}

	public String PageTitle() {
		String PageName = driver.getTitle();
		return (PageName);

	}

	public String PageTexts() {
		String TextsOnPage = driver.getPageSource();
		return TextsOnPage;
	}

	public List<WebElement> Links() {
		return driver.findElements(Links);
	}

}
