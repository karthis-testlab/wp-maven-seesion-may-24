package salesforce.automation.week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesforceEmailTest {
	
	@Test
	public void userShouldBeToSendEmail() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("vinothkumar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SeleniumChallenge@24");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='View All Applications']")));
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Opportunities']/span")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/th/span/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Email']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Subject...']"))).sendKeys("Subject - Test Mail Function");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='CK Editor Container']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Email Body']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@aria-label='Email Body']"))).sendKeys("Body - Test Mail Function");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Send']/parent::button"))).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "Email was sent.");
		driver.quit();
	}

}