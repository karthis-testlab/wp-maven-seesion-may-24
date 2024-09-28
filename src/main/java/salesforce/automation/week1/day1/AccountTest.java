package salesforce.automation.week1.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest {
	
	//@Test
	public void userShouldAbleToCreateAccount() {
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
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Accounts']/span")));
		driver.findElement(By.linkText("New")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("WP Salesforce");
		driver.findElement(By.xpath("//button[text()='Save' and @name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "Account \"WP Salesforce\" was created.");
		driver.quit();
	}
	
	
	   @Test
		public void userShouldAbleToEditAccount() throws InterruptedException {			
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
			driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Accounts']/span")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Account-search-input']")));
			driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("WP Salesforce", Keys.ENTER);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceListViewManagerPrimaryDisplayManager']//div[@role='status' and contains(@class, 'slds-spinner')]")));
			driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/span/div/a")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Rating']/following-sibling::div/lightning-base-combobox"))).click();
			driver.findElement(By.xpath("//span[@title='Cold']")).click();
			driver.findElement(By.xpath("//button[text()='Save' and @name='SaveEdit']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")));
			Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "Account \"WP Salesforce\" was saved.");
			driver.quit();
			
		}

}