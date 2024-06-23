package wp.week07.session2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshotForFailedTest {
	
	ChromeDriver driver;

	@Test
	public void testInvetoryReDirection() {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input#login-button")).click();
		boolean actual = driver.getCurrentUrl().contains("/inventory.html");
		Assert.assertTrue(actual);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(!result.isSuccess()) {
			File srcFile = driver.getScreenshotAs(OutputType.FILE);
			File DestinationFile = new File("./images/failed.png");
			FileUtils.copyFile(srcFile, DestinationFile);
		}
		driver.quit();
	}

}
