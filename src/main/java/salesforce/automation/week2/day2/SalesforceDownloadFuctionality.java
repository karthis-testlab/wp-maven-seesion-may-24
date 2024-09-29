package salesforce.automation.week2.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SalesforceDownloadFuctionality {
	
	@Test
	public void valdiatedSalesForceDownloadAction() throws InterruptedException {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='carousel']/div[@role='tabpanel']")));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='carousel']/div[@role='tabpanel']"));		
		for (int i = 1; i <= elements.size(); i++) {
			List<WebElement> titles = driver.findElements(By.xpath("//div[@class='carousel']/div[@role='tabpanel']["+i+"]/child::article//h2/span"));
			int j = 1;
			for (WebElement title : titles) {
				Thread.sleep(1000);				
				if((title.getText().equals("View Release Notes"))) {
					driver.findElement(By.xpath("(//div[@class='carousel']/div[@role='tabpanel']["+i+"]//child::article//div[@class='tileNavButton']/button)["+j+"]")).click();
					break;
				}
				j++;
			}
			driver.findElement(By.xpath("//div[@class='uiBlock onesetupHelpBanner']/div[@class='bRight']//button")).click();
		}
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Open PDF']"))).click();
		tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		System.out.println(driver.getCurrentUrl());
	}	

}