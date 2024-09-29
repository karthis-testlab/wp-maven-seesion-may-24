package salesforce.automation.week2.day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaleforceUploadFuctionalitiyTest {
	
	@Test
	public void valdiateTheUploadAction() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("suganya@ssf.com");
		driver.findElement(By.id("password")).sendKeys("SFQA@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='View All Applications']")));
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Opportunities']/span")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/th/span/a")));
		driver.findElement(By.xpath("//table/tbody/tr[1]/th/span/a")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload Files']")));
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\data\\test-file.doc");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-primitive-icon[@variant='success']")));
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "1 file was added to the Opportunity.");
		driver.quit();
	}
	
	public void uploadFileUsingRobotClass(String filePath) {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(1000);
			StringSelection file_to_upload = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file_to_upload, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {			
			e.printStackTrace();
		}
	}

}