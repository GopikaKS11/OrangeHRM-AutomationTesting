package testPkg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.IndexPage;

public class IndexTest {
	public class Testclass extends BaseClass {

		// Check whether logo present or not on Index Page

		@Test(priority = 1)
		public void LogoCheckOnIndexPage() throws InterruptedException {
			Thread.sleep(8000);
			IndexPage p2 = new IndexPage(driver);
			boolean LOGO = p2.LogoCheck();
			if (LOGO) {
				System.out.println("Logo Present");
			} else {
				System.out.println("No Logo is Displayed");
			}
		}
		// Check whether logo and name present on index page

		@Test(priority = 2)
		public void LogoAndNameOnIndexPage() throws InterruptedException {
			Thread.sleep(7000);
			IndexPage p2 = new IndexPage(driver);
			p2.LogoCheck();
			boolean LN = p2.LogoCheck();
			if (LN) {
				System.out.println("Logo & Name image is present");
			} else {
				System.out.println("Logo & Name image is not present");
			}
		}

		// Check whether title present

		@Test(priority = 3)
		public void PageTitleCheck() {
			IndexPage p2 = new IndexPage(driver);
			String ActualTitle = p2.PageTitle();
			String ExpTitle = "OrangeHRM";
			Assert.assertEquals(ActualTitle, ExpTitle);
			System.out.println("Actual Title on  page is " + ActualTitle);
			System.out.println("Expected title is " + ExpTitle);
			if (ExpTitle.equals(ActualTitle)) {
				System.out.println("Title check passed >>> user is on Index page");
			} else {
				System.out.println("Title check failed");
			}

		}

		// Check texts on Index page

		@Test(priority = 4)
		public void PageTextsCheck() {
			IndexPage p2 = new IndexPage(driver);
			String TextsOnPage = p2.PageTexts();
			if (TextsOnPage.contains("All rights reserved")) {
				System.out.println("Text on Indexpage verified >>> Currently user on Index page");
			} else {
				System.out.println("Text check on Index Page  failed");
			}
		}

		// Check links on Index page
		@Test(priority = 5)
		public void LinksOnIndexPage() throws IOException {
			IndexPage p2 = new IndexPage(driver);
			List<WebElement> links = p2.Links();
			System.out.println("Number of links = " + links.size());
			int brokenlinks = 0;
			for (WebElement element : links) {
				String url = element.getAttribute("href");
				if (url == null || url.isEmpty()) {
					System.out.println("URL is Empty");
					continue;
				}
				URL link = new URL(url);
				try {
					HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
					httpconn.connect();
					if (httpconn.getResponseCode() >= 400) {
						System.out.println(httpconn.getResponseCode() + "  " + url + " is " + " broken link ");
						brokenlinks++;
					} else {
						System.out.println(httpconn.getResponseCode() + " " + url + " is " + "  valid link ");
					}
				} catch (Exception e) {

				}
			}
			System.out.println("Number of broken links = " + brokenlinks);
		}

	}
}
