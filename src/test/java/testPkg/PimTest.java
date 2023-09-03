package testPkg;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pageEvents.Login;
import pageEvents.PIMaddEmpPage;

public class PimTest extends BaseClass {
	// Check whether user is able to Add employee details and save successfully
	@Test(priority = 8)
	public void PIMaddEmp() throws IOException, AWTException, InterruptedException {
		Login log1 = new Login(driver);
		log1.ActualLogin("Admin", "admin123");
		log1.clickLoginBtn();
		Thread.sleep(4000);

		PIMaddEmpPage p4 = new PIMaddEmpPage(driver);
		p4.PIMTabCleck();
		p4.AddEmp();
		Thread.sleep(5000);
		p4.createLoginclick();
		Thread.sleep(5000);

		p4.EmpIdRemove();
		p4.AddEmpId();
		p4.setvalues("Aaradhya", "Singh", "Deshayi", "AaradhyaSingh", "RFVtgb@1234", "RFVtgb@1234");
		Thread.sleep(7000);
		Thread.sleep(5000);
		p4.PhotoUpload();
		p4.ClickSave();
		Thread.sleep(8000);

		String ActaulUrl = driver.getCurrentUrl();
		System.out.println(ActaulUrl);
		// String
		// ExpUrl="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/";
		if (ActaulUrl.contains(
				"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/")) {
			System.out.println("Employee Details Succesfully Saved>>>>>>>>>Pass");
		} else {
			System.out.println("Not able to add employee details >>>>>>>>>Fail");
		}
		Thread.sleep(5000);
	}

	// Check whether user is able to save personal details
	@Test(priority = 9)
	public void PersonalDetailsAdd() throws InterruptedException, AWTException {
		PIMaddEmpPage p4 = new PIMaddEmpPage(driver);

		p4.stringvalues("Aaru", "12345", "DL4521456666", "741258", "789456123", "NA", "2045-11-11", "1997-11-11");
		Thread.sleep(7000);
		p4.GenderClick();
		p4.SaveFirstBtn();

		Thread.sleep(8000);
		p4.ScrollDown();
		Thread.sleep(8000);
		p4.AddAttachmentBtn();
		p4.CommentBox("Nil");

		p4.UploadFile();
		Thread.sleep(5000);
		p4.SaveLastBtn();
		Thread.sleep(9000);

		String DateOnForm = p4.DateAdded();
		System.out.println("Date on form is " + DateOnForm);
		LocalDate date = LocalDate.now();
		String CurrentDate = date.toString();
		System.out.println("Current Date: " + CurrentDate);
		if (DateOnForm.equalsIgnoreCase(CurrentDate)) {
			System.out.println("Data saved successfully>>>>>>>>>>>>Pass");
		} else {
			System.out.println("Data do not saved>>>>>>>Fail");
		}

	}

	// Check whether user able to search newly created employee , by employee name
	@Test(priority = 10)
	public void SearchNewEmployee() throws InterruptedException {
		PIMaddEmpPage p4 = new PIMaddEmpPage(driver);
		p4.EmployeeListClick();
		Thread.sleep(8000);
		p4.ScrollDwn();

		Thread.sleep(8000);
		List<WebElement> allData = driver
				.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]"));
		Thread.sleep(8000);
		p4.TableContents();

		for (WebElement element : allData) {
			String val = element.getText();
			System.out.println(val);
			if (val.contains("Aaradhya") && val.contains("Singh") && val.contains("Deshayi")
					&& val.contains("357277")) {
				// DataStatus = true;
				System.out.println("When search ,newly created Emlpoyee Record find >>>>>>Pass");
			}
			// break;
			else {
				System.out.println("Search Details not find>>>>>>>>>Fail");

			}

			// Assert.assertTrue(DataStatus, "Record Not Find");
		}
		Thread.sleep(5000);

	}

	// Check whether able to delete added employee
	@Test(priority = 11)
	public void DeleteEmployee() throws InterruptedException {
		PIMaddEmpPage p4 = new PIMaddEmpPage(driver);
		p4.CheckBoxClick();
		Thread.sleep(2000);
		p4.DeleteButtonClick();
		Thread.sleep(6000);
		p4.ConfirmDelete();
		Thread.sleep(8000);
		List<WebElement> allData = driver
				.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]"));
		Thread.sleep(8000);
		p4.TableContents();

		for (WebElement element : allData) {
			String val = element.getText();
			// System.out.println(val);
			if (val.contains("Aaradhya") && val.contains("Singh") && val.contains("Deshayi")
					&& val.contains("357277")) {
				System.out.println("Record find , Employee not deleted>>>>>>>>>Fail");

			} else {
				System.out
						.println("Searched Employee name not found , hence  record deleted successfully>>>>>>>>>Pass");

			}
		}
		Thread.sleep(8000);

	}

}
