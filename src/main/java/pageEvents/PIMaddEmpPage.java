package pageEvents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMaddEmpPage {
	WebDriver driver;
	By PIMTab = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span");
	By AddEmp = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By FirstName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input");
	By MiddName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input");
	By LastName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input");
	By EmpId = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
	By PhotoUpload = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button");
	By CreateLoginButton = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span");
	By UserName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
	By Password = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
	By ConfirmPassword = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
	By SaveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");

	By NickName = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input");

	By OtherId = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input");
	By DLicence = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
	By ExpiryDate = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input");
	By SSNnumber = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input");
	By SINnumber = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input");
	By Nationality = By.xpath(
			"/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]");
	By India = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div");
	By MaritalStatus = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]");
	By DateOfBirt = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input");
	By Gender = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label");
	By MilitaryService = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input");
	By SavePersonalButton = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button");
	By BloodType = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[1]");
	By SaveCustomDetailsButton = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button");
	By AddBTN = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/button");
	By BrowseButton = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[1]/div/div/div/div[2]/div/div[1]");
	By Comment = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[2]/div/div/div/div[2]/textarea");
	By SaveButtonLast = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");

	By EmployeeListTabe = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a");
	By EmpNameField = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");

	By Search = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	By TableContent = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div");
	By CheckBox = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span/i");
	By DeleteButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button");
	By WindowText = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/p");
	By ConfirmDelete = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
	By BodyContent = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form");
	By DateAddedField = By
			.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div/div/div[6]");

	public PIMaddEmpPage(WebDriver driver) {
		this.driver = driver;
	}

	public void PIMTabCleck() throws InterruptedException {
		driver.findElement(PIMTab).click();
		Thread.sleep(3000);
	}

	public void AddEmp() {
		driver.findElement(AddEmp).click();
	}

	public void createLoginclick() {
		driver.findElement(CreateLoginButton).click();
	}

	public void setvalues(String FName, String MidName, String LName, String UName, String PWD, String CPWD) {

		driver.findElement(FirstName).sendKeys(FName);
		driver.findElement(MiddName).sendKeys(MidName);
		driver.findElement(LastName).sendKeys(LName);
		driver.findElement(UserName).sendKeys(UName);
		driver.findElement(Password).sendKeys(PWD);
		driver.findElement(ConfirmPassword).sendKeys(CPWD);
	}

	public void EmpIdRemove() throws InterruptedException {
		WebElement IDField = driver.findElement(EmpId);
		IDField.click();
		IDField.sendKeys(Keys.CONTROL, "a");
		Thread.sleep(5000);
		IDField.sendKeys(Keys.DELETE);
		Thread.sleep(5000);

	}

	public void AddEmpId() {
		driver.findElement(EmpId).sendKeys("357277");
	}

	public void PhotoUpload() throws IOException, AWTException {
		driver.findElement(PhotoUpload).click();

		Robot rb = new Robot();
		rb.delay(3000);
		StringSelection ss = new StringSelection("B:\\Software testing\\AutomationProject\\Photo.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);

	}

	public void ClickSave() {
		driver.findElement(SaveButton).click();
	}

	public void AddAttachmentBtn() {
		driver.findElement(AddBTN).click();
	}

	public void stringvalues(String Nick, String OtherID, String DLNo, String SSN, String SIN, String MService,
			String ExpDate, String DOB) {
		driver.findElement(NickName).sendKeys(Nick);
		driver.findElement(OtherId).sendKeys(OtherID);
		driver.findElement(DLicence).sendKeys(DLNo);
		driver.findElement(SSNnumber).sendKeys(SSN);
		driver.findElement(SINnumber).sendKeys(SIN);
		driver.findElement(MilitaryService).sendKeys(MService);
		driver.findElement(ExpiryDate).sendKeys(ExpDate);
		driver.findElement(DateOfBirt).sendKeys(DOB);

	}

	public void GenderClick() {
		driver.findElement(Gender).click();
	}

	public void SaveFirstBtn() {
		driver.findElement(SavePersonalButton).click();
	}

	public void SaveSecondBtn() {
		driver.findElement(SaveCustomDetailsButton).click();
	}

	public void SaveLastBtn() {
		driver.findElement(SaveButtonLast).click();
	}

	public void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(AddBTN);
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void UploadFile() throws AWTException {
		driver.findElement(BrowseButton).click();
		Robot rb1 = new Robot();
		rb1.delay(3000);
		StringSelection ss = new StringSelection("B:\\Software testing\\AutomationProject\\file.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb1.keyPress(KeyEvent.VK_CONTROL);
		rb1.keyPress(KeyEvent.VK_V);
		rb1.delay(2000);
		rb1.keyRelease(KeyEvent.VK_CONTROL);
		rb1.keyRelease(KeyEvent.VK_V);
		rb1.delay(2000);

		rb1.keyPress(KeyEvent.VK_ENTER);
		rb1.delay(2000);
		rb1.keyRelease(KeyEvent.VK_ENTER);
		rb1.delay(2000);
	}

	public void CommentBox(String comm) {
		driver.findElement(Comment).sendKeys(comm);
	}

	public void EmployeeListClick() throws InterruptedException {
		driver.findElement(EmployeeListTabe).click();
		Thread.sleep(6000);
		WebElement empName = driver.findElement(EmpNameField);
		empName.sendKeys("Aaradhya Singh Deshayi");
		Thread.sleep(6000);

		driver.findElement(Search).click();
		Thread.sleep(7000);
	}

	public void TableContents() {
		List<WebElement> allData = driver.findElements(TableContent);
	}

	public void CheckBoxClick() {
		driver.findElement(CheckBox).click();
	}

	public void DeleteButtonClick() {
		driver.findElement(DeleteButton).click();
	}

	public void ConfirmDelete() throws InterruptedException {
		// System.out.println(driver.findElement(WindowText));
		Thread.sleep(4000);
		driver.findElement(ConfirmDelete).click();
		Thread.sleep(4000);

		driver.navigate().refresh();
	}

	public void ScrollDwn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	public String DateAdded() throws InterruptedException {
		Thread.sleep(5000);
		WebElement Date = driver.findElement(DateAddedField);
		String date = Date.getText();
		return date;

	}

}
