package salesforce.automation.week1.day1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpportunityTest {
	
	@Test
	public void userShouldAbleToCreateOpportuniy() {
		
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
		driver.findElement(By.linkText("New")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Opportunity Name']/following-sibling::div/input")));
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div/input")).sendKeys("Salesforce Automation By Kartihkeyan");
		driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div/input")).sendKeys(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div/lightning-base-combobox")).click();
		driver.findElement(By.xpath("//span[@title='Qualification']")).click();
		driver.findElement(By.xpath("//button[text()='Save' and @name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "Opportunity \"Salesforce Automation By Kartihkeyan\" was created.");
		driver.quit();
		
	}
	
	@Test
	public void userShouldAbleToEditOpportuniy() throws InterruptedException {
		
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Opportunity-search-input']")));
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation By Kartihkeyan", Keys.ENTER);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-aura-class='forceListViewManagerPrimaryDisplayManager']//div[@role='status' and contains(@class, 'slds-spinner')]")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table/tbody/tr[1]/td[8]/span/div/a")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Stage']/following-sibling::div/lightning-base-combobox"))).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save' and @name='SaveEdit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[starts-with(@id, 'toastDescription')]/span")).getText(), "Opportunity \"Salesforce Automation By Kartihkeyan\" was saved.");
		driver.quit();
		
	}

}
